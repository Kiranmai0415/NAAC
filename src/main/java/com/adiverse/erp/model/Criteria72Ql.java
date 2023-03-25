package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="criteria72Ql")
public class Criteria72Ql implements Serializable
{

	

	private static final long serialVersionUID = 4708923488494526011L;

	
	private CriteriaPrimaryKey criteriaId;
	
	@Id
    @Column(name="unique_key1")
	private long uniqueKey1;
	
	@Column(name = "responseValue721")
    private String response721;
	
	
	@Column(name = "input721t1")
    private String input721t1;
	

	@Column(name = "criteria72status")
    private String criteria72status;


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


	public String getResponse721() {
		if(response721 !=null) {
		return response721;
	}else {
		return "";
	}
	}


	public void setResponse721(String response721) {
		this.response721 = response721;
	}


	public String getInput721t1() {
		if(input721t1 !=null) {
		return input721t1;
	}else {
		return "";
	}
	}


	public void setInput721t1(String input721t1) {
		this.input721t1 = input721t1;
	}


	public String getCriteria72status() {
		return criteria72status;
	}


	public void setCriteria72status(String criteria72status) {
		this.criteria72status = criteria72status;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	@Override
	public int hashCode() {
		return Objects.hash(criteria72status, criteriaId, input721t1, response721, uniqueKey1);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Criteria72Ql other = (Criteria72Ql) obj;
		return Objects.equals(criteria72status, other.criteria72status) && Objects.equals(criteriaId, other.criteriaId)
				&& Objects.equals(input721t1, other.input721t1) && Objects.equals(response721, other.response721)
				&& uniqueKey1 == other.uniqueKey1;
	}


}
