package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="yeartable6421")
public class YearTable6421 implements Serializable
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
    private String input6421y;
	@Column(name = "philanthropists_year")
    private String input6421v;
	

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
	public String getInput6421y() {
		if(input6421y !=null)
		{
		return input6421y;
		}
		else
		{
			return "";
		}
	}
	public void setInput6421y(String input6421y) {
		this.input6421y = input6421y;
	}
	public String getInput6421v() {
		if(input6421v !=null) {
		return input6421v;}
		else {
			return "";
		}
	}
	public void setInput6421v(String input6421v) {
		this.input6421v = input6421v;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public int hashCode() {
		return Objects.hash(criteriaId, input6421v, input6421y, uniqueKey1);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		YearTable6421 other = (YearTable6421) obj;
		return Objects.equals(criteriaId, other.criteriaId) && Objects.equals(input6421v, other.input6421v)
				&& Objects.equals(input6421y, other.input6421y) && uniqueKey1 == other.uniqueKey1;
	}
	
}
