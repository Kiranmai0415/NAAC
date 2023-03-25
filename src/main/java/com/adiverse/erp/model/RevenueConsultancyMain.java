package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name ="revenue_consultancy_main")
public class RevenueConsultancyMain implements Serializable{
	
	
	private static final long serialVersionUID = 2963762320319863087L;

	@Id
	private CriteriaPrimaryKey criteriaId;
	

	@OneToMany(cascade=CascadeType.ALL)
    @JoinColumns ({
        @JoinColumn(name="collegeId", referencedColumnName = "collegeId",nullable = false,insertable = false,updatable = false),
        @JoinColumn(name="financialYear", referencedColumnName = "financialYear",nullable = false,insertable = false,updatable = false),
        @JoinColumn(name="typeofInstitution", referencedColumnName = "typeofInstitution",nullable = false,insertable = false,updatable = false)
    })
    public List<RevenueConsultancy> revenueConsultancy;
    
    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumns ({
        @JoinColumn(name="collegeId", referencedColumnName = "collegeId",nullable = false,insertable = false,updatable = false),
        @JoinColumn(name="financialYear", referencedColumnName = "financialYear",nullable = false,insertable = false,updatable = false),
        @JoinColumn(name="typeofInstitution", referencedColumnName = "typeofInstitution",nullable = false,insertable = false,updatable = false)
    })
    public List<RevenueConsultancyFileUpload> revenueConsultancyFileUpload;

	public CriteriaPrimaryKey getCriteriaId() {
		return criteriaId;
	}

	public void setCriteriaId(CriteriaPrimaryKey criteriaId) {
		this.criteriaId = criteriaId;
	}

	public List<RevenueConsultancy> getRevenueConsultancy() {
		return revenueConsultancy;
	}

	public void setRevenueConsultancy(List<RevenueConsultancy> revenueConsultancy) {
		this.revenueConsultancy = revenueConsultancy;
	}

	public List<RevenueConsultancyFileUpload> getRevenueConsultancyFileUpload() {
		return revenueConsultancyFileUpload;
	}

	public void setRevenueConsultancyFileUpload(List<RevenueConsultancyFileUpload> revenueConsultancyFileUpload) {
		this.revenueConsultancyFileUpload = revenueConsultancyFileUpload;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	
	
}
