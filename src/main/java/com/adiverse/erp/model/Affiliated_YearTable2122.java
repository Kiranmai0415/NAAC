package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="affiliated_YearTable2122")
public class Affiliated_YearTable2122 implements Serializable
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
    private String input2122y;
	
	@Column(name = "govtrules")
    private String input2122v;

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

	public String getInput2122y() {
		if(input2122y !=null) {
		return input2122y;
	}else {
		return "";
	}
	}

	public void setInput2122y(String input2122y) {
		this.input2122y = input2122y;
	}

	public String getInput2122v() {
		if(input2122v !=null) {
		return input2122v;
	}else {
		return "";
	}
	}

	public void setInput2122v(String input2122v) {
		this.input2122v = input2122v;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(criteriaId, input2122v, input2122y, uniqueKey1);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Affiliated_YearTable2122 other = (Affiliated_YearTable2122) obj;
		return Objects.equals(criteriaId, other.criteriaId) && Objects.equals(input2122v, other.input2122v)
				&& Objects.equals(input2122y, other.input2122y) && uniqueKey1 == other.uniqueKey1;
	}

	
	
}