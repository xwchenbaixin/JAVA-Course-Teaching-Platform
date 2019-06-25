package com.jctp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jctp.beans.User;
import com.jctp.model.RequestModel;
import com.jctp.model.ResponseModel;
import com.jctp.mapper.XTeacherManagerMapper;
import com.jctp.service.XTeacherManagerService;

@Service("teacherService")
public class XTeacherManagerServiceImpl implements XTeacherManagerService{
	@Autowired
	private XTeacherManagerMapper teacherManagerMapper;

	@Override
	@Transactional
	public ResponseModel<User> listTeacher(RequestModel<User> reqModel) {
		// TODO Auto-generated method stub
		int total=teacherManagerMapper.getTotal();
		List<User> userList=teacherManagerMapper.listTeacher(reqModel);
		
		return new ResponseModel<User>(userList, total);
	}

	@Override
	@Transactional
	public ResponseModel<User> update(User user) {
		ResponseModel<User> resModel=new ResponseModel<User>();
		int checkWorkNo=teacherManagerMapper.checkWorkNo(user);
		if(checkWorkNo==0) {
			teacherManagerMapper.update(user);
			resModel.setStatus(200);
			resModel.setMsg("修改成功");
		}
		else {
			resModel.setStatus(500);
			resModel.setMsg("请勿修改重复的'工号'");
		}
		return resModel;
	}

	@Override
	public ResponseModel<User> delete(User user) {
		int status=teacherManagerMapper.delete(user);
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
		int checkWorkNo=teacherManagerMapper.checkWorkNo(user);
		if(checkWorkNo==0) {
			teacherManagerMapper.insert(user);
			resModel.setStatus(200);
			resModel.setMsg("添加成功");
		}
		else {
			resModel.setStatus(500);
			resModel.setMsg("请勿添加重复的'工号'");
		}
		return resModel;
	}

	
}