package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name ="criteria51Qn")
public class Criteria51Qn implements Serializable
{
	
	private static final long serialVersionUID = 1L;

	
	private CriteriaPrimaryKey criteriaId;
	
	@Id
    @Column(name="unique_key1")
	private long uniqueKey1;
	
	@Column(name = "responseValue511")
    private String response511;
	
	@Column(name = "input511t1")
    private String input511t1;
	
	
	@Column(name = "responseValue512")
    private String response512;
	
	@Column(name = "input512t1")
    private String input512t1;
	
	
	
	@Column(name = "responseValue513")
    private String response513;
	
	@Column(name = "input513t1")
    private String input513t1;
	
	@Column(name = "input514t1")
    private String input514t1;
	
	@Column(name = "responseValue514")
    private String response514;
	
	@Column(name = "responseValue515")
    private String response515;
	

	@Column(name = "input515t1")
    private String input515t1;

	@Column(name = "criteria51status")
    private String criteria51status;

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

	public String getResponse511() {
		if(response511 !=null) {
		return response511;
	}else {
		return "";
	}
	}

	public void setResponse511(String response511) {
		this.response511 = response511;
	}

	public String getInput511t1() {
		if(input511t1 !=null) {
		return input511t1;
	}else {
		return "";
	}
	}

	public void setInput511t1(String input511t1) {
		this.input511t1 = input511t1;
	}

	public String getResponse512() {
		if(response512 !=null) {
		return response512;
	}else {
		return "";
	}
	}

	public void setResponse512(String response512) {
		this.response512 = response512;
	}

	public String getInput512t1() {
		if(input512t1 !=null) {
		return input512t1;
	}else {
		return "";
	}
	}

	public void setInput512t1(String input512t1) {
		this.input512t1 = input512t1;
	}

	public String getResponse513() {
		if(response513 !=null) {
		return response513;
	}else {
		return "";
	}
	}

	public void setResponse513(String response513) {
		this.response513 = response513;
	}

	public String getInput513t1() {
		if(input513t1 !=null) {
		return input513t1;
	}else {
		return "";
	}
	}

	public void setInput513t1(String input513t1) {
		this.input513t1 = input513t1;
	}

	public String getInput514t1() {
		if(input514t1 !=null) {
		return input514t1;
	}else {
		return "";
	}
	}

	public void setInput514t1(String input514t1) {
		this.input514t1 = input514t1;
	}

	public String getResponse514() {
		if(response514 !=null) {
		return response514;
	}else {
		return "";
	}
	}

	public void setResponse514(String response514) {
		this.response514 = response514;
	}

	public String getResponse515() {
		if(response515 !=null) {
		return response515;
	}else {
		return "";
	}
	}

	public void setResponse515(String response515) {
		this.response515 = response515;
	}

	public String getInput515t1() {
		if(input515t1 !=null) {
		return input515t1;
	}else {
		return "";
	}
	}

	public void setInput515t1(String input515t1) {
		this.input515t1 = input515t1;
	}

	public String getCriteria51status() {
		return criteria51status;
	}

	public void setCriteria51status(String criteria51status) {
		this.criteria51status = criteria51status;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(criteria51status, criteriaId, input511t1, input512t1, input513t1, input514t1, input515t1,
				response511, response512, response513, response514, response515, uniqueKey1);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Criteria51Qn other = (Criteria51Qn) obj;
		return Objects.equals(criteria51status, other.criteria51status) && Objects.equals(criteriaId, other.criteriaId)
				&& Objects.equals(input511t1, other.input511t1) && Objects.equals(input512t1, other.input512t1)
				&& Objects.equals(input513t1, other.input513t1) && Objects.equals(input514t1, other.input514t1)
				&& Objects.equals(input515t1, other.input515t1) && Objects.equals(response511, other.response511)
				&& Objects.equals(response512, other.response512) && Objects.equals(response513, other.response513)
				&& Objects.equals(response514, other.response514) && Objects.equals(response515, other.response515)
				&& uniqueKey1 == other.uniqueKey1;
	}
	


}
