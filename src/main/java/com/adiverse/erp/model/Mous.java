package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "mous")
public class Mous implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private CriteriaPrimaryKey criteriaId;

	@Id
	@Column(name = "unique_key1")
	private long uniqueKey1;
	
	@Column(name = "nameof_organ_withwhom_mous_signed")
	private String inputmt1;
	
	@Column(name = "department")
	private String inputmt2;
	
	@Column(name = "schools_name")
	private String inputmt3;
	
	
	@Column(name = "nameof_collab_agency_contactdtls")
	private String inputmt4;
	
	@Column(name = "yearof_signing_mou")
	private int inputmt5;
	
	@Column(name = "durationof_mou")
	private String inputmt6;
	
	@Column(name = "list_actualactivities_mou_yearwise")
	private String inputmt7;


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

	public String getInputmt1() {
		if (inputmt1!=null) {
			return inputmt1;
		}
		else {
			return "";
		}
		
	}

	public void setInputmt1(String inputmt1) {
		this.inputmt1 = inputmt1;
	}

	public String getInputmt2() {
		if (inputmt2!=null) {
			return inputmt2;
		}
		else {
			return "";
		}
	}

	public void setInputmt2(String inputmt2) {
		this.inputmt2 = inputmt2;
	}

	public String getInputmt3() {
		if (inputmt3!=null) {
			return inputmt3;
		}
		else {
			return "";
		}
	}

	public void setInputmt3(String inputmt3) {
		this.inputmt3 = inputmt3;
	}

	public String getInputmt4() {
		if (inputmt4!=null) {
			return inputmt4;
		}
		else {
			return "";
		}
	}

	public void setInputmt4(String inputmt4) {
		this.inputmt4 = inputmt4;
	}

	public int getInputmt5() {
		if (inputmt5>0) {
			return inputmt5;
		}
		else {
			return 0;
		}
		
	}

	public void setInputmt5(int inputmt5) {
		this.inputmt5 = inputmt5;
	}

	public String getInputmt6() {
		if (inputmt6!=null) {
			return inputmt6;
		}
		else {
			return "";
		}
	}

	public void setInputmt6(String inputmt6) {
		this.inputmt6 = inputmt6;
	}

	public String getInputmt7() {
		if (inputmt7!=null) {
			return inputmt7;
		}
		else {
			return "";
		}
	}

	public void setInputmt7(String inputmt7) {
		this.inputmt7 = inputmt7;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(criteriaId, inputmt1, inputmt2, inputmt3, inputmt4, inputmt5, inputmt6, inputmt7,
				uniqueKey1);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Mous other = (Mous) obj;
		return Objects.equals(criteriaId, other.criteriaId) && Objects.equals(inputmt1, other.inputmt1)
				&& Objects.equals(inputmt2, other.inputmt2) && Objects.equals(inputmt3, other.inputmt3)
				&& Objects.equals(inputmt4, other.inputmt4) && inputmt5 == other.inputmt5
				&& Objects.equals(inputmt6, other.inputmt6) && Objects.equals(inputmt7, other.inputmt7)
				&& uniqueKey1 == other.uniqueKey1;
	}


}
