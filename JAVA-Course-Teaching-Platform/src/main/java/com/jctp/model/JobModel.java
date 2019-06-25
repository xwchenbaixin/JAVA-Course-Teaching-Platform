package com.jctp.model;

import java.util.List;

import com.jctp.beans.StudentJob;
import com.jctp.beans.StudentQuestions;

public class JobModel {
	private int jid;
	private List<StudentQuestions> questions;
	public int getJid() {
		return jid;
	}
	public void setJid(int jid) {
		this.jid = jid;
	}
	public List<StudentQuestions> getQuestions() {
		return questions;
	}
	public void setQuestions(List<StudentQuestions> questions) {
		this.questions = questions;
	}
	
	
	
}
