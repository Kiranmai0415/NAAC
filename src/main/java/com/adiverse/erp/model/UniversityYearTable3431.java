package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="universityyeartable3431")
public class UniversityYearTable3431 implements Serializable
{
	private static final long serialVersionUID = 1L;

	private CriteriaPrimaryKey criteriaId;
	
	@Id
	@Column(name="unique_key1")
	private long uniqueKey1;
	
	@Column(name="year")
	private String input3431y;
	
	@Column(name="published_awarded")
	private String input3431v;

	

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

	public String getInput3431y() {
		if (input3431y!=null) {
			return input3431y;
		}
		else {
			return "";
		}
		
	}

	public void setInput3431y(String input3431y) {
		this.input3431y = input3431y;
	}

	public String getInput3431v() {
		if (input3431v!=null) {
			return input3431v;
		}
		else {
			return "";
		}
		
	}

	public void setInput3431v(String input3431v) {
		this.input3431v = input3431v;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(criteriaId, input3431v, input3431y, uniqueKey1);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UniversityYearTable3431 other = (UniversityYearTable3431) obj;
		return Objects.equals(criteriaId, other.criteriaId) && Objects.equals(input3431v, other.input3431v)
				&& Objects.equals(input3431y, other.input3431y) && uniqueKey1 == other.uniqueKey1;
	}

		
}
