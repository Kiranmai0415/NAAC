package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "seed_money")
public class SeedMoney implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private CriteriaPrimaryKey criteriaId;
	
	@Id
    @Column(name="unique_key1")
	private long uniqueKey1;
	
	@Column(name = "nameof_teacher_with_seedmoney")
	private String inputsmt1;
	
	@Column(name = "dept")
	private String inputsmt2;
	
	@Column(name = "schools_name")
	private String inputsmt3;
	
	@Column(name = "amountof_seedmoney_lakhs")
	private String inputsmt4;
	
	@Column(name = "yearof_receiving")
	private String inputsmt5;
	
	@Column(name = "linkof_policydoc_sanction")
	private String inputsmt6;

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

	public CriteriaPrimaryKey getCriteriaId() {
		return criteriaId;
	}

	public void setCriteriaId(CriteriaPrimaryKey criteriaId) {
		this.criteriaId = criteriaId;
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

	public String getInputsmt6() {
		if (inputsmt6!=null) {
			return inputsmt6;
		}
		else {
			return "";
		}
	}

	public void setInputsmt6(String inputsmt6) {
		this.inputsmt6 = inputsmt6;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(criteriaId, inputsmt1, inputsmt2, inputsmt3, inputsmt4, inputsmt5, inputsmt6, uniqueKey1);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SeedMoney other = (SeedMoney) obj;
		return Objects.equals(criteriaId, other.criteriaId) && Objects.equals(inputsmt1, other.inputsmt1)
				&& Objects.equals(inputsmt2, other.inputsmt2) && Objects.equals(inputsmt3, other.inputsmt3)
				&& Objects.equals(inputsmt4, other.inputsmt4) && Objects.equals(inputsmt5, other.inputsmt5)
				&& Objects.equals(inputsmt6, other.inputsmt6) && uniqueKey1 == other.uniqueKey1;
	}

	
	
}
