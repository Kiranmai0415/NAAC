package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="affiliated_yearTable2632")
public class Affiliated_YearTable2632 implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private CriteriaPrimaryKey criteriaId;
	
    @Id
    @Column(name="unique_key1")
	private long uniqueKey1;
    
	
	@Column(name = "students")
    private String input2632y;
	
	
	@Column(name = "finalyear")
    private String input2632v;
	
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
	public String getInput2632y() {
		return input2632y;
	}
	public void setInput2632y(String input2632y) {
		this.input2632y = input2632y;
	}
	public String getInput2632v() {
		return input2632v;
	}
	public void setInput2632v(String input2632v) {
		this.input2632v = input2632v;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public int hashCode() {
		return Objects.hash(criteriaId, input2632v, input2632y, uniqueKey1);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Affiliated_YearTable2632 other = (Affiliated_YearTable2632) obj;
		return Objects.equals(criteriaId, other.criteriaId) && Objects.equals(input2632v, other.input2632v)
				&& Objects.equals(input2632y, other.input2632y) && uniqueKey1 == other.uniqueKey1;
	}
	
	
	
}
