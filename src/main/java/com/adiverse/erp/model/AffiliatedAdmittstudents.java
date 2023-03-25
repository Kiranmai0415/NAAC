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
@Table(name ="affiliated_admittstudents")
public class AffiliatedAdmittstudents implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

   private CriteriaPrimaryKey criteriaId;
	
    @Id
    @Column(name="unique_key1")
	private String uniqueKey1;
    
	@Column(name = "year1_male")
    private String inputat1;
	
	@Column(name = "year1_female")
    private String inputat2;
	
	@Column(name = "year2_male")
    private String inputat3;
	
	@Column(name = "year2_female")
    private String inputat4;
	
	@Column(name = "year3_male")
    private String inputat5;

	
	@Column(name = "year3_female")
    private String inputat6;
	
	@Column(name = "year4_male")
    private String inputat7;
	
	@Column(name = "year4_female")
    private String inputat8;

	

	

	public String getInputat1() {
		if(inputat1 !=null) {
		return inputat1;
	}else {
		return "";
	}
	}

	public void setInputat1(String inputat1) {
		this.inputat1 = inputat1;
	}

	public String getInputat2() {
		if(inputat2 !=null) {
		return inputat2;
	}else {
		return "";
	}
	}

	public void setInputat2(String inputat2) {
		this.inputat2 = inputat2;
	}

	public String getInputat3() {
		if(inputat3 !=null) {
		return inputat3;
	}else {
		return "";
	}
	}

	public void setInputat3(String inputat3) {
		this.inputat3 = inputat3;
	}

	public String getInputat4() {
		if(inputat4 !=null) {
		return inputat4;
	}else {
		return "";
	}
	}

	public void setInputat4(String inputat4) {
		this.inputat4 = inputat4;
	}

	public String getInputat5() {
		if(inputat5 !=null) {
		return inputat5;
	}else {
		return "";
	}
	}

	public void setInputat5(String inputat5) {
		this.inputat5 = inputat5;
	}

	public String getInputat6() {
		if(inputat6 !=null) {
		return inputat6;
	}else {
		return "";
	}
	}

	public void setInputat6(String inputat6) {
		this.inputat6 = inputat6;
	}

	public String getInputat7() {
		if(inputat7 !=null) {
		return inputat7;
	}else {
		return "";
	}
	}

	public void setInputat7(String inputat7) {
		this.inputat7 = inputat7;
	}

	public String getInputat8() {
		if(inputat8 !=null) {
		return inputat8;
	}else {
		return "";
	}
	}

	public void setInputat8(String inputat8) {
		this.inputat8 = inputat8;
	}

	public CriteriaPrimaryKey getCriteriaId() {
		return criteriaId;
	}

	public void setCriteriaId(CriteriaPrimaryKey criteriaId) {
		this.criteriaId = criteriaId;
	}

	public String getUniqueKey1() {
		return uniqueKey1;
	}

	public void setUniqueKey1(String uniqueKey1) {
		this.uniqueKey1 = uniqueKey1;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public int hashCode() {
		return Objects.hash(criteriaId, inputat1, inputat2, inputat3, inputat4, inputat5, inputat6, inputat7, inputat8,
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
		AffiliatedAdmittstudents other = (AffiliatedAdmittstudents) obj;
		return Objects.equals(criteriaId, other.criteriaId) && Objects.equals(inputat1, other.inputat1)
				&& Objects.equals(inputat2, other.inputat2) && Objects.equals(inputat3, other.inputat3)
				&& Objects.equals(inputat4, other.inputat4) && Objects.equals(inputat5, other.inputat5)
				&& Objects.equals(inputat6, other.inputat6) && Objects.equals(inputat7, other.inputat7)
				&& Objects.equals(inputat8, other.inputat8) && Objects.equals(uniqueKey1, other.uniqueKey1);
	}
	



	
}	

	
	
	
	

