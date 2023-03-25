package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name ="facultyawards_main")
public class FacultyAwardsMain implements Serializable{
	
	
	private static final long serialVersionUID = 2963762320319863087L;

	@EmbeddedId
    public CriteriaPrimaryKey criteriaId;
	

	@OneToMany(cascade=CascadeType.ALL)
    @JoinColumns ({
        @JoinColumn(name="collegeId", referencedColumnName = "collegeId",nullable = false,insertable = false,updatable = false),
        @JoinColumn(name="financialYear", referencedColumnName = "financialYear",nullable = false,insertable = false,updatable = false),
        @JoinColumn(name="typeofInstitution", referencedColumnName = "typeofInstitution",nullable = false,insertable = false,updatable = false)
    })
    public List<FacultyAwards> facultyAwards;
    
    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumns ({
        @JoinColumn(name="collegeId", referencedColumnName = "collegeId",nullable = false,insertable = false,updatable = false),
        @JoinColumn(name="financialYear", referencedColumnName = "financialYear",nullable = false,insertable = false,updatable = false),
        @JoinColumn(name="typeofInstitution", referencedColumnName = "typeofInstitution",nullable = false,insertable = false,updatable = false)
    })
    public List<FacultyAwardsFileUpload> facultyAwardsFileUpload;

	public CriteriaPrimaryKey getCriteriaId() {
		return criteriaId;
	}

	public void setCriteriaId(CriteriaPrimaryKey criteriaId) {
		this.criteriaId = criteriaId;
	}

	public List<FacultyAwards> getFacultyAwards() {
		return facultyAwards;
	}

	public void setFacultyAwards(List<FacultyAwards> facultyAwards) {
		this.facultyAwards = facultyAwards;
	}

	public List<FacultyAwardsFileUpload> getFacultyAwardsFileUpload() {
		return facultyAwardsFileUpload;
	}

	public void setFacultyAwardsFileUpload(List<FacultyAwardsFileUpload> facultyAwardsFileUpload) {
		this.facultyAwardsFileUpload = facultyAwardsFileUpload;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(criteriaId, facultyAwards, facultyAwardsFileUpload);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FacultyAwardsMain other = (FacultyAwardsMain) obj;
		return Objects.equals(criteriaId, other.criteriaId) && Objects.equals(facultyAwards, other.facultyAwards)
				&& Objects.equals(facultyAwardsFileUpload, other.facultyAwardsFileUpload);
	}
    
   
}
