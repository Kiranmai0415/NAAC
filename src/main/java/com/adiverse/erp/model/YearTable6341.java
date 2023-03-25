package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="yeartable6341")
public class YearTable6341 implements Serializable
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
    private String input6341y;
	@Column(name = "development_programmes")
    private String input6341v;
	
	
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
	public String getInput6341y() {
		if(input6341y!=null) {
		return input6341y;}
		else {
			return "";
		}
	}
	public void setInput6341y(String input6341y) {
		this.input6341y = input6341y;
	}
	public String getInput6341v() {
		if(input6341v !=null)
		{
		return input6341v;
		}
		else 
		{
			return "";
		}
	}
	public void setInput6341v(String input6341v) {
		this.input6341v = input6341v;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public int hashCode() {
		return Objects.hash(criteriaId, input6341v, input6341y, uniqueKey1);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		YearTable6341 other = (YearTable6341) obj;
		return Objects.equals(criteriaId, other.criteriaId) && Objects.equals(input6341v, other.input6341v)
				&& Objects.equals(input6341y, other.input6341y) && uniqueKey1 == other.uniqueKey1;
	}
	
	
}
