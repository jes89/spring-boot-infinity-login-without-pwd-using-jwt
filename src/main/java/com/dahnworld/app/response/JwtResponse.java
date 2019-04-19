package com.dahnworld.app.response;

public class JwtResponse {

	private String token;
	private String type = "Bearer";
	private String msg;
	private String callbackType;
	
	
	private long expiryTime;

	public JwtResponse(String accessToken, long expiryTime, String msg, String callbackType) {
		this.token = accessToken;
		this.expiryTime = expiryTime;
		this.msg = msg;
		this.callbackType = callbackType;
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
	
	public long getExpiryTime() {
		return expiryTime;
	}

	public void setExpiryTime(long expiryTime) {
		this.expiryTime = expiryTime;
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

}