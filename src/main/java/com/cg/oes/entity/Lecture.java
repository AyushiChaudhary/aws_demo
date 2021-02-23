package com.cg.oes.entity;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.SerializableString;

@Entity //indicates that this class is an entity class
@Table(name = "Lecture_detail") 

public class Lecture implements SerializableString  {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(length=20,name="lecture_id")
	private int lectureId;
	
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="teacher_id",referencedColumnName="teacher_id")
    private Teacher teacherId;
	
	@Column(length=20)
	private String lectureName;
	@Column(length=20)
	private LocalTime startLectureTime;
	@Column(length=20)
	private LocalTime endLectureTime;
	public Lecture(int lectureId, Teacher teacherId, String lectureName, LocalTime startLectureTime,
			LocalTime endLectureTime) {
		super();
		this.lectureId = lectureId;
		this.teacherId = teacherId;
		this.lectureName = lectureName;
		this.startLectureTime = startLectureTime;
		this.endLectureTime = endLectureTime;
	}
	
	/**
	*Lecture()
	*description of method: creates lecture object
	*parameters: String lectureName, LocalTime startLectureTime,LocalTime endLectureTime, int lectureId, Teacher teacherId
	*returntype: Lecture  
	*method Type: contructor
	*authorName: Manoj Chauhan
	*version 1.0
	*/
	
	public Lecture() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getLectureId() {
		return lectureId;
	}
	public void setLectureId(int lectureId) {
		this.lectureId = lectureId;
	}
	public Teacher getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(Teacher teacherId) {
		this.teacherId = teacherId;
	}
	public String getLectureName() {
		return lectureName;
	}
	public void setLectureName(String lectureName) {
		this.lectureName = lectureName;
	}
	public LocalTime getStartLectureTime() {
		return startLectureTime;
	}
	public void setStartLectureTime(LocalTime startLectureTime) {
		this.startLectureTime = startLectureTime;
	}
	public LocalTime getEndLectureTime() {
		return endLectureTime;
	}
	public void setEndLectureTime(LocalTime endLectureTime) {
		this.endLectureTime = endLectureTime;
	}
	@Override
	public String toString() {
		return "Lecture [lectureId=" + lectureId + ", teacherId=" + teacherId + ", lectureName=" + lectureName
				+ ", startLectureTime=" + startLectureTime + ", endLectureTime=" + endLectureTime + "]";
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