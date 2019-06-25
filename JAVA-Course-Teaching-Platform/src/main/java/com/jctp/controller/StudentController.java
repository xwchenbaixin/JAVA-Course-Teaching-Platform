package com.jctp.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.jctp.beans.Course;
import com.jctp.beans.CourseJob;
import com.jctp.beans.StudentJob;
import com.jctp.beans.StudentQuestions;
import com.jctp.beans.User;
import com.jctp.model.JobModel;
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
	public ResponseModel<Course> listCourses(){
		//获取Session
		User user=(User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		return studentService.listCourses(user.getClassId());
	}
	
	@RequestMapping("/listStudentJobs")
	@ResponseBody
	public ResponseModel<StudentJob> listStudentJobs(@RequestBody RequestModel<StudentJob> reqModel){
		User user=(User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		return studentService.listCourseJobs(reqModel,user.getId());
	}
		
	
	@RequestMapping("/doJob")
	public String doJob(int jid,Model model) {
		User user=(User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		int userId=user.getId();
		
		studentService.doJob(jid,userId,model);
		
		return "student/dojob";
	}
	@RequestMapping("/submitJob")
	@ResponseBody
	public ResponseModel<StudentQuestions> submitJob(@RequestBody JobModel jm,Model model) {
		User user=(User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		int userId=user.getId();
		
		
		return studentService.submitJob(jm);
	}
	
	
	@RequestMapping("/getjobs")
	@ResponseBody
	public Map<String, List<StudentQuestions>> getjobs(int jid,Model model) {
		User user=(User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		int userId=user.getId();
		return studentService.doJob(jid,userId,model);
	}
	
}
