package com.dahnworld.app.dto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;



public class UserPrinciple extends User {
	
	private static final long serialVersionUID = 3110678695214207737L;
	
	private String userNm;
	
	public UserPrinciple(String username, String userNm, String password, Collection<? extends GrantedAuthority> authorities) {
		super(username, password, authorities);
		this.userNm = userNm;
	}
	
	public String getUserNm() {
		return userNm;
	}
	
	public void setUserNm(String userNm) {
		this.userNm = userNm;
	}
	
    public static UserPrinciple build(UserDto user) {
        
	    //TODO
	    //권한체크 만들기
//    	List<GrantedAuthority> authorities = user.getRoles().stream().map(role ->
//                new SimpleGrantedAuthority("ROLE_ADMIN")
//                new SimpleGrantedAuthority(role)
//        ).collect(Collectors.toList());
        
	    List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
	    
		
	    authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        
        return new UserPrinciple(
                user.getUserId(),
                user.getName(),
                user.getPwd(),
                authorities
        );
    }
}