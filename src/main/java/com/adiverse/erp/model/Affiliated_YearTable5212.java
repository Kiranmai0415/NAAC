package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="affiliated_YearTable5212")
public class Affiliated_YearTable5212 implements Serializable
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
    private String input5212y;
	
	@Column(name = "outgoingstudents")
    private String input5212v;

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

	public String getInput5212y() {
		if(input5212y !=null) {
		return input5212y;
	}else {
		return "";
	}
	}

	public void setInput5212y(String input5212y) {
		this.input5212y = input5212y;
	}

	public String getInput5212v() {
		if(input5212v !=null) {
		return input5212v;
	}else {
		return "";
	}
	}

	public void setInput5212v(String input5212v) {
		this.input5212v = input5212v;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(criteriaId, input5212v, input5212y, uniqueKey1);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Affiliated_YearTable5212 other = (Affiliated_YearTable5212) obj;
		return Objects.equals(criteriaId, other.criteriaId) && Objects.equals(input5212v, other.input5212v)
				&& Objects.equals(input5212y, other.input5212y) && uniqueKey1 == other.uniqueKey1;
	}
	

}
