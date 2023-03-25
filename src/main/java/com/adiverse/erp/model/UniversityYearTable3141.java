package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="universityyeartable3141")
public class UniversityYearTable3141 implements Serializable
{
	private static final long serialVersionUID = 1L;

	private CriteriaPrimaryKey criteriaId;
	
	@Id
	@Column(name="unique_key1")
	private long uniqueKey1;
	
	@Column(name="year")
	private String input3141y;
	
	@Column(name="JRF_SRF")
	private String input3141v;
	


	public String getInput3141y() {
		if (input3141y!=null) {
			return input3141y;
		}
		else {
			return "";
		}
		
	}

	public void setInput3141y(String input3141y) {
		this.input3141y = input3141y;
	}

	public String getInput3141v() {
		if (input3141v!=null) {
			return input3141v;
		}
		else {
			return "";
		}
		
	}

	public void setInput3141v(String input3141v) {
		this.input3141v = input3141v;
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
		return Objects.hash(criteriaId, input3141v, input3141y, uniqueKey1);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UniversityYearTable3141 other = (UniversityYearTable3141) obj;
		return Objects.equals(criteriaId, other.criteriaId) && Objects.equals(input3141v, other.input3141v)
				&& Objects.equals(input3141y, other.input3141y) && uniqueKey1 == other.uniqueKey1;
	}

	
	
}
