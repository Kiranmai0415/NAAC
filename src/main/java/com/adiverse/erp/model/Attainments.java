package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "attainments")
public class Attainments implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private CriteriaPrimaryKey criteriaId;
	
	@Id
	@Column(name = "unique_key1")
	private long uniqueKey1;

	@Column(name = "nameof_faculty")
	private String inputat1;
	
	@Column(name = "dept")
	private String inputat2;
	
	@Column(name = "school_name")
	private String inputat3;
	
	@Column(name = "at_outcomes")
	private String inputat4;

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

	public String getInputat1() {
		if(inputat1 !=null) {
		return inputat1;
	}else {
		return "";
	}
	}

	public void setInputat1(String inputat1) {
		this.inputat1 = inputat1;
	}

	public String getInputat2() {
		if(inputat2 !=null) {
		return inputat2;
	}else {
		return "";
	}
	}

	public void setInputat2(String inputat2) {
		this.inputat2 = inputat2;
	}

	public String getInputat3() {
		if(inputat3 !=null) {
		return inputat3;
	}else {
		return "";
	}
	}

	public void setInputat3(String inputat3) {
		this.inputat3 = inputat3;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getInputat4() {
		return inputat4;
	}

	public void setInputat4(String inputat4) {
		this.inputat4 = inputat4;
	}

	@Override
	public int hashCode() {
		return Objects.hash(criteriaId, inputat1, inputat2, inputat3, inputat4, uniqueKey1);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Attainments other = (Attainments) obj;
		return Objects.equals(criteriaId, other.criteriaId) && Objects.equals(inputat1, other.inputat1)
				&& Objects.equals(inputat2, other.inputat2) && Objects.equals(inputat3, other.inputat3)
				&& Objects.equals(inputat4, other.inputat4) && uniqueKey1 == other.uniqueKey1;
	}

	
	
	
	
	


}
