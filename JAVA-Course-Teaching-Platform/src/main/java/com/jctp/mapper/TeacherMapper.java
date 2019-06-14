package com.jctp.mapper;

import java.util.List;

import com.jctp.beans.Course;
import com.jctp.beans.Homework;
import com.jctp.beans.Message;
import com.jctp.model.RequestModel;

public interface TeacherMapper {

	public List<Homework> listHomework(RequestModel<Homework> reqModel);
	public List<Message> listMeassge(RequestModel<Message> reqModel);
}
