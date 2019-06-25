package com.jctp.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

import com.jctp.beans.Course;
import com.jctp.beans.CourseJob;
import com.jctp.beans.StudentJob;
import com.jctp.beans.StudentQuestions;
import com.jctp.model.RequestModel;

public interface StudentMapper {

	@Select("SELECT Count(*) FROM JCTP_COURSE WHERE class_id=#{classId}")
	public int getCoursesTotal(@Param("classId") int classId);

	@Select("SELECT *,u.name as teacherName "
			+ "FROM JCTP_COURSE c LEFT JOIN JCTP_USER u ON c.teacher_id=u.id  "
			+ "LEFT JOIN JCTP_CLASS cz on c.class_id=cz.id "
			+ "WHERE c.class_id=#{classId}")
	public List<Course> listCourses(@Param("classId")int classId);

	public void updateJobSocre(CourseJob param);

	@Select("select * from JCTP_STUDENT_JOB sj left join JCTP_COURSE_JOB cj ON sj.job_id=cj.id WHERE cj.course_id=#{courseId} and sj.student_id=#{studentId} and sj.state in (${state})")
	public List<StudentJob> getStudentJobsList(@Param("courseId")int courseId, @Param("studentId")int studentId,@Param("state")String state);

	@Update("update JCTP_STUDENT_JOB SET STATE=#{state} where id=#{id}")
	public void updateJobState(@Param("id")int id, @Param("state")int state);

	//@Select("select Count(*) FROM jctp_student_job WHERE job_id=#{jid} and student_id=#{userId}")
	//public int checkStudentJob(@Param("jid")int jid,@Param("userId") int userId);

	@Select("select *,@seq := @seq+1 AS seq from JCTP_STUDENTS_QUESTIONS sq left join JCTP_QUESTIONS q on sq.question_id=q.id,(SELECT @seq:=0) s WHERE job_id=#{jid} and user_id=#{userId}")
	public List<StudentQuestions> getStudentQuestions(@Param("jid")int jid, @Param("userId")int userId);

	@Select("select * from JCTP_STUDENT_JOB sj left join JCTP_COURSE_JOB cj ON sj.job_id=cj.id WHERE sj.student_id=#{userId} and sj.job_id=#{jid}")
	public StudentJob getStudentJob(@Param("jid")int jid, @Param("userId")int userId);

	@Update("update JCTP_STUDENT_JOB SET STATE=1 where job_id=#{jid} and student_id=#{userId}")
	public void updateStudentJobStateByUserId(@Param("jid")int jid,@Param("userId") int userId);


	public void updateStudentQuestion(StudentQuestions sq);


}
