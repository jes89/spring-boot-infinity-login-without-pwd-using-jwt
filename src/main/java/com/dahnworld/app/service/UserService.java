package com.dahnworld.app.service;

import java.util.List;

import com.dahnworld.app.dto.UserDto;


public interface UserService {
	
	int updateUserAccessInfo(UserDto userDto, String accessToken);
	int updateTokenLog(UserDto userDto);
	int updateDwMemberCd(String userId, String dwMemberCd);
	
	String getUserFromTokenLog(String accessToken, String mac, long expiryTime);
	
	UserDto getUserByUserId(String userId);
	UserDto getUserByAccessToken(String accessToken);
	
	List<UserDto> getUserByUserList();
	List<String> getUserRoles(String userId);
}
