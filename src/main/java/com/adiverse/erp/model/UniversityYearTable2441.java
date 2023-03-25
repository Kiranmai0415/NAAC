package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="universityyeartable2441")
public class UniversityYearTable2441 implements Serializable
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
    private String input2441y;
	@Column(name = "Recognized_bodies")
    private String input2441v;
	
	
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
	public String getInput2441y() {
		if (input2441y!=null) {
			return input2441y;
		}
		else {
			return "";
		}
		
	}
	public void setInput2441y(String input2441y) {
		this.input2441y = input2441y;
	}
	public String getInput2441v() {
		if (input2441v!=null) {
			return input2441v;
		}
		else {
			return "";
		}
		
	}
	public void setInput2441v(String input2441v) {
		this.input2441v = input2441v;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public int hashCode() {
		return Objects.hash(criteriaId, input2441v, input2441y, uniqueKey1);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UniversityYearTable2441 other = (UniversityYearTable2441) obj;
		return Objects.equals(criteriaId, other.criteriaId) && Objects.equals(input2441v, other.input2441v)
				&& Objects.equals(input2441y, other.input2441y) && uniqueKey1 == other.uniqueKey1;
	}
	
	
	}
