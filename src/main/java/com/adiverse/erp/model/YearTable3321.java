package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="yeartable3321")
public class YearTable3321 implements Serializable
{
	private static final long serialVersionUID = 1L;

	private CriteriaPrimaryKey criteriaId;
	
	@Id
	@Column(name="unique_key1")
	private long uniqueKey1;
	
	@Column(name="year")
	private String input3321y;
	
	@Column(name = "workshop")
    private String input3321v;


	public String getInput3321y() {
		if (input3321y!=null) {
			return input3321y;
		}
		else {
			return "";
		}
	}

	public void setInput3321y(String input3321y) {
		this.input3321y = input3321y;
	}

	public String getInput3321v() {
		if (input3321v!=null) {
			return input3321v;
		}
		else {
			return "";
		}
	}

	public void setInput3321v(String input3321v) {
		this.input3321v = input3321v;
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

	public long getUniqueKey1() {
		return uniqueKey1;
	}

	public void setUniqueKey1(long uniqueKey1) {
		this.uniqueKey1 = uniqueKey1;
	}

	@Override
	public int hashCode() {
		return Objects.hash(criteriaId, input3321v, input3321y, uniqueKey1);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		YearTable3321 other = (YearTable3321) obj;
		return Objects.equals(criteriaId, other.criteriaId) && Objects.equals(input3321v, other.input3321v)
				&& Objects.equals(input3321y, other.input3321y) && uniqueKey1 == other.uniqueKey1;
	}

	
	
	
}
