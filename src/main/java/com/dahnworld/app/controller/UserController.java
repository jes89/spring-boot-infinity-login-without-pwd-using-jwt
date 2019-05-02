package com.dahnworld.app.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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
		UserDto selectedUserDto = userService.getUserByUserId(userDto.getUserId());
		
		selectedUserDto.setAccessToken(jwtResponse.getToken());
		selectedUserDto.setExpiryTime(jwtResponse.getExpiryTime());
		selectedUserDto.setMac(userDto.getMac());
		
		
		int updated = userService.updateUserAccessInfo(selectedUserDto, jwtResponse.getToken());
		
		logger.info("loginByUserInfo : " + updated);
		
		if( updated == 0) {
			
			logger.info("jwtResponse.getToken() : " + jwtResponse.getToken());
			logger.info("update token error : " + selectedUserDto.toString());
			
			jwtResponse.setMsg("update token error");
		}
		
		HashMap<String, String> payload = new HashMap<>();
		
		payload.put("result","success");
		
		jwtResponse.setPayload(payload);
		jwtResponse.setUserNm(selectedUserDto.getName());
		
		return ResponseEntity.ok(jwtResponse);
	}
	
	@PostMapping("/autoLogin")
	protected ResponseEntity<?> doAutoLogin(@RequestAttribute JwtResponse jwtResponse, HttpServletRequest req) {
		
		String msg = jwtResponse.getMsg();
		
		if(msg == null || msg.length() == 0 || msg.equals("invaild token or mac information")) {
			
			long expiryTime = jwtProvider.getExpiryTime(req);
			
			String accessToken = jwtProvider.getJwt(req);
			String mac = jwtProvider.getMac(req);
			String userId = userService.getUserFromTokenLog(accessToken, mac, expiryTime);
			
			logger.info("doAutoLogin 호출 ");
			logger.info("accessToken : " + accessToken);
			logger.info("mac : " + mac);
			logger.info("expiryTime : " + expiryTime);
			logger.info("userId : " + userId);
			
			if(userId == null || userId.length() == 0) {
				return ResponseEntity.ok(jwtResponse);
			}
			
			UserDto userDto = new UserDto();
			
			UserDetails userDetails = userDetailsService.loadUserByUsername(userId);
			UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
			
			authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(req));
			SecurityContextHolder.getContext().setAuthentication(authentication);
			
			UserDto selectedUserDto = userService.getUserByUserId(userId); 
			
			jwtResponse = new JwtResponse(jwtProvider.generateJwtToken(authentication), "new token issued using log", selectedUserDto.getName());
			
			selectedUserDto.setExpiryTime(jwtResponse.getExpiryTime());
			
			userDto.setUserId(userId);
			userDto.setExpiryTime(expiryTime);
			userDto.setMac(mac);
			
			int updated = userService.updateUserAccessInfo(userDto, jwtResponse.getToken());
			
			logger.info("updated : " + updated);
			logger.info("jwtResponse.getToken() : " + jwtResponse.getToken());
			logger.info("update token error : " + selectedUserDto.toString());
			
			if( updated == 0) {
				jwtResponse.setMsg("update token error");
			} 
			
			HashMap<String, String> payload = new HashMap<>();
			
			payload.put("accessToken", accessToken);
			payload.put("mac", mac);
			payload.put("expiryTime", String.valueOf(expiryTime));
			
			jwtResponse.setPayload(payload);
		}
		
		return ResponseEntity.ok(jwtResponse);
	}
	
	@PostMapping("/updateTokenLog")
	protected String doAutoLogin(@ModelAttribute UserDto userDto) {
		if(userService.updateTokenLog(userDto) > 0) {
			return "success";
		} else {
			return "fail";
		}
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
	
	@GetMapping("/getAttendanceList")
	protected ResponseEntity<?> getAttendanceList(@RequestAttribute JwtResponse jwtResponse){
		return ResponseEntity.ok(jwtResponse);
	}
	
	@PostMapping("/updateDainNetData")
	protected ResponseEntity<?> updateDainNetData(@RequestAttribute JwtResponse jwtResponse){
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
