package com.dahnworld.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dahnworld.app.dao.UserDao;
import com.dahnworld.app.dto.UserDto;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserDao userDao;
	
	@Override
	public int insertUser(UserDto userDto) {
		return userDao.insertUser(userDto);
	}
	
	@Override
	public int updateUserAccessInfo(UserDto userDto, String accessToken) {
		userDto.setAccessToken(accessToken);
		return userDao.updateUserAccessInfo(userDto);
	}

	@Override
	public int updateUserInfo(UserDto userDto) {
		return userDao.updateUserInfo(userDto);
	}
	
	@Override
	public UserDto getUserByUserId(String userId) {
		return userDao.getUserByUserId(userId);
	}

	@Override
	public List<String> getUserRoles(String userId) {
		return userDao.getUserRoles(userId);
	}

	@Override
	public UserDto getUserByAccessToken(String accessToken) {
		return userDao.getUserByAccessToken(accessToken);
	}

}
