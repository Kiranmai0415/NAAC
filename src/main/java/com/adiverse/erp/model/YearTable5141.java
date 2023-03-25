package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="yeartable5141")
public class YearTable5141 implements Serializable
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
    private String input5141y;
	@Column(name = "competitive_examinations")
    private String input5141v;
	
	
	
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
	public String getInput5141y() {
		if (input5141y!=null) {
			return input5141y;
		}
		else {
			return "";
		}
		
	}
	public void setInput5141y(String input5141y) {
		this.input5141y = input5141y;
	}
	public String getInput5141v() {
		if (input5141v!=null) {
			return input5141v;
		}
		else {
			return "";
		}
		
	}
	public void setInput5141v(String input5141v) {
		this.input5141v = input5141v;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public int hashCode() {
		return Objects.hash(criteriaId, input5141v, input5141y, uniqueKey1);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		YearTable5141 other = (YearTable5141) obj;
		return Objects.equals(criteriaId, other.criteriaId) && Objects.equals(input5141v, other.input5141v)
				&& Objects.equals(input5141y, other.input5141y) && uniqueKey1 == other.uniqueKey1;
	}
	
	
	
	
		
	
}
