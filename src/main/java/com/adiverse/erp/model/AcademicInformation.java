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
@Table(name="academic")
public class AcademicInformation implements Serializable
{


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private CriteriaPrimaryKey criteriaId;
	
 	@Id
    @Column(name="unique_key1")
	private long uniqueKey1;
	
	
	 @Column(name="sino")
	  private String inputad1;
	
	
	@Column(name="Level_of_Programme")
	  private String inputad11;
	  
	  @Column(name="Name_of_Programme_Course")
	  private String inputad12;
	  
	  @Column(name="Duration_of_Months")
	  private String inputad13;
	  
	  @Column(name="Entry_Qualification") 
	  private String inputad14;
	  
	  @Column(name="Medium_of_Instruction")
	  private String inputad15;
	  
	  @Column(name="Sanctioned_Strength")
	  private String inputad16;
	  
	  @Column(name="No_Of_Students_Admitted")
	  private String inputad17;
	  
	

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

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
	
	// mapping changes
	
	  public String getInputad1() {
		  if(inputad1 !=null) {
			return inputad1;
		}else {
			return "";
		}
		}

		public void setInputad1(String inputad1) {
			this.inputad1 = inputad1;
		}

	
	

	public String getInputad11() {
		if(inputad11 !=null) {
		return inputad11;
	}else {
		return "";
	}
	}

	public void setInputad11(String inputad11) {
		this.inputad11 = inputad11;
	}

	public String getInputad12() {
		if(inputad12 !=null) {
		return inputad12;
	}else {
		return "";
	}
	}

	public void setInputad12(String inputad12) {
		this.inputad12 = inputad12;
	}

	public String getInputad13() {
		if(inputad13 !=null) {
		return inputad13;
	}else {
		return "";
	}
	}

	public void setInputad13(String inputad13) {
		this.inputad13 = inputad13;
	}

	public String getInputad14() {
		if(inputad14 !=null) {
		return inputad14;
	}else {
		return "";
	}
	}

	public void setInputad14(String inputad14) {
		this.inputad14 = inputad14;
	}

	public String getInputad15() {
		if(inputad15 !=null) {
		return inputad15;
	}else {
		return "";
	}
	}

	public void setInputad15(String inputad15) {
		this.inputad15 = inputad15;
	}

	public String getInputad16() {
		if(inputad16 !=null) {
		return inputad16;
	}else {
		return "";
	}
	}

	public void setInputad16(String inputad16) {
		this.inputad16 = inputad16;
	}

	public String getInputad17() {
		if(inputad17 !=null) {
		return inputad17;
	}else {
		return "";
	}
	}

	public void setInputad17(String inputad17) {
		this.inputad17 = inputad17;
	}

	@Override
	public int hashCode() {
		return Objects.hash(criteriaId, inputad1, inputad11, inputad12, inputad13, inputad14, inputad15, inputad16,
				inputad17, uniqueKey1);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AcademicInformation other = (AcademicInformation) obj;
		return Objects.equals(criteriaId, other.criteriaId) && Objects.equals(inputad1, other.inputad1)
				&& Objects.equals(inputad11, other.inputad11) && Objects.equals(inputad12, other.inputad12)
				&& Objects.equals(inputad13, other.inputad13) && Objects.equals(inputad14, other.inputad14)
				&& Objects.equals(inputad15, other.inputad15) && Objects.equals(inputad16, other.inputad16)
				&& Objects.equals(inputad17, other.inputad17) && uniqueKey1 == other.uniqueKey1;
	}


	
	 
	  
}


