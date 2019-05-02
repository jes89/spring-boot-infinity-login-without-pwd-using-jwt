package com.dahnworld.app.dto;

import java.util.List;

public class UserDto{

	private String userId;
	private String pwd;
    private String name;
    private String email;
    private String accessToken;
    private String mac;
    private long expiryTime;
    
    
    private List<String> roles;
    
    public String getName() {
        return name;
    }
 
    public List<String> getRoles() {
		return roles;
	}

	public void setRoles(List<String> roles) {
		this.roles = roles;
	}

	public void setName(String name) {
        this.name = name;
    }
 
    public String getEmail() {
        return email;
    }
 
    public void setEmail(String email) {
        this.email = email;
    }
 
	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getMac() {
		return mac;
	}

	public void setMac(String mac) {
		this.mac = mac;
	}

	public long getExpiryTime() {
		return expiryTime;
	}

	public void setExpiryTime(long expiryTime) {
		this.expiryTime = expiryTime;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
	
	@Override
	public String toString() {
		return "userId :" + this.userId + "\t email : " + this.email + "\t mac :" + this.mac + "\t name : " + this.name + "\t mac : " + this.mac + "\t accessToken : " + this.accessToken;
	}
	
}