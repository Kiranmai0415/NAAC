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
@Table(name ="noof_workshops_main")
public class NumberofWorkshopsSeminorsMain implements Serializable{
	
	
	private static final long serialVersionUID = 2963762320319863087L;

	@EmbeddedId
    private CriteriaPrimaryKey criteriaId;
	

	@OneToMany(cascade=CascadeType.ALL)
    @JoinColumns ({
        @JoinColumn(name="collegeId", referencedColumnName = "collegeId",nullable = false,insertable = false,updatable = false),
        @JoinColumn(name="financialYear", referencedColumnName = "financialYear",nullable = false,insertable = false,updatable = false),
        @JoinColumn(name="typeofInstitution", referencedColumnName = "typeofInstitution",nullable = false,insertable = false,updatable = false)
    })
    public List<NumberofWorkshopsorSeminars> numberofWorkshopsorSeminars;
	
	@OneToMany(cascade=CascadeType.ALL)
    @JoinColumns ({
        @JoinColumn(name="collegeId", referencedColumnName = "collegeId",nullable = false,insertable = false,updatable = false),
        @JoinColumn(name="financialYear", referencedColumnName = "financialYear",nullable = false,insertable = false,updatable = false),
        @JoinColumn(name="typeofInstitution", referencedColumnName = "typeofInstitution",nullable = false,insertable = false,updatable = false)
    })
    public List<NumberofWorkshopsorSeminarsFileUpload> numberofWorkshopsorSeminarsFileUpload;

	public CriteriaPrimaryKey getCriteriaId() {
		return criteriaId;
	}

	public void setCriteriaId(CriteriaPrimaryKey criteriaId) {
		this.criteriaId = criteriaId;
	}

	public List<NumberofWorkshopsorSeminars> getNumberofWorkshopsorSeminars() {
		return numberofWorkshopsorSeminars;
	}

	public void setNumberofWorkshopsorSeminars(List<NumberofWorkshopsorSeminars> numberofWorkshopsorSeminars) {
		this.numberofWorkshopsorSeminars = numberofWorkshopsorSeminars;
	}

	public List<NumberofWorkshopsorSeminarsFileUpload> getNumberofWorkshopsorSeminarsFileUpload() {
		return numberofWorkshopsorSeminarsFileUpload;
	}

	public void setNumberofWorkshopsorSeminarsFileUpload(
			List<NumberofWorkshopsorSeminarsFileUpload> numberofWorkshopsorSeminarsFileUpload) {
		this.numberofWorkshopsorSeminarsFileUpload = numberofWorkshopsorSeminarsFileUpload;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(criteriaId, numberofWorkshopsorSeminars, numberofWorkshopsorSeminarsFileUpload);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NumberofWorkshopsSeminorsMain other = (NumberofWorkshopsSeminorsMain) obj;
		return Objects.equals(criteriaId, other.criteriaId)
				&& Objects.equals(numberofWorkshopsorSeminars, other.numberofWorkshopsorSeminars)
				&& Objects.equals(numberofWorkshopsorSeminarsFileUpload, other.numberofWorkshopsorSeminarsFileUpload);
	}

	
    
}
