package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="yeartable6321")
public class YearTable6321 implements Serializable
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
    private String input6321y;
	@Column(name = "conferences_workshops")
    private String input6321v;
	
	
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
	public String getInput6321y() {
		if (input6321y!=null) {
			return input6321y;
		}
		else {
			return "";
		}
	}
	public void setInput6321y(String input6321y) {
		this.input6321y = input6321y;
	}
	public String getInput6321v() {
		if (input6321v!=null) {
		return input6321v;
		}
		else {
			return "";
		}
			
	}
	public void setInput6321v(String input6321v) {
		this.input6321v = input6321v;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public int hashCode() {
		return Objects.hash(criteriaId, input6321v, input6321y, uniqueKey1);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		YearTable6321 other = (YearTable6321) obj;
		return Objects.equals(criteriaId, other.criteriaId) && Objects.equals(input6321v, other.input6321v)
				&& Objects.equals(input6321y, other.input6321y) && uniqueKey1 == other.uniqueKey1;
	}
	
	
}
