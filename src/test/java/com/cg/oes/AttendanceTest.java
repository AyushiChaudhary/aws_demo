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

import com.cg.oes.entity.Attendance;
import com.cg.oes.entity.Lecture;
import com.cg.oes.entity.Student;
import com.cg.oes.entity.Teacher;
import com.cg.oes.repository.IAttendanceRepository;
import com.cg.oes.service.AttendanceServiceImpl;
import com.cg.oes.service.IAttendanceService;
import com.cg.oes.service.StudentService;
import com.cg.oes.service.StudentServiceImpl;

class AttendanceTest {

	@Autowired
	private IAttendanceService service;
	
	@MockBean
	private IAttendanceRepository dao;
	
	@InjectMocks
    AttendanceServiceImpl attendanceServiceImpl;
	
	@Test
	public void addAttendanceTest() throws Exception {
		Attendance attendance = new Attendance(23, new Student(12, "Ayushi","suraj",335, "ayushi@99", "9749984566","ayushi@gmail.com") , 
				new Lecture(111,new Teacher(3, "Suraj", "suraj@gmail.com", "suraj23@99", "9749898566","Hindi"),"English",
						LocalTime.of(10,43,12),LocalTime.now()), "Absent");
		IAttendanceService service = mock(AttendanceServiceImpl.class);
		when(service.addAttendance(attendance)).thenReturn(attendance);
		System.out.println(attendance.toString());
		Attendance t = service.addAttendance(attendance);
		assertEquals(attendance, t);
	}
	
	@Test
	public void viewAllAttendanceTest() throws Exception {
		List<Attendance> login = new ArrayList<Attendance>();
		login.add(new Attendance(23, new Student(12, "Ayushi","suraj",335, "ayushi@99", "9749984566","ayushi@gmail.com") , 
				new Lecture(111,new Teacher(3, "Suraj", "suraj@gmail.com", "suraj23@99", "9749898566","Hindi"),"English",
						LocalTime.of(10,43,12),LocalTime.now()), "Absent"));
		login.add(new Attendance(23, new Student(12, "Ayushi","suraj",335, "ayushi@99", "9749984566","ayushi@gmail.com")
				,new Lecture(111,new Teacher(3, "Suraj", "suraj@gmail.com", "suraj23@99", "9749898566","Hindi"),"English",
						LocalTime.of(10,43,12),LocalTime.now()), "Absent"));
		login.add(new Attendance(23, new Student(12, "Ayushi","suraj",335, "ayushi@99", "9749984566","ayushi@gmail.com")
				,new Lecture(111,new Teacher(3, "Suraj", "suraj@gmail.com", "suraj23@99", "9749898566","Hindi"),"English",
						LocalTime.of(10,43,12),LocalTime.now()), "Absent"));
		IAttendanceService service = mock(AttendanceServiceImpl.class);
		when(service.displayAttendance()).thenReturn(login);
		System.out.println(login.toString());
		List<Attendance> log1 = service.displayAttendance();
		assertNotNull(log1);
		assertFalse(log1.isEmpty());
	}
	
	
}
