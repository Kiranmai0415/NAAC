package com.adiverse.erp.model;


import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;


@Component
@Entity
@Table(name="ep_student21")
public class Epstudent21 implements Serializable
{
	
    private static final long serialVersionUID = 1L;



    private CriteriaPrimaryKey criteriaId;
  	
   	@Id
      @Column(name="unique_key1")
  	private long uniqueKey1;
  	
	
	@Column(name="studentYear")
	private String input21y;
	
	@Column(name="studentNumberLast")
	private String input21v;

// affiliated
	@Column(name="fulltimeteacher")
	private String input23v;

	
	
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

	public String getInput21y() {
		if(input21y !=null) {
			return input21y;
		}else {
			return "";
		}
	}

	public void setInput21y(String input21y) {
		this.input21y = input21y;
	}

	public String getInput21v() {
		if(input21v !=null) {
			return input21v;
		}else {
			return "";
		}
	}

	public void setInput21v(String input21v) {
		this.input21v = input21v;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(criteriaId, input21v, input21y, input23v, uniqueKey1);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Epstudent21 other = (Epstudent21) obj;
		return Objects.equals(criteriaId, other.criteriaId) && Objects.equals(input21v, other.input21v)
				&& Objects.equals(input21y, other.input21y) && Objects.equals(input23v, other.input23v)
				&& uniqueKey1 == other.uniqueKey1;
	}

	

	
	
	
}