package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="Affiliated_YearTable5222")
public class Affiliated_YearTable5222 implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private CriteriaPrimaryKey criteriaId;
	
	@Id
	@Column(name="unique_key1")
	private long uniqueKey1;
	
	@Column(name = "year")
    private String input5222y;
	
	@Column(name = "studentsappearing")
    private String input5222v;

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

	public String getInput5222y() {
		if(input5222y !=null) {
		return input5222y;
	}else {
		return "";
	}
	}

	public void setInput5222y(String input5222y) {
		this.input5222y = input5222y;
	}

	public String getInput5222v() {
		if(input5222v !=null) {
		return input5222v;
	}else {
		return "";
	}
	}

	public void setInput5222v(String input5222v) {
		this.input5222v = input5222v;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(criteriaId, input5222v, input5222y, uniqueKey1);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Affiliated_YearTable5222 other = (Affiliated_YearTable5222) obj;
		return Objects.equals(criteriaId, other.criteriaId) && Objects.equals(input5222v, other.input5222v)
				&& Objects.equals(input5222y, other.input5222y) && uniqueKey1 == other.uniqueKey1;
	}

	

}