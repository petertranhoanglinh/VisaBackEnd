package com.example.visa.config;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.visa.dao.users.UserDao;
import com.example.visa.model.UserModel;
import com.example.visa.service.login.CustomUserDetails;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

@Service
public class MyUserDetail implements UserDetailsService {
    @Autowired
    UserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
        UserModel user = this.userDao.getByUser(userId);

        if (user == null) {
            throw new UsernameNotFoundException("Khong co tai khoan");
        }
        Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
        String roleName = user.getRole();
        authorities.add(new SimpleGrantedAuthority(roleName));
        System.out.println("this is authorite" + authorities.toString() +
                "userId : " + user.getUserId());
        // config thêm các thông tin cần vào trong userDetail
        return new CustomUserDetails(user.getPassword(), user.getUserId(), true, true, true, true, authorities, user);
    }

}
