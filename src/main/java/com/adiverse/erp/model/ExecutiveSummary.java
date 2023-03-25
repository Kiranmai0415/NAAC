package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="executive_summary")
public class ExecutiveSummary implements Serializable
{

	private static final long serialVersionUID = -3329036149228418689L;


	@EmbeddedId
    public CriteriaPrimaryKey criteriaId;
	
	@OneToMany(cascade=CascadeType.ALL)
	 @JoinColumns ({
	        @JoinColumn(name="collegeId", referencedColumnName = "collegeId",nullable = false,insertable = false,updatable = false),
	        @JoinColumn(name="financialYear", referencedColumnName = "financialYear",nullable = false,insertable = false,updatable = false),
	        @JoinColumn(name="typeofInstitution", referencedColumnName = "typeofInstitution",nullable = false,insertable = false,updatable = false)
	    })
	private List<Executive_FileUpload> executiveFileUpload; 
	

	
	
	
	
	@Column(name="executive_institution")
	private String inputes1;
	
	@Column(name="executive_vision")
	private String inputes2;
	
	@Column(name="executive_mission")
	private String inputes3;
	
	@Column(name="executive_location")
	private String inputes4;
	
	@Column(name="executive_typeOf_institution")
	private String inputes5;
	
	@Column(name="criterionWise_institution")
	private String inputes7;
	
	@Column(name="strength_weakness")
	private String inputes8;
	
	@Column(name="additional_information")
	private String inputes9;
	
	@Column(name="conclusive_explication")
	private String inputes10;

	public CriteriaPrimaryKey getCriteriaId() {
		return criteriaId;
	}

	public void setCriteriaId(CriteriaPrimaryKey criteriaId) {
		this.criteriaId = criteriaId;
	}

	public List<Executive_FileUpload> getExecutiveFileUpload() {
		return executiveFileUpload;
	}

	public void setExecutiveFileUpload(List<Executive_FileUpload> executiveFileUpload) {
		this.executiveFileUpload = executiveFileUpload;
	}

	public String getInputes1() {
		return inputes1;
	}

	public void setInputes1(String inputes1) {
		this.inputes1 = inputes1;
	}

	public String getInputes2() {
		if(inputes2 !=null) {
			return inputes2;
		}else {
			return "";
		}
	}

	public void setInputes2(String inputes2) {
		this.inputes2 = inputes2;
	}

	public String getInputes3() {
		if(inputes3 !=null) {
			return inputes3;
		}else {
			return "";
		}
	}

	public void setInputes3(String inputes3) {
		this.inputes3 = inputes3;
	}

	public String getInputes4() {
		if(inputes4 !=null) {
			return inputes4;
		}else {
			return "";
		}
	}

	public void setInputes4(String inputes4) {
		this.inputes4 = inputes4;
	}

	public String getInputes5() {
		if(inputes5 !=null) {
			return inputes5;
		}else {
			return "";
		}
	}

	public void setInputes5(String inputes5) {
		this.inputes5 = inputes5;
	}

	public String getInputes7() {
		if(inputes7 !=null) {
			return inputes7;
		}else {
			return "";
		}
	}

	public void setInputes7(String inputes7) {
		this.inputes7 = inputes7;
	}

	public String getInputes8() {
		if(inputes8 !=null) {
			return inputes8;
		}else {
			return "";
		}
	}

	public void setInputes8(String inputes8) {
		this.inputes8 = inputes8;
	}

	public String getInputes9() {
		if(inputes9 !=null) {
			return inputes9;
		}else {
			return "";
		}
	}

	public void setInputes9(String inputes9) {
		this.inputes9 = inputes9;
	}

	public String getInputes10() {
		if(inputes10 !=null) {
			return inputes10;
		}else {
			return "";
		}
	}

	public void setInputes10(String inputes10) {
		this.inputes10 = inputes10;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	

	
}
