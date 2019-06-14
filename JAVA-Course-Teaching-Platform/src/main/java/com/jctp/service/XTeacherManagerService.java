package com.jctp.service;

import java.util.List;

import com.jctp.beans.User;
import com.jctp.model.PageModel;
import com.jctp.model.RequestModel;
import com.jctp.model.ResponseModel;


public interface XTeacherManagerService {	
	ResponseModel<User> update(User user);

	ResponseModel<User> listTeacher(RequestModel<User> reqModel);

	ResponseModel<User> delete(User user);

	ResponseModel<User> insert(User user);
}
