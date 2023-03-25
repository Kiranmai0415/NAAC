package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="affiliated_yeartable351")
public class Affiliated_YearTable351 implements Serializable
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
    private String input351y;
	
	@Column(name = "collaborations")
    private String input351v;
	
	
	public String getInput351y() {
		if(input351y !=null) {
		return input351y;
	}else {
		return "";
	}
	}
	
	public void setInput351y(String input351y) {
		this.input351y = input351y;
	}
	public String getInput351v() {
		if(input351v !=null) {
		return  input351v;
	}else {
		return "";
	}
	}
	
	public void setInput351v(String input351v) {
		this.input351v = input351v;
	}
	public static long getSerialversionuid() {
		return  serialVersionUID;
	}
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
	@Override
	public int hashCode() {
		return Objects.hash(criteriaId, input351v, input351y, uniqueKey1);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Affiliated_YearTable351 other = (Affiliated_YearTable351) obj;
		return Objects.equals(criteriaId, other.criteriaId) && Objects.equals(input351v, other.input351v)
				&& Objects.equals(input351y, other.input351y) && uniqueKey1 == other.uniqueKey1;
	}
	
}	

	
	
	
	

