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
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.security.web.context.SecurityContextPersistenceFilter;
import org.springframework.stereotype.Component;

import com.jctp.beans.Constants;
import com.jctp.beans.User;
import com.jctp.mapper.UserPermissionMapper;
@Component
public class LoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler{
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
		Authentication authentication) throws IOException, ServletException {
		User user=(User) authentication.getPrincipal();
		String targetUrl="turnPage?role="+user.getRoleName().toLowerCase()+"&pn=";
		switch (user.getRoleId()) {
		case 1:
			targetUrl+=Constants.STUDENT_INDEX;
			break;
		case 2:
			targetUrl+=Constants.TEACHER_INDEX;
			break;
		case 3:
			targetUrl+=Constants.DEAN_INDEX;
			break;

		default:
			break;
		}
		//登录成功后跳转至角色对应的首界面
		//System.err.println(targetUrl);
		response.sendRedirect(targetUrl);
		//super.onAuthenticationSuccess(request, response, authentication);
	}

}
