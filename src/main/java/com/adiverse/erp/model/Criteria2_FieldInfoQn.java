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
//@Table(name ="criteria2Qn_fieldinfo")
//public class Criteria2_FieldInfoQn implements Serializable
//{
//	
//	private static final long serialVersionUID = 4920532919687126600L;
//
//	
//	private CriteriaPrimaryKey criteriaId;
//	
//	@Id
//    @Column(name="unique_key1")
//	private long uniqueKey1;
//	
//	
//	@Column(name = "responseValue211")
//    private String response211;
//	
//	@Column(name = "input2112t11")
//    private String input2112t11;
//	@Column(name = "input2121t21")
//    private String input2121t21;
//	
//	@Column(name = "responseValue212")
//    private String response212;
//	
//	
//	@Column(name = "responseValue221")
//    private String response221;
//	
//	@Column(name = "input221t1")
//    private String input221t1;
//	
//	
//	@Column(name = "responseValue222")
//    private String response222;
//	
//	@Column(name = "input222t1")
//    private String input222t1;
//	
//	@Column(name = "input2221t1")
//    private String input2221t1;
//	
//	
//	@Column(name = "responseValue233")
//    private String response233;
//	
//	@Column(name = "input2331t1")
//    private String input2331t1;
//	
//	@Column(name = "input2331t2")
//    private String input2331t2;
//	
//	@Column(name = "responseValue241")
//    private String response241;
//	
//	@Column(name = "input241t21")
//    private String input241t21;
//	
//	@Column(name = "responseValue242")
//    private String response242;
//	
//	@Column(name = "input2421t21")
//    private String input2421t21;
//	
//	@Column(name = "responseValue243")
//    private String response243;
//	
//    @Column(name = "input2431t1")
//    private String input2431t1;
//    
//    @Column(name = "responseValue244")
//    private String response244;
//	
//    
//	@Column(name = "input2431t3")
//    private String input2431t3;
//	@Column(name = "input2441t3")
//    private String input2441t3;
//	
//	public String getInput2441t3() {
//		return input2441t3;
//	}
//
//	public void setInput2441t3(String input2441t3) {
//		this.input2441t3 = input2441t3;
//	}
//	
//
//	@Column(name = "responseValue251")
//    private String response251;
//	@Column(name = "input2511t11")
//    private String input2511t11;
//	
//	@Column(name = "responseValue252")
//    private String response252;
//	@Column(name = "responseValue262")
//    private String response262;
//    @Column(name = "input262t1")
//    private String input262t1;
//	
//	
//	@Column(name = "responseValue263")
//    private String response263;
//	
//	@Column(name = "input2631t1")
//    private String input2631t1;
//	@Column(name = "input2632t1")
//    private String input2632t1;
//	
//	@Column(name = "input2632t2")
//    private String input2632t2;
//	@Column(name = "input271t1")
//    private String input271t1;
//	
//	@Column(name = "responseValue271")
//    private String response271;
//
//	public CriteriaPrimaryKey getCriteriaId() {
//		return criteriaId;
//	}
//
//	public void setCriteriaId(CriteriaPrimaryKey criteriaId) {
//		this.criteriaId = criteriaId;
//	}
//
//	public long getUniqueKey1() {
//		return uniqueKey1;
//	}
//
//	public void setUniqueKey1(long uniqueKey1) {
//		this.uniqueKey1 = uniqueKey1;
//	}
//
//	public String getResponse211() {
//		return response211;
//	}
//
//	public void setResponse211(String response211) {
//		this.response211 = response211;
//	}
//
//	public String getInput2112t11() {
//		return input2112t11;
//	}
//
//	public void setInput2112t11(String input2112t11) {
//		this.input2112t11 = input2112t11;
//	}
//
//	public String getInput2121t21() {
//		return input2121t21;
//	}
//
//	public void setInput2121t21(String input2121t21) {
//		this.input2121t21 = input2121t21;
//	}
//
//	public String getResponse212() {
//		return response212;
//	}
//
//	public void setResponse212(String response212) {
//		this.response212 = response212;
//	}
//
//	public String getResponse222() {
//		return response222;
//	}
//
//	public void setResponse222(String response222) {
//		this.response222 = response222;
//	}
//
//	public String getInput222t1() {
//		return input222t1;
//	}
//
//	public void setInput222t1(String input222t1) {
//		this.input222t1 = input222t1;
//	}
//
//	public String getInput2221t1() {
//		return input2221t1;
//	}
//
//	public void setInput2221t1(String input2221t1) {
//		this.input2221t1 = input2221t1;
//	}
//
//	public String getResponse233() {
//		return response233;
//	}
//
//	public void setResponse233(String response233) {
//		this.response233 = response233;
//	}
//
//	public String getInput2331t1() {
//		return input2331t1;
//	}
//
//	public void setInput2331t1(String input2331t1) {
//		this.input2331t1 = input2331t1;
//	}
//
//	public String getResponse241() {
//		return response241;
//	}
//
//	public void setResponse241(String response241) {
//		this.response241 = response241;
//	}
//
//	public String getInput241t21() {
//		return input241t21;
//	}
//
//	public void setInput241t21(String input241t21) {
//		this.input241t21 = input241t21;
//	}
//
//	public String getResponse242() {
//		return response242;
//	}
//
//	public void setResponse242(String response242) {
//		this.response242 = response242;
//	}
//
//	public String getInput2421t21() {
//		return input2421t21;
//	}
//
//	public void setInput2421t21(String input2421t21) {
//		this.input2421t21 = input2421t21;
//	}
//
//	public String getResponse243() {
//		return response243;
//	}
//
//	public void setResponse243(String response243) {
//		this.response243 = response243;
//	}
//
//	public String getInput2431t1() {
//		return input2431t1;
//	}
//
//	public void setInput2431t1(String input2431t1) {
//		this.input2431t1 = input2431t1;
//	}
//
//	public String getInput2431t3() {
//		return input2431t3;
//	}
//
//	public void setInput2431t3(String input2431t3) {
//		this.input2431t3 = input2431t3;
//	}
//
//	public String getResponse251() {
//		return response251;
//	}
//
//	public void setResponse251(String response251) {
//		this.response251 = response251;
//	}
//
//	public String getInput2511t11() {
//		return input2511t11;
//	}
//
//	public void setInput2511t11(String input2511t11) {
//		this.input2511t11 = input2511t11;
//	}
//
//	public String getResponse252() {
//		return response252;
//	}
//
//	public void setResponse252(String response252) {
//		this.response252 = response252;
//	}
//
//	public String getResponse263() {
//		return response263;
//	}
//
//	public void setResponse263(String response263) {
//		this.response263 = response263;
//	}
//
//	public String getInput2631t1() {
//		return input2631t1;
//	}
//
//	public void setInput2631t1(String input2631t1) {
//		this.input2631t1 = input2631t1;
//	}
//
//	public String getInput2632t1() {
//		return input2632t1;
//	}
//
//	public void setInput2632t1(String input2632t1) {
//		this.input2632t1 = input2632t1;
//	}
//
//	public String getInput2632t2() {
//		return input2632t2;
//	}
//
//	public void setInput2632t2(String input2632t2) {
//		this.input2632t2 = input2632t2;
//	}
//
//	public String getInput271t1() {
//		return input271t1;
//	}
//
//	public void setInput271t1(String input271t1) {
//		this.input271t1 = input271t1;
//	}
//
//	public String getResponse271() {
//		return response271;
//	}
//
//	public void setResponse271(String response271) {
//		this.response271 = response271;
//	}
//
//	public static long getSerialversionuid() {
//		return serialVersionUID;
//	}
//
//	public String getInput2331t2() {
//		return input2331t2;
//	}
//
//	public void setInput2331t2(String input2331t2) {
//		this.input2331t2 = input2331t2;
//	}
//
//	public String getResponse262() {
//		return response262;
//	}
//
//	public void setResponse262(String response262) {
//		this.response262 = response262;
//	}
//
//	public String getInput262t1() {
//		return input262t1;
//	}
//
//	public void setInput262t1(String input262t1) {
//		this.input262t1 = input262t1;
//	}
//
//	public String getResponse221() {
//		return response221;
//	}
//
//	public void setResponse221(String response221) {
//		this.response221 = response221;
//	}
//
//	public String getInput221t1() {
//		return input221t1;
//	}
//
//	public void setInput221t1(String input221t1) {
//		this.input221t1 = input221t1;
//	}
//
//	public String getResponse244() {
//		return response244;
//	}
//
//	public void setResponse244(String response244) {
//		this.response244 = response244;
//	}
//
//	@Override
//	public int hashCode() {
//		return Objects.hash(criteriaId, input2112t11, input2121t21, input221t1, input2221t1, input222t1, input2331t1,
//				input2331t2, input241t21, input2421t21, input2431t1, input2431t3, input2441t3, input2511t11, input262t1,
//				input2631t1, input2632t1, input2632t2, input271t1, response211, response212, response221, response222,
//				response233, response241, response242, response243, response244, response251, response252, response262,
//				response263, response271, uniqueKey1);
//	}
//
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Criteria2_FieldInfoQn other = (Criteria2_FieldInfoQn) obj;
//		return Objects.equals(criteriaId, other.criteriaId) && Objects.equals(input2112t11, other.input2112t11)
//				&& Objects.equals(input2121t21, other.input2121t21) && Objects.equals(input221t1, other.input221t1)
//				&& Objects.equals(input2221t1, other.input2221t1) && Objects.equals(input222t1, other.input222t1)
//				&& Objects.equals(input2331t1, other.input2331t1) && Objects.equals(input2331t2, other.input2331t2)
//				&& Objects.equals(input241t21, other.input241t21) && Objects.equals(input2421t21, other.input2421t21)
//				&& Objects.equals(input2431t1, other.input2431t1) && Objects.equals(input2431t3, other.input2431t3)
//				&& Objects.equals(input2441t3, other.input2441t3) && Objects.equals(input2511t11, other.input2511t11)
//				&& Objects.equals(input262t1, other.input262t1) && Objects.equals(input2631t1, other.input2631t1)
//				&& Objects.equals(input2632t1, other.input2632t1) && Objects.equals(input2632t2, other.input2632t2)
//				&& Objects.equals(input271t1, other.input271t1) && Objects.equals(response211, other.response211)
//				&& Objects.equals(response212, other.response212) && Objects.equals(response221, other.response221)
//				&& Objects.equals(response222, other.response222) && Objects.equals(response233, other.response233)
//				&& Objects.equals(response241, other.response241) && Objects.equals(response242, other.response242)
//				&& Objects.equals(response243, other.response243) && Objects.equals(response244, other.response244)
//				&& Objects.equals(response251, other.response251) && Objects.equals(response252, other.response252)
//				&& Objects.equals(response262, other.response262) && Objects.equals(response263, other.response263)
//				&& Objects.equals(response271, other.response271) && uniqueKey1 == other.uniqueKey1;
//	}
//
//	
//}
