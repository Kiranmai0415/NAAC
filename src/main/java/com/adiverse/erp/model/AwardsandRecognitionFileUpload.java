package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "awards_recog_fileupload")
public class AwardsandRecognitionFileUpload implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public CriteriaPrimaryKey criteriaId;
	
	@Id
    @Column(name="unique_key1")
	private String uniqueKey1;
	
	@Column(name = "awards_recog_file_name")
	private String awardsRecogFileName;
	
	@Column(name = "awards_recog_file_path")
	private String awardsRecogFilePath;
	
	@Column(name = "awards_recog_file_type")
	private String awardsRecogFileType;

	public String getUniqueKey1() {
		return uniqueKey1;
	}

	public void setUniqueKey1(String uniqueKey1) {
		this.uniqueKey1 = uniqueKey1;
	}

	public String getAwardsRecogFileName() {
		return awardsRecogFileName;
	}

	public void setAwardsRecogFileName(String awardsRecogFileName) {
		this.awardsRecogFileName = awardsRecogFileName;
	}

	public String getAwardsRecogFilePath() {
		return awardsRecogFilePath;
	}

	public void setAwardsRecogFilePath(String awardsRecogFilePath) {
		this.awardsRecogFilePath = awardsRecogFilePath;
	}

	public String getAwardsRecogFileType() {
		return awardsRecogFileType;
	}

	public void setAwardsRecogFileType(String awardsRecogFileType) {
		this.awardsRecogFileType = awardsRecogFileType;
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
		return Objects.hash(awardsRecogFileName, awardsRecogFilePath, awardsRecogFileType, criteriaId, uniqueKey1);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AwardsandRecognitionFileUpload other = (AwardsandRecognitionFileUpload) obj;
		return Objects.equals(awardsRecogFileName, other.awardsRecogFileName)
				&& Objects.equals(awardsRecogFilePath, other.awardsRecogFilePath)
				&& Objects.equals(awardsRecogFileType, other.awardsRecogFileType)
				&& Objects.equals(criteriaId, other.criteriaId) && Objects.equals(uniqueKey1, other.uniqueKey1);
	}

	

}
