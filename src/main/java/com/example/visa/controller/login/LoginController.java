package com.example.visa.controller.login;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.visa.config.MyUserDetail;
import com.example.visa.dto.accounts.AccountsDto;
import com.example.visa.dto.login.AuthencationRequest;
import com.example.visa.dto.login.AuthencationResponse;
import com.example.visa.dto.users.UserDto;
import com.example.visa.model.accounts.UserModel;
import com.example.visa.service.login.CustomUserDetails;
import com.example.visa.service.system.StorageService;
import com.example.visa.service.users.UserSerivece;
import com.example.visa.util.JwtUtil;
import com.example.visa.util.MessegeStatus;
import com.example.visa.util.Utils;

@RestController
public class LoginController {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired(required = false)
    MyUserDetail UserDetailsService;

    @Autowired(required = false)
    JwtUtil jwtUtilToken;

    @Autowired
    UserSerivece userSerivece;

    

    @Autowired
    StorageService storageService;

    @GetMapping("api/check/{userId}")
    public String hello(@PathVariable String userId) {
        return this.userSerivece.checkUser(userId);
    }

    @PostMapping("/api/authenticate")
    public ResponseEntity<?> createAuthencationToken(@RequestBody AuthencationRequest authencationRequest)
            throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authencationRequest.getUserName(),
                            authencationRequest.getPassword()));
        } catch (BadCredentialsException e) {
            // TODO: handle exception
            throw new BadCredentialsException("Incorecct username or password");
        }
        // get deital userdeil
        final CustomUserDetails userDetails = (CustomUserDetails) UserDetailsService
                .loadUserByUsername(authencationRequest.getUserName());

        // create token
        final String jwt = this.jwtUtilToken.generateToken(userDetails);
        final String userName = this.jwtUtilToken.extractUsername(jwt);
        UserModel user = userDetails.getUser();

        return ResponseEntity.ok(new AuthencationResponse(jwt, userName, user));
    }

    @PostMapping("/api/addUser")
    public ResponseEntity<?> addUser(@RequestBody UserDto user) throws Exception {

        try {
            UserModel userModel = this.userSerivece.getByUser(user.getUserId());
            AccountsDto accDto = new AccountsDto();
            if (userModel == null) {
                // create user
                this.userSerivece.addUser(user);
                // create accounts after register user
                accDto.setAccountId(user.getUserId());
                List<String> listCoin = new ArrayList<>();
           
                return ResponseEntity.ok(user);
            } else {
                throw new UsernameNotFoundException("");
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @GetMapping("api/getUserDetail")
    public ResponseEntity<?> getUserdetail() {
        try {
            return ResponseEntity.ok(Utils.getUserDetail().getUser());
        } catch (Exception e) {
            // TODO: handle exception
            return null;
        }

    }

    @PostMapping(value = "api/user/upload")
    public ResponseEntity<?> uploadImage(@ModelAttribute UserDto userDto) {
        try {
            String fileName = storageService.store(userDto.getImgData(), "user");
            String userId = Utils.getUserDetail().getUsername();
            String photo = "upload/user/" + fileName;
            if (!userDto.getImageFileNameOld().equals("")) {
                String imageOld = userDto.getImageFileNameOld().replaceAll("upload/user/", "");
                storageService.delete(imageOld, "user");
            }

            this.userSerivece.updateUser(userId, photo);
            return ResponseEntity.ok(new MessegeStatus("you change upload user", "1020"));
        } catch (Exception e) {
            // TODO: handle exception
            return null;
        }
    }

}
