package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="affiliated_yeartable342")
public class Affiliated_YearTable342 implements Serializable
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
    private String input342y;
	
	@Column(name = "awards")
    private String input342v;

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

	public String getInput342y() {
		if(input342y !=null) {
		return input342y;
	}else {
		return "";
	}
	}

	public void setInput342y(String input342y) {
		this.input342y = input342y;
	}

	public String getInput342v() {
		if(input342v !=null) {
		return input342v;
	}else {
		return "";
	}
	}

	public void setInput342v(String input342v) {
		this.input342v = input342v;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(criteriaId, input342v, input342y, uniqueKey1);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Affiliated_YearTable342 other = (Affiliated_YearTable342) obj;
		return Objects.equals(criteriaId, other.criteriaId) && Objects.equals(input342v, other.input342v)
				&& Objects.equals(input342y, other.input342y) && uniqueKey1 == other.uniqueKey1;
	}
	
	
	
	
}
