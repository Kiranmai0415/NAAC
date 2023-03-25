package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "student_mentor_ratio_fileupload")
public class StudentMentorRatioFileUppload implements Serializable  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private CriteriaPrimaryKey criteriaId;
	
	@Id
	@Column(name = "unique_key1")
	private String uniqueKey1;
	
	@Column(name = "student_mentor_file_name")
	private String studentMentorFileName;

	@Column(name = "student_mentor_file_path")
	private String studentMentorFilePath;

	@Column(name = "student_mentor_file_type")
	private String studentMentorFileType;
	

	public String getUniqueKey1() {
		return uniqueKey1;
	}

	public void setUniqueKey1(String uniqueKey1) {
		this.uniqueKey1 = uniqueKey1;
	}

	public String getStudentMentorFileName() {
		if (studentMentorFileName!=null) {
			return studentMentorFileName;
		}
		else {
			return "";
		}
		
	}

	public void setStudentMentorFileName(String studentMentorFileName) {
		this.studentMentorFileName = studentMentorFileName;
	}

	public String getStudentMentorFilePath() {
		if (studentMentorFilePath!=null) {
			return studentMentorFilePath;
		}
		else {
			return "";
		}
		
	}

	public void setStudentMentorFilePath(String studentMentorFilePath) {
		this.studentMentorFilePath = studentMentorFilePath;
	}

	public String getStudentMentorFileType() {
		if (studentMentorFileType!=null) {
			return studentMentorFileType;
		}
		else {
			return "";
		}
		
	}

	public void setStudentMentorFileType(String studentMentorFileType) {
		this.studentMentorFileType = studentMentorFileType;
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
		return Objects.hash(criteriaId, studentMentorFileName, studentMentorFilePath, studentMentorFileType,
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
		StudentMentorRatioFileUppload other = (StudentMentorRatioFileUppload) obj;
		return Objects.equals(criteriaId, other.criteriaId)
				&& Objects.equals(studentMentorFileName, other.studentMentorFileName)
				&& Objects.equals(studentMentorFilePath, other.studentMentorFilePath)
				&& Objects.equals(studentMentorFileType, other.studentMentorFileType)
				&& Objects.equals(uniqueKey1, other.uniqueKey1);
	}

	
	

}
