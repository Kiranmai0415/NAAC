package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "research_fel_enrol_instit_fileupload")
public class ResearchFellowsEnrolledinInstitutionFileUpload implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private CriteriaPrimaryKey criteriaId;

	@Id
    @Column(name="unique_key1")
	private String uniqueKey1;
	
	@Column(name = "research_fel_enrol_instit_file_name")
	private String researchFellowEnrolinInstituteFileName;
	
	@Column(name = "research_fel_enrol_instit_file_path")
	private String researchFellowEnrolinInstituteFilePath;
	
	@Column(name = "research_fel_enrol_instit_file_type")
	private String researchFellowEnrolinInstituteFileType;

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

	public String getResearchFellowEnrolinInstituteFileName() {
		if (researchFellowEnrolinInstituteFileName!=null) {
			return researchFellowEnrolinInstituteFileName;
		}
		else {
			return "";
		}
		
	}

	public void setResearchFellowEnrolinInstituteFileName(String researchFellowEnrolinInstituteFileName) {
		this.researchFellowEnrolinInstituteFileName = researchFellowEnrolinInstituteFileName;
	}

	public String getResearchFellowEnrolinInstituteFilePath() {
		if (researchFellowEnrolinInstituteFilePath!=null) {
			return researchFellowEnrolinInstituteFilePath;
		}
		else {
			return "";
		}
		
	}

	public void setResearchFellowEnrolinInstituteFilePath(String researchFellowEnrolinInstituteFilePath) {
		this.researchFellowEnrolinInstituteFilePath = researchFellowEnrolinInstituteFilePath;
	}

	public String getResearchFellowEnrolinInstituteFileType() {
		if (researchFellowEnrolinInstituteFileType!=null) {
			return researchFellowEnrolinInstituteFileType;
		}
		else {
			return "";
		}
		
	}

	public void setResearchFellowEnrolinInstituteFileType(String researchFellowEnrolinInstituteFileType) {
		this.researchFellowEnrolinInstituteFileType = researchFellowEnrolinInstituteFileType;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(criteriaId, researchFellowEnrolinInstituteFileName, researchFellowEnrolinInstituteFilePath,
				researchFellowEnrolinInstituteFileType, uniqueKey1);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ResearchFellowsEnrolledinInstitutionFileUpload other = (ResearchFellowsEnrolledinInstitutionFileUpload) obj;
		return Objects.equals(criteriaId, other.criteriaId)
				&& Objects.equals(researchFellowEnrolinInstituteFileName, other.researchFellowEnrolinInstituteFileName)
				&& Objects.equals(researchFellowEnrolinInstituteFilePath, other.researchFellowEnrolinInstituteFilePath)
				&& Objects.equals(researchFellowEnrolinInstituteFileType, other.researchFellowEnrolinInstituteFileType)
				&& Objects.equals(uniqueKey1, other.uniqueKey1);
	}

	
	

}
