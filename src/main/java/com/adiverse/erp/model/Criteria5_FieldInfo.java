package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;


@Entity
@Table(name ="criteria5_fieldinfo")
public class Criteria5_FieldInfo implements Serializable
{
	
	private static final long serialVersionUID = -4278690162341937850L;

	@Id
    public CriteriaPrimaryKey criteriaId;
	
	
	 @OneToMany(cascade= {CascadeType.PERSIST,CascadeType.MERGE},fetch = FetchType.LAZY)
	    @NotFound(action = NotFoundAction.IGNORE)
	    @JoinColumns ({
	        @JoinColumn(name="collegeId", referencedColumnName = "collegeId",nullable = false,insertable = false,updatable = false),
	        @JoinColumn(name="financialYear", referencedColumnName = "financialYear",nullable = false,insertable = false,updatable = false),
	        @JoinColumn(name="typeofInstitution", referencedColumnName = "typeofInstitution",nullable = false,insertable = false,updatable = false)
	    })
	    public List<Criteria51Qn> criteria51Qn;
	 
	 
	 
	 
	 @OneToMany(cascade= {CascadeType.PERSIST,CascadeType.MERGE},fetch = FetchType.LAZY)
	    @NotFound(action = NotFoundAction.IGNORE)
	    @JoinColumns ({
	        @JoinColumn(name="collegeId", referencedColumnName = "collegeId",nullable = false,insertable = false,updatable = false),
	        @JoinColumn(name="financialYear", referencedColumnName = "financialYear",nullable = false,insertable = false,updatable = false),
	        @JoinColumn(name="typeofInstitution", referencedColumnName = "typeofInstitution",nullable = false,insertable = false,updatable = false)
	    })
	    public List<Criteria52Qn> criteria52Qn;
	
	 @OneToMany(cascade= {CascadeType.PERSIST,CascadeType.MERGE},fetch = FetchType.LAZY)
	    @NotFound(action = NotFoundAction.IGNORE)
	    @JoinColumns ({
	        @JoinColumn(name="collegeId", referencedColumnName = "collegeId",nullable = false,insertable = false,updatable = false),
	        @JoinColumn(name="financialYear", referencedColumnName = "financialYear",nullable = false,insertable = false,updatable = false),
	        @JoinColumn(name="typeofInstitution", referencedColumnName = "typeofInstitution",nullable = false,insertable = false,updatable = false)
	    })
	    public List<Criteria53Qn> criteria53Qn;
	 
	 @OneToMany(cascade= {CascadeType.PERSIST,CascadeType.MERGE},fetch = FetchType.LAZY)
	    @NotFound(action = NotFoundAction.IGNORE)
	    @JoinColumns ({
	        @JoinColumn(name="collegeId", referencedColumnName = "collegeId",nullable = false,insertable = false,updatable = false),
	        @JoinColumn(name="financialYear", referencedColumnName = "financialYear",nullable = false,insertable = false,updatable = false),
	        @JoinColumn(name="typeofInstitution", referencedColumnName = "typeofInstitution",nullable = false,insertable = false,updatable = false)
	    })
	    public List<Criteria54Ql> criteria54Ql;
	
	
	
//    @OneToMany(cascade=CascadeType.ALL)
//    @JoinColumns ({
//        @JoinColumn(name="collegeId", referencedColumnName = "collegeId",nullable = false,insertable = false,updatable = false),
//        @JoinColumn(name="financialYear", referencedColumnName = "financialYear",nullable = false,insertable = false,updatable = false),
//        @JoinColumn(name="typeofInstitution", referencedColumnName = "typeofInstitution",nullable = false,insertable = false,updatable = false)
//    })
//    public List<Criteria5_FieldInfoQl> criteria5FieldInfoQl;
//    
//    @OneToMany(cascade=CascadeType.ALL)
//    @JoinColumns ({
//        @JoinColumn(name="collegeId", referencedColumnName = "collegeId",nullable = false,insertable = false,updatable = false),
//        @JoinColumn(name="financialYear", referencedColumnName = "financialYear",nullable = false,insertable = false,updatable = false),
//        @JoinColumn(name="typeofInstitution", referencedColumnName = "typeofInstitution",nullable = false,insertable = false,updatable = false)
//    })
//    public List<Criteria5_FieldInfoQn> criteria5FieldInfoQn;
//    
	 @OneToMany(cascade= {CascadeType.PERSIST,CascadeType.MERGE},fetch = FetchType.LAZY)
	    @NotFound(action = NotFoundAction.IGNORE)
	    @JoinColumns ({
        @JoinColumn(name="collegeId", referencedColumnName = "collegeId",nullable = false,insertable = false,updatable = false),
        @JoinColumn(name="financialYear", referencedColumnName = "financialYear",nullable = false,insertable = false,updatable = false),
        @JoinColumn(name="typeofInstitution", referencedColumnName = "typeofInstitution",nullable = false,insertable = false,updatable = false)
    })
    public List<Criteria5_FileUpload> criteria5FileUpload;
//    
    //changes
    
