package com.example.visa.service.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.visa.dao.users.UserDao;
import com.example.visa.model.UserModel;
import com.example.visa.util.MessegeStatus;

@Service
public class UserSeriveceImpl implements UserSerivece {
    String StrRequestSuscess = "Register account suscess";
    String StrRequestFail = "Register account fail by email has used";
    @Autowired
    UserDao userDao;
    
    @Override
    public UserModel getByUser(String userId) {
        // TODO Auto-generated method stub
        return this.userDao.getByUser(userId);
    }

    @Override
    public MessegeStatus addUser(String email, String password) {
        // TODO Auto-generated method stub
        String passwordEncoder = new BCryptPasswordEncoder().encode(password);
        int statusRequest = this.userDao.callUserPK(email, passwordEncoder);
        if(statusRequest == 0 ) {
            return new MessegeStatus(StrRequestFail, "0000");
        }else {
            return new MessegeStatus(StrRequestSuscess, "0001");
        }
     
    }

    @Override
    public boolean isEmailHasUsed(String email) {
        // TODO Auto-generated method stub
        UserModel user = this.userDao.getByUser(email);
      
        return (user != null);
    }

}
