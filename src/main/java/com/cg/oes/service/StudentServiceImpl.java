package com.cg.oes.service;

import java.util.List;
import java.util.NoSuchElementException;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.oes.entity.Student;
import com.cg.oes.exception.StudentNotFoundException;
import com.cg.oes.repository.IStudentRepository;
@Service
@Transactional
public class StudentServiceImpl implements StudentService {
	@Autowired
	private IStudentRepository repository;

	
	/**
	 * method name: saveStudents
	 * method desc: get a Student class object and insert into database through save method.
	 * parameters:  Student type-student
	 * returns:     Student
	 * method type: insertion
	 * author name: Divyansh
	 */
	 @Override
	 public Student saveStudent(Student student) {
		 return repository.save(student);
}
	
	 /**
		 * method name: login
		 * method desc: Getting the studentId and password and calling the login fucntion from Studentservice Inteface.
		 * parameters:  Student type-student
		 * returns:     String
		 * method type: Fetch
		 * author name: Divyansh
		 */	 
	 @Override
	 
		public String login(Student student) {
			 String returnString = "Invalid Credentials";
				
				try
				{
				   Student student1 = repository.findById(student.getStudentId()).get();
				System.out.println(student);
				  if(student1.getPassword().equals(student.getPassword()))
					{
						returnString="Login Successful";
					 
						return returnString;
					}
				return returnString;
				
				}
				catch (NoSuchElementException ex)
				{
					return "Invalid studentId";
				}
	 }
	 
	 /**
		 * method name: displayStudent()
		 * method desc: to fetch the details of student by findAll method.
		 * parameters:  no parametrs
		 * returns:     list of student type
		 * method type: retrieval
		 * author name: Divyansh Singh
		 */ 
	 @Override
		public List<Student> displayStudent() 
	    { 
		 return (List<Student>) repository.findAll();
		}
	 
	 /**
		 * method name: updateStudent
		 * method desc: get a Student class object and update it from database through save method.
		 * parameters:  Student type-student
		 * returns:     Student
		 * method type: updation
		 * author name: Divyansh
		 */	 
	 @Override
		public Student updateStudent(Student student) {
			Student updateStudents =repository.save(student);
		    if(updateStudents!=null)
			{
			return repository.save(student);		
			}
			else
			{
			throw new StudentNotFoundException("StudentId  does not exist.");
			}
		 }
     
	 /**
		 * method name: searchStudent
		 * method desc: to fetch the details of student from database through studentId by findById method.
		 * parameters:  int type-studentId
		 * returns:     Student
		 * method type: retrieval
		 * author name:Divyansh 
		 */
	@Override
	public Student searchStudent(int studentId) {
		return repository.findById(studentId).get();
	}

	 /**
	 * method name: deleteStudent
	 * method desc: to delete the details of student from database through studentId by deleteById method.
	 * parameters:  int0 type-studentId
	 * returns:    Void
	 * method type: retrieval
	 * author name:Divyansh 
	 */
	@Override
	public void deleteStudent(int studentId) {
		repository.deleteById(studentId);
		
	}	
}
