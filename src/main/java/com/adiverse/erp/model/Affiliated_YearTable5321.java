package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="affiliated_YearTable5321")
public class Affiliated_YearTable5321 implements Serializable
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
    private String input5321y;
	
	@Column(name = "sports")
    private String input5321v;

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

	public String getInput5321y() {
		if(input5321y !=null) {
		return input5321y;
	}else {
		return "";
	}
	}

	public void setInput5321y(String input5321y) {
		this.input5321y = input5321y;
	}

	public String getInput5321v() {
		if(input5321v !=null) {
		return input5321v;
	}else {
		return "";
	}
	}

	public void setInput5321v(String input5321v) {
		this.input5321v = input5321v;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(criteriaId, input5321v, input5321y, uniqueKey1);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Affiliated_YearTable5321 other = (Affiliated_YearTable5321) obj;
		return Objects.equals(criteriaId, other.criteriaId) && Objects.equals(input5321v, other.input5321v)
				&& Objects.equals(input5321y, other.input5321y) && uniqueKey1 == other.uniqueKey1;
	}
	
	

}