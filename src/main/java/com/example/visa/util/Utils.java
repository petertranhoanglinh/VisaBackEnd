package com.example.visa.util;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.example.visa.model.UserModel;
import com.example.visa.service.login.CustomUserDetails;

public class Utils {

	public static String API_KEY = "0605cbf4-e7e1-4491-b084-7d5490460731";
	static Timestamp timestamp = new Timestamp(System.currentTimeMillis());

	// 2021-03-24 16:48:05.591
	static Date date = new Date();
	// Timestamp timestamp2 = new Timestamp(date.getTime());

	// convert Instant to Timestamp
	// Timestamp ts = Timestamp.from(Instant.now());

	// convert ZonedDateTime to Instant to Timestamp
	// Timestamp ts1= Timestamp.from(ZonedDateTime.now().toInstant());

	// convert Timestamp to Instant
	// Instant instant = ts.toInstant();

	public static Timestamp TIME_GLOBAL_NOW = timestamp;

	public static String fomatterDate(Date date) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		formatter.format(date);
		return formatter.format(date);
	}

	public static String URL_META = "https://mainnet.infura.io/v3/cdd1642fca664ab9960e1c7a1ad07c0f";

	public static CustomUserDetails getUserDetail() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		CustomUserDetails userDetails = (CustomUserDetails) auth.getPrincipal();
		return userDetails;
	}
	
	public static boolean isAdmin() {
	    
	    UserModel userModel = getUserDetail().getUser();
	    return ("ADMIN".equals(userModel.getRole()));

	}

}

