package com.cg.oes.service;

import java.util.List;
import com.cg.oes.entity.Teacher;

public interface ITeacherService {
	
	public String login(Teacher teacher);
	public Teacher addTeacher(Teacher teacher);
	public Teacher searchTeacher(int teacherId);
	public void deleteTeacher(int teacherId);
	public Teacher updateTeacher(Teacher teacher);
	public List<Teacher> displayTeacher();

}
