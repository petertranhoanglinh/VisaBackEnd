package com.example.backend.dto.login;

import java.util.List;

import org.springframework.security.core.GrantedAuthority;

import com.example.backend.model.UserModel;

public class AuthencationResponse {
	private final String jwt;
	private String userName;
	private UserModel userDetail;

	List<GrantedAuthority> authorities;

	public UserModel getUserDetail() {
		return userDetail;
	}

	public void setUserDetail(UserModel userDetail) {
		this.userDetail = userDetail;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public AuthencationResponse(String jwt) {
		this.jwt = jwt;
	}

	public AuthencationResponse(String jwt, String userName, UserModel userDetail) {
		this.jwt = jwt;
		this.userName = userName;
		this.userDetail = userDetail;

	}

	public String getJwt() {
		return jwt;
	}
}
