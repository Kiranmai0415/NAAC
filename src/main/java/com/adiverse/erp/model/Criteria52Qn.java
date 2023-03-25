package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name ="criteria52Qn")
public class Criteria52Qn implements Serializable
{
	
	private static final long serialVersionUID = 1L;

	
	private CriteriaPrimaryKey criteriaId;
	
	@Id
    @Column(name="unique_key1")
	private long uniqueKey1;
	@Column(name = "responseValue521")
    private String response521;
	
	@Column(name = "responseValue522")
    private String response522;
	
	
	@Column(name = "input522t1")
    private String input522t1;
	
	
	@Column(name = "input522t2")
    private String input522t2;
	
	@Column(name = "responseValue523")
    private String response523;
	

	@Column(name = "criteria52status")
    private String criteria52status;


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


	public String getResponse521() {
		if(response521 !=null) {
		return response521;
	}else {
		return "";
	}
	}


	public void setResponse521(String response521) {
		this.response521 = response521;
	}


	public String getResponse522() {
		if(response522 !=null) {
		return response522;
	}else {
		return "";
	}
	}


	public void setResponse522(String response522) {
		this.response522 = response522;
	}


	public String getInput522t1() {
		if(input522t1 !=null) {
		return input522t1;
	}else {
		return "";
	}
	}


	public void setInput522t1(String input522t1) {
		this.input522t1 = input522t1;
	}


	public String getInput522t2() {
		if(input522t2 !=null) {
		return input522t2;
	}else {
		return "";
	}
	}


	public void setInput522t2(String input522t2) {
		this.input522t2 = input522t2;
	}


	public String getResponse523() {
		if(response523 !=null) {
		return response523;
	}else {
		return "";
	}
	}


	public void setResponse523(String response523) {
		this.response523 = response523;
	}


	public String getCriteria52status() {
		return criteria52status;
	}


	public void setCriteria52status(String criteria52status) {
		this.criteria52status = criteria52status;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	@Override
	public int hashCode() {
		return Objects.hash(criteria52status, criteriaId, input522t1, input522t2, response521, response522, response523,
				uniqueKey1);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Criteria52Qn other = (Criteria52Qn) obj;
		return Objects.equals(criteria52status, other.criteria52status) && Objects.equals(criteriaId, other.criteriaId)
				&& Objects.equals(input522t1, other.input522t1) && Objects.equals(input522t2, other.input522t2)
				&& Objects.equals(response521, other.response521) && Objects.equals(response522, other.response522)
				&& Objects.equals(response523, other.response523) && uniqueKey1 == other.uniqueKey1;
	}
	

	
}
