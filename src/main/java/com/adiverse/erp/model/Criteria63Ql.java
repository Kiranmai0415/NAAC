package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name ="criteria63Ql")
public class Criteria63Ql implements Serializable {
	
	private static final long serialVersionUID = 384884159595539439L;


	private CriteriaPrimaryKey criteriaId;
	
	@Id
    @Column(name="unique_key1")
	private long uniqueKey1;
	
	
	@Column(name = "input631t1")
    private String input631t1;
	
	@Column(name = "responseValue631")
    private String response631;
	  
	
	@Column(name = "responseValue633")
    private String response633;
	
	@Column(name = "input633t1")
    private String input633t1;
	

	@Column(name = "criteria63status")
    private String criteria63status;


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


	public String getInput631t1() {
		if(input631t1 !=null) {
		return input631t1;
	}else {
		return "";
	}
	}


	public void setInput631t1(String input631t1) {
		this.input631t1 = input631t1;
	}


	public String getResponse631() {
		if(response631 !=null) {
		return response631;
	}else {
		return "";
	}
	}


	public void setResponse631(String response631) {
		this.response631 = response631;
	}


	public String getResponse633() {
		if(response633 !=null) {
		return response633;
	}else {
		return "";
	}
	}


	public void setResponse633(String response633) {
		this.response633 = response633;
	}


	public String getInput633t1() {
		if(input633t1 !=null) {
		return input633t1;
	}else {
		return "";
		}
	}


	public void setInput633t1(String input633t1) {
		this.input633t1 = input633t1;
	}


	public String getCriteria63status() {
		return criteria63status;
	}


	public void setCriteria63status(String criteria63status) {
		this.criteria63status = criteria63status;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	@Override
	public int hashCode() {
		return Objects.hash(criteria63status, criteriaId, input631t1, input633t1, response631, response633, uniqueKey1);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Criteria63Ql other = (Criteria63Ql) obj;
		return Objects.equals(criteria63status, other.criteria63status) && Objects.equals(criteriaId, other.criteriaId)
				&& Objects.equals(input631t1, other.input631t1) && Objects.equals(input633t1, other.input633t1)
				&& Objects.equals(response631, other.response631) && Objects.equals(response633, other.response633)
				&& uniqueKey1 == other.uniqueKey1;
	}

	
	
}
