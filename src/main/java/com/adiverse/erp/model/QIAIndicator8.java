package com.adiverse.erp.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="qia27_details")
		
public class QIAIndicator8 implements Serializable {

	//26
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private CriteriaPrimaryKey criteriaId;

	@Id
    @Column(name="unique_key1")
	private long uniqueKey1;

	
	 @Column(name="Date")
	  private String inputiiqa27t1;
	 
	  @Column(name="View_Document")	
	  private String iiqa27f1;

	

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

	public String getInputiiqa27t1() {
		if (inputiiqa27t1!=null) {
			return inputiiqa27t1;
		}
		else {
			return "";
		}
		
	}

	public void setInputiiqa27t1(String inputiiqa27t1) {
		this.inputiiqa27t1 = inputiiqa27t1;
	}

	public String getIiqa27f1() {
		if (iiqa27f1!=null) {
			return iiqa27f1;
		}
		else {
			return "";
		}
		
	}

	public void setIiqa27f1(String iiqa27f1) {
		this.iiqa27f1 = iiqa27f1;
	}
	  

	
	
	  
	  
	  
	
}
