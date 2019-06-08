package com.jctp.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Scope;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.jctp.beans.User;
import com.jctp.mapper.UserPermissionMapper;

@SpringBootApplication
@ComponentScan(basePackages = {"com.jctp"})
@MapperScan(basePackages = "com.jctp.mapper")
public class JavaCourseTeachingPlatformApplication {
	public static void main(String[] args) {
		SpringApplication.run(JavaCourseTeachingPlatformApplication.class, args);
	}
	
}
