package com.cg.oes.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="Student_detail")	
@SequenceGenerator(name="seq",initialValue = 5,allocationSize = 50)


public class Student {
	@Id 
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seq")
	@Column(length=12, name="student_id") 
	private int studentId;
	@Column(length=15)
	private String studentName;
	@Column(length=15)
	private String fatherName;
	@Column(length=8)
	private int rollNo;
	@Column(length=10)
	private String mobileNo;
	@Column
	private String emailId;
	@Column
	private String password;
	
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	*Student()
	*description of method: creates attendance object
	*parameters: String mobileNo ,Long studentId, Lecture lectureId, String studentName ,String fatherName, Long rollNo, String emailId, String password
	*returntype: Student 
	*method Type: contructor
	*authorName: Divyansh
	*version 1.0
	*/

	public Student(int studentId, String studentName, String fatherName, int rollNo, String mobileNo, String emailId,
			String password) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.fatherName = fatherName;
		this.rollNo = rollNo;
		this.mobileNo = mobileNo;
		this.emailId = emailId;
		this.password = password;
	}
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getFatherName() {
		return fatherName;
	}
	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}
	public int getRollNo() {
		return rollNo;
	}
	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", studentName=" + studentName + ", fatherName=" + fatherName
				+ ", rollNo=" + rollNo + ", mobileNo=" + mobileNo + ", emailId=" + emailId + ", password=" + password
				+ "]";
	}
	
}
