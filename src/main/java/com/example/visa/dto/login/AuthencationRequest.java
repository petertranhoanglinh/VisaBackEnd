package com.example.visa.dto.login;

public class AuthencationRequest {

    private String userName;
    private String password;
    
	public AuthencationRequest() {
        
	}
	public AuthencationRequest(String userName, String password) {
		this.userName = userName;
		this.password = password;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

    
}
