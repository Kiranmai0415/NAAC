package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "research_fel_enrol_main")
public class ResearchFellowsEnrolledMain implements Serializable{

	/**
	 * 
	 */

	private static final long serialVersionUID = 2963762320319863087L;

	@EmbeddedId
    public CriteriaPrimaryKey criteriaId;
	

	@OneToMany(cascade=CascadeType.ALL)
    @JoinColumns ({
        @JoinColumn(name="collegeId", referencedColumnName = "collegeId",nullable = false,insertable = false,updatable = false),
        @JoinColumn(name="financialYear", referencedColumnName = "financialYear",nullable = false,insertable = false,updatable = false),
        @JoinColumn(name="typeofInstitution", referencedColumnName = "typeofInstitution",nullable = false,insertable = false,updatable = false)
    })
    public List<ResearchFellowsEnrolledinInstitution> researchFellowsEnrolledinInstitution;
    
    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumns ({
        @JoinColumn(name="collegeId", referencedColumnName = "collegeId",nullable = false,insertable = false,updatable = false),
        @JoinColumn(name="financialYear", referencedColumnName = "financialYear",nullable = false,insertable = false,updatable = false),
        @JoinColumn(name="typeofInstitution", referencedColumnName = "typeofInstitution",nullable = false,insertable = false,updatable = false)
    })
    public List<ResearchFellowsEnrolledinInstitutionFileUpload> researchFellowsEnrolledinInstitutionFileUpload;

	public CriteriaPrimaryKey getCriteriaId() {
		return criteriaId;
	}

	public void setCriteriaId(CriteriaPrimaryKey criteriaId) {
		this.criteriaId = criteriaId;
	}

	public List<ResearchFellowsEnrolledinInstitution> getResearchFellowsEnrolledinInstitution() {
		return researchFellowsEnrolledinInstitution;
	}

	public void setResearchFellowsEnrolledinInstitution(
			List<ResearchFellowsEnrolledinInstitution> researchFellowsEnrolledinInstitution) {
		this.researchFellowsEnrolledinInstitution = researchFellowsEnrolledinInstitution;
	}

	public List<ResearchFellowsEnrolledinInstitutionFileUpload> getResearchFellowsEnrolledinInstitutionFileUpload() {
		return researchFellowsEnrolledinInstitutionFileUpload;
	}

	public void setResearchFellowsEnrolledinInstitutionFileUpload(
			List<ResearchFellowsEnrolledinInstitutionFileUpload> researchFellowsEnrolledinInstitutionFileUpload) {
		this.researchFellowsEnrolledinInstitutionFileUpload = researchFellowsEnrolledinInstitutionFileUpload;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(criteriaId, researchFellowsEnrolledinInstitution,
				researchFellowsEnrolledinInstitutionFileUpload);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ResearchFellowsEnrolledMain other = (ResearchFellowsEnrolledMain) obj;
		return Objects.equals(criteriaId, other.criteriaId)
				&& Objects.equals(researchFellowsEnrolledinInstitution, other.researchFellowsEnrolledinInstitution)
				&& Objects.equals(researchFellowsEnrolledinInstitutionFileUpload,
						other.researchFellowsEnrolledinInstitutionFileUpload);
	}

	
	

}
