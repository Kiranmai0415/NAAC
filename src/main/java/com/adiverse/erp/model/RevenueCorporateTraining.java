package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "revenue_corpo_training")
public class RevenueCorporateTraining implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	 private CriteriaPrimaryKey criteriaId;
		
	@Id
    @Column(name="unique_key1")
	private long uniqueKey1;
	
	@Column(name = "nameof_trainer")
	private String inputrctt1;
	
	@Column(name = "dept")
	private String inputrctt2;
	
	@Column(name = "schools_name")
	private String inputrctt3;
	
	@Column(name = "titleof_corpo_training_progm")
	private String inputrctt4;
	
	@Column(name = "agency_contact_dtls")
	private String inputrctt5;
	
	@Column(name = "year")
	private String inputrctt6;
	
	@Column(name = "revenue_generated_in_rs")
	private String inputrctt7;
	
	@Column(name = "no_of_trainees")
	private String inputrctt8;

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

	public String getInputrctt1() {
		if (inputrctt1!=null) {
			return inputrctt1;
		}
		else {
			return "";
		}
	
	}

	public void setInputrctt1(String inputrctt1) {
		this.inputrctt1 = inputrctt1;
	}

	public String getInputrctt2() {
		if (inputrctt2!=null) {
			return inputrctt2;
		}
		else {
			return "";
		}
	}

	public void setInputrctt2(String inputrctt2) {
		this.inputrctt2 = inputrctt2;
	}

	public String getInputrctt3() {
		if (inputrctt3!=null) {
			return inputrctt3;
		}
		else {
			return "";
		}
	}

	public void setInputrctt3(String inputrctt3) {
		this.inputrctt3 = inputrctt3;
	}

	public String getInputrctt4() {
		if (inputrctt4!=null) {
			return inputrctt4;
		}
		else {
			return "";
		}
	}

	public void setInputrctt4(String inputrctt4) {
		this.inputrctt4 = inputrctt4;
	}

	public String getInputrctt5() {
		if (inputrctt5!=null) {
			return inputrctt5;
		}
		else {
			return "";
		}
	}

	public void setInputrctt5(String inputrctt5) {
		this.inputrctt5 = inputrctt5;
	}

	public String getInputrctt6() {
		if (inputrctt6!=null) {
			return inputrctt6;
		}
		else {
			return "";
		}
	}

	public void setInputrctt6(String inputrctt6) {
		this.inputrctt6 = inputrctt6;
	}

	public String getInputrctt7() {
		if (inputrctt7!=null) {
			return inputrctt7;
		}
		else {
			return "";
		}
	}

	public void setInputrctt7(String inputrctt7) {
		this.inputrctt7 = inputrctt7;
	}

	public String getInputrctt8() {
		if (inputrctt8!=null) {
			return inputrctt8;
		}
		else {
			return "";
		}
	}

	public void setInputrctt8(String inputrctt8) {
		this.inputrctt8 = inputrctt8;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(criteriaId, inputrctt1, inputrctt2, inputrctt3, inputrctt4, inputrctt5, inputrctt6,
				inputrctt7, inputrctt8, uniqueKey1);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RevenueCorporateTraining other = (RevenueCorporateTraining) obj;
		return Objects.equals(criteriaId, other.criteriaId) && Objects.equals(inputrctt1, other.inputrctt1)
				&& Objects.equals(inputrctt2, other.inputrctt2) && Objects.equals(inputrctt3, other.inputrctt3)
				&& Objects.equals(inputrctt4, other.inputrctt4) && Objects.equals(inputrctt5, other.inputrctt5)
				&& Objects.equals(inputrctt6, other.inputrctt6) && Objects.equals(inputrctt7, other.inputrctt7)
				&& Objects.equals(inputrctt8, other.inputrctt8) && uniqueKey1 == other.uniqueKey1;
	}

	
	
	
	

}
