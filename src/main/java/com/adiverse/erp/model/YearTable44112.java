package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="yeartable44112")
public class YearTable44112 implements Serializable
{
	private static final long serialVersionUID = 1L;

	private CriteriaPrimaryKey criteriaId;
	
    @Id
    @Column(name="unique_key1")
	private long uniqueKey1;
	
	@Column(name = "year")
    private String input44112y;
	@Column(name = "physical_facilities_1")
    private String input44112v;
	
	
	
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
	public String getInput44112y() {
		if (input44112y!=null) {
			return input44112y;
		}
		else {
			return "";
		}
		
	}
	public void setInput44112y(String input44112y) {
		this.input44112y = input44112y;
	}
	public String getInput44112v() {
		if (input44112v!=null) {
			return input44112v;
		}
		else {
			return "";
		}
		
	}
	public void setInput44112v(String input44112v) {
		this.input44112v = input44112v;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public int hashCode() {
		return Objects.hash(criteriaId, input44112v, input44112y, uniqueKey1);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		YearTable44112 other = (YearTable44112) obj;
		return Objects.equals(criteriaId, other.criteriaId) && Objects.equals(input44112v, other.input44112v)
				&& Objects.equals(input44112y, other.input44112y) && uniqueKey1 == other.uniqueKey1;
	}
	
}
