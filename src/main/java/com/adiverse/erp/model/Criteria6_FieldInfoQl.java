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
//@Table(name ="criteria6Ql_fieldinfo")
//public class Criteria6_FieldInfoQl implements Serializable {
//	
//	private static final long serialVersionUID = 384884159595539439L;
//
//
//	private CriteriaPrimaryKey criteriaId;
//	
//	@Id
//    @Column(name="unique_key1")
//	private long uniqueKey1;
//	
//	
//	@Column(name = "input611t1")
//    private String input611t1;
//	@Column(name = "responseValue611")
//    private String response611;
//	
//	@Column(name = "input612t1")
//    private String input612t1;
//	@Column(name = "responseValue612")
//    private String response612;
//	
//	@Column(name = "input621t1")
//    private String input621t1;
//	
//	@Column(name = "responseValue621")
//    private String response621;	
//    @Column(name = "input622t1")
//   private String input622t1;
//	@Column(name = "responseValu622")
//   private String response622;
//
//	@Column(name = "input631t1")
//    private String input631t1;
//	@Column(name = "responseValue631")
//    private String response631;
//	
//	@Column(name = "input641t1")
//    private String input641t1;
//	@Column(name = "responseValue641")
//    private String response641;
//	
//	@Column(name = "input643t1")
//    private String input643t1;
//	@Column(name = "responseValue643")
//    private String response643;
//	
//	@Column(name = "input651t1")
//    private String input651t1;
//	@Column(name = "responseValue651")
//    private String response651;
//	
//	@Column(name = "input652t1")
//    private String input652t1;
//	@Column(name = "responseValue652")
//    private String response652;
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
//	public String getInput611t1() {
//		return input611t1;
//	}
//	public void setInput611t1(String input611t1) {
//		this.input611t1 = input611t1;
//	}
//	public String getResponse611() {
//		return response611;
//	}
//	public void setResponse611(String response611) {
//		this.response611 = response611;
//	}
//	public String getInput612t1() {
//		return input612t1;
//	}
//	public void setInput612t1(String input612t1) {
//		this.input612t1 = input612t1;
//	}
//	public String getResponse612() {
//		return response612;
//	}
//	public void setResponse612(String response612) {
//		this.response612 = response612;
//	}
//	public String getInput621t1() {
//		return input621t1;
//	}
//	public void setInput621t1(String input621t1) {
//		this.input621t1 = input621t1;
//	}
//	public String getResponse621() {
//		return response621;
//	}
//	public void setResponse621(String response621) {
//		this.response621 = response621;
//	}
//	public String getInput622t1() {
//		return input622t1;
//	}
//	public void setInput622t1(String input622t1) {
//		this.input622t1 = input622t1;
//	}
//	public String getResponse622() {
//		return response622;
//	}
//	public void setResponse622(String response622) {
//		this.response622 = response622;
//	}
//	public String getInput631t1() {
//		return input631t1;
//	}
//	public void setInput631t1(String input631t1) {
//		this.input631t1 = input631t1;
//	}
//	public String getResponse631() {
//		return response631;
//	}
//	public void setResponse631(String response631) {
//		this.response631 = response631;
//	}
//	public String getInput641t1() {
//		return input641t1;
//	}
//	public void setInput641t1(String input641t1) {
//		this.input641t1 = input641t1;
//	}
//	public String getResponse641() {
//		return response641;
//	}
//	public void setResponse641(String response641) {
//		this.response641 = response641;
//	}
//	public String getInput643t1() {
//		return input643t1;
//	}
//	public void setInput643t1(String input643t1) {
//		this.input643t1 = input643t1;
//	}
//	public String getResponse643() {
//		return response643;
//	}
//	public void setResponse643(String response643) {
//		this.response643 = response643;
//	}
//	public String getInput651t1() {
//		return input651t1;
//	}
//	public void setInput651t1(String input651t1) {
//		this.input651t1 = input651t1;
//	}
//	public String getResponse651() {
//		return response651;
//	}
//	public void setResponse651(String response651) {
//		this.response651 = response651;
//	}
//	public String getInput652t1() {
//		return input652t1;
//	}
//	public void setInput652t1(String input652t1) {
//		this.input652t1 = input652t1;
//	}
//	public String getResponse652() {
//		return response652;
//	}
//	public void setResponse652(String response652) {
//		this.response652 = response652;
//	}
//	public static long getSerialversionuid() {
//		return serialVersionUID;
//	}
//	@Override
//	public int hashCode() {
//		return Objects.hash(criteriaId, input611t1, input612t1, input621t1, input622t1, input631t1, input641t1,
//				input643t1, input651t1, input652t1, response611, response612, response621, response622, response631,
//				response641, response643, response651, response652, uniqueKey1);
//	}
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Criteria6_FieldInfoQl other = (Criteria6_FieldInfoQl) obj;
//		return Objects.equals(criteriaId, other.criteriaId) && Objects.equals(input611t1, other.input611t1)
//				&& Objects.equals(input612t1, other.input612t1) && Objects.equals(input621t1, other.input621t1)
//				&& Objects.equals(input622t1, other.input622t1) && Objects.equals(input631t1, other.input631t1)
//				&& Objects.equals(input641t1, other.input641t1) && Objects.equals(input643t1, other.input643t1)
//				&& Objects.equals(input651t1, other.input651t1) && Objects.equals(input652t1, other.input652t1)
//				&& Objects.equals(response611, other.response611) && Objects.equals(response612, other.response612)
//				&& Objects.equals(response621, other.response621) && Objects.equals(response622, other.response622)
//				&& Objects.equals(response631, other.response631) && Objects.equals(response641, other.response641)
//				&& Objects.equals(response643, other.response643) && Objects.equals(response651, other.response651)
//				&& Objects.equals(response652, other.response652) && uniqueKey1 == other.uniqueKey1;
//	}
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//}
