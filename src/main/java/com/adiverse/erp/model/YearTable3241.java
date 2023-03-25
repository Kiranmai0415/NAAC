package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="yeartable3241")
public class YearTable3241 implements Serializable
{
	private static final long serialVersionUID = 1L;

	private CriteriaPrimaryKey criteriaId;
	
	@Id
	@Column(name="unique_key1")
	private long uniqueKey1;
	
	@Column(name="year")
	private String input3241y;
	
	@Column(name = "research_gov_projects")
    private String input3241v;


	public String getInput3241y() {
		if (input3241y!=null) {
			return input3241y;
		}
		else {
			return "";
		}
		
	}

	public void setInput3241y(String input3241y) {
		this.input3241y = input3241y;
	}

	public String getInput3241v() {
		if (input3241v!=null) {
			return input3241v;
		}
		else {
			return "";
		}
		
	}

	public void setInput3241v(String input3241v) {
		this.input3241v = input3241v;
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
		return Objects.hash(criteriaId, input3241v, input3241y, uniqueKey1);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		YearTable3241 other = (YearTable3241) obj;
		return Objects.equals(criteriaId, other.criteriaId) && Objects.equals(input3241v, other.input3241v)
				&& Objects.equals(input3241y, other.input3241y) && uniqueKey1 == other.uniqueKey1;
	}
	

}
