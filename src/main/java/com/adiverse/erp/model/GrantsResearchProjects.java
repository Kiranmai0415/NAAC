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
@Table(name = "grants_research_projects")
public class GrantsResearchProjects implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private CriteriaPrimaryKey criteriaId;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="unique_key1")
	private long uniqueKey1;
	
	@Column(name = "nameof_project_scheme")
	private String inputgrt1;
	
	@Column(name = "nameof_princi_co_investg")
	private String inputgrt2;
	
	@Column(name = "dept")
	private String inputgrt3;
	
	@Column(name = "schools_name")
	private String inputgrt4;
	
	@Column(name = "nameof_funding_agency")
	private String inputgrt5;
	
	@Column(name = "type_govt_nongovt")
	private String inputgrt6;
	
	@Column(name = "deptof_princi_co_investg")
	private String inputgrt7;
	
	@Column(name = "yrof_award")
	private String inputgrt8;
	
	@Column(name = "funds_provided_lakhs")
	private String inputgrt9;
	
	@Column(name = "duration_project")
	private String inputgrt10;

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

	public String getInputgrt1() {
		if(inputgrt1 !=null) {
			return inputgrt1;
		}else {
			return "";
		}
	}

	public void setInputgrt1(String inputgrt1) {
		this.inputgrt1 = inputgrt1;
	}

	public String getInputgrt2() {
		if(inputgrt2 !=null) {
			return inputgrt2;
		}else {
			return "";
		}
	}

	public void setInputgrt2(String inputgrt2) {
		this.inputgrt2 = inputgrt2;
	}

	public String getInputgrt3() {
		if(inputgrt3 !=null) {
			return inputgrt3;
		}else {
			return "";
		}
	}

	public void setInputgrt3(String inputgrt3) {
		this.inputgrt3 = inputgrt3;
	}

	public String getInputgrt4() {
		if(inputgrt4 !=null) {
			return inputgrt4;
		}else {
			return "";
		}
	}

	public void setInputgrt4(String inputgrt4) {
		this.inputgrt4 = inputgrt4;
	}

	public String getInputgrt5() {
		if(inputgrt5 !=null) {
			return inputgrt5;
		}else {
			return "";
		}
	}

	public void setInputgrt5(String inputgrt5) {
		this.inputgrt5 = inputgrt5;
	}

	public String getInputgrt6() {
		if(inputgrt6 !=null) {
			return inputgrt6;
		}else {
			return "";
		}
	}

	public void setInputgrt6(String inputgrt6) {
		this.inputgrt6 = inputgrt6;
	}

	public String getInputgrt7() {
		if(inputgrt7 !=null) {
			return inputgrt7;
		}else {
			return "";
		}
	}

	public void setInputgrt7(String inputgrt7) {
		this.inputgrt7 = inputgrt7;
	}

	public String getInputgrt8() {
		if(inputgrt8 !=null) {
			return inputgrt8;
		}else {
			return "";
		}
	}

	public void setInputgrt8(String inputgrt8) {
		this.inputgrt8 = inputgrt8;
	}

	public String getInputgrt9() {
		if(inputgrt9 !=null) {
			return inputgrt9;
		}else {
			return "";
		}
	}

	public void setInputgrt9(String inputgrt9) {
		this.inputgrt9 = inputgrt9;
	}

	public String getInputgrt10() {
		if(inputgrt10 !=null) {
			return inputgrt10;
		}else {
			return "";
		}
	}

	public void setInputgrt10(String inputgrt10) {
		this.inputgrt10 = inputgrt10;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(criteriaId, inputgrt1, inputgrt10, inputgrt2, inputgrt3, inputgrt4, inputgrt5, inputgrt6,
				inputgrt7, inputgrt8, inputgrt9, uniqueKey1);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GrantsResearchProjects other = (GrantsResearchProjects) obj;
		return Objects.equals(criteriaId, other.criteriaId) && Objects.equals(inputgrt1, other.inputgrt1)
				&& Objects.equals(inputgrt10, other.inputgrt10) && Objects.equals(inputgrt2, other.inputgrt2)
				&& Objects.equals(inputgrt3, other.inputgrt3) && Objects.equals(inputgrt4, other.inputgrt4)
				&& Objects.equals(inputgrt5, other.inputgrt5) && Objects.equals(inputgrt6, other.inputgrt6)
				&& Objects.equals(inputgrt7, other.inputgrt7) && Objects.equals(inputgrt8, other.inputgrt8)
				&& Objects.equals(inputgrt9, other.inputgrt9) && uniqueKey1 == other.uniqueKey1;
	}

	
	
	
	
	
}


