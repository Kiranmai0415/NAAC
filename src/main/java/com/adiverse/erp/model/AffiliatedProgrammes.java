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
@Table(name ="affiliated_Programmes")
public class AffiliatedProgrammes implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

   private CriteriaPrimaryKey criteriaId;
	
    @Id
    @Column(name="unique_key1")
	private String uniqueKey1;

	
	@Column(name = "selffinanced_offered")
    private String inputpt1;
	
	@Column(name = "newprogrammes_introduced")
    private String inputpt2;

	

	public String getInputpt1() {
		if(inputpt1 !=null) {
		return inputpt1;
	}else {
		return "";
	}
	}

	public void setInputpt1(String inputpt1) {
		this.inputpt1 = inputpt1;
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

	public String getInputpt2() {
		if(inputpt2 !=null) {
		return inputpt2;
	}else {
		return "";
	}
	}

	public void setInputpt2(String inputpt2) {
		this.inputpt2 = inputpt2;
	}

	@Override
	public int hashCode() {
		return Objects.hash(criteriaId, inputpt1, inputpt2, uniqueKey1);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AffiliatedProgrammes other = (AffiliatedProgrammes) obj;
		return Objects.equals(criteriaId, other.criteriaId) && Objects.equals(inputpt1, other.inputpt1)
				&& Objects.equals(inputpt2, other.inputpt2) && Objects.equals(uniqueKey1, other.uniqueKey1);
	}

	
	
}	

	
	
	
	

