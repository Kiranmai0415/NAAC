package com.adiverse.erp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adiverse.erp.model.AssignFunctionality;
import com.adiverse.erp.model.CriteriaPrimaryKey;


@Repository
public interface AssignfunctionalityRepository extends JpaRepository<AssignFunctionality, CriteriaPrimaryKey>
{

}

