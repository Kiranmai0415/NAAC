package com.adiverse.erp.repository;

//import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adiverse.erp.model.AcademicInstitution;



public interface AcademicRepositoryTwo extends JpaRepository<AcademicInstitution,Long>
{

//	List<AcademicInformation> findByLevprogramContaining(String levprogram);
	
}