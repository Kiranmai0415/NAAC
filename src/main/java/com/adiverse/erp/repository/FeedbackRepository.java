package com.adiverse.erp.repository;

//import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adiverse.erp.model.FeedbackForm_WB;

public interface FeedbackRepository extends JpaRepository<FeedbackForm_WB,Long>
{
//	List<AcademicInformation> findByLevprogramContaining(String levprogram);
	
}