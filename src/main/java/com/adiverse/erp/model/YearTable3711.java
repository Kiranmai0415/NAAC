package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="yeartable3711")
public class YearTable3711 implements Serializable
{


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private CriteriaPrimaryKey criteriaId;
	
	@Id
	@Column(name="unique_key1")
	private long uniqueKey1;
	
	@Column(name="year")
	private String input3711y;
	
	@Column(name = "collaborative_activities")
    private String input3711v;

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

	public String getInput3711y() {
		if (input3711y!=null) {
			return input3711y;
		}
		else {
			return "";
		}
		
	}

	public void setInput3711y(String input3711y) {
		this.input3711y = input3711y;
	}

	public String getInput3711v() {
		if (input3711v!=null) {
			return input3711v;
		}
		else {
			return "";
		}
		
	}

	public void setInput3711v(String input3711v) {
		this.input3711v = input3711v;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(criteriaId, input3711v, input3711y, uniqueKey1);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		YearTable3711 other = (YearTable3711) obj;
		return Objects.equals(criteriaId, other.criteriaId) && Objects.equals(input3711v, other.input3711v)
				&& Objects.equals(input3711y, other.input3711y) && uniqueKey1 == other.uniqueKey1;
	}


	
	
}
