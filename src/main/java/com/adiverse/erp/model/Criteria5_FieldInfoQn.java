//package com.adiverse.erp.model;
//
//import java.io.Serializable;
//import java.util.Objects;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.Id;
//import javax.persistence.Table;
//
//
//@Entity
//@Table(name ="criteria5Qn_fieldinfo")
//public class Criteria5_FieldInfoQn implements Serializable {
//	
//	private static final long serialVersionUID = 1L;
//
//	
//	private CriteriaPrimaryKey criteriaId;
//	
//	@Id
//    @Column(name="unique_key1")
//	private long uniqueKey1;
//	
//	@Column(name = "input511t1")
//    private String input511t1;
//	@Column(name = "responseValue511")
//    private String response511;
//	
//	@Column(name = "input512t1")
//    private String input512t1;
//	@Column(name = "responseValue512")
//    private String response512;
//	@Column(name = "input5212t1")
//    private String input5212t1;
//	
//	@Column(name = "responseValue513")
//    private String response513;
//	@Column(name = "input513t1")
//    private String input513t1;
//	
//	@Column(name = "input514t1")
//    private String input514t1;
//	
//	@Column(name = "responseValue514")
//    private String response514;
//	
//	@Column(name = "responseValue515")
//    private String response515;
//	@Column(name = "input515t1")
//    private String input515t1;
//	@Column(name = "responseValue521")
//    private String response521;
//	
//	@Column(name = "responseValue522")
//    private String response522;
//	@Column(name = "input5221t1")
//    private String input5221t1;
//	@Column(name = "responseValue523")
//    private String response523;
//	
//	@Column(name = "input531t1")
//    private String input531t1;
//	@Column(name = "responseValue531")
//    private String response531;
//	
//	@Column(name = "input532t1")
//    private String input532t1;
//	@Column(name = "responseValue532")
//    private String response532;
//	
//	
//	public String getInput532t1() {
//		return input532t1;
//	}
//	public void setInput532t1(String input532t1) {
//		this.input532t1 = input532t1;
//	}
//	public String getResponse532() {
//		return response532;
//	}
//	public void setResponse532(String response532) {
//		this.response532 = response532;
//	}
//	@Column(name = "responseValue533")
//    private String response533;
//	
//	@Column(name = "responseValue542")
//    private String response542;
//	@Column(name = "input542t1")
//    private String input542t1;
//	public CriteriaPrimaryKey getCriteriaId() {
//		return criteriaId;
//	}
//	public void setCriteriaId(CriteriaPrimaryKey criteriaId) {
//		this.criteriaId = criteriaId;
//	}
//	public long getUniqueKey1() {
//		return uniqueKey1;
//	}
//	public void setUniqueKey1(long uniqueKey1) {
//		this.uniqueKey1 = uniqueKey1;
//	}
//	public String getResponse511() {
//		return response511;
//	}
//	public void setResponse511(String response511) {
//		this.response511 = response511;
//	}
//	public String getInput5212t1() {
//		return input5212t1;
//	}
//	public void setInput5212t1(String input5212t1) {
//		this.input5212t1 = input5212t1;
//	}
//	public String getResponse512() {
//		return response512;
//	}
//	public void setResponse512(String response512) {
//		this.response512 = response512;
//	}
//	public String getResponse513() {
//		return response513;
//	}
//	public void setResponse513(String response513) {
//		this.response513 = response513;
//	}
//	public String getInput513t1() {
//		return input513t1;
//	}
//	public void setInput513t1(String input513t1) {
//		this.input513t1 = input513t1;
//	}
//	public String getResponse514() {
//		return response514;
//	}
//	public void setResponse514(String response514) {
//		this.response514 = response514;
//	}
//	public String getResponse515() {
//		return response515;
//	}
//	public void setResponse515(String response515) {
//		this.response515 = response515;
//	}
//	public String getInput515t1() {
//		return input515t1;
//	}
//	public void setInput515t1(String input515t1) {
//		this.input515t1 = input515t1;
//	}
//	public String getResponse521() {
//		return response521;
//	}
//	public void setResponse521(String response521) {
//		this.response521 = response521;
//	}
//	public String getResponse522() {
//		return response522;
//	}
//	public void setResponse522(String response522) {
//		this.response522 = response522;
//	}
//	public String getInput5221t1() {
//		return input5221t1;
//	}
//	public void setInput5221t1(String input5221t1) {
//		this.input5221t1 = input5221t1;
//	}
//	public String getResponse523() {
//		return response523;
//	}
//	public void setResponse523(String response523) {
//		this.response523 = response523;
//	}
//	public String getResponse531() {
//		return response531;
//	}
//	public void setResponse531(String response531) {
//		this.response531 = response531;
//	}
//	public String getResponse533() {
//		return response533;
//	}
//	public void setResponse533(String response533) {
//		this.response533 = response533;
//	}
//	public String getResponse542() {
//		return response542;
//	}
//	public void setResponse542(String response542) {
//		this.response542 = response542;
//	}
//	public String getInput542t1() {
//		return input542t1;
//	}
//	public void setInput542t1(String input542t1) {
//		this.input542t1 = input542t1;
//	}
//	public static long getSerialversionuid() {
//		return serialVersionUID;
//	}
//	public String getInput511t1() {
//		return input511t1;
//	}
//	public void setInput511t1(String input511t1) {
//		this.input511t1 = input511t1;
//	}
//	public String getInput512t1() {
//		return input512t1;
//	}
//	public void setInput512t1(String input512t1) {
//		this.input512t1 = input512t1;
//	}
//	public String getInput514t1() {
//		return input514t1;
//	}
//	public void setInput514t1(String input514t1) {
//		this.input514t1 = input514t1;
//	}
//	public String getInput531t1() {
//		return input531t1;
//	}
//	public void setInput531t1(String input531t1) {
//		this.input531t1 = input531t1;
//	}
//	
//	
//	@Override
//	public int hashCode() {
//		return Objects.hash(criteriaId, input511t1, input512t1, input513t1, input514t1, input515t1, input5212t1,
//				input5221t1, input531t1, input532t1, input542t1, response511, response512, response513, response514,
//				response515, response521, response522, response523, response531, response532, response533, response542,
//				uniqueKey1);
//	}
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Criteria5_FieldInfoQn other = (Criteria5_FieldInfoQn) obj;
//		return Objects.equals(criteriaId, other.criteriaId) && Objects.equals(input511t1, other.input511t1)
//				&& Objects.equals(input512t1, other.input512t1) && Objects.equals(input513t1, other.input513t1)
//				&& Objects.equals(input514t1, other.input514t1) && Objects.equals(input515t1, other.input515t1)
//				&& Objects.equals(input5212t1, other.input5212t1) && Objects.equals(input5221t1, other.input5221t1)
//				&& Objects.equals(input531t1, other.input531t1) && Objects.equals(input532t1, other.input532t1)
//				&& Objects.equals(input542t1, other.input542t1) && Objects.equals(response511, other.response511)
//				&& Objects.equals(response512, other.response512) && Objects.equals(response513, other.response513)
//				&& Objects.equals(response514, other.response514) && Objects.equals(response515, other.response515)
//				&& Objects.equals(response521, other.response521) && Objects.equals(response522, other.response522)
//				&& Objects.equals(response523, other.response523) && Objects.equals(response531, other.response531)
//				&& Objects.equals(response532, other.response532) && Objects.equals(response533, other.response533)
//				&& Objects.equals(response542, other.response542) && uniqueKey1 == other.uniqueKey1;
//	}
//	
//	
//}
