package com.dahnworld.app.controller.api;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dahnworld.app.dto.UserDto;
import com.dahnworld.app.jwt.JwtProvider;
import com.dahnworld.app.response.JwtResponse;
import com.dahnworld.app.service.UserService;

@RestController
public class testController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private JwtProvider jwtProvider;
	
	@RequestMapping("/test")
	protected ResponseEntity<?> test(@RequestAttribute JwtResponse jwtResponse) {
		
		String accessToken = jwtResponse.getToken();
		
		if(accessToken == null) {
			return ResponseEntity.ok(jwtResponse);
		}
		
		String userId = jwtProvider.getUserNameFromJwtToken(accessToken);
		UserDto userDto = userService.getUserByUserId(userId);
		
		HashMap<String, UserDto> payload = new HashMap<>();
		
		payload.put("user", userDto);
		
		jwtResponse.setPayload(payload);
		
		return ResponseEntity.ok(jwtResponse);
	}
}
