package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="criteria26Qn")
public class Criteria26Qn  implements Serializable{
	
private static final long serialVersionUID = 4920532919687126600L;

	
	private CriteriaPrimaryKey criteriaId;
	
	@Id
    @Column(name="unique_key1")
	private long uniqueKey1;
	
	@Column(name = "responseValue263")
    private String response263;
	
	@Column(name = "input2631t1")
    private String input2631t1;
	
	@Column(name = "input2632t1")
    private String input2632t1;
	
	@Column(name = "responseValue262")
    private String response262;

	@Column(name = "input2621t1")
    private String input2621t1;
	
	
	
	@Column(name = "input2622t2")
    private String input2622t2;
	
	@Column(name = "criteria26status")
    private String criteria26status;

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

	public String getResponse263() {
		if(response263 !=null) {
		return response263;
	}else {
		return "";
	}
	}

	public void setResponse263(String response263) {
		this.response263 = response263;
	}

	public String getInput2631t1() {
		if(input2631t1 !=null) {
		return input2631t1;
	}else {
		return "";
	}
	}

	public void setInput2631t1(String input2631t1) {
		this.input2631t1 = input2631t1;
	}

	public String getInput2632t1() {
		if(input2632t1 !=null) {
		return input2632t1;
	}else {
		return "";
	}
	}

	public void setInput2632t1(String input2632t1) {
		this.input2632t1 = input2632t1;
	}

	public String getResponse262() {
		if(response262 !=null) {
		return response262;
	}else {
		return "";
	}
	}

	public void setResponse262(String response262) {
		this.response262 = response262;
	}

	public String getInput2621t1() {
		if(input2621t1 !=null) {
		return input2621t1;
	}else {
		return "";
	}
	}

	public void setInput2621t1(String input2621t1) {
		this.input2621t1 = input2621t1;
	}

	public String getInput2622t2() {
		if(input2622t2 !=null ) {
		return input2622t2;
	}else {
		return "";
	}
	}

	public void setInput2622t2(String input2622t2) {
		this.input2622t2 = input2622t2;
	}

	public String getCriteria26status() {
		return criteria26status;
	}

	public void setCriteria26status(String criteria26status) {
		this.criteria26status = criteria26status;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(criteria26status, criteriaId, input2621t1, input2622t2, input2631t1, input2632t1,
				response262, response263, uniqueKey1);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Criteria26Qn other = (Criteria26Qn) obj;
		return Objects.equals(criteria26status, other.criteria26status) && Objects.equals(criteriaId, other.criteriaId)
				&& Objects.equals(input2621t1, other.input2621t1) && Objects.equals(input2622t2, other.input2622t2)
				&& Objects.equals(input2631t1, other.input2631t1) && Objects.equals(input2632t1, other.input2632t1)
				&& Objects.equals(response262, other.response262) && Objects.equals(response263, other.response263)
				&& uniqueKey1 == other.uniqueKey1;
	}



	

}
