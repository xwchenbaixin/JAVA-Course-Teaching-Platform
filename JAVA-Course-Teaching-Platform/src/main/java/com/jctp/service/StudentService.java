package com.jctp.service;

import java.util.List;
import java.util.Map;

import org.springframework.ui.Model;

import com.jctp.beans.Course;
import com.jctp.beans.CourseJob;
import com.jctp.beans.StudentJob;
import com.jctp.beans.StudentQuestions;
import com.jctp.model.JobModel;
import com.jctp.model.RequestModel;
import com.jctp.model.ResponseModel;

public interface StudentService {
	ResponseModel<Course> listCourses(int classId);
	ResponseModel<StudentJob> listCourseJobs(RequestModel<StudentJob> reqModel, int studentId);
	Map<String, List<StudentQuestions>> doJob(int jid, int userId,Model model);
	ResponseModel<StudentQuestions> submitJob(JobModel jm);
}
