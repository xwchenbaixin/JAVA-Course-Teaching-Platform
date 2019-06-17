package com.jctp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jctp.beans.Clzz;
import com.jctp.beans.Course;
import com.jctp.beans.CourseFile;
import com.jctp.model.RequestModel;
import com.jctp.model.ResponseModel;
import com.jctp.service.XCourseManagerService;

@Controller
@RequestMapping("/courseManager")
public class XCourseManagerController {
	
	@Autowired
	private XCourseManagerService courseService;

	/**
	 * DESC:获取所有Clzz数据
	 * @param reqModel
	 * @return ResponseModel
	 */
	@RequestMapping("/listCourse")
	@ResponseBody
	public ResponseModel<Course> lilstCourse(@RequestBody RequestModel<Course> reqModel){
		//System.out.println("pageSize:"+reqModel.getPageModel().getPageSize());
		ResponseModel<Course> resModel=courseService.listCourse(reqModel);
		
		return resModel;
	}
	/**
	 * DESC:更新Student数据
	 * @param Clzz
	 * @return ResponseModel
	 */
	@RequestMapping("/xcouupdate")
	@ResponseBody
	public ResponseModel<Course> update(@RequestBody Course course) {
		return courseService.update(course);
	}
	/**
	 * DESC:添加数据
	 * @param Clzz
	 * @return ResponseModel
	 */
	@RequestMapping("/xcouinsert")
	@ResponseBody
	public ResponseModel<Course> insert(@RequestBody Course course) {
		return courseService.insert(course);
	}
	
	@RequestMapping("/xcoudelete")
	@ResponseBody
	public ResponseModel<Course> delete(@RequestBody Course course) {
		return courseService.delete(course);
	}
}