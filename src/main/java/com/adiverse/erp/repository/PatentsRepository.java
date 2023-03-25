package com.adiverse.erp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adiverse.erp.model.CriteriaPrimaryKey;
import com.adiverse.erp.model.Patents;
import com.adiverse.erp.model.PatentsMain;

public interface PatentsRepository extends JpaRepository<PatentsMain, CriteriaPrimaryKey> {
	

}
