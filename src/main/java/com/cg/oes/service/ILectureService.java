package com.cg.oes.service;

import java.util.List;

import com.cg.oes.entity.Lecture;

public interface ILectureService {
	
	public Lecture addLecture(Lecture lecture);
	public Lecture searchLecture(int lectureId);
	public void deleteLecture(int lectureId);
	public Lecture updateLecture(Lecture lecture);
	public List<Lecture> displayLecture();

	

}

