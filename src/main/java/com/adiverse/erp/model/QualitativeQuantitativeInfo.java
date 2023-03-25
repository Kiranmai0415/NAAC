package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;


@Entity
@Table(name="qulitativequantitative_info")
public class QualitativeQuantitativeInfo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
    public CriteriaPrimaryKey criteriaId;
	
	@Column(name="qulitativequantitative_comments")
	private String qulitativequantitativeComments;
	
	@OneToMany(cascade= {CascadeType.PERSIST,CascadeType.MERGE},fetch = FetchType.LAZY)
	@NotFound(action = NotFoundAction.IGNORE)
    @JoinColumns ({
        @JoinColumn(name="collegeId", referencedColumnName = "collegeId",nullable = false,insertable = false, updatable = false),
        @JoinColumn(name="financialYear", referencedColumnName = "financialYear",nullable = false,insertable = false, updatable = false),
        @JoinColumn(name="typeofInstitution", referencedColumnName = "typeofInstitution",nullable = false,insertable = false, updatable = false)
    })
    public List<QuantitativeData> quantitativeDataList;
	
	@OneToMany(cascade= {CascadeType.PERSIST,CascadeType.MERGE},fetch = FetchType.LAZY)
	@NotFound(action = NotFoundAction.IGNORE)
    @JoinColumns ({
        @JoinColumn(name="collegeId", referencedColumnName = "collegeId",nullable = false,insertable = false, updatable = false),
        @JoinColumn(name="financialYear", referencedColumnName = "financialYear",nullable = false,insertable = false, updatable = false),
        @JoinColumn(name="typeofInstitution", referencedColumnName = "typeofInstitution",nullable = false,insertable = false, updatable = false)
    })
    public List<Qualitative> qualitative;
	
	
	@OneToMany(cascade= {CascadeType.PERSIST,CascadeType.MERGE},fetch = FetchType.LAZY)
	@NotFound(action = NotFoundAction.IGNORE)
    @JoinColumns ({
        @JoinColumn(name="collegeId", referencedColumnName = "collegeId",nullable = false,insertable = false, updatable = false),
        @JoinColumn(name="financialYear", referencedColumnName = "financialYear",nullable = false,insertable = false, updatable = false),
        @JoinColumn(name="typeofInstitution", referencedColumnName = "typeofInstitution",nullable = false,insertable = false, updatable = false)
    })
    public List<QualitativeQuantitative> qulitativequantitativeList;
	
	@OneToMany(cascade= {CascadeType.PERSIST,CascadeType.MERGE},fetch = FetchType.LAZY)
	@NotFound(action = NotFoundAction.IGNORE)
    @JoinColumns ({
        @JoinColumn(name="collegeId", referencedColumnName = "collegeId",nullable = false,insertable = false, updatable = false),
        @JoinColumn(name="financialYear", referencedColumnName = "financialYear",nullable = false,insertable = false, updatable = false),
        @JoinColumn(name="typeofInstitution", referencedColumnName = "typeofInstitution",nullable = false,insertable = false, updatable = false)
    })
    public List<QualitativeQuantitativeCriterionWise> criteriaWise;
	
	

	@OneToMany(cascade=CascadeType.ALL)
    @JoinColumns ({
        @JoinColumn(name="collegeId", referencedColumnName = "collegeId",nullable = false,insertable = false, updatable = false),
        @JoinColumn(name="financialYear", referencedColumnName = "financialYear",nullable = false,insertable = false, updatable = false),
        @JoinColumn(name="typeofInstitution", referencedColumnName = "typeofInstitution",nullable = false,insertable = false, updatable = false)
    })
    public List<QuantitativeCriterionWise> quantitativeCriterionWiseList;
	
	@OneToMany(cascade = CascadeType.ALL)
    @JoinColumns ({
        @JoinColumn(name="collegeId", referencedColumnName = "collegeId",nullable = false,insertable = false, updatable = false),
        @JoinColumn(name="financialYear", referencedColumnName = "financialYear",nullable = false,insertable = false, updatable = false),
        @JoinColumn(name="typeofInstitution", referencedColumnName = "typeofInstitution",nullable = false,insertable = false, updatable = false)
    })
	public List<QualitativeCriterionWise> qualitativeCriterionWiseList;
	

	public CriteriaPrimaryKey getCriteriaId() {
		return criteriaId;
	}

	public void setCriteriaId(CriteriaPrimaryKey criteriaId) {
		this.criteriaId = criteriaId;
	}

	public String getQulitativequantitativeComments() {
		return qulitativequantitativeComments;
	}

	public void setQulitativequantitativeComments(String qulitativequantitativeComments) {
		this.qulitativequantitativeComments = qulitativequantitativeComments;
	}

	public List<QuantitativeData> getQuantitativeDataList() {
		return quantitativeDataList;
	}

	public void setQuantitativeDataList(List<QuantitativeData> quantitativeDataList) {
		this.quantitativeDataList = quantitativeDataList;
	}

	public List<Qualitative> getQualitative() {
		return qualitative;
	}

	public void setQualitative(List<Qualitative> qualitative) {
		this.qualitative = qualitative;
	}

	public List<QualitativeQuantitative> getQulitativequantitativeList() {
		return qulitativequantitativeList;
	}

	public void setQulitativequantitativeList(List<QualitativeQuantitative> qulitativequantitativeList) {
		this.qulitativequantitativeList = qulitativequantitativeList;
	}

	public List<QualitativeQuantitativeCriterionWise> getCriteriaWise() {
		return criteriaWise;
	}

	public void setCriteriaWise(List<QualitativeQuantitativeCriterionWise> criteriaWise) {
		this.criteriaWise = criteriaWise;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(criteriaId, criteriaWise, qualitative, quantitativeDataList, qulitativequantitativeComments,
				qulitativequantitativeList);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		QualitativeQuantitativeInfo other = (QualitativeQuantitativeInfo) obj;
		return Objects.equals(criteriaId, other.criteriaId) && Objects.equals(criteriaWise, other.criteriaWise)
				&& Objects.equals(qualitative, other.qualitative)
				&& Objects.equals(quantitativeDataList, other.quantitativeDataList)
				&& Objects.equals(qulitativequantitativeComments, other.qulitativequantitativeComments)
				&& Objects.equals(qulitativequantitativeList, other.qulitativequantitativeList);
	}

	
	


}
