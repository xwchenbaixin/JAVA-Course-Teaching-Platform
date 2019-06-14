package com.jctp.service;

import java.util.List;

import com.jctp.beans.CourseFile;
import com.jctp.model.RequestModel;
import com.jctp.model.ResponseModel;


public interface XCourseFileManagerService {	
	ResponseModel<CourseFile> update(CourseFile coursefile);
	
	ResponseModel<CourseFile> delete(CourseFile coursefile);

	ResponseModel<CourseFile> insert(CourseFile coursefile);

	ResponseModel<CourseFile> listCourseFile(RequestModel<CourseFile> reqModel);

}
