package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "faculty_awards_fileupload")
public class FacultyAwardsFileUpload implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private CriteriaPrimaryKey criteriaId;

	@Id
	@Column(name = "unique_key1")
	private String uniqueKey1;
	
	@Column(name = "faculty_awards_file_name")
	private String facultyAwardsFileName;

	@Column(name = "faculty_awards_file_path")
	private String facultyAwardsFilePath;

	@Column(name = "faculty_awards_file_type")
	private String facultyAwardsFileType;

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

	public String getFacultyAwardsFileName() {
		return facultyAwardsFileName;
	}

	public void setFacultyAwardsFileName(String facultyAwardsFileName) {
		this.facultyAwardsFileName = facultyAwardsFileName;
	}

	public String getFacultyAwardsFilePath() {
		return facultyAwardsFilePath;
	}

	public void setFacultyAwardsFilePath(String facultyAwardsFilePath) {
		this.facultyAwardsFilePath = facultyAwardsFilePath;
	}

	public String getFacultyAwardsFileType() {
		return facultyAwardsFileType;
	}

	public void setFacultyAwardsFileType(String facultyAwardsFileType) {
		this.facultyAwardsFileType = facultyAwardsFileType;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(criteriaId, facultyAwardsFileName, facultyAwardsFilePath, facultyAwardsFileType,
				uniqueKey1);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FacultyAwardsFileUpload other = (FacultyAwardsFileUpload) obj;
		return Objects.equals(criteriaId, other.criteriaId)
				&& Objects.equals(facultyAwardsFileName, other.facultyAwardsFileName)
				&& Objects.equals(facultyAwardsFilePath, other.facultyAwardsFilePath)
				&& Objects.equals(facultyAwardsFileType, other.facultyAwardsFileType) && uniqueKey1 == other.uniqueKey1;
	}
	


}