    @OneToMany(cascade= {CascadeType.PERSIST,CascadeType.MERGE},fetch = FetchType.LAZY)
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumns ({
        @JoinColumn(name="collegeId", referencedColumnName = "collegeId",nullable = false,insertable = false,updatable = false),
        @JoinColumn(name="financialYear", referencedColumnName = "financialYear",nullable = false,insertable = false,updatable = false),
        @JoinColumn(name="typeofInstitution", referencedColumnName = "typeofInstitution",nullable = false,insertable = false,updatable = false)
    })
    public List<YearTable5111> yearTable5111;
    
    
    @OneToMany(cascade= {CascadeType.PERSIST,CascadeType.MERGE},fetch = FetchType.LAZY)
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumns ({
        @JoinColumn(name="collegeId", referencedColumnName = "collegeId",nullable = false,insertable = false,updatable = false),
        @JoinColumn(name="financialYear", referencedColumnName = "financialYear",nullable = false,insertable = false,updatable = false),
        @JoinColumn(name="typeofInstitution", referencedColumnName = "typeofInstitution",nullable = false,insertable = false,updatable = false)
    })
    public List<YearTable51112> yearTable51112;
    
    
    @OneToMany(cascade= {CascadeType.PERSIST,CascadeType.MERGE},fetch = FetchType.LAZY)
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumns ({
        @JoinColumn(name="collegeId", referencedColumnName = "collegeId",nullable = false,insertable = false,updatable = false),
        @JoinColumn(name="financialYear", referencedColumnName = "financialYear",nullable = false,insertable = false,updatable = false),
        @JoinColumn(name="typeofInstitution", referencedColumnName = "typeofInstitution",nullable = false,insertable = false,updatable = false)
    })
    public List<YearTable5121> yearTable5121;
    
    
    @OneToMany(cascade= {CascadeType.PERSIST,CascadeType.MERGE},fetch = FetchType.LAZY)
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumns ({
        @JoinColumn(name="collegeId", referencedColumnName = "collegeId",nullable = false,insertable = false,updatable = false),
        @JoinColumn(name="financialYear", referencedColumnName = "financialYear",nullable = false,insertable = false,updatable = false),
        @JoinColumn(name="typeofInstitution", referencedColumnName = "typeofInstitution",nullable = false,insertable = false,updatable = false)
    })
    public List<YearTable51212> yearTable51212;
    
    
    
    @OneToMany(cascade= {CascadeType.PERSIST,CascadeType.MERGE},fetch = FetchType.LAZY)
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumns ({
        @JoinColumn(name="collegeId", referencedColumnName = "collegeId",nullable = false,insertable = false,updatable = false),
        @JoinColumn(name="financialYear", referencedColumnName = "financialYear",nullable = false,insertable = false,updatable = false),
        @JoinColumn(name="typeofInstitution", referencedColumnName = "typeofInstitution",nullable = false,insertable = false,updatable = false)
    })
    public List<Affiliated_YearTable5131> affiliatedYearTable5131;
    
    
    
