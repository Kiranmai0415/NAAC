package com.adiverse.erp.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="qia12_details")
public class QIAIndicator3 implements Serializable {
//12	
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private CriteriaPrimaryKey criteriaId;
	

	@Id
    @Column(name="unique_key1")
	private long uniqueKey1;

	
	@Column(name="State")
	  private String inputiiqa12t1;
	
	  @Column(name="University_Name")
	  private String inputiiqa12t2;
	  
	  @Column(name="Documents")
	  private String inputiiqa12t3;



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

	public String getInputiiqa12t1() {
		if (inputiiqa12t1!=null) {
			return inputiiqa12t1;
		}
		else {
			return "";
		}
		
	}

	public void setInputiiqa12t1(String inputiiqa12t1) {
		this.inputiiqa12t1 = inputiiqa12t1;
	}

	public String getInputiiqa12t2() {
		if (inputiiqa12t2!=null) {
			return inputiiqa12t2;
		}
		else {
			return "";
		}
	}

	public void setInputiiqa12t2(String inputiiqa12t2) {
		this.inputiiqa12t2 = inputiiqa12t2;
	}

	public String getInputiiqa12t3() {
		if (inputiiqa12t3!=null) {
			return inputiiqa12t3;
		}
		else {
			return "";
		}
	}

	public void setInputiiqa12t3(String inputiiqa12t3) {
		this.inputiiqa12t3 = inputiiqa12t3;
	}
	  


	
	
	  
	

}
