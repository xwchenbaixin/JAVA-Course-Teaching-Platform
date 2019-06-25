package com.jctp.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;
import org.junit.runners.Parameterized.Parameters;
import com.jctp.beans.Course;
import com.jctp.beans.CourseJob;
import com.jctp.beans.Homework;
import com.jctp.beans.Message;
import com.jctp.model.RequestModel;

public interface TeacherMapper {

	public List<Message> listMeassge(RequestModel<Message> reqModel);

	@Select("SELECT Count(*) FROM JCTP_COURSE WHERE teacher_id=#{teacherId}")
	public int getCourseTotal(@Param("teacherId")int teacherId);
	
	@Select("SELECT *,u.name as teacherName "
			+ "FROM JCTP_COURSE c LEFT JOIN JCTP_USER u ON c.teacher_id=u.id "
			+ "LEFT JOIN JCTP_CLASS cz on c.class_id=cz.id "
			+ "WHERE c.teacher_id=#{teacherId}")
	@Results({
		@Result(column="create_data",property="createData",jdbcType=JdbcType.VARCHAR)
	})
	public List<Course> listCourse(int teacherId);

	
	@Select("select * from JCTP_COURSE_JOB sj left join "
			+ "JCTP_COURSE cj ON sj.course_id=cj.id "
			+ "WHERE sj.course_id=#{courseId} and cj.teacher_id=#{teacherId}")
	public List<CourseJob> getCourseJobsList(@Param("courseId")int courseId, @Param("teacherId")int teacherId);

	//@Update("update JCTP_STUDENT_JOB SET STATE=#{state} where id=#{id}")
	//public void updateJobState(@Param("id")int id, @Param("state")int state);

	//public List<CourseJob> getCourseJobsList(@Param("courseId")int courseId, @Param("teacherId")int teacherId);

	public List<Homework> listHomework(RequestModel<Homework> reqModel);

}
