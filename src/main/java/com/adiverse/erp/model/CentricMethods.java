package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "centric_methods")
public class CentricMethods implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private CriteriaPrimaryKey criteriaId;
	
	@Id
	@Column(name = "unique_key1")
	private long uniqueKey1;
	
	@Column(name = "nameof_faculty")
	private String inputcmt1;
	
	@Column(name = "course_name")
	private String inputcmt2;
	
	@Column(name = "dept")
	private String inputcmt3;
	
	@Column(name = "school_name")
	private String inputcmt4;

	@Column(name = "centric_type")
	private String inputcmt5;

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

	public String getInputcmt1() {
		if(inputcmt1 !=null) {
		return inputcmt1;
	}else {
		return "";
	}
	}

	public void setInputcmt1(String inputcmt1) {
		this.inputcmt1 = inputcmt1;
	}

	public String getInputcmt2() {
		if(inputcmt2 !=null) {
		return inputcmt2;
	}else {
		return "";
	}
	}

	public void setInputcmt2(String inputcmt2) {
		this.inputcmt2 = inputcmt2;
	}

	public String getInputcmt3() {
		if(inputcmt3 !=null) {
		return inputcmt3;
	}else {
		return "";
	}
	}

	public void setInputcmt3(String inputcmt3) {
		this.inputcmt3 = inputcmt3;
	}

	public String getInputcmt4() {
		if(inputcmt4 !=null) {
		return inputcmt4;
	}else {
		return "";
	}
	}

	public void setInputcmt4(String inputcmt4) {
		this.inputcmt4 = inputcmt4;
	}

	public String getInputcmt5() {
		if(inputcmt5 !=null) {
		return inputcmt5;
	}else {
		return "";
	}
	}

	public void setInputcmt5(String inputcmt5) {
		this.inputcmt5 = inputcmt5;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(criteriaId, inputcmt1, inputcmt2, inputcmt3, inputcmt4, inputcmt5, uniqueKey1);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CentricMethods other = (CentricMethods) obj;
		return Objects.equals(criteriaId, other.criteriaId) && Objects.equals(inputcmt1, other.inputcmt1)
				&& Objects.equals(inputcmt2, other.inputcmt2) && Objects.equals(inputcmt3, other.inputcmt3)
				&& Objects.equals(inputcmt4, other.inputcmt4) && Objects.equals(inputcmt5, other.inputcmt5)
				&& uniqueKey1 == other.uniqueKey1;
	}
	
	
	
	
	
	

}
