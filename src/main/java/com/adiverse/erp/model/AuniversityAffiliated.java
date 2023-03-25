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
@Table(name="auniversityaffiliated")
public class AuniversityAffiliated implements Serializable
{
	private static final long serialVersionUID = -2231411273570309611L;
	
	private CriteriaPrimaryKey criteriaId;
	
 	@Id
    @Column(name="unique_key1")
	private long uniqueKey1;
	
	
	@Column(name="college_type")
	private String inputa1t1;
	
	@Column(name="permanent_affiliation")
	private String inputa1t2;
	
	@Column(name="temporary_affiliation")
	private String inputa1t3;



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

	public String getInputa1t1() {
		if(inputa1t1 !=null) {
		return inputa1t1;
	}else {
		return "";
	}
	}

	public void setInputa1t1(String inputa1t1) {
		this.inputa1t1 = inputa1t1;
	}

	public String getInputa1t2() {
		if(inputa1t2 !=null) {
		return inputa1t2;
	}else {
		return "";
	}
	}

	public void setInputa1t2(String inputa1t2) {
		this.inputa1t2 = inputa1t2;
	}

	public String getInputa1t3() {
		if(inputa1t3 !=null) {
		return inputa1t3;
	}else {
		return "";
	}
	}

	public void setInputa1t3(String inputa1t3) {
		this.inputa1t3 = inputa1t3;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(criteriaId, inputa1t1, inputa1t2, inputa1t3, uniqueKey1);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AuniversityAffiliated other = (AuniversityAffiliated) obj;
		return Objects.equals(criteriaId, other.criteriaId) && Objects.equals(inputa1t1, other.inputa1t1)
				&& Objects.equals(inputa1t2, other.inputa1t2) && Objects.equals(inputa1t3, other.inputa1t3)
				&& uniqueKey1 == other.uniqueKey1;
	}
	
	
}
