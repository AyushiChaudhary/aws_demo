package com.cg.oes.entity;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.SerializableString;

@Entity //indicates that this class is an entity class
@Table(name = "Attendance_detail") 
@SequenceGenerator(name="seq",initialValue = 3,allocationSize = 50)

public class Attendance implements SerializableString {
	
	@Id
	@Column(length=20)
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int serialno;
	
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="student_id",referencedColumnName="student_id")
	private Student studentId;
	
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="lecture_id",referencedColumnName="lecture_id")
    private Lecture lectureId;
	
	@Column(length=20)
    private String status;
    
	/**
	*Attendance()
	*description of method: creates attendance object
	*parameters: int serialno, Student studentId, Lecture lectureId, String password
	*returntype: Attendance  
	*method Type: contructor
	*authorName: Raushan
	*version 1.0
	*/

	
	public Attendance() {
		super();
		
	}

	public Attendance(int serialno, Student studentId, Lecture lectureId, String status) {
		super();
		this.serialno = serialno;
		this.studentId = studentId;
		this.lectureId = lectureId;
		this.status = status;
	}

	public int getSerialno() {
		return serialno;
	}

	public void setSerialno(int serialno) {
		this.serialno = serialno;
	}

	public Student getStudentId() {
		return studentId;
	}

	public void setStudentId(Student studentId) {
		this.studentId = studentId;
	}

	public Lecture getLectureId() {
		return lectureId;
	}

	public void setLectureId(Lecture lectureId) {
		this.lectureId = lectureId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Attendance [serialno=" + serialno + ", studentId=" + studentId + ", lectureId=" + lectureId
				+ ", status=" + status + "]";
	}

	@Override
	public String getValue() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int charLength() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public char[] asQuotedChars() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public byte[] asUnquotedUTF8() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public byte[] asQuotedUTF8() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int appendQuotedUTF8(byte[] buffer, int offset) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int appendQuoted(char[] buffer, int offset) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int appendUnquotedUTF8(byte[] buffer, int offset) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int appendUnquoted(char[] buffer, int offset) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int writeQuotedUTF8(OutputStream out) throws IOException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int writeUnquotedUTF8(OutputStream out) throws IOException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int putQuotedUTF8(ByteBuffer buffer) throws IOException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int putUnquotedUTF8(ByteBuffer out) throws IOException {
		// TODO Auto-generated method stub
		return 0;
	}

	
}


