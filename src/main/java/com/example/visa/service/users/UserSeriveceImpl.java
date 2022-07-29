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
    public void addUser(UserDto user) {
        Users userEntity = new Users();
        if (user.getRefferralCode() != null && !user.getRefferralCode().equals("")) {
            String usersRef = this.userDao.checkReferralCode(user.getRefferralCode());
            // TODO Auto-generated method stub
            if (usersRef != null) {
                user.setRate(1);
                userEntity.setRate(1);
                this.userDao.updateRateByUserId(usersRef);
            }
        }

        String password = new BCryptPasswordEncoder().encode(user.getPassword());
        userEntity.setUserName(user.getUserName());
        userEntity.setPassword(password);
        userEntity.setCtrId(user.getCtrId());
        userEntity.setRole(user.getRole());
        userEntity.setRankCd(user.getRankCd());
        userEntity.setUserId(user.getUserId());
        this.userDao.save(userEntity);
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
