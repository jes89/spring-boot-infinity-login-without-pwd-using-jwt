package com.dahnworld.app.dao;


import java.util.List;

import com.dahnworld.app.dto.UserDto;
 
public interface UserDao  {
	
	int insertUser(UserDto userDto);
	
	int updateUserAccessInfo(UserDto userDto);
	int updateUserInfo(UserDto userDto);
	
    UserDto getUserByUserId(String userId);
    UserDto getUserByAccessToken(String accessToken);
    
    List<UserDto> getUserByUserList();
    List<String> getUserRoles(String userId);
    
    
}