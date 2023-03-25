package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="yeartable3441")
public class YearTable3441 implements Serializable
{
	private static final long serialVersionUID = 1L;

	private CriteriaPrimaryKey criteriaId;
	
	@Id
	@Column(name="unique_key1")
	private long uniqueKey1;
	
	@Column(name="year")
	private String input3441y;
	
	@Column(name = "books")
    private String input3441v;

	public String getInput3441y() {
		if (input3441y!=null) {
			return input3441y;
		}
		else {
			return "";
		}
		
	}

	public void setInput3441y(String input3441y) {
		this.input3441y = input3441y;
	}

	public String getInput3441v() {
		if (input3441v!=null) {
			return input3441v;
		}
		else {
			return "";
		}
	
	}

	public void setInput3441v(String input3441v) {
		this.input3441v = input3441v;
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
		return Objects.hash(criteriaId, input3441v, input3441y, uniqueKey1);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		YearTable3441 other = (YearTable3441) obj;
		return Objects.equals(criteriaId, other.criteriaId) && Objects.equals(input3441v, other.input3441v)
				&& Objects.equals(input3441y, other.input3441y) && uniqueKey1 == other.uniqueKey1;
	}

	
	
}
