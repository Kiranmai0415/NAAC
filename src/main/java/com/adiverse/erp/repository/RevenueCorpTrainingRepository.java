package com.adiverse.erp.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.adiverse.erp.model.CriteriaPrimaryKey;
import com.adiverse.erp.model.ResearchPublications_wb;
import com.adiverse.erp.model.RevenueCorpTrainingMain;


public interface RevenueCorpTrainingRepository extends JpaRepository<RevenueCorpTrainingMain,CriteriaPrimaryKey> {
	

}
