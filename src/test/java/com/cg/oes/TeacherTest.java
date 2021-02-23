package com.cg.oes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import com.cg.oes.entity.Teacher;
import com.cg.oes.repository.ITeacherRepository;
import com.cg.oes.service.ITeacherService;
import com.cg.oes.service.TeacherServiceImpl;

class TeacherTest {
	
	@Autowired
	private ITeacherService service;
	
	@MockBean
	private ITeacherRepository dao;
	
	@InjectMocks
    TeacherServiceImpl teacherServiceImpl;
	
	
	@Test
	public void addTeacherTest() throws Exception {
		Teacher teacher = new Teacher(1, "Manoj", "manoj@gmail.com", "manoj@99", "9745684566","physics");
		ITeacherService service = mock(TeacherServiceImpl.class);
		when(service.addTeacher(teacher)).thenReturn(teacher);
		System.out.println(teacher.toString());
		Teacher t = service.addTeacher(teacher);
		assertEquals(teacher, t);
	}
	
	@Test
	public void viewAllTeacherTest() throws Exception {
		List<Teacher> login = new ArrayList<Teacher>();
		login.add(new Teacher(1, "Manoj", "manoj@gmail.com", "manoj1@99", "9745684566","physics"));
		login.add(new Teacher(2, "Ruchi", "ruchi@gmail.com", "ruchi23@99", "9749898566","English"));
		login.add(new Teacher(3, "Ayushi", "ayushi@gmail.com", "ayushi56@99", "9700874566","Maths"));
		ITeacherService service = mock(TeacherServiceImpl.class);
		when(service.displayTeacher()).thenReturn(login);
		System.out.println(login.toString());
		List<Teacher> log1 = service.displayTeacher();
		assertNotNull(log1);
		assertFalse(log1.isEmpty());
	}
	
	@Test
	public void getTeacherTest() throws Exception {
		Teacher teacher = new Teacher(2, "Ruchi", "ruchi@gmail.com", "ruchi23@99", "9749898566","English");
		ITeacherService service = mock(TeacherServiceImpl.class);
		when(service.searchTeacher(2)).thenReturn(teacher);
		System.out.println(teacher.toString());
		Teacher log1 = service.searchTeacher(2);
		assertNotNull(log1);
	}
	
}
