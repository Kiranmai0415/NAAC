package com.adiverse.erp.repository;

//import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adiverse.erp.model.Campus;



public interface CampusRepository extends JpaRepository<Campus,Long>
{

//	List<Campus> findByCampustypeContaining(String campustype);
	
}