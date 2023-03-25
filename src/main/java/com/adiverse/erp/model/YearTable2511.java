package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="yeartable2511")
public class YearTable2511 implements Serializable
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
    private String input2511y;
	@Column(name = "semester_year")
    private String input2511v;
	
	

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
	public String getInput2511y() {
		if (input2511y!=null) {
			return input2511y;
		}
		else {
			return "";
		}
		
	}
	public void setInput2511y(String input2511y) {
		this.input2511y = input2511y;
	}
	public String getInput2511v() {
		if (input2511v!=null) {
			return input2511v;
		}
		else {
			return "";
		}
		
	}
	public void setInput2511v(String input2511v) {
		this.input2511v = input2511v;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public int hashCode() {
		return Objects.hash(criteriaId, input2511v, input2511y, uniqueKey1);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		YearTable2511 other = (YearTable2511) obj;
		return Objects.equals(criteriaId, other.criteriaId) && Objects.equals(input2511v, other.input2511v)
				&& Objects.equals(input2511y, other.input2511y) && uniqueKey1 == other.uniqueKey1;
	}
	
}
