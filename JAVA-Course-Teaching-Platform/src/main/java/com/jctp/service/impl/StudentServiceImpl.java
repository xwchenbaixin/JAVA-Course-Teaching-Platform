package com.jctp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jctp.beans.Course;
import com.jctp.beans.CourseJob;
import com.jctp.mapper.StudentMapper;
import com.jctp.model.RequestModel;
import com.jctp.model.ResponseModel;
import com.jctp.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService{
	@Autowired
	private StudentMapper studentMapper;
	@Override
	public ResponseModel<Course> listCourses(RequestModel<Course> reqModel) {
		// TODO Auto-generated method stub
		int total=studentMapper.getCoursesTotal();
		List<Course> courses=studentMapper.listCourses(reqModel);
		return new ResponseModel<Course>(courses, total);
	}


	@Override
	public ResponseModel<CourseJob> listCourseJobs(RequestModel<CourseJob> reqModel) {
		// TODO Auto-generated method stub
		int total=studentMapper.getCourseJobsTotal();
		List<CourseJob> courseJobs=studentMapper.listCourseJobs(reqModel);
		return new ResponseModel<CourseJob>(courseJobs,total);
	}


	@Override
	public ResponseModel<CourseJob> submitJob(CourseJob courseJob) {
		// TODO Auto-generated method stub
		//json数据格式
		String asnwer=studentMapper.getJobAnswer(courseJob);
		//判断答案是否正确
		//更新作业分数
		studentMapper.updateJobSocre(courseJob);
		ResponseModel<CourseJob> resModel=new ResponseModel<CourseJob>();
		resModel.setMsg("自动评分完成");
		resModel.setStatus(200);
		
		return resModel;
	}

}
