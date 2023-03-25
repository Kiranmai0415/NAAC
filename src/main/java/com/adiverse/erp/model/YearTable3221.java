package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="yeartable3221")
public class YearTable3221 implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	private CriteriaPrimaryKey criteriaId;
	
	@Id
	@Column(name="unique_key1")
	private long uniqueKey1;
	
	@Column(name="year")
	private String input3221y;
	@Column(name = "research_projects")
    private String input3221v;
	
	
	
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
	public String getInput3221y() {
		if (input3221y!=null) {
			return input3221y;
		}
		else {
			return "";
		}
		
	}
	public void setInput3221y(String input3221y) {
		this.input3221y = input3221y;
	}
	public String getInput3221v() {
		if (input3221v!=null) {
			return input3221v;
		}
		else {
			return "";
		}
		
	}
	public void setInput3221v(String input3221v) {
		this.input3221v = input3221v;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public int hashCode() {
		return Objects.hash(criteriaId, input3221v, input3221y, uniqueKey1);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		YearTable3221 other = (YearTable3221) obj;
		return Objects.equals(criteriaId, other.criteriaId) && Objects.equals(input3221v, other.input3221v)
				&& Objects.equals(input3221y, other.input3221y) && uniqueKey1 == other.uniqueKey1;
	}

}
