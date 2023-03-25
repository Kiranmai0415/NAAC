package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="Affiliated_YearTable41212")
public class Affiliated_YearTable41212 implements Serializable
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
    private String input41212y;
	
	@Column(name = "agumentation")
    private String input41212v;

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

	public String getInput41212y() {
		if(input41212y !=null) {
		return input41212y;
	}else {
		return "";
	}
	}

	public void setInput41212y(String input41212y) {
		this.input41212y = input41212y;
	}

	public String getInput41212v() {
		if(input41212v !=null) {
		return input41212v;
	}else {
		return "";
	}
	}

	public void setInput41212v(String input41212v) {
		this.input41212v = input41212v;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(criteriaId, input41212v, input41212y, uniqueKey1);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Affiliated_YearTable41212 other = (Affiliated_YearTable41212) obj;
		return Objects.equals(criteriaId, other.criteriaId) && Objects.equals(input41212v, other.input41212v)
				&& Objects.equals(input41212y, other.input41212y) && uniqueKey1 == other.uniqueKey1;
	}

	
	
}
