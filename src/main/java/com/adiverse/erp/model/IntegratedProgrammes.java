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
@Table(name="integratedprogrammes")
public class IntegratedProgrammes implements Serializable
{
	private static final long serialVersionUID = -2231411273570309611L;

	private CriteriaPrimaryKey criteriaId;
	
 	@Id
    @Column(name="unique_key1")
	private long uniqueKey1;
	
	
	@Column(name="integrated_programmes")
	private String inputult1;
	
	@Column(name="university_located")
	private String inputult2;
	
	@Column(name="statesof_india")
	private String inputult3;
	
	
	@Column(name="nri_students")
	private String inputult4;
	
	@Column(name="foreign_students")
	private String inputult5;
	
	@Column(name="total")
	private String inputult6;
	
	
	@Column(name="total_integratedprogrammes")
	private String inputult7;
	
	@Column(name="numberof_integration")
	private String inputult8;
	

	
	public String getInputult8() {
		return inputult8;
	}

	public void setInputult8(String inputult8) {
		this.inputult8 = inputult8;
	}

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

	public String getInputult1() {
		if(inputult1 !=null) {
			return inputult1;
		}else {
			return "";
		}
	}

	public void setInputult1(String inputult1) {
		this.inputult1 = inputult1;
	}

	public String getInputult2() {
		if(inputult2 !=null) {
			return inputult2;
		}else {
			return "";
		}
	}

	public void setInputult2(String inputult2) {
		this.inputult2 = inputult2;
	}

	public String getInputult3() {
		if(inputult3 !=null) {
			return inputult3;
		}else {
			return "";
		}
	}

	public void setInputult3(String inputult3) {
		this.inputult3 = inputult3;
	}

	public String getInputult4() {
		if(inputult4 !=null) {
			return inputult4;
		}else {
			return "";
		}
	}

	public void setInputult4(String inputult4) {
		this.inputult4 = inputult4;
	}

	public String getInputult5() {
		if(inputult5 !=null) {
			return inputult5;
		}else {
			return "";
		}
	}

	public void setInputult5(String inputult5) {
		this.inputult5 = inputult5;
	}

	public String getInputult6() {
		if(inputult6 !=null) {
			return inputult6;
		}else {
			return "";
		}
	}

	public void setInputult6(String inputult6) {
		this.inputult6 = inputult6;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

	public String getInputult7() {
		return inputult7;
	}

	public void setInputult7(String inputult7) {
		this.inputult7 = inputult7;
	}

	@Override
	public int hashCode() {
		return Objects.hash(criteriaId, inputult1, inputult2, inputult3, inputult4, inputult5, inputult6, inputult7,
				inputult8, uniqueKey1);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		IntegratedProgrammes other = (IntegratedProgrammes) obj;
		return Objects.equals(criteriaId, other.criteriaId) && Objects.equals(inputult1, other.inputult1)
				&& Objects.equals(inputult2, other.inputult2) && Objects.equals(inputult3, other.inputult3)
				&& Objects.equals(inputult4, other.inputult4) && Objects.equals(inputult5, other.inputult5)
				&& Objects.equals(inputult6, other.inputult6) && Objects.equals(inputult7, other.inputult7)
				&& Objects.equals(inputult8, other.inputult8) && uniqueKey1 == other.uniqueKey1;
	}



}
