package com.dahnworld.app.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.dahnworld.app.dto.UserDto;

@Mapper
public interface UserMapper {
	
	int insertTokenLog(UserDto userDto);
	
	int updateUserAccessInfo(UserDto userDto);
	int updateTokenLog(UserDto userDto);
	
	String getUserFromTokenLog(UserDto userDto);
	
	UserDto getUserByUserId(String userId);
	UserDto getUserByAccessToken(String accessToken);
	
	List<UserDto> getUserByUserList();
	List<String> getUserRoles(String userId);
	
	
	
}
