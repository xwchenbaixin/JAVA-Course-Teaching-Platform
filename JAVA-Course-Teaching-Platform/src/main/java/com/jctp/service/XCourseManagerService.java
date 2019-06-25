package com.jctp.service;

import java.util.List;

import com.jctp.beans.Course;
import com.jctp.beans.CourseFile;
import com.jctp.model.RequestModel;
import com.jctp.model.ResponseModel;


public interface XCourseManagerService {	
	ResponseModel<Course> update(Course course);
	
	ResponseModel<Course> delete(Course course);

	ResponseModel<Course> insert(Course course);


	ResponseModel<Course> listCourse(RequestModel<Course> reqModel);

}
