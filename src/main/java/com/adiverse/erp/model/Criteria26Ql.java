package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="criteria26Ql")
public class Criteria26Ql implements Serializable {

	

	private static final long serialVersionUID = 4920532919687126600L;

	
	private CriteriaPrimaryKey criteriaId;
	
	@Id
    @Column(name="unique_key1")
	private long uniqueKey1;
	@Column(name = "responseValue261")
    private String response261;
	
	@Column(name = "input261t1")
    private String input261t1;
	
	
	@Column(name = "responseValue262")
    private String response262;

	@Column(name = "input262t1")
    private String input262t1;

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

	public String getResponse261() {
		if(response261 !=null) {
		return response261;
	}else {
		return "";
	}
	}

	public void setResponse261(String response261) {
		this.response261 = response261;
	}

	public String getInput261t1() {
		if(input261t1 !=null) {
		return input261t1;
	}else {
		return "";
	}
	}

	public void setInput261t1(String input261t1) {
		this.input261t1 = input261t1;
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

	public String getInput262t1() {
		if(input262t1 !=null) {
		return input262t1;
	}else {
		return "";
	}
	}

	public void setInput262t1(String input262t1) {
		this.input262t1 = input262t1;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(criteriaId, input261t1, input262t1, response261, response262, uniqueKey1);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Criteria26Ql other = (Criteria26Ql) obj;
		return Objects.equals(criteriaId, other.criteriaId) && Objects.equals(input261t1, other.input261t1)
				&& Objects.equals(input262t1, other.input262t1) && Objects.equals(response261, other.response261)
				&& Objects.equals(response262, other.response262) && uniqueKey1 == other.uniqueKey1;
	}
		
	
}
