package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="yeartable3621")
public class YearTable3621 implements Serializable
{
	private static final long serialVersionUID = 1L;

	private CriteriaPrimaryKey criteriaId;
	
	@Id
	@Column(name="unique_key1")
	private long uniqueKey1;
	
	@Column(name="year")
	private String input3621y;
	
	@Column(name = "awards_recognition")
    private String input3621v;


	public String getInput3621y() {
		if (input3621y!=null) {
			return input3621y;
		}
		else {
			return "";
		}
		
	}

	public void setInput3621y(String input3621y) {
		this.input3621y = input3621y;
	}

	public String getInput3621v() {
		if (input3621v!=null) {
			return input3621v;
		}
		else {
			return "";
		}
		
	}

	public void setInput3621v(String input3621v) {
		this.input3621v = input3621v;
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
		return Objects.hash(criteriaId, input3621v, input3621y, uniqueKey1);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		YearTable3621 other = (YearTable3621) obj;
		return Objects.equals(criteriaId, other.criteriaId) && Objects.equals(input3621v, other.input3621v)
				&& Objects.equals(input3621y, other.input3621y) && uniqueKey1 == other.uniqueKey1;
	}

	
}
