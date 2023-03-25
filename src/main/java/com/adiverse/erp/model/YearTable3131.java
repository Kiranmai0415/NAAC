package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="yeartable3131")
public class YearTable3131 implements Serializable
{
	private static final long serialVersionUID = 1L;

	
    private CriteriaPrimaryKey criteriaId;
	
	@Id
	@Column(name="unique_key1")
	private long uniqueKey1;
	
	
	@Column(name="year")
	private String input3131y;
	
	@Column(name="teacher_awarded")
	private String input3131v;
	

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

	public String getInput3131y() {
		if (input3131y!=null) {
			return input3131y;
		}
		else {
			return "";
		}
		
	}

	public void setInput3131y(String input3131y) {
		this.input3131y = input3131y;
	}

	public String getInput3131v() {
		if (input3131v!=null) {
			return input3131v;
		}
		else {
			return "";
		}
		
	}

	public void setInput3131v(String input3131v) {
		this.input3131v = input3131v;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(input3131v, input3131y, uniqueKey1);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		YearTable3131 other = (YearTable3131) obj;
		return Objects.equals(input3131v, other.input3131v) && Objects.equals(input3131y, other.input3131y)
				&& Objects.equals(uniqueKey1, other.uniqueKey1);
	}	
	
	
}