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
@Table(name ="research_papers_published_main")


public class ResearchPapersMain implements Serializable {

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
    public List<ResearchPapersPublished> researchPapersPublished;
    
    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumns ({
        @JoinColumn(name="collegeId", referencedColumnName = "collegeId",nullable = false,insertable = false,updatable = false),
        @JoinColumn(name="financialYear", referencedColumnName = "financialYear",nullable = false,insertable = false,updatable = false),
        @JoinColumn(name="typeofInstitution", referencedColumnName = "typeofInstitution",nullable = false,insertable = false,updatable = false)
    })
    public List<ResearchPapersPublishedFileUpload> researchPapersPublishedFileUpload;

	public CriteriaPrimaryKey getCriteriaId() {
		return criteriaId;
	}

	public void setCriteriaId(CriteriaPrimaryKey criteriaId) {
		this.criteriaId = criteriaId;
	}

	public List<ResearchPapersPublished> getResearchPapersPublished() {
		return researchPapersPublished;
	}

	public void setResearchPapersPublished(List<ResearchPapersPublished> researchPapersPublished) {
		this.researchPapersPublished = researchPapersPublished;
	}

	public List<ResearchPapersPublishedFileUpload> getResearchPapersPublishedFileUpload() {
		return researchPapersPublishedFileUpload;
	}

	public void setResearchPapersPublishedFileUpload(
			List<ResearchPapersPublishedFileUpload> researchPapersPublishedFileUpload) {
		this.researchPapersPublishedFileUpload = researchPapersPublishedFileUpload;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(criteriaId, researchPapersPublished, researchPapersPublishedFileUpload);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ResearchPapersMain other = (ResearchPapersMain) obj;
		return Objects.equals(criteriaId, other.criteriaId)
				&& Objects.equals(researchPapersPublished, other.researchPapersPublished)
				&& Objects.equals(researchPapersPublishedFileUpload, other.researchPapersPublishedFileUpload);
	}
	    
	    
}
