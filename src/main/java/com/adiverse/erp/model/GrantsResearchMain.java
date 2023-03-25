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
@Table(name = "grants_research_projects_main")
public class GrantsResearchMain implements Serializable{

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
    public List<GrantsResearchProjects> grantsResearchProjects;
    
    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumns ({
        @JoinColumn(name="collegeId", referencedColumnName = "collegeId",nullable = false,insertable = false,updatable = false),
        @JoinColumn(name="financialYear", referencedColumnName = "financialYear",nullable = false,insertable = false,updatable = false),
        @JoinColumn(name="typeofInstitution", referencedColumnName = "typeofInstitution",nullable = false,insertable = false,updatable = false)
    })
    public List<GrantsResearchProjectsFileUpload> grantsResearchProjectsFileUpload;

	public CriteriaPrimaryKey getCriteriaId() {
		return criteriaId;
	}

	public void setCriteriaId(CriteriaPrimaryKey criteriaId) {
		this.criteriaId = criteriaId;
	}

	public List<GrantsResearchProjects> getGrantsResearchProjects() {
		return grantsResearchProjects;
	}

	public void setGrantsResearchProjects(List<GrantsResearchProjects> grantsResearchProjects) {
		this.grantsResearchProjects = grantsResearchProjects;
	}

	public List<GrantsResearchProjectsFileUpload> getGrantsResearchProjectsFileUpload() {
		return grantsResearchProjectsFileUpload;
	}

	public void setGrantsResearchProjectsFileUpload(
			List<GrantsResearchProjectsFileUpload> grantsResearchProjectsFileUpload) {
		this.grantsResearchProjectsFileUpload = grantsResearchProjectsFileUpload;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(criteriaId, grantsResearchProjects, grantsResearchProjectsFileUpload);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GrantsResearchMain other = (GrantsResearchMain) obj;
		return Objects.equals(criteriaId, other.criteriaId)
				&& Objects.equals(grantsResearchProjects, other.grantsResearchProjects)
				&& Objects.equals(grantsResearchProjectsFileUpload, other.grantsResearchProjectsFileUpload);
	}
	
	
	

}
