package com.adiverse.erp.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "qia20_details")
public class QIAIndicator5 implements Serializable {
//20 	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private CriteriaPrimaryKey criteriaId;

	@Id
	@Column(name = "unique_key1")
	private long uniqueKey1;

	@Column(name = "Programmes")
	private String inputiiqa20t1;
	
	@Column(name = "Number")
	private String inputiiqa20t2;

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

	public String getInputiiqa20t1() {
		if (inputiiqa20t1!=null) {
			return inputiiqa20t1;
		}
		else {
			return "";
		}
		
	}

	public void setInputiiqa20t1(String inputiiqa20t1) {
		this.inputiiqa20t1 = inputiiqa20t1;
	}

	public String getInputiiqa20t2() {
		if (inputiiqa20t2!=null) {
			return inputiiqa20t2;
		}
		else {
			return "";
		}
		
	}

	public void setInputiiqa20t2(String inputiiqa20t2) {
		this.inputiiqa20t2 = inputiiqa20t2;
	}

}