    @OneToMany(cascade= {CascadeType.PERSIST,CascadeType.MERGE},fetch = FetchType.LAZY)
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumns ({
        @JoinColumn(name="collegeId", referencedColumnName = "collegeId",nullable = false,insertable = false,updatable = false),
        @JoinColumn(name="financialYear", referencedColumnName = "financialYear",nullable = false,insertable = false,updatable = false),
        @JoinColumn(name="typeofInstitution", referencedColumnName = "typeofInstitution",nullable = false,insertable = false,updatable = false)
    })
    public List<YearTable5231> yearTable5231;


    @OneToMany(cascade= {CascadeType.PERSIST,CascadeType.MERGE},fetch = FetchType.LAZY)
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumns ({
        @JoinColumn(name="collegeId", referencedColumnName = "collegeId",nullable = false,insertable = false,updatable = false),
        @JoinColumn(name="financialYear", referencedColumnName = "financialYear",nullable = false,insertable = false,updatable = false),
        @JoinColumn(name="typeofInstitution", referencedColumnName = "typeofInstitution",nullable = false,insertable = false,updatable = false)
    })
    public List<YearTable5232> yearTable5232;
    
    @OneToMany(cascade= {CascadeType.PERSIST,CascadeType.MERGE},fetch = FetchType.LAZY)
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumns ({
        @JoinColumn(name="collegeId", referencedColumnName = "collegeId",nullable = false,insertable = false,updatable = false),
        @JoinColumn(name="financialYear", referencedColumnName = "financialYear",nullable = false,insertable = false,updatable = false),
        @JoinColumn(name="typeofInstitution", referencedColumnName = "typeofInstitution",nullable = false,insertable = false,updatable = false)
    })
    public List<YearTable5311> yearTable5311;



    @OneToMany(cascade= {CascadeType.PERSIST,CascadeType.MERGE},fetch = FetchType.LAZY)
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumns ({
        @JoinColumn(name="collegeId", referencedColumnName = "collegeId",nullable = false,insertable = false,updatable = false),
        @JoinColumn(name="financialYear", referencedColumnName = "financialYear",nullable = false,insertable = false,updatable = false),
        @JoinColumn(name="typeofInstitution", referencedColumnName = "typeofInstitution",nullable = false,insertable = false,updatable = false)
    })
    public List<YearTable5331> yearTable5331;


    @OneToMany(cascade= {CascadeType.PERSIST,CascadeType.MERGE},fetch = FetchType.LAZY)
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumns ({
        @JoinColumn(name="collegeId", referencedColumnName = "collegeId",nullable = false,insertable = false,updatable = false),
        @JoinColumn(name="financialYear", referencedColumnName = "financialYear",nullable = false,insertable = false,updatable = false),
        @JoinColumn(name="typeofInstitution", referencedColumnName = "typeofInstitution",nullable = false,insertable = false,updatable = false)
    })
    public List<YearTable5141> yearTable5141;
    
    
    @OneToMany(cascade= {CascadeType.PERSIST,CascadeType.MERGE},fetch = FetchType.LAZY)
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumns ({
        @JoinColumn(name="collegeId", referencedColumnName = "collegeId",nullable = false,insertable = false,updatable = false),
        @JoinColumn(name="financialYear", referencedColumnName = "financialYear",nullable = false,insertable = false,updatable = false),
        @JoinColumn(name="typeofInstitution", referencedColumnName = "typeofInstitution",nullable = false,insertable = false,updatable = false)
    })
    public List<YearTable51412> yearTable51412;
    
    
    @OneToMany(cascade= {CascadeType.PERSIST,CascadeType.MERGE},fetch = FetchType.LAZY)
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumns ({
        @JoinColumn(name="collegeId", referencedColumnName = "collegeId",nullable = false,insertable = false,updatable = false),
        @JoinColumn(name="financialYear", referencedColumnName = "financialYear",nullable = false,insertable = false,updatable = false),
        @JoinColumn(name="typeofInstitution", referencedColumnName = "typeofInstitution",nullable = false,insertable = false,updatable = false)
    })
    public List<YearTable5211> yearTable5211;
    
