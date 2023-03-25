package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="affiliated_enrollment")
public class AffiliatedEnrollment implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

private CriteriaPrimaryKey criteriaId;
	
    @Id
    @Column(name="unique_key1")
	private String uniqueKey1;
    
 
	
	@Column(name = "typeofstudents")
    private String inputet1;
	
	@Column(name = "enrollment_ug")
    private String inputet2;
	
	@Column(name = "enrollment_pg")
    private String inputet3;
	
	@Column(name = "enrollment_mphil")
    private String inputet4;
	
	@Column(name = "enrollment_phd")
    private String inputet5;

	@Column(name = "enrollment_total")
    private String inputet6;

	
	public String getInputet1() {
		if(inputet1 !=null) {
		return inputet1;
	}else {
		return "";
	}
	}

	public void setInputet1(String inputet1) {
		this.inputet1 = inputet1;
	}

	public String getInputet2() {
		if(inputet2 !=null) {
		return inputet2;
	}else {
		return "";
	}
	}

	public void setInputet2(String inputet2) {
		this.inputet2 = inputet2;
	}

	public String getInputet3() {
		if(inputet3 !=null) {
		return inputet3;
	}else {
		return "";
	}
	}

	public void setInputet3(String inputet3) {
		this.inputet3 = inputet3;
	}

	public String getInputet4() {
		if(inputet4 !=null) {
		return inputet4;
	}else {
		return "";
	}
	}

	public void setInputet4(String inputet4) {
		this.inputet4 = inputet4;
	}

	public String getInputet5() {
		if(inputet5 !=null) {
		return inputet5;
	}else {
		return "";
	}
	}

	public void setInputet5(String inputet5) {
		this.inputet5 = inputet5;
	}

	public String getInputet6() {
		if(inputet6 !=null) {
		return inputet6;
	}else {
		return "";
	}
	}

	public void setInputet6(String inputet6) {
		this.inputet6 = inputet6;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

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

	@Override
	public int hashCode() {
		return Objects.hash(criteriaId, inputet1, inputet2, inputet3, inputet4, inputet5, inputet6, uniqueKey1);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AffiliatedEnrollment other = (AffiliatedEnrollment) obj;
		return Objects.equals(criteriaId, other.criteriaId) && Objects.equals(inputet1, other.inputet1)
				&& Objects.equals(inputet2, other.inputet2) && Objects.equals(inputet3, other.inputet3)
				&& Objects.equals(inputet4, other.inputet4) && Objects.equals(inputet5, other.inputet5)
				&& Objects.equals(inputet6, other.inputet6) && Objects.equals(uniqueKey1, other.uniqueKey1);
	}

	

	
	
	
	
}	

	
	
	
	

