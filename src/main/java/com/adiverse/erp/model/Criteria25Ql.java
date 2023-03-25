package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="criteria25Ql")
public class Criteria25Ql implements Serializable
{


	private static final long serialVersionUID = 4920532919687126600L;

	
	private CriteriaPrimaryKey criteriaId;
	@Id
    @Column(name="unique_key1")
	private long uniqueKey1;
	

	@Column(name = "responseValue253")
    private String response253;
	
	
	@Column(name = "input253t1")
    private String input253t1;

	@Column(name = "responseValue254")
    private String response254;

	@Column(name = "input254t1")
    private String input254t1;
	


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

	public String getResponse253() {
		if(response253 !=null) {
		return response253;
	}else {
		return "";
	}
	}

	public void setResponse253(String response253) {
		this.response253 = response253;
	}

	public String getInput253t1() {
		if(input253t1 !=null) {
		return input253t1;
	}else {
		return "";
	}
	}

	public void setInput253t1(String input253t1) {
		this.input253t1 = input253t1;
	}

	public String getResponse254() {
		if(response254 !=null) {
		return response254;
	}else {
		return "";
	}
	}

	public void setResponse254(String response254) {
		this.response254 = response254;
	}

	public String getInput254t1() {
		if(input254t1 !=null) {
		return input254t1;
	}else {
		return "";
	}
	}

	public void setInput254t1(String input254t1) {
		this.input254t1 = input254t1;
	}

	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(criteriaId, input253t1, input254t1, response253, response254, uniqueKey1);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Criteria25Ql other = (Criteria25Ql) obj;
		return Objects.equals(criteriaId, other.criteriaId) && Objects.equals(input253t1, other.input253t1)
				&& Objects.equals(input254t1, other.input254t1) && Objects.equals(response253, other.response253)
				&& Objects.equals(response254, other.response254) && uniqueKey1 == other.uniqueKey1;
	}

	


		
}
