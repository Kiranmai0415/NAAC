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
@Table(name ="awardsRecognitionMain")
public class AwardsRecognitionMain implements Serializable{
	
	
	private static final long serialVersionUID = 2963762320319863087L;

	@EmbeddedId
    public CriteriaPrimaryKey criteriaId;
	

	@OneToMany(cascade=CascadeType.ALL)
    @JoinColumns ({
        @JoinColumn(name="collegeId", referencedColumnName = "collegeId",nullable = false,insertable = false,updatable = false),
        @JoinColumn(name="financialYear", referencedColumnName = "financialYear",nullable = false,insertable = false,updatable = false),
        @JoinColumn(name="typeofInstitution", referencedColumnName = "typeofInstitution",nullable = false,insertable = false,updatable = false)
    })
    public List<AwardsandRecognition> awardsandRecognition;
    
    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumns ({
        @JoinColumn(name="collegeId", referencedColumnName = "collegeId",nullable = false,insertable = false,updatable = false),
        @JoinColumn(name="financialYear", referencedColumnName = "financialYear",nullable = false,insertable = false,updatable = false),
        @JoinColumn(name="typeofInstitution", referencedColumnName = "typeofInstitution",nullable = false,insertable = false,updatable = false)
    })
    public List<AwardsandRecognitionFileUpload> awardsandRecognitionFileUpload;

	public CriteriaPrimaryKey getCriteriaId() {
		return criteriaId;
	}

	public void setCriteriaId(CriteriaPrimaryKey criteriaId) {
		this.criteriaId = criteriaId;
	}

	public List<AwardsandRecognition> getAwardsandRecognition() {
		return awardsandRecognition;
	}

	public void setAwardsandRecognition(List<AwardsandRecognition> awardsandRecognition) {
		this.awardsandRecognition = awardsandRecognition;
	}

	public List<AwardsandRecognitionFileUpload> getAwardsandRecognitionFileUpload() {
		return awardsandRecognitionFileUpload;
	}

	public void setAwardsandRecognitionFileUpload(List<AwardsandRecognitionFileUpload> awardsandRecognitionFileUpload) {
		this.awardsandRecognitionFileUpload = awardsandRecognitionFileUpload;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(awardsandRecognition, awardsandRecognitionFileUpload, criteriaId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AwardsRecognitionMain other = (AwardsRecognitionMain) obj;
		return Objects.equals(awardsandRecognition, other.awardsandRecognition)
				&& Objects.equals(awardsandRecognitionFileUpload, other.awardsandRecognitionFileUpload)
				&& Objects.equals(criteriaId, other.criteriaId);
	}

	
    
   
}
