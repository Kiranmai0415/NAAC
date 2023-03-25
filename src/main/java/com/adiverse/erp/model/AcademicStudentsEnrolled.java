package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="academicstudentsenrolled")
public class AcademicStudentsEnrolled implements Serializable
{
	private static final long serialVersionUID = 2458692497580148528L;
	private CriteriaPrimaryKey criteriaId;
	
 	@Id
    @Column(name="unique_key1")
	private long uniqueKey1;
	
	 @Column(name="enrolledProgramme")
	  private String inputas00;
	 
	 @Column(name="locatedCollege")
	  private String inputas11;
	 
	 @Column(name="statesOfindia")
	  private String inputas12;
	 
	 @Column(name="nriStudents")
	  private String inputas13;
	 
	 @Column(name="foreignStudents")
	  private String inputas14;
	 
	 @Column(name="enrolledTotal")
	  private String inputas15;

	

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

	public String getInputas00() {
		if(inputas00 !=null) {
		return inputas00;
	}else {
		return "";
	}
	}

	public void setInputas00(String inputas00) {
		this.inputas00 = inputas00;
	}

	public String getInputas11() {
		if(inputas11 !=null) {
		return inputas11;
	}else {
		return "";
	}
	}

	public void setInputas11(String inputas11) {
		this.inputas11 = inputas11;
	}

	public String getInputas12() {
		if(inputas12 !=null) {
		return inputas12;
	}else {
		return "";
	}
	}

	public void setInputas12(String inputas12) {
		this.inputas12 = inputas12;
	}

	public String getInputas13() {
		if(inputas13 !=null) {
		return inputas13;
	}else {
		return "";
	}
	}

	public void setInputas13(String inputas13) {
		this.inputas13 = inputas13;
	}

	public String getInputas14() {
		if(inputas14 !=null) {
		return inputas14;
	}else {
		return "";
	}
	}

	public void setInputas14(String inputas14) {
		this.inputas14 = inputas14;
	}

	public String getInputas15() {
		if(inputas15 !=null) {
		return inputas15;
	}else {
		return "";
	}
	}

	public void setInputas15(String inputas15) {
		this.inputas15 = inputas15;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(criteriaId, inputas00, inputas11, inputas12, inputas13, inputas14, inputas15, uniqueKey1);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AcademicStudentsEnrolled other = (AcademicStudentsEnrolled) obj;
		return Objects.equals(criteriaId, other.criteriaId) && Objects.equals(inputas00, other.inputas00)
				&& Objects.equals(inputas11, other.inputas11) && Objects.equals(inputas12, other.inputas12)
				&& Objects.equals(inputas13, other.inputas13) && Objects.equals(inputas14, other.inputas14)
				&& Objects.equals(inputas15, other.inputas15) && uniqueKey1 == other.uniqueKey1;
	}


	
}
