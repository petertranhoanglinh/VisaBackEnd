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

	@Column(name = "CTRID")
	private String ctrId;

	@Column(name = "RANKCD")
	private String rankCd;

	@Column(name = "ROLE")
	private String role;

	@Column(name = "PHOTO")
	private String photo;

	@Column(name = "TIME_CREATE")
	private java.sql.Timestamp timeCreate;

	@Column(name = "REFERRAL_CODE")
	private String refferralCode;

	@Column(name = "RATE")
	private int rate;

	public int getRate() {
		return rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
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

	public String getCtrId() {
		return ctrId;
	}

	public void setCtrId(String ctrId) {
		this.ctrId = ctrId;
	}

	public String getRankCd() {
		return rankCd;
	}

	public void setRankCd(String rankCd) {
		this.rankCd = rankCd;
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

	public String getRefferralCode() {
		return refferralCode;
	}

	public void setRefferralCode(String refferralCode) {
		this.refferralCode = refferralCode;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

}
