package com.dahnworld.app.jwt;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import com.dahnworld.app.dto.UserPrinciple;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
 
@Component
public class JwtProvider {
 
    private static final Logger logger = LoggerFactory.getLogger(JwtProvider.class);
 
    @Value("${grokonez.app.jwtSecret}")
    private String jwtSecret;
 
    @Value("${grokonez.app.jwtExpiration}")
    private int jwtExpiration;
 
    public String generateJwtToken(Authentication authentication) {
 
        UserPrinciple userPrincipal = (UserPrinciple) authentication.getPrincipal();
       
        return Jwts.builder()
		                .setSubject((userPrincipal.getUsername()))
		                .setIssuedAt(new Date())
		                .setExpiration(new Date((new Date()).getTime() + jwtExpiration))
		                .signWith(SignatureAlgorithm.HS512, jwtSecret)
		                .compact();
    }
 
    public String getUserNameFromJwtToken(String token) {
        return Jwts.parser()
			                .setSigningKey(jwtSecret)
			                .parseClaimsJws(token)
			                .getBody().getSubject();
    }
 
    public boolean validateJwtToken(String authToken) {
        
    	try {
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken);
            return true;
        } catch (Exception e) {
        	return false;
        }
    }
    
	public String getJwt(HttpServletRequest req) {
        String authHeader = req.getHeader("Authorization");
        
        if (authHeader != null && authHeader.startsWith("Bearer ")) {
        	return authHeader.replace("Bearer ","");
        }
 
        return null;
    }
	
	public String getMacJwt(HttpServletRequest req) {
        return req.getHeader("mac");
    }
}