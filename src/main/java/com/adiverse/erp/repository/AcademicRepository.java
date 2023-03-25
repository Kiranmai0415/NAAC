package com.adiverse.erp.repository;

//import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adiverse.erp.model.AcademicInformation;

public interface AcademicRepository extends JpaRepository<AcademicInformation,Long>
{
//	List<AcademicInformation> findByLevprogramContaining(String levprogram);
	
}