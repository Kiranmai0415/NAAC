package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "professional_development_programmes_main")
public class ProfessionalDevelopmenMain implements Serializable {

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
    public List<ProfessionalDevelopmentProgrammes> professionalDevelopmentProgrammes;
    
    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumns ({
        @JoinColumn(name="collegeId", referencedColumnName = "collegeId",nullable = false,insertable = false,updatable = false),
        @JoinColumn(name="financialYear", referencedColumnName = "financialYear",nullable = false,insertable = false,updatable = false),
        @JoinColumn(name="typeofInstitution", referencedColumnName = "typeofInstitution",nullable = false,insertable = false,updatable = false)
    })
    public List<ProfessionalDevelopmentProgrammesFileUpload> professionalDevelopmentProgrammesFileUpload;

	public CriteriaPrimaryKey getCriteriaId() {
		return criteriaId;
	}

	public void setCriteriaId(CriteriaPrimaryKey criteriaId) {
		this.criteriaId = criteriaId;
	}

	public List<ProfessionalDevelopmentProgrammes> getProfessionalDevelopmentProgrammes() {
		return professionalDevelopmentProgrammes;
	}

	public void setProfessionalDevelopmentProgrammes(
			List<ProfessionalDevelopmentProgrammes> professionalDevelopmentProgrammes) {
		this.professionalDevelopmentProgrammes = professionalDevelopmentProgrammes;
	}

	public List<ProfessionalDevelopmentProgrammesFileUpload> getProfessionalDevelopmentProgrammesFileUpload() {
		return professionalDevelopmentProgrammesFileUpload;
	}

	public void setProfessionalDevelopmentProgrammesFileUpload(
			List<ProfessionalDevelopmentProgrammesFileUpload> professionalDevelopmentProgrammesFileUpload) {
		this.professionalDevelopmentProgrammesFileUpload = professionalDevelopmentProgrammesFileUpload;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	  	    
}
