package com.example.visa.config;

import javax.servlet.Filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.example.visa.filter.JwtRequestFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private MyUserDetail userDetail;
    @Autowired
    JwtRequestFilter jwtRequestFilter;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // TODO Auto-generated method stub
        auth.userDetailsService(userDetail).passwordEncoder(passwordEncoder());
    }

    // đây chúng tôi cho phép truy cập ẩn danh khi đăng nhập / để người dùng có thể
    // xác thực. Chúng tôi sẽ hạn chế
    // quản trị viên đối với các vai trò QUẢN TRỊ và đảm bảo mọi thứ khác:

    // một số chú thích với spring security
    // loginPage () - trang đăng nhập tùy chỉnh
    // loginProcessingUrl () - URL để gửi tên người dùng và mật khẩu đến
    // defaultSuccessUrl () - trang đích sau khi đăng nhập thành công
    // failUrl () - trang đích sau khi đăng nhập không thành công
    // logoutUrl () - đăng xuất tùy chỉnh
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // TODO Auto-generated method stub
        http.cors()
                .and().csrf().disable().authorizeRequests()
                // this is url pass authencation
                .antMatchers("/api/authenticate",
                        "/api/addUser",
                        "/api/checkEmail/**",
                        "/api/checkLogin/**",
                        "/api/consumer/getTestAll",
                        "/api/addFaceBook/**/**",
                        "/client-ip-address",
                        "/VNPAY")
                .permitAll().anyRequest().authenticated()
                .and().sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.addFilterBefore((Filter) jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
    }

    @Override
    @Bean
    protected AuthenticationManager authenticationManager() throws Exception {
        // TODO Auto-generated method stub
        return super.authenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}