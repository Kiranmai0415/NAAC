package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="yeartable3211")
public class YearTable3211 implements Serializable
{
	private static final long serialVersionUID = 1L;

	private CriteriaPrimaryKey criteriaId;
	
	@Id
	@Column(name="unique_key1")
	private long uniqueKey1;
	
	@Column(name="year")
	private String input3211y;
	
	@Column(name = "grant12")
    private String input3211v;
	

	public String getInput3211y() {
		if (input3211y!=null) {
			return input3211y;
		}
		else {
			return "";
		}
		
	}

	public void setInput3211y(String input3211y) {
		this.input3211y = input3211y;
	}

	public String getInput3211v() {
		if (input3211v!=null) {
			return input3211v;
		}
		else {
			return "";
		}
		
	}

	public void setInput3211v(String input3211v) {
		this.input3211v = input3211v;
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
		return Objects.hash(criteriaId, input3211v, input3211y, uniqueKey1);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		YearTable3211 other = (YearTable3211) obj;
		return Objects.equals(criteriaId, other.criteriaId) && Objects.equals(input3211v, other.input3211v)
				&& Objects.equals(input3211y, other.input3211y) && uniqueKey1 == other.uniqueKey1;
	}

	
}
