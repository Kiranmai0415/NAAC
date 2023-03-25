package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;


@Entity
@Table(name ="criteria1_fieldinfo")
public class Criteria1_FieldInfo implements Serializable{
	
	
	private static final long serialVersionUID = 2963762320319863087L;

	@EmbeddedId
    public CriteriaPrimaryKey criteriaId;
	
	
	@OneToMany(cascade = { CascadeType.PERSIST,CascadeType.MERGE }, fetch = FetchType.LAZY)
	@NotFound(action = NotFoundAction.IGNORE)	   
	  @JoinColumns ({
	        @JoinColumn(name="collegeId", referencedColumnName = "collegeId",nullable = false,insertable = false,updatable = false),
	        @JoinColumn(name="financialYear", referencedColumnName = "financialYear",nullable = false,insertable = false,updatable = false),
	        @JoinColumn(name="typeofInstitution", referencedColumnName = "typeofInstitution",nullable = false,insertable = false,updatable = false)
	    })
	    public List<Criteria11Ql> criteria11Ql;
	  
	  
	  
	  @OneToMany(cascade= {CascadeType.PERSIST,CascadeType.MERGE},fetch = FetchType.LAZY)
	    @NotFound(action = NotFoundAction.IGNORE)	    
	    @JoinColumns ({
	        @JoinColumn(name="collegeId", referencedColumnName = "collegeId",nullable = false,insertable = false,updatable = false),
	        @JoinColumn(name="financialYear", referencedColumnName = "financialYear",nullable = false,insertable = false,updatable = false),
	        @JoinColumn(name="typeofInstitution", referencedColumnName = "typeofInstitution",nullable = false,insertable = false,updatable = false)
	    })
	    public List<Criteria11Qn> criteria11Qn;
	  
	
	  
	  @OneToMany(cascade= {CascadeType.PERSIST,CascadeType.MERGE},fetch = FetchType.LAZY)
	    @NotFound(action = NotFoundAction.IGNORE)	  
	    @JoinColumns ({
	        @JoinColumn(name="collegeId", referencedColumnName = "collegeId",nullable = false,insertable = false,updatable = false),
	        @JoinColumn(name="financialYear", referencedColumnName = "financialYear",nullable = false,insertable = false,updatable = false),
	        @JoinColumn(name="typeofInstitution", referencedColumnName = "typeofInstitution",nullable = false,insertable = false,updatable = false)
	    })
	    public List<Criteria12Qn> criteria12Qn;
	  
	
	  @OneToMany(cascade= {CascadeType.PERSIST,CascadeType.MERGE},fetch = FetchType.LAZY)
	    @NotFound(action = NotFoundAction.IGNORE)	   
	  @JoinColumns ({
	        @JoinColumn(name="collegeId", referencedColumnName = "collegeId",nullable = false,insertable = false,updatable = false),
	        @JoinColumn(name="financialYear", referencedColumnName = "financialYear",nullable = false,insertable = false,updatable = false),
	        @JoinColumn(name="typeofInstitution", referencedColumnName = "typeofInstitution",nullable = false,insertable = false,updatable = false)
	    })
	    public List<Criteria13Ql> criteria13Ql;
	  
	  @OneToMany(cascade= {CascadeType.PERSIST,CascadeType.MERGE},fetch = FetchType.LAZY)
	    @NotFound(action = NotFoundAction.IGNORE)	    
	  @JoinColumns ({
	        @JoinColumn(name="collegeId", referencedColumnName = "collegeId",nullable = false,insertable = false,updatable = false),
	        @JoinColumn(name="financialYear", referencedColumnName = "financialYear",nullable = false,insertable = false,updatable = false),
	        @JoinColumn(name="typeofInstitution", referencedColumnName = "typeofInstitution",nullable = false,insertable = false,updatable = false)
	    })
	    public List<Criteria13Qn> criteria13Qn;
	  
