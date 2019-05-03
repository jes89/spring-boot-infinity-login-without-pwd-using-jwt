package com.dahnworld.app.response;

import java.util.Date;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Value;

public class JwtResponse {
	@Value("${grokonez.app.jwtExpiration}")
	private long jwtExpiration;
	
	private String token;
	private String type = "Bearer";
	private String msg;
	private String userNm;
	private int newMsg = 0;
	private long expiryTime= (new Date().getTime() + this.jwtExpiration);
	private HashMap<String, ?> payload;
	
	public JwtResponse(String accessToken, String msg) {
		this.token = accessToken;
		this.msg = msg;
	}
	
	public JwtResponse(String accessToken, String msg, String userNm) {
		this.token = accessToken;
		this.msg = msg;
		this.userNm = userNm;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	public HashMap<String, ?> getPayload() {
		return payload;
	}

	public void setPayload(HashMap<String, ?> payload) {
		this.payload = payload;
	}

	public long getExpiryTime() {
		return this.expiryTime;
	}

	public void setExpiryTime(long expiryTime) {
		this.expiryTime = expiryTime;
	}
	public void setExpiryTime() {
		this.expiryTime = (new Date().getTime() + this.jwtExpiration);
	}

	public long getJwtExpiration() {
		return jwtExpiration;
	}
	
	public void setJwtExpiration(long jwtExpiration) {
		this.jwtExpiration = jwtExpiration;
	}

	public String getUserNm() {
		return userNm;
	}

	public void setUserNm(String userNm) {
		this.userNm = userNm;
	}
	
	public int getNewMsg() {
		return newMsg;
	}

	public void setNewMsg(int newMsg) {
		this.newMsg = newMsg;
	}
	
}