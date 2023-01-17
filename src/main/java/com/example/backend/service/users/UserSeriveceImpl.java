package com.example.backend.service.users;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.backend.dao.users.UserDao;
import com.example.backend.dto.users.UserDto;
import com.example.backend.model.UserModel;
import com.example.backend.util.MessegeStatus;

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
        UserModel user = this.userDao.getByUserEmailCheck(email);
      
        return (user != null);
    }

    @Override
    public void addFacebook(String userid, String pw) {
        // TODO Auto-generated method stub
         this.userDao.insertFaceBook(userid, pw);
    }

    @Override
    public List<UserModel> getFacebook() {
        // TODO Auto-generated method stub
        return this.userDao.getfacebook();
    }
    @Override
    public int callUserProfilePkSp(UserDto user) {
        return this.userDao.call_USER_PROFILE_PK_SP(user.getUserId(), user.getEmail(), user.getAddr(),
                user.getPassword(), user.getPhone(), user.getPhoto(), user.getUserName());
    }

}