	  @OneToMany(cascade= {CascadeType.PERSIST,CascadeType.MERGE},fetch = FetchType.LAZY)
	    @NotFound(action = NotFoundAction.IGNORE)	    
	  @JoinColumns ({
	        @JoinColumn(name="collegeId", referencedColumnName = "collegeId",nullable = false,insertable = false,updatable = false),
	        @JoinColumn(name="financialYear", referencedColumnName = "financialYear",nullable = false,insertable = false,updatable = false),
	        @JoinColumn(name="typeofInstitution", referencedColumnName = "typeofInstitution",nullable = false,insertable = false,updatable = false)
	    })
	    public List<Criteria14Qn> criteria14Qn;
//	  
//	  
//	  
//	
//	
//	
//	
//	
//	
////	 @OneToMany(cascade=CascadeType.ALL)
////    @JoinColumns ({
////        @JoinColumn(name="collegeId", referencedColumnName = "collegeId",nullable = false,insertable = false,updatable = false),
////        @JoinColumn(name="financialYear", referencedColumnName = "financialYear",nullable = false,insertable = false,updatable = false),
////        @JoinColumn(name="typeofInstitution", referencedColumnName = "typeofInstitution",nullable = false,insertable = false,updatable = false)
////    })
////    public List<Criteria1_FieldInfoQl> criteria1FieldInfoQl;
//    
////    @OneToMany(cascade=CascadeType.ALL)
////    @JoinColumns ({
////        @JoinColumn(name="collegeId", referencedColumnName = "collegeId",nullable = false,insertable = false,updatable = false),
////        @JoinColumn(name="financialYear", referencedColumnName = "financialYear",nullable = false,insertable = false,updatable = false),
////        @JoinColumn(name="typeofInstitution", referencedColumnName = "typeofInstitution",nullable = false,insertable = false,updatable = false)
////    })
////    public List<Criteria1_FieldInfoQn> criteria1FieldInfoQn;
//   
	  
	  
	  
	  
	  
	  @OneToMany(cascade= {CascadeType.PERSIST,CascadeType.MERGE},fetch = FetchType.LAZY)
	    @NotFound(action = NotFoundAction.IGNORE)	 
       @JoinColumns ({
        @JoinColumn(name="collegeId", referencedColumnName = "collegeId",nullable = false,insertable = false,updatable = false),
        @JoinColumn(name="financialYear", referencedColumnName = "financialYear",nullable = false,insertable = false,updatable = false),
        @JoinColumn(name="typeofInstitution", referencedColumnName = "typeofInstitution",nullable = false,insertable = false,updatable = false)
    })
    public List<Criteria1_FileUpload> criteria1FileUpload;
    
//    //changes
//    
    @OneToMany(cascade= {CascadeType.PERSIST,CascadeType.MERGE},fetch = FetchType.LAZY)
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumns ({
        @JoinColumn(name="collegeId", referencedColumnName = "collegeId",nullable = false,insertable = false,updatable = false),
        @JoinColumn(name="financialYear", referencedColumnName = "financialYear",nullable = false,insertable = false,updatable = false),
        @JoinColumn(name="typeofInstitution", referencedColumnName = "typeofInstitution",nullable = false,insertable = false,updatable = false)
    })
    public List<YearTable1131> yearTable1131;
    
    
    @OneToMany(cascade= {CascadeType.PERSIST,CascadeType.MERGE},fetch = FetchType.LAZY)
    @NotFound(action = NotFoundAction.IGNORE)
	@JoinColumns ({
        @JoinColumn(name="collegeId", referencedColumnName = "collegeId",nullable = false,insertable = false,updatable = false),
        @JoinColumn(name="financialYear", referencedColumnName = "financialYear",nullable = false,insertable = false,updatable = false),
        @JoinColumn(name="typeofInstitution", referencedColumnName = "typeofInstitution",nullable = false,insertable = false,updatable = false)
    })
    public List<YearTable11312> yearTable11312;
    
    
    @OneToMany(cascade= {CascadeType.PERSIST,CascadeType.MERGE},fetch = FetchType.LAZY)
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumns ({
        @JoinColumn(name="collegeId", referencedColumnName = "collegeId",nullable = false,insertable = false,updatable = false),
        @JoinColumn(name="financialYear", referencedColumnName = "financialYear",nullable = false,insertable = false,updatable = false),
        @JoinColumn(name="typeofInstitution", referencedColumnName = "typeofInstitution",nullable = false,insertable = false,updatable = false)
    })
    public List<YearTable1321> yearTable1321;
    
    
    @OneToMany(cascade= {CascadeType.PERSIST,CascadeType.MERGE},fetch = FetchType.LAZY)
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumns ({
        @JoinColumn(name="collegeId", referencedColumnName = "collegeId",nullable = false,insertable = false,updatable = false),
        @JoinColumn(name="financialYear", referencedColumnName = "financialYear",nullable = false,insertable = false,updatable = false),
        @JoinColumn(name="typeofInstitution", referencedColumnName = "typeofInstitution",nullable = false,insertable = false,updatable = false)
    })
    public List<YearTable1331> yearTable1331;
    
    
    @OneToMany(cascade= {CascadeType.PERSIST,CascadeType.MERGE},fetch = FetchType.LAZY)
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumns ({
        @JoinColumn(name="collegeId", referencedColumnName = "collegeId",nullable = false,insertable = false,updatable = false),
        @JoinColumn(name="financialYear", referencedColumnName = "financialYear",nullable = false,insertable = false,updatable = false),
        @JoinColumn(name="typeofInstitution", referencedColumnName = "typeofInstitution",nullable = false,insertable = false,updatable = false)
    })
    public List<YearTable13312> yearTable13312;
    
