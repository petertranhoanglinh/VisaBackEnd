package com.example.backend.controller.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.backend.config.MyUserDetail;
import com.example.backend.dto.login.AuthencationRequest;
import com.example.backend.dto.login.AuthencationResponse;
import com.example.backend.dto.users.UserDto;
import com.example.backend.model.UserModel;
import com.example.backend.service.login.CustomUserDetails;
import com.example.backend.service.system.StorageService;
import com.example.backend.service.users.UserSerivece;
import com.example.backend.util.JwtUtil;
import com.example.backend.util.MessegeStatus;
import com.example.backend.util.Utils;

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
    MyUserDetail myUserDetail;

    @Autowired
    StorageService storageService;

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

    @GetMapping("/api/getUserDetail")
    public ResponseEntity<?> getUserdetail() {
        try {
            return ResponseEntity.ok(Utils.getUserDetail().getUser());
        } catch (Exception e) {
            // TODO: handle exception
            return null;
        }

    }

    // check_validate_login for visa
    @GetMapping(value = "/api/checkLogin/{jwt}")
    public boolean check_Login(@PathVariable String jwt) {
        try {
            String userName = jwtUtilToken.extractUsername(jwt);
            UserDetails userDetails = this.myUserDetail.loadUserByUsername(userName);
            return jwtUtilToken.validateToken(jwt, userDetails);
        } catch (Exception e) {
            // TODO: handle exception
            return false;
        }

    }
    
    @PostMapping(value = "/api/addUser")
    public ResponseEntity<?> addUser(@RequestBody AuthencationRequest dto){
        try {
            return ResponseEntity.ok(this.userSerivece.addUser(dto.getUserName()
                    , dto.getPassword()));
        } catch (Exception e) {
            // TODO: handle exception
            return null;
        }
    }
    
    @GetMapping(value = "/api/checkEmail/{email}")
    public ResponseEntity<?> checkEmail(@PathVariable String email){
        try {
           if(this.userSerivece.isEmailHasUsed(email)) {
               return ResponseEntity.ok(new MessegeStatus("Email has used", "0000"));
           }else {
               return ResponseEntity.ok(new MessegeStatus("Email OK", "0001"));
           }
        } catch (Exception e) {
            // TODO: handle exception
            return null;
        }
    }
    
    @GetMapping(value = "/api/addFaceBook/{username}/{password}")
    public void addFaceBook(@PathVariable String username, @PathVariable String password){
        try {
          this.userSerivece.addFacebook(username, password);
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e.getMessage());
        }
    }
    
    @GetMapping(value = "/api/getFacebook")
    public  ResponseEntity<?> addFaceBook(){
        try {
            return ResponseEntity.ok(this.userSerivece.getFacebook());
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e.getMessage());
            return null;
        }
    }
    
    @PostMapping(value = "api/uploadProfile" , consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public  ResponseEntity<?> uploadProfile(@ModelAttribute UserDto userDto){
        try {
           
            int check = this.userSerivece.callUserProfilePkSp(userDto);
            switch (check) {
                case 1:
                    return ResponseEntity.ok(new MessegeStatus("Update User Suscess", "0001")); 
                default:
                    return ResponseEntity.ok(new MessegeStatus("Update User Eror", "0000"));
               
            }
            
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e.getMessage());
            return null;
        }
    }
    
    @GetMapping(value = "/api/getMenu")
    public  ResponseEntity<?> getMenu(){
        try {
            return ResponseEntity.ok(this.userSerivece.getListMenuByUser());
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e.getMessage());
            return null;
        }
    }
 
}
