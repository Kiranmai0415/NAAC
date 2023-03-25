package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name ="criteria73Ql")
public class Criteria73Ql implements Serializable
{
	

	private static final long serialVersionUID = 4708923488494526011L;

	
	private CriteriaPrimaryKey criteriaId;
	
	@Id
    @Column(name="unique_key1")
	private long uniqueKey1;
	
	
	@Column(name = "responseValue731")
    private String response731;
	
	@Column(name = "input731t1")
    private String input731t1;
	
	@Column(name = "criteria73status")
    private String criteria73status;

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

	public String getResponse731() {
		return response731;
	}

	public void setResponse731(String response731) {
		this.response731 = response731;
	}

	public String getInput731t1() {
		
		if(input731t1 !=null) {
		return input731t1;
	}else {
		return "";
	}
	}

	public void setInput731t1(String input731t1) {
		this.input731t1 = input731t1;
	}

	public String getCriteria73status() {
		return criteria73status;
	}

	public void setCriteria73status(String criteria73status) {
		this.criteria73status = criteria73status;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(criteria73status, criteriaId, input731t1, response731, uniqueKey1);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Criteria73Ql other = (Criteria73Ql) obj;
		return Objects.equals(criteria73status, other.criteria73status) && Objects.equals(criteriaId, other.criteriaId)
				&& Objects.equals(input731t1, other.input731t1) && Objects.equals(response731, other.response731)
				&& uniqueKey1 == other.uniqueKey1;
	}
	
	


}
