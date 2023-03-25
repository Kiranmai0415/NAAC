package com.adiverse.erp.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adiverse.erp.model.Criteria5_FieldInfo;
import com.adiverse.erp.model.CriteriaPrimaryKey;


@Repository
public interface Criteria5Repository extends JpaRepository<Criteria5_FieldInfo, CriteriaPrimaryKey>
{
	
}

