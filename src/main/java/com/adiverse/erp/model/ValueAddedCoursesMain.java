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
@Table(name ="valueadded_course_main")
public class ValueAddedCoursesMain implements Serializable{
	
	
	private static final long serialVersionUID = 2963762320319863087L;

	@EmbeddedId
	private CriteriaPrimaryKey criteriaId;
	

	@OneToMany(cascade=CascadeType.ALL)
    @JoinColumns ({
        @JoinColumn(name="collegeId", referencedColumnName = "collegeId",nullable = false,insertable = false,updatable = false),
        @JoinColumn(name="financialYear", referencedColumnName = "financialYear",nullable = false,insertable = false,updatable = false),
        @JoinColumn(name="typeofInstitution", referencedColumnName = "typeofInstitution",nullable = false,insertable = false,updatable = false)
    })
    public List<ValueAddedCourses> valueAddedCourses;
    
    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumns ({
        @JoinColumn(name="collegeId", referencedColumnName = "collegeId",nullable = false,insertable = false,updatable = false),
        @JoinColumn(name="financialYear", referencedColumnName = "financialYear",nullable = false,insertable = false,updatable = false),
        @JoinColumn(name="typeofInstitution", referencedColumnName = "typeofInstitution",nullable = false,insertable = false,updatable = false)
    })
    public List<ValueAddedCoursesFileUpload> valueAddedCoursesFileUpload;

	public CriteriaPrimaryKey getCriteriaId() {
		return criteriaId;
	}

	public void setCriteriaId(CriteriaPrimaryKey criteriaId) {
		this.criteriaId = criteriaId;
	}

	public List<ValueAddedCourses> getValueAddedCourses() {
		return valueAddedCourses;
	}

	public void setValueAddedCourses(List<ValueAddedCourses> valueAddedCourses) {
		this.valueAddedCourses = valueAddedCourses;
	}

	public List<ValueAddedCoursesFileUpload> getValueAddedCoursesFileUpload() {
		return valueAddedCoursesFileUpload;
	}

	public void setValueAddedCoursesFileUpload(List<ValueAddedCoursesFileUpload> valueAddedCoursesFileUpload) {
		this.valueAddedCoursesFileUpload = valueAddedCoursesFileUpload;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(criteriaId, valueAddedCourses, valueAddedCoursesFileUpload);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ValueAddedCoursesMain other = (ValueAddedCoursesMain) obj;
		return Objects.equals(criteriaId, other.criteriaId)
				&& Objects.equals(valueAddedCourses, other.valueAddedCourses)
				&& Objects.equals(valueAddedCoursesFileUpload, other.valueAddedCoursesFileUpload);
	}

	
}
