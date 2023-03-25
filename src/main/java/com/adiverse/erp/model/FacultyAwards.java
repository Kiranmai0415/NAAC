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
@Table(name = "faculty_awards")
public class FacultyAwards implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private CriteriaPrimaryKey criteriaId;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "unique_key1")
	private long uniqueKey1;

	@Column(name = "nameof_ft_teach_recev_award")
	private String inputfat1;
	
	@Column(name = "department")
	private String inputfat2;
	
	@Column(name = "schools_name")
	private String inputfat3;
	
	@Column(name = "pan")
	private String inputfat4;
	
	@Column(name = "designation")
	private String inputfat5;
	
	@Column(name = "incentives_givenby_hei_recog_award")
	private String inputfat6;
	
	@Column(name = "nameof_award_receivedf_govt_recogbodies")
	private String inputfat7;
	
	@Column(name = "linktothe_docs")
	private String inputfat8;

	@Column(name = "curr_year")
	private String inputfat9;

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

	public String getInputfat1() {
		if(inputfat1 !=null) {
		return inputfat1;
	}else {
		return "";
	}
	}

	public void setInputfat1(String inputfat1) {
		this.inputfat1 = inputfat1;
	}

	public String getInputfat2() {
		if(inputfat2 !=null) {
			return inputfat2;
		}else {
			return "";
		}
	}

	public void setInputfat2(String inputfat2) {
		this.inputfat2 = inputfat2;
	}

	public String getInputfat3() {
		if(inputfat3 !=null) {
			return inputfat3;
		}else {
			return "";
		}
	}

	public void setInputfat3(String inputfat3) {
		this.inputfat3 = inputfat3;
	}

	public String getInputfat4() {
		if(inputfat4 !=null) {
			return inputfat4;
		}else {
			return "";
		}
	}

	public void setInputfat4(String inputfat4) {
		this.inputfat4 = inputfat4;
	}

	public String getInputfat5() {
		if(inputfat5 !=null) {
			return inputfat5;
		}else {
			return "";
		}
	}

	public void setInputfat5(String inputfat5) {
		this.inputfat5 = inputfat5;
	}

	public String getInputfat6() {
		if(inputfat6!=null) {
			return inputfat6;
		}else {
			return "";
		}
	}

	public void setInputfat6(String inputfat6) {
		this.inputfat6 = inputfat6;
	}

	public String getInputfat7() {
		if(inputfat7!=null) {
			return inputfat7;
		}else {
			return "";
		}
	}

	public void setInputfat7(String inputfat7) {
		this.inputfat7 = inputfat7;
	}

	public String getInputfat8() {
		if(inputfat8!=null) {
			return inputfat8;
		}else {
			return "";
		}
	}

	public void setInputfat8(String inputfat8) {
		this.inputfat8 = inputfat8;
	}

	public String getInputfat9() {
		if(inputfat9!=null) {
			return inputfat9;
		}else {
			return "";
		}
	}

	public void setInputfat9(String inputfat9) {
		this.inputfat9 = inputfat9;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(criteriaId, inputfat1, inputfat2, inputfat3, inputfat4, inputfat5, inputfat6, inputfat7,
				inputfat8, inputfat9, uniqueKey1);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FacultyAwards other = (FacultyAwards) obj;
		return Objects.equals(criteriaId, other.criteriaId) && Objects.equals(inputfat1, other.inputfat1)
				&& Objects.equals(inputfat2, other.inputfat2) && Objects.equals(inputfat3, other.inputfat3)
				&& Objects.equals(inputfat4, other.inputfat4) && Objects.equals(inputfat5, other.inputfat5)
				&& Objects.equals(inputfat6, other.inputfat6) && Objects.equals(inputfat7, other.inputfat7)
				&& Objects.equals(inputfat8, other.inputfat8) && Objects.equals(inputfat9, other.inputfat9)
				&& uniqueKey1 == other.uniqueKey1;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
