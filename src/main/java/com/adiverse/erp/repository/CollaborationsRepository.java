package com.adiverse.erp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adiverse.erp.model.CollaborationLinkagesMain;
import com.adiverse.erp.model.CriteriaPrimaryKey;
import com.adiverse.erp.model.FacultyAwardsMain;


@Repository
public interface CollaborationsRepository extends JpaRepository<CollaborationLinkagesMain, CriteriaPrimaryKey>
{

}

