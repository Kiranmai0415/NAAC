package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="affiliated_yeartable251")
public class Affiliated_YearTable251 implements Serializable
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
    private String input251y;
	@Column(name = "assessment")
    private String input251v;
	
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
	public String getInput251y() {
		if(input251y !=null) {
		return input251y;
	}else {
		return "";
	}
	}
	public void setInput251y(String input251y) {
		this.input251y = input251y;
	}
	public String getInput251v() {
		if(input251v !=null) {
		return input251v;
	}else {
		return "";
	}
	}
	public void setInput251v(String input251v) {
		this.input251v = input251v;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public int hashCode() {
		return Objects.hash(criteriaId, input251v, input251y, uniqueKey1);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Affiliated_YearTable251 other = (Affiliated_YearTable251) obj;
		return Objects.equals(criteriaId, other.criteriaId) && Objects.equals(input251v, other.input251v)
				&& Objects.equals(input251y, other.input251y) && uniqueKey1 == other.uniqueKey1;
	}
	
	
	}
	
	
	

