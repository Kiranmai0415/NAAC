package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="affiliated_YearTable5131")
public class Affiliated_YearTable5131 implements Serializable
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
    private String input5131y;
	
	@Column(name = "competitive")
    private String input5131v;

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

	public String getInput5131y() {
		if(input5131y !=null) {
		return input5131y;
	}else {
		return "";
	}
	}

	public void setInput5131y(String input5131y) {
		this.input5131y = input5131y;
	}

	public String getInput5131v() {
		if(input5131v !=null) {
		return input5131v;
	}else {
		return "";
	}
	}

	public void setInput5131v(String input5131v) {
		this.input5131v = input5131v;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(criteriaId, input5131v, input5131y, uniqueKey1);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Affiliated_YearTable5131 other = (Affiliated_YearTable5131) obj;
		return Objects.equals(criteriaId, other.criteriaId) && Objects.equals(input5131v, other.input5131v)
				&& Objects.equals(input5131y, other.input5131y) && uniqueKey1 == other.uniqueKey1;
	}

	

}