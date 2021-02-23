package com.cg.oes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.cg.oes.entity.Admin;

@Repository
public interface IAdminRepository extends JpaRepository<Admin, Integer> {
 
	@Query("select c from Admin c where c.id=?1 and c.password =?2")
	public Admin mapping(int id, String password);

}
