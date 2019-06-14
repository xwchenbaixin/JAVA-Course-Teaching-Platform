package com.jctp.service;


import com.jctp.beans.Clzz;
import com.jctp.model.RequestModel;
import com.jctp.model.ResponseModel;


public interface XClassManagerService {
	ResponseModel<Clzz> listClass(RequestModel<Clzz> reqModel);
	
	ResponseModel<Clzz> update(Clzz clzz);

	ResponseModel<Clzz> delete(Clzz clzz);

	ResponseModel<Clzz> insert(Clzz clzz);
}
