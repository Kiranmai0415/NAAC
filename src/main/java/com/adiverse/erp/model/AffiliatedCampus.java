package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "affiliated_campus")
public class AffiliatedCampus implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private CriteriaPrimaryKey criteriaId;

	@Id
	@Column(name = "unique_key1")
	private String uniqueKey1;

	@Column(name = "location")
	private String inputst18;

	@Column(name = "campus_area")
	private String inputst19;

	@Column(name = "builtup_area")
	private String inputst20;

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

	public String getInputst18() {
		if(inputst18 !=null) {
		return inputst18;
	}else {
		return "";
	}
	}

	public void setInputst18(String inputst18) {
		this.inputst18 = inputst18;
	}

	public String getInputst19() {
		if(inputst19 !=null) {
		return inputst19;
	}else {
		return "";
	}
	}

	public void setInputst19(String inputst19) {
		this.inputst19 = inputst19;
	}

	public String getInputst20() {
		if(inputst20 !=null) {
		return inputst20;
	}else {
		return "";
	}
	}

	public void setInputst20(String inputst20) {
		this.inputst20 = inputst20;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(criteriaId, inputst18, inputst19, inputst20, uniqueKey1);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AffiliatedCampus other = (AffiliatedCampus) obj;
		return Objects.equals(criteriaId, other.criteriaId) && Objects.equals(inputst18, other.inputst18)
				&& Objects.equals(inputst19, other.inputst19) && Objects.equals(inputst20, other.inputst20)
				&& Objects.equals(uniqueKey1, other.uniqueKey1);
	}

}
