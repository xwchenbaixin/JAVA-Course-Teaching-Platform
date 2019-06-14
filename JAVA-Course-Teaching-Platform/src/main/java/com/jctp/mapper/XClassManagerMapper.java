package com.jctp.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.jctp.beans.Clzz;
import com.jctp.model.RequestModel;

@Mapper
public interface XClassManagerMapper {
	@Select("SELECT * FROM JCTP_CLASS"
			+" WHERE college LIKE CONCAT('%',#{param.college},'%') OR id=#{param.college}"
			+ " ORDER BY ${pageModel.sort} ${pageModel.order} "
			+ "limit #{pageModel.offset},#{pageModel.limit} ")
	List<Clzz> listClass(RequestModel<Clzz> reqModel);

	@Select("SELECT COUNT(*) FROM JCTP_CLASS")
	int getTotal();

	@Update("UPDATE JCTP_CLASS SET college=#{college} WHERE id=#{id}")
	int  update(Clzz clzz);
	
	@Update("delete from JCTP_CLASS  WHERE id=#{id}")
	int delete(Clzz clzz);
	
	@Insert("INSERT INTO JCTP_CLASS(id,college) values(#{id},#{college})")
	int insert(Clzz clzz);

	
	
}
