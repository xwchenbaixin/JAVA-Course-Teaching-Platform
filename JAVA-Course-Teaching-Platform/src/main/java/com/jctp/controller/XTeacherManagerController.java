package com.jctp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jctp.beans.User;
import com.jctp.model.RequestModel;
import com.jctp.model.ResponseModel;
import com.jctp.service.XTeacherManagerService;

@Controller
@RequestMapping("/teacherManager")
public class XTeacherManagerController {
	
	@Autowired
	private XTeacherManagerService teacherService;

	/**
	 * DESC:获取所有Teacher数据
	 * @param reqModel
	 * @return ResponseModel
	 */
	@RequestMapping("/listTeacher")
	@ResponseBody
	public ResponseModel<User> lilstUsers(@RequestBody RequestModel<User> reqModel){
		//System.out.println("pageSize:"+reqModel.getPageModel().getPageSize());
		ResponseModel<User> resModel=teacherService.listTeacher(reqModel);
		
		return resModel;
	}
	/**
	 * DESC:更新Teacher数据
	 * @param user
	 * @return ResponseModel
	 */
	@RequestMapping("/xteaupdate")
	@ResponseBody
	public ResponseModel<User> update(@RequestBody User user) {

		return teacherService.update(user);
	}
	/**
	 * DESC:添加数据
	 * @param user
	 * @return ResponseModel
	 */
	@RequestMapping("/xtinsert")
	@ResponseBody
	public ResponseModel<User> insert(@RequestBody User user) {
		return teacherService.insert(user);
	}
	
	@RequestMapping("/xstudelete")
	@ResponseBody
	public ResponseModel<User> delete(@RequestBody User user) {
		return teacherService.delete(user);
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
