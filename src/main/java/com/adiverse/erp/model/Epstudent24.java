package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="ep_student24")
public class Epstudent24 implements Serializable
{
     private static final long serialVersionUID = 1L;


     private CriteriaPrimaryKey criteriaId;
   	
    	@Id
        @Column(name="unique_key1")
      	private long uniqueKey1;
   	
	@Column(name="studentRevalutionYear")
	private String input24y;
	
	@Column(name="studentRevalutionNumber")
	private String input24v;

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

	public String getInput24y() {
		if(input24y!=null) {
			return input24y;
		}else {
			return "";
		}
	}

	public void setInput24y(String input24y) {
		this.input24y = input24y;
	}

	public String getInput24v() {
		if(input24v !=null) {
			return input24v;
		}else {
			return "";
		}
	}

	public void setInput24v(String input24v) {
		this.input24v = input24v;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(criteriaId, input24v, input24y, uniqueKey1);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Epstudent24 other = (Epstudent24) obj;
		return Objects.equals(criteriaId, other.criteriaId) && Objects.equals(input24v, other.input24v)
				&& Objects.equals(input24y, other.input24y) && uniqueKey1 == other.uniqueKey1;
	}

	

	

	
  
}