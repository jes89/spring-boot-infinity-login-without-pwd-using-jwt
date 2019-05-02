package com.dahnworld.app.jwt;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import com.dahnworld.app.controller.UserController;
import com.dahnworld.app.dto.UserDto;
import com.dahnworld.app.response.JwtResponse;
import com.dahnworld.app.service.UserService;

public class JwtAuthTokenFilter extends OncePerRequestFilter {
	
    private static final Logger logger = LoggerFactory.getLogger(JwtAuthTokenFilter.class);
    
	@Autowired
	JwtProvider jwtProvider;

	@Autowired
	UserService userService;
	
	@Autowired
	UserDetailsService userDetailsService;
	
	@Override
	protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain filterChain)
			throws ServletException, IOException {
		
		String reqUri = req.getRequestURI();
		JwtResponse jwtResponse = null;
		
		String[] ignoreList = {"/api/auth/loginByUserInfo", "/api/auth/updateTokenLog"};
		
		for(int i = 0; i < ignoreList.length; i++) {
			if(reqUri.equals(ignoreList[i])) {
				filterChain.doFilter(req, res);
				return;
			}
		}
		
		logger.info("doFilterInternal");
		
		try {

			String accessToken = jwtProvider.getJwt(req);
			String mac = jwtProvider.getMac(req);
			
			logger.info("accessToken : " + accessToken);
			logger.info("mac : " + mac);
			
			if (accessToken == null || jwtProvider.validateJwtToken(accessToken) == false) {
				jwtResponse = this.issueNewToken(accessToken, mac, req);
			} else {
				jwtResponse = this.extendTokenLifeSpan(accessToken, req);
			}
		} catch (Exception e) {
			jwtResponse = new JwtResponse(null, "doFilterInternal exception");
		}
		
		req.setAttribute("jwtResponse", jwtResponse);
		
		filterChain.doFilter(req, res);
	}
	
	private JwtResponse issueNewToken(String accessToken, String mac, HttpServletRequest req) {
		
		logger.info("issueNewToken : ");
		
		UserDto selectedUserDto = this.getUserByAccessToken(accessToken, mac);
		String userId = selectedUserDto.getUserId();
		
		logger.info("selectedUserDto : " + selectedUserDto.toString());
		logger.info("userId : " + userId);
		
		if (userId == null || userId.length() == 0) {
			return new JwtResponse(null, "invaild token or mac information");
		}
		
		UsernamePasswordAuthenticationToken authentication = this.saveUserAuthentication(userId, req);
		
		JwtResponse jwtResponse = new JwtResponse(jwtProvider.generateJwtToken(authentication), "new token issued", selectedUserDto.getName());
		
		logger.info("jwtResponse.getToken() : " + jwtResponse.getToken());
		logger.info("mac : " + mac);
		
		if (this.updateUserToken(userId, jwtResponse.getToken() , mac, jwtResponse.getExpiryTime()) == 0) {
			jwtResponse.setMsg("update token error");
		}
		
		return jwtResponse;
	}
	
	private JwtResponse extendTokenLifeSpan(String accessToken, HttpServletRequest req) {
		String userId = jwtProvider.getUserNameFromJwtToken(accessToken);
		UserDto selectedUserDto = userService.getUserByUserId(userId); 
		
		logger.info("extendTokenLifeSpan : ");
		logger.info("selectedUserDto : " + selectedUserDto.toString());
		
		this.saveUserAuthentication(userId, req);
		
		return new JwtResponse(accessToken, "extended token life span", selectedUserDto.getName());
	}
	
	private UsernamePasswordAuthenticationToken saveUserAuthentication(String userId, HttpServletRequest req) {
		UserDetails userDetails = userDetailsService.loadUserByUsername(userId);
		UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
		authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(req));
		SecurityContextHolder.getContext().setAuthentication(authentication);
		return authentication;
	}
	
	private int updateUserToken(String userId, String token, String mac, long expiryTime) {
		UserDto userDto = new UserDto();
		
		userDto.setUserId(userId);
		userDto.setMac(mac);
		userDto.setExpiryTime(expiryTime);
		
		return userService.updateUserAccessInfo(userDto, token);
	}

	private UserDto getUserByAccessToken(String accessToken, String userMac) {

		UserDto selectedUser = userService.getUserByAccessToken(accessToken);

		boolean isVaild = this.checkVaildUser(userMac, selectedUser);

		if (isVaild == false) {
			return new UserDto();
		}

		return selectedUser;
	}

	private boolean checkVaildUser(String userMac, UserDto selectedUser) {

		if (selectedUser == null || selectedUser.getMac() == null) {
			return false;
		}

		if (userMac == null) {
			return false;
		}

		String selectedUserMac = selectedUser.getMac();

		return userMac.equals(selectedUserMac);
	}
	

}