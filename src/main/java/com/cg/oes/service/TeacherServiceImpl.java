package com.cg.oes.service;

import java.util.List;
import java.util.NoSuchElementException;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.oes.repository.ITeacherRepository;
import com.cg.oes.entity.Teacher;
import com.cg.oes.exception.TeacherNotFoundException;

@Service      
@Transactional 
public class TeacherServiceImpl implements ITeacherService{
	
	@Autowired
	private ITeacherRepository ITeacherRepository;

	
	/**
	 * method name: addTeacher
	 * method desc: get a Teacher class object and insert into database through save method.
	 * parameters:  Teacher type-teacher
	 * returns:     Teacher
	 * method type: insertion
	 * author name: Ruchi
	 */
	
	@Override
	public Teacher addTeacher(Teacher teacher) {
		try
		{
			return ITeacherRepository.save(teacher);
		}catch(Exception e)
		{	
			throw new TeacherNotFoundException("Teacher with id : "+teacher.getTeacherId()+" already exist.");
		}	
	}
	 /**
	 * method name: searchTeacher
	 * method desc: to fetch the details of teacher from database through teacherId by findById method.
	 * parameters:  int type-teacherId
	 * returns:    Teacher
	 * method type: retrieval
	 * author name: Ruchi
	 */

	@Override
	public Teacher searchTeacher(int teacherId) {
		return ITeacherRepository.findById(teacherId).get();
	}

	 /**
	 * method name: deleteTeacher
	 * method desc: to delete the details of teacher from database through teacherId by deleteById method.
	 * parameters:  int type-teacherId
	 * returns:    Void
	 * method type: retrieval
	 * author name: Ruchi
	 */
	@Override
	public void deleteTeacher(int teacherId) {
		ITeacherRepository.deleteById(teacherId);
		
		
	}
	 /**
	 * method name: updateTeacher
	 * method desc: get a Teacher class object and update it from database through save method.
	 * parameters:  Teacher type-teacher
	 * returns:     Teacher
	 * method type: updation
	 * author name: Ruchi
	 */	 
	@Override
	public Teacher updateTeacher(Teacher teacher) {
		Teacher updateTeachers =ITeacherRepository.save(teacher);
	    if(updateTeachers!=null)
		{
		return ITeacherRepository.save(teacher);		
		}
		else
		{
		throw new TeacherNotFoundException("TeacherId  does not exist.");
		}
	 }	
	 /**
	 * method name: displayTeacher()
	 * method desc: to fetch the details of teacher by findAll method.
	 * parameters:  no parametrs
	 * returns:     list of teacher type
	 * method type: retrieval
	 * author name: Ruchi
	 */ 

	@Override
	public List<Teacher> displayTeacher() {
		return (List<Teacher>) ITeacherRepository.findAll();
	}
	
	 /**
	 * method name: login
	 * method desc: Getting the teacherId and password and calling the login fucntion from Teacherservice Inteface.
	 * parameters:  Teacher type-teacher
	 * returns:     String
	 * method type: Fetch
	 * author name: Ruchi
	 */	 
	@Override
	public String login(Teacher teacher) {
		 String returnString = "Invalid Credentials";
			
			try
			{
			   Teacher teacher1 = ITeacherRepository.findById(teacher.getTeacherId()).get();
			System.out.println(teacher);
			  if(teacher1.getPassword().equals(teacher.getPassword()))
				{
					returnString="Login Successful";
				 
					return returnString;
				}
			return returnString;
			
			}
			catch (NoSuchElementException ex)
			{
				return "Invalid teacherId";
			}

	}

}
