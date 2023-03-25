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
//@Table(name ="criteria5Ql_fieldinfo")
//public class Criteria5_FieldInfoQl implements Serializable {
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
//	@Column(name = "input532t1")
//    private String input532t1;
//	
//	@Column(name = "input5321t1")
//    private String input5321t1;
//	
//	@Column(name = "responseValue532")
//    private String response532;
//	
//	@Column(name = "input541t1")
//    private String input541t1;
//	
//	@Column(name = "input541t2")
//    private String input541t2;
//	
//	@Column(name = "responseValue541")
//    private String response541;
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
//	public String getInput532t1() {
//		return input532t1;
//	}
//
//	public void setInput532t1(String input532t1) {
//		this.input532t1 = input532t1;
//	}
//
//	public String getInput5321t1() {
//		return input5321t1;
//	}
//
//	public void setInput5321t1(String input5321t1) {
//		this.input5321t1 = input5321t1;
//	}
//
//	public String getResponse532() {
//		return response532;
//	}
//
//	public void setResponse532(String response532) {
//		this.response532 = response532;
//	}
//
//	public String getInput541t1() {
//		return input541t1;
//	}
//
//	public void setInput541t1(String input541t1) {
//		this.input541t1 = input541t1;
//	}
//
//	public String getInput541t2() {
//		return input541t2;
//	}
//
//	public void setInput541t2(String input541t2) {
//		this.input541t2 = input541t2;
//	}
//
//	public String getResponse541() {
//		return response541;
//	}
//
//	public void setResponse541(String response541) {
//		this.response541 = response541;
//	}
//
//	public static long getSerialversionuid() {
//		return serialVersionUID;
//	}
//
//	@Override
//	public int hashCode() {
//		return Objects.hash(criteriaId, input5321t1, input532t1, input541t1, input541t2, response532, response541,
//				uniqueKey1);
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
//		Criteria5_FieldInfoQl other = (Criteria5_FieldInfoQl) obj;
//		return Objects.equals(criteriaId, other.criteriaId) && Objects.equals(input5321t1, other.input5321t1)
//				&& Objects.equals(input532t1, other.input532t1) && Objects.equals(input541t1, other.input541t1)
//				&& Objects.equals(input541t2, other.input541t2) && Objects.equals(response532, other.response532)
//				&& Objects.equals(response541, other.response541) && uniqueKey1 == other.uniqueKey1;
//	}
//
//
//	
//
//	
//	
//}
