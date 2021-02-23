package com.cg.oes.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity //indicates that this class is an entity class
@Table(name = "Teacher_detail") 
public class Teacher {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(length=20,name="teacher_id")
	private int teacherId;
	@Column(length=20,name="teacher_name")
	private String name;
	@Column(length=20)
	private String password;
	@Column(length=20)
	private String emailId;
	@Column(length=20)
	private String mobNo;
	@Column(length=20)
	private String subDomain;
	
	public Teacher() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	/**
	*Teacher()
	*description of method: creates teacher object
	*parameters: int studentd, String teacherName, String password, String password, String mobNo, String subDomain
	*returntype: Teacher  
	*method Type: contructor
	*authorName: Ruchi
	*version 1.0
	*/

	public Teacher(int teacherId, String name, String password, String emailId, String mobNo, String subDomain) {
		super();
		this.teacherId = teacherId;
		this.name = name;
		this.password = password;
		this.emailId = emailId;
		this.mobNo = mobNo;
		this.subDomain = subDomain;
	}

	public int getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getMobNo() {
		return mobNo;
	}

	public void setMobNo(String mobNo) {
		this.mobNo = mobNo;
	}

	public String getSubDomain() {
		return subDomain;
	}

	public void setSubDomain(String subDomain) {
		this.subDomain = subDomain;
	}

	@Override
	public String toString() {
		return "Teacher [teacherId=" + teacherId + ", name=" + name + ", password=" + password + ", emailId=" + emailId
				+ ", mobNo=" + mobNo + ", subDomain=" + subDomain + "]";
	}


	
}
