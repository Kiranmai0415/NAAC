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
@Table(name ="ft_teach_phd_main")
public class FullTimeTeachersPhdMain implements Serializable{
	
	
	private static final long serialVersionUID = 2963762320319863087L;

	@EmbeddedId
    private CriteriaPrimaryKey criteriaId;
	

	@OneToMany(cascade=CascadeType.ALL)
    @JoinColumns ({
        @JoinColumn(name="collegeId", referencedColumnName = "collegeId",nullable = false,insertable = false,updatable = false),
        @JoinColumn(name="financialYear", referencedColumnName = "financialYear",nullable = false,insertable = false,updatable = false),
        @JoinColumn(name="typeofInstitution", referencedColumnName = "typeofInstitution",nullable = false,insertable = false,updatable = false)
    })
    public List<FullTimeTeacherswithPhd> fullTimeTeacherswithPhd;
	
	@OneToMany(cascade=CascadeType.ALL)
    @JoinColumns ({
        @JoinColumn(name="collegeId", referencedColumnName = "collegeId",nullable = false,insertable = false,updatable = false),
        @JoinColumn(name="financialYear", referencedColumnName = "financialYear",nullable = false,insertable = false,updatable = false),
        @JoinColumn(name="typeofInstitution", referencedColumnName = "typeofInstitution",nullable = false,insertable = false,updatable = false)
    })
    public List<FullTimeTeachersPhdFileUpload> fullTimeTeachersPhdFileUpload;

	public CriteriaPrimaryKey getCriteriaId() {
		return criteriaId;
	}

	public void setCriteriaId(CriteriaPrimaryKey criteriaId) {
		this.criteriaId = criteriaId;
	}

	public List<FullTimeTeacherswithPhd> getFullTimeTeacherswithPhd() {
		return fullTimeTeacherswithPhd;
	}

	public void setFullTimeTeacherswithPhd(List<FullTimeTeacherswithPhd> fullTimeTeacherswithPhd) {
		this.fullTimeTeacherswithPhd = fullTimeTeacherswithPhd;
	}

	public List<FullTimeTeachersPhdFileUpload> getFullTimeTeachersPhdFileUpload() {
		return fullTimeTeachersPhdFileUpload;
	}

	public void setFullTimeTeachersPhdFileUpload(List<FullTimeTeachersPhdFileUpload> fullTimeTeachersPhdFileUpload) {
		this.fullTimeTeachersPhdFileUpload = fullTimeTeachersPhdFileUpload;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(criteriaId, fullTimeTeachersPhdFileUpload, fullTimeTeacherswithPhd);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FullTimeTeachersPhdMain other = (FullTimeTeachersPhdMain) obj;
		return Objects.equals(criteriaId, other.criteriaId)
				&& Objects.equals(fullTimeTeachersPhdFileUpload, other.fullTimeTeachersPhdFileUpload)
				&& Objects.equals(fullTimeTeacherswithPhd, other.fullTimeTeacherswithPhd);
	}

	
	
    
}
