package com.jctp.service.permission;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.jctp.beans.User;
import com.jctp.mapper.UserPermissionMapper;
@Component
public class LoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler{
	@Autowired
	private UserPermissionMapper userPermissionMapper;

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
		Authentication authentication) throws IOException, ServletException {
		/*
		// 获取当前用户(domain接收)
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		User user=userPermissionMapper.getUserByWorkNo(userDetails.getUsername());
		request.getSession().setAttribute("user", user);
		System.out.println("登录成功!");
		*/
		super.onAuthenticationSuccess(request, response, authentication);
	}

}
