package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="yeartable1321")
public class YearTable1321 implements Serializable
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
    private String input1321y;
	@Column(name = "value_added")
    private String input1321v;
	
	
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
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getInput1321y() {
		if (input1321y!=null) {
			return input1321y;
		}
		else {
			return "";
		}
		
	}
	public void setInput1321y(String input1321y) {
		this.input1321y = input1321y;
	}
	public String getInput1321v() {
		if (input1321v!=null) {
			return input1321v;
		}
		else {
			return "";
		}
	}
	public void setInput1321v(String input1321v) {
		this.input1321v = input1321v;
	}
	@Override
	public int hashCode() {
		return Objects.hash(criteriaId, input1321v, input1321y, uniqueKey1);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		YearTable1321 other = (YearTable1321) obj;
		return Objects.equals(criteriaId, other.criteriaId) && Objects.equals(input1321v, other.input1321v)
				&& Objects.equals(input1321y, other.input1321y) && uniqueKey1 == other.uniqueKey1;
	}
	
}
