package com.cg.oes.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.oes.entity.Attendance;
import com.cg.oes.exception.AttendanceNotFoundException;
import com.cg.oes.repository.IAttendanceRepository;

@Service
@Transactional 
public class AttendanceServiceImpl implements IAttendanceService {
	
	@Autowired
	private IAttendanceRepository IAttendanceRepository;
	/**
	 * method name: saveAttendance
	 * method desc: get a Student class object and insert into database through save method.
	 * parameters:  Attendance type-attendance
	 * returns:    Attendance
	 * method type: insertion
	 * author name: Raushan
	 */

	@Override
	public Attendance addAttendance(Attendance attendance) {
		return IAttendanceRepository.save(attendance);
	}
	 /**
	 * method name: updateAttendance
	 * method desc: get a Attendance class object and update it from database through save method.
	 * parameters:  Attendance type-attendance
	 * returns:     Attendance
	 * method type: updation
	 * author name: Raushan
	 */	 
	@Override
	public Attendance updateAttendance(Attendance attendance) {
		Attendance updateAttendance =IAttendanceRepository.save(attendance);
	    if(updateAttendance!=null)
		{
		return IAttendanceRepository.save(attendance);		
		}
		else
		{
		throw new AttendanceNotFoundException("TeacherId  does not exist.");
		}
		
	}
	/**
	 * method name: displayAttendance()
	 * method desc: to fetch the details of attendance by findAll method.
	 * parameters:  no parametrs
	 * returns:     list of attendance type
	 * method type: retrieval
	 * author name: Raushan
	 */ 
	@Override
	public List<Attendance> displayAttendance() {
		return (List<Attendance>) IAttendanceRepository.findAll();
	}

}
