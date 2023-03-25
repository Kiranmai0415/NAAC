package com.adiverse.erp.repository;
//import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adiverse.erp.model.Criteria4_FieldInfo;
import com.adiverse.erp.model.CriteriaPrimaryKey;


@Repository
public interface Criteria4Repository extends JpaRepository<Criteria4_FieldInfo, CriteriaPrimaryKey>
{

}

