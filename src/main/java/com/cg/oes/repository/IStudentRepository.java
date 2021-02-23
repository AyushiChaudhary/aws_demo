package com.cg.oes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.oes.entity.Student;

@Repository
public interface IStudentRepository extends JpaRepository<Student, Integer> {
	
	@Query("select c from Student c where c.studentId=?1 and c.password =?2")
	public Student mapping(int studentId, String password);
	
}
