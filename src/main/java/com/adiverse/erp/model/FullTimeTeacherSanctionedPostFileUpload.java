package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ft_teach_sancpost_fileupload")
public class FullTimeTeacherSanctionedPostFileUpload implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private CriteriaPrimaryKey criteriaId;
	
	@Id
    @Column(name="unique_key1")
	private String uniqueKey1;
	
	@Column(name = "sanc_post_file_name")
	private String sancPostFileName;
	
	@Column(name = "sanc_post_file_path")
	private String sancPostFilePath;
	
	@Column(name = "sanc_post_file_type")
	private String sancPostFileType;

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

	public String getSancPostFileName() {
		return sancPostFileName;
	}

	public void setSancPostFileName(String sancPostFileName) {
		this.sancPostFileName = sancPostFileName;
	}

	public String getSancPostFilePath() {
		return sancPostFilePath;
	}

	public void setSancPostFilePath(String sancPostFilePath) {
		this.sancPostFilePath = sancPostFilePath;
	}

	public String getSancPostFileType() {
		return sancPostFileType;
	}

	public void setSancPostFileType(String sancPostFileType) {
		this.sancPostFileType = sancPostFileType;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(criteriaId, sancPostFileName, sancPostFilePath, sancPostFileType, uniqueKey1);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FullTimeTeacherSanctionedPostFileUpload other = (FullTimeTeacherSanctionedPostFileUpload) obj;
		return Objects.equals(criteriaId, other.criteriaId) && Objects.equals(sancPostFileName, other.sancPostFileName)
				&& Objects.equals(sancPostFilePath, other.sancPostFilePath)
				&& Objects.equals(sancPostFileType, other.sancPostFileType)
				&& Objects.equals(uniqueKey1, other.uniqueKey1);
	}

	
	
	
}
