package com.adiverse.erp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adiverse.erp.model.QuantitativeData;

public interface QuantitativeRepository  extends JpaRepository<QuantitativeData,Long> {
	

}
