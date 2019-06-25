package com.jctp.controller;


import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.jctp.beans.Constants;
import com.jctp.beans.Course;
import com.jctp.beans.CourseJob;
import com.jctp.beans.Homework;
import com.jctp.beans.Message;
import com.jctp.beans.User;

import com.jctp.beans.Homework;
import com.jctp.beans.Message;

import com.jctp.model.RequestModel;
import com.jctp.model.ResponseModel;
import com.jctp.service.TeacherService;

@Controller
@RequestMapping("/teacher")
public class TeacherController {
	@Autowired
	private TeacherService teacherService;

	@RequestMapping("/listCourses")
	@ResponseBody
	public ResponseModel<Course> listCourse(){
		//获取session
		User user=(User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		int teacher_id=user.getId();
		System.out.println(teacher_id);
		return teacherService.listCourse(teacher_id);
	}
	
	@RequestMapping("/listCourseJobs")
	@ResponseBody
	public ResponseModel<CourseJob> listCourseJobs(@RequestBody RequestModel<CourseJob> reqModel){
		//获取session
		User user=(User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		int teacherId=user.getId();
		
		return teacherService.listCourseJobs(reqModel,teacherId);
	}
	
	@RequestMapping("/listHomework")
	@ResponseBody
	public ResponseModel<Homework> listHomework(@RequestBody RequestModel<Homework> reqModel){
		return teacherService.listHomework(reqModel);
	}
	@RequestMapping("/listMessage")
	@ResponseBody
	public ResponseModel<Message> listMessage(@RequestBody RequestModel<Message> reqModel){
		return teacherService.listMessage(reqModel);
	}
	@RequestMapping("homeworkinsert")
	@ResponseBody
	public ResponseModel<Homework> insert(@RequestBody Homework homework){
		return teacherService.inesrt(homework);
	}
	@RequestMapping("homeworkupdate")
	@ResponseBody
	public ResponseModel<Homework> update(@RequestBody Homework homework){
		return teacherService.update(homework);
	}
	@RequestMapping("homeworkdelete")
	@ResponseBody
	public ResponseModel<Homework> delete(@RequestBody Homework homework){
		return teacherService.delete(homework);
	}
	@RequestMapping(value="/uploadFile",produces = "application/json; charset=utf-8")
    @ResponseBody
    public String upload(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return "false";
        }

        String fileName = file.getOriginalFilename();
        String filePath = Constants.FILE_PATH_ROOT;
        File dest = new File(filePath + fileName);
        try {
            file.transferTo(dest);
            //LOGGER.info("上传成功");
            return fileName;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "false";
    }
	
}
