package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name ="criteria11Ql")
public class Criteria11Ql implements Serializable {
	
	
	private static final long serialVersionUID = 1L;

	
	private CriteriaPrimaryKey criteriaId;
	
	 	@Id
	    @Column(name="unique_key1")
		private long uniqueKey1;
		
	@Column(name = "input111t1")
    private String input111t1;
	
	@Column(name = "responseValue111")
    private String response111;

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

	public String getInput111t1() {
		if(input111t1 !=null) {
		return input111t1;
	}else {
		return "";
	}
	}

	public void setInput111t1(String input111t1) {
		this.input111t1 = input111t1;
	}

	public String getResponse111() {
		if(response111 !=null) {
		return response111;
	}else {
		return "";
	}
	}

	public void setResponse111(String response111) {
		this.response111 = response111;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(criteriaId, input111t1, response111, uniqueKey1);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Criteria11Ql other = (Criteria11Ql) obj;
		return Objects.equals(criteriaId, other.criteriaId) && Objects.equals(input111t1, other.input111t1)
				&& Objects.equals(response111, other.response111) && uniqueKey1 == other.uniqueKey1;
	}
	

	
}
