package com.adiverse.erp.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="qia22_details")
public class QIAIndicator1 implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private CriteriaPrimaryKey criteriaId;

	@Id
    @Column(name="unique_key1")
	private long uniqueKey1;
	
	
	
	//22	
		 @Column(name="Numberofteaching_Male")
		  private String inputiiqa22t1;
		 
		 @Column(name="Numberofteaching_Female")
		  private String inputiiqa22t2;
		 
		@Column(name="Numberofteaching_Transgender")
		 private String inputiiqa22t3;
			
		 @Column(name="Numberofteaching_Total")
		 private String inputiiqa22t4;

	
	
	

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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	
	public String getInputiiqa22t1() {
		if (inputiiqa22t1!=null) {
			return inputiiqa22t1;
		}
		else {
			return "";
		}
		
	}

	public void setInputiiqa22t1(String inputiiqa22t1) {
		this.inputiiqa22t1 = inputiiqa22t1;
	}

	public String getInputiiqa22t2() {
		if (inputiiqa22t2!=null) {
			return inputiiqa22t2;
		}
		else {
			return "";
		}
	}

	public void setInputiiqa22t2(String inputiiqa22t2) {
		this.inputiiqa22t2 = inputiiqa22t2;
	}

	public String getInputiiqa22t3() {
		if (inputiiqa22t3!=null) {
			return inputiiqa22t3;
		}
		else {
			return "";
		}
	}

	public void setInputiiqa22t3(String inputiiqa22t3) {
		this.inputiiqa22t3 = inputiiqa22t3;
	}

	public String getInputiiqa22t4() {
		if (inputiiqa22t4!=null) {
			return inputiiqa22t4;
		}
		else {
			return "";
		}
	}

	public void setInputiiqa22t4(String inputiiqa22t4) {
		this.inputiiqa22t4 = inputiiqa22t4;
	}

	 
	 
	
	
	
	  
	  

}
