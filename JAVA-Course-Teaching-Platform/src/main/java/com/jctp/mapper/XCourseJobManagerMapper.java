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
import com.jctp.beans.CourseJob;
import com.jctp.model.RequestModel;

@Mapper
public interface XCourseJobManagerMapper {

	@Select("SELECT COUNT(*) FROM JCTP_COURSE_JOB")
	int getTotal();

	@Update("UPDATE JCTP_COURSE_JOB SET course_id=#{courseId},job_name=#{jobName},description=#{description},release_data=#{releaseData},end_date=#{endDate},seq=#{seq},total_socre=#{totalSocre} WHERE id=#{id}")
	int update(CourseJob course);

	@Delete("DELETE FROM JCTP_COURSE_JOB WHERE id=#{id}")
	int delete(CourseJob course);

	@Insert("INSERT INTO JCTP_COURSE_JOB (course_id,job_name,description,release_data,end_date,seq,total_socre) values(#{courseId},#{jobName},#{description},#{releaseData},#{endDate},#{seq},#{totalSocre})")
	int insert(CourseJob course);

	List<CourseJob> listCourse(RequestModel<CourseJob> reqModel);
}
