package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name ="criteria71Ql")
public class Criteria71Ql implements Serializable
{
	
private static final long serialVersionUID = 4708923488494526011L;

	
	private CriteriaPrimaryKey criteriaId;
	
	@Id
    @Column(name="unique_key1")
	private long uniqueKey1;
	
	
	@Column(name = "responseValue711")
    private String response711;
	
	
	@Column(name = "input711t1")
    private String input711t1;
	
	@Column(name = "responseValue718")
    private String response718;
	
	@Column(name = "input718t1")
    private String input718t1;
	
	@Column(name = "responseValue719")
    private String response719;

	@Column(name = "input719t1")
    private String input719t1;
	
	@Column(name = "responseValue7111")
    private String response7111;
	
	@Column(name = "input7111t1")
    private String input7111t1;
	

	@Column(name = "criteria71status")
    private String criteria71status;


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


	public String getResponse711() {
		return response711;
	}


	public void setResponse711(String response711) {
		this.response711 = response711;
	}


	public String getInput711t1() {
		return input711t1;
	}


	public void setInput711t1(String input711t1) {
		this.input711t1 = input711t1;
	}


	public String getResponse718() {
		return response718;
	}


	public void setResponse718(String response718) {
		this.response718 = response718;
	}


	public String getInput718t1() {
		return input718t1;
	}


	public void setInput718t1(String input718t1) {
		this.input718t1 = input718t1;
	}


	public String getResponse719() {
		return response719;
	}


	public void setResponse719(String response719) {
		this.response719 = response719;
	}


	public String getInput719t1() {
		return input719t1;
	}


	public void setInput719t1(String input719t1) {
		this.input719t1 = input719t1;
	}


	public String getResponse7111() {
		return response7111;
	}


	public void setResponse7111(String response7111) {
		this.response7111 = response7111;
	}


	public String getInput7111t1() {
		return input7111t1;
	}


	public void setInput7111t1(String input7111t1) {
		this.input7111t1 = input7111t1;
	}


	public String getCriteria71status() {
		return criteria71status;
	}


	public void setCriteria71status(String criteria71status) {
		this.criteria71status = criteria71status;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	@Override
	public int hashCode() {
		return Objects.hash(criteria71status, criteriaId, input7111t1, input711t1, input718t1, input719t1, response711,
				response7111, response718, response719, uniqueKey1);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Criteria71Ql other = (Criteria71Ql) obj;
		return Objects.equals(criteria71status, other.criteria71status) && Objects.equals(criteriaId, other.criteriaId)
				&& Objects.equals(input7111t1, other.input7111t1) && Objects.equals(input711t1, other.input711t1)
				&& Objects.equals(input718t1, other.input718t1) && Objects.equals(input719t1, other.input719t1)
				&& Objects.equals(response711, other.response711) && Objects.equals(response7111, other.response7111)
				&& Objects.equals(response718, other.response718) && Objects.equals(response719, other.response719)
				&& uniqueKey1 == other.uniqueKey1;
	}

	
}
