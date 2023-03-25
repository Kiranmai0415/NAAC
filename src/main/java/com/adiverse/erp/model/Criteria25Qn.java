package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name ="criteria25Qn")
public class Criteria25Qn implements Serializable
{
	private static final long serialVersionUID = 4920532919687126600L;

	
	private CriteriaPrimaryKey criteriaId;
	
	@Id
    @Column(name="unique_key1")
	private long uniqueKey1;

	
	@Column(name = "responseValue251")
    private String response251;
	
	@Column(name = "input251t1")
    private String input251t1;
	
	
	@Column(name = "responseValue252")
    private String response252;
	
	@Column(name = "criteria25status")
    private String criteria25status;

	
	

	public String getCriteria25status() {
		return criteria25status;
	}


	public void setCriteria25status(String criteria25status) {
		this.criteria25status = criteria25status;
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


	public String getResponse251() {
		if(response251 !=null) {
		return response251;
	}else {
		return "";
	}
	}


	public void setResponse251(String response251) {
		this.response251 = response251;
	}


	public String getInput251t1() {
		if(input251t1 !=null) {
		return input251t1;
	}else {
		return "";
	}
	}


	public void setInput251t1(String input251t1) {
		this.input251t1 = input251t1;
	}


	public String getResponse252() {
		if(response252 !=null) {
		return response252;
	}else {
		return "";
	}
	}


	public void setResponse252(String response252) {
		this.response252 = response252;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	@Override
	public int hashCode() {
		return Objects.hash(criteria25status, criteriaId, input251t1, response251, response252, uniqueKey1);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Criteria25Qn other = (Criteria25Qn) obj;
		return Objects.equals(criteria25status, other.criteria25status) && Objects.equals(criteriaId, other.criteriaId)
				&& Objects.equals(input251t1, other.input251t1) && Objects.equals(response251, other.response251)
				&& Objects.equals(response252, other.response252) && uniqueKey1 == other.uniqueKey1;
	}




		
}
