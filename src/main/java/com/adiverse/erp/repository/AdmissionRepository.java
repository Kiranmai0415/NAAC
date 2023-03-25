package com.adiverse.erp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adiverse.erp.model.AdmissionEnquiryForm_WB;
import com.adiverse.erp.model.AdmissionForm_WB;

public interface AdmissionRepository extends JpaRepository<AdmissionEnquiryForm_WB,Long>
{

}