package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="Ep_academic32")
public class EpAcademic32 implements Serializable
{
     private static final long serialVersionUID = 1L;


     private CriteriaPrimaryKey criteriaId;
   	
    	@Id
        @Column(name="unique_key1")
     	private long uniqueKey1;
    	
  
    @Column(name="academicfulltimeYear")
    private String input32y;
    
    @Column(name="academicteacherNumber")
    private String input32v;

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

	public String getInput32y() {
		if(input32y !=null) {
			return input32y;
		}else {
			return "";
		}
	}

	public void setInput32y(String input32y) {
		this.input32y = input32y;
	}

	public String getInput32v() {
		if(input32v !=null) {
			return input32v;
		}else {
			return "";
		}
	}

	public void setInput32v(String input32v) {
		this.input32v = input32v;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(criteriaId, input32v, input32y, uniqueKey1);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EpAcademic32 other = (EpAcademic32) obj;
		return Objects.equals(criteriaId, other.criteriaId) && Objects.equals(input32v, other.input32v)
				&& Objects.equals(input32y, other.input32y) && uniqueKey1 == other.uniqueKey1;
	}

	

	

	
    

}