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
@Table(name="Proffessional_programmes")
public class Proffessionalprogrammes implements Serializable
{
	private static final long serialVersionUID = -3611436780363891166L;
	
	private CriteriaPrimaryKey criteriaId;
	
 	@Id
    @Column(name="unique_key1")
	private long uniqueKey1;
	
	@Column(name="professional_offered")
	private String inputpopt1;
	
	@Column(name="professional_offered1")
	private String inputpopt2;
	
	@Column(name="professional_offered2")
	private String inputpopt3;

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

	public String getInputpopt1() {
		if (inputpopt1!=null) {
			return inputpopt1;
		}
		else {
			return "";
		}
		
	}

	public void setInputpopt1(String inputpopt1) {
		this.inputpopt1 = inputpopt1;
	}

	public String getInputpopt2() {
		if (inputpopt2!=null) {
			return inputpopt2;
		}
		else {
			return "";
		}
	}

	public void setInputpopt2(String inputpopt2) {
		this.inputpopt2 = inputpopt2;
	}

	public String getInputpopt3() {
		if (inputpopt3!=null) {
			return inputpopt3;
		}
		else {
			return "";
		}
	}

	public void setInputpopt3(String inputpopt3) {
		this.inputpopt3 = inputpopt3;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(criteriaId, inputpopt1, inputpopt2, inputpopt3, uniqueKey1);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Proffessionalprogrammes other = (Proffessionalprogrammes) obj;
		return Objects.equals(criteriaId, other.criteriaId) && Objects.equals(inputpopt1, other.inputpopt1)
				&& Objects.equals(inputpopt2, other.inputpopt2) && Objects.equals(inputpopt3, other.inputpopt3)
				&& uniqueKey1 == other.uniqueKey1;
	}

	
	
	
	
	
	
	


	
}