package com.adiverse.erp.repository;
//import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adiverse.erp.model.Criteria1_FileUpload;


@Repository
public interface Criteria1_FileUploadRepository extends JpaRepository<Criteria1_FileUpload, String>
{
//	List<Criteria1_FieldInfo> findByInput111t1Containing(String input111t1);
	//@Query(SELECT MAX(fieldId) AS fieldId From criteria3_info)
    //Long CountByName(Long fieldId);
	
	
	
}

