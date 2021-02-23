package com.cg.oes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.cg.oes.entity.Attendance;
import com.cg.oes.service.IAttendanceService;

@RestController
@RequestMapping(value = "/OES")
@CrossOrigin(origins="http://localhost:4200")
public class AttendanceController {

	@Autowired 
	private IAttendanceService IAttendanceService;
	/**
	 * method name: addAttendance
	 * method desc: to add a object of attendance class by passing object by calling the method of service class.
	 * parameters:  Lecture class type-lecture
	 * returns:    Attendance
	 * method type: post
	 * author name:Raushan
	 */ 
	@RequestMapping(value="/attendance",method=RequestMethod.POST) 
	public Attendance addAttendance(@RequestBody Attendance attendance) {
		return IAttendanceService.addAttendance(attendance);
	}
	 /**
		 * method name: updateAttendance
		 * method desc: update the object of  attendance by passing object by calling the method of service class.
		 * parameters:  Attendance class type-student
		 * returns:    Attendance
		 * method type: put
		 * author name: Raushan
		 */ 

	@PutMapping(value="/attendance")
	public Attendance updateAttendance(@RequestBody Attendance attendance) {
		return IAttendanceService.updateAttendance(attendance);		
	}
	
	 /**
		 * method name: getAttendance
		 * method desc: to fetch the details of attendance by passing  student id through uri by calling method of service class.
		 * parameters:  int type-id
		 * returns:    Attendance
		 * method type: get
		 * author name: Raushan
		 */ 
	@GetMapping(value="/attendance")
	public List<Attendance> listAttendance(){
		return IAttendanceService.displayAttendance();
	}
	
	
		
}
