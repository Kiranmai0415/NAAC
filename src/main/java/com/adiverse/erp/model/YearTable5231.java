package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="yeartable5231")
public class YearTable5231 implements Serializable
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
    private String input5231y;
	
	@Column(name = "students_qualifying")
    private String input5231v;
	
	
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
	public String getInput5231y() {
		if (input5231y!=null) {
			return input5231y;
		}
		else {
			return "";
		}
		
	}
	public void setInput5231y(String input5231y) {
		this.input5231y = input5231y;
	}
	public String getInput5231v() {
		if (input5231v!=null) {
			return input5231v;
		}
		else {
			return "";
		}
		
	}
	public void setInput5231v(String input5231v) {
		this.input5231v = input5231v;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public int hashCode() {
		return Objects.hash(criteriaId, input5231v, input5231y, uniqueKey1);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		YearTable5231 other = (YearTable5231) obj;
		return Objects.equals(criteriaId, other.criteriaId) && Objects.equals(input5231v, other.input5231v)
				&& Objects.equals(input5231y, other.input5231y) && uniqueKey1 == other.uniqueKey1;
	}
	
}
