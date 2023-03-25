package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="affiliated_yeartable1221")
public class Affiliated_YearTable1221 implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
     //changes
	
	private CriteriaPrimaryKey criteriaId;
	
    @Id
    @Column(name="unique_key1")
	private long uniqueKey1;
	
	
	@Column(name = "year")
    private String input1221y;
	
	@Column(name = "subject")
    private String input1221v;

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

	public String getInput1221y() {
		if(input1221y !=null) {
		return input1221y;
	}else {
		return "";
	}
	}

	public void setInput1221y(String input1221y) {
		this.input1221y = input1221y;
	}

	public String getInput1221v() {
		if(input1221v !=null) {
		return input1221v;
	}else {
		return "";
	}
	}

	public void setInput1221v(String input1221v) {
		this.input1221v = input1221v;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(criteriaId, input1221v, input1221y, uniqueKey1);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Affiliated_YearTable1221 other = (Affiliated_YearTable1221) obj;
		return Objects.equals(criteriaId, other.criteriaId) && Objects.equals(input1221v, other.input1221v)
				&& Objects.equals(input1221y, other.input1221y) && uniqueKey1 == other.uniqueKey1;
	}
	
	
}