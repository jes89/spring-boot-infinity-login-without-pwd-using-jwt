package com.dahnworld.app.service;

import java.util.List;

import com.dahnworld.app.dto.UserDto;


public interface UserService {
	
	int insertUser(UserDto userDto);
	
	int updateUserAccessInfo(UserDto userDto, String accessToken);
	int updateUserInfo(UserDto userDto);
	
	UserDto getUserByUserId(String userId);
    UserDto getUserByAccessToken(String accessToken);
    
    List<String> getUserRoles(String userId);
    List<UserDto> getUserByUserList();
}
