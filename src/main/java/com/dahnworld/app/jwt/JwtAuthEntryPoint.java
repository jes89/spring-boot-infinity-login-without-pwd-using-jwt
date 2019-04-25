package com.dahnworld.app.jwt;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import com.dahnworld.app.response.JwtResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
 
@Component
public class JwtAuthEntryPoint implements AuthenticationEntryPoint {

    private static final Logger logger = LoggerFactory.getLogger(JwtAuthEntryPoint.class);
    
    @Override
    public void commence(HttpServletRequest request,
                         HttpServletResponse response,
                         AuthenticationException e) 
                        		 throws IOException, ServletException {
    	
        response.setContentType("application/json");
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        
        JwtResponse jwtResponse = new JwtResponse(null , e.getMessage());
    	
        HashMap<String, String> payload = new HashMap<>();
		
		payload.put("result", e.getMessage());
		
		jwtResponse.setPayload(payload);
        
        response.setStatus(HttpStatus.OK.value());
        String json = new ObjectMapper().writeValueAsString(jwtResponse);
        response.getWriter().write(json);
        response.flushBuffer();

    }
}