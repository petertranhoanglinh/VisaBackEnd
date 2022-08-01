package com.example.visa.service.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.visa.dao.users.UserDao;
import com.example.visa.dto.users.UserDto;
import com.example.visa.entity.Users;
import com.example.visa.model.accounts.UserModel;

@Service
public class UserSeriveceImpl implements UserSerivece {
    @Autowired
    UserDao userDao;

    @Override
    public String checkReferralCode(String referralCode) {
        // TODO Auto-generated method stub

        return this.userDao.checkReferralCode(referralCode);
    }

    @Override
    public UserModel getByUser(String userId) {
        // TODO Auto-generated method stub
        return this.userDao.getByUser(userId);
    }

    @Override
    public String checkUser(String userId) {
        // TODO Auto-generated method stub
        return this.userDao.checkUser(userId);
    }

    @Override
    public void updateUser(String userId, String photo) {
        // TODO Auto-generated method stub
        this.userDao.updateUser(userId, photo);

    }

}
