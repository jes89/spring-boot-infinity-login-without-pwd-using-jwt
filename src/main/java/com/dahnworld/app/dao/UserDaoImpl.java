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
	public int insertUser(UserDto userDto) {
		return userMapper.insertUser(userDto);
	}
	
	@Override
	public int updateUserAccessInfo(UserDto userDto) {
		return userMapper.updateUserAccessInfo(userDto);
	}

	@Override
	public int updateUserInfo(UserDto userDto) {
		return userMapper.updateUserInfo(userDto);
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

	

}
