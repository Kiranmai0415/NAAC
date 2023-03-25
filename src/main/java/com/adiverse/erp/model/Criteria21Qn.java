package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name ="Criteria21Qn")
public class Criteria21Qn implements Serializable
{
	
	private static final long serialVersionUID = 4920532919687126600L;


	private CriteriaPrimaryKey criteriaId;
	
	
	@Id
    @Column(name="unique_key1")
	private long uniqueKey1;
	
	
	@Column(name = "responseValue211")
    private String response211;

	@Column(name = "responseValue212")
    private String response212;
	
	@Column(name = "criteria21status")
    private String criteria21status;

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

	public String getResponse211() {
		if(response211 !=null) {
		return response211;
	}else {
		return "";
	}
	}

	public void setResponse211(String response211) {
		this.response211 = response211;
	}

	public String getResponse212() {
		if(response212 !=null) {
		return response212;
	}else {
		return "";
	}
	}

	public void setResponse212(String response212) {
		this.response212 = response212;
	}

	public String getCriteria21status() {
		return criteria21status;
	}

	public void setCriteria21status(String criteria21status) {
		this.criteria21status = criteria21status;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(criteria21status, criteriaId, response211, response212, uniqueKey1);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Criteria21Qn other = (Criteria21Qn) obj;
		return Objects.equals(criteria21status, other.criteria21status) && Objects.equals(criteriaId, other.criteriaId)
				&& Objects.equals(response211, other.response211) && Objects.equals(response212, other.response212)
				&& uniqueKey1 == other.uniqueKey1;
	}

		
	
}
