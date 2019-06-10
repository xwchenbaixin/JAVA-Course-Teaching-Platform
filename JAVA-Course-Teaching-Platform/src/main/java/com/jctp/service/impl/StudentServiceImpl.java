package com.jctp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jctp.beans.User1;
import com.jctp.mapper.StudentMapper;
import com.jctp.service.StudentService;

@Service("studentService")
public class StudentServiceImpl implements StudentService{
	@Autowired
	private StudentMapper studentDao;
	
	@Override
	public List<User1> listUsers() {
		// TODO Auto-generated method stub
		return studentDao.listUsers();
	}

	
}
