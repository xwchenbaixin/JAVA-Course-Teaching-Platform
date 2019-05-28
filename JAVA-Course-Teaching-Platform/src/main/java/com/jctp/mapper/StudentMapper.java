package com.jctp.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.jctp.beans.User;

@Mapper
public interface StudentMapper {
	@Select("SELECT * FROM JCTP_USER")
	List<User> listUsers();
}
