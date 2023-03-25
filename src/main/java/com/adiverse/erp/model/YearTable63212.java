package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="yeartable63212")
public class YearTable63212 implements Serializable
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
    private String input63212y;
	@Column(name = "conferences_workshops")
    private String input63212v;
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
	public String getInput63212y() {
		if(input63212y !=null)
		{
		return input63212y;
		}
		else {
			return "";
		}
	}
	public void setInput63212y(String input63212y) {
		this.input63212y = input63212y;
	}
	public String getInput63212v() {
		if(input63212v !=null)
		{
		return input63212v;
		}
		else 
		{
			return "";
		}
	}
	public void setInput63212v(String input63212v) {
		this.input63212v = input63212v;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public int hashCode() {
		return Objects.hash(criteriaId, input63212v, input63212y, uniqueKey1);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		YearTable63212 other = (YearTable63212) obj;
		return Objects.equals(criteriaId, other.criteriaId) && Objects.equals(input63212v, other.input63212v)
				&& Objects.equals(input63212y, other.input63212y) && uniqueKey1 == other.uniqueKey1;
	}
	
	
	
}
