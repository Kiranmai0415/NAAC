package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="yeartable1131")
public class YearTable1131 implements Serializable
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
    private String input1131y;
	@Column(name = "skill_development")
    private String input1131v;
	
	
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
	public String getInput1131y() {
		if (input1131y!=null) {
			return input1131y;
		}
		else {
			return "";
		}
		
	}
	public void setInput1131y(String input1131y) {
		this.input1131y = input1131y;
	}
	public String getInput1131v() {
		if (input1131v!=null) {
			return input1131v;
		}
		else {
			return "";
		}
	
	}
	public void setInput1131v(String input1131v) {
		this.input1131v = input1131v;
	}
	@Override
	public int hashCode() {
		return Objects.hash(criteriaId, input1131v, input1131y, uniqueKey1);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		YearTable1131 other = (YearTable1131) obj;
		return Objects.equals(criteriaId, other.criteriaId) && Objects.equals(input1131v, other.input1131v)
				&& Objects.equals(input1131y, other.input1131y) && uniqueKey1 == other.uniqueKey1;
	}
	
	
}
