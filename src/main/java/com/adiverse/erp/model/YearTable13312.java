package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="yeartable13312")
public class YearTable13312 implements Serializable
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
    private String input13312y;
	@Column(name = "added_courses_1")
    private String input13312v;
	

	public String getInput13312y() {
		if (input13312y!=null) {
			return input13312y;
		}
		else {
			return "";
		}
		
	}
	public void setInput13312y(String input13312y) {
		this.input13312y = input13312y;
	}
	public String getInput13312v() {
		if (input13312v!=null) {
			return input13312v;
		}
		else {
			return "";
		}
	}
	public void setInput13312v(String input13312v) {
		this.input13312v = input13312v;
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
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public int hashCode() {
		return Objects.hash(criteriaId, input13312v, input13312y, uniqueKey1);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		YearTable13312 other = (YearTable13312) obj;
		return Objects.equals(criteriaId, other.criteriaId) && Objects.equals(input13312v, other.input13312v)
				&& Objects.equals(input13312y, other.input13312y) && uniqueKey1 == other.uniqueKey1;
	}
	
}
