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
@Table(name ="fellowship_main")
public class FellowshipMain implements Serializable{
	
	
	private static final long serialVersionUID = 2963762320319863087L;

	@EmbeddedId
	private CriteriaPrimaryKey criteriaId;
	

	@OneToMany(cascade=CascadeType.ALL)
    @JoinColumns ({
        @JoinColumn(name="collegeId", referencedColumnName = "collegeId",nullable = false,insertable = false,updatable = false),
        @JoinColumn(name="financialYear", referencedColumnName = "financialYear",nullable = false,insertable = false,updatable = false),
        @JoinColumn(name="typeofInstitution", referencedColumnName = "typeofInstitution",nullable = false,insertable = false,updatable = false)
    })
    public List<Fellowship> fellowship;
    
    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumns ({
        @JoinColumn(name="collegeId", referencedColumnName = "collegeId",nullable = false,insertable = false,updatable = false),
        @JoinColumn(name="financialYear", referencedColumnName = "financialYear",nullable = false,insertable = false,updatable = false),
        @JoinColumn(name="typeofInstitution", referencedColumnName = "typeofInstitution",nullable = false,insertable = false,updatable = false)
    })
    public List<FellowshipFileUpload> fellowshipFileUpload;

	public CriteriaPrimaryKey getCriteriaId() {
		return criteriaId;
	}

	public void setCriteriaId(CriteriaPrimaryKey criteriaId) {
		this.criteriaId = criteriaId;
	}

	public List<Fellowship> getFellowship() {
		return fellowship;
	}

	public void setFellowship(List<Fellowship> fellowship) {
		this.fellowship = fellowship;
	}

	public List<FellowshipFileUpload> getFellowshipFileUpload() {
		return fellowshipFileUpload;
	}

	public void setFellowshipFileUpload(List<FellowshipFileUpload> fellowshipFileUpload) {
		this.fellowshipFileUpload = fellowshipFileUpload;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(criteriaId, fellowship, fellowshipFileUpload);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FellowshipMain other = (FellowshipMain) obj;
		return Objects.equals(criteriaId, other.criteriaId) && Objects.equals(fellowship, other.fellowship)
				&& Objects.equals(fellowshipFileUpload, other.fellowshipFileUpload);
	}

	
}
