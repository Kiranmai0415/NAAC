package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name ="criteria61Ql")
public class Criteria61Ql implements Serializable {
	
	private static final long serialVersionUID = 384884159595539439L;


	private CriteriaPrimaryKey criteriaId;
	
	@Id
    @Column(name="unique_key1")
	private long uniqueKey1;
	
	
	@Column(name = "input611t1")
    private String input611t1;
	
	@Column(name = "responseValue611")
    private String response611;
	
	
	
	@Column(name = "input612t1")
    private String input612t1;
	
	@Column(name = "responseValue612")
    private String response612;
	
	@Column(name = "criteria61status")
    private String criteria61status;

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

	public String getInput611t1() {
		if(input611t1 !=null) {
		return input611t1;
	}else {
		return "";
	}
	}

	public void setInput611t1(String input611t1) {
		this.input611t1 = input611t1;
	}

	public String getResponse611() {
		if(response611 !=null) {
		return response611;
	}else {
		return "";
	}
	}

	public void setResponse611(String response611) {
		this.response611 = response611;
	}

	public String getInput612t1() {
		if(input612t1 !=null) {
		return input612t1;
	}else {
		return "";
	}
	}

	public void setInput612t1(String input612t1) {
		this.input612t1 = input612t1;
	}

	public String getResponse612() {
		if(response612 !=null) {
		return response612;
	}else {
		return "";
	}
	}

	public void setResponse612(String response612) {
		this.response612 = response612;
	}

	public String getCriteria61status() {
		return criteria61status;
	}

	public void setCriteria61status(String criteria61status) {
		this.criteria61status = criteria61status;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(criteria61status, criteriaId, input611t1, input612t1, response611, response612, uniqueKey1);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Criteria61Ql other = (Criteria61Ql) obj;
		return Objects.equals(criteria61status, other.criteria61status) && Objects.equals(criteriaId, other.criteriaId)
				&& Objects.equals(input611t1, other.input611t1) && Objects.equals(input612t1, other.input612t1)
				&& Objects.equals(response611, other.response611) && Objects.equals(response612, other.response612)
				&& uniqueKey1 == other.uniqueKey1;
	}

	
}
