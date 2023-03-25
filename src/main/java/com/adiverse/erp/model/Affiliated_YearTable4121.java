package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="affiliated_YearTable4121")
public class Affiliated_YearTable4121 implements Serializable
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
    private String input4121y;
	
	@Column(name = "agumentation")
    private String input4121v;

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

	public String getInput4121y() {
		if(input4121y !=null) {
		return input4121y;
	}else {
		return "";
	}
	}

	public void setInput4121y(String input4121y) {
		this.input4121y = input4121y;
	}

	public String getInput4121v() {
		if(input4121v !=null) {
		return input4121v;
	}else {
		return "";
	}
	}

	public void setInput4121v(String input4121v) {
		this.input4121v = input4121v;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(criteriaId, input4121v, input4121y, uniqueKey1);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Affiliated_YearTable4121 other = (Affiliated_YearTable4121) obj;
		return Objects.equals(criteriaId, other.criteriaId) && Objects.equals(input4121v, other.input4121v)
				&& Objects.equals(input4121y, other.input4121y) && uniqueKey1 == other.uniqueKey1;
	}

	
}
