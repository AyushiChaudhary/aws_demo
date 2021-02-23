package com.cg.oes.service;

import java.util.List;
import com.cg.oes.entity.Attendance;


public interface IAttendanceService {
	
	public Attendance addAttendance(Attendance attendance);
	public Attendance updateAttendance(Attendance attendance);
	public List<Attendance> displayAttendance();


}
