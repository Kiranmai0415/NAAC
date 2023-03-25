package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="yeartable3242")
public class YearTable3242 implements Serializable
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
	private String input3242y;
	
	@Column(name = "research_gov_projects")
    private String input3242v;



	public String getInput3242y() {
		if (input3242y!=null) {
			return input3242y;
		}
		else {
			return "";
		}
	}

	public void setInput3242y(String input3242y) {
		this.input3242y = input3242y;
	}

	public String getInput3242v() {
		if (input3242v!=null) {
			return input3242v;
		}
		else {
			return "";
		}
		
	}

	public void setInput3242v(String input3242v) {
		this.input3242v = input3242v;
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
		return Objects.hash(criteriaId, input3242v, input3242y, uniqueKey1);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		YearTable3242 other = (YearTable3242) obj;
		return Objects.equals(criteriaId, other.criteriaId) && Objects.equals(input3242v, other.input3242v)
				&& Objects.equals(input3242y, other.input3242y) && uniqueKey1 == other.uniqueKey1;
	}

	
}
