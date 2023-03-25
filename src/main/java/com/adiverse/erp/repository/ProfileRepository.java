package com.adiverse.erp.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.adiverse.erp.model.CriteriaPrimaryKey;
import com.adiverse.erp.model.Profile;
import com.adiverse.erp.model.ProfileMain;

public interface ProfileRepository extends JpaRepository<ProfileMain,CriteriaPrimaryKey>
{

	
}