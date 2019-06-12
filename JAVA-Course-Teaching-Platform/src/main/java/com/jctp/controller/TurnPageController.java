package com.jctp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jctp.mapper.UserPermissionMapper;

@Controller
public class TurnPageController {
	@RequestMapping("/turnPage/{packageName}/{pageName}")
	public String turnPage(@PathVariable("packageName") String packageName,@PathVariable("pageName") String pageName,Model model) {
		
		//从数据库查找该ID对应的界面
	
		return packageName+"/"+pageName;
	}
	
	@RequestMapping("/")
	public String index(Model model,HttpServletRequest request) {
		/*
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		user=userPermissionMapper.getUserByWorkNo(userDetails.getUsername());
		model.addAttribute("user", user);
		*/
		return "index";
	}
}
