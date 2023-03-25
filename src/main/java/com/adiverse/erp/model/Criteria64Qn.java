package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name ="criteria64Qn")
public class Criteria64Qn implements Serializable {
	
	private static final long serialVersionUID = 384884159595539439L;


	private CriteriaPrimaryKey criteriaId;
	
	@Id
    @Column(name="unique_key1")
	private long uniqueKey1;
	
	@Column(name = "responseValue642")
    private String response642;
	
	@Column(name = "input642t1")
    private String input642t1;
	
	
	@Column(name = "criteria64status")
    private String criteria64status;
	
	
	

	public String getCriteria64status() {
		return criteria64status;
	}

	public void setCriteria64status(String criteria64status) {
		this.criteria64status = criteria64status;
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

	public String getResponse642() {
		if(response642 !=null) {
		return response642;
	}else {
		return "";
	}
	}

	public void setResponse642(String response642) {
		this.response642 = response642;
	}

	public String getInput642t1() {
		if(input642t1 !=null) {
		return input642t1;
	}else {
		return "";
	}
	}

	public void setInput642t1(String input642t1) {
		this.input642t1 = input642t1;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(criteria64status, criteriaId, input642t1, response642, uniqueKey1);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Criteria64Qn other = (Criteria64Qn) obj;
		return Objects.equals(criteria64status, other.criteria64status) && Objects.equals(criteriaId, other.criteriaId)
				&& Objects.equals(input642t1, other.input642t1) && Objects.equals(response642, other.response642)
				&& uniqueKey1 == other.uniqueKey1;
	}

}
