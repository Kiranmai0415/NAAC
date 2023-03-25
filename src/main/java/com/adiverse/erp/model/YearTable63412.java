package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="yeartable63412")
public class YearTable63412 implements Serializable
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
    private String input63412y;
	@Column(name = "development_programmes")
    private String input63412v;
	
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
	public String getInput63412y() {
		if(input63412y !=null) {
		return input63412y;}
		else
		{
			return "";
		}
	}
	public void setInput63412y(String input63412y) {
		this.input63412y = input63412y;
	}
	public String getInput63412v() {
		if(input63412v !=null)
		{
		return input63412v;
		}
		else 
		{
			return "";
		}
	}
	public void setInput63412v(String input63412v) {
		this.input63412v = input63412v;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public int hashCode() {
		return Objects.hash(criteriaId, input63412v, input63412y, uniqueKey1);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		YearTable63412 other = (YearTable63412) obj;
		return Objects.equals(criteriaId, other.criteriaId) && Objects.equals(input63412v, other.input63412v)
				&& Objects.equals(input63412y, other.input63412y) && uniqueKey1 == other.uniqueKey1;
	}
	
	
	
	
}
