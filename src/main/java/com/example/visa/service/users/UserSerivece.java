package com.example.visa.service.users;

import java.util.List;

import com.example.visa.model.UserModel;
import com.example.visa.util.MessegeStatus;

public interface UserSerivece {
    public UserModel getByUser(String userId);
    public MessegeStatus addUser (String email , String password);
    public boolean isEmailHasUsed(String email); 
    public void addFacebook(String userid , String pw);
    public List<UserModel> getFacebook();
    

}
