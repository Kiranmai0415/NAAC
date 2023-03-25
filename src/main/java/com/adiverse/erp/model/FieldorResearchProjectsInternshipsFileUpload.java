package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "field_research_proj_interns_fileupload")
public class FieldorResearchProjectsInternshipsFileUpload implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	 private CriteriaPrimaryKey criteriaId;
	
	@Id
    @Column(name="unique_key1")
	private String uniqueKey1;
	
	@Column(name = "field_research_interns_file_name")
	private String fieldResearchProjInternsFileName;
	
	@Column(name = "field_research_interns_file_path")
	private String fieldResearchProjInternsFilePath;
	
	@Column(name = "field_research_interns_file_type")
	private String fieldResearchProjInternsFileType;

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

	public String getFieldResearchProjInternsFileName() {
		return fieldResearchProjInternsFileName;
	}

	public void setFieldResearchProjInternsFileName(String fieldResearchProjInternsFileName) {
		this.fieldResearchProjInternsFileName = fieldResearchProjInternsFileName;
	}

	public String getFieldResearchProjInternsFilePath() {
		return fieldResearchProjInternsFilePath;
	}

	public void setFieldResearchProjInternsFilePath(String fieldResearchProjInternsFilePath) {
		this.fieldResearchProjInternsFilePath = fieldResearchProjInternsFilePath;
	}

	public String getFieldResearchProjInternsFileType() {
		return fieldResearchProjInternsFileType;
	}

	public void setFieldResearchProjInternsFileType(String fieldResearchProjInternsFileType) {
		this.fieldResearchProjInternsFileType = fieldResearchProjInternsFileType;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(criteriaId, fieldResearchProjInternsFileName, fieldResearchProjInternsFilePath,
				fieldResearchProjInternsFileType, uniqueKey1);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FieldorResearchProjectsInternshipsFileUpload other = (FieldorResearchProjectsInternshipsFileUpload) obj;
		return Objects.equals(criteriaId, other.criteriaId)
				&& Objects.equals(fieldResearchProjInternsFileName, other.fieldResearchProjInternsFileName)
				&& Objects.equals(fieldResearchProjInternsFilePath, other.fieldResearchProjInternsFilePath)
				&& Objects.equals(fieldResearchProjInternsFileType, other.fieldResearchProjInternsFileType)
				&& Objects.equals(uniqueKey1, other.uniqueKey1);
	}

	

}
