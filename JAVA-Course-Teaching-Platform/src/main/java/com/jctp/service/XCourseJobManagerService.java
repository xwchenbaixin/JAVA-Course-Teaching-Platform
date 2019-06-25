package com.jctp.service;

import java.util.List;

import com.jctp.beans.Course;
import com.jctp.beans.CourseFile;
import com.jctp.beans.CourseJob;
import com.jctp.model.RequestModel;
import com.jctp.model.ResponseModel;


public interface XCourseJobManagerService {	
	ResponseModel<CourseJob> update(CourseJob course);
	
	ResponseModel<CourseJob> delete(CourseJob course);

	ResponseModel<CourseJob> insert(CourseJob course);


	ResponseModel<CourseJob> listCourse(RequestModel<CourseJob> reqModel);


}
