package com.example.backend.dto.users;

import java.io.Serializable;

import org.springframework.web.multipart.MultipartFile;

public class UserDto implements Serializable {
    private static final long serialVersionUID = 74458L;

    private String userId;

    private String password;

    private String userName;
    
    private String menuCd;
    private String photo;
    private String email;
    private String addr;
    private String phone;
    private String description;
    private String imgOldName;
    




    public String getImgOldName() {
        return imgOldName;
    }

    public void setImgOldName(String imgOldName) {
        this.imgOldName = imgOldName;
    }

    private String role;

    private MultipartFile imgData;


    public static long getSerialversionuid() {
        return serialVersionUID;
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getMenuCd() {
        return menuCd;
    }

    public void setMenuCd(String menuCd) {
        this.menuCd = menuCd;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    
    



}
