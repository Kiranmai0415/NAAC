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
@Table(name ="ft_teach_sanction_main")
public class FullTimeTeacherSanctionMain implements Serializable{
	
	
	private static final long serialVersionUID = 2963762320319863087L;

	@EmbeddedId
    private CriteriaPrimaryKey criteriaId;
	

	@OneToMany(cascade=CascadeType.ALL)
    @JoinColumns ({
        @JoinColumn(name="collegeId", referencedColumnName = "collegeId",nullable = false,insertable = false,updatable = false),
        @JoinColumn(name="financialYear", referencedColumnName = "financialYear",nullable = false,insertable = false,updatable = false),
        @JoinColumn(name="typeofInstitution", referencedColumnName = "typeofInstitution",nullable = false,insertable = false,updatable = false)
    })
    public List<FullTimeTeacherSanctionedPost> fullTimeTeacherSanctionedPost;
	
	@OneToMany(cascade=CascadeType.ALL)
    @JoinColumns ({
        @JoinColumn(name="collegeId", referencedColumnName = "collegeId",nullable = false,insertable = false,updatable = false),
        @JoinColumn(name="financialYear", referencedColumnName = "financialYear",nullable = false,insertable = false,updatable = false),
        @JoinColumn(name="typeofInstitution", referencedColumnName = "typeofInstitution",nullable = false,insertable = false,updatable = false)
    })
    public List<FullTimeTeacherSanctionedPostFileUpload> fullTimeTeacherSanctionedPostFileUpload;

	public CriteriaPrimaryKey getCriteriaId() {
		return criteriaId;
	}

	public void setCriteriaId(CriteriaPrimaryKey criteriaId) {
		this.criteriaId = criteriaId;
	}

	public List<FullTimeTeacherSanctionedPost> getFullTimeTeacherSanctionedPost() {
		return fullTimeTeacherSanctionedPost;
	}

	public void setFullTimeTeacherSanctionedPost(List<FullTimeTeacherSanctionedPost> fullTimeTeacherSanctionedPost) {
		this.fullTimeTeacherSanctionedPost = fullTimeTeacherSanctionedPost;
	}

	public List<FullTimeTeacherSanctionedPostFileUpload> getFullTimeTeacherSanctionedPostFileUpload() {
		return fullTimeTeacherSanctionedPostFileUpload;
	}

	public void setFullTimeTeacherSanctionedPostFileUpload(
			List<FullTimeTeacherSanctionedPostFileUpload> fullTimeTeacherSanctionedPostFileUpload) {
		this.fullTimeTeacherSanctionedPostFileUpload = fullTimeTeacherSanctionedPostFileUpload;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(criteriaId, fullTimeTeacherSanctionedPost, fullTimeTeacherSanctionedPostFileUpload);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FullTimeTeacherSanctionMain other = (FullTimeTeacherSanctionMain) obj;
		return Objects.equals(criteriaId, other.criteriaId)
				&& Objects.equals(fullTimeTeacherSanctionedPost, other.fullTimeTeacherSanctionedPost) && Objects
						.equals(fullTimeTeacherSanctionedPostFileUpload, other.fullTimeTeacherSanctionedPostFileUpload);
	}
	
	

	
    
}
