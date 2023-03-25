package com.adiverse.erp.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.adiverse.erp.model.CriteriaPrimaryKey;
import com.adiverse.erp.model.ExecutiveSummary;

public interface ExecutiveRepository extends JpaRepository<ExecutiveSummary,CriteriaPrimaryKey>
{

	
}