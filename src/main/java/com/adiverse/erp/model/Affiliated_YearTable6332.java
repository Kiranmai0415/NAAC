package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="affiliated_YearTable6332")
public class Affiliated_YearTable6332 implements Serializable
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
    private String input6332y;
	
	@Column(name = "nonteachingstaff")
    private String input6332v;

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

	public String getInput6332y() {
		if(input6332y !=null) {
		return input6332y;
	}else {
		return "";
	}
	}

	public void setInput6332y(String input6332y) {
		this.input6332y = input6332y;
	}

	public String getInput6332v() {
		if(input6332v !=null) {
		return input6332v;
	}else {
		return "";
	}
	}

	public void setInput6332v(String input6332v) {
		this.input6332v = input6332v;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(criteriaId, input6332v, input6332y, uniqueKey1);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Affiliated_YearTable6332 other = (Affiliated_YearTable6332) obj;
		return Objects.equals(criteriaId, other.criteriaId) && Objects.equals(input6332v, other.input6332v)
				&& Objects.equals(input6332y, other.input6332y) && uniqueKey1 == other.uniqueKey1;
	}

	

}