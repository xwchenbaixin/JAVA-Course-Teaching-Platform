package com.jctp.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.jctp.beans.User;

@Mapper
public interface StudentManagerMapper {
	@Select("SELECT * FROM JCTP_USER WHERE state=1 limit #{offset},#{pageSize} ")
	List<User> listUsers(@Param("offset")int offset, @Param("pageSize")int pageSize);

	@Select("SELECT COUNT(*) FROM JCTP_USER WHERE STATE=1")
	int getTotal();

	@Update("UPDATE JCTP_USER SET work_no=#{workNo},name=#{name},sex=#{sex} WHERE id=#{id}")
	int update(User user);
}
