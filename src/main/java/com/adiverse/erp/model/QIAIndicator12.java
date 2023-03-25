package com.adiverse.erp.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="qiat11_details")
		
public class QIAIndicator12 implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private CriteriaPrimaryKey criteriaId;


	@Id
    @Column(name="unique_key1")
	private long uniqueKey1;

	

	
	 @Column(name="Cycle")
	  private String inputiiqa1t3;
	 
	  @Column(name="Date")	
	  private String inputiiqa1t4;
	  
	  @Column(name="Grade")	
	  private String inputiiqa1t5;
	  
	  @Column(name="Score")	
	  private String inputiiqa1t6;



	public CriteriaPrimaryKey getCriteriaId() {
		return criteriaId;
	}

	public void setCriteriaId(CriteriaPrimaryKey criteriaId) {
		this.criteriaId = criteriaId;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public long getUniqueKey1() {
		return uniqueKey1;
	}

	public void setUniqueKey1(long uniqueKey1) {
		this.uniqueKey1 = uniqueKey1;
	}

	public String getInputiiqa1t3() {
		if (inputiiqa1t3!=null) {
			return inputiiqa1t3;
		}
		else {
			return "";
		}		
	}

	public void setInputiiqa1t3(String inputiiqa1t3) {
		this.inputiiqa1t3 = inputiiqa1t3;
	}

	public String getInputiiqa1t4() {
		if (inputiiqa1t4!=null) {
			return inputiiqa1t4;
		}
		else {
			return "";
		}
	}

	public void setInputiiqa1t4(String inputiiqa1t4) {
		this.inputiiqa1t4 = inputiiqa1t4;
	}

	public String getInputiiqa1t5() {
		if (inputiiqa1t5!=null) {
			return inputiiqa1t5;
		}
		else {
			return "";
		}
	}

	public void setInputiiqa1t5(String inputiiqa1t5) {
		this.inputiiqa1t5 = inputiiqa1t5;
	}

	public String getInputiiqa1t6() {
		if (inputiiqa1t6!=null) {
			return inputiiqa1t6;
		}
		else {
			return "";
		}
	}

	public void setInputiiqa1t6(String inputiiqa1t6) {
		this.inputiiqa1t6 = inputiiqa1t6;
	}
	  


	
	  
	  
	  
	
}
