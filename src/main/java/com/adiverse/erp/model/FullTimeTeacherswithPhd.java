package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "fulltime_teach_phd")
public class FullTimeTeacherswithPhd implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private CriteriaPrimaryKey criteriaId;

	
	@Id
    @Column(name="unique_key1")
	private long uniqueKey1;
	
	@Column(name = "nameof_ft_teach_spliz")
	private String inputpht1;
	
	@Column(name = "dept")
	private String inputpht2;
	
	@Column(name = "schools_name")
	private String inputpht3;
	
	@Column(name = "qualif")
	private String inputpht4;
	
	@Column(name = "yrof_qual")
	private String inputpht5;

	@Column(name = "curr_year")
	private String inputpht6;
	
	@Column(name = "experience")
	private String inputpht7;
	
	@Column(name = "industry_exp")
	private String inputpht8;
	
	

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

	public String getInputpht1() {
		if(inputpht1 !=null) {
			return inputpht1;
		}else {
			return "";
		}
	}

	public void setInputpht1(String inputpht1) {
		this.inputpht1 = inputpht1;
	}

	public String getInputpht2() {
		if(inputpht2 !=null) {
			return inputpht2;
		}else {
			return "";
		}
	}

	public void setInputpht2(String inputpht2) {
		this.inputpht2 = inputpht2;
	}

	public String getInputpht3() {
		if(inputpht3 !=null) {
			return inputpht3;
		}else {
			return "";
		}
	}

	public void setInputpht3(String inputpht3) {
		this.inputpht3 = inputpht3;
	}

	public String getInputpht4() {
		if(inputpht4 !=null) {
			return inputpht4;
		}else {
			return "";
		}
	}

	public void setInputpht4(String inputpht4) {
		this.inputpht4 = inputpht4;
	}

	public String getInputpht5() {
		if(inputpht5 !=null) {
			return inputpht5;
		}else {
			return "";
		}
	}

	public void setInputpht5(String inputpht5) {
		this.inputpht5 = inputpht5;
	}

	public String getInputpht6() {
		if(inputpht6 !=null) {
			return inputpht6;
		}else {
			return "";
		}
	}

	public void setInputpht6(String inputpht6) {
		this.inputpht6 = inputpht6;
	}

	public String getInputpht7() {
		if(inputpht7 !=null) {
			return inputpht7;
		}else {
			return "";
		}
	}

	public void setInputpht7(String inputpht7) {
		this.inputpht7 = inputpht7;
	}

	
	
	
	
	
	
	public String getInputpht8() {
		return inputpht8;
	}

	public void setInputpht8(String inputpht8) {
		this.inputpht8 = inputpht8;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(criteriaId, inputpht1, inputpht2, inputpht3, inputpht4, inputpht5, inputpht6, inputpht7,
				inputpht8, uniqueKey1);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FullTimeTeacherswithPhd other = (FullTimeTeacherswithPhd) obj;
		return Objects.equals(criteriaId, other.criteriaId) && Objects.equals(inputpht1, other.inputpht1)
				&& Objects.equals(inputpht2, other.inputpht2) && Objects.equals(inputpht3, other.inputpht3)
				&& Objects.equals(inputpht4, other.inputpht4) && Objects.equals(inputpht5, other.inputpht5)
				&& Objects.equals(inputpht6, other.inputpht6) && Objects.equals(inputpht7, other.inputpht7)
				&& Objects.equals(inputpht8, other.inputpht8) && uniqueKey1 == other.uniqueKey1;
	}

	
	
	
	
	
	
	
	
	
	
	
}
