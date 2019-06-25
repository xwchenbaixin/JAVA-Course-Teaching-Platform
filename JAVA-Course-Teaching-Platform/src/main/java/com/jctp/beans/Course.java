package com.jctp.beans;

import java.sql.Date;

public class Course {
	private int id;
	private String classId;
	private String teacherId;
	private String workNo;
	private String courseName;
	private String teachername;
	private String teacherName;
	private String createDate;
	private int grade;
	private int term;
	private String classNo;
	private String courseImg;
	
	
	
	public String getTeacherName() {
		return teacherName;
	}
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
		this.teachername = teacherName;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	
	public String getCourseImg() {
		return courseImg;
	}
	public void setCourseImg(String courseImg) {
		this.courseImg = courseImg;
	}
	public String getClassNo() {
		return classNo;
	}
	public void setClassNo(String classNo) {
		this.classNo = classNo;
	}
	public String getWorkNo() {
		return workNo;
	}
	public void setWorkNo(String workNo) {
		this.workNo = workNo;
	}
	public String getTeachername() {
		return teachername;
	}
	public void setTeachername(String teachername) {
		this.teacherName=teachername;
		this.teachername = teachername;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getClassId() {
		return classId;
	}
	public void setClassId(String classId) {
		this.classId = classId;
	}
	public String getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(String teacherId) {
		this.teacherId = teacherId;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public int getTerm() {
		return term;
	}
	public void setTerm(int term) {
		this.term = term;
	}
}
