package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="yeartable5111")
public class YearTable5111 implements Serializable
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
    private String input5111y;
	@Column(name = "government_year")
    private String input5111v;
	
	

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
	public String getInput5111y() {
		if (input5111y!=null) {
			return input5111y;
		}
		else {
			return "";
		}
		
	}
	public void setInput5111y(String input5111y) {
		this.input5111y = input5111y;
	}
	public String getInput5111v() {
		if (input5111v!=null) {
			return input5111v;
		}
		else {
			return "";
		}
		
	}
	public void setInput5111v(String input5111v) {
		this.input5111v = input5111v;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public int hashCode() {
		return Objects.hash(criteriaId, input5111v, input5111y, uniqueKey1);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		YearTable5111 other = (YearTable5111) obj;
		return Objects.equals(criteriaId, other.criteriaId) && Objects.equals(input5111v, other.input5111v)
				&& Objects.equals(input5111y, other.input5111y) && uniqueKey1 == other.uniqueKey1;
	}
	
}
