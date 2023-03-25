package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "criteria2_fileupload")
public class Criteria2_FileUpload implements Serializable
{	
	
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private CriteriaPrimaryKey criteriaId;
	
    @Id
    @Column(name="unique_key1")
	private String uniqueKey1;
	 
	@Column(name = "criteria2_file_name")
	private String criteria2FileName;
	
	@Column(name = "criteria2_file_path")
	private String criteria2FilePath;
	
	@Column(name = "criteria2_file_type")
	private String criteria2FileType;

	

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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getCriteria2FileName() {
		return criteria2FileName;
	}

	public void setCriteria2FileName(String criteria2FileName) {
		this.criteria2FileName = criteria2FileName;
	}

	public String getCriteria2FilePath() {
		return criteria2FilePath;
	}

	public void setCriteria2FilePath(String criteria2FilePath) {
		this.criteria2FilePath = criteria2FilePath;
	}

	public String getCriteria2FileType() {
		return criteria2FileType;
	}

	public void setCriteria2FileType(String criteria2FileType) {
		this.criteria2FileType = criteria2FileType;
	}

	@Override
	public int hashCode() {
		return Objects.hash(criteria2FileName, criteria2FilePath, criteria2FileType, criteriaId, uniqueKey1);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Criteria2_FileUpload other = (Criteria2_FileUpload) obj;
		return Objects.equals(criteria2FileName, other.criteria2FileName)
				&& Objects.equals(criteria2FilePath, other.criteria2FilePath)
				&& Objects.equals(criteria2FileType, other.criteria2FileType)
				&& Objects.equals(criteriaId, other.criteriaId) && uniqueKey1 == other.uniqueKey1;
	}

	
	
	
}
