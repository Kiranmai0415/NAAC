package com.adiverse.erp.repository;


import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.adiverse.erp.model.CriteriaPrimaryKey;
import com.adiverse.erp.model.TrackingDetails;


@Repository
public interface TrackingDetailsRepository extends JpaRepository<TrackingDetails, CriteriaPrimaryKey>
{
	
	@Transactional
	@Modifying
	@Query(value="select * from tracking_details p where p.college_id = ?1 and p.financial_Year = ?2 and p.typeof_Institution =?3",nativeQuery = true)
	List<TrackingDetails> progreamsdata(String collegeId,String financialYear,String typeofInstitution);
	
}

