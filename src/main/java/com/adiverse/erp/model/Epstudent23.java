package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


//@Component
@Entity
@Table(name="ep_student23")
public class Epstudent23 implements Serializable
{
     private static final long serialVersionUID = 1L;



     private CriteriaPrimaryKey criteriaId;
   	
    	@Id
        @Column(name="unique_key1")
   	    private long uniqueKey1;
   	
	
	@Column(name="studentAppearedexaminationYear")
	private String input23y;
	
	@Column(name="studentAppearedexaminationNumber")
	private String input23v;

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

	public String getInput23y() {
		if(input23y !=null) {
			return input23y;
		}else {
			return "";
		}
	}

	public void setInput23y(String input23y) {
		this.input23y = input23y;
	}

	public String getInput23v() {
		if(input23v !=null) {
			return input23v;
		}else {
			return "";
		}
	}

	public void setInput23v(String input23v) {
		this.input23v = input23v;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(criteriaId, input23v, input23y, uniqueKey1);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Epstudent23 other = (Epstudent23) obj;
		return Objects.equals(criteriaId, other.criteriaId) && Objects.equals(input23v, other.input23v)
				&& Objects.equals(input23y, other.input23y) && uniqueKey1 == other.uniqueKey1;
	}

	

}