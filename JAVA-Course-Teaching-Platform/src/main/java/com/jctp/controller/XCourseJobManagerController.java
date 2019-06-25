package com.jctp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jctp.beans.Clzz;
import com.jctp.beans.Course;
import com.jctp.beans.CourseFile;
import com.jctp.beans.CourseJob;
import com.jctp.model.RequestModel;
import com.jctp.model.ResponseModel;
import com.jctp.service.XCourseJobManagerService;
import com.jctp.service.XCourseManagerService;

@Controller
@RequestMapping("/coursejobManager")
public class XCourseJobManagerController {
	
	@Autowired
	private XCourseJobManagerService coursejobService;

	/**
	 * DESC:更新Student数据
	 * @param Clzz
	 * @return ResponseModel
	 */
	@RequestMapping("/xjobupdate")
	@ResponseBody
	public ResponseModel<CourseJob> update(@RequestBody CourseJob course) {
		return coursejobService.update(course);
	}
	/**
	 * DESC:添加数据
	 * @param Clzz
	 * @return ResponseModel
	 */
	@RequestMapping("/xjobinsert")
	@ResponseBody
	public ResponseModel<CourseJob> insert(@RequestBody CourseJob course) {
		return coursejobService.insert(course);
	}
	
	@RequestMapping("/xjobdelete")
	@ResponseBody
	public ResponseModel<CourseJob> delete(@RequestBody CourseJob course) {
		return coursejobService.delete(course);
	}
}