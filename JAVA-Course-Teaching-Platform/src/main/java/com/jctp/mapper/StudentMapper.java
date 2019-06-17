package com.jctp.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

import com.jctp.beans.Course;
import com.jctp.beans.CourseJob;
import com.jctp.model.RequestModel;

public interface StudentMapper {

	@Select("SELECT Count(*) FROM JCTP_COURSE WHERE class_id=#{classId}")
	public int getCoursesTotal(@Param("classId") int classId);

	@Select("SELECT *,u.name as teacherName "
			+ "FROM JCTP_COURSE c LEFT JOIN JCTP_USER u ON c.teacher_id=u.id  "
			+ "LEFT JOIN JCTP_CLASS cz on c.class_id=cz.id "
			+ "WHERE c.class_id=#{classId}")
	@Results({
		@Result(column = "create_date",property = "createDate",jdbcType = JdbcType.VARCHAR)
	})
	public List<Course> listCourses(@Param("classId")int classId);

	public int getCourseJobsTotal();

	public List<CourseJob> listCourseJobs(RequestModel<CourseJob> reqModel);

	public String getJobAnswer(CourseJob param);

	public void updateJobSocre(CourseJob param);

}
