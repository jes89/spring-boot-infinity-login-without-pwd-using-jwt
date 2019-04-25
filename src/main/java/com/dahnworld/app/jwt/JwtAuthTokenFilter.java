package com.dahnworld.app.jwt;

import java.io.IOException;
import java.util.Date;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import com.dahnworld.app.dto.UserDto;
import com.dahnworld.app.response.JwtResponse;
import com.dahnworld.app.service.UserService;

public class JwtAuthTokenFilter extends OncePerRequestFilter {

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
		
		if(reqUri.equals("/api/auth/loginByUserInfo")) {
			filterChain.doFilter(req, res);
			return;
		}
		
		try {

			String accessToken = jwtProvider.getJwt(req);
			String mac = jwtProvider.getMacJwt(req);
			
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
		
		UserDto selectedUserDto = this.getUserByAccessToken(accessToken, mac);
		String userId = selectedUserDto.getUserId();
		
		if (userId == null || userId.length() == 0) {
			return new JwtResponse(null, "invaild token or mac information");
		}
		
		UsernamePasswordAuthenticationToken authentication = this.saveUserAuthentication(userId, req);
		
		JwtResponse jwtResponse = new JwtResponse(jwtProvider.generateJwtToken(authentication), "new token issued", selectedUserDto.getName());
		
		if (this.updateUserToken(userId, jwtResponse.getToken() , mac) == 0) {
			jwtResponse.setMsg("update token error");
		}
		
		return jwtResponse;
	}
	
	private JwtResponse extendTokenLifeSpan(String accessToken, HttpServletRequest req) {
		String userId = jwtProvider.getUserNameFromJwtToken(accessToken);
		UserDto selectedUserDto = userService.getUserByUserId(userId); 
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
	
	private int updateUserToken(String userId, String token, String mac) {
		UserDto userDto = new UserDto();
		userDto.setUserId(userId);
		userDto.setMac(mac);
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