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
@Table(name ="revenue_corp_train_main")
public class RevenueCorpTrainingMain implements Serializable{
	
	
	private static final long serialVersionUID = 2963762320319863087L;

	@EmbeddedId
	private CriteriaPrimaryKey criteriaId;
	

	@OneToMany(cascade=CascadeType.ALL)
    @JoinColumns ({
        @JoinColumn(name="collegeId", referencedColumnName = "collegeId",nullable = false,insertable = false,updatable = false),
        @JoinColumn(name="financialYear", referencedColumnName = "financialYear",nullable = false,insertable = false,updatable = false),
        @JoinColumn(name="typeofInstitution", referencedColumnName = "typeofInstitution",nullable = false,insertable = false,updatable = false)
    })
    public List<RevenueCorporateTraining> revenueCorporateTraining;
    
    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumns ({
        @JoinColumn(name="collegeId", referencedColumnName = "collegeId",nullable = false,insertable = false,updatable = false),
        @JoinColumn(name="financialYear", referencedColumnName = "financialYear",nullable = false,insertable = false,updatable = false),
        @JoinColumn(name="typeofInstitution", referencedColumnName = "typeofInstitution",nullable = false,insertable = false,updatable = false)
    })
    public List<RevenueCorporateTrainingFileUpload> revenueCorporateTrainingFileUpload;

	public CriteriaPrimaryKey getCriteriaId() {
		return criteriaId;
	}

	public void setCriteriaId(CriteriaPrimaryKey criteriaId) {
		this.criteriaId = criteriaId;
	}

	public List<RevenueCorporateTraining> getRevenueCorporateTraining() {
		return revenueCorporateTraining;
	}

	public void setRevenueCorporateTraining(List<RevenueCorporateTraining> revenueCorporateTraining) {
		this.revenueCorporateTraining = revenueCorporateTraining;
	}

	public List<RevenueCorporateTrainingFileUpload> getRevenueCorporateTrainingFileUpload() {
		return revenueCorporateTrainingFileUpload;
	}

	public void setRevenueCorporateTrainingFileUpload(
			List<RevenueCorporateTrainingFileUpload> revenueCorporateTrainingFileUpload) {
		this.revenueCorporateTrainingFileUpload = revenueCorporateTrainingFileUpload;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(criteriaId, revenueCorporateTraining, revenueCorporateTrainingFileUpload);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RevenueCorpTrainingMain other = (RevenueCorpTrainingMain) obj;
		return Objects.equals(criteriaId, other.criteriaId)
				&& Objects.equals(revenueCorporateTraining, other.revenueCorporateTraining)
				&& Objects.equals(revenueCorporateTrainingFileUpload, other.revenueCorporateTrainingFileUpload);
	}

	
}
