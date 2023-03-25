package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ft_teacherswith_spec_fileupload")
public class FullTimeTeacherswithSpecializationFileUpload implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	private CriteriaPrimaryKey criteriaId;

	@Id
	@Column(name = "unique_key1")
	private String uniqueKey1;
	
	@Column(name = "ft_teacherswith_spec_file_name")
	private String fulltimeTeacherswithSpecFileName;

	@Column(name = "ft_teacherswith_spec_file_path")
	private String fulltimeTeacherswithSpecFilePath;

	@Column(name = "ft_teacherswith_spec_file_type")
	private String fulltimeTeacherswithSpecFileType;

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

	public String getFulltimeTeacherswithSpecFileName() {
		return fulltimeTeacherswithSpecFileName;
	}

	public void setFulltimeTeacherswithSpecFileName(String fulltimeTeacherswithSpecFileName) {
		this.fulltimeTeacherswithSpecFileName = fulltimeTeacherswithSpecFileName;
	}

	public String getFulltimeTeacherswithSpecFilePath() {
		return fulltimeTeacherswithSpecFilePath;
	}

	public void setFulltimeTeacherswithSpecFilePath(String fulltimeTeacherswithSpecFilePath) {
		this.fulltimeTeacherswithSpecFilePath = fulltimeTeacherswithSpecFilePath;
	}

	public String getFulltimeTeacherswithSpecFileType() {
		return fulltimeTeacherswithSpecFileType;
	}

	public void setFulltimeTeacherswithSpecFileType(String fulltimeTeacherswithSpecFileType) {
		this.fulltimeTeacherswithSpecFileType = fulltimeTeacherswithSpecFileType;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(criteriaId, fulltimeTeacherswithSpecFileName, fulltimeTeacherswithSpecFilePath,
				fulltimeTeacherswithSpecFileType, uniqueKey1);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FullTimeTeacherswithSpecializationFileUpload other = (FullTimeTeacherswithSpecializationFileUpload) obj;
		return Objects.equals(criteriaId, other.criteriaId)
				&& Objects.equals(fulltimeTeacherswithSpecFileName, other.fulltimeTeacherswithSpecFileName)
				&& Objects.equals(fulltimeTeacherswithSpecFilePath, other.fulltimeTeacherswithSpecFilePath)
				&& Objects.equals(fulltimeTeacherswithSpecFileType, other.fulltimeTeacherswithSpecFileType)
				&& uniqueKey1 == other.uniqueKey1;
	}
	
	
}
