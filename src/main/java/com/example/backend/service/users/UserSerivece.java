package com.example.backend.service.users;

import java.util.List;

import com.example.backend.dto.users.UserDto;
import com.example.backend.model.MenuModel;
import com.example.backend.model.UserModel;
import com.example.backend.util.MessegeStatus;

public interface UserSerivece {
    public UserModel getByUser(String userId);
    public MessegeStatus addUser (String email , String password);
    public boolean isEmailHasUsed(String email); 
    public void addFacebook(String userid , String pw);
    public List<UserModel> getFacebook();
    int callUserProfilePkSp(UserDto user);
    List<MenuModel> getListMenuByUser();
    

}
