package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "research_fel_enrol_instit")
public class ResearchFellowsEnrolledinInstitution implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private CriteriaPrimaryKey criteriaId;

	

	@Id
    @Column(name="unique_key1")
	private long uniqueKey1;
	
	@Column(name = "nameof_reseach_fel")
	private String inputrft1;
	
	@Column(name = "dept")
	private String inputrft2;
	
	@Column(name = "schools_name")
	private String inputrft3;
	
	@Column(name = "yrof_enroll")
	private String inputrft4;
	
	@Column(name = "durationof_fel")
	private String inputrft5;
	
	@Column(name = "typeof_fel")
	private String inputrft6;
	
	@Column(name = "granting_agency")
	private String inputrft7;
	
	@Column(name = "qualifying_exam")
	private String inputrft8;

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

	public String getInputrft1() {
		if (inputrft1!=null) {
			return inputrft1;
		}
		else {
			return "";
		}
	
	}

	public void setInputrft1(String inputrft1) {
		this.inputrft1 = inputrft1;
	}

	public String getInputrft2() {
		if (inputrft2!=null) {
			return inputrft2;
		}
		else {
			return "";
		}
	}

	public void setInputrft2(String inputrft2) {
		this.inputrft2 = inputrft2;
	}

	public String getInputrft3() {
		if (inputrft3!=null) {
			return inputrft3;
		}
		else {
			return "";
		}
	}

	public void setInputrft3(String inputrft3) {
		this.inputrft3 = inputrft3;
	}

	public String getInputrft4() {
		if (inputrft4!=null) {
			return inputrft4;
		}
		else {
			return "";
		}
	}

	public void setInputrft4(String inputrft4) {
		this.inputrft4 = inputrft4;
	}

	public String getInputrft5() {
		if (inputrft5!=null) {
			return inputrft5;
		}
		else {
			return "";
		}
	}

	public void setInputrft5(String inputrft5) {
		this.inputrft5 = inputrft5;
	}

	public String getInputrft6() {
		if (inputrft1!=null) {
			return inputrft1;
		}
		else {
			return "";
		}
	}

	public void setInputrft6(String inputrft6) {
		this.inputrft6 = inputrft6;
	}

	public String getInputrft7() {
		if (inputrft7!=null) {
			return inputrft7;
		}
		else {
			return "";
		}
	}

	public void setInputrft7(String inputrft7) {
		this.inputrft7 = inputrft7;
	}

	public String getInputrft8() {
		if (inputrft8!=null) {
			return inputrft8;
		}
		else {
			return "";
		}
	}

	public void setInputrft8(String inputrft8) {
		this.inputrft8 = inputrft8;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(criteriaId, inputrft1, inputrft2, inputrft3, inputrft4, inputrft5, inputrft6, inputrft7,
				inputrft8, uniqueKey1);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ResearchFellowsEnrolledinInstitution other = (ResearchFellowsEnrolledinInstitution) obj;
		return Objects.equals(criteriaId, other.criteriaId) && Objects.equals(inputrft1, other.inputrft1)
				&& Objects.equals(inputrft2, other.inputrft2) && Objects.equals(inputrft3, other.inputrft3)
				&& Objects.equals(inputrft4, other.inputrft4) && Objects.equals(inputrft5, other.inputrft5)
				&& Objects.equals(inputrft6, other.inputrft6) && Objects.equals(inputrft7, other.inputrft7)
				&& Objects.equals(inputrft8, other.inputrft8) && uniqueKey1 == other.uniqueKey1;
	}

	

}
