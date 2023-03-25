package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="yearTable36412")
public class YearTable36412 implements Serializable
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
	private String input36412y;
	
	@Column(name = "extension_activities")
    private String input36412v;

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

	public String getInput36412y() {
		if (input36412y!=null) {
			return input36412y;
		}
		else {
			return "";
		}
		
	}

	public void setInput36412y(String input36412y) {
		this.input36412y = input36412y;
	}

	public String getInput36412v() {
		if (input36412v!=null) {
			return input36412v;
		}
		else {
			return "";
		}
		
	}

	public void setInput36412v(String input36412v) {
		this.input36412v = input36412v;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(criteriaId, input36412v, input36412y, uniqueKey1);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		YearTable36412 other = (YearTable36412) obj;
		return Objects.equals(criteriaId, other.criteriaId) && Objects.equals(input36412v, other.input36412v)
				&& Objects.equals(input36412y, other.input36412y) && uniqueKey1 == other.uniqueKey1;
	}

	
	
	
}
