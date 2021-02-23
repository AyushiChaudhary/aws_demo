package com.cg.oes.controller;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import com.cg.oes.entity.Student;
import com.cg.oes.service.StudentService;


@RequestMapping("/OES")
@RestController
@CrossOrigin(origins="http://localhost:4200")
public class StudentController {
	Logger logger = LoggerFactory.getLogger(StudentController.class);
	@Autowired
	private StudentService service;
	
	/**
	 * method name: saveStudent
	 * method desc: to add a object of student class by passing object by calling the method of service class.
	 * parameters:  student class type-Student
	 * returns:    student
	 * method type: post
	 * author name: Divyansh
	 */ 
	 @PostMapping("/students")
	 public ResponseEntity<Object> save(@RequestBody Student student)
		{
			student = service.saveStudent(student);
			logger.info("Student Registered");
			return new ResponseEntity<>(HttpStatus.CREATED);
			}
	 /**
		 * method name: getStudent
		 * method desc: to fetch the details of student by passing  student id through uri by calling method of service class.
		 * parameters:  int type-id
		 * returns:     Student
		 * method type: get
		 * author name:Divyansh
		 */ 
	 @GetMapping(value="/students/{studentId}")
		public Student getStudent(@PathVariable("studentId") int studentId){
			Student student=service.searchStudent(studentId);
	           return student;
		}
		/**
		 * method name: deleteStudent
		 * method desc: to delete  student by passing teacher id through uri by calling the method of service class.
		 * parameters:  int type-studentId
		 * returns:     boolean 
		 * method type: delete
		 * author name: Divyansh
		 */ 
	 @DeleteMapping(value="/students/{studentId}")
	    public boolean deleteStudent(@PathVariable("studentId") int studentId) {
			service.deleteStudent(studentId);
		  return true;
	    }
	 /**
		 * method name: updateStudent
		 * method desc: update the object of student by passing object by calling the method of service class.
		 * parameters:  Student class type-student
		 * returns:     Student 
		 * method type: put
		 * author name: Divyansh
		 */ 
		@PutMapping("/students")
		public Student updateStudent(@RequestBody Student student) {
			return service.updateStudent(student);		
		}
		/**
		 * method name: listOfStudent
		 * method desc: to fetch details of all teacher through uri by calling method of service class. 
		 * parameters:  no parameters
		 * returns:     list of student type
		 * method type: get
		 * author name: divyansh
		 */ 
		@GetMapping("/students")
		public List<Student> listOfStudents(){
			return service.displayStudent();
		}
		/**
		 * method name: login
		 * method desc: student will login  by passing  studentId and password through uri by calling method of service class.
		 * parameters: Student type-student 
		 * returns:    String
		 * method type: get
		 * author name: divyansh
		 */ 
		 @PostMapping("/login")
			public String login(@RequestBody Student student)
			{
			 	
				System.out.println("doing"+student);
				return service.login(student) ;
			}
}
