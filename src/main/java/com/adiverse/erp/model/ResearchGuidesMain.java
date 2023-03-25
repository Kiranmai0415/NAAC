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
@Table(name ="research_guides_main")
public class ResearchGuidesMain implements Serializable{
	
	
	private static final long serialVersionUID = 2963762320319863087L;

	@EmbeddedId
	private CriteriaPrimaryKey criteriaId;
	

	@OneToMany(cascade=CascadeType.ALL)
    @JoinColumns ({
        @JoinColumn(name="collegeId", referencedColumnName = "collegeId",nullable = false,insertable = false,updatable = false),
        @JoinColumn(name="financialYear", referencedColumnName = "financialYear",nullable = false,insertable = false,updatable = false),
        @JoinColumn(name="typeofInstitution", referencedColumnName = "typeofInstitution",nullable = false,insertable = false,updatable = false)
    })
    public List<ResearchGuides> researchGuides;
    
    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumns ({
        @JoinColumn(name="collegeId", referencedColumnName = "collegeId",nullable = false,insertable = false,updatable = false),
        @JoinColumn(name="financialYear", referencedColumnName = "financialYear",nullable = false,insertable = false,updatable = false),
        @JoinColumn(name="typeofInstitution", referencedColumnName = "typeofInstitution",nullable = false,insertable = false,updatable = false)
    })
    public List<ResearchGuideFileUpload> researchGuideFileUpload;

	public CriteriaPrimaryKey getCriteriaId() {
		return criteriaId;
	}

	public void setCriteriaId(CriteriaPrimaryKey criteriaId) {
		this.criteriaId = criteriaId;
	}

	public List<ResearchGuides> getResearchGuides() {
		return researchGuides;
	}

	public void setResearchGuides(List<ResearchGuides> researchGuides) {
		this.researchGuides = researchGuides;
	}

	public List<ResearchGuideFileUpload> getResearchGuideFileUpload() {
		return researchGuideFileUpload;
	}

	public void setResearchGuideFileUpload(List<ResearchGuideFileUpload> researchGuideFileUpload) {
		this.researchGuideFileUpload = researchGuideFileUpload;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(criteriaId, researchGuideFileUpload, researchGuides);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ResearchGuidesMain other = (ResearchGuidesMain) obj;
		return Objects.equals(criteriaId, other.criteriaId)
				&& Objects.equals(researchGuideFileUpload, other.researchGuideFileUpload)
				&& Objects.equals(researchGuides, other.researchGuides);
	}

	
	
}
