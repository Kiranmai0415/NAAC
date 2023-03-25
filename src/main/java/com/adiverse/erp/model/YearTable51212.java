package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="yeartable51212")
public class YearTable51212 implements Serializable
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
    private String input51212y;
	@Column(name = "non_government_agencies_1")
    private String input51212v;
	
	
	
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
	public String getInput51212y() {
		if (input51212y!=null) {
			return input51212y;	
		}
		else {
			return "";
		}
		
	}
	public void setInput51212y(String input51212y) {
		this.input51212y = input51212y;
	}
	public String getInput51212v() {
		if (input51212v!=null) {
			return input51212v;
		}
		else {
			return "";
		}
		
	}
	public void setInput51212v(String input51212v) {
		this.input51212v = input51212v;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public int hashCode() {
		return Objects.hash(criteriaId, input51212v, input51212y, uniqueKey1);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		YearTable51212 other = (YearTable51212) obj;
		return Objects.equals(criteriaId, other.criteriaId) && Objects.equals(input51212v, other.input51212v)
				&& Objects.equals(input51212y, other.input51212y) && uniqueKey1 == other.uniqueKey1;
	}
	
}
