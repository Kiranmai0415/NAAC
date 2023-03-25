package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "criteria1_fileupload")
public class Criteria1_FileUpload implements Serializable
{	
	
	private static final long serialVersionUID = 1L;

	private CriteriaPrimaryKey criteriaId;
	
    @Id
    @Column(name="unique_key1")
	private String uniqueKey1;
	 
	@Column(name = "criteria1_file_name")
	private String criteria1FileName;
	
	@Column(name = "criteria1_file_path")
	private String criteria1FilePath;
	
	@Column(name = "criteria1_file_type")
	private String criteria1FileType;

	
	
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

	public String getCriteria1FileName() {
		return criteria1FileName;
	}

	public void setCriteria1FileName(String criteria1FileName) {
		this.criteria1FileName = criteria1FileName;
	}

	public String getCriteria1FilePath() {
		return criteria1FilePath;
	}

	public void setCriteria1FilePath(String criteria1FilePath) {
		this.criteria1FilePath = criteria1FilePath;
	}

	public String getCriteria1FileType() {
		return criteria1FileType;
	}

	public void setCriteria1FileType(String criteria1FileType) {
		this.criteria1FileType = criteria1FileType;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(criteria1FileName, criteria1FilePath, criteria1FileType, criteriaId, uniqueKey1);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Criteria1_FileUpload other = (Criteria1_FileUpload) obj;
		return Objects.equals(criteria1FileName, other.criteria1FileName)
				&& Objects.equals(criteria1FilePath, other.criteria1FilePath)
				&& Objects.equals(criteria1FileType, other.criteria1FileType)
				&& Objects.equals(criteriaId, other.criteriaId) && uniqueKey1 == other.uniqueKey1;
	}

		
	
	
}
