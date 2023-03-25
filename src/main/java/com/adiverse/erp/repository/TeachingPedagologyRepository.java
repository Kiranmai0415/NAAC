package com.adiverse.erp.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adiverse.erp.model.TeachingPedagology;

@Repository
public interface TeachingPedagologyRepository extends JpaRepository<TeachingPedagology,Long>
{

	
}