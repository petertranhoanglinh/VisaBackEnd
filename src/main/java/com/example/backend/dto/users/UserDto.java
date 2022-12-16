package com.example.backend.dto.users;

import java.io.Serializable;

import org.springframework.web.multipart.MultipartFile;

public class UserDto implements Serializable {
    private static final long serialVersionUID = 74458L;

    private String userId;

    private String password;

    private String userName;

    private String ctrId;

    private String rankCd;

    private String role;

    private String refferralCode;

    private int rate;

    private MultipartFile imgData;

    private String imageFileNameOld;

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public String getImageFileNameOld() {
        return imageFileNameOld;
    }

    public void setImageFileNameOld(String imageFileNameOld) {
        this.imageFileNameOld = imageFileNameOld;
    }

    public MultipartFile getImgData() {
        return imgData;
    }

    public void setImgData(MultipartFile imgData) {
        this.imgData = imgData;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

    public int getRate() {
        return rate;
    }

    public void setRate(int i) {
        this.rate = i;
    }

}
