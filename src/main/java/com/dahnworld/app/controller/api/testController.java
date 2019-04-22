package com.dahnworld.app.controller.api;

import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class testController {
	
	
	@RequestMapping("/test")
	protected String test(@RequestAttribute String newAccessToken) {
		
		System.out.println(newAccessToken);
		
		return "";
	}
}
