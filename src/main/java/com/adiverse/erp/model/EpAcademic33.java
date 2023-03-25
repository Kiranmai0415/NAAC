package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="ep_academic33")
public class EpAcademic33 implements Serializable
{
     private static final long serialVersionUID = 1L;


     private CriteriaPrimaryKey criteriaId;
   	
    	@Id
        @Column(name="unique_key1")
     	private long uniqueKey1;
   	
    
    @Column(name="academicsanctionedYear")
    private String input33y;
    
    @Column(name="academicsanctionedNumber")
    private String input33v;

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

	public String getInput33y() {
		if(input33y !=null) {
			return input33y;
		}else {
			return "";
		}
	}

	public void setInput33y(String input33y) {
		this.input33y = input33y;
	}

	public String getInput33v() {
		if(input33v !=null) {
			return input33v;
		}else {
			return "";
		}
	}

	public void setInput33v(String input33v) {
		this.input33v = input33v;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(criteriaId, input33v, input33y, uniqueKey1);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EpAcademic33 other = (EpAcademic33) obj;
		return Objects.equals(criteriaId, other.criteriaId) && Objects.equals(input33v, other.input33v)
				&& Objects.equals(input33y, other.input33y) && uniqueKey1 == other.uniqueKey1;
	}

	
	
    
    
    
}