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
	public int updateUserAccessInfo(UserDto userDto, String accessToken) {
		
		userDto.setAccessToken(accessToken);
		
		if(userDao.insertTokenLog(userDto) == 0) {
			return 0;
		}

		return userDao.updateUserAccessInfo(userDto);
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

	@Override
	public List<UserDto> getUserByUserList() {
		return userDao.getUserByUserList();
	}

	@Override
	public int updateTokenLog(UserDto userDto) {
		return userDao.updateTokenLog(userDto);
	}

	@Override
	public String getUserFromTokenLog(String accessToken, String mac, long expiryTime) {
		
		UserDto userDto = new UserDto();
		
		userDto.setAccessToken(accessToken);
		userDto.setMac(mac);
		userDto.setExpiryTime(expiryTime);
		
		return userDao.getUserFromTokenLog(userDto);
	}

}
