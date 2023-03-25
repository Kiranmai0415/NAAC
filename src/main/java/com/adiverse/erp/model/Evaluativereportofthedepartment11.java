package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name ="evaluative_departmentschild")

public class Evaluativereportofthedepartment11 implements Serializable{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

    private CriteriaPrimaryKey criteriaId;
	
 	@Id
    @Column(name="unique_key1")
	private long uniqueKey1;
	
	@Column(name="si_no")
    private String siNo ;
	
	@Column(name="name_ofthe_department1")
    private String nameOftheDepartment1;
	
	@Column(name="english")
    private String english;
	
	@Column(name="zoology")
    private String zoology;
	
	@Column(name="bio_technology")
    private String bioTechnology;

	

	public String getSiNo() {
		return siNo;
	}

	public void setSiNo(String siNo) {
		this.siNo = siNo;
	}

	public String getNameOftheDepartment1() {
		if(nameOftheDepartment1 !=null) {
			return nameOftheDepartment1;
		}else {
			return "";
					}
	}

	public void setNameOftheDepartment1(String nameOftheDepartment1) {
		this.nameOftheDepartment1 = nameOftheDepartment1;
	}

	public String getEnglish() {
		if(english !=null) {
			return english;
		}else {
			return "";
					}
	}

	public void setEnglish(String english) {
		this.english = english;
	}

	public String getZoology() {
		if(zoology !=null) {
			return zoology;
		}else {
			return "";
					}
	}

	public void setZoology(String zoology) {
		this.zoology = zoology;
	}

	public String getBioTechnology() {
		if(bioTechnology !=null) {
			return bioTechnology;
		}else {
			return "";
					}
	}

	public void setBioTechnology(String bioTechnology) {
		this.bioTechnology = bioTechnology;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(bioTechnology, criteriaId, english, nameOftheDepartment1, siNo, uniqueKey1, zoology);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Evaluativereportofthedepartment11 other = (Evaluativereportofthedepartment11) obj;
		return Objects.equals(bioTechnology, other.bioTechnology) && Objects.equals(criteriaId, other.criteriaId)
				&& Objects.equals(english, other.english)
				&& Objects.equals(nameOftheDepartment1, other.nameOftheDepartment1) && Objects.equals(siNo, other.siNo)
				&& uniqueKey1 == other.uniqueKey1 && Objects.equals(zoology, other.zoology);
	}


	
	}
	


