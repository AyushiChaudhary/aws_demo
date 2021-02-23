package com.cg.oes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.cg.oes.entity.Teacher;

@Repository
public interface ITeacherRepository extends JpaRepository<Teacher, Integer>{
	
	@Query("select c from Teacher c where c.teacherId=?1 and c.password =?2")
	public Teacher mapping(int teacherId, String password);

}
