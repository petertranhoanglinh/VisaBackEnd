package com.example.visa.service.users;
import com.example.visa.model.accounts.UserModel;

public interface UserSerivece {
    public String checkReferralCode(String referralCode);

    public UserModel getByUser(String userId);

    public String checkUser(String userId);

    public void updateUser(String userId, String photo);
}
