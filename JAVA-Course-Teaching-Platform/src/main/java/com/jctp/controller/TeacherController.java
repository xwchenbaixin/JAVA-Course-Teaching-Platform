package com.jctp.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jctp.beans.Homework;
import com.jctp.beans.Message;
import com.jctp.model.RequestModel;
import com.jctp.model.ResponseModel;
import com.jctp.service.TeacherService;

@Controller
@RequestMapping("/teacher")
public class TeacherController {
	@Autowired
	private TeacherService teacherService;
	
	@RequestMapping("/listHomework")
	@ResponseBody
	public ResponseModel<Homework> listHomework(@RequestBody RequestModel<Homework> reqModel){
		return teacherService.listHomework(reqModel);
	}
	@RequestMapping("/listMessage")
	@ResponseBody
	public ResponseModel<Message> listMessage(@RequestBody RequestModel<Message> reqModel){
		return teacherService.listMessage(reqModel);
	}
	
}
