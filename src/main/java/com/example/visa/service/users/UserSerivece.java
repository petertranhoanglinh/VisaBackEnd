package com.example.visa.service.users;

import com.example.visa.model.UserModel;
import com.example.visa.util.MessegeStatus;

public interface UserSerivece {
    public UserModel getByUser(String userId);
    public MessegeStatus addUser (String email , String password);
    public boolean isEmailHasUsed(String email); 

}
