package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="yeartable1331")
public class YearTable1331 implements Serializable
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
    private String input1331y;
	@Column(name = "added_courses")
    private String input1331v;
	
	
	
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
	public String getInput1331y() {
		if (input1331y!=null) {
			return input1331y;
		}
		else {
			return "";
		}
		
	}
	public void setInput1331y(String input1331y) {
		this.input1331y = input1331y;
	}
	public String getInput1331v() {
		if (input1331v!=null) {
			return input1331v;
		}
		else {
			return "";
		}
		
	}
	public void setInput1331v(String input1331v) {
		this.input1331v = input1331v;
	}
	@Override
	public int hashCode() {
		return Objects.hash(criteriaId, input1331v, input1331y, uniqueKey1);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		YearTable1331 other = (YearTable1331) obj;
		return Objects.equals(criteriaId, other.criteriaId) && Objects.equals(input1331v, other.input1331v)
				&& Objects.equals(input1331y, other.input1331y) && uniqueKey1 == other.uniqueKey1;
	}
	
	
}
