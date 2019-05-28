package com.jctp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jctp.beans.User;
import com.jctp.service.StudentService;

@Controller
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@RequestMapping("/")
	public String index(Model model) {
		model.addAttribute("Users",studentService.listUsers());
		return "index";
	}
	
	@RequestMapping("/listUsers")
	@ResponseBody
	public List<User> lilstUsers(){
		return studentService.listUsers();
	}
	
	@RequestMapping("/teacher")
	@ResponseBody
	public String teacherTest() {
		return "teacher welcome";
	}
	
	@RequestMapping("/student")
	@ResponseBody
	public String studentTest() {
		return "student welcome";
	}
	
}
