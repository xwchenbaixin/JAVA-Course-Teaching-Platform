package com.jctp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jctp.beans.CourseFile;
import com.jctp.model.RequestModel;
import com.jctp.model.ResponseModel;
import com.jctp.mapper.XZhiLiaoManagerMapper;
import com.jctp.service.XZhiLiaoManagerService;

@Service("zhiliaoService")
public class XZhiLiaoManagerServiceImpl implements XZhiLiaoManagerService{
	@Autowired
	private XZhiLiaoManagerMapper coursefileManagerMapper;

	@Override
	@Transactional
	public ResponseModel<CourseFile> listCourseFile(RequestModel<CourseFile> reqModel) {
		// TODO Auto-generated method stub
		int total=coursefileManagerMapper.getTotal();
		
		List<CourseFile> clzzList=coursefileManagerMapper.listCourseFile(reqModel);
		
		return new ResponseModel<CourseFile>(clzzList, total);
	}

	
	@Override
	public ResponseModel<CourseFile> delete(CourseFile coursefile) {
		int status=coursefileManagerMapper.delete(coursefile);
		ResponseModel<CourseFile> resModel=new ResponseModel<CourseFile>();
		if(status==1) {
			resModel.setStatus(200);
			resModel.setMsg("修改成功");
		}
		return resModel;
	}

	@Override
	public ResponseModel<CourseFile> insert(CourseFile coursefile) {
		ResponseModel<CourseFile> resModel=new ResponseModel<CourseFile>();
			coursefileManagerMapper.insert(coursefile);
			resModel.setStatus(200);
			resModel.setMsg("添加成功");
		return resModel;
	}
}
