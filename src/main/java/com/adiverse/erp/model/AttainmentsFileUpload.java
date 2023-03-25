package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "attainments_fileupload")
public class AttainmentsFileUpload implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public CriteriaPrimaryKey criteriaId;
	
	@Id
    @Column(name="unique_key1")
	private String uniqueKey1;
	
	@Column(name = "attainments_file_name")
	private String attainmentsFileName;
	
	@Column(name = "attainments_file_path")
	private String attainmentsFilePath;
	
	@Column(name = "attainments_file_type")
	private String attainmentsFileType;

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

	public String getAttainmentsFileName() {
		return attainmentsFileName;
	}

	public void setAttainmentsFileName(String attainmentsFileName) {
		this.attainmentsFileName = attainmentsFileName;
	}

	public String getAttainmentsFilePath() {
		return attainmentsFilePath;
	}

	public void setAttainmentsFilePath(String attainmentsFilePath) {
		this.attainmentsFilePath = attainmentsFilePath;
	}

	public String getAttainmentsFileType() {
		return attainmentsFileType;
	}

	public void setAttainmentsFileType(String attainmentsFileType) {
		this.attainmentsFileType = attainmentsFileType;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(attainmentsFileName, attainmentsFilePath, attainmentsFileType, criteriaId, uniqueKey1);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AttainmentsFileUpload other = (AttainmentsFileUpload) obj;
		return Objects.equals(attainmentsFileName, other.attainmentsFileName)
				&& Objects.equals(attainmentsFilePath, other.attainmentsFilePath)
				&& Objects.equals(attainmentsFileType, other.attainmentsFileType)
				&& Objects.equals(criteriaId, other.criteriaId) && Objects.equals(uniqueKey1, other.uniqueKey1);
	}

	
	
	

}
