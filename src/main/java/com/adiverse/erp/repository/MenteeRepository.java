package com.adiverse.erp.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.adiverse.erp.model.MenteeForm;

public interface MenteeRepository extends JpaRepository<MenteeForm,Long>
{

	
}