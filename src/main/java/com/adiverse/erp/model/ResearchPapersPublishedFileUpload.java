package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="research_papers_published_fileupload")
public class ResearchPapersPublishedFileUpload implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private CriteriaPrimaryKey criteriaId;
	
    @Id
    @Column(name="unique_key1")
	private String uniqueKey1;
    
    
    @Column(name = "research_papers_published_file_name")
	private String researchPapersFileName;
	
	@Column(name = "research_papers_published_file_path")
	private String researchPapersFilePath;
	
	@Column(name = "research_papers_published_file_type")
	private String researchPapersFileType;

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

	public String getResearchPapersFileName() {
		if (researchPapersFileName!=null) {
			return researchPapersFileName;
		}
		else {
			return "";
		}
		
	}

	public void setResearchPapersFileName(String researchPapersFileName) {
		this.researchPapersFileName = researchPapersFileName;
	}

	public String getResearchPapersFilePath() {
		if (researchPapersFilePath!=null) {
			return researchPapersFilePath;
		}
		else {
			return "";
		}
		
	}

	public void setResearchPapersFilePath(String researchPapersFilePath) {
		this.researchPapersFilePath = researchPapersFilePath;
	}

	public String getResearchPapersFileType() {
		if (researchPapersFileType!=null) {
			return researchPapersFileType;
		}
		else {
			return "";
		}
		
	}

	public void setResearchPapersFileType(String researchPapersFileType) {
		this.researchPapersFileType = researchPapersFileType;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(criteriaId, researchPapersFileName, researchPapersFilePath, researchPapersFileType,
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
		ResearchPapersPublishedFileUpload other = (ResearchPapersPublishedFileUpload) obj;
		return Objects.equals(criteriaId, other.criteriaId)
				&& Objects.equals(researchPapersFileName, other.researchPapersFileName)
				&& Objects.equals(researchPapersFilePath, other.researchPapersFilePath)
				&& Objects.equals(researchPapersFileType, other.researchPapersFileType)
				&& Objects.equals(uniqueKey1, other.uniqueKey1);
	}

	
	
	
	
	
	
}
