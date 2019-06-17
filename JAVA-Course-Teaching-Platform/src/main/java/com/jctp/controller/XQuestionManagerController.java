package com.jctp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jctp.beans.Clzz;
import com.jctp.beans.Question;
import com.jctp.beans.User;
import com.jctp.model.RequestModel;
import com.jctp.model.ResponseModel;
import com.jctp.service.XClassManagerService;
import com.jctp.service.XQuestionManagerService;
import com.jctp.service.XStudentManagerService;

@Controller
@RequestMapping("/questionManager")
public class XQuestionManagerController {
	
	@Autowired
	private XQuestionManagerService questionService;

	/**
	 * DESC:获取所有Stuent数据
	 * @param reqModel
	 * @return ResponseModel
	 */
	@RequestMapping("/listQuestion")
	@ResponseBody
	public ResponseModel<Question> listQuestion(@RequestBody RequestModel<Question> reqModel){
		//System.out.println("pageSize:"+reqModel.getPageModel().getPageSize());
		ResponseModel<Question> resModel=questionService.listQuestion(reqModel);
		
		return resModel;
	}
	/**
	 * DESC:更新Student数据
	 * @param user
	 * @return ResponseModel
	 */
	@RequestMapping("/xqueupdate")
	@ResponseBody
	public ResponseModel<Question> update(@RequestBody Question question) {

		return questionService.update(question);
	}
	/**
	 * DESC:添加数据
	 * @param user
	 * @return ResponseModel
	 */
	@RequestMapping("/xqueinsert")
	@ResponseBody
	public ResponseModel<Question> insert(@RequestBody  Question question) {
		return questionService.insert(question);
	}
	
	@RequestMapping("/xquedelete")
	@ResponseBody
	public ResponseModel<Question> delete(@RequestBody  Question question) {
		return questionService.delete(question);
	}
	
}
