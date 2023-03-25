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
@Table(name ="field_research_interns_main")
public class FieldResearchInternsMain implements Serializable{
	
	
	private static final long serialVersionUID = 2963762320319863087L;

	@EmbeddedId
    private CriteriaPrimaryKey criteriaId;
	

	@OneToMany(cascade=CascadeType.ALL)
    @JoinColumns ({
        @JoinColumn(name="collegeId", referencedColumnName = "collegeId",nullable = false,insertable = false,updatable = false),
        @JoinColumn(name="financialYear", referencedColumnName = "financialYear",nullable = false,insertable = false,updatable = false),
        @JoinColumn(name="typeofInstitution", referencedColumnName = "typeofInstitution",nullable = false,insertable = false,updatable = false)
    })
    public List<FieldorResearchProjectsInternships> fieldorResearchProjectsInternships;
	
	@OneToMany(cascade=CascadeType.ALL)
    @JoinColumns ({
        @JoinColumn(name="collegeId", referencedColumnName = "collegeId",nullable = false,insertable = false,updatable = false),
        @JoinColumn(name="financialYear", referencedColumnName = "financialYear",nullable = false,insertable = false,updatable = false),
        @JoinColumn(name="typeofInstitution", referencedColumnName = "typeofInstitution",nullable = false,insertable = false,updatable = false)
    })
    public List<FieldorResearchProjectsInternshipsFileUpload> fieldorResearchProjectsInternshipsFileUpload;

	public CriteriaPrimaryKey getCriteriaId() {
		return criteriaId;
	}

	public void setCriteriaId(CriteriaPrimaryKey criteriaId) {
		this.criteriaId = criteriaId;
	}

	public List<FieldorResearchProjectsInternships> getFieldorResearchProjectsInternships() {
		return fieldorResearchProjectsInternships;
	}

	public void setFieldorResearchProjectsInternships(
			List<FieldorResearchProjectsInternships> fieldorResearchProjectsInternships) {
		this.fieldorResearchProjectsInternships = fieldorResearchProjectsInternships;
	}

	public List<FieldorResearchProjectsInternshipsFileUpload> getFieldorResearchProjectsInternshipsFileUpload() {
		return fieldorResearchProjectsInternshipsFileUpload;
	}

	public void setFieldorResearchProjectsInternshipsFileUpload(
			List<FieldorResearchProjectsInternshipsFileUpload> fieldorResearchProjectsInternshipsFileUpload) {
		this.fieldorResearchProjectsInternshipsFileUpload = fieldorResearchProjectsInternshipsFileUpload;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(criteriaId, fieldorResearchProjectsInternships,
				fieldorResearchProjectsInternshipsFileUpload);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FieldResearchInternsMain other = (FieldResearchInternsMain) obj;
		return Objects.equals(criteriaId, other.criteriaId)
				&& Objects.equals(fieldorResearchProjectsInternships, other.fieldorResearchProjectsInternships)
				&& Objects.equals(fieldorResearchProjectsInternshipsFileUpload,
						other.fieldorResearchProjectsInternshipsFileUpload);
	}

	
    
}
