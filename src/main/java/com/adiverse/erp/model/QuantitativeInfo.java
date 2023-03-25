package com.adiverse.erp.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="quantitative_info")
public class QuantitativeInfo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
    public CriteriaPrimaryKey criteriaId;
	
	@Column(name="quantitative_comments")
	private String quantitativeComments;
	
	/*
	 * @OneToMany(cascade=CascadeType.ALL)
	 * 
	 * @JoinColumns ({
	 * 
	 * @JoinColumn(name="collegeId", referencedColumnName = "collegeId",nullable =
	 * false),
	 * 
	 * @JoinColumn(name="financialYear", referencedColumnName =
	 * "financialYear",nullable = false),
	 * 
	 * @JoinColumn(name="typeofInstitution", referencedColumnName =
	 * "typeofInstitution",nullable = false) }) public List<QuantitativeData>
	 * quantitativeDataList
	 */;
	
//	@OneToMany(cascade=CascadeType.ALL)
//    @JoinColumns ({
//        @JoinColumn(name="collegeId", referencedColumnName = "collegeId",nullable = false),
//        @JoinColumn(name="financialYear", referencedColumnName = "financialYear",nullable = false),
//        @JoinColumn(name="typeofInstitution", referencedColumnName = "typeofInstitution",nullable = false)
//    })
//    public List<QuantitativeCriterionWise> quantitativeCriterionWiseList;

	

	public CriteriaPrimaryKey getCriteriaId() {
		return criteriaId;
	}

	public void setCriteriaId(CriteriaPrimaryKey criteriaId) {
		this.criteriaId = criteriaId;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getQuantitativeComments() {
		if (quantitativeComments!=null) {
			return quantitativeComments;
		}
		else {
			return "";
		}
		
	}

	public void setQuantitativeComments(String quantitativeComments) {
		this.quantitativeComments = quantitativeComments;
	}

	
}
