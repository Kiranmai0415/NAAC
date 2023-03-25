package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="criteria42Ql")
public class Criteria42Ql implements Serializable{
	
	private static final long serialVersionUID = 1L;

	
	private CriteriaPrimaryKey criteriaId;
	
	@Id
    @Column(name="unique_key1")
	private long uniqueKey1;
	
	
	@Column(name = "responseValue421")
    private String response421;
	
	@Column(name = "input421t1")
    private String input421t1;

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

	public String getResponse421() {
		if(response421 !=null) {
		return response421;
	}else {
		return "";
	}
	}

	public void setResponse421(String response421) {
		this.response421 = response421;
	}

	public String getInput421t1() {
		if(input421t1 !=null) {
		return input421t1;
	}else {
		return "";
	}
	}

	public void setInput421t1(String input421t1) {
		this.input421t1 = input421t1;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(criteriaId, input421t1, response421, uniqueKey1);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Criteria42Ql other = (Criteria42Ql) obj;
		return Objects.equals(criteriaId, other.criteriaId) && Objects.equals(input421t1, other.input421t1)
				&& Objects.equals(response421, other.response421) && uniqueKey1 == other.uniqueKey1;
	}
	
	

}
