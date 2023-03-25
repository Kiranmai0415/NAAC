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
//@Table(name ="criteria4Qn_fieldinfo")
//public class Criteria4_FieldInfoQn implements Serializable {
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
//
//	@Column(name = "responseValue412")
//    private String response412;
//	
//	
//	@Column(name = "input412t1")
//    private String input412t1;
//	
//	@Column(name = "responseValue413")
//    private String response413;
//	
//	
//	@Column(name = "input4131t1")
//    private String input4131t1;
//	@Column(name = "input4131t2")
//    private String input4131t2;
//	
//	@Column(name = "responseValue414")
//    private String response414;
//
//	@Column(name = "responseValue422")
//    private String response422;
//	
//	@Column(name = "input422t1")
//    private String input422t1;
//	
//	@Column(name = "responseValue423")
//    private String response423;
//	
//	@Column(name = "responseValue424")
//    private String response424;
//	
//	@Column(name = "input4241t1")
//    private String input4241t1;
//	
//	@Column(name = "input4241t2")
//    private String input4241t2;
//
//	@Column(name = "input432t1")
//    private String input432t1;
//	
//	@Column(name = "input432t2")
//    private String input432t2;
//	
//	@Column(name = "responseValue432")
//    private String response432;
//	
//	@Column(name = "responseValue433")
//    private String response433;
//	
//	@Column(name = "input433t1")
//    private String input433t1;
//	@Column(name = "responseValue434")
//    private String response434;
//	
//	@Column(name = "input434t1")
//    private String input434t1;
//	@Column(name = "input441t1")
//    private String input441t1;
//	@Column(name = "responseValue441")
//    private String response441;
//	
//	
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
//	public String getResponse413() {
//		return response413;
//	}
//	public void setResponse413(String response413) {
//		this.response413 = response413;
//	}
//	public String getInput4131t1() {
//		return input4131t1;
//	}
//	public void setInput4131t1(String input4131t1) {
//		this.input4131t1 = input4131t1;
//	}
//	
//	public String getResponse414() {
//		return response414;
//	}
//	public void setResponse414(String response414) {
//		this.response414 = response414;
//	}
//	public String getResponse422() {
//		return response422;
//	}
//	public void setResponse422(String response422) {
//		this.response422 = response422;
//	}
//	public String getInput422t1() {
//		return input422t1;
//	}
//	public void setInput422t1(String input422t1) {
//		this.input422t1 = input422t1;
//	}
//	public String getResponse423() {
//		return response423;
//	}
//	public void setResponse423(String response423) {
//		this.response423 = response423;
//	}
//	public String getResponse424() {
//		return response424;
//	}
//	public void setResponse424(String response424) {
//		this.response424 = response424;
//	}
//	public String getInput4241t1() {
//		return input4241t1;
//	}
//	public void setInput4241t1(String input4241t1) {
//		this.input4241t1 = input4241t1;
//	}
//	public String getInput432t1() {
//		return input432t1;
//	}
//	public void setInput432t1(String input432t1) {
//		this.input432t1 = input432t1;
//	}
//	public String getResponse432() {
//		return response432;
//	}
//	public void setResponse432(String response432) {
//		this.response432 = response432;
//	}
//	public String getResponse433() {
//		return response433;
//	}
//	public void setResponse433(String response433) {
//		this.response433 = response433;
//	}
//	public String getInput433t1() {
//		return input433t1;
//	}
//	public void setInput433t1(String input433t1) {
//		this.input433t1 = input433t1;
//	}
//	public String getResponse434() {
//		return response434;
//	}
//	public void setResponse434(String response434) {
//		this.response434 = response434;
//	}
//	public String getInput434t1() {
//		return input434t1;
//	}
//	public void setInput434t1(String input434t1) {
//		this.input434t1 = input434t1;
//	}
//	public String getResponse441() {
//		return response441;
//	}
//	public void setResponse441(String response441) {
//		this.response441 = response441;
//	}
//	
//	public String getInput4241t2() {
//		return input4241t2;
//	}
//	public void setInput4241t2(String input4241t2) {
//		this.input4241t2 = input4241t2;
//	}
//	public static long getSerialversionuid() {
//		return serialVersionUID;
//	}
//	
//	
//	public String getInput4131t2() {
//		return input4131t2;
//	}
//	public void setInput4131t2(String input4131t2) {
//		this.input4131t2 = input4131t2;
//	}
//	public String getInput432t2() {
//		return input432t2;
//	}
//	public void setInput432t2(String input432t2) {
//		this.input432t2 = input432t2;
//	}
//	public String getResponse412() {
//		return response412;
//	}
//	public void setResponse412(String response412) {
//		this.response412 = response412;
//	}
//	public String getInput412t1() {
//		return input412t1;
//	}
//	public void setInput412t1(String input412t1) {
//		this.input412t1 = input412t1;
//	}
//	public String getInput441t1() {
//		return input441t1;
//	}
//	public void setInput441t1(String input441t1) {
//		this.input441t1 = input441t1;
//	}
//	@Override
//	public int hashCode() {
//		return Objects.hash(criteriaId, input412t1, input4131t1, input4131t2, input422t1, input4241t1, input4241t2,
//				input432t1, input432t2, input433t1, input434t1, input441t1, response412, response413, response414,
//				response422, response423, response424, response432, response433, response434, response441, uniqueKey1);
//	}
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Criteria4_FieldInfoQn other = (Criteria4_FieldInfoQn) obj;
//		return Objects.equals(criteriaId, other.criteriaId) && Objects.equals(input412t1, other.input412t1)
//				&& Objects.equals(input4131t1, other.input4131t1) && Objects.equals(input4131t2, other.input4131t2)
//				&& Objects.equals(input422t1, other.input422t1) && Objects.equals(input4241t1, other.input4241t1)
//				&& Objects.equals(input4241t2, other.input4241t2) && Objects.equals(input432t1, other.input432t1)
//				&& Objects.equals(input432t2, other.input432t2) && Objects.equals(input433t1, other.input433t1)
//				&& Objects.equals(input434t1, other.input434t1) && Objects.equals(input441t1, other.input441t1)
//				&& Objects.equals(response412, other.response412) && Objects.equals(response413, other.response413)
//				&& Objects.equals(response414, other.response414) && Objects.equals(response422, other.response422)
//				&& Objects.equals(response423, other.response423) && Objects.equals(response424, other.response424)
//				&& Objects.equals(response432, other.response432) && Objects.equals(response433, other.response433)
//				&& Objects.equals(response434, other.response434) && Objects.equals(response441, other.response441)
//				&& uniqueKey1 == other.uniqueKey1;
//	}
//	
//	
//	
//	
//}
