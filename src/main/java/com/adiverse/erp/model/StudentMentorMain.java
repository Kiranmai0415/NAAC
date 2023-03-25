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
@Table(name ="student_mentor_main")
public class StudentMentorMain implements Serializable{
	
	
	private static final long serialVersionUID = 2963762320319863087L;

	@EmbeddedId
    public CriteriaPrimaryKey criteriaId;
	

	@OneToMany(cascade=CascadeType.ALL)
    @JoinColumns ({
        @JoinColumn(name="collegeId", referencedColumnName = "collegeId",nullable = false,insertable = false,updatable = false),
        @JoinColumn(name="financialYear", referencedColumnName = "financialYear",nullable = false,insertable = false,updatable = false),
        @JoinColumn(name="typeofInstitution", referencedColumnName = "typeofInstitution",nullable = false,insertable = false,updatable = false)
    })
    public List<StudentMentorRatio> studentMentorRatio;
	
	@OneToMany(cascade=CascadeType.ALL)
    @JoinColumns ({
        @JoinColumn(name="collegeId", referencedColumnName = "collegeId",nullable = false,insertable = false,updatable = false),
        @JoinColumn(name="financialYear", referencedColumnName = "financialYear",nullable = false,insertable = false,updatable = false),
        @JoinColumn(name="typeofInstitution", referencedColumnName = "typeofInstitution",nullable = false,insertable = false,updatable = false)
    })
    public List<StudentMentorRatioFileUppload> studentMentorRatioFileUppload;

	public CriteriaPrimaryKey getCriteriaId() {
		return criteriaId;
	}

	public void setCriteriaId(CriteriaPrimaryKey criteriaId) {
		this.criteriaId = criteriaId;
	}

	public List<StudentMentorRatio> getStudentMentorRatio() {
		return studentMentorRatio;
	}

	public void setStudentMentorRatio(List<StudentMentorRatio> studentMentorRatio) {
		this.studentMentorRatio = studentMentorRatio;
	}

	public List<StudentMentorRatioFileUppload> getStudentMentorRatioFileUppload() {
		return studentMentorRatioFileUppload;
	}

	public void setStudentMentorRatioFileUppload(List<StudentMentorRatioFileUppload> studentMentorRatioFileUppload) {
		this.studentMentorRatioFileUppload = studentMentorRatioFileUppload;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(criteriaId, studentMentorRatio, studentMentorRatioFileUppload);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StudentMentorMain other = (StudentMentorMain) obj;
		return Objects.equals(criteriaId, other.criteriaId)
				&& Objects.equals(studentMentorRatio, other.studentMentorRatio)
				&& Objects.equals(studentMentorRatioFileUppload, other.studentMentorRatioFileUppload);
	}
	
	
	
	
    
    
   
    
}
