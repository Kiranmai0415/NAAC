package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "criteria4_fileupload")
public class Criteria4_FileUpload implements Serializable
{	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private CriteriaPrimaryKey criteriaId;
	
    @Id
    @Column(name="unique_key1")
	private String uniqueKey1;
	 
	@Column(name = "criteria4_file_name")
	private String criteria4FileName;
	
	@Column(name = "criteria4_file_path")
	private String criteria4FilePath;
	
	@Column(name = "criteria4_file_type")
	private String criteria4FileType;

	

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

	public String getCriteria4FileName() {
		return criteria4FileName;
	}

	public void setCriteria4FileName(String criteria4FileName) {
		this.criteria4FileName = criteria4FileName;
	}

	public String getCriteria4FilePath() {
		return criteria4FilePath;
	}

	public void setCriteria4FilePath(String criteria4FilePath) {
		this.criteria4FilePath = criteria4FilePath;
	}

	public String getCriteria4FileType() {
		return criteria4FileType;
	}

	public void setCriteria4FileType(String criteria4FileType) {
		this.criteria4FileType = criteria4FileType;
	}

	@Override
	public int hashCode() {
		return Objects.hash(criteria4FileName, criteria4FilePath, criteria4FileType, criteriaId, uniqueKey1);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Criteria4_FileUpload other = (Criteria4_FileUpload) obj;
		return Objects.equals(criteria4FileName, other.criteria4FileName)
				&& Objects.equals(criteria4FilePath, other.criteria4FilePath)
				&& Objects.equals(criteria4FileType, other.criteria4FileType)
				&& Objects.equals(criteriaId, other.criteriaId) && uniqueKey1 == other.uniqueKey1;
	}
	

	
}
