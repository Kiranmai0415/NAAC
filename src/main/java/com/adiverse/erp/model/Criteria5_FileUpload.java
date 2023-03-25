package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "criteria5_fileupload")
public class Criteria5_FileUpload implements Serializable
{	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private CriteriaPrimaryKey criteriaId;
	
    @Id
    @Column(name="unique_key1")
	private String uniqueKey1;
	 
	@Column(name = "criteria5_file_name")
	private String criteria5FileName;
	
	@Column(name = "criteria5_file_path")
	private String criteria5FilePath;
	
	@Column(name = "criteria5_file_type")
	private String criteria5FileType;

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

	public String getCriteria5FileName() {
		return criteria5FileName;
	}

	public void setCriteria5FileName(String criteria5FileName) {
		this.criteria5FileName = criteria5FileName;
	}

	public String getCriteria5FilePath() {
		return criteria5FilePath;
	}

	public void setCriteria5FilePath(String criteria5FilePath) {
		this.criteria5FilePath = criteria5FilePath;
	}

	public String getCriteria5FileType() {
		return criteria5FileType;
	}

	public void setCriteria5FileType(String criteria5FileType) {
		this.criteria5FileType = criteria5FileType;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(criteria5FileName, criteria5FilePath, criteria5FileType, criteriaId, uniqueKey1);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Criteria5_FileUpload other = (Criteria5_FileUpload) obj;
		return Objects.equals(criteria5FileName, other.criteria5FileName)
				&& Objects.equals(criteria5FilePath, other.criteria5FilePath)
				&& Objects.equals(criteria5FileType, other.criteria5FileType)
				&& Objects.equals(criteriaId, other.criteriaId) && Objects.equals(uniqueKey1, other.uniqueKey1);
	}

	

}
