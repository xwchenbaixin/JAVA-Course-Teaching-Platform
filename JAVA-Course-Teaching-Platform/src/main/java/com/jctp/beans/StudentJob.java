package com.jctp.beans;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jctp.tools.StringTools;

public class StudentJob {
	private int id;
	private int courseId;
	private String jobName;
	private String description;
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Timestamp releaseDate;
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Timestamp endDate;
	private int totalScore;
	private int seq;
	private int type;
	//作业状态
	private int state;
	private String lastTime;
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Timestamp submitDate;
	
	private double score;
	private int studentId;
	private int jobId;
	
	
	public Timestamp getSubmitDate() {
		return submitDate;
	}
	public void setSubmitDate(Timestamp submitDate) {
		this.submitDate = submitDate;
	}
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public int getJobId() {
		return jobId;
	}
	public void setJobId(int jobId) {
		this.jobId = jobId;
	}
	public String getLastTime() {
		this.lastTime=StringTools.subDate(endDate);
		return this.lastTime;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	public String getJobName() {
		return jobName;
	}
	public void setJobName(String jobName) {
		this.jobName = jobName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Timestamp getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(Timestamp releaseDate) {
		this.releaseDate = releaseDate;
	}
	public Timestamp getEndDate() {
		return endDate;
	}
	public void setEndDate(Timestamp endDate) {
		this.endDate = endDate;
	}
	public int getTotalScore() {
		return totalScore;
	}
	public void setTotalScore(int totalScore) {
		this.totalScore = totalScore;
	}
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public void setLastTime(String lastTime) {
		this.lastTime = lastTime;
	}
	
	
}
