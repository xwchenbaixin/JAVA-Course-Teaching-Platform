package com.jctp.controller;

import java.util.List;

import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jctp.beans.User;
import com.jctp.common.PageModel;
import com.jctp.common.RequestModel;
import com.jctp.common.ResponseModel;
import com.jctp.service.StudentManagerService;

@Controller
@RequestMapping("/studentManager")
public class StudentManagerController {
	
	@Autowired
	private StudentManagerService studentService;

	
	@RequestMapping("/listUsers")
	@ResponseBody
	public ResponseModel<User> lilstUsers(@RequestBody RequestModel<User> reqModel){
		//System.out.println("pageSize:"+reqModel.getPageModel().getPageSize());
		PageModel pageModel=reqModel.getPageModel();
		ResponseModel<User> resModel=studentService.listUsers(pageModel.getOffset(),pageModel.getPageSize());
		
		return resModel;
	}
	@RequestMapping("/update")
	@ResponseBody
	public ResponseModel<User> update(@RequestBody User user) {
		System.out.println(studentService.update(user));
		ResponseModel<User> resModel=new ResponseModel<User>();
		resModel.setStatus(200);
		resModel.setMsg("修改成功");
		return resModel;
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
