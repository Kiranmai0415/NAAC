package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="yeartable25212")
public class YearTable25212 implements Serializable
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
    private String input25212y;
	@Column(name = "complaints_grievances_1")
    private String input25212v;
	
	
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
	public String getInput25212y() {
		if (input25212y!=null) {
			return input25212y;
		}
		else {
			return "";
		}
		
	}
	public void setInput25212y(String input25212y) {
		this.input25212y = input25212y;
	}
	public String getInput25212v() {
		if (input25212v!=null) {
			return input25212v;
		}else {
		return "";
		}
	}
	public void setInput25212v(String input25212v) {
		this.input25212v = input25212v;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public int hashCode() {
		return Objects.hash(criteriaId, input25212v, input25212y, uniqueKey1);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		YearTable25212 other = (YearTable25212) obj;
		return Objects.equals(criteriaId, other.criteriaId) && Objects.equals(input25212v, other.input25212v)
				&& Objects.equals(input25212y, other.input25212y) && uniqueKey1 == other.uniqueKey1;
	}
	
}
