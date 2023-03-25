package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="phd_awardedor_registered")
public class PhdAwardedorRegistered implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
public CriteriaPrimaryKey criteriaId;
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="unique_key1")
	private long uniqueKey1;
	
	@Column(name="nameofthe_phd_scholar")
	private String inputphdt1;
	
	@Column(name="nameofthe_department")
	private String inputphdt2;
	
	@Column(name="schools_name")
	private String inputphdt3;
	
	@Column(name="nameofthe_guides")
	private String inputphdt4;
	
	@Column(name="titleofthe_thesis")
	private String inputphdt5;
	
	@Column(name="yearof_registrationof_scholar")
	private String inputphdt6;
	
	@Column(name="yearof_phd_awarded")
	private String inputphdt7;
	
	@Column(name="whether_recogas_research_guidefor ")
	private String inputphdt8;
	
	@Column(name="yearof_recognitionasa_research_guide")
	private String inputphdt9;
	
	@Column(name="curr_year")
	private String inputphdt10;

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

	public String getInputphdt1() {
		if (inputphdt1!=null) {
			return inputphdt1;
		}
		else {
			return "";
		}
		
	}

	public void setInputphdt1(String inputphdt1) {
		this.inputphdt1 = inputphdt1;
	}

	public String getInputphdt2() {
		if (inputphdt2!=null) {
			return inputphdt2;
		}
		else {
			return "";
		}
	}

	public void setInputphdt2(String inputphdt2) {
		this.inputphdt2 = inputphdt2;
	}

	public String getInputphdt3() {
		if (inputphdt3!=null) {
			return inputphdt3;
		}
		else {
			return "";
		}
	}

	public void setInputphdt3(String inputphdt3) {
		this.inputphdt3 = inputphdt3;
	}

	public String getInputphdt4() {
		if (inputphdt4!=null) {
			return inputphdt4;
		}
		else {
			return "";
		}
	}

	public void setInputphdt4(String inputphdt4) {
		this.inputphdt4 = inputphdt4;
	}

	public String getInputphdt5() {
		if (inputphdt5!=null) {
			return inputphdt5;
		}
		else {
			return "";
		}
	}

	public void setInputphdt5(String inputphdt5) {
		this.inputphdt5 = inputphdt5;
	}

	public String getInputphdt6() {
		if (inputphdt6!=null) {
			return inputphdt6;
		}
		else {
			return "";
		}
	}

	public void setInputphdt6(String inputphdt6) {
		this.inputphdt6 = inputphdt6;
	}

	public String getInputphdt7() {
		if (inputphdt7!=null) {
			return inputphdt7;
		}
		else {
			return "";
		}
	}

	public void setInputphdt7(String inputphdt7) {
		this.inputphdt7 = inputphdt7;
	}

	public String getInputphdt8() {
		if (inputphdt8!=null) {
			return inputphdt8;
		}
		else {
			return "";
		}
	}

	public void setInputphdt8(String inputphdt8) {
		this.inputphdt8 = inputphdt8;
	}

	public String getInputphdt9() {
		if (inputphdt9!=null) {
			return inputphdt9;
		}
		else {
			return "";
		}
	}

	public void setInputphdt9(String inputphdt9) {
		this.inputphdt9 = inputphdt9;
	}

	public String getInputphdt10() {
		if (inputphdt10!=null) {
			return inputphdt10;
		}
		else {
			return "";
		}
	}

	public void setInputphdt10(String inputphdt10) {
		this.inputphdt10 = inputphdt10;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(criteriaId, inputphdt1, inputphdt10, inputphdt2, inputphdt3, inputphdt4, inputphdt5,
				inputphdt6, inputphdt7, inputphdt8, inputphdt9, uniqueKey1);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PhdAwardedorRegistered other = (PhdAwardedorRegistered) obj;
		return Objects.equals(criteriaId, other.criteriaId) && Objects.equals(inputphdt1, other.inputphdt1)
				&& Objects.equals(inputphdt10, other.inputphdt10) && Objects.equals(inputphdt2, other.inputphdt2)
				&& Objects.equals(inputphdt3, other.inputphdt3) && Objects.equals(inputphdt4, other.inputphdt4)
				&& Objects.equals(inputphdt5, other.inputphdt5) && Objects.equals(inputphdt6, other.inputphdt6)
				&& Objects.equals(inputphdt7, other.inputphdt7) && Objects.equals(inputphdt8, other.inputphdt8)
				&& Objects.equals(inputphdt9, other.inputphdt9) && uniqueKey1 == other.uniqueKey1;
	}
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
}
