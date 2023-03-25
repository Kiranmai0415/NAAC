package com.adiverse.erp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="qualitative")
public class Qualitative {
	private static final long serialVersionUID = -7236424143156288812L;

	private CriteriaPrimaryKey criteriaId;

	@Id
	@Column(name="unique_key1")
	private long uniqueKey1;

	@Column(name="qualitative_criteria_W")
	private String qlit1;
	
	@Column(name="qualitative_criteriaTotal")
	private String qlit2;
	
	@Column(name="qualitative_criteriaWise_gradePoint")
	private String qlit3;
	
	@Column(name="qualitative_completetotal")
	private String qlit4;
	
	@Column(name="qualitative_final_cgpa")
	private String qlit5;
	
	@Column(name="qualitative_grade")
	private String qlit6;
	
	@Column(name="qualitative_comments")
	private String qlit8;
	
	@Column(name="quanlitative_ResponseValidate")
	private String qlit7;
	  
	
	
	

	
	public String getQlit8() {
		if (qlit8!=null) {
			return qlit8;
		}
		else {
			return "";
		}
		
	}
	public void setQlit8(String qlit8) {
		this.qlit8 = qlit8;
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
	public String getQlit1() {
		if (qlit1!=null) {
			return qlit1;
		}
		else {
			return "";
		}
	}
	public void setQlit1(String qlit1) {
		this.qlit1 = qlit1;
	}
	public String getQlit2() {
		if (qlit2!=null) {
			return qlit8;
		}
		else {
			return "";
		}
	}
	public void setQlit2(String qlit2) {
		this.qlit2 = qlit2;
	}
	public String getQlit3() {
		if (qlit3!=null) {
			return qlit3;
		}
		else {
			return "";
		}
	}
	public void setQlit3(String qlit3) {
		this.qlit3 = qlit3;
	}
	public String getQlit4() {
		if (qlit4!=null) {
			return qlit4;
		}
		else {
			return "";
		}
	}
	public void setQlit4(String qlit4) {
		this.qlit4 = qlit4;
	}
	public String getQlit5() {
		if (qlit5!=null) {
			return qlit5;
		}
		else {
			return "";
		}
	}
	public void setQlit5(String qlit5) {
		this.qlit5 = qlit5;
	}
	public String getQlit6() {
		if (qlit6!=null) {
			return qlit6;
		}
		else {
			return "";
		}
	}
	public void setQlit6(String qlit6) {
		this.qlit6 = qlit6;
	}
	public String getQlit7() {
		if (qlit7!=null) {
			return qlit7;
		}
		else {
			return "";
		}
	}
	public void setQlit7(String qlit7) {
		this.qlit7 = qlit7;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
}
