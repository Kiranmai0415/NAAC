package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="affiliated_education")
public class AffiliatedEducation implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

     private CriteriaPrimaryKey criteriaId;
	
    @Id
    @Column(name="unique_key1")
	private String uniqueKey1;
	
   
	
	@Column(name = "unitcostof_education")
    private String inputct1;
	
	@Column(name = "salary_component")
    private String inputct2;
	
	@Column(name = "excluding_component")
    private String inputct3;

	

	public String getInputct1() {
		if(inputct1 !=null) {
		return inputct1;
	}else {
		return "";
	}
	}

	public void setInputct1(String inputct1) {
		this.inputct1 = inputct1;
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

	public String getInputct2() {
		if(inputct2 !=null) {
		return inputct2;
	}else {
		return "";
	}
	}

	public void setInputct2(String inputct2) {
		this.inputct2 = inputct2;
	}

	public String getInputct3() {
		if(inputct3 !=null) {
		return inputct3;
	}else {
		return "";
	}
	}

	public void setInputct3(String inputct3) {
		this.inputct3 = inputct3;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(criteriaId, inputct1, inputct2, inputct3, uniqueKey1);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AffiliatedEducation other = (AffiliatedEducation) obj;
		return Objects.equals(criteriaId, other.criteriaId) && Objects.equals(inputct1, other.inputct1)
				&& Objects.equals(inputct2, other.inputct2) && Objects.equals(inputct3, other.inputct3)
				&& Objects.equals(uniqueKey1, other.uniqueKey1);
	}

	
	
	
	
}	

	
	
	
	

