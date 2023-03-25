package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "research_guides_fileupload")
public class ResearchGuideFileUpload implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private CriteriaPrimaryKey criteriaId;
	
	@Id
    @Column(name="unique_key1")
	private String uniqueKey1;
	
	@Column(name = "research_guide_file_name")
	private String researchGuideFileName;
	
	@Column(name = "research_guide_file_path")
	private String researchGuideFilePath;
	
	@Column(name = "research_guide_file_type")
	private String researchGuideFileType;

	public String getUniqueKey1() {
		return uniqueKey1;
	}

	public void setUniqueKey1(String uniqueKey1) {
		this.uniqueKey1 = uniqueKey1;
	}

	public String getResearchGuideFileName() {
		if (researchGuideFileName!=null) {
			return researchGuideFileName;
		}
		else {
			return "";
		}
		
	}

	public void setResearchGuideFileName(String researchGuideFileName) {
		this.researchGuideFileName = researchGuideFileName;
	}

	public String getResearchGuideFilePath() {
		if (researchGuideFilePath!=null) {
			return researchGuideFilePath;
		}
		else {
			return "";
		}
	}

	public void setResearchGuideFilePath(String researchGuideFilePath) {
		this.researchGuideFilePath = researchGuideFilePath;
	}

	public String getResearchGuideFileType() {
		if (researchGuideFileType!=null) {
			return researchGuideFileType;
		}
		else {
			return "";
		}
		
	}

	public void setResearchGuideFileType(String researchGuideFileType) {
		this.researchGuideFileType = researchGuideFileType;
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
		return Objects.hash(criteriaId, researchGuideFileName, researchGuideFilePath, researchGuideFileType,
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
		ResearchGuideFileUpload other = (ResearchGuideFileUpload) obj;
		return Objects.equals(criteriaId, other.criteriaId)
				&& Objects.equals(researchGuideFileName, other.researchGuideFileName)
				&& Objects.equals(researchGuideFilePath, other.researchGuideFilePath)
				&& Objects.equals(researchGuideFileType, other.researchGuideFileType)
				&& Objects.equals(uniqueKey1, other.uniqueKey1);
	}

	
	
	


}
