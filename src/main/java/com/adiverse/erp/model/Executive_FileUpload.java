package com.adiverse.erp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "executive_fileupload")
public class Executive_FileUpload 
{	
	
private CriteriaPrimaryKey criteriaId;
	
    @Id
    @Column(name="unique_key1")
	private String uniqueKey1;
    
    
	 
	@Column(name = "executive_file_name")
	private String executiveFileName;
	
	@Column(name = "executive_file_path")
	private String executiveFilePath;
	
	@Column(name = "executive_file_type")
	private String executiveFileType;

	

	public CriteriaPrimaryKey getCriteriaId() {
		return criteriaId;
	}

	public void setCriteriaId(CriteriaPrimaryKey criteriaId) {
		this.criteriaId = criteriaId;
	}

	public String getUniqueKey1() {
		return uniqueKey1;
	}

	public void setUniqueKey1(String uniqueKey1) {
		this.uniqueKey1 = uniqueKey1;
	}

	public String getExecutiveFileName() {
		return executiveFileName;
	}

	public void setExecutiveFileName(String executiveFileName) {
		this.executiveFileName = executiveFileName;
	}

	public String getExecutiveFilePath() {
		return executiveFilePath;
	}

	public void setExecutiveFilePath(String executiveFilePath) {
		this.executiveFilePath = executiveFilePath;
	}

	public String getExecutiveFileType() {
		return executiveFileType;
	}

	public void setExecutiveFileType(String executiveFileType) {
		this.executiveFileType = executiveFileType;
	}


		
}
