 package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="yeartable2111")
public class YearTable2111 implements Serializable



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
    private String input2111y;
	
	
	@Column(name = "students_admitted")
    private String input2111v;
	
	
	
	
	
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
	public String getInput2111y() {
		if (input2111y!=null) {
			return input2111y;
		}
		else {
			return "";
		}
	
	}
	public void setInput2111y(String input2111y) {
		this.input2111y = input2111y;
	}
	public String getInput2111v() {
		if (input2111v!=null) {
			return input2111v;
		}
		else {
			return "";
		}
		
	}
	public void setInput2111v(String input2111v) {
		this.input2111v = input2111v;
		
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public int hashCode() {
		return Objects.hash(criteriaId, input2111v, input2111y, uniqueKey1);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		YearTable2111 other = (YearTable2111) obj;
		return Objects.equals(criteriaId, other.criteriaId) && Objects.equals(input2111v, other.input2111v)
				&& Objects.equals(input2111y, other.input2111y) && uniqueKey1 == other.uniqueKey1;
	}
	
	
}
