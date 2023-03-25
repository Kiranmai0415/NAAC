package com.adiverse.erp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adiverse.erp.model.AwardsRecognitionMain;
import com.adiverse.erp.model.CriteriaPrimaryKey;
import com.adiverse.erp.model.EcontentDevbyTeachMain;


@Repository
public interface EContentRepository extends JpaRepository<EcontentDevbyTeachMain, CriteriaPrimaryKey>
{

}

