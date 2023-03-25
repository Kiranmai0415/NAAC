package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="academiciansappointed")
public class AcademiciansAppointed implements Serializable
{
	private static final long serialVersionUID = -2231411273570309611L;

	private CriteriaPrimaryKey criteriaId;
	
 	@Id
    @Column(name="unique_key1")
	private long uniqueKey1;
	
	
	@Column(name="academicians_male")
	private String inputaa1t1;
	
	@Column(name="academicians_female")
	private String inputaa1t2;
	
	@Column(name="academicians_others")
	private String inputaa1t3;
	
	@Column(name="academicians_total")
	private String inputaa1t4;

	
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

	public String getInputaa1t1() {
		if(inputaa1t1 !=null) {
		return inputaa1t1;
	}else {
		return "";
	}
	}

	public void setInputaa1t1(String inputaa1t1) {
		this.inputaa1t1 = inputaa1t1;
	}

	public String getInputaa1t2() {
		if(inputaa1t2 !=null) {
		return inputaa1t2;
	}else {
		return "";
	}
	}

	public void setInputaa1t2(String inputaa1t2) {
		this.inputaa1t2 = inputaa1t2;
	}

	public String getInputaa1t3() {
		if(inputaa1t3 !=null) {
		return inputaa1t3;
	}else {
		return "";
	}
	}

	public void setInputaa1t3(String inputaa1t3) {
		this.inputaa1t3 = inputaa1t3;
	}

	public String getInputaa1t4() {
		if(inputaa1t4 !=null) {
		return inputaa1t4;
		}else {
			return "";
		}
	}

	public void setInputaa1t4(String inputaa1t4) {
		this.inputaa1t4 = inputaa1t4;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(criteriaId, inputaa1t1, inputaa1t2, inputaa1t3, inputaa1t4, uniqueKey1);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AcademiciansAppointed other = (AcademiciansAppointed) obj;
		return Objects.equals(criteriaId, other.criteriaId) && Objects.equals(inputaa1t1, other.inputaa1t1)
				&& Objects.equals(inputaa1t2, other.inputaa1t2) && Objects.equals(inputaa1t3, other.inputaa1t3)
				&& Objects.equals(inputaa1t4, other.inputaa1t4) && uniqueKey1 == other.uniqueKey1;
	}
	
	
	

}