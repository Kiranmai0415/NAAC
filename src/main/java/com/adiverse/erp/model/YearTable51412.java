package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="yeartable51412")
public class YearTable51412 implements Serializable
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
    private String input51412y;
	@Column(name = "competitive_examinations_1")
    private String input51412v;
	
	
	
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
	public String getInput51412y() {
		if (input51412y!=null) {
			return input51412y;
		}else {
			return "";
		}
		
	}
	public void setInput51412y(String input51412y) {
		this.input51412y = input51412y;
	}
	public String getInput51412v() {
		return input51412v;
	}
	public void setInput51412v(String input51412v) {
		this.input51412v = input51412v;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public int hashCode() {
		return Objects.hash(criteriaId, input51412v, input51412y, uniqueKey1);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		YearTable51412 other = (YearTable51412) obj;
		return Objects.equals(criteriaId, other.criteriaId) && Objects.equals(input51412v, other.input51412v)
				&& Objects.equals(input51412y, other.input51412y) && uniqueKey1 == other.uniqueKey1;
	}
	
	
}
