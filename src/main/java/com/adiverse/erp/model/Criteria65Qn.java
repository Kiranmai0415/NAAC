package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name ="criteria65Qn")
public class Criteria65Qn implements Serializable {
	
	private static final long serialVersionUID = 384884159595539439L;


	private CriteriaPrimaryKey criteriaId;
	
	@Id
    @Column(name="unique_key1")
	private long uniqueKey1;
	
	@Column(name = "responseValue653")
    private String response653;
	
	@Column(name = "input653t1")
    private String input653t1;

	@Column(name = "responseValue651")
    private String response651;

	@Column(name = "criteria65status")
    private String criteria65status;



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



	public String getResponse653() {
		if(response653 !=null) {
		return response653;
	}else {
		return "";
	}
	}



	public void setResponse653(String response653) {
		this.response653 = response653;
	}



	public String getInput653t1() {
		if(input653t1 !=null) {
		return input653t1;
	}else {
		return "";
	}
	}



	public void setInput653t1(String input653t1) {
		this.input653t1 = input653t1;
	}



	public String getCriteria65status() {
		return criteria65status;
	}



	public void setCriteria65status(String criteria65status) {
		this.criteria65status = criteria65status;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	public String getResponse651() {
		return response651;
	}



	public void setResponse651(String response651) {
		this.response651 = response651;
	}



	@Override
	public int hashCode() {
		return Objects.hash(criteria65status, criteriaId, input653t1, response651, response653, uniqueKey1);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Criteria65Qn other = (Criteria65Qn) obj;
		return Objects.equals(criteria65status, other.criteria65status) && Objects.equals(criteriaId, other.criteriaId)
				&& Objects.equals(input653t1, other.input653t1) && Objects.equals(response651, other.response651)
				&& Objects.equals(response653, other.response653) && uniqueKey1 == other.uniqueKey1;
	}



	
	
	
}
