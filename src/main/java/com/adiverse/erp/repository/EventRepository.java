package com.adiverse.erp.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adiverse.erp.model.EventDetails_wb;

@Repository
public interface EventRepository extends JpaRepository<EventDetails_wb, Long> 
{

}
