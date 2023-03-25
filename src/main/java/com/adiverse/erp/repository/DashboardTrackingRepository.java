package com.adiverse.erp.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adiverse.erp.model.CriteriaPrimaryKey;
import com.adiverse.erp.model.DashboardProgramsAuthorise;


@Repository
public interface DashboardTrackingRepository extends JpaRepository<DashboardProgramsAuthorise, CriteriaPrimaryKey>
{
	
}

