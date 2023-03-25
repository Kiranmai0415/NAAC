package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="natureof_institution")
public class NatureofInstitution implements Serializable
{
	private static final long serialVersionUID = -2231411273570309611L;

	private CriteriaPrimaryKey criteriaId;
	
 	@Id
    @Column(name="unique_key1")
	private long uniqueKey1;
	


	@Column(name="institution_status")
	private String inputbti1;
	
	@Column(name="By_gender")
	private String inputbti2;
	
	@Column(name="By_Shift")
	private String inputbti3;
	
	@Column(name="Dateof_Establishment")
	private String inputbti4;
	
	@Column(name="Dateof_grant")
	private String inputbti5;
	
	@Column(name="Establishment_date")
	private String inputbti6;

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

	public String getInputbti1() {
		if (inputbti1!=null) {
			return inputbti1;
		}
		else {
			return "";
		}
		
	}

	public void setInputbti1(String inputbti1) {
		this.inputbti1 = inputbti1;
	}

	public String getInputbti2() {
		if (inputbti2!=null) {
			return inputbti2;
		}
		else {
			return "";
		}
	}

	public void setInputbti2(String inputbti2) {
		this.inputbti2 = inputbti2;
	}

	public String getInputbti3() {
		if (inputbti3!=null) {
			return inputbti3;
		}
		else {
			return "";
		}
	}

	public void setInputbti3(String inputbti3) {
		this.inputbti3 = inputbti3;
	}

	public String getInputbti4() {
		if (inputbti4!=null) {
			return inputbti4;
		}
		else {
			return "";
		}
	}

	public void setInputbti4(String inputbti4) {
		this.inputbti4 = inputbti4;
	}

	public String getInputbti5() {
		if (inputbti5!=null) {
			return inputbti5;
		}
		else {
			return "";
		}
	}

	public void setInputbti5(String inputbti5) {
		this.inputbti5 = inputbti5;
	}

	public String getInputbti6() {
		if (inputbti6!=null) {
			return inputbti6;
		}
		else {
			return "";
		}
	}

	public void setInputbti6(String inputbti6) {
		this.inputbti6 = inputbti6;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(criteriaId, inputbti1, inputbti2, inputbti3, inputbti4, inputbti5, inputbti6, uniqueKey1);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NatureofInstitution other = (NatureofInstitution) obj;
		return Objects.equals(criteriaId, other.criteriaId) && Objects.equals(inputbti1, other.inputbti1)
				&& Objects.equals(inputbti2, other.inputbti2) && Objects.equals(inputbti3, other.inputbti3)
				&& Objects.equals(inputbti4, other.inputbti4) && Objects.equals(inputbti5, other.inputbti5)
				&& Objects.equals(inputbti6, other.inputbti6) && uniqueKey1 == other.uniqueKey1;
	}
	
	

	

}
