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
			ObjectMapper mapper = new ObjectMapper();
			
			UserDto userDto = mapper.readValue(req.getInputStream(),UserDto.class);
			
			String accessToke = userDto.getAccessToken();
			String mac = userDto.getMac();
			
			String jwt = jwtProvider.getJwt(req);
			
			System.out.println(jwt);
			String userId = this.getUserIdByJwt(jwt, accessToke, mac);
			
			String newAccessToken = null;
			
			if (userId == null || userId.length() == 0) {
				logger.error("refreshAccessToken  -> userId is inVaild");
			}
			
			UserDetails userDetails = userDetailsService.loadUserByUsername(userId);
			
			UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails,
					null, userDetails.getAuthorities());
			
			authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(req));
			
			jwt = jwtProvider.generateJwtToken(authentication);
			
			JwtResponse jwtResponse = new JwtResponse(jwt, this.getExpiryTime() ,"success", "updateToken");

			newAccessToken = jwtResponse.getToken();
			
			userDto.setUserId(userDetails.getUsername());
			userDto.setAccessToken(newAccessToken);
			userDto.setMac(mac);
			
			int updateed = userService.updateUserAccessInfo(userDto, newAccessToken);
			
			if (updateed == 0) {
				logger.error("refreshToken  -> updateError: ");
			}
			
			req.setAttribute("newAccessToken", newAccessToken);
			
			SecurityContextHolder.getContext().setAuthentication(authentication);
		} catch (Exception e) {
			logger.error("jwt doFilterInternal error: " + e.getMessage());
		}
		filterChain.doFilter(req, res);
	}

	private String getUserIdByJwt(String jwt, String accessToken, String mac) {
		String userId = null;

		if (jwt != null && jwtProvider.validateJwtToken(jwt)) {
			userId = jwtProvider.getUserNameFromJwtToken(jwt);
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
			return null;
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

	private long getExpiryTime() {
		Date date = new Date();
		return (date.getTime() + this.jwtExpiration);
	}

}