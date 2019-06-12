package com.jctp.service;

import java.util.List;

import com.jctp.beans.User;
import com.jctp.common.ResponseModel;


public interface StudentManagerService {
	ResponseModel<User> listUsers (int offset, int pageSize);
	
	int update(User user);
}
