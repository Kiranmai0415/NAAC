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
@Table(name = "collaborations_linkages_main")
public class CollaborationLinkagesMain implements Serializable {

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
    public List<CollaborationsLinkages> collaborationsLinkages;
    
    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumns ({
        @JoinColumn(name="collegeId", referencedColumnName = "collegeId",nullable = false,insertable = false,updatable = false),
        @JoinColumn(name="financialYear", referencedColumnName = "financialYear",nullable = false,insertable = false,updatable = false),
        @JoinColumn(name="typeofInstitution", referencedColumnName = "typeofInstitution",nullable = false,insertable = false,updatable = false)
    })
    public List<CollaborationsLinkagesFileUpload> collaborationsLinkagesFileUpload;

	public CriteriaPrimaryKey getCriteriaId() {
		return criteriaId;
	}

	public void setCriteriaId(CriteriaPrimaryKey criteriaId) {
		this.criteriaId = criteriaId;
	}

	public List<CollaborationsLinkages> getCollaborationsLinkages() {
		return collaborationsLinkages;
	}

	public void setCollaborationsLinkages(List<CollaborationsLinkages> collaborationsLinkages) {
		this.collaborationsLinkages = collaborationsLinkages;
	}

	public List<CollaborationsLinkagesFileUpload> getCollaborationsLinkagesFileUpload() {
		return collaborationsLinkagesFileUpload;
	}

	public void setCollaborationsLinkagesFileUpload(
			List<CollaborationsLinkagesFileUpload> collaborationsLinkagesFileUpload) {
		this.collaborationsLinkagesFileUpload = collaborationsLinkagesFileUpload;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(collaborationsLinkages, collaborationsLinkagesFileUpload, criteriaId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CollaborationLinkagesMain other = (CollaborationLinkagesMain) obj;
		return Objects.equals(collaborationsLinkages, other.collaborationsLinkages)
				&& Objects.equals(collaborationsLinkagesFileUpload, other.collaborationsLinkagesFileUpload)
				&& Objects.equals(criteriaId, other.criteriaId);
	}
	    
	    
	    

}
