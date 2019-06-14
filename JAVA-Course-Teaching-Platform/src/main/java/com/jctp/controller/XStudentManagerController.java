package com.jctp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jctp.beans.User;
import com.jctp.model.RequestModel;
import com.jctp.model.ResponseModel;
import com.jctp.service.XStudentManagerService;

@Controller
@RequestMapping("/studentManager")
public class XStudentManagerController {
	
	@Autowired
	private XStudentManagerService studentService;

	/**
	 * DESC:获取所有Stuent数据
	 * @param reqModel
	 * @return ResponseModel
	 */
	@RequestMapping("/listStudent")
	@ResponseBody
	public ResponseModel<User> listStudent(@RequestBody RequestModel<User> reqModel){
		//System.out.println("pageSize:"+reqModel.getPageModel().getPageSize());
		ResponseModel<User> resModel=studentService.listStudent(reqModel);
		
		return resModel;
	}
	/**
	 * DESC:更新Student数据
	 * @param user
	 * @return ResponseModel
	 */
	@RequestMapping("/xstuupdate")
	@ResponseBody
	public ResponseModel<User> update(@RequestBody User user) {

		return studentService.update(user);
	}
	/**
	 * DESC:添加数据
	 * @param user
	 * @return ResponseModel
	 */
	@RequestMapping("/xstuinsert")
	@ResponseBody
	public ResponseModel<User> insert(@RequestBody User user) {
		return studentService.insert(user);
	}
	
	@RequestMapping("/xstudelete")
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
