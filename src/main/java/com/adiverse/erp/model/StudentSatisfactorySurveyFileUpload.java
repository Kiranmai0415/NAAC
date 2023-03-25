package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "students_satisf_fileupload")
public class StudentSatisfactorySurveyFileUpload implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private CriteriaPrimaryKey criteriaId;
	
	@Id
    @Column(name="unique_key1")
	private String uniqueKey1;
	
	@Column(name = "students_satisf_file_name")
	private String studentSatisfFileName;
	
	@Column(name = "students_satisf_file_path")
	private String studentSatisfFilePath;
	
	@Column(name = "students_satisf_file_type")
	private String studentSatisfFileType;

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

	public String getStudentSatisfFileName() {
		if (studentSatisfFileName!=null) {
			return studentSatisfFileName;
		}
		else {
			return "";
		}
		
	}

	public void setStudentSatisfFileName(String studentSatisfFileName) {
		this.studentSatisfFileName = studentSatisfFileName;
	}

	public String getStudentSatisfFilePath() {
		if (studentSatisfFilePath!=null) {
			return studentSatisfFilePath;
		}
		else {
			return "";
		}
		
	}

	public void setStudentSatisfFilePath(String studentSatisfFilePath) {
		this.studentSatisfFilePath = studentSatisfFilePath;
	}

	public String getStudentSatisfFileType() {
		if (studentSatisfFileType!=null) {
			return studentSatisfFileType;
		}
		else {
			return "";
		}
		
	}

	public void setStudentSatisfFileType(String studentSatisfFileType) {
		this.studentSatisfFileType = studentSatisfFileType;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(criteriaId, studentSatisfFileName, studentSatisfFilePath, studentSatisfFileType,
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
		StudentSatisfactorySurveyFileUpload other = (StudentSatisfactorySurveyFileUpload) obj;
		return Objects.equals(criteriaId, other.criteriaId)
				&& Objects.equals(studentSatisfFileName, other.studentSatisfFileName)
				&& Objects.equals(studentSatisfFilePath, other.studentSatisfFilePath)
				&& Objects.equals(studentSatisfFileType, other.studentSatisfFileType)
				&& Objects.equals(uniqueKey1, other.uniqueKey1);
	}

	
}
