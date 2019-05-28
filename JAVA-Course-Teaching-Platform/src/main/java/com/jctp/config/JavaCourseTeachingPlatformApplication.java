package com.jctp.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.jctp"})
@MapperScan(basePackages = "com.jctp.mapper")
public class JavaCourseTeachingPlatformApplication {
	public static void main(String[] args) {
		SpringApplication.run(JavaCourseTeachingPlatformApplication.class, args);
	}

}
