package com.adiverse.erp.repository;

//import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adiverse.erp.model.CriteriaPrimaryKey;
import com.adiverse.erp.model.FellowshipMain;
import com.adiverse.erp.model.SeedMoneyMain;



public interface FellowshipRepository extends JpaRepository<FellowshipMain,CriteriaPrimaryKey>
{

	
}