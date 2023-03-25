package com.adiverse.erp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adiverse.erp.model.CriteriaPrimaryKey;
import com.adiverse.erp.model.FacultyAwardsMain;
import com.adiverse.erp.model.TeachingActivities_WB;


@Repository
public interface TeachingActivitiesRepository extends JpaRepository<TeachingActivities_WB, CriteriaPrimaryKey>
{

}

