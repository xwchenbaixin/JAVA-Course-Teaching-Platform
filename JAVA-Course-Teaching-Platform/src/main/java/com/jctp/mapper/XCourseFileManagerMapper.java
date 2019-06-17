package com.jctp.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.jctp.model.RequestModel;
import com.jctp.beans.CourseFile;

@Mapper
public interface XCourseFileManagerMapper {
	@Select("SELECT fil.id,fil.course_id,cla.class_no,cou.course_name,fil.type,fil.file_name,fil.file_path,fil.state FROM JCTP_COURSE_FILE fil left join JCTP_COURSE cou ON fil.course_id=cou.id"
			+ " left join JCTP_CLASS cla on cou.class_id=cla.id"
			+ " WHERE  file_name LIKE CONCAT('%',#{param.fileName},'%') and course_name LIKE CONCAT('%',#{param.courseName},'%') and class_no LIKE CONCAT('%',#{param.classNo},'%')"
			+ " ORDER BY ${pageModel.sort} ${pageModel.order} "
			+ "limit #{pageModel.offset},#{pageModel.limit} ")
	List<CourseFile> listCourseFile(RequestModel<CourseFile> reqModel);
	
	@Select("SELECT COUNT(*) FROM JCTP_COURSE_FILE")
	int getTotal();

	@Update("UPDATE JCTP_COURSE_FILE SET course_id=#{courseId},type=#{type},file_name=#{fileName},file_path=#{filePath},state=#{state} WHERE id=#{id}")
	int update(CourseFile coursefile);

	@Delete("DELETE FROM JCTP_COURSE_FILE WHERE id=#{id}")
	int delete(CourseFile coursefile);

	@Insert("INSERT INTO JCTP_COURSE_FILE(course_id,type,file_name,file_path,state) values(#{courseId},#{type},#{fileName},#{filePath},#{state})")
	int insert(CourseFile coursefile);
}
