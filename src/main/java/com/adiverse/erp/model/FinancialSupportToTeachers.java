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
@Table(name = "financial_supto_teachers")
public class FinancialSupportToTeachers implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private CriteriaPrimaryKey criteriaId;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="unique_key1")
	private long uniqueKey1;
	
	@Column(name = "year")
	private String inputfst1;
	
	@Column(name = "nameof_teacher")
	private String inputfst2;
	
	@Column(name = "dept")
	private String inputfst3;
	
	@Column(name = "schools_name")
	private String inputfst4;
	
	@Column(name = "nameof_conf_finance_sup_provided")
	private String inputfst5;
	
	@Column(name = "nameof_profbody_memberfee_provide")
	private String inputfst6;
	
	@Column(name = "amountof_support")
	private String inputfst7;

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

	public String getInputfst1() {
		if(inputfst1 !=null) {
			return inputfst1;
		}else {
			return "";
		}
	}

	public void setInputfst1(String inputfst1) {
		this.inputfst1 = inputfst1;
	}

	public String getInputfst2() {
		if(inputfst2 !=null) {
			return inputfst2;
		}else {
			return "";
		}
	}

	public void setInputfst2(String inputfst2) {
		this.inputfst2 = inputfst2;
	}

	public String getInputfst3() {
		if(inputfst3 !=null) {
			return inputfst3;
		}else {
			return "";
		}
	}

	public void setInputfst3(String inputfst3) {
		this.inputfst3 = inputfst3;
	}

	public String getInputfst4() {
		if(inputfst4 !=null) {
			return inputfst4;
		}else {
			return "";
		}
	}

	public void setInputfst4(String inputfst4) {
		this.inputfst4 = inputfst4;
	}

	public String getInputfst5() {
		if(inputfst5 !=null) {
			return inputfst5;
		}else {
			return "";
		}
	}

	public void setInputfst5(String inputfst5) {
		this.inputfst5 = inputfst5;
	}

	public String getInputfst6() {
		if(inputfst6 !=null) {
			return inputfst6;
		}else {
			return "";
		}
	}

	public void setInputfst6(String inputfst6) {
		this.inputfst6 = inputfst6;
	}

	public String getInputfst7() {
		if(inputfst7 !=null) {
			return inputfst7;
		}else {
			return "";
		}
	}

	public void setInputfst7(String inputfst7) {
		this.inputfst7 = inputfst7;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(criteriaId, inputfst1, inputfst2, inputfst3, inputfst4, inputfst5, inputfst6, inputfst7,
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
		FinancialSupportToTeachers other = (FinancialSupportToTeachers) obj;
		return Objects.equals(criteriaId, other.criteriaId) && Objects.equals(inputfst1, other.inputfst1)
				&& Objects.equals(inputfst2, other.inputfst2) && Objects.equals(inputfst3, other.inputfst3)
				&& Objects.equals(inputfst4, other.inputfst4) && Objects.equals(inputfst5, other.inputfst5)
				&& Objects.equals(inputfst6, other.inputfst6) && Objects.equals(inputfst7, other.inputfst7)
				&& uniqueKey1 == other.uniqueKey1;
	}
	
	

	

}
