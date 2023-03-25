package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "criteria6_fileupload")
public class Criteria6_FileUpload implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private CriteriaPrimaryKey criteriaId;

	@Id
	@Column(name = "unique_key1")
	private String uniqueKey1;

	@Column(name = "criteria6_file_name")
	private String criteria6FileName;

	@Column(name = "criteria6_file_path")
	private String criteria6FilePath;

	@Column(name = "criteria6_file_type")
	private String criteria6FileType;

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

	public String getCriteria6FileName() {
		return criteria6FileName;
	}

	public void setCriteria6FileName(String criteria6FileName) {
		this.criteria6FileName = criteria6FileName;
	}

	public String getCriteria6FilePath() {
		return criteria6FilePath;
	}

	public void setCriteria6FilePath(String criteria6FilePath) {
		this.criteria6FilePath = criteria6FilePath;
	}

	public String getCriteria6FileType() {
		return criteria6FileType;
	}

	public void setCriteria6FileType(String criteria6FileType) {
		this.criteria6FileType = criteria6FileType;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(criteria6FileName, criteria6FilePath, criteria6FileType, criteriaId, uniqueKey1);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Criteria6_FileUpload other = (Criteria6_FileUpload) obj;
		return Objects.equals(criteria6FileName, other.criteria6FileName)
				&& Objects.equals(criteria6FilePath, other.criteria6FilePath)
				&& Objects.equals(criteria6FileType, other.criteria6FileType)
				&& Objects.equals(criteriaId, other.criteriaId) && Objects.equals(uniqueKey1, other.uniqueKey1);
	}

}
