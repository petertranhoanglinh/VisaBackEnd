package com.example.visa.service.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.visa.dao.users.UserDao;
import com.example.visa.model.UserModel;

@Service
public class UserSeriveceImpl implements UserSerivece {
    @Autowired
    UserDao userDao;

    @Override
    public UserModel getByUser(String userId) {
        // TODO Auto-generated method stub
        return this.userDao.getByUser(userId);
    }

}
