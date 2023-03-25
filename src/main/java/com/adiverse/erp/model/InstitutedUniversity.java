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
@Table(name="instituteduniversity")
public class InstitutedUniversity implements Serializable
{
	private static final long serialVersionUID = -2231411273570309611L;

	private CriteriaPrimaryKey criteriaId;
	
 	@Id
    @Column(name="unique_key1")
	private long uniqueKey1;
	
	
	@Column(name="sino")
	private String inputiut1;
	
	@Column(name="nameof_department")
	private String inputiut2;
	
	@Column(name="nameof_chair")
	private String inputiut3;
	
	@Column(name="nameof_sponsororaganisation")
	private String inputiut4;

	
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

	public String getInputiut1() {
		if(inputiut1 !=null) {
			return inputiut1;
		}else {
			return "";
		}
	}

	public void setInputiut1(String inputiut1) {
		this.inputiut1 = inputiut1;
	}

	public String getInputiut2() {
		if(inputiut2 !=null) {
			return inputiut2;
		}else {
			return "";
		}
	}

	public void setInputiut2(String inputiut2) {
		this.inputiut2 = inputiut2;
	}

	public String getInputiut3() {
		if(inputiut3 !=null) {
			return inputiut3;
		}else {
			return "";
		}
	}

	public void setInputiut3(String inputiut3) {
		this.inputiut3 = inputiut3;
	}

	public String getInputiut4() {
		if(inputiut4 !=null) {
			return inputiut4;
		}else {
			return "";
		}
	}

	public void setInputiut4(String inputiut4) {
		this.inputiut4 = inputiut4;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(criteriaId, inputiut1, inputiut2, inputiut3, inputiut4, uniqueKey1);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		InstitutedUniversity other = (InstitutedUniversity) obj;
		return Objects.equals(criteriaId, other.criteriaId) && Objects.equals(inputiut1, other.inputiut1)
				&& Objects.equals(inputiut2, other.inputiut2) && Objects.equals(inputiut3, other.inputiut3)
				&& Objects.equals(inputiut4, other.inputiut4) && uniqueKey1 == other.uniqueKey1;
	}

	
	
}