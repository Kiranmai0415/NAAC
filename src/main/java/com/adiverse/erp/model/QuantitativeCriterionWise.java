package com.adiverse.erp.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="quantitative_criterion_wise")
public class QuantitativeCriterionWise implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private CriteriaPrimaryKey criteriaId;

	@Id
	@Column(name="unique_key1")
	private long uniqueKey1;
	
	@Column(name = "criterion_name")
	private String criterionName;
	
	@Column(name = "naac_weighted")
	private String naacWeighted;
	
	@Column(name = "Criterion_wise_weighted")
	private String criterionWiseWeighted;
	
	@Column(name = "Criterion_wise_grade")
	private String criterionWiseGrade;

	
	@Column(name = "kiwise_total")
	private String kiwisetotal;
	
	
	


	public String getKiwisetotal() {
		return kiwisetotal;
	}

	public void setKiwisetotal(String kiwisetotal) {
		this.kiwisetotal = kiwisetotal;
	}

	public CriteriaPrimaryKey getCriteriaId() {
		return criteriaId;
	}

	public void setCriteriaId(CriteriaPrimaryKey criteriaId) {
		this.criteriaId = criteriaId;
	}

	public long getUniqueKey1() {
		return uniqueKey1;
	}

	public void setUniqueKey1(long uniqueKey1) {
		this.uniqueKey1 = uniqueKey1;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getNaacWeighted() {
		if (naacWeighted!=null) {
			return naacWeighted;
		}
		else {
			return "";
		}
		
	}

	public void setNaacWeighted(String naacWeighted) {
		this.naacWeighted = naacWeighted;
	}

	public String getCriterionWiseWeighted() {
		if (criterionWiseWeighted!=null) {
			return criterionWiseWeighted;
		}
		else {
			return "";
		}
		
	}

	public void setCriterionWiseWeighted(String criterionWiseWeighted) {
		this.criterionWiseWeighted = criterionWiseWeighted;
	}

	public String getCriterionWiseGrade() {
		if (criterionWiseGrade!=null) {
			return criterionWiseGrade;
		}
		else {
			return "";
		}
		
	}

	public void setCriterionWiseGrade(String criterionWiseGrade) {
		this.criterionWiseGrade = criterionWiseGrade;
	}

	public String getCriterionName() {
		if (criterionName!=null) {
			return criterionName;
		}
		else {
			return "";
		}
		
	}

	public void setCriterionName(String criterionName) {
		this.criterionName = criterionName;
	}

	

}
