package com.jctp.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.jctp.beans.Clzz;
import com.jctp.beans.Question;
import com.jctp.model.RequestModel;

@Mapper
public interface XQuestionManagerMapper {
	@Select("SELECT * FROM JCTP_QUESTIONS "
			+" WHERE question_name LIKE CONCAT('%',#{param.questionName},'%') OR question_type=#{param.questionType}"
			+ " ORDER BY ${pageModel.sort} ${pageModel.order} "
			+ "limit #{pageModel.offset},#{pageModel.limit} ")
	List<Question> listQuestion(RequestModel<Question> reqModel);

	@Select("SELECT COUNT(*) FROM JCTP_QUESTIONS")
	int getTotal();

	@Update("UPDATE JCTP_QUESTIONS SET question_name=#{questionName},question_type=#{questionType},answer=#{answer},seq=#{seq} WHERE id=#{id}")
	int  update(Question question);
	
	@Update("delete from JCTP_QUESTIONS  WHERE id=#{id}")
	int delete(Question question);
	
	@Insert("INSERT INTO JCTP_QUESTIONS(question_name,question_type,answer,seq) values(#{questionName},#{questionType},#{answer},#{seq})")
	int insert(Question question);

	
	
}
