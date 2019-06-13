package com.jctp.service;

import java.util.List;

import com.jctp.beans.User;
import com.jctp.model.PageModel;
import com.jctp.model.RequestModel;
import com.jctp.model.ResponseModel;


public interface StudentManagerService {	
	ResponseModel<User> update(User user);

	ResponseModel<User> listUsers(RequestModel<User> reqModel);

	ResponseModel<User> delete(User user);

	ResponseModel<User> insert(User user);
}
