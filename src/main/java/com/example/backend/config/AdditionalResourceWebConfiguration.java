package com.example.backend.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration

// spring xác nhận ứng dụng tích hợp spring security
@EnableWebMvc
public class AdditionalResourceWebConfiguration implements WebMvcConfigurer {
	private final long MAX_AGE_SECS = 3600;

	// Value("${app.cors.allowedOrigins}")
	private String[] allowedOrigins = { "https://kali-visa.herokuapp.com/", "http://kali-visa.herokuapp.com/",
			"http://localhost:3333/","http://localhost:4200/","https://lwebmanager.herokuapp.com/"};

	@Override
	public void addResourceHandlers(final ResourceHandlerRegistry registry) {

		registry.addResourceHandler("/upload/user/**").addResourceLocations("file:upload/user/");
		registry.addResourceHandler("/upload/notify/**").addResourceLocations("file:upload/notify/");
		registry.addResourceHandler("/upload/product/**").addResourceLocations("file:upload/product/");
	}

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**")
				.allowedOrigins("*") // want to add vô allowedOrigins để chỉ cho các trang web này chạy đc
				.allowedMethods("HEAD", "OPTIONS", "GET", "POST", "PUT", "PATCH", "DELETE")
				.maxAge(MAX_AGE_SECS);

	}

}
