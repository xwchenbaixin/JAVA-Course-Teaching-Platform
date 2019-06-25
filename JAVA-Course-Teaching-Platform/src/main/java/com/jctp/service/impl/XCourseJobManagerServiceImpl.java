package com.jctp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jctp.beans.Course;
import com.jctp.beans.CourseFile;
import com.jctp.beans.CourseJob;
import com.jctp.mapper.XCourseFileManagerMapper;
import com.jctp.mapper.XCourseJobManagerMapper;
import com.jctp.mapper.XCourseManagerMapper;
import com.jctp.model.RequestModel;
import com.jctp.model.ResponseModel;
import com.jctp.service.XCourseFileManagerService;
import com.jctp.service.XCourseJobManagerService;
import com.jctp.service.XCourseManagerService;

@Service("coursejobService")
public class XCourseJobManagerServiceImpl implements XCourseJobManagerService{
	@Autowired
	private XCourseJobManagerMapper coursejobManagerMapper;

	@Override
	@Transactional
	public ResponseModel<CourseJob>listCourse(RequestModel<CourseJob> reqModel) {
		// TODO Auto-generated method stub
		int total=coursejobManagerMapper.getTotal();
		
		List<CourseJob> courseList=coursejobManagerMapper.listCourse(reqModel);
		
		return new ResponseModel<CourseJob>(courseList, total);
	}

	@Override
	@Transactional
	public ResponseModel<CourseJob> update(CourseJob course) {
		ResponseModel<CourseJob> resModel=new ResponseModel<CourseJob>();
			coursejobManagerMapper.update(course);
			resModel.setStatus(200);
			resModel.setMsg("修改成功");
		return resModel;
	}

	@Override
	public ResponseModel<CourseJob> delete(CourseJob course) {
		int status=coursejobManagerMapper.delete(course);
		ResponseModel<CourseJob> resModel=new ResponseModel<CourseJob>();
		if(status==1) {
			resModel.setStatus(200);
			resModel.setMsg("修改成功");
		}
		return resModel;
	}

	@Override
	public ResponseModel<CourseJob> insert(CourseJob course) {
		ResponseModel<CourseJob> resModel=new ResponseModel<CourseJob>();
			coursejobManagerMapper.insert(course);
			resModel.setStatus(200);
			resModel.setMsg("添加成功");
		return resModel;
	}
}
