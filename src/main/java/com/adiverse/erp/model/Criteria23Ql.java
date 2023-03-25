package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name ="criteria23Ql")
public class Criteria23Ql implements Serializable 
{
	

	private static final long serialVersionUID = 4920532919687126600L;

	
	private CriteriaPrimaryKey criteriaId;
	@Id
    @Column(name="unique_key1")
	private long uniqueKey1;
	

	@Column(name = "responseValue231")
    private String response231;
	
	@Column(name = "input231t1")
    private String input231t1;
	
	@Column(name = "responseValue232")
    private String response232;
	
	@Column(name = "input232t1")
    private String input232t1;
	
	@Column(name = "responseValue234")
    private String response234;

	@Column(name = "criteria23status")
    private String criteria23status;

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

	public String getResponse231() {
		if(response231 !=null) {
		return response231;
	}else {
		return "";
	}
	}

	public void setResponse231(String response231) {
		this.response231 = response231;
	}

	public String getInput231t1() {
		if(input231t1 !=null) {
		return input231t1;
	}else {
		return "";
	}
	}

	public void setInput231t1(String input231t1) {
		this.input231t1 = input231t1;
	}

	public String getResponse232() {
		if(response232 !=null) {
		return response232;
	}else {
		return "";
	}
	}

	public void setResponse232(String response232) {
		this.response232 = response232;
	}

	public String getInput232t1() {
		if(input232t1 !=null) {
		return input232t1;
	}else {
		return "";
	}
	}

	public void setInput232t1(String input232t1) {
		this.input232t1 = input232t1;
	}

	public String getResponse234() {
		if(response234 !=null) {
		return response234;
	}else {
		return "";
	}
	}

	public void setResponse234(String response234) {
		this.response234 = response234;
	}

	public String getCriteria23status() {
		return criteria23status;
	}

	public void setCriteria23status(String criteria23status) {
		this.criteria23status = criteria23status;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(criteria23status, criteriaId, input231t1, input232t1, response231, response232, response234,
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
		Criteria23Ql other = (Criteria23Ql) obj;
		return Objects.equals(criteria23status, other.criteria23status) && Objects.equals(criteriaId, other.criteriaId)
				&& Objects.equals(input231t1, other.input231t1) && Objects.equals(input232t1, other.input232t1)
				&& Objects.equals(response231, other.response231) && Objects.equals(response232, other.response232)
				&& Objects.equals(response234, other.response234) && uniqueKey1 == other.uniqueKey1;
	}

	
}
