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
@Table(name ="pass_percent_stud_main")
public class PassPercentStudMain implements Serializable{
	
	
	private static final long serialVersionUID = 2963762320319863087L;

	@EmbeddedId
    private CriteriaPrimaryKey criteriaId;
	

	@OneToMany(cascade=CascadeType.ALL)
    @JoinColumns ({
        @JoinColumn(name="collegeId", referencedColumnName = "collegeId",nullable = false,insertable = false,updatable = false),
        @JoinColumn(name="financialYear", referencedColumnName = "financialYear",nullable = false,insertable = false,updatable = false),
        @JoinColumn(name="typeofInstitution", referencedColumnName = "typeofInstitution",nullable = false,insertable = false,updatable = false)
    })
    public List<PassPercentofStudents> passPercentofStudents;
	
	@OneToMany(cascade=CascadeType.ALL)
    @JoinColumns ({
        @JoinColumn(name="collegeId", referencedColumnName = "collegeId",nullable = false,insertable = false,updatable = false),
        @JoinColumn(name="financialYear", referencedColumnName = "financialYear",nullable = false,insertable = false,updatable = false),
        @JoinColumn(name="typeofInstitution", referencedColumnName = "typeofInstitution",nullable = false,insertable = false,updatable = false)
    })
    public List<PassPercentofStudentsFileUpload> passPercentofStudentsFileUpload;

	public CriteriaPrimaryKey getCriteriaId() {
		return criteriaId;
	}

	public void setCriteriaId(CriteriaPrimaryKey criteriaId) {
		this.criteriaId = criteriaId;
	}

	public List<PassPercentofStudents> getPassPercentofStudents() {
		return passPercentofStudents;
	}

	public void setPassPercentofStudents(List<PassPercentofStudents> passPercentofStudents) {
		this.passPercentofStudents = passPercentofStudents;
	}

	public List<PassPercentofStudentsFileUpload> getPassPercentofStudentsFileUpload() {
		return passPercentofStudentsFileUpload;
	}

	public void setPassPercentofStudentsFileUpload(List<PassPercentofStudentsFileUpload> passPercentofStudentsFileUpload) {
		this.passPercentofStudentsFileUpload = passPercentofStudentsFileUpload;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(criteriaId, passPercentofStudents, passPercentofStudentsFileUpload);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PassPercentStudMain other = (PassPercentStudMain) obj;
		return Objects.equals(criteriaId, other.criteriaId)
				&& Objects.equals(passPercentofStudents, other.passPercentofStudents)
				&& Objects.equals(passPercentofStudentsFileUpload, other.passPercentofStudentsFileUpload);
	}

	
    
}
