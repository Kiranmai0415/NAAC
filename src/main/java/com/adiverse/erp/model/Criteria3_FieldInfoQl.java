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
//@Table(name ="criteria3Ql_fieldinfo")
//public class Criteria3_FieldInfoQl implements Serializable {
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
////	@Column(name = "input311t1")
////    private String input311t1;
////	
////	@Column(name = "responseValue311")
////    private String response311;
////	
////	@Column(name = "input331t1")
////    private String input331t1;
////	
//
//	@Column(name = "responseValue321")
//    private String response321;
//	@Column(name = "input321t1")
//    private String input321t1;
//	
//	
//	
//	
//	@Column(name = "responseValue331")
//    private String response331;
//	
//	@Column(name = "input331t2")
//    private String input331t2;
//	
//	@Column(name = "input361t1")
//    private String input361t1;
//	
//	@Column(name = "responseValue341")
//    private String response341;
//	@Column(name = "input341t1")
//    private String input341t1;
//	
//	@Column(name = "responseValue342")
//    private String response342;
//	@Column(name = "input342t1")
//    private String input342t1;
//	
//	
//	
//	@Column(name = "responseValue361")
//    private String response361;
//	@Column(name = "input361t2")
//    private String input361t2;
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
//	public String getInput311t1() {
//		return input311t1;
//	}
//	public void setInput311t1(String input311t1) {
//		this.input311t1 = input311t1;
//	}
//	public String getResponse311() {
//		return response311;
//	}
//	public void setResponse311(String response311) {
//		this.response311 = response311;
//	}
//	public String getInput331t1() {
//		return input331t1;
//	}
//	public void setInput331t1(String input331t1) {
//		this.input331t1 = input331t1;
//	}
//	public String getResponse331() {
//		return response331;
//	}
//	public void setResponse331(String response331) {
//		this.response331 = response331;
//	}
//	public String getInput331t2() {
//		return input331t2;
//	}
//	public void setInput331t2(String input331t2) {
//		this.input331t2 = input331t2;
//	}
//	public String getInput361t1() {
//		return input361t1;
//	}
//	public void setInput361t1(String input361t1) {
//		this.input361t1 = input361t1;
//	}
//	public String getResponse361() {
//		return response361;
//	}
//	public void setResponse361(String response361) {
//		this.response361 = response361;
//	}
//	public String getInput361t2() {
//		return input361t2;
//	}
//	public void setInput361t2(String input361t2) {
//		this.input361t2 = input361t2;
//	}
//	public static long getSerialversionuid() {
//		return serialVersionUID;
//	}
//	public String getResponse321() {
//		return response321;
//	}
//	public void setResponse321(String response321) {
//		this.response321 = response321;
//	}
//	public String getInput321t1() {
//		return input321t1;
//	}
//	public void setInput321t1(String input321t1) {
//		this.input321t1 = input321t1;
//	}
//	
//	
//	
//	public String getResponse341() {
//		return response341;
//	}
//	public void setResponse341(String response341) {
//		this.response341 = response341;
//	}
//	public String getInput341t1() {
//		return input341t1;
//	}
//	public void setInput341t1(String input341t1) {
//		this.input341t1 = input341t1;
//	}
//	public String getResponse342() {
//		return response342;
//	}
//	public void setResponse342(String response342) {
//		this.response342 = response342;
//	}
//	public String getInput342t1() {
//		return input342t1;
//	}
//	public void setInput342t1(String input342t1) {
//		this.input342t1 = input342t1;
//	}
//	@Override
//	public int hashCode() {
//		return Objects.hash(criteriaId, input311t1, input321t1, input331t1, input331t2, input341t1, input342t1,
//				input361t1, input361t2, response311, response321, response331, response341, response342, response361,
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
//		Criteria3_FieldInfoQl other = (Criteria3_FieldInfoQl) obj;
//		return Objects.equals(criteriaId, other.criteriaId) && Objects.equals(input311t1, other.input311t1)
//				&& Objects.equals(input321t1, other.input321t1) && Objects.equals(input331t1, other.input331t1)
//				&& Objects.equals(input331t2, other.input331t2) && Objects.equals(input341t1, other.input341t1)
//				&& Objects.equals(input342t1, other.input342t1) && Objects.equals(input361t1, other.input361t1)
//				&& Objects.equals(input361t2, other.input361t2) && Objects.equals(response311, other.response311)
//				&& Objects.equals(response321, other.response321) && Objects.equals(response331, other.response331)
//				&& Objects.equals(response341, other.response341) && Objects.equals(response342, other.response342)
//				&& Objects.equals(response361, other.response361) && uniqueKey1 == other.uniqueKey1;
//	}
//	
//
//	
//	
//}
