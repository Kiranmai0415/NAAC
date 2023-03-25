package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="universityyeartable3461")
public class UniversityYearTable3461 implements Serializable
{
	private static final long serialVersionUID = 1L;

	private CriteriaPrimaryKey criteriaId;
	
	@Id
	@Column(name="unique_key1")
	private long uniqueKey1;
	
	@Column(name="year")
	private String input3461y;
	
	@Column(name="books_chapters")
	private String input3461v;



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

	public String getInput3461y() {
		if (input3461y!=null) {
			return input3461y;
		}
		else {
			return "";
		}
		
	}

	public void setInput3461y(String input3461y) {
		this.input3461y = input3461y;
	}

	public String getInput3461v() {
		if (input3461v!=null) {
			return input3461v;
		}
		else {
			return "";
		}
	
	}

	public void setInput3461v(String input3461v) {
		this.input3461v = input3461v;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(criteriaId, input3461v, input3461y, uniqueKey1);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UniversityYearTable3461 other = (UniversityYearTable3461) obj;
		return Objects.equals(criteriaId, other.criteriaId) && Objects.equals(input3461v, other.input3461v)
				&& Objects.equals(input3461y, other.input3461y) && uniqueKey1 == other.uniqueKey1;
	}

	
}
