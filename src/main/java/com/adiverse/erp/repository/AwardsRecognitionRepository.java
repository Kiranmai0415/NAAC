package com.adiverse.erp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adiverse.erp.model.AwardsRecognitionMain;
import com.adiverse.erp.model.CriteriaPrimaryKey;


@Repository
public interface AwardsRecognitionRepository extends JpaRepository<AwardsRecognitionMain, CriteriaPrimaryKey>
{

}

