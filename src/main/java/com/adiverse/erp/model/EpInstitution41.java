package com.adiverse.erp.model;


import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="epinstitution41")
public class EpInstitution41 implements Serializable
{
     private static final long serialVersionUID = 1L;


     private CriteriaPrimaryKey criteriaId;
   	
    	@Id
        @Column(name="unique_key1")
    	private long uniqueKey1;
   	
    
    @Column(name="institutionapplicationreceivedYear")
    private String input41y;
    
    @Column(name="institionadmissionNumber")
    private String input41v;

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

	public String getInput41y() {
		if(input41y !=null) {
			return input41y;
		}else {
			return "";
		}
	}

	public void setInput41y(String input41y) {
		this.input41y = input41y;
	}

	public String getInput41v() {
		if(input41v !=null) {
			return input41v;
		}else {
			return "";
		}
	}

	public void setInput41v(String input41v) {
		this.input41v = input41v;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(criteriaId, input41v, input41y, uniqueKey1);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EpInstitution41 other = (EpInstitution41) obj;
		return Objects.equals(criteriaId, other.criteriaId) && Objects.equals(input41v, other.input41v)
				&& Objects.equals(input41y, other.input41y) && uniqueKey1 == other.uniqueKey1;
	}

	
    



}