    @OneToMany(cascade= {CascadeType.PERSIST,CascadeType.MERGE},fetch = FetchType.LAZY)
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumns ({
        @JoinColumn(name="collegeId", referencedColumnName = "collegeId",nullable = false,insertable = false,updatable = false),
        @JoinColumn(name="financialYear", referencedColumnName = "financialYear",nullable = false,insertable = false,updatable = false),
        @JoinColumn(name="typeofInstitution", referencedColumnName = "typeofInstitution",nullable = false,insertable = false,updatable = false)
    })
    public List<Affiliated_YearTable1221> affiliatedYearTable1221;

	public CriteriaPrimaryKey getCriteriaId() {
		return criteriaId;
	}

	public void setCriteriaId(CriteriaPrimaryKey criteriaId) {
		this.criteriaId = criteriaId;
	}

	public List<Criteria11Ql> getCriteria11Ql() {
		return criteria11Ql;
	}

	public void setCriteria11Ql(List<Criteria11Ql> criteria11Ql) {
		this.criteria11Ql = criteria11Ql;
	}

	public List<Criteria11Qn> getCriteria11Qn() {
		return criteria11Qn;
	}

	public void setCriteria11Qn(List<Criteria11Qn> criteria11Qn) {
		this.criteria11Qn = criteria11Qn;
	}

	public List<Criteria12Qn> getCriteria12Qn() {
		return criteria12Qn;
	}

	public void setCriteria12Qn(List<Criteria12Qn> criteria12Qn) {
		this.criteria12Qn = criteria12Qn;
	}

	public List<Criteria13Ql> getCriteria13Ql() {
		return criteria13Ql;
	}

	public void setCriteria13Ql(List<Criteria13Ql> criteria13Ql) {
		this.criteria13Ql = criteria13Ql;
	}

	public List<Criteria13Qn> getCriteria13Qn() {
		return criteria13Qn;
	}

	public void setCriteria13Qn(List<Criteria13Qn> criteria13Qn) {
		this.criteria13Qn = criteria13Qn;
	}

	public List<Criteria14Qn> getCriteria14Qn() {
		return criteria14Qn;
	}

	public void setCriteria14Qn(List<Criteria14Qn> criteria14Qn) {
		this.criteria14Qn = criteria14Qn;
	}

	public List<Criteria1_FileUpload> getCriteria1FileUpload() {
		return criteria1FileUpload;
	}

	public void setCriteria1FileUpload(List<Criteria1_FileUpload> criteria1FileUpload) {
		this.criteria1FileUpload = criteria1FileUpload;
	}

	public List<YearTable1131> getYearTable1131() {
		return yearTable1131;
	}

	public void setYearTable1131(List<YearTable1131> yearTable1131) {
		this.yearTable1131 = yearTable1131;
	}

	public List<YearTable11312> getYearTable11312() {
		return yearTable11312;
	}

	public void setYearTable11312(List<YearTable11312> yearTable11312) {
		this.yearTable11312 = yearTable11312;
	}

	public List<YearTable1321> getYearTable1321() {
		return yearTable1321;
	}

	public void setYearTable1321(List<YearTable1321> yearTable1321) {
		this.yearTable1321 = yearTable1321;
	}

	public List<YearTable1331> getYearTable1331() {
		return yearTable1331;
	}

	public void setYearTable1331(List<YearTable1331> yearTable1331) {
		this.yearTable1331 = yearTable1331;
	}

	public List<YearTable13312> getYearTable13312() {
		return yearTable13312;
	}

	public void setYearTable13312(List<YearTable13312> yearTable13312) {
		this.yearTable13312 = yearTable13312;
	}

	public List<Affiliated_YearTable1221> getAffiliatedYearTable1221() {
		return affiliatedYearTable1221;
	}

	public void setAffiliatedYearTable1221(List<Affiliated_YearTable1221> affiliatedYearTable1221) {
		this.affiliatedYearTable1221 = affiliatedYearTable1221;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	    
}
