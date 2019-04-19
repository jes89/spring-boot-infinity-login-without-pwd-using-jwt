package com.dahnworld.app.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.dahnworld.app.dto.UserDto;

@Mapper
public interface UserMapper {
	
	int insertUser(UserDto userDto);
	
	int updateUserAccessInfo(UserDto userDto);
	int updateUserInfo(UserDto userDto);
	
	UserDto getUserByUserId(String userId);
	UserDto getUserByAccessToken(String accessToken);
	
	List<String> getUserRoles(String userId);
	
}
