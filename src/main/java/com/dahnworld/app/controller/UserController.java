package com.dahnworld.app.controller;

import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dahnworld.app.dto.UserDto;
import com.dahnworld.app.jwt.JwtProvider;
import com.dahnworld.app.response.JwtResponse;
import com.dahnworld.app.service.UserService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/user")
public class UserController {
	
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	JwtProvider jwtProvider;

	@Autowired
	UserService userService;
	
	@Autowired
	UserDetailsService userDetailsService;
	
	@PostMapping("/loginByUserInfo")
	protected ResponseEntity<?> login(@RequestBody UserDto userDto) {
		
		String jwt = this.getJwtByUserInfo(userDto);
		
		JwtResponse jwtResponse = new JwtResponse(jwt ,"new token issued");
		UserDto selectedUser = userService.getUserByUserId(userDto.getUserId());
		
		int updated = userService.updateUserAccessInfo( userDto, jwtResponse.getToken() );
		
		if( updated == 0) {
			jwtResponse.setMsg("update token error");
		}
		
		HashMap<String, String> payload = new HashMap<>();
		
		payload.put("result","success");
		
		jwtResponse.setPayload(payload);
		jwtResponse.setUserNm(selectedUser.getName());
		
		return ResponseEntity.ok(jwtResponse);
	}
	
	@GetMapping("/view")
	protected ResponseEntity<?> getUser(@RequestAttribute JwtResponse jwtResponse, @RequestParam String userId){

		UserDto user = userService.getUserByUserId(userId);
		
		HashMap<String, UserDto> payload = new HashMap<>();
		
		payload.put("user", user);
		
		jwtResponse.setPayload(payload);
		
		return ResponseEntity.ok(jwtResponse);
	}
	
	@GetMapping("/list")
	protected ResponseEntity<?> getUserList(@RequestAttribute JwtResponse jwtResponse){

		List<UserDto> userList = userService.getUserByUserList();
		
		HashMap<String, List<UserDto>> payload = new HashMap<>();
		
		payload.put("userList", userList);
		
		jwtResponse.setPayload(payload);
		
		return ResponseEntity.ok(jwtResponse);
	}
	
	private String getJwtByUserInfo(UserDto userDto) {

		String userId = userDto.getUserId();
		String pwd = userDto.getPwd();
		
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                		userId,
                		pwd
                )
        );
        
		SecurityContextHolder.getContext().setAuthentication(authentication);

		return jwtProvider.generateJwtToken(authentication);
	}
	
}
