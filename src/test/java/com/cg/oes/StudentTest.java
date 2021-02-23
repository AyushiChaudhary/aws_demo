package com.cg.oes;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import com.cg.oes.entity.Student;
import com.cg.oes.entity.Teacher;
import com.cg.oes.repository.IStudentRepository;
import com.cg.oes.service.StudentService;
import com.cg.oes.service.StudentServiceImpl;
class StudentTest {

	/*@Test
	void test() {
		fail("Not yet implemented");
	}*/
	
	@Autowired
	private StudentService service;
	
	@MockBean
	private IStudentRepository dao;
	
	@InjectMocks
    StudentServiceImpl studentServiceImpl;
	
	@Test
	public void addStudentTest() throws Exception {
		Student student = new Student(11, "Manoj","Pankaj",345, "manoj@99", "9745684566","Manoj@gmail.com");
		StudentService service = mock(StudentServiceImpl.class);
		when(service.saveStudent(student)).thenReturn(student);
		System.out.println(student.toString());
		Student t = service.saveStudent(student);
		assertEquals(student, t);
	}
	
	@Test
	public void viewAllStudentTest() throws Exception {
		List<Student> login = new ArrayList<Student>();
		login.add(new Student(11, "Manoj","Pankaj",345, "manoj@99", "9745684566","Manoj@gmail.com"));
		login.add(new Student(12, "Ayushi","suraj",335, "ayushi@99", "9749984566","ayushi@gmail.com"));
		login.add(new Student(13, "Hammad","Manoj",355, "hammad@99", "9749884566","hammad@gmail.com"));
		StudentService service = mock(StudentServiceImpl.class);
		when(service.displayStudent()).thenReturn(login);
		System.out.println(login.toString());
		List<Student> log1 = service.displayStudent();
		assertNotNull(log1);
		assertFalse(log1.isEmpty());
	}
	
	@Test
	public void getStudentTest() throws Exception {
		Student student = new Student(11, "Manoj","Pankaj",345, "manoj@99", "9745684566","Manoj@gmail.com");
		StudentService service = mock(StudentServiceImpl.class);
		when(service.searchStudent(11)).thenReturn(student);
		System.out.println(student.toString());
		Student log1 = service.searchStudent(11);
		assertNotNull(log1);
	}
	

}
