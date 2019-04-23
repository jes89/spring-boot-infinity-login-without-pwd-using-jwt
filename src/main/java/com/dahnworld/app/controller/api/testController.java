package com.dahnworld.app.controller.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dahnworld.app.response.JwtResponse;

@RestController
public class testController {
	
	
	@RequestMapping("/test")
	protected ResponseEntity<?> test(@RequestAttribute JwtResponse jwtResponse) {
		
		jwtResponse.setMsg("SUCCESS");
		jwtResponse.setCallbackType("그런거없다");
		
		return ResponseEntity.ok(jwtResponse);
	}
}
