package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "field_research_proj_interns")
public class FieldorResearchProjectsInternships implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private CriteriaPrimaryKey criteriaId;
	
	@Id
    @Column(name="unique_key1")
	private long uniqueKey1;
	
	@Column(name = "progm_code")
	private String inputfrit1;
	
	@Column(name = "progm_name")
	private String inputfrit2;
	
	@Column(name = "dept")
	private String inputfrit3;
	
	@Column(name = "schools_name")
	private String inputfrit4;
	
	@Column(name = "noof_students")
	private String inputfrit5;
	
	@Column(name = "linkto_relv__doc")
	private String inputfrit6;

	@Column(name = "noof_students_undertaking")
	private String inputfrit7;

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

	public String getInputfrit1() {
		return inputfrit1;
	}

	public void setInputfrit1(String inputfrit1) {
		this.inputfrit1 = inputfrit1;
	}

	public String getInputfrit2() {
		return inputfrit2;
	}

	public void setInputfrit2(String inputfrit2) {
		this.inputfrit2 = inputfrit2;
	}

	public String getInputfrit3() {
		return inputfrit3;
	}

	public void setInputfrit3(String inputfrit3) {
		this.inputfrit3 = inputfrit3;
	}

	public String getInputfrit4() {
		return inputfrit4;
	}

	public void setInputfrit4(String inputfrit4) {
		this.inputfrit4 = inputfrit4;
	}

	public String getInputfrit5() {
		return inputfrit5;
	}

	public void setInputfrit5(String inputfrit5) {
		this.inputfrit5 = inputfrit5;
	}

	public String getInputfrit6() {
		return inputfrit6;
	}

	public void setInputfrit6(String inputfrit6) {
		this.inputfrit6 = inputfrit6;
	}

	public String getInputfrit7() {
		return inputfrit7;
	}

	public void setInputfrit7(String inputfrit7) {
		this.inputfrit7 = inputfrit7;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(criteriaId, inputfrit1, inputfrit2, inputfrit3, inputfrit4, inputfrit5, inputfrit6,
				inputfrit7, uniqueKey1);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FieldorResearchProjectsInternships other = (FieldorResearchProjectsInternships) obj;
		return Objects.equals(criteriaId, other.criteriaId) && Objects.equals(inputfrit1, other.inputfrit1)
				&& Objects.equals(inputfrit2, other.inputfrit2) && Objects.equals(inputfrit3, other.inputfrit3)
				&& Objects.equals(inputfrit4, other.inputfrit4) && Objects.equals(inputfrit5, other.inputfrit5)
				&& Objects.equals(inputfrit6, other.inputfrit6) && Objects.equals(inputfrit7, other.inputfrit7)
				&& uniqueKey1 == other.uniqueKey1;
	}

	
	
	

}
