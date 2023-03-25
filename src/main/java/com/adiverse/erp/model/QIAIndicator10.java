package com.adiverse.erp.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="qia24_details")
public class QIAIndicator10 implements Serializable {
//24	
	
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




	 @Column(name="Studentsroll_Male")
	  private String inputiiqa24t1;
	 @Column(name="Studentsroll_Female")
	  private String inputiiqa24t2;
	 @Column(name="Studentsroll_Transgender")
	  private String inputiiqa24t3;
	 @Column(name="Studentsroll_Total")
	  private String inputiiqa24t4;
	
	 
	 
	 
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
	public String getInputiiqa24t1() {
		if (inputiiqa24t1!=null) {
			return inputiiqa24t1;
		}
		else {
			return "";
		}
		
	}
	public void setInputiiqa24t1(String inputiiqa24t1) {
		this.inputiiqa24t1 = inputiiqa24t1;
	}
	public String getInputiiqa24t2() {
		if (inputiiqa24t2!=null) {
			return inputiiqa24t2;
		}
		else {
			return "";
		}
	}
	public void setInputiiqa24t2(String inputiiqa24t2) {
		this.inputiiqa24t2 = inputiiqa24t2;
	}
	public String getInputiiqa24t3() {
		if (inputiiqa24t3!=null) {
			return inputiiqa24t3;
		}
		else {
			return "";
		}
	}
	public void setInputiiqa24t3(String inputiiqa24t3) {
		this.inputiiqa24t3 = inputiiqa24t3;
	}
	public String getInputiiqa24t4() {
		if (inputiiqa24t4!=null) {
			return inputiiqa24t4;
		}
		else {
			return "";
		}
	}
	public void setInputiiqa24t4(String inputiiqa24t4) {
		this.inputiiqa24t4 = inputiiqa24t4;
	}
	 
	 
	 
	
	 

	 
}
