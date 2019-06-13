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
import com.jctp.model.PageModel;
import com.jctp.model.RequestModel;
import com.jctp.model.ResponseModel;
import com.jctp.service.StudentManagerService;

@Controller
@RequestMapping("/studentManager")
public class StudentManagerController {
	
	@Autowired
	private StudentManagerService studentService;

	/**
	 * DESC:获取所有Users数据
	 * @param reqModel
	 * @return ResponseModel
	 */
	@RequestMapping("/listUsers")
	@ResponseBody
	public ResponseModel<User> lilstUsers(@RequestBody RequestModel<User> reqModel){
		//System.out.println("pageSize:"+reqModel.getPageModel().getPageSize());
		ResponseModel<User> resModel=studentService.listUsers(reqModel);
		
		return resModel;
	}
	
	/**
	 * DESC:更新Student数据
	 * @param user
	 * @return ResponseModel
	 */
	@RequestMapping("/update")
	@ResponseBody
	public ResponseModel<User> update(@RequestBody User user) {

		return studentService.update(user);
	}
	/**
	 * DESC:添加数据
	 * @param user
	 * @return ResponseModel
	 */
	@RequestMapping("/insert")
	@ResponseBody
	public ResponseModel<User> insert(@RequestBody User user) {
		return studentService.insert(user);
	}
	
	@RequestMapping("/delete")
	@ResponseBody
	public ResponseModel<User> delete(@RequestBody User user) {
		return studentService.delete(user);
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
