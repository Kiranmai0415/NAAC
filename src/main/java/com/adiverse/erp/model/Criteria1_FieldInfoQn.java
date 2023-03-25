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
//@Table(name ="criteria1Qn_fieldinfo")
//public class Criteria1_FieldInfoQn implements Serializable {
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
//	
//	@Column(name = "responseValue112")
//    private String response112;
//	
//	@Column(name = "input1121t1")
//    private String input1121t1;
//	
//	@Column(name = "input1122t1")
//    private String input1122t1;
//	
//	@Column(name = "responseValue113")
//    private String response113;
//	
//	@Column(name = "responseValue121")
//    private String response121;
//	
//	@Column(name = "input1211t1")
//    private String input1211t1;
//	
//	@Column(name = "responseValue123")
//    private String response123;
//	
//	@Column(name = "input123t1")
//    private String input123t1;
//	
//	@Column(name = "input1212t1")
//    private String input1212t1;
//	
//	@Column(name = "input1212t2")
//    private String input1212t2;
//	
//	@Column(name = "responseValue122")
//    private String response122;
//	
//	//extra(g)
//	@Column(name = "input122t1")
//    private String input122t1;
//	
//	@Column(name = "input1221t1")
//    private String input1221t1;
//	
//	@Column(name = "input1221t2")
//    private String input1221t2;
//
//	@Column(name = "responseValue132")
//    private String responseValue132;
//	
//	@Column(name = "input1321t11")
//    private String input1321t11;
//	
//	@Column(name = "responseValue133")
//    private String response133;
//	
//	@Column(name = "input1331t21")
//    private String input1331t21;
//	
//	@Column(name = "responseValue134")
//    private String response134;
//	
//	
//	@Column(name = "input134t1")
//    private String input134t1;
//	
//	@Column(name = "input1341t1")
//    private String input1341t1;
//	
//	//extra
//	@Column(name = "input1341t2")
//    private String input1341t2;
//	
//	@Column(name = "responseValue141")
//    private String response141;
//	
//	@Column(name = "input141t1")
//    private String input141t1;
//	
//	//extra
//	@Column(name = "input141t2")
//    private String input141t2;
//	
//	@Column(name = "responseValue142")
//    private String response142;
//	
//	@Column(name = "input142t1")
//    private String input142t1;
//	
//	//extra
//	@Column(name = "input142t2")
//    private String input142t2;
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
//	public String getResponse112() {
//		return response112;
//	}
//
//	public void setResponse112(String response112) {
//		this.response112 = response112;
//	}
//
//	public String getInput1121t1() {
//		return input1121t1;
//	}
//
//	public void setInput1121t1(String input1121t1) {
//		this.input1121t1 = input1121t1;
//	}
//
//	public String getInput1122t1() {
//		return input1122t1;
//	}
//
//	public void setInput1122t1(String input1122t1) {
//		this.input1122t1 = input1122t1;
//	}
//
//	public String getResponse113() {
//		return response113;
//	}
//
//	public void setResponse113(String response113) {
//		this.response113 = response113;
//	}
//
//	public String getResponse121() {
//		return response121;
//	}
//
//	public void setResponse121(String response121) {
//		this.response121 = response121;
//	}
//
//	public String getInput1211t1() {
//		return input1211t1;
//	}
//
//	public void setInput1211t1(String input1211t1) {
//		this.input1211t1 = input1211t1;
//	}
//
//	public String getInput1212t1() {
//		return input1212t1;
//	}
//
//	public void setInput1212t1(String input1212t1) {
//		this.input1212t1 = input1212t1;
//	}
//
//	public String getInput1212t2() {
//		return input1212t2;
//	}
//
//	public void setInput1212t2(String input1212t2) {
//		this.input1212t2 = input1212t2;
//	}
//
//	public String getResponse122() {
//		return response122;
//	}
//
//	public void setResponse122(String response122) {
//		this.response122 = response122;
//	}
//
//	public String getInput122t1() {
//		return input122t1;
//	}
//
//	public void setInput122t1(String input122t1) {
//		this.input122t1 = input122t1;
//	}
//
//	public String getInput1221t1() {
//		return input1221t1;
//	}
//
//	public void setInput1221t1(String input1221t1) {
//		this.input1221t1 = input1221t1;
//	}
//
//	public String getInput1221t2() {
//		return input1221t2;
//	}
//
//	public void setInput1221t2(String input1221t2) {
//		this.input1221t2 = input1221t2;
//	}
//
//	public String getResponseValue132() {
//		return responseValue132;
//	}
//
//	public void setResponseValue132(String responseValue132) {
//		this.responseValue132 = responseValue132;
//	}
//
//	public String getInput1321t11() {
//		return input1321t11;
//	}
//
//	public void setInput1321t11(String input1321t11) {
//		this.input1321t11 = input1321t11;
//	}
//
//	public String getResponse133() {
//		return response133;
//	}
//
//	public void setResponse133(String response133) {
//		this.response133 = response133;
//	}
//
//	public String getInput1331t21() {
//		return input1331t21;
//	}
//
//	public void setInput1331t21(String input1331t21) {
//		this.input1331t21 = input1331t21;
//	}
//
//	public String getResponse134() {
//		return response134;
//	}
//
//	public void setResponse134(String response134) {
//		this.response134 = response134;
//	}
//
//	public String getInput134t1() {
//		return input134t1;
//	}
//
//	public void setInput134t1(String input134t1) {
//		this.input134t1 = input134t1;
//	}
//
//	public String getInput1341t1() {
//		return input1341t1;
//	}
//
//	public void setInput1341t1(String input1341t1) {
//		this.input1341t1 = input1341t1;
//	}
//
//	public String getInput1341t2() {
//		return input1341t2;
//	}
//
//	public void setInput1341t2(String input1341t2) {
//		this.input1341t2 = input1341t2;
//	}
//
//	public String getResponse141() {
//		return response141;
//	}
//
//	public void setResponse141(String response141) {
//		this.response141 = response141;
//	}
//
//	public String getInput141t1() {
//		return input141t1;
//	}
//
//	public void setInput141t1(String input141t1) {
//		this.input141t1 = input141t1;
//	}
//
//	public String getInput141t2() {
//		return input141t2;
//	}
//
//	public void setInput141t2(String input141t2) {
//		this.input141t2 = input141t2;
//	}
//
//	public String getResponse142() {
//		return response142;
//	}
//
//	public void setResponse142(String response142) {
//		this.response142 = response142;
//	}
//
//	public String getInput142t1() {
//		return input142t1;
//	}
//
//	public void setInput142t1(String input142t1) {
//		this.input142t1 = input142t1;
//	}
//
//	public String getInput142t2() {
//		return input142t2;
//	}
//
//	public void setInput142t2(String input142t2) {
//		this.input142t2 = input142t2;
//	}
//
//	public static long getSerialversionuid() {
//		return serialVersionUID;
//	}
//
//	public String getResponse123() {
//		return response123;
//	}
//
//	public void setResponse123(String response123) {
//		this.response123 = response123;
//	}
//
//	public String getInput123t1() {
//		return input123t1;
//	}
//
//	public void setInput123t1(String input123t1) {
//		this.input123t1 = input123t1;
//	}
//
//	@Override
//	public int hashCode() {
//		return Objects.hash(criteriaId, input1121t1, input1122t1, input1211t1, input1212t1, input1212t2, input1221t1,
//				input1221t2, input122t1, input123t1, input1321t11, input1331t21, input1341t1, input1341t2, input134t1,
//				input141t1, input141t2, input142t1, input142t2, response112, response113, response121, response122,
//				response123, response133, response134, response141, response142, responseValue132, uniqueKey1);
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
//		Criteria1_FieldInfoQn other = (Criteria1_FieldInfoQn) obj;
//		return Objects.equals(criteriaId, other.criteriaId) && Objects.equals(input1121t1, other.input1121t1)
//				&& Objects.equals(input1122t1, other.input1122t1) && Objects.equals(input1211t1, other.input1211t1)
//				&& Objects.equals(input1212t1, other.input1212t1) && Objects.equals(input1212t2, other.input1212t2)
//				&& Objects.equals(input1221t1, other.input1221t1) && Objects.equals(input1221t2, other.input1221t2)
//				&& Objects.equals(input122t1, other.input122t1) && Objects.equals(input123t1, other.input123t1)
//				&& Objects.equals(input1321t11, other.input1321t11) && Objects.equals(input1331t21, other.input1331t21)
//				&& Objects.equals(input1341t1, other.input1341t1) && Objects.equals(input1341t2, other.input1341t2)
//				&& Objects.equals(input134t1, other.input134t1) && Objects.equals(input141t1, other.input141t1)
//				&& Objects.equals(input141t2, other.input141t2) && Objects.equals(input142t1, other.input142t1)
//				&& Objects.equals(input142t2, other.input142t2) && Objects.equals(response112, other.response112)
//				&& Objects.equals(response113, other.response113) && Objects.equals(response121, other.response121)
//				&& Objects.equals(response122, other.response122) && Objects.equals(response123, other.response123)
//				&& Objects.equals(response133, other.response133) && Objects.equals(response134, other.response134)
//				&& Objects.equals(response141, other.response141) && Objects.equals(response142, other.response142)
//				&& Objects.equals(responseValue132, other.responseValue132) && uniqueKey1 == other.uniqueKey1;
//	}
//	
//	
//
//	
//
//	
//}
