package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="criteria27Ql")
public class Criteria27Ql implements Serializable {

	

	private static final long serialVersionUID = 4920532919687126600L;

	
	private CriteriaPrimaryKey criteriaId;
	
	@Id
    @Column(name="unique_key1")
	private long uniqueKey1;
	
	@Column(name = "responseValue271")
    private String response271;
	

	@Column(name = "criteria27status")
	private String criteria27status;


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


	public String getResponse271() {
		if(response271 !=null) {
		return response271;
	}else {
		return "";
	}
	}


	public void setResponse271(String response271) {
		this.response271 = response271;
	}


	public String getCriteria27status() {
		return criteria27status;
	}


	public void setCriteria27status(String criteria27status) {
		this.criteria27status = criteria27status;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	@Override
	public int hashCode() {
		return Objects.hash(criteria27status, criteriaId, response271, uniqueKey1);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Criteria27Ql other = (Criteria27Ql) obj;
		return Objects.equals(criteria27status, other.criteria27status) && Objects.equals(criteriaId, other.criteriaId)
				&& Objects.equals(response271, other.response271) && uniqueKey1 == other.uniqueKey1;
	}

	
}
