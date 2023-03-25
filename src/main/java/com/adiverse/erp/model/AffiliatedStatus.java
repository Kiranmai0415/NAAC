package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "affiliated_status")
public class AffiliatedStatus implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private CriteriaPrimaryKey criteriaId;

	@Id
	@Column(name = "unique_key1")
	private String uniqueKey1;

	
	@Column(name = "college_constituent")
	private String inputst1;

	@Column(name = "typeof_gender")
	private String inputst2;

	@Column(name = "by_gender")
	private String inputst3;

	@Column(name = "by_shift")
	private String inputst4;

	@Column(name = "minority_institution")
	private String inputst5;

	@Column(name = "sourceof_finding")
	private String inputst6;

	@Column(name = "dateof_establishment")
	private String inputst7;

	@Column(name = "governsof_college")
	private String inputst8;

	@Column(name = "act_provide")
	private String inputst11;

	@Column(name = "college_applied")
	private String inputst12;

	@Column(name = "college_potential")
	private String inputst13;

	@Column(name = "dateof_recognition")
	private String inputst14;

	@Column(name = "governmental_agency")
	private String inputst15;

	@Column(name = "nameof_agency")
	private String inputst16;

	@Column(name = "recognition")
	private String inputst17;
	
	public CriteriaPrimaryKey getCriteriaId() {
		return criteriaId;
	}

	public void setCriteriaId(CriteriaPrimaryKey criteriaId) {
		this.criteriaId = criteriaId;
	}

	public String getUniqueKey1() {
		return uniqueKey1;
	}

	public void setUniqueKey1(String uniqueKey1) {
		this.uniqueKey1 = uniqueKey1;
	}


	public String getInputst1() {
		if(inputst1 !=null) {
		return inputst1;
	}else {
		return "";
	}
	}

	public void setInputst1(String inputst1) {
		this.inputst1 = inputst1;
	}

	public String getInputst2() {
		if(inputst2 !=null) {
		return inputst2;
	}else {
		return "";
	}
	}

	public void setInputst2(String inputst2) {
		this.inputst2 = inputst2;
	}

	public String getInputst3() {
		if(inputst3 !=null) {
		return inputst3;
	}else {
		return "";
	}
	}

	public void setInputst3(String inputst3) {
		this.inputst3 = inputst3;
	}

	public String getInputst4() {
		if(inputst4 !=null) {
		return inputst4;
	}else {
		return "";
	}
	}

	public void setInputst4(String inputst4) {
		this.inputst4 = inputst4;
	}

	public String getInputst5() {
		if(inputst5 !=null) {
		return inputst5;
	}else {
		return "";
	}
	}

	public void setInputst5(String inputst5) {
		this.inputst5 = inputst5;
	}

	public String getInputst6() {
		if(inputst6 !=null) {
		return inputst6;
	}else {
		return "";
	}
	}

	public void setInputst6(String inputst6) {
		this.inputst6 = inputst6;
	}

	public String getInputst7() {
		if(inputst7 !=null) {
		return inputst7;
	}else {
		return "";
	}
	}

	public void setInputst7(String inputst7) {
		this.inputst7 = inputst7;
	}

	public String getInputst8() {
		if(inputst8 !=null) {
		return inputst8;
	}else {
		return "";
	}
	}

	public void setInputst8(String inputst8) {
		this.inputst8 = inputst8;
	}

	public String getInputst11() {
		if(inputst11 !=null) {
		return inputst11;
	}else {
		return "";
	}
	}

	public void setInputst11(String inputst11) {
		this.inputst11 = inputst11;
	}

	public String getInputst12() {
		if(inputst12 !=null) {
		return inputst12;
	}else {
		return "";
	}
	}

	public void setInputst12(String inputst12) {
		this.inputst12 = inputst12;
	}

	public String getInputst13() {
		if(inputst13 !=null) {
		return inputst13;
	}else {
		return "";
	}
	}

	public void setInputst13(String inputst13) {
		this.inputst13 = inputst13;
	}

	public String getInputst14() {
		if(inputst14 !=null) {
		return inputst14;
	}else {
		return "";
	}
	}

	public void setInputst14(String inputst14) {
		this.inputst14 = inputst14;
	}

	public String getInputst15() {
		if(inputst15 !=null) {
		return inputst15;
	}else {
		return "";
	}
	}

	public void setInputst15(String inputst15) {
		this.inputst15 = inputst15;
	}

	public String getInputst16() {
		if(inputst16 !=null) {
		return inputst16;
	}else {
		return "";
	}
	}

	public void setInputst16(String inputst16) {
		this.inputst16 = inputst16;
	}

	public String getInputst17() {
		if(inputst17 !=null) {
		return inputst17;
	}else {
		return "";
	}
	}

	public void setInputst17(String inputst17) {
		this.inputst17 = inputst17;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(criteriaId, inputst1, inputst11, inputst12, inputst13, inputst14, inputst15, inputst16,
				inputst17, inputst2, inputst3, inputst4, inputst5, inputst6, inputst7, inputst8, uniqueKey1);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AffiliatedStatus other = (AffiliatedStatus) obj;
		return Objects.equals(criteriaId, other.criteriaId) && Objects.equals(inputst1, other.inputst1)
				&& Objects.equals(inputst11, other.inputst11) && Objects.equals(inputst12, other.inputst12)
				&& Objects.equals(inputst13, other.inputst13) && Objects.equals(inputst14, other.inputst14)
				&& Objects.equals(inputst15, other.inputst15) && Objects.equals(inputst16, other.inputst16)
				&& Objects.equals(inputst17, other.inputst17) && Objects.equals(inputst2, other.inputst2)
				&& Objects.equals(inputst3, other.inputst3) && Objects.equals(inputst4, other.inputst4)
				&& Objects.equals(inputst5, other.inputst5) && Objects.equals(inputst6, other.inputst6)
				&& Objects.equals(inputst7, other.inputst7) && Objects.equals(inputst8, other.inputst8)
				&& Objects.equals(uniqueKey1, other.uniqueKey1);
	}

}
