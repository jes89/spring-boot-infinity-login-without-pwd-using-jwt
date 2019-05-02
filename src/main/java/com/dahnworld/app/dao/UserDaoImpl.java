package com.dahnworld.app.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dahnworld.app.dto.UserDto;
import com.dahnworld.app.mapper.UserMapper;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	UserMapper userMapper;
	
	@Override
	public int insertTokenLog(UserDto userDto) {
		return userMapper.insertTokenLog(userDto);
	}
	
	@Override
	public int updateUserAccessInfo(UserDto userDto) {
		return userMapper.updateUserAccessInfo(userDto);
	}
	
	@Override
	public int updateTokenLog(UserDto userDto) {
		return userMapper.updateTokenLog(userDto);
	}
	
	@Override
	public UserDto getUserByUserId(String userId) {
		return userMapper.getUserByUserId(userId);
	}

	@Override
	public List<String> getUserRoles(String userId) {
		return userMapper.getUserRoles(userId);
	}

	@Override
	public UserDto getUserByAccessToken(String accessToken) {
		return userMapper.getUserByAccessToken(accessToken);
	}

	@Override
	public List<UserDto> getUserByUserList() {
		return userMapper.getUserByUserList();
	}

	@Override
	public String getUserFromTokenLog(UserDto userDto) {
		return userMapper.getUserFromTokenLog(userDto);
	}
	



	

}
