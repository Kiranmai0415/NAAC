package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="yeartable11312")
public class YearTable11312 implements Serializable
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
    private String input11312y;
	@Column(name = "skill_development_1")
    private String input11312v;
	
	
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
	public String getInput11312y() {
		if (input11312y!=null) {
			return input11312y;
		}
		else {
			return "";
		}
		
	}
	public void setInput11312y(String input11312y) {
		this.input11312y = input11312y;
	}
	public String getInput11312v() {
		if (input11312v!=null) {
			return input11312v;
		}
		else {
			return "";
		}
		
	}
	public void setInput11312v(String input11312v) {
		this.input11312v = input11312v;
	}
	@Override
	public int hashCode() {
		return Objects.hash(criteriaId, input11312v, input11312y, uniqueKey1);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		YearTable11312 other = (YearTable11312) obj;
		return Objects.equals(criteriaId, other.criteriaId) && Objects.equals(input11312v, other.input11312v)
				&& Objects.equals(input11312y, other.input11312y) && uniqueKey1 == other.uniqueKey1;
	}
	
}
