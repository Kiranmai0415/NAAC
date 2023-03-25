package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "awards_recognition")
public class AwardsandRecognition implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public CriteriaPrimaryKey criteriaId;
	
	@Id
    @Column(name="unique_key1")
	private long uniqueKey1;
	
	@Column(name = "nameofthe_activity")
	private String inputart1;
	
	@Column(name = "dept")
	private String inputart2;
	
	@Column(name = "schools_name")
	private String inputart3;
	
	@Column(name = "nameofthe_award")
	private String inputart4;
	
	@Column(name = "nameof_awarding_govt_recog_bodies")
	private String inputart5;
	
	@Column(name = "yearof_award")
	private String inputart6;

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

	public String getInputart1() {
		if(inputart1 !=null) {
		return inputart1;
	}else {
		return "";
	}
	}

	public void setInputart1(String inputart1) {
		this.inputart1 = inputart1;
	}

	public String getInputart2() {
		if(inputart2 !=null) {
		return inputart2;
	}else {
		return "";
	}
	}

	public void setInputart2(String inputart2) {
		this.inputart2 = inputart2;
	}

	public String getInputart3() {
		if(inputart3 !=null) {
		return inputart3;
	}else {
		return "";
	}
	}

	public void setInputart3(String inputart3) {
		this.inputart3 = inputart3;
	}

	public String getInputart4() {
		if(inputart4 !=null) {
		return inputart4;
	}else {
		return "";
	}
	}

	public void setInputart4(String inputart4) {
		this.inputart4 = inputart4;
	}

	public String getInputart5() {
		if(inputart5 !=null) {
		return inputart5;
	}else {
		return "";
	}
	}

	public void setInputart5(String inputart5) {
		this.inputart5 = inputart5;
	}

	public String getInputart6() {
		if(inputart6 !=null) {
		return inputart6;
	
		}else {
			return "";
		}
		}
	
	public void setInputart6(String inputart6) {
		this.inputart6 = inputart6;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(criteriaId, inputart1, inputart2, inputart3, inputart4, inputart5, inputart6, uniqueKey1);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AwardsandRecognition other = (AwardsandRecognition) obj;
		return Objects.equals(criteriaId, other.criteriaId) && Objects.equals(inputart1, other.inputart1)
				&& Objects.equals(inputart2, other.inputart2) && Objects.equals(inputart3, other.inputart3)
				&& Objects.equals(inputart4, other.inputart4) && Objects.equals(inputart5, other.inputart5)
				&& Objects.equals(inputart6, other.inputart6) && uniqueKey1 == other.uniqueKey1;
	}

	
	
}
