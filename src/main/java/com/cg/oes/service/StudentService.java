package com.cg.oes.service;

import java.util.List;

import com.cg.oes.entity.Student;


public interface StudentService {
	Student saveStudent(Student student);
	public String login(Student student);
	public Student searchStudent(int studentId);
	public void deleteStudent(int studentId);
	public Student updateStudent(Student student);
	public List<Student> displayStudent();

}
