package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="detailsofUgc_recognition")
public class DetailsofUgcRecognition implements Serializable
{
	

   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

    private CriteriaPrimaryKey criteriaId;
	
    @Id
    @Column(name="unique_key1")
	private String uniqueKey1;
   

	
	@Column(name = "datemonthyear")
    private String inputst9;
	
	@Column(name = "remarks")
    private String inputst10;

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

	public String getInputst9() {
		if(inputst9 !=null) {
		return inputst9;
	}else {
		return "";
	}
	}

	public void setInputst9(String inputst9) {
		this.inputst9 = inputst9;
	}

	public String getInputst10() {
		if(inputst10 !=null) {
		return inputst10;
	}else {
		return "";
	}
	}

	public void setInputst10(String inputst10) {
		this.inputst10 = inputst10;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(criteriaId, inputst10, inputst9, uniqueKey1);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DetailsofUgcRecognition other = (DetailsofUgcRecognition) obj;
		return Objects.equals(criteriaId, other.criteriaId) && Objects.equals(inputst10, other.inputst10)
				&& Objects.equals(inputst9, other.inputst9) && Objects.equals(uniqueKey1, other.uniqueKey1);
	}
	

	
	
	

}
