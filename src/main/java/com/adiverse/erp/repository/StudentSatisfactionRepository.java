package com.adiverse.erp.repository;

//import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adiverse.erp.model.CriteriaPrimaryKey;
import com.adiverse.erp.model.ResearchGuidesMain;
import com.adiverse.erp.model.StudentSatisfactionMain;



public interface StudentSatisfactionRepository extends JpaRepository<StudentSatisfactionMain,CriteriaPrimaryKey>
{

	
}