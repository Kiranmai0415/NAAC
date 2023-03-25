package com.adiverse.erp.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="quantitative")
public class QuantitativeData {
	private static final long serialVersionUID = -7236424143156288812L;

	private CriteriaPrimaryKey criteriaId;

	@Id
	@Column(name="unique_key1")
	private long uniqueKey1;
	 
	@Column(name="quantitative_criteria_W")
	private String qntt1;
	
	@Column(name="quantitative_criteriaTotal")
	private String qntt2;
	
	@Column(name="quantitative_criteriaWise_gradePoint")
	private String qntt3;
	
	@Column(name="quantitative_completetotal")
	private String qntt4;
	
	@Column(name="quantitative_final_cgpa")
	private String qntt5;
	
	@Column(name="quantitative_grade")
	private String qntt6;
	
	@Column(name="quantitative_comments")
	private String qntt8;
	
	
	@Column(name="quantitative_ResponseValidate")
	private String qntt7;
	  

	public String getQntt8() {
		return qntt8;
	}

	public void setQntt8(String qntt8) {
		this.qntt8 = qntt8;
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

	public String getQntt1() {
		if (qntt1!=null) {
			return qntt1;
		}
		else {
			return "";
		}
		
	}

	public void setQntt1(String qntt1) {
		this.qntt1 = qntt1;
	}

	public String getQntt2() {
		if (qntt2!=null) {
			return qntt2;
		}
		else {
			return "";
		}
	}

	public void setQntt2(String qntt2) {
		this.qntt2 = qntt2;
	}

	public String getQntt3() {
		if (qntt3!=null) {
			return qntt3;
		}
		else {
			return "";
		}
	}

	public void setQntt3(String qntt3) {
		this.qntt3 = qntt3;
	}

	public String getQntt4() {
		if (qntt4!=null) {
			return qntt4;
		}
		else {
			return "";
		}
	}

	public void setQntt4(String qntt4) {
		this.qntt4 = qntt4;
	}

	public String getQntt5() {
		if (qntt5!=null) {
			return qntt5;
		}
		else {
			return "";
		}
	}

	public void setQntt5(String qntt5) {
		this.qntt5 = qntt5;
	}

	public String getQntt6() {
		if (qntt6!=null) {
			return qntt6;
		}
		else {
			return "";
		}
	}

	public void setQntt6(String qntt6) {
		this.qntt6 = qntt6;
	}

	public String getQntt7() {
		if (qntt7!=null) {
			return qntt7;
		}
		else {
			return "";
		}
	}

	public void setQntt7(String qntt7) {
		this.qntt7 = qntt7;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(criteriaId, qntt1, qntt2, qntt3, qntt4, qntt5, qntt6, qntt7, qntt8, uniqueKey1);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		QuantitativeData other = (QuantitativeData) obj;
		return Objects.equals(criteriaId, other.criteriaId) && Objects.equals(qntt1, other.qntt1)
				&& Objects.equals(qntt2, other.qntt2) && Objects.equals(qntt3, other.qntt3)
				&& Objects.equals(qntt4, other.qntt4) && Objects.equals(qntt5, other.qntt5)
				&& Objects.equals(qntt6, other.qntt6) && Objects.equals(qntt7, other.qntt7)
				&& Objects.equals(qntt8, other.qntt8) && uniqueKey1 == other.uniqueKey1;
	}
	
	
	
}
