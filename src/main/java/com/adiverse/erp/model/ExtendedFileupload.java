package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Extended_Fileupload")
public class ExtendedFileupload implements Serializable {
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

  private CriteriaPrimaryKey criteriaId;
	
    @Id
    @Column(name="unique_key1")
	private String uniqueKey1;
    
    
	 
	@Column(name = "executive_file_name")
	private String extendedFileName;
	
	@Column(name = "executive_file_path")
	private String extendedFilePath;
	
	@Column(name = "executive_file_type")
	private String extendedFileType;

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

	public String getExtendedFileName() {
		return extendedFileName;
	}

	public void setExtendedFileName(String extendedFileName) {
		this.extendedFileName = extendedFileName;
	}

	public String getExtendedFilePath() {
		return extendedFilePath;
	}

	public void setExtendedFilePath(String extendedFilePath) {
		this.extendedFilePath = extendedFilePath;
	}

	public String getExtendedFileType() {
		return extendedFileType;
	}

	public void setExtendedFileType(String extendedFileType) {
		this.extendedFileType = extendedFileType;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(criteriaId, extendedFileName, extendedFilePath, extendedFileType, uniqueKey1);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ExtendedFileupload other = (ExtendedFileupload) obj;
		return Objects.equals(criteriaId, other.criteriaId) && Objects.equals(extendedFileName, other.extendedFileName)
				&& Objects.equals(extendedFilePath, other.extendedFilePath)
				&& Objects.equals(extendedFileType, other.extendedFileType)
				&& Objects.equals(uniqueKey1, other.uniqueKey1);
	}

	

	

}