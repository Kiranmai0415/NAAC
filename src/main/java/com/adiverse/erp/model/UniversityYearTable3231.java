package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="universityyeartable3231")
public class UniversityYearTable3231 implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	private CriteriaPrimaryKey criteriaId;
	
	@Id
	@Column(name="unique_key1")
	private long uniqueKey1;
	
	@Column(name="year")
	private String input3231y;
	@Column(name = "research_projects")
    private String input3231v;
	
	public String getInput3231y() {
		if (input3231y!=null) {
			return input3231y;
		}
		else {
			return "";
		}
		
	}
	public void setInput3231y(String input3231y) {
		this.input3231y = input3231y;
	}
	public String getInput3231v() {
		if (input3231v!=null) {
			return input3231v;
		}
		else {
			return "";
		}
		
	}
	public void setInput3231v(String input3231v) {
		this.input3231v = input3231v;
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
		return Objects.hash(criteriaId, input3231v, input3231y, uniqueKey1);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UniversityYearTable3231 other = (UniversityYearTable3231) obj;
		return Objects.equals(criteriaId, other.criteriaId) && Objects.equals(input3231v, other.input3231v)
				&& Objects.equals(input3231y, other.input3231y) && uniqueKey1 == other.uniqueKey1;
	}
	
	
	
}