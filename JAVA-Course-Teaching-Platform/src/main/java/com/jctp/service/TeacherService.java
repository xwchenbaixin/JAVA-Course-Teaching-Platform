package com.jctp.service;

import com.jctp.beans.Homework;
import com.jctp.beans.Message;
import com.jctp.model.RequestModel;
import com.jctp.model.ResponseModel;

public interface TeacherService {

	ResponseModel<Homework> listHomework(RequestModel<Homework> reqModel);

	ResponseModel<Message> listMessage(RequestModel<Message> reqModel);

	
}
