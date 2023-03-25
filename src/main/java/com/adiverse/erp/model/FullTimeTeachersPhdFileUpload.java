package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ft_teach_phd_fileupload")
public class FullTimeTeachersPhdFileUpload implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private CriteriaPrimaryKey criteriaId;
	
	@Id
    @Column(name="unique_key1")
	private String uniqueKey1;
	
	@Column(name = "ft_teach_phd_file_name")
	private String ftTeachPhdFileName;
	
	@Column(name = "ft_teach_phd_file_path")
	private String ftTeachPhdFilePath;
	
	@Column(name = "ft_teach_phd_file_type")
	private String ftTeachPhdFileType;

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

	public String getFtTeachPhdFileName() {
		return ftTeachPhdFileName;
	}

	public void setFtTeachPhdFileName(String ftTeachPhdFileName) {
		this.ftTeachPhdFileName = ftTeachPhdFileName;
	}

	public String getFtTeachPhdFilePath() {
		return ftTeachPhdFilePath;
	}

	public void setFtTeachPhdFilePath(String ftTeachPhdFilePath) {
		this.ftTeachPhdFilePath = ftTeachPhdFilePath;
	}

	public String getFtTeachPhdFileType() {
		return ftTeachPhdFileType;
	}

	public void setFtTeachPhdFileType(String ftTeachPhdFileType) {
		this.ftTeachPhdFileType = ftTeachPhdFileType;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(criteriaId, ftTeachPhdFileName, ftTeachPhdFilePath, ftTeachPhdFileType, uniqueKey1);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FullTimeTeachersPhdFileUpload other = (FullTimeTeachersPhdFileUpload) obj;
		return Objects.equals(criteriaId, other.criteriaId)
				&& Objects.equals(ftTeachPhdFileName, other.ftTeachPhdFileName)
				&& Objects.equals(ftTeachPhdFilePath, other.ftTeachPhdFilePath)
				&& Objects.equals(ftTeachPhdFileType, other.ftTeachPhdFileType)
				&& Objects.equals(uniqueKey1, other.uniqueKey1);
	}

	


}
