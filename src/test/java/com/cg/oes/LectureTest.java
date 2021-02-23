package com.cg.oes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import com.cg.oes.entity.Lecture;
import com.cg.oes.entity.Student;
import com.cg.oes.entity.Teacher;
import com.cg.oes.repository.ILectureRepository;
import com.cg.oes.repository.IStudentRepository;
import com.cg.oes.service.ILectureService;
import com.cg.oes.service.LectureServiceImpl;
import com.cg.oes.service.StudentService;
import com.cg.oes.service.StudentServiceImpl;

class LectureTest {

	@Autowired
	private ILectureService service;
	
	@MockBean
	private ILectureRepository dao;
	
	@InjectMocks
    LectureServiceImpl studentServiceImpl;
	
	@Test
	public void addLectureTest() throws Exception {
		Lecture lecture = new Lecture(111,new Teacher(3, "Suraj", "suraj@gmail.com", "suraj23@99", "9749898566","Hindi"),"English",LocalTime.of(10,43,12),LocalTime.now());
		ILectureService service = mock(LectureServiceImpl.class);
		when(service.addLecture(lecture)).thenReturn(lecture);
		System.out.println(lecture.toString());
		Lecture t = service.addLecture(lecture);
		assertEquals(lecture, t);
	} 
	
	@Test
	public void viewAllLectureTest() throws Exception {
		List<Lecture> login = new ArrayList<Lecture>();
		login.add(new Lecture(111, new Teacher(1, "Manoj", "manoj@gmail.com", "manoj@99", "9745684566","physics"),"English",LocalTime.of(10,43,12),LocalTime.now()));
		login.add(new Lecture(112,new Teacher(2, "Ruchi", "ruchi@gmail.com", "ruchi23@99", "9749898566","English"),"Hindi",LocalTime.of(10,43,12),LocalTime.now()));
		login.add(new Lecture(113,new Teacher(3, "Suraj", "suraj@gmail.com", "suraj23@99", "9749898566","Hindi"),"science",LocalTime.of(10,43,12),LocalTime.now()));
		ILectureService service = mock(LectureServiceImpl.class);
		when(service.displayLecture()).thenReturn(login);
		System.out.println(login.toString());
		List<Lecture> log1 = service.displayLecture();
		assertNotNull(log1);
		assertFalse(log1.isEmpty());
	}
	
	@Test
	public void getLectureTest() throws Exception {
		Lecture lecture = new Lecture(111,new Teacher(3, "Suraj", "suraj@gmail.com", "suraj23@99", "9749898566","Hindi"),"English",LocalTime.of(10,43,12),LocalTime.now());
		ILectureService service = mock(LectureServiceImpl.class);
		when(service.searchLecture(111)).thenReturn(lecture);
		System.out.println(lecture.toString());
		Lecture log1 = service.searchLecture(111);
		assertNotNull(log1);
	}

}
