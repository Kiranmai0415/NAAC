package com.adiverse.erp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adiverse.erp.model.YearTable3131;

@Repository
public interface YearTable3131Repository extends JpaRepository<YearTable3131, Long>
{

//	 List<YearInfo> findByFieldId(Long yearid);
	  
//	  @Transactional
//	  void deleteByFieldId(long field_id);
}

