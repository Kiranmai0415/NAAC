package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="criteria41Ql")
public class Criteria41Ql implements Serializable {

	private static final long serialVersionUID = 1L;
	
	
	private CriteriaPrimaryKey criteriaId;
	
	@Id
    @Column(name="unique_key1")
	private long uniqueKey1;
	
	
	@Column(name = "responseValue411")
	
    private String response411;
	
	
	
	@Column(name = "input411t1")
	
    private String input411t1;
	
	@Column(name = "responseValue412")
    private String response412;
	
	
	
	@Column(name = "responseValue413")
    private String response413;
	
	@Column(name = "input413t1")
    private String input413t1;
	
	@Column(name = "input4131t1")
    private String input4131t1;
	
	
	@Column(name = "input412t1")
    private String input412t1;
	
	@Column(name = "responseValue431")
    private String response431;
	
	@Column(name = "input431t1")
    private String input431t1;

	@Column(name = "responseValue414")
    private String response414;
	

	@Column(name = "criteria41status")
    private String criteria41status;


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


	public String getResponse411() {
		if(response411 !=null) {
		return response411;
	}else {
		return "";
	}
	}


	public void setResponse411(String response411) {
		this.response411 = response411;
	}


	public String getInput411t1() {
		if(input411t1 !=null) {
		return input411t1;
	}else {
		return "";
	}
	}


	public void setInput411t1(String input411t1) {
		this.input411t1 = input411t1;
	}


	public String getResponse412() {
		if(response412 !=null) {
		return response412;
	}else {
		return "";
	}
	}


	public void setResponse412(String response412) {
		this.response412 = response412;
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


	public String getInput413t1() {
		if(input413t1 !=null) {
		return input413t1;
	}else {
		return "";
	}
	}


	public void setInput413t1(String input413t1) {
		this.input413t1 = input413t1;
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


	public String getInput412t1() {
		if(input412t1 !=null) {
		return input412t1;
	}else {
		return "";
	}
	}


	public void setInput412t1(String input412t1) {
		this.input412t1 = input412t1;
	}


	public String getResponse431() {
		if(response431 !=null) {
		return response431;
	}else {
		return "";
	}
	}


	public void setResponse431(String response431) {
		this.response431 = response431;
	}


	public String getInput431t1() {
		if(input431t1 !=null) {
		return input431t1;
	}else {
		return "";
	}
	}


	public void setInput431t1(String input431t1) {
		this.input431t1 = input431t1;
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


	public String getCriteria41status() {
		return criteria41status;
	}


	public void setCriteria41status(String criteria41status) {
		this.criteria41status = criteria41status;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	@Override
	public int hashCode() {
		return Objects.hash(criteria41status, criteriaId, input411t1, input412t1, input4131t1, input413t1, input431t1,
				response411, response412, response413, response414, response431, uniqueKey1);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Criteria41Ql other = (Criteria41Ql) obj;
		return Objects.equals(criteria41status, other.criteria41status) && Objects.equals(criteriaId, other.criteriaId)
				&& Objects.equals(input411t1, other.input411t1) && Objects.equals(input412t1, other.input412t1)
				&& Objects.equals(input4131t1, other.input4131t1) && Objects.equals(input413t1, other.input413t1)
				&& Objects.equals(input431t1, other.input431t1) && Objects.equals(response411, other.response411)
				&& Objects.equals(response412, other.response412) && Objects.equals(response413, other.response413)
				&& Objects.equals(response414, other.response414) && Objects.equals(response431, other.response431)
				&& uniqueKey1 == other.uniqueKey1;
	}

	
}
