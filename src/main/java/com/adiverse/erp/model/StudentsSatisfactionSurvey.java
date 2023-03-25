package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "students_satisf_survey")
public class StudentsSatisfactionSurvey implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	@Id
    @Column(name="unique_key1")
	private long uniqueKey1;
	
	@Column(name = "nameof_student")
	private String inputsst1;
	
	@Column(name = "dept")
	private String inputsst2;
	
	@Column(name = "schools_name")
	private String inputsst3;
	
	@Column(name = "gender")
	private String inputsst4;
	
	@Column(name = "category")
	private String inputsst5;
	
	@Column(name = "stateof_domicile")
	private String inputsst6;
	
	@Column(name = "nationif_otherthan_ind")
	private String inputsst7;
	
	@Column(name = "emailid")
	private String inputsst8;
	
	@Column(name = "progm_name")
	private String inputsst9;
	
	@Column(name = "student_uniq_enroll_id")
	private String inputsst10;
	
	@Column(name = "mob_no")
	private String inputsst11;
	
	@Column(name = "yrof_joining")
	private String inputsst12;

	public long getUniqueKey1() {
		return uniqueKey1;
	}

	public void setUniqueKey1(long uniqueKey1) {
		this.uniqueKey1 = uniqueKey1;
	}

	public String getInputsst1() {
		if (inputsst1!=null) {
			return inputsst1;
		}
		else {
			return "";
		}
		
	}

	public void setInputsst1(String inputsst1) {
		this.inputsst1 = inputsst1;
	}

	public String getInputsst2() {
		if (inputsst2!=null) {
			return inputsst2;
		}
		else {
			return "";
		}
		
	}

	public void setInputsst2(String inputsst2) {
		this.inputsst2 = inputsst2;
	}

	public String getInputsst3() {
		if (inputsst3!=null) {
			return inputsst3;
		}
		else {
			return "";
		}
		
	}

	public void setInputsst3(String inputsst3) {
		this.inputsst3 = inputsst3;
	}

	public String getInputsst4() {
		if (inputsst4!=null) {
			return inputsst4;
		}
		else {
			return "";
		}
	}

	public void setInputsst4(String inputsst4) {
		this.inputsst4 = inputsst4;
	}

	public String getInputsst5() {
		if (inputsst5!=null) {
			return inputsst5;
		}
		else {
			return "";
		}
	}

	public void setInputsst5(String inputsst5) {
		this.inputsst5 = inputsst5;
	}

	public String getInputsst6() {
		if (inputsst6!=null) {
			return inputsst6;
		}
		else {
			return "";
		}
	}

	public void setInputsst6(String inputsst6) {
		this.inputsst6 = inputsst6;
	}

	public String getInputsst7() {
		if (inputsst7!=null) {
			return inputsst7;
		}
		else {
			return "";
		}
	}

	public void setInputsst7(String inputsst7) {
		this.inputsst7 = inputsst7;
	}

	public String getInputsst8() {
		if (inputsst8!=null) {
			return inputsst8;
		}
		else {
			return "";
		}
	}

	public void setInputsst8(String inputsst8) {
		this.inputsst8 = inputsst8;
	}

	public String getInputsst9() {
		if (inputsst9!=null) {
			return inputsst9;
		}
		else {
			return "";
		}
	}

	public void setInputsst9(String inputsst9) {
		this.inputsst9 = inputsst9;
	}

	public String getInputsst10() {
		if (inputsst10!=null) {
			return inputsst10;
		}
		else {
			return "";
		}
	}

	public void setInputsst10(String inputsst10) {
		this.inputsst10 = inputsst10;
	}

	public String getInputsst11() {
		if (inputsst11!=null) {
			return inputsst11;
		}
		else {
			return "";
		} 
	}

	public void setInputsst11(String inputsst11) {
		this.inputsst11 = inputsst11;
	}

	public String getInputsst12() {
		if (inputsst12!=null) {
			return inputsst12;
		}
		else {
			return "";
		}
	}

	public void setInputsst12(String inputsst12) {
		this.inputsst12 = inputsst12;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(inputsst1, inputsst10, inputsst11, inputsst12, inputsst2, inputsst3, inputsst4, inputsst5,
				inputsst6, inputsst7, inputsst8, inputsst9, uniqueKey1);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StudentsSatisfactionSurvey other = (StudentsSatisfactionSurvey) obj;
		return Objects.equals(inputsst1, other.inputsst1) && Objects.equals(inputsst10, other.inputsst10)
				&& Objects.equals(inputsst11, other.inputsst11) && Objects.equals(inputsst12, other.inputsst12)
				&& Objects.equals(inputsst2, other.inputsst2) && Objects.equals(inputsst3, other.inputsst3)
				&& Objects.equals(inputsst4, other.inputsst4) && Objects.equals(inputsst5, other.inputsst5)
				&& Objects.equals(inputsst6, other.inputsst6) && Objects.equals(inputsst7, other.inputsst7)
				&& Objects.equals(inputsst8, other.inputsst8) && Objects.equals(inputsst9, other.inputsst9)
				&& uniqueKey1 == other.uniqueKey1;
	}
	
	
	

	
}
