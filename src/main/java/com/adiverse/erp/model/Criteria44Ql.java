package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="criteria44Ql")
public class Criteria44Ql implements Serializable
{
	
	
	
	
	private static final long serialVersionUID = 1L;
	
	
	private CriteriaPrimaryKey criteriaId;
	
	@Id
    @Column(name="unique_key1")
	private long uniqueKey1;
	
	@Column(name = "responseValue441")
    private String response441;
	
	@Column(name = "responseValue442")
    private String response442;
	
	
	
	
	@Column(name = "input442t1")
    private String input442t1;
	

	@Column(name = "criteria44status")
    private String criteria44status;


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


	public String getResponse441() {
		if(response441 !=null) {
		return response441;
	}else {
		return "";
	}
	}


	public void setResponse441(String response441) {
		this.response441 = response441;
	}


	public String getResponse442() {
		if(response442 !=null) {
		return response442;
	}else {
		return "";
	}
	}


	public void setResponse442(String response442) {
		this.response442 = response442;
	}


	public String getInput442t1() {
		if(input442t1 !=null) {
		return input442t1;
	}else {
		return "";
	}
	}


	public void setInput442t1(String input442t1) {
		this.input442t1 = input442t1;
	}


	public String getCriteria44status() {
		return criteria44status;
	}


	public void setCriteria44status(String criteria44status) {
		this.criteria44status = criteria44status;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	@Override
	public int hashCode() {
		return Objects.hash(criteria44status, criteriaId, input442t1, response441, response442, uniqueKey1);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Criteria44Ql other = (Criteria44Ql) obj;
		return Objects.equals(criteria44status, other.criteria44status) && Objects.equals(criteriaId, other.criteriaId)
				&& Objects.equals(input442t1, other.input442t1) && Objects.equals(response441, other.response441)
				&& Objects.equals(response442, other.response442) && uniqueKey1 == other.uniqueKey1;
	}


	

}
