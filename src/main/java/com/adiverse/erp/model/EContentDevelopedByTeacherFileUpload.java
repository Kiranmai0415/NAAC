package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "econtent_devel_byteach_fileupload")
public class EContentDevelopedByTeacherFileUpload implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	 private CriteriaPrimaryKey criteriaId;
	
	@Id
    @Column(name="unique_key1")
	private String uniqueKey1;
	
	@Column(name = "econtent_devel_byteach_file_name")
	private String econtentDevelopedbyTeacherFileName;
	
	@Column(name = "econtent_devel_byteach_file_path")
	private String econtentDevelopedbyTeacherFilePath;
	
	@Column(name = "econtent_devel_byteach_file_type")
	private String econtentDevelopedbyTeacherFileType;

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

	public String getEcontentDevelopedbyTeacherFileName() {
		return econtentDevelopedbyTeacherFileName;
	}

	public void setEcontentDevelopedbyTeacherFileName(String econtentDevelopedbyTeacherFileName) {
		this.econtentDevelopedbyTeacherFileName = econtentDevelopedbyTeacherFileName;
	}

	public String getEcontentDevelopedbyTeacherFilePath() {
		return econtentDevelopedbyTeacherFilePath;
	}

	public void setEcontentDevelopedbyTeacherFilePath(String econtentDevelopedbyTeacherFilePath) {
		this.econtentDevelopedbyTeacherFilePath = econtentDevelopedbyTeacherFilePath;
	}

	public String getEcontentDevelopedbyTeacherFileType() {
		return econtentDevelopedbyTeacherFileType;
	}

	public void setEcontentDevelopedbyTeacherFileType(String econtentDevelopedbyTeacherFileType) {
		this.econtentDevelopedbyTeacherFileType = econtentDevelopedbyTeacherFileType;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(criteriaId, econtentDevelopedbyTeacherFileName, econtentDevelopedbyTeacherFilePath,
				econtentDevelopedbyTeacherFileType, uniqueKey1);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EContentDevelopedByTeacherFileUpload other = (EContentDevelopedByTeacherFileUpload) obj;
		return Objects.equals(criteriaId, other.criteriaId)
				&& Objects.equals(econtentDevelopedbyTeacherFileName, other.econtentDevelopedbyTeacherFileName)
				&& Objects.equals(econtentDevelopedbyTeacherFilePath, other.econtentDevelopedbyTeacherFilePath)
				&& Objects.equals(econtentDevelopedbyTeacherFileType, other.econtentDevelopedbyTeacherFileType)
				&& Objects.equals(uniqueKey1, other.uniqueKey1);
	}

	

	

}
