package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "grants_research_proj_fileupload")
public class GrantsResearchProjectsFileUpload  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private CriteriaPrimaryKey criteriaId;
	
	@Id
    @Column(name="unique_key1")
	private String uniqueKey1;
	
	@Column(name = "grants_research_proj_file_name")
	private String grantsResearchProjectsFileName;
	
	@Column(name = "grants_research_proj_file_path")
	private String  grantsResearchProjectsFilePath;
	
	@Column(name = "grants_research_proj_file_type")
	private String  grantsResearchProjectsFileType;

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

	public String getGrantsResearchProjectsFileName() {
		return grantsResearchProjectsFileName;
	}

	public void setGrantsResearchProjectsFileName(String grantsResearchProjectsFileName) {
		this.grantsResearchProjectsFileName = grantsResearchProjectsFileName;
	}

	public String getGrantsResearchProjectsFilePath() {
		return grantsResearchProjectsFilePath;
	}

	public void setGrantsResearchProjectsFilePath(String grantsResearchProjectsFilePath) {
		this.grantsResearchProjectsFilePath = grantsResearchProjectsFilePath;
	}

	public String getGrantsResearchProjectsFileType() {
		return grantsResearchProjectsFileType;
	}

	public void setGrantsResearchProjectsFileType(String grantsResearchProjectsFileType) {
		this.grantsResearchProjectsFileType = grantsResearchProjectsFileType;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(criteriaId, grantsResearchProjectsFileName, grantsResearchProjectsFilePath,
				grantsResearchProjectsFileType, uniqueKey1);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GrantsResearchProjectsFileUpload other = (GrantsResearchProjectsFileUpload) obj;
		return Objects.equals(criteriaId, other.criteriaId)
				&& Objects.equals(grantsResearchProjectsFileName, other.grantsResearchProjectsFileName)
				&& Objects.equals(grantsResearchProjectsFilePath, other.grantsResearchProjectsFilePath)
				&& Objects.equals(grantsResearchProjectsFileType, other.grantsResearchProjectsFileType)
				&& Objects.equals(uniqueKey1, other.uniqueKey1);
	}

	
}
