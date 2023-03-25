package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="affiliated_yeartable2622")
public class Affiliated_YearTable2622 implements Serializable
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
    private String input2622y;
	@Column(name = "finalyear")
    private String input2622v;
	
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
	public String getInput2622y() {
		if(input2622y !=null) {
		return input2622y;
	}else {
		return "";
	}
	}
	public void setInput2622y(String input2622y) {
		this.input2622y = input2622y;
	}
	public String getInput2622v() {
		if(input2622v !=null) {
		return input2622v;
	}else {
		return "";
	}
	}
	public void setInput2622v(String input2622v) {
		this.input2622v = input2622v;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public int hashCode() {
		return Objects.hash(criteriaId, input2622v, input2622y, uniqueKey1);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Affiliated_YearTable2622 other = (Affiliated_YearTable2622) obj;
		return Objects.equals(criteriaId, other.criteriaId) && Objects.equals(input2622v, other.input2622v)
				&& Objects.equals(input2622y, other.input2622y) && uniqueKey1 == other.uniqueKey1;
	}
	
	
	
	
	
	
	
	
}
