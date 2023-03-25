package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="criteria22Qn")
public class Criteria22Qn implements Serializable
{

	
	private static final long serialVersionUID = 4920532919687126600L;

	
	private CriteriaPrimaryKey criteriaId;
	
	@Id
    @Column(name="unique_key1")
	private long uniqueKey1;
	

	@Column(name = "responseValue221")
    private String response221;
	

	@Column(name = "input221t1")
    private String input221t1;
	
	@Column(name = "input221t2")
    private String input221t2;
	
	@Column(name = "responseValue222")
    private String response222;
	
	@Column(name = "input222t1")
    private String input222t1;
	
	@Column(name = "input2221t2")
    private String input2221t2;
	
	@Column(name = "criteria22status")
    private String criteria22status;

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

	public String getResponse221() {
		if(response221 !=null) {
		return response221;
	}else {
		return "";
	}
	}

	public void setResponse221(String response221) {
		this.response221 = response221;
	}

	public String getInput221t1() {
		if(input221t1 !=null) {
		return input221t1;
	}else {
		return "";
	}
	}

	public void setInput221t1(String input221t1) {
		this.input221t1 = input221t1;
	}

	public String getInput221t2() {
		if(input221t2 !=null) {
		return input221t2;
	}else {
		return "";
	}
	}

	public void setInput221t2(String input221t2) {
		this.input221t2 = input221t2;
	}

	public String getResponse222() {
		if(response222 !=null) {
		return response222;
	}else {
		return "";
	}
	}

	public void setResponse222(String response222) {
		this.response222 = response222;
	}

	public String getInput222t1() {
		if(input222t1 !=null) {
		return input222t1;
	}else {
		return "";
	}
	}

	public void setInput222t1(String input222t1) {
		this.input222t1 = input222t1;
	}

	public String getInput2221t2() {
		if(input2221t2 !=null) {
		return input2221t2;
	}else {
		return "";
	}
	}

	public void setInput2221t2(String input2221t2) {
		this.input2221t2 = input2221t2;
	}

	public String getCriteria22status() {
		return criteria22status;
	}

	public void setCriteria22status(String criteria22status) {
		this.criteria22status = criteria22status;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(criteria22status, criteriaId, input221t1, input221t2, input2221t2, input222t1, response221,
				response222, uniqueKey1);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Criteria22Qn other = (Criteria22Qn) obj;
		return Objects.equals(criteria22status, other.criteria22status) && Objects.equals(criteriaId, other.criteriaId)
				&& Objects.equals(input221t1, other.input221t1) && Objects.equals(input221t2, other.input221t2)
				&& Objects.equals(input2221t2, other.input2221t2) && Objects.equals(input222t1, other.input222t1)
				&& Objects.equals(response221, other.response221) && Objects.equals(response222, other.response222)
				&& uniqueKey1 == other.uniqueKey1;
	}

	
	
}
