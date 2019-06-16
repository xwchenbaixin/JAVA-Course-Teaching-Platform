package com.jctp.service;

import com.jctp.beans.Course;
import com.jctp.beans.CourseJob;
import com.jctp.model.RequestModel;
import com.jctp.model.ResponseModel;

public interface StudentService {
	ResponseModel<Course> listCourses(RequestModel<Course> reqModel);
	ResponseModel<CourseJob> listCourseJobs(RequestModel<CourseJob> reqModel);
	ResponseModel<CourseJob> submitJob(CourseJob courseJob); 
}
