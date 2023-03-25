package com.adiverse.erp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adiverse.erp.model.Criteria3_FileUpload;


public interface Criteria3_FileUploadRepository extends JpaRepository<Criteria3_FileUpload, Long>
{
	
//	List<FileUpload> findByFieldId(Long postId);
//	 List<FileUpload> findByFieldId(Long fileId);
	  
//	  @Transactional
//	  void deleteByFieldId(long field_id);
}
