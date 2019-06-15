package com.jctp.service.impl;

import org.springframework.stereotype.Service;

import com.jctp.beans.Homework;
import com.jctp.beans.Message;
import com.jctp.model.RequestModel;
import com.jctp.model.ResponseModel;
import com.jctp.service.TeacherService;

@Service
public class TeacherServiceImpl implements TeacherService{

	@Override
	public ResponseModel<Homework> listHomework(RequestModel<Homework> reqModel) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseModel<Message> listMessage(RequestModel<Message> reqModel) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
