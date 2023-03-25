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
//@Entity
//@Table(name="academic_teachingStaff")
//public class AcademicTeachingStaff implements Serializable
//{
//	
//
//	/**
//	 * 
//	 */
//	private static final long serialVersionUID = 1L;
//
//	private CriteriaPrimaryKey criteriaId;
//	
// 	@Id
//    @Column(name="unique_key1")
//	private long uniqueKey1;
//	
//	@Column(name="teachers_qualification")
//	private String inputatq00;
//	
//	//Permanent Teachers Table
//	@Column(name="permanent_professor_male")
//	private String inputatq11;
//	@Column(name="permanent_professor_female")
//	private String inputatq12;
//	@Column(name="permanent_professor_others")
//	private String inputatq13;
//
//	@Column(name="permanent_associate_male")
//	private String inputatq14;
//	@Column(name="permanent_associate_female")
//	private String inputatq15;
//	@Column(name="permanent_associate_others")
//	private String inputatq16;
//	
//	@Column(name="permanent_assistant_male")
//	private String inputatq17;
//	@Column(name="permanent_assistant_female")
//	private String inputatq18;
//	@Column(name="permanent_assistant_others")
//	private String inputatq19;
//	
//	@Column(name="permanent_total")
//	private String inputatq110;
//	
//	//Temporary Teachers Table
//	@Column(name="temporary_professor_male")
//	private String inputatq51;
//	@Column(name="temporary_professor_female")
//	private String inputatq52;
//	@Column(name="temporary_professor_others")
//	private String inputatq53;
//
//	@Column(name="temporary_associate_male")
//	private String inputatq54;
//	@Column(name="temporary_associate_female")
//	private String inputatq55;
//	@Column(name="temporary_associate_others")
//	private String inputatq56;
//	
//	@Column(name="temporary_assistant_male")
//	private String inputatq57;
//	@Column(name="temporary_assistant_female")
//	private String inputatq58;
//	@Column(name="temporary_assistant_others")
//	private String inputatq59;
//	
//	@Column(name="temporary_total")
//	private String inputatq510;
//	
//	//Part-Time Teahers Table
//	@Column(name="parttime_professor_male")
//	private String inputatq91;
//	@Column(name="parttime_professor_female")
//	private String inputatq92;
//	@Column(name="parttime_professor_others")
//	private String inputatq93;
//
//	@Column(name="parttime_associate_male")
//	private String inputatq94;
//	@Column(name="parttime_associate_female")
//	private String inputatq95;
//	@Column(name="parttime_associate_others")
//	private String inputatq96;
//	
//	@Column(name="parttime_assistant_male")
//	private String inputatq97;
//	@Column(name="parttime_assistant_female")
//	private String inputatq98;
//	@Column(name="parttime_assistant_others")
//	private String inputatq99;
//	
//	@Column(name="parttime_total")
//	private String inputatq910;
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
//	public String getInputatq00() {
//		return inputatq00;
//	}
//
//	public void setInputatq00(String inputatq00) {
//		this.inputatq00 = inputatq00;
//	}
//
//	public String getInputatq11() {
//		return inputatq11;
//	}
//
//	public void setInputatq11(String inputatq11) {
//		this.inputatq11 = inputatq11;
//	}
//
//	public String getInputatq12() {
//		return inputatq12;
//	}
//
//	public void setInputatq12(String inputatq12) {
//		this.inputatq12 = inputatq12;
//	}
//
//	public String getInputatq13() {
//		return inputatq13;
//	}
//
//	public void setInputatq13(String inputatq13) {
//		this.inputatq13 = inputatq13;
//	}
//
//	public String getInputatq14() {
//		return inputatq14;
//	}
//
//	public void setInputatq14(String inputatq14) {
//		this.inputatq14 = inputatq14;
//	}
//
//	public String getInputatq15() {
//		return inputatq15;
//	}
//
//	public void setInputatq15(String inputatq15) {
//		this.inputatq15 = inputatq15;
//	}
//
//	public String getInputatq16() {
//		return inputatq16;
//	}
//
//	public void setInputatq16(String inputatq16) {
//		this.inputatq16 = inputatq16;
//	}
//
//	public String getInputatq17() {
//		return inputatq17;
//	}
//
//	public void setInputatq17(String inputatq17) {
//		this.inputatq17 = inputatq17;
//	}
//
//	public String getInputatq18() {
//		return inputatq18;
//	}
//
//	public void setInputatq18(String inputatq18) {
//		this.inputatq18 = inputatq18;
//	}
//
//	public String getInputatq19() {
//		return inputatq19;
//	}
//
//	public void setInputatq19(String inputatq19) {
//		this.inputatq19 = inputatq19;
//	}
//
//	public String getInputatq110() {
//		return inputatq110;
//	}
//
//	public void setInputatq110(String inputatq110) {
//		this.inputatq110 = inputatq110;
//	}
//
//	public String getInputatq51() {
//		return inputatq51;
//	}
//
//	public void setInputatq51(String inputatq51) {
//		this.inputatq51 = inputatq51;
//	}
//
//	public String getInputatq52() {
//		return inputatq52;
//	}
//
//	public void setInputatq52(String inputatq52) {
//		this.inputatq52 = inputatq52;
//	}
//
//	public String getInputatq53() {
//		return inputatq53;
//	}
//
//	public void setInputatq53(String inputatq53) {
//		this.inputatq53 = inputatq53;
//	}
//
//	public String getInputatq54() {
//		return inputatq54;
//	}
//
//	public void setInputatq54(String inputatq54) {
//		this.inputatq54 = inputatq54;
//	}
//
//	public String getInputatq55() {
//		return inputatq55;
//	}
//
//	public void setInputatq55(String inputatq55) {
//		this.inputatq55 = inputatq55;
//	}
//
//	public String getInputatq56() {
//		return inputatq56;
//	}
//
//	public void setInputatq56(String inputatq56) {
//		this.inputatq56 = inputatq56;
//	}
//
//	public String getInputatq57() {
//		return inputatq57;
//	}
//
//	public void setInputatq57(String inputatq57) {
//		this.inputatq57 = inputatq57;
//	}
//
//	public String getInputatq58() {
//		return inputatq58;
//	}
//
//	public void setInputatq58(String inputatq58) {
//		this.inputatq58 = inputatq58;
//	}
//
//	public String getInputatq59() {
//		return inputatq59;
//	}
//
//	public void setInputatq59(String inputatq59) {
//		this.inputatq59 = inputatq59;
//	}
//
//	public String getInputatq510() {
//		return inputatq510;
//	}
//
//	public void setInputatq510(String inputatq510) {
//		this.inputatq510 = inputatq510;
//	}
//
//	public String getInputatq91() {
//		return inputatq91;
//	}
//
//	public void setInputatq91(String inputatq91) {
//		this.inputatq91 = inputatq91;
//	}
//
//	public String getInputatq92() {
//		return inputatq92;
//	}
//
//	public void setInputatq92(String inputatq92) {
//		this.inputatq92 = inputatq92;
//	}
//
//	public String getInputatq93() {
//		return inputatq93;
//	}
//
//	public void setInputatq93(String inputatq93) {
//		this.inputatq93 = inputatq93;
//	}
//
//	public String getInputatq94() {
//		return inputatq94;
//	}
//
//	public void setInputatq94(String inputatq94) {
//		this.inputatq94 = inputatq94;
//	}
//
//	public String getInputatq95() {
//		return inputatq95;
//	}
//
//	public void setInputatq95(String inputatq95) {
//		this.inputatq95 = inputatq95;
//	}
//
//	public String getInputatq96() {
//		return inputatq96;
//	}
//
//	public void setInputatq96(String inputatq96) {
//		this.inputatq96 = inputatq96;
//	}
//
//	public String getInputatq97() {
//		return inputatq97;
//	}
//
//	public void setInputatq97(String inputatq97) {
//		this.inputatq97 = inputatq97;
//	}
//
//	public String getInputatq98() {
//		return inputatq98;
//	}
//
//	public void setInputatq98(String inputatq98) {
//		this.inputatq98 = inputatq98;
//	}
//
//	public String getInputatq99() {
//		return inputatq99;
//	}
//
//	public void setInputatq99(String inputatq99) {
//		this.inputatq99 = inputatq99;
//	}
//
//	public String getInputatq910() {
//		return inputatq910;
//	}
//
//	public void setInputatq910(String inputatq910) {
//		this.inputatq910 = inputatq910;
//	}
//
//	public static long getSerialversionuid() {
//		return serialVersionUID;
//	}
//
//	@Override
//	public int hashCode() {
//		return Objects.hash(criteriaId, inputatq00, inputatq11, inputatq110, inputatq12, inputatq13, inputatq14,
//				inputatq15, inputatq16, inputatq17, inputatq18, inputatq19, inputatq51, inputatq510, inputatq52,
//				inputatq53, inputatq54, inputatq55, inputatq56, inputatq57, inputatq58, inputatq59, inputatq91,
//				inputatq910, inputatq92, inputatq93, inputatq94, inputatq95, inputatq96, inputatq97, inputatq98,
//				inputatq99, uniqueKey1);
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
//		AcademicTeachingStaff other = (AcademicTeachingStaff) obj;
//		return Objects.equals(criteriaId, other.criteriaId) && Objects.equals(inputatq00, other.inputatq00)
//				&& Objects.equals(inputatq11, other.inputatq11) && Objects.equals(inputatq110, other.inputatq110)
//				&& Objects.equals(inputatq12, other.inputatq12) && Objects.equals(inputatq13, other.inputatq13)
//				&& Objects.equals(inputatq14, other.inputatq14) && Objects.equals(inputatq15, other.inputatq15)
//				&& Objects.equals(inputatq16, other.inputatq16) && Objects.equals(inputatq17, other.inputatq17)
//				&& Objects.equals(inputatq18, other.inputatq18) && Objects.equals(inputatq19, other.inputatq19)
//				&& Objects.equals(inputatq51, other.inputatq51) && Objects.equals(inputatq510, other.inputatq510)
//				&& Objects.equals(inputatq52, other.inputatq52) && Objects.equals(inputatq53, other.inputatq53)
//				&& Objects.equals(inputatq54, other.inputatq54) && Objects.equals(inputatq55, other.inputatq55)
//				&& Objects.equals(inputatq56, other.inputatq56) && Objects.equals(inputatq57, other.inputatq57)
//				&& Objects.equals(inputatq58, other.inputatq58) && Objects.equals(inputatq59, other.inputatq59)
//				&& Objects.equals(inputatq91, other.inputatq91) && Objects.equals(inputatq910, other.inputatq910)
//				&& Objects.equals(inputatq92, other.inputatq92) && Objects.equals(inputatq93, other.inputatq93)
//				&& Objects.equals(inputatq94, other.inputatq94) && Objects.equals(inputatq95, other.inputatq95)
//				&& Objects.equals(inputatq96, other.inputatq96) && Objects.equals(inputatq97, other.inputatq97)
//				&& Objects.equals(inputatq98, other.inputatq98) && Objects.equals(inputatq99, other.inputatq99)
//				&& uniqueKey1 == other.uniqueKey1;
//	}
//
//
//
//	
//}
