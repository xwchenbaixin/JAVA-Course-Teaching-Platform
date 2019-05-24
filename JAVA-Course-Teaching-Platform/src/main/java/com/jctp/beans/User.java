package com.jctp.beans;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class User {
	private int id;
	private String name;
	
	@Pattern(regexp = "^��|Ů$",message = "�Ա�������л�Ů")
	private String sex;
	
	private String workNo;
	
	@Pattern(regexp = "^[1][3,4,5,6,7,8][0-9]{9}$",message = "�绰���벻��ȷ")
	private String phone;
	private int roleId;
	private int roleName;
	private int state;
	private int classId;
	private String className;
	
	@NotBlank(message = "���벻Ϊ��")
	@Size(max=16,min=8,message = "���볤����8-16λ")
	@Pattern(regexp = "^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{8,16}$",message = "������Ҫͬʱ�������ֺ���ĸ")
	private String password;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setNameString(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSexString(String sex) {
		this.sex = sex;
	}
	public String getWorkNo() {
		return workNo;
	}
	public void setWorkNo(String workNo) {
		this.workNo = workNo;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public int getRoleName() {
		return roleName;
	}
	public void setRoleName(int roleName) {
		this.roleName = roleName;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public int getClassId() {
		return classId;
	}
	public void setClassId(int classId) {
		this.classId = classId;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
