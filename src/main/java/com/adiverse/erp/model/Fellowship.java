package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "fellowship")
public class Fellowship implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private CriteriaPrimaryKey criteriaId;

	
	@Id
    @Column(name="unique_key1")
	private long uniqueKey1;
	
	@Column(name = "nameof_teacher_awarded")
	private String inputft1;
	
	@Column(name = "dept")
	private String inputft2;
	
	@Column(name = "schools_name")
	private String inputft3;
	
	@Column(name = "nameof_fellowship")
	private String inputft4;
	
	@Column(name = "yearof_award")
	private int inputft5;
	
	@Column(name = "awarding_agency")
	private String inputft6;

	
	@Column(name = "link")
	private String inputft7;


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


	public String getInputft1() {
		if(inputft1 !=null) {
			return inputft1;
		}else {
			return "";
		}
	}


	public void setInputft1(String inputft1) {
		this.inputft1 = inputft1;
	}


	public String getInputft2() {
		if(inputft2 !=null) {
			return inputft2;
		}else {
			return "";
		}
	}


	public void setInputft2(String inputft2) {
		this.inputft2 = inputft2;
	}


	public String getInputft3() {
		if(inputft3 !=null) {
			return inputft3;
		}else {
			return "";
		}
	}


	public void setInputft3(String inputft3) {
		this.inputft3 = inputft3;
	}


	public String getInputft4() {
		if(inputft4 !=null) {
			return inputft4;
		}else {
			return "";
		}
	}


	public void setInputft4(String inputft4) {
		this.inputft4 = inputft4;
	}


	public int getInputft5() {
		return inputft5;
	}


	public void setInputft5(int inputft5) {
		this.inputft5 = inputft5;
	}


	public String getInputft6() {
		return inputft6;
	}


	public void setInputft6(String inputft6) {
		this.inputft6 = inputft6;
	}


	public String getInputft7() {
		return inputft7;
	}


	public void setInputft7(String inputft7) {
		this.inputft7 = inputft7;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	@Override
	public int hashCode() {
		return Objects.hash(criteriaId, inputft1, inputft2, inputft3, inputft4, inputft5, inputft6, inputft7,
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
		Fellowship other = (Fellowship) obj;
		return Objects.equals(criteriaId, other.criteriaId) && Objects.equals(inputft1, other.inputft1)
				&& Objects.equals(inputft2, other.inputft2) && Objects.equals(inputft3, other.inputft3)
				&& Objects.equals(inputft4, other.inputft4) && inputft5 == other.inputft5
				&& Objects.equals(inputft6, other.inputft6) && Objects.equals(inputft7, other.inputft7)
				&& uniqueKey1 == other.uniqueKey1;
	}


	
	

}
