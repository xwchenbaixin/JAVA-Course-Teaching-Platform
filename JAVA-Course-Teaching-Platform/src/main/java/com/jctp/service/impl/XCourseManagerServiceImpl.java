package com.jctp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jctp.beans.Course;
import com.jctp.beans.CourseFile;
import com.jctp.mapper.XCourseFileManagerMapper;
import com.jctp.mapper.XCourseManagerMapper;
import com.jctp.model.RequestModel;
import com.jctp.model.ResponseModel;
import com.jctp.service.XCourseFileManagerService;
import com.jctp.service.XCourseManagerService;

@Service("courseService")
public class XCourseManagerServiceImpl implements XCourseManagerService{
	@Autowired
	private XCourseManagerMapper courseManagerMapper;

	@Override
	@Transactional
	public ResponseModel<Course>listCourse(RequestModel<Course> reqModel) {
		// TODO Auto-generated method stub
		int total=courseManagerMapper.getTotal();
		
		List<Course> courseList=courseManagerMapper.listCourse(reqModel);
		
		return new ResponseModel<Course>(courseList, total);
	}

	@Override
	@Transactional
	public ResponseModel<Course> update(Course course) {
		ResponseModel<Course> resModel=new ResponseModel<Course>();
			courseManagerMapper.update(course);
			resModel.setStatus(200);
			resModel.setMsg("修改成功");
		return resModel;
	}

	@Override
	public ResponseModel<Course> delete(Course course) {
		int status=courseManagerMapper.delete(course);
		ResponseModel<Course> resModel=new ResponseModel<Course>();
		if(status==1) {
			resModel.setStatus(200);
			resModel.setMsg("修改成功");
		}
		return resModel;
	}

	@Override
	public ResponseModel<Course> insert(Course course) {
		ResponseModel<Course> resModel=new ResponseModel<Course>();
			courseManagerMapper.insert(course);
			resModel.setStatus(200);
			resModel.setMsg("添加成功");
		return resModel;
	}
}
