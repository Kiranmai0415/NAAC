package com.adiverse.erp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adiverse.erp.model.CriteriaPrimaryKey;
import com.adiverse.erp.model.EvaluativereportMain;

public interface EvaluativeRepository extends JpaRepository<EvaluativereportMain,CriteriaPrimaryKey>  {


}
