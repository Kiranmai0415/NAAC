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
//@Table(name ="criteria2Ql_fieldinfo")
//public class Criteria2_FieldInfoQl implements Serializable
//{
//	
//	private static final long serialVersionUID = 4920532919687126600L;
//
//	
//	private CriteriaPrimaryKey criteriaId;
//	@Id
//    @Column(name="unique_key1")
//	private long uniqueKey1;
//	
//	
//	
//	@Column(name = "input221t1")
//    private String input221t1;
//	
//	@Column(name = "input221t2")
//    private String input221t2;
//	
//	@Column(name = "responseValue221")
//    private String response221;
//	
//	@Column(name = "input231t1")
//    private String input231t1;
//	@Column(name = "input231t2")
//    private String input231t2;
//	@Column(name = "responseValue231")
//    private String response231;
//	
//	@Column(name = "input232t1")
//    private String input232t1;
//	@Column(name = "input232t2")
//    private String input232t2;
//	
//	@Column(name = "responseValue232")
//    private String response232;
//	@Column(name = "input234t1")
//    private String input234t1;
//	@Column(name = "input234t2")
//    private String input234t2;
//	
//	@Column(name = "responseValue234")
//    private String response234;
//	@Column(name = "input253t1")
//    private String input253t1;
//	@Column(name = "input253t2")
//    private String input253t2;
//	
//	
//	
//	@Column(name = "responseValue251")
//    private String responseValue251;
//	
//	@Column(name = "input251t1")
//    private String input251t1;
//	
//	@Column(name = "responseValue253")
//    private String response253;
//	
//	@Column(name = "input261t1")
//    private String input261t1;
//	@Column(name = "input261t2")
//    private String input261t2;
//	
//	@Column(name = "responseValue261")
//    private String response261;
//	@Column(name = "input262t1")
//    private String input262t1;
//	@Column(name = "input262t2")
//    private String input262t2;
//	
//	@Column(name = "responseValue262")
//    private String response262;
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
//	public String getInput221t1() {
//		return input221t1;
//	}
//
//	public void setInput221t1(String input221t1) {
//		this.input221t1 = input221t1;
//	}
//
//	public String getInput221t2() {
//		return input221t2;
//	}
//
//	public void setInput221t2(String input221t2) {
//		this.input221t2 = input221t2;
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
//	public String getInput231t1() {
//		return input231t1;
//	}
//
//	public void setInput231t1(String input231t1) {
//		this.input231t1 = input231t1;
//	}
//
//	public String getInput231t2() {
//		return input231t2;
//	}
//
//	public void setInput231t2(String input231t2) {
//		this.input231t2 = input231t2;
//	}
//
//	public String getResponse231() {
//		return response231;
//	}
//
//	public void setResponse231(String response231) {
//		this.response231 = response231;
//	}
//
//	public String getInput232t1() {
//		return input232t1;
//	}
//
//	public void setInput232t1(String input232t1) {
//		this.input232t1 = input232t1;
//	}
//
//	public String getInput232t2() {
//		return input232t2;
//	}
//
//	public void setInput232t2(String input232t2) {
//		this.input232t2 = input232t2;
//	}
//
//	public String getResponse232() {
//		return response232;
//	}
//
//	public void setResponse232(String response232) {
//		this.response232 = response232;
//	}
//
//	public String getInput234t1() {
//		return input234t1;
//	}
//
//	public void setInput234t1(String input234t1) {
//		this.input234t1 = input234t1;
//	}
//
//	public String getInput234t2() {
//		return input234t2;
//	}
//
//	public void setInput234t2(String input234t2) {
//		this.input234t2 = input234t2;
//	}
//
//	public String getResponse234() {
//		return response234;
//	}
//
//	public void setResponse234(String response234) {
//		this.response234 = response234;
//	}
//
//	public String getInput253t1() {
//		return input253t1;
//	}
//
//	public void setInput253t1(String input253t1) {
//		this.input253t1 = input253t1;
//	}
//
//	public String getInput253t2() {
//		return input253t2;
//	}
//
//	public void setInput253t2(String input253t2) {
//		this.input253t2 = input253t2;
//	}
//
//	public String getResponse253() {
//		return response253;
//	}
//
//	public void setResponse253(String response253) {
//		this.response253 = response253;
//	}
//
//	public String getInput261t1() {
//		return input261t1;
//	}
//
//	public void setInput261t1(String input261t1) {
//		this.input261t1 = input261t1;
//	}
//
//	public String getInput261t2() {
//		return input261t2;
//	}
//
//	public void setInput261t2(String input261t2) {
//		this.input261t2 = input261t2;
//	}
//
//	public String getResponse261() {
//		return response261;
//	}
//
//	public void setResponse261(String response261) {
//		this.response261 = response261;
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
//	public String getInput262t2() {
//		return input262t2;
//	}
//
//	public void setInput262t2(String input262t2) {
//		this.input262t2 = input262t2;
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
//	public static long getSerialversionuid() {
//		return serialVersionUID;
//	}
//
//	public String getResponseValue251() {
//		return responseValue251;
//	}
//
//	public void setResponseValue251(String responseValue251) {
//		this.responseValue251 = responseValue251;
//	}
//
//	public String getInput251t1() {
//		return input251t1;
//	}
//
//	public void setInput251t1(String input251t1) {
//		this.input251t1 = input251t1;
//	}
//
//	@Override
//	public int hashCode() {
//		return Objects.hash(criteriaId, input221t1, input221t2, input231t1, input231t2, input232t1, input232t2,
//				input234t1, input234t2, input251t1, input253t1, input253t2, input261t1, input261t2, input262t1,
//				input262t2, response221, response231, response232, response234, response253, response261, response262,
//				responseValue251, uniqueKey1);
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
//		Criteria2_FieldInfoQl other = (Criteria2_FieldInfoQl) obj;
//		return Objects.equals(criteriaId, other.criteriaId) && Objects.equals(input221t1, other.input221t1)
//				&& Objects.equals(input221t2, other.input221t2) && Objects.equals(input231t1, other.input231t1)
//				&& Objects.equals(input231t2, other.input231t2) && Objects.equals(input232t1, other.input232t1)
//				&& Objects.equals(input232t2, other.input232t2) && Objects.equals(input234t1, other.input234t1)
//				&& Objects.equals(input234t2, other.input234t2) && Objects.equals(input251t1, other.input251t1)
//				&& Objects.equals(input253t1, other.input253t1) && Objects.equals(input253t2, other.input253t2)
//				&& Objects.equals(input261t1, other.input261t1) && Objects.equals(input261t2, other.input261t2)
//				&& Objects.equals(input262t1, other.input262t1) && Objects.equals(input262t2, other.input262t2)
//				&& Objects.equals(response221, other.response221) && Objects.equals(response231, other.response231)
//				&& Objects.equals(response232, other.response232) && Objects.equals(response234, other.response234)
//				&& Objects.equals(response253, other.response253) && Objects.equals(response261, other.response261)
//				&& Objects.equals(response262, other.response262)
//				&& Objects.equals(responseValue251, other.responseValue251) && uniqueKey1 == other.uniqueKey1;
//	}
//
//	
//	
//
//	
//	
//}