package com.adiverse.erp.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adiverse.erp.model.StudentForm_WB;

@Repository
public interface StudentformRepository extends JpaRepository<StudentForm_WB, Long> 
{

}
