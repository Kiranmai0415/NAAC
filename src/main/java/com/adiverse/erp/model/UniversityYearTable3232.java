package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="universityyeartable3232")
public class UniversityYearTable3232 implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	
	private CriteriaPrimaryKey criteriaId;
	
	@Id
	@Column(name="unique_key1")
	private long uniqueKey1;
	
	@Column(name="year")
	private String input3232y;
	@Column(name = "fulltime_teachers")
    private String input3232v;
	
	

	public String getInput3232y() {
		if (input3232y!=null) {
			return input3232y;
		}
		else {
			return "";
		}
		
	}
	public void setInput3232y(String input3232y) {
		this.input3232y = input3232y;
	}
	public String getInput3232v() {
		if (input3232v!=null) {
			return input3232v;
		}
		else {
			return "";
		}
		
	}
	public void setInput3232v(String input3232v) {
		this.input3232v = input3232v;
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
		return Objects.hash(criteriaId, input3232v, input3232y, uniqueKey1);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UniversityYearTable3232 other = (UniversityYearTable3232) obj;
		return Objects.equals(criteriaId, other.criteriaId) && Objects.equals(input3232v, other.input3232v)
				&& Objects.equals(input3232y, other.input3232y) && uniqueKey1 == other.uniqueKey1;
	}
	
	
}
