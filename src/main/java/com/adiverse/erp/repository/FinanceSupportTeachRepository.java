package com.adiverse.erp.repository;

//import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adiverse.erp.model.CriteriaPrimaryKey;
import com.adiverse.erp.model.FinancialSupportToTeachersMain;
import com.adiverse.erp.model.FullTimeTeacherSanctionMain;
import com.adiverse.erp.model.FullTimeTeachersPhdMain;
import com.adiverse.erp.model.ResearchGuidesMain;
import com.adiverse.erp.model.StudentSatisfactionMain;



public interface FinanceSupportTeachRepository extends JpaRepository<FinancialSupportToTeachersMain,CriteriaPrimaryKey>
{

	
}