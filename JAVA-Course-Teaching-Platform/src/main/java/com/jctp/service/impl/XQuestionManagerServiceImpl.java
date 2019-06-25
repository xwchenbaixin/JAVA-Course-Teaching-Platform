package com.jctp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jctp.beans.Clzz;
import com.jctp.beans.Question;
import com.jctp.beans.User;
import com.jctp.model.RequestModel;
import com.jctp.model.ResponseModel;
import com.jctp.mapper.XClassManagerMapper;
import com.jctp.mapper.XQuestionManagerMapper;
import com.jctp.mapper.XStudentManagerMapper;
import com.jctp.service.XClassManagerService;
import com.jctp.service.XQuestionManagerService;
import com.jctp.service.XStudentManagerService;

@Service("questionService")
public class XQuestionManagerServiceImpl implements XQuestionManagerService{
	@Autowired
	private XQuestionManagerMapper questionManagerMapper;

	@Override
	@Transactional
	public ResponseModel<Question> listQuestion(RequestModel<Question> reqModel) {
		// TODO Auto-generated method stub
		int total=questionManagerMapper.getTotal();
		
		List<Question> clzzList=questionManagerMapper.listQuestion(reqModel);
		
		return new ResponseModel<Question>(clzzList, total);
	}

	@Override
	@Transactional
	public ResponseModel<Question> update(Question question) {
		ResponseModel<Question> resModel=new ResponseModel<Question>();
			questionManagerMapper.update(question);
			resModel.setStatus(200);
			resModel.setMsg("修改成功");
		return resModel;
	}

	@Override
	public ResponseModel<Question> delete(Question question) {
		int status=questionManagerMapper.delete(question);
		ResponseModel<Question> resModel=new ResponseModel<Question>();
		if(status==1) {
			resModel.setStatus(200);
			resModel.setMsg("修改成功");
		}
		return resModel;
	}

	@Override
	public ResponseModel<Question> insert(Question question) {
		ResponseModel<Question> resModel=new ResponseModel<Question>();
			questionManagerMapper.insert(question);
			resModel.setStatus(200);
			resModel.setMsg("添加成功");
		return resModel;
	}
}
