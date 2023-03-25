package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="universityyeartable34612")
public class UniversityYearTable34612 implements Serializable
{
	private static final long serialVersionUID = 1L;

	private CriteriaPrimaryKey criteriaId;
	
	@Id
	@Column(name="unique_key1")
	private long uniqueKey1;
	
	@Column(name="year")
	private String input34612y;
	
	@Column(name="volumes_books")
	private String input34612v;

	
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

	public String getInput34612y() {
		if (input34612y!=null) {
			return input34612y;
		}
		else {
			return "";
		}
		
	}

	public void setInput34612y(String input34612y) {
		this.input34612y = input34612y;
	}

	public String getInput34612v() {
		if (input34612v!=null) {
			return input34612v;
		}
		else {
			return "";
		}
		
	}

	public void setInput34612v(String input34612v) {
		this.input34612v = input34612v;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(criteriaId, input34612v, input34612y, uniqueKey1);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UniversityYearTable34612 other = (UniversityYearTable34612) obj;
		return Objects.equals(criteriaId, other.criteriaId) && Objects.equals(input34612v, other.input34612v)
				&& Objects.equals(input34612y, other.input34612y) && uniqueKey1 == other.uniqueKey1;
	}

	
}
