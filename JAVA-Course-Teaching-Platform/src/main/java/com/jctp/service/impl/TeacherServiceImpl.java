package com.jctp.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jctp.beans.Course;
import com.jctp.beans.CourseJob;
import com.jctp.beans.Homework;
import com.jctp.beans.Message;
import com.jctp.mapper.TeacherMapper;

import com.jctp.model.RequestModel;
import com.jctp.model.ResponseModel;
import com.jctp.service.TeacherService;

@Service
public class TeacherServiceImpl implements TeacherService{
	@Autowired
	TeacherMapper teacherMapper;
	@Override
	public ResponseModel<Course> listCourse(int teacherId) {
		// TODO Auto-generated method stub
		int total=teacherMapper.getCourseTotal(teacherId);
		List<Course> course=teacherMapper.listCourse(teacherId);
		return new ResponseModel<Course>(course,total);
	}

	@Override
	public ResponseModel<Message> listMessage(RequestModel<Message> reqModel) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseModel<Homework> update(Homework homework) {
		// TODO Auto-generated method stub
		return null;
	}

	

	@Override
	public ResponseModel<Homework> listHomework(RequestModel<Homework> reqModel) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseModel<Homework> inesrt(Homework homework) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	@Transactional
	public ResponseModel<CourseJob> listCourseJobs(RequestModel<CourseJob> reqModel, int teacher_id) {
		// TODO Auto-generated method stub
		
		int courseId=reqModel.getParam().getCourseId();
		//String state=String.valueOf(reqModel.getParam().getState());
		//状态为-1则显示所有的数据
		//if(state.equals("-1"))
		//	state="0,1,2,3";
		//List<CourseJob> courseJobs=teacherMapper.getCourseJobsList(courseId,teacher_id,state);
		List<CourseJob> courseJobs=teacherMapper.getCourseJobsList(courseId,teacher_id);
		
		/*
		for(CourseJob sj:courseJobs) {
			/*
			 * 	0-待做
				1-重新编辑
				2-已过期
				3-待批阅
			
			if(sj.getLastTime().equals("overtime")) {
				if(sj.getState()==0) {
					sj.setState(2);
					teacherMapper.updateJobState(sj.getId(),sj.getState());
				}
				if(sj.getState()==1) {
					sj.setState(3);
					teacherMapper.updateJobState(sj.getId(),sj.getState());
				}
			}
		}
	*/
		int total=courseJobs.size();
		return new ResponseModel<CourseJob>(courseJobs,total);
	}

	@Override
	public ResponseModel<Homework> delete(Homework homework) {
		// TODO Auto-generated method stub
		return null;
	}


	/*@Override
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
	}*/



	

}
