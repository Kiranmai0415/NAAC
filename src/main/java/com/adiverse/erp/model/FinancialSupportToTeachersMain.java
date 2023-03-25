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
@Table(name ="financ_support_teach_main")
public class FinancialSupportToTeachersMain implements Serializable{
	
	
	private static final long serialVersionUID = 2963762320319863087L;

	@EmbeddedId
    private CriteriaPrimaryKey criteriaId;
	

	@OneToMany(cascade=CascadeType.ALL)
    @JoinColumns ({
        @JoinColumn(name="collegeId", referencedColumnName = "collegeId",nullable = false,insertable = false,updatable = false),
        @JoinColumn(name="financialYear", referencedColumnName = "financialYear",nullable = false,insertable = false,updatable = false),
        @JoinColumn(name="typeofInstitution", referencedColumnName = "typeofInstitution",nullable = false,insertable = false,updatable = false)
    })
    public List<FinancialSupportToTeachers> financialSupportToTeachers;
	
	@OneToMany(cascade=CascadeType.ALL)
    @JoinColumns ({
        @JoinColumn(name="collegeId", referencedColumnName = "collegeId",nullable = false,insertable = false,updatable = false),
        @JoinColumn(name="financialYear", referencedColumnName = "financialYear",nullable = false,insertable = false,updatable = false),
        @JoinColumn(name="typeofInstitution", referencedColumnName = "typeofInstitution",nullable = false,insertable = false,updatable = false)
    })
    public List<FinancialSupportToTeachersFileUpload> financialSupportToTeachersFileUpload;

	public CriteriaPrimaryKey getCriteriaId() {
		return criteriaId;
	}

	public void setCriteriaId(CriteriaPrimaryKey criteriaId) {
		this.criteriaId = criteriaId;
	}

	public List<FinancialSupportToTeachers> getFinancialSupportToTeachers() {
		return financialSupportToTeachers;
	}

	public void setFinancialSupportToTeachers(List<FinancialSupportToTeachers> financialSupportToTeachers) {
		this.financialSupportToTeachers = financialSupportToTeachers;
	}

	public List<FinancialSupportToTeachersFileUpload> getFinancialSupportToTeachersFileUpload() {
		return financialSupportToTeachersFileUpload;
	}

	public void setFinancialSupportToTeachersFileUpload(
			List<FinancialSupportToTeachersFileUpload> financialSupportToTeachersFileUpload) {
		this.financialSupportToTeachersFileUpload = financialSupportToTeachersFileUpload;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(criteriaId, financialSupportToTeachers, financialSupportToTeachersFileUpload);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FinancialSupportToTeachersMain other = (FinancialSupportToTeachersMain) obj;
		return Objects.equals(criteriaId, other.criteriaId)
				&& Objects.equals(financialSupportToTeachers, other.financialSupportToTeachers)
				&& Objects.equals(financialSupportToTeachersFileUpload, other.financialSupportToTeachersFileUpload);
	}

	
    
}
