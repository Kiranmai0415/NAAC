package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="universityyeartable5221")
public class UniversityYearTable5221 implements Serializable
{
	private static final long serialVersionUID = 1L;

	private CriteriaPrimaryKey criteriaId;
	
    @Id
    @Column(name="unique_key1")
	private long uniqueKey1;
	
	@Column(name="year")
	private String input5221y;
	
	@Column(name="students_placed")
	private String input5221v;

	
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

	public String getInput5221y() {
		if (input5221y!=null) {
			return input5221y;
		}
		else {
			return "";
		}
	}

	public void setInput5221y(String input5221y) {
		this.input5221y = input5221y;
	}

	public String getInput5221v() {
		if (input5221v!=null) {
			return input5221v;
		}
		else {
			return "";
		}
		
	}

	public void setInput5221v(String input5221v) {
		this.input5221v = input5221v;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(criteriaId, input5221v, input5221y, uniqueKey1);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UniversityYearTable5221 other = (UniversityYearTable5221) obj;
		return Objects.equals(criteriaId, other.criteriaId) && Objects.equals(input5221v, other.input5221v)
				&& Objects.equals(input5221y, other.input5221y) && uniqueKey1 == other.uniqueKey1;
	}

	
	

	
	
	
}
