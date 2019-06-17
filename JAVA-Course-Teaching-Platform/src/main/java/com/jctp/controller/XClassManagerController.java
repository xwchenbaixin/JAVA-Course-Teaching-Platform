package com.jctp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jctp.beans.Clzz;
import com.jctp.beans.User;
import com.jctp.model.RequestModel;
import com.jctp.model.ResponseModel;
import com.jctp.service.XClassManagerService;
import com.jctp.service.XStudentManagerService;

@Controller
@RequestMapping("/classManager")
public class XClassManagerController {
	
	@Autowired
	private XClassManagerService classService;

	/**
	 * DESC:获取所有Stuent数据
	 * @param reqModel
	 * @return ResponseModel
	 */
	@RequestMapping("/listClass")
	@ResponseBody
	public ResponseModel<Clzz> listClass(@RequestBody RequestModel<Clzz> reqModel){
		//System.out.println("pageSize:"+reqModel.getPageModel().getPageSize());
		ResponseModel<Clzz> resModel=classService.listClass(reqModel);
		
		return resModel;
	}
	/**
	 * DESC:更新Student数据
	 * @param user
	 * @return ResponseModel
	 */
	@RequestMapping("/xclaupdate")
	@ResponseBody
	public ResponseModel<Clzz> update(@RequestBody Clzz clzz) {

		return classService.update(clzz);
	}
	/**
	 * DESC:添加数据
	 * @param user
	 * @return ResponseModel
	 */
	@RequestMapping("/xclainsert")
	@ResponseBody
	public ResponseModel<Clzz> insert(@RequestBody  Clzz clzz) {
		return classService.insert(clzz);
	}
	
	@RequestMapping("/xcladelete")
	@ResponseBody
	public ResponseModel<Clzz> delete(@RequestBody  Clzz clzz) {
		return classService.delete(clzz);
	}
	
}