    @OneToMany(cascade= {CascadeType.PERSIST,CascadeType.MERGE},fetch = FetchType.LAZY)
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumns ({
        @JoinColumn(name="collegeId", referencedColumnName = "collegeId",nullable = false,insertable = false,updatable = false),
        @JoinColumn(name="financialYear", referencedColumnName = "financialYear",nullable = false,insertable = false,updatable = false),
        @JoinColumn(name="typeofInstitution", referencedColumnName = "typeofInstitution",nullable = false,insertable = false,updatable = false)
    })
    public List<YearTable52112> yearTable52112;
    
    @OneToMany(cascade= {CascadeType.PERSIST,CascadeType.MERGE},fetch = FetchType.LAZY)
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumns ({
        @JoinColumn(name="collegeId", referencedColumnName = "collegeId",nullable = false,insertable = false,updatable = false),
        @JoinColumn(name="financialYear", referencedColumnName = "financialYear",nullable = false,insertable = false,updatable = false),
        @JoinColumn(name="typeofInstitution", referencedColumnName = "typeofInstitution",nullable = false,insertable = false,updatable = false)
    })
    public List<UniversityYearTable5221> universityYearTable5221;
    
    @OneToMany(cascade= {CascadeType.PERSIST,CascadeType.MERGE},fetch = FetchType.LAZY)
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumns ({
        @JoinColumn(name="collegeId", referencedColumnName = "collegeId",nullable = false,insertable = false,updatable = false),
        @JoinColumn(name="financialYear", referencedColumnName = "financialYear",nullable = false,insertable = false,updatable = false),
        @JoinColumn(name="typeofInstitution", referencedColumnName = "typeofInstitution",nullable = false,insertable = false,updatable = false)
    })
    public List<Affiliated_YearTable5212> affiliatedYearTable5212;
    

    @OneToMany(cascade= {CascadeType.PERSIST,CascadeType.MERGE},fetch = FetchType.LAZY)
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumns ({
        @JoinColumn(name="collegeId", referencedColumnName = "collegeId",nullable = false,insertable = false,updatable = false),
        @JoinColumn(name="financialYear", referencedColumnName = "financialYear",nullable = false,insertable = false,updatable = false),
        @JoinColumn(name="typeofInstitution", referencedColumnName = "typeofInstitution",nullable = false,insertable = false,updatable = false)
    })
    public List<Affiliated_YearTable5221> affiliatedYearTable5221;
    
    
    
