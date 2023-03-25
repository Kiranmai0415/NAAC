package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="epinstitution42")
public class EpInstitution42 implements Serializable
{
     private static final long serialVersionUID = 1L;


     private CriteriaPrimaryKey criteriaId;
   	
    	@Id
        @Column(name="unique_key1")
    	private long uniqueKey1;
   	
    
    @Column(name="institutionearnmarksYear")
    private String input42y;
    
    @Column(name= "institutioncategoryNumber")
    private String input42v;

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

	public String getInput42y() {
		if(input42y !=null) {
			return input42y;
		}else {
			return "";
		}
	}

	public void setInput42y(String input42y) {
		this.input42y = input42y;
	}

	public String getInput42v() {
		if(input42v !=null) {
			return input42v;
		}else {
			return "";
		}
	}

	public void setInput42v(String input42v) {
		this.input42v = input42v;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(criteriaId, input42v, input42y, uniqueKey1);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EpInstitution42 other = (EpInstitution42) obj;
		return Objects.equals(criteriaId, other.criteriaId) && Objects.equals(input42v, other.input42v)
				&& Objects.equals(input42y, other.input42y) && uniqueKey1 == other.uniqueKey1;
	}


    
    

}