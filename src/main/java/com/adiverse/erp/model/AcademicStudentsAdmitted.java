package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="academic_studentsadmitted")
public class AcademicStudentsAdmitted implements Serializable
{
	private static final long serialVersionUID = 2458692497580148528L;
	private CriteriaPrimaryKey criteriaId;
	
 	@Id
    @Column(name="unique_key1")
	private long uniqueKey1;
	
	 @Column(name="admittedProgramme")
	  private String inputaa00;
	 
	 
	 @Column(name="year1")
	 private String inputaa11;
	 
	  @Column(name="year2")
	  private String inputaa12;
	 
	 @Column(name="year3")
	  private String inputaa13;
	 
	 @Column(name="year4")
	  private String inputaa14;

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

	public String getInputaa00() {
		if(inputaa00 !=null) {
		return inputaa00;
	}else {
		return "";
	}
	}

	public void setInputaa00(String inputaa00) {
		this.inputaa00 = inputaa00;
	}

	public String getInputaa11() {
		if(inputaa11 !=null) {
		return inputaa11;
	}else {
		return "";
	}
	}

	public void setInputaa11(String inputaa11) {
		this.inputaa11 = inputaa11;
	}

	public String getInputaa12() {
		if(inputaa12 !=null) {
		return inputaa12;
	}else {
		return "";
	}
	}

	public void setInputaa12(String inputaa12) {
		this.inputaa12 = inputaa12;
	}

	public String getInputaa13() {
		if(inputaa13 !=null) {
		return inputaa13;
	}else {
		return "";
	}
	}

	public void setInputaa13(String inputaa13) {
		this.inputaa13 = inputaa13;
	}

	public String getInputaa14() {
		if(inputaa14 !=null) {
		return inputaa14;
	}else {
		return "";
	}
	}

	public void setInputaa14(String inputaa14) {
		this.inputaa14 = inputaa14;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(criteriaId, inputaa00, inputaa11, inputaa12, inputaa13, inputaa14, uniqueKey1);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AcademicStudentsAdmitted other = (AcademicStudentsAdmitted) obj;
		return Objects.equals(criteriaId, other.criteriaId) && Objects.equals(inputaa00, other.inputaa00)
				&& Objects.equals(inputaa11, other.inputaa11) && Objects.equals(inputaa12, other.inputaa12)
				&& Objects.equals(inputaa13, other.inputaa13) && Objects.equals(inputaa14, other.inputaa14)
				&& uniqueKey1 == other.uniqueKey1;
	}

	
	 


}
