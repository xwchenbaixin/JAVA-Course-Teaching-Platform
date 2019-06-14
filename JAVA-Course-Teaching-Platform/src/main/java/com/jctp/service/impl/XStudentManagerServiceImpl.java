package com.jctp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jctp.beans.User;
import com.jctp.model.RequestModel;
import com.jctp.model.ResponseModel;
import com.jctp.mapper.XStudentManagerMapper;
import com.jctp.service.XStudentManagerService;

@Service("studentService")
public class XStudentManagerServiceImpl implements XStudentManagerService{
	@Autowired
	private XStudentManagerMapper studentManagerMapper;

	@Override
	@Transactional
	public ResponseModel<User> listStudent(RequestModel<User> reqModel) {
		// TODO Auto-generated method stub
		int total=studentManagerMapper.getTotal();
		
		List<User> userList=studentManagerMapper.listStudent(reqModel);
		
		return new ResponseModel<User>(userList, total);
	}

	@Override
	@Transactional
	public ResponseModel<User> update(User user) {
		ResponseModel<User> resModel=new ResponseModel<User>();
		int checkWorkNo=studentManagerMapper.checkWorkNo(user);
		if(checkWorkNo==0) {
			studentManagerMapper.update(user);
			resModel.setStatus(200);
			resModel.setMsg("修改成功");
		}
		else {
			resModel.setStatus(500);
			resModel.setMsg("请勿修改重复的'学号'");
		}
		return resModel;
	}

	@Override
	public ResponseModel<User> delete(User user) {
		int status=studentManagerMapper.delete(user);
		ResponseModel<User> resModel=new ResponseModel<User>();
		if(status==1) {
			resModel.setStatus(200);
			resModel.setMsg("修改成功");
		}
		return resModel;
	}

	@Override
	public ResponseModel<User> insert(User user) {
		ResponseModel<User> resModel=new ResponseModel<User>();
		int checkWorkNo=studentManagerMapper.checkWorkNo(user);
		if(checkWorkNo==0) {
			studentManagerMapper.insert(user);
			resModel.setStatus(200);
			resModel.setMsg("添加成功");
		}
		else {
			resModel.setStatus(500);
			resModel.setMsg("请勿添加重复的'学号'");
		}
		return resModel;
	}

	
}
