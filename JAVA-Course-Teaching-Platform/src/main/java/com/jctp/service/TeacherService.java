package com.jctp.service;


import com.jctp.beans.Course;
import com.jctp.beans.CourseJob;

import com.jctp.beans.Homework;
import com.jctp.beans.Message;
import com.jctp.model.RequestModel;
import com.jctp.model.ResponseModel;

public interface TeacherService {

	ResponseModel<Message> listMessage(RequestModel<Message> reqModel);


	ResponseModel<Homework> update(Homework homework);

	ResponseModel<Homework> delete(Homework homework);

	ResponseModel<Homework> inesrt(Homework homework);


	//ResponseModel<CourseJob> listCourseJobs(int teacher_id);


	ResponseModel<Course> listCourse(int teacher_id);


	ResponseModel<CourseJob> listCourseJobs(RequestModel<CourseJob> reqModel, int teacher_id);





	ResponseModel<Homework> listHomework(RequestModel<Homework> reqModel);



	
}
