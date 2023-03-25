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
@Table(name ="econtent_devby_teach_main")
public class EcontentDevbyTeachMain implements Serializable{
	
	
	private static final long serialVersionUID = 2963762320319863087L;

	@EmbeddedId
    public CriteriaPrimaryKey criteriaId;
	

	@OneToMany(cascade=CascadeType.ALL)
    @JoinColumns ({
        @JoinColumn(name="collegeId", referencedColumnName = "collegeId",nullable = false,insertable = false,updatable = false),
        @JoinColumn(name="financialYear", referencedColumnName = "financialYear",nullable = false,insertable = false,updatable = false),
        @JoinColumn(name="typeofInstitution", referencedColumnName = "typeofInstitution",nullable = false,insertable = false,updatable = false)
    })
    public List<EContentDevelopedByTeacher> eContentDevelopedByTeacher;
    
    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumns ({
        @JoinColumn(name="collegeId", referencedColumnName = "collegeId",nullable = false,insertable = false,updatable = false),
        @JoinColumn(name="financialYear", referencedColumnName = "financialYear",nullable = false,insertable = false,updatable = false),
        @JoinColumn(name="typeofInstitution", referencedColumnName = "typeofInstitution",nullable = false,insertable = false,updatable = false)
    })
    public List<EContentDevelopedByTeacherFileUpload> eContentDevelopedByTeacherFileUpload;

	public CriteriaPrimaryKey getCriteriaId() {
		return criteriaId;
	}

	public void setCriteriaId(CriteriaPrimaryKey criteriaId) {
		this.criteriaId = criteriaId;
	}

	public List<EContentDevelopedByTeacher> geteContentDevelopedByTeacher() {
		return eContentDevelopedByTeacher;
	}

	public void seteContentDevelopedByTeacher(List<EContentDevelopedByTeacher> eContentDevelopedByTeacher) {
		this.eContentDevelopedByTeacher = eContentDevelopedByTeacher;
	}

	public List<EContentDevelopedByTeacherFileUpload> geteContentDevelopedByTeacherFileUpload() {
		return eContentDevelopedByTeacherFileUpload;
	}

	public void seteContentDevelopedByTeacherFileUpload(
			List<EContentDevelopedByTeacherFileUpload> eContentDevelopedByTeacherFileUpload) {
		this.eContentDevelopedByTeacherFileUpload = eContentDevelopedByTeacherFileUpload;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(criteriaId, eContentDevelopedByTeacher, eContentDevelopedByTeacherFileUpload);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EcontentDevbyTeachMain other = (EcontentDevbyTeachMain) obj;
		return Objects.equals(criteriaId, other.criteriaId)
				&& Objects.equals(eContentDevelopedByTeacher, other.eContentDevelopedByTeacher)
				&& Objects.equals(eContentDevelopedByTeacherFileUpload, other.eContentDevelopedByTeacherFileUpload);
	}

	
   
}
