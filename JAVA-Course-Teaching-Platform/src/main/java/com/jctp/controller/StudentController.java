package com.jctp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jctp.beans.Course;
import com.jctp.beans.CourseJob;
import com.jctp.model.RequestModel;
import com.jctp.model.ResponseModel;
import com.jctp.service.StudentService;

@Controller
@RequestMapping("/student")
public class StudentController {
	@Autowired
	private StudentService studentService;
	
	@RequestMapping("/listCourses")
	@ResponseBody
	public ResponseModel<Course> listCourses(@RequestBody RequestModel<Course> reqModel){
		return studentService.listCourses(reqModel);
	}
	
	@RequestMapping("/listCourseJobs")
	@ResponseBody
	public ResponseModel<CourseJob> listCourseJobs(@RequestBody RequestModel<CourseJob> reqModel){
		return studentService.listCourseJobs(reqModel);
	}
	
	@RequestMapping("/submitJob")
	@ResponseBody
	public ResponseModel<CourseJob> submitJob(@RequestBody CourseJob courseJob){
		return studentService.submitJob(courseJob);
	}
	
}
