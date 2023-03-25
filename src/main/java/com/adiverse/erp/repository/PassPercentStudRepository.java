package com.adiverse.erp.repository;

//import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adiverse.erp.model.CriteriaPrimaryKey;
import com.adiverse.erp.model.PassPercentStudMain;


@Repository
public interface PassPercentStudRepository extends JpaRepository<PassPercentStudMain,CriteriaPrimaryKey>
{

	
}