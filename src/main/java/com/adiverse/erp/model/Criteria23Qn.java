package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="criteria23Qn")
public class Criteria23Qn implements Serializable{
	
private static final long serialVersionUID = 4920532919687126600L;

	
	private CriteriaPrimaryKey criteriaId;
	
	@Id
    @Column(name="unique_key1")
	private long uniqueKey1;
	
	@Column(name = "responseValue233")
    private String response233;


	@Column(name = "input2331t1")
    private String input2331t1;
	
	@Column(name = "input2331t2")
    private String input2331t2;

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

	public String getResponse233() {
		if(response233 !=null) {
		return response233;
	}else {
		return "";
	}
	}

	public void setResponse233(String response233) {
		this.response233 = response233;
	}

	public String getInput2331t1() {
		if(input2331t1 !=null) {
		return input2331t1;
	}else {
		return "";
	}
	}

	public void setInput2331t1(String input2331t1) {
		this.input2331t1 = input2331t1;
	}

	public String getInput2331t2() {
		if(input2331t2 !=null) {
		return input2331t2;
	}else {
		return "";
	}
	}

	public void setInput2331t2(String input2331t2) {
		this.input2331t2 = input2331t2;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(criteriaId, input2331t1, input2331t2, response233, uniqueKey1);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Criteria23Qn other = (Criteria23Qn) obj;
		return Objects.equals(criteriaId, other.criteriaId) && Objects.equals(input2331t1, other.input2331t1)
				&& Objects.equals(input2331t2, other.input2331t2) && Objects.equals(response233, other.response233)
				&& uniqueKey1 == other.uniqueKey1;
	}
	
		
}
