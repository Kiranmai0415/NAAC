package com.adiverse.erp.repository;

//import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adiverse.erp.model.basicprofile_2;


public interface BasicProfileRepository extends JpaRepository<basicprofile_2,Long>
{
//	List<basicprofile_2> findByExcellenceContaining(String excellence);
	
}