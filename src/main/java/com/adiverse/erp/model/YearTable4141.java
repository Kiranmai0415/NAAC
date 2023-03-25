package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="yeartable4141")
public class YearTable4141 implements Serializable
{
	private static final long serialVersionUID = 1L;

	private CriteriaPrimaryKey criteriaId;
	
    @Id
    @Column(name="unique_key1")
	private long uniqueKey1;
	
	@Column(name = "year")
    private String input4141y;
	@Column(name = "expenditure_infrastructure")
    private String input4141v;
	
	
	
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
	public String getInput4141y() {
		if (input4141y!=null) {
			return input4141y;
		}
		else {
			return "";
		}
		
	}
	public void setInput4141y(String input4141y) {
		this.input4141y = input4141y;
	}
	public String getInput4141v() {
		if (input4141v!=null) {
			return input4141v;
		}
		else {
			return "";
		}
		
	}
	public void setInput4141v(String input4141v) {
		this.input4141v = input4141v;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public int hashCode() {
		return Objects.hash(criteriaId, input4141v, input4141y, uniqueKey1);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		YearTable4141 other = (YearTable4141) obj;
		return Objects.equals(criteriaId, other.criteriaId) && Objects.equals(input4141v, other.input4141v)
				&& Objects.equals(input4141y, other.input4141y) && uniqueKey1 == other.uniqueKey1;
	}

	
}
