package com.adiverse.erp.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="ep_student22")
public class Epstudent22 implements Serializable
{
     private static final long serialVersionUID = 1L;


     private CriteriaPrimaryKey criteriaId;
   	
    	@Id
        @Column(name="unique_key1")
      	private long uniqueKey1;
   	
	@Column(name="studentOutgoingYear")
	private String input22y;
	
	@Column(name="studentOutgoingNumber")
	private String input22v;

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

	public String getInput22y() {
		if(input22y !=null) {
			return input22y;
		}else {
			return "";
		}
	}

	public void setInput22y(String input22y) {
		this.input22y = input22y;
	}

	public String getInput22v() {
		if(input22v !=null) {
			return input22v;
		}else {
			return "";
		}
	}

	public void setInput22v(String input22v) {
		this.input22v = input22v;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	

	
	
	
}