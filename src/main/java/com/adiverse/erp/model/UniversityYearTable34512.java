package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="universityyeartable34512")
public class UniversityYearTable34512 implements Serializable
{
	private static final long serialVersionUID = 1L;

	private CriteriaPrimaryKey criteriaId;
	
	@Id
	@Column(name="unique_key1")
	private long uniqueKey1;
	
	
	@Column(name="year")
	private String input34512y;
	
	@Column(name="ugc_website")
	private String input34512v;

	
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

	public String getInput34512y() {
		if (input34512y!=null) {
			return input34512y;
		}
		else {
			return "";
		}
		
	}

	public void setInput34512y(String input34512y) {
		this.input34512y = input34512y;
	}

	public String getInput34512v() {
		if (input34512v!=null) {
			return input34512v;
		}
		else {
			return "";
		}
		
	}

	public void setInput34512v(String input34512v) {
		this.input34512v = input34512v;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(criteriaId, input34512v, input34512y, uniqueKey1);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UniversityYearTable34512 other = (UniversityYearTable34512) obj;
		return Objects.equals(criteriaId, other.criteriaId) && Objects.equals(input34512v, other.input34512v)
				&& Objects.equals(input34512y, other.input34512y) && uniqueKey1 == other.uniqueKey1;
	}

	
}
