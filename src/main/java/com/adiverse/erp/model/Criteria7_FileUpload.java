package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "criteria7_fileupload")
public class Criteria7_FileUpload implements Serializable
{	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private CriteriaPrimaryKey criteriaId;
	
    @Id
    @Column(name="unique_key1")
	private String uniqueKey1;
	 
	@Column(name = "criteria7_file_name")
	private String criteria7FileName;
	
	@Column(name = "criteria7_file_path")
	private String criteria7FilePath;
	
	@Column(name = "criteria7_file_type")
	private String criteria7FileType;

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

	public String getCriteria7FileName() {
		return criteria7FileName;
	}

	public void setCriteria7FileName(String criteria7FileName) {
		this.criteria7FileName = criteria7FileName;
	}

	public String getCriteria7FilePath() {
		return criteria7FilePath;
	}

	public void setCriteria7FilePath(String criteria7FilePath) {
		this.criteria7FilePath = criteria7FilePath;
	}

	public String getCriteria7FileType() {
		return criteria7FileType;
	}

	public void setCriteria7FileType(String criteria7FileType) {
		this.criteria7FileType = criteria7FileType;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(criteria7FileName, criteria7FilePath, criteria7FileType, criteriaId, uniqueKey1);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Criteria7_FileUpload other = (Criteria7_FileUpload) obj;
		return Objects.equals(criteria7FileName, other.criteria7FileName)
				&& Objects.equals(criteria7FilePath, other.criteria7FilePath)
				&& Objects.equals(criteria7FileType, other.criteria7FileType)
				&& Objects.equals(criteriaId, other.criteriaId) && Objects.equals(uniqueKey1, other.uniqueKey1);
	}

	

	
	
}
