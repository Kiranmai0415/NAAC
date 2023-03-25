package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "student_mentor_ratio")
public class StudentMentorRatio implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private CriteriaPrimaryKey criteriaId;

	@Id
	@Column(name = "unique_key1")
	private long uniqueKey1;
	
	@Column(name = "year")
	private String inputsmt1;
	
	@Column(name = "dept")
	private String inputsmt2;
	
	@Column(name = "schools_name")
	private String inputsmt3;
	
	
	@Column(name = "total_noof_students")
	private String inputsmt4;
	
	@Column(name = "total_noof_faculty")
	private String inputsmt5;
	
  
	

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

	public String getInputsmt1() {
		if (inputsmt1!=null) {
			return inputsmt1;
		}
		else {
			return "";
		}
		
	}

	public void setInputsmt1(String inputsmt1) {
		this.inputsmt1 = inputsmt1;
	}

	public String getInputsmt2() {
		if (inputsmt2!=null) {
			return inputsmt2;
		}
		else {
			return "";
		}
	}

	public void setInputsmt2(String inputsmt2) {
		this.inputsmt2 = inputsmt2;
	}

	public String getInputsmt3() {
		if (inputsmt3!=null) {
			return inputsmt3;
		}
		else {
			return "";
		}
	}

	public void setInputsmt3(String inputsmt3) {
		this.inputsmt3 = inputsmt3;
	}

	public String getInputsmt4() {
		if (inputsmt4!=null) {
			return inputsmt4;
		}
		else {
			return "";
		}
	}

	public void setInputsmt4(String inputsmt4) {
		this.inputsmt4 = inputsmt4;
	}

	public String getInputsmt5() {
		if (inputsmt5!=null) {
			return inputsmt5;
		}
		else {
			return "";
		}
	}

	public void setInputsmt5(String inputsmt5) {
		this.inputsmt5 = inputsmt5;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	

}
