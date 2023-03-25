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
@Table(name="phd_awardedor_registered_main")
public class PhdAwardedorRegisteredMain implements Serializable {

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
    public List<PhdAwardedorRegistered> phdAwardedorRegistered;
    
    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumns ({
        @JoinColumn(name="collegeId", referencedColumnName = "collegeId",nullable = false,insertable = false,updatable = false),
        @JoinColumn(name="financialYear", referencedColumnName = "financialYear",nullable = false,insertable = false,updatable = false),
        @JoinColumn(name="typeofInstitution", referencedColumnName = "typeofInstitution",nullable = false,insertable = false,updatable = false)
    })
    public List<PhdAwardedorRegisteredFileUpload> phdAwardedorRegisteredFileUpload;

	public CriteriaPrimaryKey getCriteriaId() {
		return criteriaId;
	}

	public void setCriteriaId(CriteriaPrimaryKey criteriaId) {
		this.criteriaId = criteriaId;
	}

	public List<PhdAwardedorRegistered> getPhdAwardedorRegistered() {
		return phdAwardedorRegistered;
	}

	public void setPhdAwardedorRegistered(List<PhdAwardedorRegistered> phdAwardedorRegistered) {
		this.phdAwardedorRegistered = phdAwardedorRegistered;
	}

	public List<PhdAwardedorRegisteredFileUpload> getPhdAwardedorRegisteredFileUpload() {
		return phdAwardedorRegisteredFileUpload;
	}

	public void setPhdAwardedorRegisteredFileUpload(
			List<PhdAwardedorRegisteredFileUpload> phdAwardedorRegisteredFileUpload) {
		this.phdAwardedorRegisteredFileUpload = phdAwardedorRegisteredFileUpload;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(criteriaId, phdAwardedorRegistered, phdAwardedorRegisteredFileUpload);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PhdAwardedorRegisteredMain other = (PhdAwardedorRegisteredMain) obj;
		return Objects.equals(criteriaId, other.criteriaId)
				&& Objects.equals(phdAwardedorRegistered, other.phdAwardedorRegistered)
				&& Objects.equals(phdAwardedorRegisteredFileUpload, other.phdAwardedorRegisteredFileUpload);
	}
	
	
	
	
	
	
	
}
