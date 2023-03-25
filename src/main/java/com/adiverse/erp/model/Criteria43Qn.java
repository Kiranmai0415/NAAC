package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name ="criteria43Qn")
public class Criteria43Qn implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	
	private CriteriaPrimaryKey criteriaId;
	
	@Id
    @Column(name="unique_key1")
	private long uniqueKey1;
	

	
	@Column(name = "responseValue432")
    private String response432;
	
	@Column(name = "input432t1")
    private String input432t1;
	
	@Column(name = "input432t2")
    private String input432t2;
	
	@Column(name = "responseValue433")
    private String response433;
	
	@Column(name = "input433t1")
    private String input433t1;
	
	@Column(name = "input433t2")
    private String input433t2;
	
	@Column(name = "responseValue434")
    private String response434;
	
	@Column(name = "input434t1")
    private String input434t1;
	
	@Column(name = "responseValue435")
    private String response435;
	
	@Column(name = "input435t1")
    private String input435t1;
	

	@Column(name = "criteria43status")
    private String criteria43status;


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


	public String getResponse432() {
		if(response432 !=null) {
		return response432;
	}else {
		return "";
	}
	}


	public void setResponse432(String response432) {
		this.response432 = response432;
	}


	public String getInput432t1() {
		if(input432t1 !=null) {
		return input432t1;
	}else {
		return "";
	}
	}


	public void setInput432t1(String input432t1) {
		this.input432t1 = input432t1;
	}


	public String getInput432t2() {
		if(input432t2 !=null) {
		return input432t2;
	}else {
		return "";
	}
	}


	public void setInput432t2(String input432t2) {
		this.input432t2 = input432t2;
	}


	public String getResponse433() {
		if(response433 !=null) {
		return response433;
	}else {
		return "";
	}
	}


	public void setResponse433(String response433) {
		this.response433 = response433;
	}


	public String getInput433t1() {
		if(input433t1 !=null) {
		return input433t1;
	}else {
		return "";
	}
	}


	public void setInput433t1(String input433t1) {
		this.input433t1 = input433t1;
	}


	public String getInput433t2() {
		if(input433t2 !=null) {
		return input433t2;
	}else {
		return "";
	}
	}


	public void setInput433t2(String input433t2) {
		this.input433t2 = input433t2;
	}


	public String getResponse434() {
		if(response434 !=null) {
		return response434;
	}else {
		return "";
	}
	}


	public void setResponse434(String response434) {
		this.response434 = response434;
	}


	public String getInput434t1() {
		if(input434t1 !=null) {
		return input434t1;
	}else {
		return "";
	}
	}


	public void setInput434t1(String input434t1) {
		this.input434t1 = input434t1;
	}


	public String getResponse435() {
		if(response435 !=null) {
		return response435;
	}else {
		return "";
	}
	}


	public void setResponse435(String response435) {
		this.response435 = response435;
	}


	public String getInput435t1() {
		if(input435t1 !=null) {
		return input435t1;
	}else {
		return "";
	}
	}


	public void setInput435t1(String input435t1) {
		this.input435t1 = input435t1;
	}


	public String getCriteria43status() {
		return criteria43status;
	}


	public void setCriteria43status(String criteria43status) {
		this.criteria43status = criteria43status;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	@Override
	public int hashCode() {
		return Objects.hash(criteria43status, criteriaId, input432t1, input432t2, input433t1, input433t2, input434t1,
				input435t1, response432, response433, response434, response435, uniqueKey1);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Criteria43Qn other = (Criteria43Qn) obj;
		return Objects.equals(criteria43status, other.criteria43status) && Objects.equals(criteriaId, other.criteriaId)
				&& Objects.equals(input432t1, other.input432t1) && Objects.equals(input432t2, other.input432t2)
				&& Objects.equals(input433t1, other.input433t1) && Objects.equals(input433t2, other.input433t2)
				&& Objects.equals(input434t1, other.input434t1) && Objects.equals(input435t1, other.input435t1)
				&& Objects.equals(response432, other.response432) && Objects.equals(response433, other.response433)
				&& Objects.equals(response434, other.response434) && Objects.equals(response435, other.response435)
				&& uniqueKey1 == other.uniqueKey1;
	}

	
	
}
