package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name ="criteria63Qn")
public class Criteria63Qn implements Serializable {
	
	private static final long serialVersionUID = 384884159595539439L;


	private CriteriaPrimaryKey criteriaId;
	
	@Id
    @Column(name="unique_key1")
	private long uniqueKey1;
	
	@Column(name = "responseValue632")
    private String response632;
	
	@Column(name = "input632t1")
    private String input632t1;
	

	@Column(name = "responseValue634")
    private String response634;


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


	public String getResponse632() {
		if(response632 !=null) {
		return response632;
	}else {
		return "";
	}
	}


	public void setResponse632(String response632) {
		this.response632 = response632;
	}


	public String getInput632t1() {
		if(input632t1 !=null) {
		return input632t1;
	}else {
		return "";
	}
	}


	public void setInput632t1(String input632t1) {
		this.input632t1 = input632t1;
	}


	public String getResponse634() {
		if(response634 !=null) {
		return response634;
	}else {
		return "";
	}
	}


	public void setResponse634(String response634) {
		this.response634 = response634;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	@Override
	public int hashCode() {
		return Objects.hash(criteriaId, input632t1, response632, response634, uniqueKey1);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Criteria63Qn other = (Criteria63Qn) obj;
		return Objects.equals(criteriaId, other.criteriaId) && Objects.equals(input632t1, other.input632t1)
				&& Objects.equals(response632, other.response632) && Objects.equals(response634, other.response634)
				&& uniqueKey1 == other.uniqueKey1;
	}
	
	
}
