package com.cg.oes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cg.oes.entity.Lecture;

@Repository
public interface ILectureRepository  extends JpaRepository<Lecture, Integer> {
	
	

}
