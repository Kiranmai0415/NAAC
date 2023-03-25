package com.adiverse.erp.repository;

//import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adiverse.erp.model.Recognition;


public interface RecognitionRepository extends JpaRepository<Recognition,Long>
{

//	List<Recognition> findByRegulatoryContaining(String regulatory);
	
}