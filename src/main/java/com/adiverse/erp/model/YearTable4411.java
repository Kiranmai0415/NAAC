package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="yeartable4411")
public class YearTable4411 implements Serializable
{
	private static final long serialVersionUID = 1L;

	private CriteriaPrimaryKey criteriaId;
	
    @Id
    @Column(name="unique_key1")
	private long uniqueKey1;
	
	@Column(name = "year")
    private String input4411y;
	@Column(name = "physical_facilities")
    private String input4411v;
	
	
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
	public String getInput4411y() {
		if (input4411y!=null) {
			return input4411y;
		}
		else {
			return "";
		}
		
	}
	public void setInput4411y(String input4411y) {
		this.input4411y = input4411y;
	}
	public String getInput4411v() {
		if (input4411v!=null) {
			return input4411v;
		}
		else {
			return "";
		}
		
	}
	public void setInput4411v(String input4411v) {
		this.input4411v = input4411v;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public int hashCode() {
		return Objects.hash(criteriaId, input4411v, input4411y, uniqueKey1);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		YearTable4411 other = (YearTable4411) obj;
		return Objects.equals(criteriaId, other.criteriaId) && Objects.equals(input4411v, other.input4411v)
				&& Objects.equals(input4411y, other.input4411y) && uniqueKey1 == other.uniqueKey1;
	}
	
}
