package com.dahnworld.app.jwt;

import java.io.IOException;
import java.util.Date;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import com.dahnworld.app.dto.UserDto;
import com.dahnworld.app.response.JwtResponse;
import com.dahnworld.app.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JwtAuthTokenFilter extends OncePerRequestFilter {

	@Autowired
	JwtProvider jwtProvider;

	@Autowired
	UserService userService;
	
	@Autowired
	UserDetailsService userDetailsService;
	
	@Value("${grokonez.app.jwtExpiration}")
	private long jwtExpiration;

	@Override
	protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain filterChain)
			throws ServletException, IOException {
		
		String reqUri = req.getRequestURI();

		if(reqUri.equals("/api/auth/loginByUserInfo")) {
			filterChain.doFilter(req, res);
			return;
		}
		
		try {
			
			String accessToken = jwtProvider.getJwt(req);
			String mac = jwtProvider.getMacJwt(req);
			
			String userId = this.getUserIdByJwt(accessToken, mac);
			
			if (userId == null || userId.length() == 0) {
				this.setResponseEntity(null, "invaild token and mac information", null, req, res, filterChain);
				return;
			}
			
			UsernamePasswordAuthenticationToken authentication = this.saveUserAuthentication(userId, req);
			
			JwtResponse jwtResponse = new JwtResponse(jwtProvider.generateJwtToken(authentication), this.getExpiryTime() , null, null);
			
			if (this.updateUserToken(userId, jwtResponse.getToken() , mac) == 0) {
				this.setResponseEntity(null, "update token error", null, req, res, filterChain);
				return;
			}
				
			this.setResponseEntity(jwtResponse, req, res, filterChain);
			return;
			
		} catch (Exception e) {
			logger.error("jwt doFilterInternal error: " + e.getMessage());
			this.setResponseEntity(null, "get new token error", null, req, res, filterChain);
		}
	}
	
	private UsernamePasswordAuthenticationToken saveUserAuthentication(String userId, HttpServletRequest req) {
		
		UserDetails userDetails = userDetailsService.loadUserByUsername(userId);
		
		UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails,
				null, userDetails.getAuthorities()
		);
		
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

	private String getUserIdByJwt(String accessToken, String mac) {
		String userId = null;

		if (accessToken != null && jwtProvider.validateJwtToken(accessToken)) {
			userId = jwtProvider.getUserNameFromJwtToken(accessToken);
		} else {
			UserDto selectedUserDto = this.getUserByAccessToken(accessToken, mac);
			userId = selectedUserDto.getUserId();
		}

		return userId;
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
	
	private void setResponseEntity(JwtResponse jwtResponse, HttpServletRequest req, HttpServletResponse res, FilterChain filterChain) throws IOException, ServletException{
		req.setAttribute("jwtResponse", jwtResponse);
		filterChain.doFilter(req, res);
	}
	
	private void setResponseEntity(String jwt, String msg, String callbackNm, HttpServletRequest req, HttpServletResponse res, FilterChain filterChain) throws IOException, ServletException{
		JwtResponse jwtResponse = new JwtResponse(jwt, this.getExpiryTime() , msg, callbackNm);
		req.setAttribute("jwtResponse", jwtResponse);
		filterChain.doFilter(req, res);
	}

	private long getExpiryTime() {
		Date date = new Date();
		return (date.getTime() + this.jwtExpiration);
	}

}