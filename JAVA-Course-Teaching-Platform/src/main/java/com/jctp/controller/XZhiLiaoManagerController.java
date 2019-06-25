package com.jctp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.jctp.beans.CourseFile;
import com.jctp.model.RequestModel;
import com.jctp.model.ResponseModel;
import com.jctp.service.XCourseFileManagerService;
import com.jctp.service.XZhiLiaoManagerService;

@Controller
@RequestMapping("/allStudentCourses-material")
public class XZhiLiaoManagerController {
	
	@Autowired
	private XZhiLiaoManagerService coursefileService;

	/**
	 * DESC:获取所有Clzz数据
	 * @param reqModel
	 * @return ResponseModel
	 */
	@RequestMapping("/listZhiliao")
	@ResponseBody
	public ResponseModel<CourseFile> lilstCourseFile(@RequestBody RequestModel<CourseFile> reqModel){
		//System.out.println("pageSize:"+reqModel.getPageModel().getPageSize());
		ResponseModel<CourseFile> resModel=coursefileService.listCourseFile(reqModel);
		
		return resModel;
	}
	/**
	 * DESC:添加数据
	 * @param Clzz
	 * @return ResponseModel
	 */
	@RequestMapping("/xzhiinsert")
	@ResponseBody
	public ResponseModel<CourseFile> insert(@RequestBody CourseFile coursefile) {
		return coursefileService.insert(coursefile);
	}
	
	@RequestMapping("/xzhidelete")
	@ResponseBody
	public ResponseModel<CourseFile> delete(@RequestBody CourseFile coursefile) {
		return coursefileService.delete(coursefile);
	}
}