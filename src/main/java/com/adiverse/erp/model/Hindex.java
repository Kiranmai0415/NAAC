package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "h_index")
public class Hindex implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private CriteriaPrimaryKey criteriaId;

	@Id
	@Column(name = "unique_key1")
	private long uniqueKey1;
	
	@Column(name = "nameof_faculty")
	private String inputhit1;
	
	@Column(name = "dept")
	private String inputhit2;
	
	@Column(name = "school_name")
	private String inputhit3;
	
	@Column(name = "noof_google_h_index")
	private String inputhit4;
	
	@Column(name = "noof_scopus_h_index")
	private String inputhit5;

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

	public String getInputhit1() {
		if(inputhit1 !=null) {
			return inputhit1;
		}else {
			return "";
		}
	}

	public void setInputhit1(String inputhit1) {
		this.inputhit1 = inputhit1;
	}

	public String getInputhit2() {
		if(inputhit2 !=null) {
			return inputhit2;
		}else {
			return "";
		}
	}

	public void setInputhit2(String inputhit2) {
		this.inputhit2 = inputhit2;
	}

	public String getInputhit3() {
		if(inputhit3 !=null) {
			return inputhit3;
		}else {
			return "";
		}
	}

	public void setInputhit3(String inputhit3) {
		this.inputhit3 = inputhit3;
	}

	public String getInputhit4() {
		if(inputhit4 !=null) {
			return inputhit4;
		}else {
			return "";
		}
	}

	public void setInputhit4(String inputhit4) {
		this.inputhit4 = inputhit4;
	}

	public String getInputhit5() {
		if(inputhit5 !=null) {
			return inputhit5;
		}else {
			return "";
		}
	}

	public void setInputhit5(String inputhit5) {
		this.inputhit5 = inputhit5;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(criteriaId, inputhit1, inputhit2, inputhit3, inputhit4, inputhit5, uniqueKey1);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Hindex other = (Hindex) obj;
		return Objects.equals(criteriaId, other.criteriaId) && Objects.equals(inputhit1, other.inputhit1)
				&& Objects.equals(inputhit2, other.inputhit2) && Objects.equals(inputhit3, other.inputhit3)
				&& Objects.equals(inputhit4, other.inputhit4) && Objects.equals(inputhit5, other.inputhit5)
				&& uniqueKey1 == other.uniqueKey1;
	}

	
	

}
