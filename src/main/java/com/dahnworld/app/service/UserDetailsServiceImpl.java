package com.dahnworld.app.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.dahnworld.app.dao.UserDao;
import com.dahnworld.app.dto.UserDto;
import com.dahnworld.app.dto.UserPrinciple;
 
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
 
    @Autowired
    UserDao userDao;
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    	
		UserDto user = userDao.getUserByUserId(username);
    	
		if (user == null) {
			throw new UsernameNotFoundException(username);
		}
		
        return UserPrinciple.build(user);
        
    }
}