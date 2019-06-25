package com.jctp.service;

import java.util.List;

import com.jctp.beans.CourseFile;
import com.jctp.model.RequestModel;
import com.jctp.model.ResponseModel;


public interface XZhiLiaoManagerService {	
	
	ResponseModel<CourseFile> delete(CourseFile coursefile);

	ResponseModel<CourseFile> insert(CourseFile coursefile);

	ResponseModel<CourseFile> listCourseFile(RequestModel<CourseFile> reqModel);

}
