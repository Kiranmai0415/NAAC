package com.adiverse.erp.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="qia18_details")
public class QIAIndicator4 implements Serializable{
//18 table
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private CriteriaPrimaryKey criteriaId;

	
	@Id
    @Column(name="unique_key1")
	private long uniqueKey1;

	@Column(name="SRA_program")
	  private String inputiiqa18t2;
	
	  @Column(name="Document")	
	  private String inputiiqa18t3;

	

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

	public String getInputiiqa18t2() {
		if (inputiiqa18t2!=null) {
			return inputiiqa18t2;
		}
		else {
			return "";
		}
		
	}

	public void setInputiiqa18t2(String inputiiqa18t2) {
		this.inputiiqa18t2 = inputiiqa18t2;
	}

	public String getInputiiqa18t3() {
		if (inputiiqa18t3!=null) {
			return inputiiqa18t3;
		}
		else {
			return "";
		}
	}

	public void setInputiiqa18t3(String inputiiqa18t3) {
		this.inputiiqa18t3 = inputiiqa18t3;
	}
	
	
	

	
}
