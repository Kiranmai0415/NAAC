package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ft_teach_sanction_post")
public class FullTimeTeacherSanctionedPost implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
    @Column(name="unique_key1")
	private long uniqueKey1;
	
	@Column(name = "nameof_fulltime_teach")
	private String inputspt1;
	
	@Column(name = "dept")
	private String inputspt2;
	
	@Column(name = "schools_name")
	private String inputspt3;
	
	@Column(name = "pan")
	private String inputspt4;
	
	@Column(name = "designation")
	private String inputspt5;
	
	@Column(name = "nameof_dept")
	private String inputspt6;
	
	@Column(name = "natureof_appointment")
	private String inputspt7;
	
	@Column(name = "yrof_appointment")
	private String inputspt8;
	
	@Column(name = "yrsof_experi_insame_institute")
	private String inputspt9;
	
	@Column(name = "isteach_stillserv_institute")
	private String inputspt10;
	
	@Column(name = "yrof_recogas_research_guide")
	private String inputspt11;

	public long getUniqueKey1() {
		return uniqueKey1;
	}

	public void setUniqueKey1(long uniqueKey1) {
		this.uniqueKey1 = uniqueKey1;
	}

	public String getInputspt1() {
		if(inputspt1 !=null) {
			return inputspt1;
		}else {
			return "";
		}
	}

	public void setInputspt1(String inputspt1) {
		this.inputspt1 = inputspt1;
	}

	public String getInputspt2() {
		if(inputspt2 !=null) {
			return inputspt2;
		}else {
			return "";
		}
	}

	public void setInputspt2(String inputspt2) {
		this.inputspt2 = inputspt2;
	}

	public String getInputspt3() {
		if(inputspt3 !=null) {
			return inputspt3;
		}else {
			return "";
		}
	}

	public void setInputspt3(String inputspt3) {
		this.inputspt3 = inputspt3;
	}

	public String getInputspt4() {
		if(inputspt4 !=null) {
			return inputspt4;
		}else {
			return "";
		}
	}

	public void setInputspt4(String inputspt4) {
		this.inputspt4 = inputspt4;
	}

	public String getInputspt5() {
		if(inputspt5 !=null) {
			return inputspt5;
		}else {
			return "";
		}
	}

	public void setInputspt5(String inputspt5) {
		this.inputspt5 = inputspt5;
	}

	public String getInputspt6() {
		if(inputspt6 !=null) {
			return inputspt6;
		}else {
			return "";
		}
	}

	public void setInputspt6(String inputspt6) {
		this.inputspt6 = inputspt6;
	}

	public String getInputspt7() {
		if(inputspt7 !=null) {
			return inputspt7;
		}else {
			return "";
		}
	}

	public void setInputspt7(String inputspt7) {
		this.inputspt7 = inputspt7;
	}

	public String getInputspt8() {
		if(inputspt8 !=null) {
			return inputspt8;
		}else {
			return "";
		}
	}

	public void setInputspt8(String inputspt8) {
		this.inputspt8 = inputspt8;
	}

	public String getInputspt9() {
		if(inputspt9 !=null) {
			return inputspt9;
		}else {
			return "";
		}
	}

	public void setInputspt9(String inputspt9) {
		this.inputspt9 = inputspt9;
	}

	public String getInputspt10() {
		if(inputspt10 !=null) {
			return inputspt10;
		}else {
			return "";
		}
	}

	public void setInputspt10(String inputspt10) {
		this.inputspt10 = inputspt10;
	}

	public String getInputspt11() {
		if(inputspt11 !=null) {
			return inputspt11;
		}else {
			return "";
		}
	}

	public void setInputspt11(String inputspt11) {
		this.inputspt11 = inputspt11;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(inputspt1, inputspt10, inputspt11, inputspt2, inputspt3, inputspt4, inputspt5, inputspt6,
				inputspt7, inputspt8, inputspt9, uniqueKey1);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FullTimeTeacherSanctionedPost other = (FullTimeTeacherSanctionedPost) obj;
		return Objects.equals(inputspt1, other.inputspt1) && Objects.equals(inputspt10, other.inputspt10)
				&& Objects.equals(inputspt11, other.inputspt11) && Objects.equals(inputspt2, other.inputspt2)
				&& Objects.equals(inputspt3, other.inputspt3) && Objects.equals(inputspt4, other.inputspt4)
				&& Objects.equals(inputspt5, other.inputspt5) && Objects.equals(inputspt6, other.inputspt6)
				&& Objects.equals(inputspt7, other.inputspt7) && Objects.equals(inputspt8, other.inputspt8)
				&& Objects.equals(inputspt9, other.inputspt9) && uniqueKey1 == other.uniqueKey1;
	}
	
	
	
	

}
