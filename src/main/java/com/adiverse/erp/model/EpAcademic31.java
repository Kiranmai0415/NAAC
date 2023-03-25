package com.adiverse.erp.model;


import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="ep_academic31")
public class EpAcademic31 implements Serializable
{
	
     private static final long serialVersionUID = 1L;

     private CriteriaPrimaryKey criteriaId;
   	
    	@Id
    	
        @Column(name="unique_key1")
    	private long uniqueKey1;
   	
	
    @Column(name="academiccourseYear")
     private String input31y;
    
    @Column(name="academicprogrammerNumber")
    private String input31v;

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

	public String getInput31y() {
		if(input31y !=null) {
		return input31y;
	}else {
		return "";
	}
	}

	public void setInput31y(String input31y) {
		this.input31y = input31y;
	}

	public String getInput31v() {
		if(input31v !=null) {
		return input31v;
	}else {
		return "";
	}
	}

	public void setInput31v(String input31v) {
		this.input31v = input31v;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(criteriaId, input31v, input31y, uniqueKey1);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EpAcademic31 other = (EpAcademic31) obj;
		return Objects.equals(criteriaId, other.criteriaId) && Objects.equals(input31v, other.input31v)
				&& Objects.equals(input31y, other.input31y) && uniqueKey1 == other.uniqueKey1;
	}

	

	

	
}