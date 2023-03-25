package com.adiverse.erp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adiverse.erp.model.AdmissionForm_WB;

public interface AdminFormRepository extends JpaRepository<AdmissionForm_WB,Long>
{

}