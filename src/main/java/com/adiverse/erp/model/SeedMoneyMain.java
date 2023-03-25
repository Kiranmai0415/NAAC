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
@Table(name ="facultyawards_main")
public class SeedMoneyMain implements Serializable{
	
	
	private static final long serialVersionUID = 2963762320319863087L;

	@EmbeddedId
	private CriteriaPrimaryKey criteriaId;
	

	@OneToMany(cascade=CascadeType.ALL)
    @JoinColumns ({
        @JoinColumn(name="collegeId", referencedColumnName = "collegeId",nullable = false,insertable = false,updatable = false),
        @JoinColumn(name="financialYear", referencedColumnName = "financialYear",nullable = false,insertable = false,updatable = false),
        @JoinColumn(name="typeofInstitution", referencedColumnName = "typeofInstitution",nullable = false,insertable = false,updatable = false)
    })
    public List<SeedMoney> seedMoney;
    
    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumns ({
        @JoinColumn(name="collegeId", referencedColumnName = "collegeId",nullable = false,insertable = false,updatable = false),
        @JoinColumn(name="financialYear", referencedColumnName = "financialYear",nullable = false,insertable = false,updatable = false),
        @JoinColumn(name="typeofInstitution", referencedColumnName = "typeofInstitution",nullable = false,insertable = false,updatable = false)
    })
    public List<SeedMoneyFileUpload> SeedMoneyFileUpload;

	public CriteriaPrimaryKey getCriteriaId() {
		return criteriaId;
	}

	public void setCriteriaId(CriteriaPrimaryKey criteriaId) {
		this.criteriaId = criteriaId;
	}

	public List<SeedMoney> getSeedMoney() {
		return seedMoney;
	}

	public void setSeedMoney(List<SeedMoney> seedMoney) {
		this.seedMoney = seedMoney;
	}

	public List<SeedMoneyFileUpload> getSeedMoneyFileUpload() {
		return SeedMoneyFileUpload;
	}

	public void setSeedMoneyFileUpload(List<SeedMoneyFileUpload> seedMoneyFileUpload) {
		SeedMoneyFileUpload = seedMoneyFileUpload;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(SeedMoneyFileUpload, criteriaId, seedMoney);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SeedMoneyMain other = (SeedMoneyMain) obj;
		return Objects.equals(SeedMoneyFileUpload, other.SeedMoneyFileUpload)
				&& Objects.equals(criteriaId, other.criteriaId) && Objects.equals(seedMoney, other.seedMoney);
	}

	
}
