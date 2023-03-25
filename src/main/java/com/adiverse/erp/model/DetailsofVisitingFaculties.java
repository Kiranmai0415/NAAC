package com.adiverse.erp.model;


import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import javax.persistence.Table;


@Entity

@Table(name="detailsofVisiting_Faculties")
public class DetailsofVisitingFaculties implements Serializable
{


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private CriteriaPrimaryKey criteriaId;
	
 	@Id
    @Column(name="unique_key1")
	private long uniqueKey1;
	
	
	
	  //Details of visiting/guest faculties
	  @Column(name="Visting_Male")
	  private String inputatg11;
	  
	  @Column(name="Visting_Female")
	  private String inputatg12;
	 
	  @Column(name="Visting_Others")
	  private String inputatg13;
	  
	  @Column(name="Visting_Total")
	  private String inputatg14;

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

	public String getInputatg11() {
		if(inputatg11 !=null) {
		return inputatg11;
	}else {
		return "";
	}
	}

	public void setInputatg11(String inputatg11) {
		this.inputatg11 = inputatg11;
	}

	public String getInputatg12() {
		if(inputatg12 !=null) {
			return inputatg12;
		}else {
			return "";
		}
		}
	
	

	public void setInputatg12(String inputatg12) {
		this.inputatg12 = inputatg12;
	}

	public String getInputatg13() {
		
		if(inputatg13 !=null) {
			return inputatg13;
		}else {
			return "";
		}
		}
	

	public void setInputatg13(String inputatg13) {
		this.inputatg13 = inputatg13;
	}

	public String getInputatg14() {
		
		if(inputatg14 !=null) {
			return inputatg14;
		}else {
			return "";
		}
		}
	

	public void setInputatg14(String inputatg14) {
		this.inputatg14 = inputatg14;
	}
	
	

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(criteriaId, inputatg11, inputatg12, inputatg13, inputatg14, uniqueKey1);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DetailsofVisitingFaculties other = (DetailsofVisitingFaculties) obj;
		return Objects.equals(criteriaId, other.criteriaId) && Objects.equals(inputatg11, other.inputatg11)
				&& Objects.equals(inputatg12, other.inputatg12) && Objects.equals(inputatg13, other.inputatg13)
				&& Objects.equals(inputatg14, other.inputatg14) && uniqueKey1 == other.uniqueKey1;
	}


	
	 
	  
}


