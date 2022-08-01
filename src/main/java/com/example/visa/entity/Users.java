package com.example.visa.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;

@DynamicInsert
@Entity
@Table(name = "USERS")
public class Users implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1664168847123341692L;

	@Id
	@Column(name = "USERID")
	private String userId;

	@Column(name = "PASSWORD")
	private String password;

	@Column(name = "USERNAME")
	private String userName;

	@Column(name = "ROLE")
	private String role;

	@Column(name = "PHOTO")
	private String photo;
	
	@Column(name = "EMAIL")
	private String email;
	
	@Column(name = "ADDRESS")
	private String address;
	
	@Column(name = "PHONE")
	private String phone;

	@Column(name = "CREATE_DATE")
	private String createDate;



	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}


	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

}
