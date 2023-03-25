package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "fellowship_fileupload")
public class FellowshipFileUpload implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private CriteriaPrimaryKey criteriaId;
	
	@Id
    @Column(name="unique_key1")
	private String uniqueKey1;
	
	@Column(name = "fellowship_file_name")
	private String fellowshipFileName;
	
	@Column(name = "fellowship_file_path")
	private String fellowshipFilePath;
	
	@Column(name = "fellowship_file_type")
	private String fellowshipFileType;

	public String getUniqueKey1() {
		return uniqueKey1;
	}

	public void setUniqueKey1(String uniqueKey1) {
		this.uniqueKey1 = uniqueKey1;
	}

	public String getFellowshipFileName() {
		return fellowshipFileName;
	}

	public void setFellowshipFileName(String fellowshipFileName) {
		this.fellowshipFileName = fellowshipFileName;
	}

	public String getFellowshipFilePath() {
		return fellowshipFilePath;
	}

	public void setFellowshipFilePath(String fellowshipFilePath) {
		this.fellowshipFilePath = fellowshipFilePath;
	}

	public String getFellowshipFileType() {
		return fellowshipFileType;
	}

	public void setFellowshipFileType(String fellowshipFileType) {
		this.fellowshipFileType = fellowshipFileType;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public CriteriaPrimaryKey getCriteriaId() {
		return criteriaId;
	}

	public void setCriteriaId(CriteriaPrimaryKey criteriaId) {
		this.criteriaId = criteriaId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(criteriaId, fellowshipFileName, fellowshipFilePath, fellowshipFileType, uniqueKey1);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FellowshipFileUpload other = (FellowshipFileUpload) obj;
		return Objects.equals(criteriaId, other.criteriaId)
				&& Objects.equals(fellowshipFileName, other.fellowshipFileName)
				&& Objects.equals(fellowshipFilePath, other.fellowshipFilePath)
				&& Objects.equals(fellowshipFileType, other.fellowshipFileType)
				&& Objects.equals(uniqueKey1, other.uniqueKey1);
	}

	
	
	
	
	

}
