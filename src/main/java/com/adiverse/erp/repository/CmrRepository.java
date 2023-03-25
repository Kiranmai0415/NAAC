package com.adiverse.erp.repository;

//import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adiverse.erp.model.CourseRegistrationform_WB;



public interface CmrRepository extends JpaRepository<CourseRegistrationform_WB,Long>
{
//	List<AcademicInformation> findByLevprogramContaining(String levprogram);
	
}