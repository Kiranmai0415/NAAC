package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="affiliated_yeartable2621")
public class Affiliated_YearTable2621 implements Serializable
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
    private String input2621y;
	@Column(name = "students")
    private String input2621v;
	
	
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
	public String getInput2621y() {
		if(input2621y !=null) {
		return input2621y;
	}else {
		return "";
	}
	}
	public void setInput2621y(String input2621y) {
		this.input2621y = input2621y;
	}
	public String getInput2621v() {
		if(input2621v !=null) {
		return input2621v;
	}else {
		return "";
	}
	}
	public void setInput2621v(String input2621v) {
		this.input2621v = input2621v;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;

	}
	@Override
	public int hashCode() {
		return Objects.hash(criteriaId, input2621v, input2621y, uniqueKey1);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Affiliated_YearTable2621 other = (Affiliated_YearTable2621) obj;
		return Objects.equals(criteriaId, other.criteriaId) && Objects.equals(input2621v, other.input2621v)
				&& Objects.equals(input2621y, other.input2621y) && uniqueKey1 == other.uniqueKey1;
	}
	
	
	
	}
