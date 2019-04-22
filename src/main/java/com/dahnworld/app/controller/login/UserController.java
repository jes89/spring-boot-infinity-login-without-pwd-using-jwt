package com.dahnworld.app.controller.login;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dahnworld.app.dto.UserDto;
import com.dahnworld.app.jwt.JwtProvider;
import com.dahnworld.app.response.JwtResponse;
import com.dahnworld.app.service.UserDetailsServiceImpl;
import com.dahnworld.app.service.UserService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
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
	
    @Value("${grokonez.app.jwtExpiration}")
    private long jwtExpiration;
	
	@PostMapping("/loginByUserInfo")
	protected ResponseEntity<?> login(@RequestBody UserDto userDto) {
		
		String jwt = this.getJwtByUserInfo(userDto);
		
		JwtResponse jwtResponse = new JwtResponse(jwt, this.getExpiryTime() ,"success", "updateToken");
		
		int updateed = userService.updateUserAccessInfo( userDto, jwtResponse.getToken() );
		
		if( updateed == 0) {
            return new ResponseEntity<String>("updating information of access is failed", HttpStatus.NOT_MODIFIED);
		}
		
        return ResponseEntity.ok(jwtResponse);
	}
	
//	@PutMapping("/refreshAccessToken")
//	public ResponseEntity<?> refreshToken(@RequestBody UserDto userDto, HttpServletRequest req) {
//		
//		ResponseEntity<?> responseEntity = null;
//		JwtResponse jwtResponse = null;
//		
//        try {
//        	
//        	String jwt = jwtProvider.getJwt(req);
//        	
//        	String userId = this.getUserIdByJwt(jwt, userDto.getAccessToken(), userDto.getMac());
//        
//        	if(userId == null || userId.length() == 0) {
//        		responseEntity = new ResponseEntity<String>("invalid token ", HttpStatus.PRECONDITION_FAILED);
//        		logger.error("unvaild token");
//        	}
//        	
//        	UserDetails userDetails = userDetailsService.loadUserByUsername(userId);
//            
//            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
//            
//            authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(req));
//            
//            jwt = jwtProvider.generateJwtToken(authentication);
//            
//            jwtResponse = new JwtResponse(jwt, this.getExpiryTime() ,"success", "updateToken");
//            
//            userDto.setUserId(userDetails.getUsername());
//            userDto.setAccessToken(jwtResponse.getToken());
//            
//            responseEntity = ResponseEntity.ok(jwtResponse);
//            
//            SecurityContextHolder.getContext().setAuthentication(authentication);
//            
//        } catch (Exception e) {
//            responseEntity = new ResponseEntity<String>("refresh token failed", HttpStatus.PRECONDITION_FAILED);
//            logger.error("refreshToken  -> Message: " + e.getMessage());
//        }
//        
//        int updateed = userService.updateUserAccessInfo(userDto, jwtResponse.getToken());
//		
//		if( updateed == 0) {
//            return new ResponseEntity<String>("updating information of access is failed", HttpStatus.NOT_MODIFIED);
//		}
//        
//		return responseEntity;
//	}

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
	
	private long getExpiryTime() {
		Date date = new Date();
		return (date.getTime() + this.jwtExpiration);
	}

}
