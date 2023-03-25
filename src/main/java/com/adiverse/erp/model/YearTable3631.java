package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="yeartable3631")
public class YearTable3631 implements Serializable
{
	private static final long serialVersionUID = 1L;

	private CriteriaPrimaryKey criteriaId;
	
	@Id
	@Column(name="unique_key1")
	private long uniqueKey1;
	
	@Column(name="year")
	private String input3631y;
	
	@Column(name = "extension_outreach")
    private String input3631v;

	
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

	public String getInput3631y() {
		if (input3631y!=null) {
			return input3631y;
		}
		else {
			return "";
		}
		
	}

	public void setInput3631y(String input3631y) {
		this.input3631y = input3631y;
	}

	public String getInput3631v() {
		if (input3631v!=null) {
			return input3631v;
		}
		else {
			return "";
		}
		
	}

	public void setInput3631v(String input3631v) {
		this.input3631v = input3631v;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(criteriaId, input3631v, input3631y, uniqueKey1);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		YearTable3631 other = (YearTable3631) obj;
		return Objects.equals(criteriaId, other.criteriaId) && Objects.equals(input3631v, other.input3631v)
				&& Objects.equals(input3631y, other.input3631y) && uniqueKey1 == other.uniqueKey1;
	}

	
}
