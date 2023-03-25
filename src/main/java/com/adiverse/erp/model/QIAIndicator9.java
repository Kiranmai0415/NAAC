package com.adiverse.erp.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="qia23_details")
public class QIAIndicator9 implements Serializable {

	private CriteriaPrimaryKey criteriaId;

	
	
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


//23
	
	@Id
    @Column(name="unique_key1")
	private long uniqueKey1;


	 @Column(name="Nonteachingstaff_Male")
	  private String inputiiqa23t1;
	 
	 @Column(name="Nonteachingstaff_Female")
	  private String inputiiqa23t2;
	 
	 @Column(name="Nonteachingstaff_Transgender")
	  private String inputiiqa23t3;
	 
	 @Column(name="Nonteachingstaff_Total")
	  private String inputiiqa23t4;

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

	public String getInputiiqa23t1() {
		if (inputiiqa23t1!=null) {
			return inputiiqa23t1;
		}
		else {
			return "";
		}
		
	}

	public void setInputiiqa23t1(String inputiiqa23t1) {
		this.inputiiqa23t1 = inputiiqa23t1;
	}

	public String getInputiiqa23t2() {
		if (inputiiqa23t2!=null) {
			return inputiiqa23t2;
		}
		else {
			return "";
		}
	}

	public void setInputiiqa23t2(String inputiiqa23t2) {
		this.inputiiqa23t2 = inputiiqa23t2;
	}

	public String getInputiiqa23t3() {
		if (inputiiqa23t3!=null) {
			return inputiiqa23t3;
		}
		else {
			return "";
		}
	}

	public void setInputiiqa23t3(String inputiiqa23t3) {
		this.inputiiqa23t3 = inputiiqa23t3;
	}

	public String getInputiiqa23t4() {
		if (inputiiqa23t4!=null) {
			return inputiiqa23t4;
		}
		else {
			return "";
		}
	}

	public void setInputiiqa23t4(String inputiiqa23t4) {
		this.inputiiqa23t4 = inputiiqa23t4;
	}
	 
	 
	
	 
}
