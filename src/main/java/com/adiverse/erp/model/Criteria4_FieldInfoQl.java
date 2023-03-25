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
//@Table(name ="criteria4Ql_fieldinfo")
//public class Criteria4_FieldInfoQl implements Serializable {
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
//	@Column(name = "input411t1")
//    private String input411t1;
//	@Column(name = "responseValue411")
//    private String response411;
//	
//	@Column(name = "input412t1")
//    private String input412t1;
//	@Column(name = "responseValue412")
//    private String response412;
//	
//	@Column(name = "input421t1")
//    private String input421t1;
//	@Column(name = "responseValue421")
//    private String response421;
//	
//	@Column(name = "input431t1")
//    private String input431t1;
//	@Column(name = "responseValue431")
//    private String response431;
//	
//	@Column(name = "input442t1")
//    private String input442t1;
//	@Column(name = "responseValue442")
//    private String response442;
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
//	public String getInput411t1() {
//		return input411t1;
//	}
//	public void setInput411t1(String input411t1) {
//		this.input411t1 = input411t1;
//	}
//	public String getResponse411() {
//		return response411;
//	}
//	public void setResponse411(String response411) {
//		this.response411 = response411;
//	}
//	public String getInput412t1() {
//		return input412t1;
//	}
//	public void setInput412t1(String input412t1) {
//		this.input412t1 = input412t1;
//	}
//	public String getResponse412() {
//		return response412;
//	}
//	public void setResponse412(String response412) {
//		this.response412 = response412;
//	}
//	public String getInput421t1() {
//		return input421t1;
//	}
//	public void setInput421t1(String input421t1) {
//		this.input421t1 = input421t1;
//	}
//	public String getResponse421() {
//		return response421;
//	}
//	public void setResponse421(String response421) {
//		this.response421 = response421;
//	}
//	public String getInput431t1() {
//		return input431t1;
//	}
//	public void setInput431t1(String input431t1) {
//		this.input431t1 = input431t1;
//	}
//	public String getResponse431() {
//		return response431;
//	}
//	public void setResponse431(String response431) {
//		this.response431 = response431;
//	}
//	public String getInput442t1() {
//		return input442t1;
//	}
//	public void setInput442t1(String input442t1) {
//		this.input442t1 = input442t1;
//	}
//	public String getResponse442() {
//		return response442;
//	}
//	public void setResponse442(String response442) {
//		this.response442 = response442;
//	}
//	public static long getSerialversionuid() {
//		return serialVersionUID;
//	}
//	@Override
//	public int hashCode() {
//		return Objects.hash(criteriaId, input411t1, input412t1, input421t1, input431t1, input442t1, response411,
//				response412, response421, response431, response442, uniqueKey1);
//	}
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Criteria4_FieldInfoQl other = (Criteria4_FieldInfoQl) obj;
//		return Objects.equals(criteriaId, other.criteriaId) && Objects.equals(input411t1, other.input411t1)
//				&& Objects.equals(input412t1, other.input412t1) && Objects.equals(input421t1, other.input421t1)
//				&& Objects.equals(input431t1, other.input431t1) && Objects.equals(input442t1, other.input442t1)
//				&& Objects.equals(response411, other.response411) && Objects.equals(response412, other.response412)
//				&& Objects.equals(response421, other.response421) && Objects.equals(response431, other.response431)
//				&& Objects.equals(response442, other.response442) && uniqueKey1 == other.uniqueKey1;
//	}
//	
//	
//	
//	
//	
//	
//}