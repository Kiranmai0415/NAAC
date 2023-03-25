package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="criteria54Ql")
public class Criteria54Ql implements Serializable
{
private static final long serialVersionUID = 1L;

	
	private CriteriaPrimaryKey criteriaId;
	
	@Id
    @Column(name="unique_key1")
	private long uniqueKey1;
	
	@Column(name = "responseValue541")
    private String response541;
	
	@Column(name = "input541t1")
    private String input541t1;
	
	@Column(name = "responseValue542")
    private String response542;
	

	@Column(name = "input542t1")
    private String input542t1;
	

	
	@Column(name = "criteria54status")
    private String criteria54status;



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



	public String getResponse541() {
		if(response541 !=null) {
		return response541;
	}else {
		return "";
	}
	}



	public void setResponse541(String response541) {
		this.response541 = response541;
	}



	public String getInput541t1() {
		if(input541t1 !=null) {
		return input541t1;
	}else {
		return "";
	}
	}



	public void setInput541t1(String input541t1) {
		this.input541t1 = input541t1;
	}



	public String getResponse542() {
		if(response542 !=null) {
		return response542;
	}else {
		return "";
	}
	}



	public void setResponse542(String response542) {
		this.response542 = response542;
	}



	public String getInput542t1() {
		if(input542t1 !=null) {
		return input542t1;
	}else {
		return "";
	}
	}



	public void setInput542t1(String input542t1) {
		this.input542t1 = input542t1;
	}



	public String getCriteria54status() {
		return criteria54status;
	}



	public void setCriteria54status(String criteria54status) {
		this.criteria54status = criteria54status;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	@Override
	public int hashCode() {
		return Objects.hash(criteria54status, criteriaId, input541t1, input542t1, response541, response542, uniqueKey1);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Criteria54Ql other = (Criteria54Ql) obj;
		return Objects.equals(criteria54status, other.criteria54status) && Objects.equals(criteriaId, other.criteriaId)
				&& Objects.equals(input541t1, other.input541t1) && Objects.equals(input542t1, other.input542t1)
				&& Objects.equals(response541, other.response541) && Objects.equals(response542, other.response542)
				&& uniqueKey1 == other.uniqueKey1;
	}
	
	



}
