package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pass_percentof_stud")
public class PassPercentofStudents implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private CriteriaPrimaryKey criteriaId;
	
	@Id
    @Column(name="unique_key1")
	private long uniqueKey1;
	
	@Column(name = "progm_code")
	private String inputpst1;
	
	@Column(name = "progm_name")
	private String inputpst2;
	
	
	@Column(name = "dept")
	private String inputpst3;
	
	@Column(name = "schools_name")
	private String inputpst4;
	
	@Column(name = "noof_stud_appear_finalyr_xam")
	private String inputpst5;
	
	@Column(name = "noof_stud_pass_finalyr_xam")
	private String inputpst6;
	
	@Column(name = "year")
	private String inputpst7;
	
	@Column(name = "total_noof_stud")
	private String inputpst8;
	
	@Column(name = "noof_ft_stud")
	private String inputpst9;
	
	@Column(name = "noof_part_stud")
	private String inputpst10;
	
	@Column(name = "noof_ft_phd_stud")
	private String inputpst11;
	
	@Column(name = "noof_part_phd_stud")
	private String inputpst12;

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

	public String getInputpst1() {
		return inputpst1;
	}

	public void setInputpst1(String inputpst1) {
		this.inputpst1 = inputpst1;
	}

	public String getInputpst2() {
		return inputpst2;
	}

	public void setInputpst2(String inputpst2) {
		this.inputpst2 = inputpst2;
	}

	public String getInputpst3() {
		return inputpst3;
	}

	public void setInputpst3(String inputpst3) {
		this.inputpst3 = inputpst3;
	}

	public String getInputpst4() {
		return inputpst4;
	}

	public void setInputpst4(String inputpst4) {
		this.inputpst4 = inputpst4;
	}

	public String getInputpst5() {
		return inputpst5;
	}

	public void setInputpst5(String inputpst5) {
		this.inputpst5 = inputpst5;
	}

	public String getInputpst6() {
		return inputpst6;
	}

	public void setInputpst6(String inputpst6) {
		this.inputpst6 = inputpst6;
	}

	public String getInputpst7() {
		return inputpst7;
	}

	public void setInputpst7(String inputpst7) {
		this.inputpst7 = inputpst7;
	}

	public String getInputpst8() {
		return inputpst8;
	}

	public void setInputpst8(String inputpst8) {
		this.inputpst8 = inputpst8;
	}

	public String getInputpst9() {
		return inputpst9;
	}

	public void setInputpst9(String inputpst9) {
		this.inputpst9 = inputpst9;
	}

	public String getInputpst10() {
		return inputpst10;
	}

	public void setInputpst10(String inputpst10) {
		this.inputpst10 = inputpst10;
	}

	public String getInputpst11() {
		return inputpst11;
	}

	public void setInputpst11(String inputpst11) {
		this.inputpst11 = inputpst11;
	}

	public String getInputpst12() {
		return inputpst12;
	}

	public void setInputpst12(String inputpst12) {
		this.inputpst12 = inputpst12;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(criteriaId, inputpst1, inputpst10, inputpst11, inputpst12, inputpst2, inputpst3, inputpst4,
				inputpst5, inputpst6, inputpst7, inputpst8, inputpst9, uniqueKey1);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PassPercentofStudents other = (PassPercentofStudents) obj;
		return Objects.equals(criteriaId, other.criteriaId) && Objects.equals(inputpst1, other.inputpst1)
				&& Objects.equals(inputpst10, other.inputpst10) && Objects.equals(inputpst11, other.inputpst11)
				&& Objects.equals(inputpst12, other.inputpst12) && Objects.equals(inputpst2, other.inputpst2)
				&& Objects.equals(inputpst3, other.inputpst3) && Objects.equals(inputpst4, other.inputpst4)
				&& Objects.equals(inputpst5, other.inputpst5) && Objects.equals(inputpst6, other.inputpst6)
				&& Objects.equals(inputpst7, other.inputpst7) && Objects.equals(inputpst8, other.inputpst8)
				&& Objects.equals(inputpst9, other.inputpst9) && uniqueKey1 == other.uniqueKey1;
	}
	
	
	
	
	

	
	
	

}
