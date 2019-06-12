package com.jctp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jctp.beans.User;
import com.jctp.common.ResponseModel;
import com.jctp.mapper.StudentManagerMapper;
import com.jctp.service.StudentManagerService;

@Service("studentService")
public class StudentManagerServiceImpl implements StudentManagerService{
	@Autowired
	private StudentManagerMapper studentManagerMapper;

	@Override
	@Transactional
	public ResponseModel<User> listUsers(int offset, int pageSize) {
		// TODO Auto-generated method stub
		int total=studentManagerMapper.getTotal();
		
		List<User> userList=studentManagerMapper.listUsers(offset,pageSize);
		
		return new ResponseModel<User>(userList, total);
	}

	@Override
	public int update(User user) {
		// TODO Auto-generated method stub
		return studentManagerMapper.update(user);
	}

	
}
