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
@Table(name="Programmes_Offred")
public class ProgrammesOffred implements Serializable
{
	private static final long serialVersionUID = -3611436780363891166L;
	
	private CriteriaPrimaryKey criteriaId;
	
 	@Id
    @Column(name="unique_key1")
	private long uniqueKey1;
	
 	@Column(name="programme_offred")
	private String inputpot1;
	
	@Column(name="aided")
	private String inputpot2;
	
	@Column(name="self_financed")
	private String inputpot3;

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

	public String getInputpot1() {
		if (inputpot1!=null) {
			return inputpot1;
		}
		else {
			return "";
		}
		
	}

	public void setInputpot1(String inputpot1) {
		this.inputpot1 = inputpot1;
	}

	public String getInputpot2() {
		if (inputpot2!=null) {
			return inputpot2;
		}
		else {
			return "";
		}
	}

	public void setInputpot2(String inputpot2) {
		this.inputpot2 = inputpot2;
	}

	public String getInputpot3() {
		if (inputpot3!=null) {
			return inputpot3;
		}
		else {
			return "";
		}
	}

	public void setInputpot3(String inputpot3) {
		this.inputpot3 = inputpot3;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(criteriaId, inputpot1, inputpot2, inputpot3, uniqueKey1);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProgrammesOffred other = (ProgrammesOffred) obj;
		return Objects.equals(criteriaId, other.criteriaId) && Objects.equals(inputpot1, other.inputpot1)
				&& Objects.equals(inputpot2, other.inputpot2) && Objects.equals(inputpot3, other.inputpot3)
				&& uniqueKey1 == other.uniqueKey1;
	}


	
	
	
	
	


	
}