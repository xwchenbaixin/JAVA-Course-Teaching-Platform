package com.jctp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jctp.beans.Clzz;
import com.jctp.beans.User;
import com.jctp.model.RequestModel;
import com.jctp.model.ResponseModel;
import com.jctp.mapper.XClassManagerMapper;
import com.jctp.mapper.XStudentManagerMapper;
import com.jctp.service.XClassManagerService;
import com.jctp.service.XStudentManagerService;

@Service("classService")
public class XClassManagerServiceImpl implements XClassManagerService{
	@Autowired
	private XClassManagerMapper classManagerMapper;

	@Override
	@Transactional
	public ResponseModel<Clzz> listClass(RequestModel<Clzz> reqModel) {
		// TODO Auto-generated method stub
		int total=classManagerMapper.getTotal();
		
		List<Clzz> clzzList=classManagerMapper.listClass(reqModel);
		
		return new ResponseModel<Clzz>(clzzList, total);
	}

	@Override
	@Transactional
	public ResponseModel<Clzz> update(Clzz clzz) {
		ResponseModel<Clzz> resModel=new ResponseModel<Clzz>();
			classManagerMapper.update(clzz);
			resModel.setStatus(200);
			resModel.setMsg("修改成功");
		return resModel;
	}

	@Override
	public ResponseModel<Clzz> delete(Clzz clzz) {
		int status=classManagerMapper.delete(clzz);
		ResponseModel<Clzz> resModel=new ResponseModel<Clzz>();
		if(status==1) {
			resModel.setStatus(200);
			resModel.setMsg("修改成功");
		}
		return resModel;
	}

	@Override
	public ResponseModel<Clzz> insert(Clzz clzz) {
		ResponseModel<Clzz> resModel=new ResponseModel<Clzz>();
			classManagerMapper.insert(clzz);
			resModel.setStatus(200);
			resModel.setMsg("添加成功");
		return resModel;
	}
}
