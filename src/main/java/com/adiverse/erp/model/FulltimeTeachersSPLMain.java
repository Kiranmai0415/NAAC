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
@Table(name ="fulltime_teachers_SPLMain")
public class FulltimeTeachersSPLMain implements Serializable{
	
	
	private static final long serialVersionUID = 2963762320319863087L;

	@EmbeddedId
    public CriteriaPrimaryKey criteriaId;
	

	@OneToMany(cascade=CascadeType.ALL)
    @JoinColumns ({
        @JoinColumn(name="collegeId", referencedColumnName = "collegeId",nullable = false,insertable = false,updatable = false),
        @JoinColumn(name="financialYear", referencedColumnName = "financialYear",nullable = false,insertable = false,updatable = false),
        @JoinColumn(name="typeofInstitution", referencedColumnName = "typeofInstitution",nullable = false,insertable = false,updatable = false)
    })
    public List<FullTimeTeacherswithSpecialization> fullTimeTeacherswithSpecialization;
    
    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumns ({
        @JoinColumn(name="collegeId", referencedColumnName = "collegeId",nullable = false,insertable = false,updatable = false),
        @JoinColumn(name="financialYear", referencedColumnName = "financialYear",nullable = false,insertable = false,updatable = false),
        @JoinColumn(name="typeofInstitution", referencedColumnName = "typeofInstitution",nullable = false,insertable = false,updatable = false)
    })
    public List<FullTimeTeacherswithSpecializationFileUpload> fullTimeTeacherswithSpecializationFileUpload;

	public CriteriaPrimaryKey getCriteriaId() {
		return criteriaId;
	}

	public void setCriteriaId(CriteriaPrimaryKey criteriaId) {
		this.criteriaId = criteriaId;
	}

	public List<FullTimeTeacherswithSpecialization> getFullTimeTeacherswithSpecialization() {
		return fullTimeTeacherswithSpecialization;
	}

	public void setFullTimeTeacherswithSpecialization(
			List<FullTimeTeacherswithSpecialization> fullTimeTeacherswithSpecialization) {
		this.fullTimeTeacherswithSpecialization = fullTimeTeacherswithSpecialization;
	}

	public List<FullTimeTeacherswithSpecializationFileUpload> getFullTimeTeacherswithSpecializationFileUpload() {
		return fullTimeTeacherswithSpecializationFileUpload;
	}

	public void setFullTimeTeacherswithSpecializationFileUpload(
			List<FullTimeTeacherswithSpecializationFileUpload> fullTimeTeacherswithSpecializationFileUpload) {
		this.fullTimeTeacherswithSpecializationFileUpload = fullTimeTeacherswithSpecializationFileUpload;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(criteriaId, fullTimeTeacherswithSpecialization,
				fullTimeTeacherswithSpecializationFileUpload);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FulltimeTeachersSPLMain other = (FulltimeTeachersSPLMain) obj;
		return Objects.equals(criteriaId, other.criteriaId)
				&& Objects.equals(fullTimeTeacherswithSpecialization, other.fullTimeTeacherswithSpecialization)
				&& Objects.equals(fullTimeTeacherswithSpecializationFileUpload,
						other.fullTimeTeacherswithSpecializationFileUpload);
	}

	
   
}
