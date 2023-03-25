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
@Table(name="recognition")
public class Recognition implements Serializable
{
	private static final long serialVersionUID = 3315733796001209410L;
	
	private CriteriaPrimaryKey criteriaId;
	
 	@Id
    @Column(name="unique_key1")
	private long uniqueKey1;
	

	@Column(name="recognitionRegulatory")
	private String inputbtd11;
	
	@Column(name="recognitionApproval")
	private String inputbtd12;
	
	@Column(name="daymonthyear")
	private String inputbtd13;
	
	@Column(name="validityinmonths")
	private String inputbtd14;
	
	@Column(name="remarks")
	private String inputbtd15;
	




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

	public String getInputbtd15() {
		if (inputbtd15!=null) {
			return inputbtd15;
		}
		else {
			return "";
		}
	
	}

	public void setInputbtd15(String inputbtd15) {
		this.inputbtd15 = inputbtd15;
	}

	public String getInputbtd11() {
		if (inputbtd11!=null) {
			return inputbtd11;
		}
		else {
			return "";
		}
	}

	public void setInputbtd11(String inputbtd11) {
		this.inputbtd11 = inputbtd11;
	}

	public String getInputbtd12() {
		if (inputbtd12!=null) {
			return inputbtd12;
		}
		else {
			return "";
		}
	}

	public void setInputbtd12(String inputbtd12) {
		this.inputbtd12 = inputbtd12;
	}

	public String getInputbtd13() {
		if (inputbtd13!=null) {
			return inputbtd13;
		}
		else {
			return "";
		}
	}

	public void setInputbtd13(String inputbtd13) {
		this.inputbtd13 = inputbtd13;
	}

	public String getInputbtd14() {
		if (inputbtd14!=null) {
			return inputbtd14;
		}
		else {
			return "";
		}
	}

	public void setInputbtd14(String inputbtd14) {
		this.inputbtd14 = inputbtd14;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(criteriaId, inputbtd11, inputbtd12, inputbtd13, inputbtd14, inputbtd15, uniqueKey1);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Recognition other = (Recognition) obj;
		return Objects.equals(criteriaId, other.criteriaId) && Objects.equals(inputbtd11, other.inputbtd11)
				&& Objects.equals(inputbtd12, other.inputbtd12) && Objects.equals(inputbtd13, other.inputbtd13)
				&& Objects.equals(inputbtd14, other.inputbtd14) && Objects.equals(inputbtd15, other.inputbtd15)
				&& uniqueKey1 == other.uniqueKey1;
	}

	
	

}