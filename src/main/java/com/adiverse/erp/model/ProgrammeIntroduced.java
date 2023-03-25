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
@Table(name="programme_introduced")
public class ProgrammeIntroduced implements Serializable
{
	private static final long serialVersionUID = -3611436780363891166L;
	private CriteriaPrimaryKey criteriaId;
	
 	@Id
    @Column(name="unique_key1")
	private long uniqueKey1;
	
	@Column(name="year")
	private String inputbtp11;
	
	@Column(name="programmes_no")
	private String inputbtp12;
	
	@Column(name="programmes_name")
	private String inputbtp13;
	
	@Column(name="programs_ug")
	private String inputbtp14;
	
	@Column(name="programs_pg")
	private String inputbtp15;

	

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

	public String getInputbtp11() {
		if (inputbtp11!=null) {
			return inputbtp11;
		}
		else {
			return "";
		}
		
	}

	public void setInputbtp11(String inputbtp11) {
		this.inputbtp11 = inputbtp11;
	}

	public String getInputbtp12() {
		if (inputbtp12!=null) {
			return inputbtp12;
		}
		else {
			return "";
		}
		
	}

	public void setInputbtp12(String inputbtp12) {
		this.inputbtp12 = inputbtp12;
	}

	public String getInputbtp13() {
		if (inputbtp13!=null) {
			return inputbtp13;
		}
		else {
			return "";
		}
		
	}

	public void setInputbtp13(String inputbtp13) {
		this.inputbtp13 = inputbtp13;
	}

	public String getInputbtp14() {
		if (inputbtp14!=null) {
			return inputbtp14;
		}
		else {
			return "";
		}
		
	}

	public void setInputbtp14(String inputbtp14) {
		this.inputbtp14 = inputbtp14;
	}

	public String getInputbtp15() {
		if (inputbtp15!=null) {
			return inputbtp15;
		}
		else {
			return "";
		}
		
	}

	public void setInputbtp15(String inputbtp15) {
		this.inputbtp15 = inputbtp15;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(criteriaId, inputbtp11, inputbtp12, inputbtp13, inputbtp14, inputbtp15, uniqueKey1);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProgrammeIntroduced other = (ProgrammeIntroduced) obj;
		return Objects.equals(criteriaId, other.criteriaId) && Objects.equals(inputbtp11, other.inputbtp11)
				&& Objects.equals(inputbtp12, other.inputbtp12) && Objects.equals(inputbtp13, other.inputbtp13)
				&& Objects.equals(inputbtp14, other.inputbtp14) && Objects.equals(inputbtp15, other.inputbtp15)
				&& uniqueKey1 == other.uniqueKey1;
	}
	
	
	
}