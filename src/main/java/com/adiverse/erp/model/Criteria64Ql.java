package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name ="criteria64Ql")
public class Criteria64Ql implements Serializable {
	
	private static final long serialVersionUID = 384884159595539439L;


	private CriteriaPrimaryKey criteriaId;
	
	@Id
    @Column(name="unique_key1")
	private long uniqueKey1;
	
	@Column(name = "responseValue641")
    private String response641;
	
	@Column(name = "input641t1")
    private String input641t1;
	
	
	@Column(name = "input643t1")
    private String input643t1;
	
	@Column(name = "responseValue643")
    private String response643;
	
	
	@Column(name = "responseValue644")
    private String response644;
	
	@Column(name = "input644t1")
    private String input644t1;
	

	


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


	public String getResponse641() {
		if(response641 !=null) {
		return response641;
	}else{
		return "";
	}
	}


	public void setResponse641(String response641) {
		this.response641 = response641;
	}


	public String getInput641t1() {
		if(input641t1 !=null) {
		return input641t1;
	}else {
		return "";
	}
	}


	public void setInput641t1(String input641t1) {
		this.input641t1 = input641t1;
	}


	public String getInput643t1() {
		if(input643t1 !=null) {
		return input643t1;
	}else {
		return "";
	}
	}


	public void setInput643t1(String input643t1) {
		this.input643t1 = input643t1;
	}


	public String getResponse643() {
		if(response643 !=null) {
		return response643;
	}else {
		return "";
	}
	}


	public void setResponse643(String response643) {
		this.response643 = response643;
	}


	public String getResponse644() {
		if(response644 !=null) {
		return response644;
	}else {
		return "";
	}
	}


	public void setResponse644(String response644) {
		this.response644 = response644;
	}


	public String getInput644t1() {
		if(input644t1 !=null) {
		return input644t1;
	}else {
		return "";
	}
	}


	public void setInput644t1(String input644t1) {
		this.input644t1 = input644t1;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	@Override
	public int hashCode() {
		return Objects.hash(criteriaId, input641t1, input643t1, input644t1, response641, response643, response644,
				uniqueKey1);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Criteria64Ql other = (Criteria64Ql) obj;
		return Objects.equals(criteriaId, other.criteriaId) && Objects.equals(input641t1, other.input641t1)
				&& Objects.equals(input643t1, other.input643t1) && Objects.equals(input644t1, other.input644t1)
				&& Objects.equals(response641, other.response641) && Objects.equals(response643, other.response643)
				&& Objects.equals(response644, other.response644) && uniqueKey1 == other.uniqueKey1;
	}


	
	
}
