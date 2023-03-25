package com.adiverse.erp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.adiverse.erp.model.CriteriaPrimaryKey;
import com.adiverse.erp.model.QualitativeQuantitativeCriterionWise;
import com.adiverse.erp.model.QualitativeQuantitativeInfo;

public interface QualitativeQuantitativeCriteriaWiseRepository extends JpaRepository<QualitativeQuantitativeCriterionWise,CriteriaPrimaryKey>{

//	@Query("FROM QualitativeQuantitativeInfo ORDER BY uniqueKey1 ASC")
//    List<QualitativeQuantitativeInfo> findAllOrderByQualitativeAsc();
}
