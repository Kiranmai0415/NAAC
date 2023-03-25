package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "mous_fileupload")
public class MousFileUpload implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private CriteriaPrimaryKey criteriaId;

	@Id
	@Column(name = "unique_key1")
	private String uniqueKey1;
	
	@Column(name = "mous_file_name")
	private String mousFileName;

	@Column(name = "mous_file_path")
	private String mousFilePath;

	@Column(name = "mous_file_type")
	private String mousFileType;

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

	public String getMousFileName() {
		return mousFileName;
	}

	public void setMousFileName(String mousFileName) {
		this.mousFileName = mousFileName;
	}

	public String getMousFilePath() {
		return mousFilePath;
	}

	public void setMousFilePath(String mousFilePath) {
		this.mousFilePath = mousFilePath;
	}

	public String getMousFileType() {
		return mousFileType;
	}

	public void setMousFileType(String mousFileType) {
		this.mousFileType = mousFileType;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(criteriaId, mousFileName, mousFilePath, mousFileType, uniqueKey1);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MousFileUpload other = (MousFileUpload) obj;
		return Objects.equals(criteriaId, other.criteriaId) && Objects.equals(mousFileName, other.mousFileName)
				&& Objects.equals(mousFilePath, other.mousFilePath) && Objects.equals(mousFileType, other.mousFileType)
				&& uniqueKey1 == other.uniqueKey1;
	}

	
	
	
}
