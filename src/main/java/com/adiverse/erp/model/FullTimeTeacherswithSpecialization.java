package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ft_teacherswith_spec")
public class FullTimeTeacherswithSpecialization implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private CriteriaPrimaryKey criteriaId;

	@Id
	@Column(name = "unique_key1")
	private long uniqueKey1;
	
	@Column(name = "nameofthe_teacherwith_spec")
	private String inputftt1;
	
	@Column(name = "dept")
	private String inputftt2;
	
	@Column(name = "schools_name")
	private String inputftt3;
	
	@Column(name = "qualification")
	private String inputftt4;
	
	@Column(name = "yearof_obtaining_qualifi")
	private String inputftt5;
	
	@Column(name = "whether_recogas_guide_forany_spec")
	private String inputftt6;
	
	@Column(name = "idno_aadharno")
	private String inputftt7;
	
	@Column(name = "email")
	private String inputftt8;
	
	@Column(name = "gender")
	private String inputftt9;
	
	@Column(name = "designation")
	private String inputftt10;
	
	@Column(name = "dateof_joining_institution")
	private String inputftt11;
	
	@Column(name = "natureof_appointment")
	private String inputftt12;
	
	@Column(name = "nameofthe_department")
	private String inputftt13;

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

	public String getInputftt1() {
		if(inputftt1 !=null) {
			return inputftt1;
		}else {
			return "";
		}
	}

	public void setInputftt1(String inputftt1) {
		this.inputftt1 = inputftt1;
	}

	public String getInputftt2() {
		if(inputftt2 !=null) {
			return inputftt2;
		}else {
			return "";
		}
	}

	public void setInputftt2(String inputftt2) {
		this.inputftt2 = inputftt2;
	}

	public String getInputftt3() {
		if(inputftt3 !=null) {
			return inputftt3;
		}else {
			return "";
		}
	}

	public void setInputftt3(String inputftt3) {
		this.inputftt3 = inputftt3;
	}

	public String getInputftt4() {
		if(inputftt4 !=null) {
			return inputftt4;
		}else {
			return "";
		}
	}

	public void setInputftt4(String inputftt4) {
		this.inputftt4 = inputftt4;
	}

	public String getInputftt5() {
		if(inputftt5 !=null) {
			return inputftt5;
		}else {
			return "";
		}
	}

	public void setInputftt5(String inputftt5) {
		this.inputftt5 = inputftt5;
	}

	public String getInputftt6() {
		if(inputftt6!=null) {
			return inputftt6;
		}else {
			return "";
		}
	}

	public void setInputftt6(String inputftt6) {
		this.inputftt6 = inputftt6;
	}

	public String getInputftt7() {
		if(inputftt7 !=null) {
			return inputftt7;
		}else {
			return "";
		}
	}

	public void setInputftt7(String inputftt7) {
		this.inputftt7 = inputftt7;
	}

	public String getInputftt8() {
		if(inputftt8 !=null) {
			return inputftt8;
		}else {
			return "";
		}
	}

	public void setInputftt8(String inputftt8) {
		this.inputftt8 = inputftt8;
	}

	public String getInputftt9() {
		if(inputftt9 !=null) {
			return inputftt9;
		}else {
			return "";
		}
	}

	public void setInputftt9(String inputftt9) {
		this.inputftt9 = inputftt9;
	}

	public String getInputftt10() {
		if(inputftt10 !=null) {
			return inputftt10;
		}else {
			return "";
		}
	}

	public void setInputftt10(String inputftt10) {
		this.inputftt10 = inputftt10;
	}

	public String getInputftt11() {
		if(inputftt11 !=null) {
			return inputftt11;
		}else {
			return "";
		}
	}

	public void setInputftt11(String inputftt11) {
		this.inputftt11 = inputftt11;
	}

	public String getInputftt12() {
		if(inputftt12 !=null) {
			return inputftt12;
		}else {
			return "";
		}
	}

	public void setInputftt12(String inputftt12) {
		this.inputftt12 = inputftt12;
	}

	public String getInputftt13() {
		if(inputftt13 !=null) {
			return inputftt13;
		}else {
			return "";
		}
	}

	public void setInputftt13(String inputftt13) {
		this.inputftt13 = inputftt13;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(criteriaId, inputftt1, inputftt10, inputftt11, inputftt12, inputftt13, inputftt2, inputftt3,
				inputftt4, inputftt5, inputftt6, inputftt7, inputftt8, inputftt9, uniqueKey1);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FullTimeTeacherswithSpecialization other = (FullTimeTeacherswithSpecialization) obj;
		return Objects.equals(criteriaId, other.criteriaId) && Objects.equals(inputftt1, other.inputftt1)
				&& Objects.equals(inputftt10, other.inputftt10) && Objects.equals(inputftt11, other.inputftt11)
				&& Objects.equals(inputftt12, other.inputftt12) && Objects.equals(inputftt13, other.inputftt13)
				&& Objects.equals(inputftt2, other.inputftt2) && Objects.equals(inputftt3, other.inputftt3)
				&& Objects.equals(inputftt4, other.inputftt4) && Objects.equals(inputftt5, other.inputftt5)
				&& Objects.equals(inputftt6, other.inputftt6) && Objects.equals(inputftt7, other.inputftt7)
				&& Objects.equals(inputftt8, other.inputftt8) && Objects.equals(inputftt9, other.inputftt9)
				&& uniqueKey1 == other.uniqueKey1;
	}
	
	
	

	
	
}
