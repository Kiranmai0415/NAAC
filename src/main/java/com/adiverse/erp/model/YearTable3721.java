package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="yeartable3721")
public class YearTable3721 implements Serializable
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
	private String input3721y;
	
	@Column(name = "mous")
    private String input3721v;

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

	public String getInput3721y() {
		if (input3721y!=null) {
			return input3721y;
		}
		else {
			return "";
		}
		
	}

	public void setInput3721y(String input3721y) {
		this.input3721y = input3721y;
	}

	public String getInput3721v() {
		if (input3721v!=null) {
			return input3721v;
		}
		else {
			return "";
		}
		
	}

	public void setInput3721v(String input3721v) {
		this.input3721v = input3721v;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(criteriaId, input3721v, input3721y, uniqueKey1);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		YearTable3721 other = (YearTable3721) obj;
		return Objects.equals(criteriaId, other.criteriaId) && Objects.equals(input3721v, other.input3721v)
				&& Objects.equals(input3721y, other.input3721y) && uniqueKey1 == other.uniqueKey1;
	}

	

	

	
	
}
