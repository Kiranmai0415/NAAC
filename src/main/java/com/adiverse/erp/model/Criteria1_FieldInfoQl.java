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
//@Table(name ="criteria1Ql_fieldinfo")
//public class Criteria1_FieldInfoQl implements Serializable {
//	
//	
//	private static final long serialVersionUID = 1L;
//
//	
//	private CriteriaPrimaryKey criteriaId;
//	
//	 	@Id
//	    @Column(name="unique_key1")
//		private long uniqueKey1;
//		
//	@Column(name = "input111t1")
//    private String input111t1;
//	
//	@Column(name = "responseValue111")
//    private String response111;
//	
//	@Column(name = "input131t1")
//    private String input131t1;
//	
//	@Column(name = "responseValue131")
//    private String response131;
//	
//	
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
//	public String getInput111t1() {
//		return input111t1;
//	}
//
//	public void setInput111t1(String input111t1) {
//		this.input111t1 = input111t1;
//	}
//
//	public String getResponse111() {
//		return response111;
//	}
//
//	public void setResponse111(String response111) {
//		this.response111 = response111;
//	}
//
//	public String getInput131t1() {
//		return input131t1;
//	}
//
//	public void setInput131t1(String input131t1) {
//		this.input131t1 = input131t1;
//	}
//
//	public String getResponse131() {
//		return response131;
//	}
//
//	public void setResponse131(String response131) {
//		this.response131 = response131;
//	}
//
//	public static long getSerialversionuid() {
//		return serialVersionUID;
//	}
//
//	@Override
//	public int hashCode() {
//		return Objects.hash(criteriaId, input111t1, input131t1, response111, response131, uniqueKey1);
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
//		Criteria1_FieldInfoQl other = (Criteria1_FieldInfoQl) obj;
//		return Objects.equals(criteriaId, other.criteriaId) && Objects.equals(input111t1, other.input111t1)
//				&& Objects.equals(input131t1, other.input131t1) && Objects.equals(response111, other.response111)
//				&& Objects.equals(response131, other.response131) && uniqueKey1 == other.uniqueKey1;
//	}
//
//	
//
//	
//	
//}
