package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pass_percentof_stud_fileupload")
public class PassPercentofStudentsFileUpload implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	 private CriteriaPrimaryKey criteriaId;
	
	@Id
    @Column(name="unique_key1")
	private String uniqueKey1;
	
	@Column(name = "pass_percentof_stud_file_name")
	private String passPercentofStudentFileName;
	
	@Column(name = "pass_percentof_stud_file_path")
	private String passPercentofStudentFilePath;
	
	@Column(name = "pass_percentof_stud_file_type")
	private String passPercentofStudentFileType;

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

	public String getPassPercentofStudentFileName() {
		if (passPercentofStudentFileName!=null) {
			return passPercentofStudentFileName;
		}
		else {
			return "";
		}
		
	}

	public void setPassPercentofStudentFileName(String passPercentofStudentFileName) {
		this.passPercentofStudentFileName = passPercentofStudentFileName;
	}

	public String getPassPercentofStudentFilePath() {
		if (passPercentofStudentFilePath!=null) {
			return passPercentofStudentFilePath;
		}
		else {
			return "";
		}
		
	}

	public void setPassPercentofStudentFilePath(String passPercentofStudentFilePath) {
		this.passPercentofStudentFilePath = passPercentofStudentFilePath;
	}

	public String getPassPercentofStudentFileType() {
		if (passPercentofStudentFileType!=null) {
			return passPercentofStudentFileType;
		}
		else {
			return "";
		}
		
	}

	public void setPassPercentofStudentFileType(String passPercentofStudentFileType) {
		this.passPercentofStudentFileType = passPercentofStudentFileType;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(criteriaId, passPercentofStudentFileName, passPercentofStudentFilePath,
				passPercentofStudentFileType, uniqueKey1);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PassPercentofStudentsFileUpload other = (PassPercentofStudentsFileUpload) obj;
		return Objects.equals(criteriaId, other.criteriaId)
				&& Objects.equals(passPercentofStudentFileName, other.passPercentofStudentFileName)
				&& Objects.equals(passPercentofStudentFilePath, other.passPercentofStudentFilePath)
				&& Objects.equals(passPercentofStudentFileType, other.passPercentofStudentFileType)
				&& Objects.equals(uniqueKey1, other.uniqueKey1);
	}

	
	
	

}
