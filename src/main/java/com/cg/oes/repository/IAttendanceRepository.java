package com.cg.oes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cg.oes.entity.Attendance;


@Repository
public interface IAttendanceRepository extends JpaRepository<Attendance,Integer>{

}
