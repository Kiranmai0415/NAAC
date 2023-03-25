package com.adiverse.erp.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="qia26_details")
//27
public class QIAIndicator7 implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private CriteriaPrimaryKey criteriaId;

	
	@Id
    @Column(name="unique_key1")
	private long uniqueKey1;

	 @Column(name="Date")
	  private String inputiiqa26t2;
	 
	  @Column(name="View_Document")	
	  private String iiqa26f1;

	

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

	public String getInputiiqa26t2() {
		if (inputiiqa26t2!=null) {
			return inputiiqa26t2;
		}
		else {
			return "";
		}
		
	}

	public void setInputiiqa26t2(String inputiiqa26t2) {
		this.inputiiqa26t2 = inputiiqa26t2;
	}

	public String getIiqa26f1() {
		if (iiqa26f1!=null) {
			return iiqa26f1;
		}
		else {
			return "";
		}
		
	}

	public void setIiqa26f1(String iiqa26f1) {
		this.iiqa26f1 = iiqa26f1;
	}
	  
	  
	
	
	  
	

}
