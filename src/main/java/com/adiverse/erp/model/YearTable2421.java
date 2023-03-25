package com.adiverse.erp.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="yeartable2421")
public class YearTable2421 implements Serializable
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
    private String input2421y;
	@Column(name = "fulltime_teachers")
    private String input2421v;
	
	
	
	public String getInput2421y() {
		if (input2421y!=null) {
			return input2421y;
		}
		else {
			return "";
		}
		
	}
	public void setInput2421y(String input2421y) {
		this.input2421y = input2421y;
	}
	public String getInput2421v() {
		if (input2421v!=null) {
			return input2421v;
		}
		else {
			return "";
		}
		
	}
	public void setInput2421v(String input2421v) {
		this.input2421v = input2421v;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
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
	
	
}
