package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="criteria41Qn")
public class Criteria41Qn implements Serializable {

	private static final long serialVersionUID = 1L;
	
	
	private CriteriaPrimaryKey criteriaId;
	
	@Id
    @Column(name="unique_key1")
	private long uniqueKey1;
	
	@Column(name = "responseValue413")
    private String response413;
	
	
	@Column(name = "input4131t1")
    private String input4131t1;
	
	@Column(name = "input4131t2")
    private String input4131t2;

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

	public String getResponse413() {
		if(response413 !=null) {
		return response413;
	}else {
		return "";
	}
	}

	public void setResponse413(String response413) {
		this.response413 = response413;
	}

	public String getInput4131t1() {
		if(input4131t1 !=null) {
		return input4131t1;
	}else {
		return "";
	}
	}

	public void setInput4131t1(String input4131t1) {
		this.input4131t1 = input4131t1;
	}

	public String getInput4131t2() {
		if(input4131t2 !=null) {
		return input4131t2;
	}else {
		return "";
	}
	}

	public void setInput4131t2(String input4131t2) {
		this.input4131t2 = input4131t2;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(criteriaId, input4131t1, input4131t2, response413, uniqueKey1);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Criteria41Qn other = (Criteria41Qn) obj;
		return Objects.equals(criteriaId, other.criteriaId) && Objects.equals(input4131t1, other.input4131t1)
				&& Objects.equals(input4131t2, other.input4131t2) && Objects.equals(response413, other.response413)
				&& uniqueKey1 == other.uniqueKey1;
	}
	

	
}
