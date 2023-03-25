package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="affiliated_yeartable221")
public class Affiliated_YearTable221 implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
     //changes
	
	private CriteriaPrimaryKey criteriaId;
	
    @Id
    @Column(name="unique_key1")
	private long uniqueKey1;
	
	
	@Column(name = "year")
    private String input221y;
	@Column(name = "teachers")
    private String input221v;
	
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
	public String getInput221y() {
		if(input221y !=null) {
		return input221y;
	}else {
		return "";
	}
	}
	public void setInput221y(String input221y) {
		this.input221y = input221y;
	}
	public String getInput221v() {
		if(input221v !=null) {
		return input221v;
	}else {
		return "";
	}
	}
	public void setInput221v(String input221v) {
		this.input221v = input221v;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public int hashCode() {
		return Objects.hash(criteriaId, input221v, input221y, uniqueKey1);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Affiliated_YearTable221 other = (Affiliated_YearTable221) obj;
		return Objects.equals(criteriaId, other.criteriaId) && Objects.equals(input221v, other.input221v)
				&& Objects.equals(input221y, other.input221y) && uniqueKey1 == other.uniqueKey1;
	}
	
	
	}
