package com.adiverse.erp.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.adiverse.erp.model.CentricMethods;
import com.adiverse.erp.model.Citations;
import com.adiverse.erp.model.QualityAdvisor;


public interface CitationsRepository extends JpaRepository<Citations,Long>
{

	
}