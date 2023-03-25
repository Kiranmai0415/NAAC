package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="affiliated_yeartable3111")
public class Affiliated_YearTable3111 implements Serializable
{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private CriteriaPrimaryKey criteriaId;
	
	@Id
	@Column(name="unique_key1")
	private long uniqueKey1;
	
	@Column(name = "year")
    private String input3111y;
	
	@Column(name = "researchprojects")
    private String input3111v;

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

	public String getInput3111y() {
		if(input3111y !=null) {
		return input3111y;
	}else {
		return "";
	}
	}

	public void setInput3111y(String input3111y) {
		this.input3111y = input3111y;
	}

	public String getInput3111v() {
		if(input3111v !=null) {
		return input3111v;
	}else {
		return "";
	}
	}

	public void setInput3111v(String input3111v) {
		this.input3111v = input3111v;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(criteriaId, input3111v, input3111y, uniqueKey1);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Affiliated_YearTable3111 other = (Affiliated_YearTable3111) obj;
		return Objects.equals(criteriaId, other.criteriaId) && Objects.equals(input3111v, other.input3111v)
				&& Objects.equals(input3111y, other.input3111y) && uniqueKey1 == other.uniqueKey1;
	}

	
	
}	

	
	
	
	

