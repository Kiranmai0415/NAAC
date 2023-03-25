package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="quantitativequalitative_criterion_wise")
public class QualitativeQuantitativeCriterionWise implements Serializable {
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
		return criterionWiseGrade;
	}

	public void setCriterionWiseGrade(String criterionWiseGrade) {
		this.criterionWiseGrade = criterionWiseGrade;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
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

	@Override
	public int hashCode() {
		return Objects.hash(criteriaId, criterionName, criterionWiseGrade, criterionWiseWeighted, naacWeighted,
				uniqueKey1);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		QualitativeQuantitativeCriterionWise other = (QualitativeQuantitativeCriterionWise) obj;
		return Objects.equals(criteriaId, other.criteriaId) && Objects.equals(criterionName, other.criterionName)
				&& Objects.equals(criterionWiseGrade, other.criterionWiseGrade)
				&& Objects.equals(criterionWiseWeighted, other.criterionWiseWeighted)
				&& Objects.equals(naacWeighted, other.naacWeighted) && uniqueKey1 == other.uniqueKey1;
	}

	

}
