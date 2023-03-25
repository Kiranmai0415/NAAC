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
//@Table(name ="criteria6Qn_fieldinfo")
//public class Criteria6_FieldInfoQn implements Serializable {
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
//	@Column(name = "input622t1")
//    private String input622t1;
//	@Column(name = "responseValu622")
//    private String response622;
//
//	@Column(name = "responseValue623")
//    private String response623;
//	@Column(name = "input623t1")
//    private String input623t1;
//	
//	
//	@Column(name = "input632t1")
//    private String input632t1;
//	@Column(name = "responseValue632")
//    private String response632;
//	
//	
//	@Column(name = "input6333t1")
//    private String input6333t1;
//	
//	public String getInput6333t1() {
//		return input6333t1;
//	}
//	public void setInput6333t1(String input6333t1) {
//		this.input6333t1 = input6333t1;
//	}
//	@Column(name = "responseValue633")
//    private String response633;
//	
//	@Column(name = "responseValue634")
//    private String response634;
//	
//	
//	@Column(name = "responseValue642")
//    private String response642;
//	
//	
//	@Column(name = "responseValue652")
//    private String response652;
//	@Column(name = "input652t1")
//    private String input652t1;
//	
//	
//	
//	@Column(name = "responseValue653")
//    private String response653;
//	@Column(name = "input653t1")
//    private String input653t1;
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
//	public String getResponse623() {
//		return response623;
//	}
//	public void setResponse623(String response623) {
//		this.response623 = response623;
//	}
//	public String getInput623t1() {
//		return input623t1;
//	}
//	public void setInput623t1(String input623t1) {
//		this.input623t1 = input623t1;
//	}
//	public String getResponse632() {
//		return response632;
//	}
//	public void setResponse632(String response632) {
//		this.response632 = response632;
//	}
//	public String getResponse633() {
//		return response633;
//	}
//	public void setResponse633(String response633) {
//		this.response633 = response633;
//	}
//	public String getResponse634() {
//		return response634;
//	}
//	public void setResponse634(String response634) {
//		this.response634 = response634;
//	}
//	public String getResponse642() {
//		return response642;
//	}
//	public void setResponse642(String response642) {
//		this.response642 = response642;
//	}
//	public String getResponse653() {
//		return response653;
//	}
//	public void setResponse653(String response653) {
//		this.response653 = response653;
//	}
//	public String getInput653t1() {
//		return input653t1;
//	}
//	public void setInput653t1(String input653t1) {
//		this.input653t1 = input653t1;
//	}
//	public static long getSerialversionuid() {
//		return serialVersionUID;
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
//	public String getInput632t1() {
//		return input632t1;
//	}
//	public void setInput632t1(String input632t1) {
//		this.input632t1 = input632t1;
//	}
//	public String getResponse652() {
//		return response652;
//	}
//	public void setResponse652(String response652) {
//		this.response652 = response652;
//	}
//	public String getInput652t1() {
//		return input652t1;
//	}
//	public void setInput652t1(String input652t1) {
//		this.input652t1 = input652t1;
//	}
//	@Override
//	public int hashCode() {
//		return Objects.hash(criteriaId, input622t1, input623t1, input632t1, input6333t1, input652t1, input653t1,
//				response622, response623, response632, response633, response634, response642, response652, response653,
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
//		Criteria6_FieldInfoQn other = (Criteria6_FieldInfoQn) obj;
//		return Objects.equals(criteriaId, other.criteriaId) && Objects.equals(input622t1, other.input622t1)
//				&& Objects.equals(input623t1, other.input623t1) && Objects.equals(input632t1, other.input632t1)
//				&& Objects.equals(input6333t1, other.input6333t1) && Objects.equals(input652t1, other.input652t1)
//				&& Objects.equals(input653t1, other.input653t1) && Objects.equals(response622, other.response622)
//				&& Objects.equals(response623, other.response623) && Objects.equals(response632, other.response632)
//				&& Objects.equals(response633, other.response633) && Objects.equals(response634, other.response634)
//				&& Objects.equals(response642, other.response642) && Objects.equals(response652, other.response652)
//				&& Objects.equals(response653, other.response653) && uniqueKey1 == other.uniqueKey1;
//	}
//	
//	
//
//	
//	
//	
//	
//}