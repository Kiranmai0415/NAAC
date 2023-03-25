package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name ="criteria53Qn")
public class Criteria53Qn implements Serializable
{
	
private static final long serialVersionUID = 1L;

	
	private CriteriaPrimaryKey criteriaId;
	
	@Id
    @Column(name="unique_key1")
	private long uniqueKey1;
	
	@Column(name = "responseValue531")
    private String response531;
	
	@Column(name = "input531t1")
    private String input531t1;
	
	@Column(name = "responseValue532")
    private String response532;
	
	@Column(name = "input532t1")
    private String input532t1;


	@Column(name = "responseValue533")
    private String response533;
	
	@Column(name = "input533t1")
    private String input533t1;
	
	@Column(name = "criteria53status")
    private String criteria53status;

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

	public String getResponse531() {
		if(response531 !=null) {
		return response531;
	}else {
		return "";
	}
	}

	public void setResponse531(String response531) {
		this.response531 = response531;
	}

	public String getInput531t1() {
		if(input531t1 !=null) {
		return input531t1;
	}else {
		return "";
	}
	}

	public void setInput531t1(String input531t1) {
		this.input531t1 = input531t1;
	}

	public String getResponse532() {
		if(response532 !=null) {
		return response532;
	}else {
		return "";
	}
	}

	public void setResponse532(String response532) {
		this.response532 = response532;
	}

	public String getInput532t1() {
		if(input532t1 !=null) {
		return input532t1;
	}else {
		return "";
	}
	}

	public void setInput532t1(String input532t1) {
		this.input532t1 = input532t1;
	}

	public String getResponse533() {
		if(response533 !=null) {
		return response533;
	}else {
		return "";
	}
	}

	public void setResponse533(String response533) {
		this.response533 = response533;
	}

	public String getInput533t1() {
		if(input533t1 !=null) {
		return input533t1;
	}else {
		return "";
	}
	}

	public void setInput533t1(String input533t1) {
		this.input533t1 = input533t1;
	}

	public String getCriteria53status() {
		return criteria53status;
	}

	public void setCriteria53status(String criteria53status) {
		this.criteria53status = criteria53status;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(criteria53status, criteriaId, input531t1, input532t1, input533t1, response531, response532,
				response533, uniqueKey1);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Criteria53Qn other = (Criteria53Qn) obj;
		return Objects.equals(criteria53status, other.criteria53status) && Objects.equals(criteriaId, other.criteriaId)
				&& Objects.equals(input531t1, other.input531t1) && Objects.equals(input532t1, other.input532t1)
				&& Objects.equals(input533t1, other.input533t1) && Objects.equals(response531, other.response531)
				&& Objects.equals(response532, other.response532) && Objects.equals(response533, other.response533)
				&& uniqueKey1 == other.uniqueKey1;
	}
	

	
}
