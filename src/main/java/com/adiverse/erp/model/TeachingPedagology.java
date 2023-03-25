package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "teaching_pedagology")
public class TeachingPedagology implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private CriteriaPrimaryKey criteriaId;

	@Id
	@Column(name = "unique_key1")
	private long uniqueKey1;
	
	@Column(name = "nameof_faculty")
	private String inputtpt1;
	
	@Column(name = "dept")
	private String inputtpt2;
	
	@Column(name = "school_name")
	private String inputtpt3;
	
	@Column(name = "type")
	private String inputtpt4;

	@Column(name = "ict_tools")
	private String inputtpt5;

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

	public String getInputtpt1() {
		if (inputtpt1!=null) {
			return inputtpt1;
		}
		else {
			return "";
		}
		
	}

	public void setInputtpt1(String inputtpt1) {
		this.inputtpt1 = inputtpt1;
	}

	public String getInputtpt2() {
		if (inputtpt2!=null) {
			return inputtpt2;
		}
		else {
			return "";
		}
		
	}

	public void setInputtpt2(String inputtpt2) {
		this.inputtpt2 = inputtpt2;
	}

	public String getInputtpt3() {
		if (inputtpt3!=null) {
			return inputtpt3;
		}
		else {
			return "";
		}
		
	}

	public void setInputtpt3(String inputtpt3) {
		this.inputtpt3 = inputtpt3;
	}

	public String getInputtpt4() {
		if (inputtpt4!=null) {
			return inputtpt4;
		}
		else {
			return "";
		}
		
	}

	public void setInputtpt4(String inputtpt4) {
		this.inputtpt4 = inputtpt4;
	}

	public String getInputtpt5() {
		if (inputtpt5!=null) {
			return inputtpt5;
		}
		else {
			return "";
		}
		
	}

	public void setInputtpt5(String inputtpt5) {
		this.inputtpt5 = inputtpt5;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(criteriaId, inputtpt1, inputtpt2, inputtpt3, inputtpt4, inputtpt5, uniqueKey1);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TeachingPedagology other = (TeachingPedagology) obj;
		return Objects.equals(criteriaId, other.criteriaId) && Objects.equals(inputtpt1, other.inputtpt1)
				&& Objects.equals(inputtpt2, other.inputtpt2) && Objects.equals(inputtpt3, other.inputtpt3)
				&& Objects.equals(inputtpt4, other.inputtpt4) && Objects.equals(inputtpt5, other.inputtpt5)
				&& uniqueKey1 == other.uniqueKey1;
	}
	
	
	
	
	

}
