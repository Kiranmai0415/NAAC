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
@Table(name ="affiliated_department")
public class AffiliatedDepartment implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

private CriteriaPrimaryKey criteriaId;
	
    @Id
    @Column(name="unique_key1")
	private String uniqueKey1;
    
    
	@Column(name = "faculty")
    private String inputdt1;
	
	@Column(name = "departments")
    private String inputdt2;
	
	@Column(name = "ug")
    private String inputdt3;
	
	@Column(name = "pg")
    private String inputdt4;
	
	@Column(name = "research")
    private String inputdt5;

	

	public String getInputdt1() {
		if(inputdt1 !=null) {
		return inputdt1;
	}else {
		return "";
	}
	}

	public void setInputdt1(String inputdt1) {
		this.inputdt1 = inputdt1;
	}

	public String getInputdt2() {
		if(inputdt2 !=null) {
		return inputdt2;
	}else {
		return "";
	}
	}

	public void setInputdt2(String inputdt2) {
		this.inputdt2 = inputdt2;
	}

	public String getInputdt3() {
		if(inputdt3 !=null) {
		return inputdt3;
	}else {
		return "";
	}
	}

	public void setInputdt3(String inputdt3) {
		this.inputdt3 = inputdt3;
	}

	public String getInputdt4() {
		if(inputdt4 !=null) {
		return inputdt4;
	}else {
		return "";
	}
	}

	public void setInputdt4(String inputdt4) {
		this.inputdt4 = inputdt4;
	}

	public String getInputdt5() {
		if(inputdt5 !=null) {
		return inputdt5;
	}else {
		return "";
	}
	}

	public void setInputdt5(String inputdt5) {
		this.inputdt5 = inputdt5;
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

	public String getUniqueKey1() {
		return uniqueKey1;
	}

	public void setUniqueKey1(String uniqueKey1) {
		this.uniqueKey1 = uniqueKey1;
	}

	@Override
	public int hashCode() {
		return Objects.hash(criteriaId, inputdt1, inputdt2, inputdt3, inputdt4, inputdt5, uniqueKey1);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AffiliatedDepartment other = (AffiliatedDepartment) obj;
		return Objects.equals(criteriaId, other.criteriaId) && Objects.equals(inputdt1, other.inputdt1)
				&& Objects.equals(inputdt2, other.inputdt2) && Objects.equals(inputdt3, other.inputdt3)
				&& Objects.equals(inputdt4, other.inputdt4) && Objects.equals(inputdt5, other.inputdt5)
				&& Objects.equals(uniqueKey1, other.uniqueKey1);
	}

	
	
	
	
	
	
	
	
}	

	
	
	
	

