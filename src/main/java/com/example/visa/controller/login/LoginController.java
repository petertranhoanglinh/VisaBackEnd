package com.example.visa.controller.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.visa.config.MyUserDetail;
import com.example.visa.dto.login.AuthencationRequest;
import com.example.visa.dto.login.AuthencationResponse;
import com.example.visa.model.UserModel;
import com.example.visa.service.login.CustomUserDetails;
import com.example.visa.service.system.StorageService;
import com.example.visa.service.users.UserSerivece;
import com.example.visa.util.JwtUtil;
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

}
