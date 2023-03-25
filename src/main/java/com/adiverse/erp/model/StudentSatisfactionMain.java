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
@Table(name ="student_satisfy_main")
public class StudentSatisfactionMain implements Serializable{
	
	
	private static final long serialVersionUID = 2963762320319863087L;

	@EmbeddedId
	private CriteriaPrimaryKey criteriaId;
	

	@OneToMany(cascade=CascadeType.ALL)
    @JoinColumns ({
        @JoinColumn(name="collegeId", referencedColumnName = "collegeId",nullable = false,insertable = false,updatable = false),
        @JoinColumn(name="financialYear", referencedColumnName = "financialYear",nullable = false,insertable = false,updatable = false),
        @JoinColumn(name="typeofInstitution", referencedColumnName = "typeofInstitution",nullable = false,insertable = false,updatable = false)
    })
    public List<StudentsSatisfactionSurvey> studentsSatisfactionSurvey;
	
	@OneToMany(cascade=CascadeType.ALL)
    @JoinColumns ({
        @JoinColumn(name="collegeId", referencedColumnName = "collegeId",nullable = false,insertable = false,updatable = false),
        @JoinColumn(name="financialYear", referencedColumnName = "financialYear",nullable = false,insertable = false,updatable = false),
        @JoinColumn(name="typeofInstitution", referencedColumnName = "typeofInstitution",nullable = false,insertable = false,updatable = false)
    })
    public List<StudentSatisfactorySurveyFileUpload> studentSatisfactorySurveyFileUpload;

	public CriteriaPrimaryKey getCriteriaId() {
		return criteriaId;
	}

	public void setCriteriaId(CriteriaPrimaryKey criteriaId) {
		this.criteriaId = criteriaId;
	}

	public List<StudentsSatisfactionSurvey> getStudentsSatisfactionSurvey() {
		return studentsSatisfactionSurvey;
	}

	public void setStudentsSatisfactionSurvey(List<StudentsSatisfactionSurvey> studentsSatisfactionSurvey) {
		this.studentsSatisfactionSurvey = studentsSatisfactionSurvey;
	}

	public List<StudentSatisfactorySurveyFileUpload> getStudentSatisfactorySurveyFileUpload() {
		return studentSatisfactorySurveyFileUpload;
	}

	public void setStudentSatisfactorySurveyFileUpload(
			List<StudentSatisfactorySurveyFileUpload> studentSatisfactorySurveyFileUpload) {
		this.studentSatisfactorySurveyFileUpload = studentSatisfactorySurveyFileUpload;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(criteriaId, studentSatisfactorySurveyFileUpload, studentsSatisfactionSurvey);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StudentSatisfactionMain other = (StudentSatisfactionMain) obj;
		return Objects.equals(criteriaId, other.criteriaId)
				&& Objects.equals(studentSatisfactorySurveyFileUpload, other.studentSatisfactorySurveyFileUpload)
				&& Objects.equals(studentsSatisfactionSurvey, other.studentsSatisfactionSurvey);
	}

	
   
    
}
