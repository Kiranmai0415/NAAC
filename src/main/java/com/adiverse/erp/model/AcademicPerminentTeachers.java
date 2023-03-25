package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="academic_perminentTeachers")
public class AcademicPerminentTeachers implements Serializable
{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private CriteriaPrimaryKey criteriaId;
	
 	@Id
    @Column(name="unique_key1")
	private long uniqueKey1;
	
	

	@Column(name="permanent_professor_male")
	private String inputatq11;
	@Column(name="permanent_professor_female")
	private String inputatq12;
	@Column(name="permanent_professor_others")
	private String inputatq13;

	@Column(name="permanent_associate_male")
	private String inputatq14;
	@Column(name="permanent_associate_female")
	private String inputatq15;
	@Column(name="permanent_associate_others")
	private String inputatq16;
	
	@Column(name="permanent_assistant_male")
	private String inputatq17;
	@Column(name="permanent_assistant_female")
	private String inputatq18;
	@Column(name="permanent_assistant_others")
	private String inputatq19;
	
	@Column(name="permanent_total")
	private String inputatq110;

	public CriteriaPrimaryKey getCriteriaId() {
		return criteriaId;
	}

	public void setCriteriaId(CriteriaPrimaryKey criteriaId) {
		this.criteriaId = criteriaId;
	}

	public long getUniqueKey1() {
		return uniqueKey1;
	}

	public void setUniqueKey1(long uniqueKey1) {
		this.uniqueKey1 = uniqueKey1;
	}

	public String getInputatq11() {
		if(inputatq11 !=null) {
		return inputatq11;
	}else {
		return "";
	}
	}

	public void setInputatq11(String inputatq11) {
		this.inputatq11 = inputatq11;
	}

	public String getInputatq12() {
		if(inputatq12 !=null) {
		return inputatq12;
	}else {
		return "";
	}
	}

	public void setInputatq12(String inputatq12) {
		this.inputatq12 = inputatq12;
	}

	public String getInputatq13() {
		if(inputatq13 !=null) {
		return inputatq13;
	}else {
		return "";
	}
	}

	public void setInputatq13(String inputatq13) {
		this.inputatq13 = inputatq13;
	}

	public String getInputatq14() {
		if(inputatq14 !=null) {
		return inputatq14;
	}else {
		return "";
	}
	}

	public void setInputatq14(String inputatq14) {
		this.inputatq14 = inputatq14;
	}

	public String getInputatq15() {
	if(inputatq15 !=null) {
		return inputatq15;
	}else {
		return "";
	}
	}

	public void setInputatq15(String inputatq15) {
		this.inputatq15 = inputatq15;
	}

	public String getInputatq16() {
		if(inputatq16 !=null) {
		return inputatq16;
	}else {
		return "";
	}
	}

	public void setInputatq16(String inputatq16) {
		this.inputatq16 = inputatq16;
	}

	public String getInputatq17() {
		if(inputatq17 !=null) {
		return inputatq17;
	}else {
		return "";
	}
	}

	public void setInputatq17(String inputatq17) {
		this.inputatq17 = inputatq17;
	}

	public String getInputatq18() {
		if(inputatq18 !=null) {
		return inputatq18;
	}else {
		return "";
	}
	}

	public void setInputatq18(String inputatq18) {
		this.inputatq18 = inputatq18;
	}

	public String getInputatq19() {
		if(inputatq19 !=null) {
		return inputatq19;
	}else {
		return "";
	}
	}

	public void setInputatq19(String inputatq19) {
		this.inputatq19 = inputatq19;
	}

	public String getInputatq110() {
		if(inputatq110 !=null) {
		return inputatq110;
	}else {
		return "";
	}
	}

	public void setInputatq110(String inputatq110) {
		this.inputatq110 = inputatq110;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(criteriaId, inputatq11, inputatq110, inputatq12, inputatq13, inputatq14, inputatq15,
				inputatq16, inputatq17, inputatq18, inputatq19, uniqueKey1);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AcademicPerminentTeachers other = (AcademicPerminentTeachers) obj;
		return Objects.equals(criteriaId, other.criteriaId) && Objects.equals(inputatq11, other.inputatq11)
				&& Objects.equals(inputatq110, other.inputatq110) && Objects.equals(inputatq12, other.inputatq12)
				&& Objects.equals(inputatq13, other.inputatq13) && Objects.equals(inputatq14, other.inputatq14)
				&& Objects.equals(inputatq15, other.inputatq15) && Objects.equals(inputatq16, other.inputatq16)
				&& Objects.equals(inputatq17, other.inputatq17) && Objects.equals(inputatq18, other.inputatq18)
				&& Objects.equals(inputatq19, other.inputatq19) && uniqueKey1 == other.uniqueKey1;
	}
	
	
	
	
}