    @OneToMany(cascade= {CascadeType.PERSIST,CascadeType.MERGE},fetch = FetchType.LAZY)
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumns ({
        @JoinColumn(name="collegeId", referencedColumnName = "collegeId",nullable = false,insertable = false,updatable = false),
        @JoinColumn(name="financialYear", referencedColumnName = "financialYear",nullable = false,insertable = false,updatable = false),
        @JoinColumn(name="typeofInstitution", referencedColumnName = "typeofInstitution",nullable = false,insertable = false,updatable = false)
    })
    public List<Affiliated_YearTable5222> affiliatedYearTable5222;
    
    
    @OneToMany(cascade= {CascadeType.PERSIST,CascadeType.MERGE},fetch = FetchType.LAZY)
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumns ({
        @JoinColumn(name="collegeId", referencedColumnName = "collegeId",nullable = false,insertable = false,updatable = false),
        @JoinColumn(name="financialYear", referencedColumnName = "financialYear",nullable = false,insertable = false,updatable = false),
        @JoinColumn(name="typeofInstitution", referencedColumnName = "typeofInstitution",nullable = false,insertable = false,updatable = false)
    })
    public List<Affiliated_YearTable5321> affiliatedYearTable5321;
    
    
    @OneToMany(cascade= {CascadeType.PERSIST,CascadeType.MERGE},fetch = FetchType.LAZY)
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumns ({
        @JoinColumn(name="collegeId", referencedColumnName = "collegeId",nullable = false,insertable = false,updatable = false),
        @JoinColumn(name="financialYear", referencedColumnName = "financialYear",nullable = false,insertable = false,updatable = false),
        @JoinColumn(name="typeofInstitution", referencedColumnName = "typeofInstitution",nullable = false,insertable = false,updatable = false)
    })
    public List<UniversityYearTable52212> universityYearTable52212;
    
    
    @OneToMany(cascade= {CascadeType.PERSIST,CascadeType.MERGE},fetch = FetchType.LAZY)
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumns ({
        @JoinColumn(name="collegeId", referencedColumnName = "collegeId",nullable = false,insertable = false,updatable = false),
        @JoinColumn(name="financialYear", referencedColumnName = "financialYear",nullable = false,insertable = false,updatable = false),
        @JoinColumn(name="typeofInstitution", referencedColumnName = "typeofInstitution",nullable = false,insertable = false,updatable = false)
    })
    public List<YearTable51312> yearTable51312;


	public CriteriaPrimaryKey getCriteriaId() {
		return criteriaId;
	}


	public void setCriteriaId(CriteriaPrimaryKey criteriaId) {
		this.criteriaId = criteriaId;
	}


	public List<Criteria51Qn> getCriteria51Qn() {
		return criteria51Qn;
	}


	public void setCriteria51Qn(List<Criteria51Qn> criteria51Qn) {
		this.criteria51Qn = criteria51Qn;
	}


	public List<Criteria52Qn> getCriteria52Qn() {
		return criteria52Qn;
	}


	public void setCriteria52Qn(List<Criteria52Qn> criteria52Qn) {
		this.criteria52Qn = criteria52Qn;
	}


	public List<Criteria53Qn> getCriteria53Qn() {
		return criteria53Qn;
	}


	public void setCriteria53Qn(List<Criteria53Qn> criteria53Qn) {
		this.criteria53Qn = criteria53Qn;
	}


	public List<Criteria54Ql> getCriteria54Ql() {
		return criteria54Ql;
	}


	public void setCriteria54Ql(List<Criteria54Ql> criteria54Ql) {
		this.criteria54Ql = criteria54Ql;
	}


	public List<Criteria5_FileUpload> getCriteria5FileUpload() {
		return criteria5FileUpload;
	}


	public void setCriteria5FileUpload(List<Criteria5_FileUpload> criteria5FileUpload) {
		this.criteria5FileUpload = criteria5FileUpload;
	}


	public List<YearTable5111> getYearTable5111() {
		return yearTable5111;
	}


	public void setYearTable5111(List<YearTable5111> yearTable5111) {
		this.yearTable5111 = yearTable5111;
	}


	public List<YearTable51112> getYearTable51112() {
		return yearTable51112;
	}


	public void setYearTable51112(List<YearTable51112> yearTable51112) {
		this.yearTable51112 = yearTable51112;
	}


	public List<YearTable5121> getYearTable5121() {
		return yearTable5121;
	}


	public void setYearTable5121(List<YearTable5121> yearTable5121) {
		this.yearTable5121 = yearTable5121;
	}


	public List<YearTable51212> getYearTable51212() {
		return yearTable51212;
	}


	public void setYearTable51212(List<YearTable51212> yearTable51212) {
		this.yearTable51212 = yearTable51212;
	}


	public List<Affiliated_YearTable5131> getAffiliatedYearTable5131() {
		return affiliatedYearTable5131;
	}


