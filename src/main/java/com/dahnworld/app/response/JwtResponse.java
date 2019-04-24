package com.dahnworld.app.response;

import java.util.HashMap;

public class JwtResponse {

	private String token;
	private String type = "Bearer";
	private String msg;
	private String callbackType;
	private long expiryTime;
	private HashMap<String, ?> payload;
	
	public JwtResponse(String accessToken, String msg) {
		this.token = accessToken;
		this.msg = msg;
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

	public String getCallbackType() {
		return callbackType;
	}

	public void setCallbackType(String callbackType) {
		this.callbackType = callbackType;
	}

	public HashMap<String, ?> getPayload() {
		return payload;
	}

	public void setPayload(HashMap<String, ?> payload) {
		this.payload = payload;
	}

	public long getExpiryTime() {
		return expiryTime;
	}

	public void setExpiryTime(long expiryTime) {
		this.expiryTime = expiryTime;
	}
	
}