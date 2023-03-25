package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="universityyeartable3451")
public class UniversityYearTable3451 implements Serializable
{
	private static final long serialVersionUID = 1L;

	private CriteriaPrimaryKey criteriaId;
	
	@Id
	@Column(name="unique_key1")
	private long uniqueKey1;
	
	@Column(name="year")
	private String input3451y;
	
	@Column(name="papers_published")
	private String input3451v;

	

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

	public String getInput3451y() {
		if (input3451y!=null) {
			return input3451y;
		}
		else {
			return "";
		}
		
	}

	public void setInput3451y(String input3451y) {
		this.input3451y = input3451y;
	}

	public String getInput3451v() {
		if (input3451v!=null) {
			return input3451v;
		}
		else {
			return "";
		}
		
	}

	public void setInput3451v(String input3451v) {
		this.input3451v = input3451v;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(criteriaId, input3451v, input3451y, uniqueKey1);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UniversityYearTable3451 other = (UniversityYearTable3451) obj;
		return Objects.equals(criteriaId, other.criteriaId) && Objects.equals(input3451v, other.input3451v)
				&& Objects.equals(input3451y, other.input3451y) && uniqueKey1 == other.uniqueKey1;
	}

	
	
}
