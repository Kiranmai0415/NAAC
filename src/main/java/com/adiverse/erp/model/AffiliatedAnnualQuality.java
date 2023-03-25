package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="affiliated_annualQuality")
public class AffiliatedAnnualQuality implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private CriteriaPrimaryKey criteriaId;
	
 	@Id
    @Column(name="unique_key1")
	private long uniqueKey1;
	
	
 	@Column(name = "accrediation_iqac")
    private String inputat9;
	
	@Column(name = "accrediation_aqar1")
    private String inputat10;
	
	
	@Column(name = "accrediation_aqar2")
    private String inputat11;
	

	@Column(name = "accrediation_aqar3")
    private String inputat12;
	

	@Column(name = "accrediation_aqar4")
    private String inputat13;


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


	public String getInputat9() {
		if(inputat9 !=null) {
		return inputat9;
	}else {
		return "";
	}
	}


	public void setInputat9(String inputat9) {
		this.inputat9 = inputat9;
	}


	public String getInputat10() {
		if(inputat10 !=null) {
		return inputat10;
	}else {
		return "";
	}
	}


	public void setInputat10(String inputat10) {
		this.inputat10 = inputat10;
	}


	public String getInputat11() {
		if(inputat11 !=null) {
		return inputat11;
	}else {
		return "";
	}
	}


	public void setInputat11(String inputat11) {
		this.inputat11 = inputat11;
	}


	public String getInputat12() {
		if(inputat12 !=null) {
		return inputat12;
	}else {
		return "";
	}
	}


	public void setInputat12(String inputat12) {
		this.inputat12 = inputat12;
	}


	public String getInputat13() {
		if(inputat13 !=null) {
		return inputat13;
	}else {
		return "";
	}
	}


	public void setInputat13(String inputat13) {
		this.inputat13 = inputat13;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	@Override
	public int hashCode() {
		return Objects.hash(criteriaId, inputat10, inputat11, inputat12, inputat13, inputat9, uniqueKey1);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AffiliatedAnnualQuality other = (AffiliatedAnnualQuality) obj;
		return Objects.equals(criteriaId, other.criteriaId) && Objects.equals(inputat10, other.inputat10)
				&& Objects.equals(inputat11, other.inputat11) && Objects.equals(inputat12, other.inputat12)
				&& Objects.equals(inputat13, other.inputat13) && Objects.equals(inputat9, other.inputat9)
				&& uniqueKey1 == other.uniqueKey1;
	}


	

	
	
	
}	

	
	
	
	