	public void setAffiliatedYearTable5131(List<Affiliated_YearTable5131> affiliatedYearTable5131) {
		this.affiliatedYearTable5131 = affiliatedYearTable5131;
	}


	public List<YearTable5231> getYearTable5231() {
		return yearTable5231;
	}


	public void setYearTable5231(List<YearTable5231> yearTable5231) {
		this.yearTable5231 = yearTable5231;
	}


	public List<YearTable5232> getYearTable5232() {
		return yearTable5232;
	}


	public void setYearTable5232(List<YearTable5232> yearTable5232) {
		this.yearTable5232 = yearTable5232;
	}


	public List<YearTable5311> getYearTable5311() {
		return yearTable5311;
	}


	public void setYearTable5311(List<YearTable5311> yearTable5311) {
		this.yearTable5311 = yearTable5311;
	}


	public List<YearTable5331> getYearTable5331() {
		return yearTable5331;
	}


	public void setYearTable5331(List<YearTable5331> yearTable5331) {
		this.yearTable5331 = yearTable5331;
	}


	public List<YearTable5141> getYearTable5141() {
		return yearTable5141;
	}


	public void setYearTable5141(List<YearTable5141> yearTable5141) {
		this.yearTable5141 = yearTable5141;
	}


	public List<YearTable51412> getYearTable51412() {
		return yearTable51412;
	}


	public void setYearTable51412(List<YearTable51412> yearTable51412) {
		this.yearTable51412 = yearTable51412;
	}


	public List<YearTable5211> getYearTable5211() {
		return yearTable5211;
	}


	public void setYearTable5211(List<YearTable5211> yearTable5211) {
		this.yearTable5211 = yearTable5211;
	}


	public List<YearTable52112> getYearTable52112() {
		return yearTable52112;
	}


	public void setYearTable52112(List<YearTable52112> yearTable52112) {
		this.yearTable52112 = yearTable52112;
	}


	public List<UniversityYearTable5221> getUniversityYearTable5221() {
		return universityYearTable5221;
	}


	public void setUniversityYearTable5221(List<UniversityYearTable5221> universityYearTable5221) {
		this.universityYearTable5221 = universityYearTable5221;
	}


	public List<Affiliated_YearTable5212> getAffiliatedYearTable5212() {
		return affiliatedYearTable5212;
	}


	public void setAffiliatedYearTable5212(List<Affiliated_YearTable5212> affiliatedYearTable5212) {
		this.affiliatedYearTable5212 = affiliatedYearTable5212;
	}


	public List<Affiliated_YearTable5221> getAffiliatedYearTable5221() {
		return affiliatedYearTable5221;
	}


	public void setAffiliatedYearTable5221(List<Affiliated_YearTable5221> affiliatedYearTable5221) {
		this.affiliatedYearTable5221 = affiliatedYearTable5221;
	}


	public List<Affiliated_YearTable5222> getAffiliatedYearTable5222() {
		return affiliatedYearTable5222;
	}


	public void setAffiliatedYearTable5222(List<Affiliated_YearTable5222> affiliatedYearTable5222) {
		this.affiliatedYearTable5222 = affiliatedYearTable5222;
	}


	public List<Affiliated_YearTable5321> getAffiliatedYearTable5321() {
		return affiliatedYearTable5321;
	}


	public void setAffiliatedYearTable5321(List<Affiliated_YearTable5321> affiliatedYearTable5321) {
		this.affiliatedYearTable5321 = affiliatedYearTable5321;
	}


	public List<UniversityYearTable52212> getUniversityYearTable52212() {
		return universityYearTable52212;
	}


	public void setUniversityYearTable52212(List<UniversityYearTable52212> universityYearTable52212) {
		this.universityYearTable52212 = universityYearTable52212;
	}


	public List<YearTable51312> getYearTable51312() {
		return yearTable51312;
	}


	public void setYearTable51312(List<YearTable51312> yearTable51312) {
		this.yearTable51312 = yearTable51312;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}
    

    
    
    
    

}
