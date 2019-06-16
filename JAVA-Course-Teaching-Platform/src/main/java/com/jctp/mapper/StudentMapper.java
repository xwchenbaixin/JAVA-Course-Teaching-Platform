package com.jctp.mapper;

import java.util.List;

import com.jctp.beans.Course;
import com.jctp.beans.CourseJob;
import com.jctp.model.RequestModel;

public interface StudentMapper {

	public int getCoursesTotal();

	public List<Course> listCourses(RequestModel<Course> reqModel);

	public int getCourseJobsTotal();

	public List<CourseJob> listCourseJobs(RequestModel<CourseJob> reqModel);

	public String getJobAnswer(CourseJob param);

	public void updateJobSocre(CourseJob param);

}
