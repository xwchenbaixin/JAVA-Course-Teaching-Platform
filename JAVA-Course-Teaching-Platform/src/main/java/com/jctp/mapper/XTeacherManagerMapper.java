package com.jctp.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.jctp.beans.User;
import com.jctp.model.RequestModel;
import com.jctp.beans.Constants;

@Mapper
public interface XTeacherManagerMapper {
	@Select("SELECT * FROM JCTP_USER "
			+ "WHERE state=1 and name LIKE CONCAT('%',#{param.name},'%') and work_no LIKE CONCAT('%',#{param.workNo},'%' ) and role_id="+Constants.TEACHER 
			+ " ORDER BY ${pageModel.sort} ${pageModel.order} "
			+ "limit #{pageModel.offset},#{pageModel.limit} ")
	List<User> listStudent(RequestModel<User> reqModel);

	@Select("SELECT COUNT(*) FROM JCTP_USER WHERE STATE=1 AND role_id="+Constants.TEACHER)
	int getTotal();

	@Update("UPDATE JCTP_USER SET work_no=#{workNo},name=#{name},sex=#{sex} WHERE id=#{id}")
	int update(User user);

	@Delete("DELETE FROM JCTP_USER WHERE id=#{id}")
	int delete(User user);

	@Insert("INSERT INTO JCTP_USER(class_id,role_id,phone,work_no,name,sex,state,password) values(#{classId},2,#{phone},#{workNo},#{name},#{sex},1,"+Constants.MIMA+")")
	int insert(User user);
	
	@Select("SELECT COUNT(*) FROM JCTP_USER WHERE work_no=#{workNo} and id<>#{id}")
	int checkWorkNo(User user);
	
}
