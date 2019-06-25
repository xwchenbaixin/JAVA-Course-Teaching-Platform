package com.jctp.beans;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import com.jctp.tools.StringTools;

public class StudentQuestions {
	private int id;
	private int userId;
	private int jobId;
	private int questionId;
	private Timestamp date;
	private String upAnswer;
	private int state;
	
	private String questionName;
	private int questionType;
	private List<Map<String, String>> answer;
	private int seq;
	private List<Map<String, String>> select;
	private double questionScore;
	private double userScore;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getJobId() {
		return jobId;
	}
	public void setJobId(int jobId) {
		this.jobId = jobId;
	}
	public int getQuestionId() {
		return questionId;
	}
	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}
	public Timestamp getDate() {
		return date;
	}
	public void setDate(Timestamp date) {
		this.date = date;
	}
	public String getUpAnswer() {
		return upAnswer;
	}
	public void setUpAnswer(String upAnswer) {
		this.upAnswer = upAnswer;
	}
	
	public double getQuestionScore() {
		return questionScore;
	}
	public void setQuestionScore(double questionScore) {
		this.questionScore = questionScore;
	}
	public double getUserScore() {
		return userScore;
	}
	public void setUserScore(double userScore) {
		this.userScore = userScore;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public String getQuestionName() {
		return questionName;
	}
	public void setQuestionName(String questionName) {
		this.questionName = questionName;
	}
	public int getQuestionType() {
		return questionType;
	}
	public void setQuestionType(int questionType) {
		this.questionType = questionType;
	}
	public List<Map<String, String>> getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer=StringTools.jsonArrayToList(answer);
	}
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public List<Map<String, String>> getSelect() {
		return select;
	}
	public void setSelect(String select) {
		this.select = StringTools.jsonArrayToList(select);
	}
	
	
}
