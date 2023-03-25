package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="universityyeartable3442")
public class UniversityYearTable3442 implements Serializable
{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private CriteriaPrimaryKey criteriaId;
	
	@Id
	@Column(name="unique_key1")
	private long uniqueKey1;
	
	@Column(name="year")
	private String input3442y;
	
	@Column(name="guides_during")
	private String input3442v;

	
	public String getInput3442y() {
		if (input3442y!=null) {
			return input3442y;
		}
		else {
			return "";
		}
		
	}

	public void setInput3442y(String input3442y) {
		this.input3442y = input3442y;
	}

	public String getInput3442v() {
		if (input3442v!=null) {
			return input3442v;
		}
		else {
			return "";
		}
		
	}

	public void setInput3442v(String input3442v) {
		this.input3442v = input3442v;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(criteriaId, input3442v, input3442y, uniqueKey1);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UniversityYearTable3442 other = (UniversityYearTable3442) obj;
		return Objects.equals(criteriaId, other.criteriaId) && Objects.equals(input3442v, other.input3442v)
				&& Objects.equals(input3442y, other.input3442y) && uniqueKey1 == other.uniqueKey1;
	}


	
}
