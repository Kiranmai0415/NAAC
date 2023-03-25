package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="criteria41Qn")
public class Criteia41Qn implements Serializable
{
	
private static final long serialVersionUID = 1L;

	
	private CriteriaPrimaryKey criteriaId;
	
	@Id
    @Column(name="unique_key1")
	private long uniqueKey1;
	
	
	@Column(name = "responseValue414")
    private String response414;


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


	public String getResponse414() {
		if(response414 !=null) {
		return response414;
	}else {
		return "";
	}
	}


	public void setResponse414(String response414) {
		this.response414 = response414;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	@Override
	public int hashCode() {
		return Objects.hash(criteriaId, response414, uniqueKey1);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Criteia41Qn other = (Criteia41Qn) obj;
		return Objects.equals(criteriaId, other.criteriaId) && Objects.equals(response414, other.response414)
				&& uniqueKey1 == other.uniqueKey1;
	}
	
	

}
