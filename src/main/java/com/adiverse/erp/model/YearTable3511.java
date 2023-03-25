package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.crypto.dsig.keyinfo.RetrievalMethod;

@Entity
@Table(name="yeartable3511")
public class YearTable3511 implements Serializable
{
	private static final long serialVersionUID = 1L;

	private CriteriaPrimaryKey criteriaId;
	
	@Id
	@Column(name="unique_key1")
	private long uniqueKey1;
	
	@Column(name="year")
	private String input3511y;
	
	@Column(name = "amount_generated")
    private String input3511v;

	
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

	public String getInput3511y() {
		if (input3511y!=null) {
			return input3511y;
		}
		else {
			return "";
		}
		
	}

	public void setInput3511y(String input3511y) {
		this.input3511y = input3511y;
	}

	public String getInput3511v() {
		if (input3511v!=null) {
			return input3511v;
		}
		else {
			return "";
		}
		
	}

	public void setInput3511v(String input3511v) {
		this.input3511v = input3511v;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(criteriaId, input3511v, input3511y, uniqueKey1);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		YearTable3511 other = (YearTable3511) obj;
		return Objects.equals(criteriaId, other.criteriaId) && Objects.equals(input3511v, other.input3511v)
				&& Objects.equals(input3511y, other.input3511y) && uniqueKey1 == other.uniqueKey1;
	}

	
}
