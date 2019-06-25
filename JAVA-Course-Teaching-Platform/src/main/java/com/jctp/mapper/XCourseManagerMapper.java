package com.jctp.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

import com.jctp.beans.Course;
import com.jctp.model.RequestModel;

@Mapper
public interface XCourseManagerMapper {
	@Select("SELECT fil.id,fil.class_id,fil.teacher_id,cou.work_no,fil.course_name,fil.create_date,fil.grade,fil.term,fil.course_img,cou.name AS teachername FROM JCTP_COURSE fil left join JCTP_USER cou ON fil.teacher_id=cou.id"
			+ " left join JCTP_CLASS cla on fil.class_id=cla.class_no"
			+ " WHERE  course_name LIKE CONCAT('%',#{param.courseName},'%') and cou.work_no LIKE CONCAT('%',#{param.workNo},'%') and fil.class_id LIKE CONCAT('%',#{param.classId},'%')"
			+ " ORDER BY ${pageModel.sort} ${pageModel.order} "
			+ "limit #{pageModel.offset},#{pageModel.limit} ")
	@Results({ 
	    @Result(column = "create_date",property = "createDate",  jdbcType=JdbcType.VARCHAR), 
		})
	List<Course> listCourse(RequestModel<Course> reqModel);

	@Select("SELECT COUNT(*) FROM JCTP_COURSE")
	int getTotal();

	@Update("UPDATE JCTP_COURSE SET class_id=#{classId},teacher_id=#{teacherId},course_name=#{courseName},create_date=#{createDate},grade=#{grade},term=#{term},course_img=#{courseImg} WHERE id=#{id}")
	int update(Course course);

	@Delete("DELETE FROM JCTP_COURSE WHERE id=#{id}")
	int delete(Course course);

	@Insert("INSERT INTO JCTP_COURSE(class_id,teacher_id,course_name,create_date,grade,term,course_img) values(#{classId},#{teacherId},#{courseName},#{createDate},#{grade},#{term},#{courseImg})")
	int insert(Course course);
}
