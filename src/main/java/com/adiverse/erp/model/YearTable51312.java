package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="yearTable51312")
public class YearTable51312 implements Serializable
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
    private String input51312y;
	
	@Column(name = "examinations ")
    private String input51312v;

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

	public String getInput51312y() {
		if (input51312y!=null) {
			return input51312y;
		}
		else {
			return "";
		}
		
	}

	public void setInput51312y(String input51312y) {
		this.input51312y = input51312y;
	}

	public String getInput51312v() {
		if (input51312v!=null) {
			return input51312v;
		}
		else {
			return "";
		}
	
	}

	public void setInput51312v(String input51312v) {
		this.input51312v = input51312v;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(criteriaId, input51312v, input51312y, uniqueKey1);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		YearTable51312 other = (YearTable51312) obj;
		return Objects.equals(criteriaId, other.criteriaId) && Objects.equals(input51312v, other.input51312v)
				&& Objects.equals(input51312y, other.input51312y) && uniqueKey1 == other.uniqueKey1;
	}
	
	
	
	
	
}
