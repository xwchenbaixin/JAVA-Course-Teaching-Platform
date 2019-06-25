package com.jctp.service;


import com.jctp.beans.Clzz;
import com.jctp.beans.Question;
import com.jctp.model.RequestModel;
import com.jctp.model.ResponseModel;


public interface XQuestionManagerService {
	ResponseModel<Question> listQuestion(RequestModel<Question> reqModel);
	
	ResponseModel<Question> update(Question question);

	ResponseModel<Question> delete(Question question);

	ResponseModel<Question> insert(Question question);
}
