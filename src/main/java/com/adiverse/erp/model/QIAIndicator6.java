package com.adiverse.erp.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="qia21_details")
public class QIAIndicator6 implements Serializable {
//21 table
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private CriteriaPrimaryKey criteriaId;

	
	@Id
    @Column(name="unique_key1")
	private long uniqueKey1;

	 @Column(name="Programme")
	  private String inputiiqa21t1;
	 
	  @Column(name="Department")	
	  private String inputiiqa21t2;
	  
	  @Column(name="University_Affiliation")	
	  private String inputiiqa21t3;
	  
	  @Column(name="SRA_Recognition")	
	  private String inputiiqa21t4;
	  
	  @Column(name="Affiliation_Status")	
	  private String inputiiqa21t5;


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

	public String getInputiiqa21t1() {
		if (inputiiqa21t1!=null) {
			return inputiiqa21t1;
		}
		else {
			return "";
		}
		
	}

	public void setInputiiqa21t1(String inputiiqa21t1) {
		this.inputiiqa21t1 = inputiiqa21t1;
	}

	public String getInputiiqa21t2() {
		if (inputiiqa21t2!=null) {
			return inputiiqa21t2;
		}
		else {
			return "";
		}
		
	}

	public void setInputiiqa21t2(String inputiiqa21t2) {
		this.inputiiqa21t2 = inputiiqa21t2;
	}

	public String getInputiiqa21t3() {
		if (inputiiqa21t3!=null) {
			return inputiiqa21t3;
		}
		else {
			return "";
		}
		
	}

	public void setInputiiqa21t3(String inputiiqa21t3) {
		this.inputiiqa21t3 = inputiiqa21t3;
	}

	public String getInputiiqa21t4() {
		if (inputiiqa21t4!=null) {
			return inputiiqa21t4;
		}
		else {
			return "";
		}
		
	}

	public void setInputiiqa21t4(String inputiiqa21t4) {
		this.inputiiqa21t4 = inputiiqa21t4;
	}

	public String getInputiiqa21t5() {
		if (inputiiqa21t5!=null) {
			return inputiiqa21t5;
		}
		else {
			return "";
		}
		
	}

	public void setInputiiqa21t5(String inputiiqa21t5) {
		this.inputiiqa21t5 = inputiiqa21t5;
	}
	  
	  


}
