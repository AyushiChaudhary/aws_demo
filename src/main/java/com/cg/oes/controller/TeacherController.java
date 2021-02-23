package com.cg.oes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cg.oes.entity.Admin;
import com.cg.oes.entity.Teacher;
import com.cg.oes.service.ITeacherService;


@RestController
@RequestMapping(value = "/OES")
@CrossOrigin(origins="http://localhost:4200")
public class TeacherController {  
	
	@Autowired 
	private ITeacherService ITeacherService;
	
	
		/**
	 * method name: addTeacher
	 * method desc: to add a object of teacher class by passing object by calling the method of service class.
	 * parameters:  Teacher class type-teacher
	 * returns:     teacher
	 * method type: post
	 * author name: Ruchi
	 */ 
	@RequestMapping(value="/teachers",method=RequestMethod.POST) 
	public Teacher addTeacher(@RequestBody Teacher teacher) {
		return ITeacherService.addTeacher(teacher);
	}
	
	/**
	 * method name: getTeacher
	 * method desc: to fetch the details of teacher by passing teacher id through uri by calling method of service class.
	 * parameters:  int type-id
	 * returns:     Teacher 
	 * method type: get
	 * author name: Ruchi
	 */ 
	@GetMapping(value="/teachers/{teacherId}")
	public Teacher getTeacher(@PathVariable("teacherId") int teacherId){
		Teacher teacher=ITeacherService.searchTeacher(teacherId);
           return teacher;
	}
	
	/**
	 * method name: deleteTeacher
	 * method desc: to delete  teacher by passing teacher id through uri by calling the method of service class.
	 * parameters:  int type-teacherId
	 * returns:     boolean 
	 * method type: delete
	 * author name: Ruchi
	 */ 
	@DeleteMapping(value="/teachers/{teacherId}")
    public boolean deleteTeacher(@PathVariable("teacherId") int teacherId) {
		ITeacherService.deleteTeacher(teacherId);
	  return true;
    }
	
	/*
	 * method name: updateTeacher
	 * method desc: update the object of teacher by passing object by calling the method of service class.
	 * parameters:  Teacher class type-teacher
	 * returns:     Teacher 
	 * method type: put
	 * author name: Ruchi
	 */ 
	
	@PutMapping(value="/teachers")
	public Teacher updateTeacher(@RequestBody Teacher teacher) {
		return ITeacherService.updateTeacher(teacher);		
	}
	
	/**
	 * method name: listOfTeachers
	 * method desc: to fetch details of all teacher through uri by calling method of service class. 
	 * parameters:  no parameters
	 * returns:     list of teacher type
	 * method type: get
	 * author name: Ruchi
	 */ 
	@GetMapping(value="/teachers")
	public List<Teacher> listOfTeachers(){
		return ITeacherService.displayTeacher();
	}
	@PostMapping("/tlogin")
	public String login(@RequestBody Teacher teacher)
	{
		System.out.println("doing"+teacher);
		return ITeacherService.login(teacher) ;
	}			
	
}
	

