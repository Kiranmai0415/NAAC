package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name ="criteria42Qn")
public class Criteria42Qn implements Serializable
{
	
	
private static final long serialVersionUID = 1L;

	
	private CriteriaPrimaryKey criteriaId;
	
	@Id
    @Column(name="unique_key1")
	private long uniqueKey1;
	
	
	
	@Column(name = "responseValue422")
    private String response422;
	
	@Column(name = "input422t1")
    private String input422t1;
	
	@Column(name = "responseValue423")
    private String response423;
	
	@Column(name = "responseValue424")
    private String response424;
	
	@Column(name = "input4241t1")
    private String input4241t1;
	
	@Column(name = "input4241t2")
    private String input4241t2;


	@Column(name = "criteria42status")
    private String criteria42status;


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


	public String getResponse422() {
		if(response422 !=null) {
		return response422;
	}else {
		return "";
	}
	}


	public void setResponse422(String response422) {
		this.response422 = response422;
	}


	public String getInput422t1() {
		if(input422t1 !=null) {
		return input422t1;
	}else {
		return "";
	}
	}


	public void setInput422t1(String input422t1) {
		this.input422t1 = input422t1;
	}


	public String getResponse423() {
		if(response423 !=null) {
		return response423;
	}else {
		return "";
	}
	}


	public void setResponse423(String response423) {
		this.response423 = response423;
	}


	public String getResponse424() {
		if(response424 !=null) {
		return response424;
	}else {
		return "";
	}
	}


	public void setResponse424(String response424) {
		this.response424 = response424;
	}


	public String getInput4241t1() {
		if(input4241t1 !=null){
		return input4241t1;
	}else {
		return "";
	}
	}


	public void setInput4241t1(String input4241t1) {
		this.input4241t1 = input4241t1;
	}


	public String getInput4241t2() {
		if(input4241t2 !=null) {
		return input4241t2;
	}else {
		return "";
	}
	}


	public void setInput4241t2(String input4241t2) {
		this.input4241t2 = input4241t2;
	}


	public String getCriteria42status() {
		return criteria42status;
	}


	public void setCriteria42status(String criteria42status) {
		this.criteria42status = criteria42status;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	@Override
	public int hashCode() {
		return Objects.hash(criteria42status, criteriaId, input422t1, input4241t1, input4241t2, response422,
				response423, response424, uniqueKey1);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Criteria42Qn other = (Criteria42Qn) obj;
		return Objects.equals(criteria42status, other.criteria42status) && Objects.equals(criteriaId, other.criteriaId)
				&& Objects.equals(input422t1, other.input422t1) && Objects.equals(input4241t1, other.input4241t1)
				&& Objects.equals(input4241t2, other.input4241t2) && Objects.equals(response422, other.response422)
				&& Objects.equals(response423, other.response423) && Objects.equals(response424, other.response424)
				&& uniqueKey1 == other.uniqueKey1;
	}

	
	
}
