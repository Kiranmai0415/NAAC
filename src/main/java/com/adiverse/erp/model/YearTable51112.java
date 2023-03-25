package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="yeartable51112")
public class YearTable51112 implements Serializable
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
    private String input51112y;
	@Column(name = "government_year_1")
    private String input51112v;
	

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
	public String getInput51112y() {
		if (input51112y!=null) {
			return input51112y;
		}
		else {
			return "";
		}
		
	}
	public void setInput51112y(String input51112y) {
		this.input51112y = input51112y;
	}
	public String getInput51112v() {
		if (input51112v!=null) {
			return input51112v;
		}
		else {
			return "";
		}
		
	}
	public void setInput51112v(String input51112v) {
		this.input51112v = input51112v;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public int hashCode() {
		return Objects.hash(criteriaId, input51112v, input51112y, uniqueKey1);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		YearTable51112 other = (YearTable51112) obj;
		return Objects.equals(criteriaId, other.criteriaId) && Objects.equals(input51112v, other.input51112v)
				&& Objects.equals(input51112y, other.input51112y) && uniqueKey1 == other.uniqueKey1;
	}
	
}
