package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="yeartable3121")
public class YearTable3121 implements Serializable
{
	private static final long serialVersionUID = 1L;

	private CriteriaPrimaryKey criteriaId;
		
	@Id
	@Column(name="unique_key1")
	private long uniqueKey1;
		
	
	@Column(name = "year")
    private String input3121y;
	@Column(name = "seed_money")
    private String input3121v;

	
	
	
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

	public String getInput3121y() {
		if (input3121y!=null) {
			return input3121y;
		}
		else {
			return "";
		}
		
	}

	public void setInput3121y(String input3121y) {
		this.input3121y = input3121y;
	}

	public String getInput3121v() {
		if (input3121v!=null) {
			return input3121v;
		}
		else {
			return "";
		}
		
	}

	public void setInput3121v(String input3121v) {
		this.input3121v = input3121v;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(criteriaId, input3121v, input3121y, uniqueKey1);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		YearTable3121 other = (YearTable3121) obj;
		return Objects.equals(criteriaId, other.criteriaId) && Objects.equals(input3121v, other.input3121v)
				&& Objects.equals(input3121y, other.input3121y) && uniqueKey1 == other.uniqueKey1;
	}

	
	
}
