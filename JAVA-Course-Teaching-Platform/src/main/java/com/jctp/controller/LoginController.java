package com.jctp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jctp.beans.User;
import com.jctp.service.permission.MyUserDetailsService;

@Controller
public class LoginController {
	@Autowired
	MyUserDetailsService userPermissionService;
	
	@RequestMapping("/login")
	public String login() {
		System.out.println("登录控制器");
		return "login";
	}
}
