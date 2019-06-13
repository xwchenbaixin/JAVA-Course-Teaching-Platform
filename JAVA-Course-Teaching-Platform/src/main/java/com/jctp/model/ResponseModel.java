package com.jctp.model;

import java.util.List;

public class ResponseModel<T> {
	private List<T> rows;
	private int total;
	private int status;
	private String msg;
	public ResponseModel() {
		
	}
	public ResponseModel(List<T> rows,int total){
		this.rows=rows;
		this.total=total;
	}
	public List<T> getRows() {
		return rows;
	}
	public void setRows(List<T> rows) {
		this.rows = rows;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
}
