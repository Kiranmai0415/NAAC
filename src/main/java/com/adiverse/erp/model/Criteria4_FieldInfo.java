package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

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
@Table(name ="criteria4_fieldinfo")
public class Criteria4_FieldInfo implements Serializable {
	
	private static final long serialVersionUID = 7473207777668077807L;

	@Id
    public CriteriaPrimaryKey criteriaId;



	  @OneToMany(cascade= {CascadeType.PERSIST,CascadeType.MERGE},fetch = FetchType.LAZY)
	    @NotFound(action = NotFoundAction.IGNORE)	 
	    @JoinColumns ({
	        @JoinColumn(name="collegeId", referencedColumnName = "collegeId",nullable = false,insertable =false,updatable =false),
	        @JoinColumn(name="financialYear", referencedColumnName = "financialYear",nullable = false,insertable =false,updatable =false),
	        @JoinColumn(name="typeofInstitution", referencedColumnName = "typeofInstitution",nullable = false,insertable =false,updatable =false)
	    })
	    public List<Criteria41Ql> criteria41Ql;
	  
	  
	  @OneToMany(cascade= {CascadeType.PERSIST,CascadeType.MERGE},fetch = FetchType.LAZY)
	    @NotFound(action = NotFoundAction.IGNORE)	 
	    @JoinColumns ({
	        @JoinColumn(name="collegeId", referencedColumnName = "collegeId",nullable = false,insertable =false,updatable =false),
	        @JoinColumn(name="financialYear", referencedColumnName = "financialYear",nullable = false,insertable =false,updatable =false),
	        @JoinColumn(name="typeofInstitution", referencedColumnName = "typeofInstitution",nullable = false,insertable =false,updatable =false)
	    })
	    public List<Criteria41Qn> criteria41Qn;
	  
	  
	  

	  @OneToMany(cascade= {CascadeType.PERSIST,CascadeType.MERGE},fetch = FetchType.LAZY)
	    @NotFound(action = NotFoundAction.IGNORE)	 
	    @JoinColumns ({
	        @JoinColumn(name="collegeId", referencedColumnName = "collegeId",nullable = false,insertable =false,updatable =false),
	        @JoinColumn(name="financialYear", referencedColumnName = "financialYear",nullable = false,insertable =false,updatable =false),
	        @JoinColumn(name="typeofInstitution", referencedColumnName = "typeofInstitution",nullable = false,insertable =false,updatable =false)
	    })
	    public List<Criteria42Ql> criteria42Ql;
	    
	    

		  @OneToMany(cascade= {CascadeType.PERSIST,CascadeType.MERGE},fetch = FetchType.LAZY)
		    @NotFound(action = NotFoundAction.IGNORE)	 
	    @JoinColumns ({
	        @JoinColumn(name="collegeId", referencedColumnName = "collegeId",nullable = false,insertable =false,updatable =false),
	        @JoinColumn(name="financialYear", referencedColumnName = "financialYear",nullable = false,insertable =false,updatable =false),
	        @JoinColumn(name="typeofInstitution", referencedColumnName = "typeofInstitution",nullable = false,insertable =false,updatable =false)
	    })
	    public List<Criteria42Qn> criteria42Qn;
	    

		  @OneToMany(cascade= {CascadeType.PERSIST,CascadeType.MERGE},fetch = FetchType.LAZY)
		    @NotFound(action = NotFoundAction.IGNORE)	 
	    @JoinColumns ({
	        @JoinColumn(name="collegeId", referencedColumnName = "collegeId",nullable = false,insertable =false,updatable =false),
	        @JoinColumn(name="financialYear", referencedColumnName = "financialYear",nullable = false,insertable =false,updatable =false),
	        @JoinColumn(name="typeofInstitution", referencedColumnName = "typeofInstitution",nullable = false,insertable =false,updatable =false)
	    })
	    public List<Criteria43Ql> criteria43Ql;
	    
	
	    
	    

		  @OneToMany(cascade= {CascadeType.PERSIST,CascadeType.MERGE},fetch = FetchType.LAZY)
		    @NotFound(action = NotFoundAction.IGNORE)	 
	    @JoinColumns ({
	        @JoinColumn(name="collegeId", referencedColumnName = "collegeId",nullable = false,insertable =false,updatable =false),
	        @JoinColumn(name="financialYear", referencedColumnName = "financialYear",nullable = false,insertable =false,updatable =false),
	        @JoinColumn(name="typeofInstitution", referencedColumnName = "typeofInstitution",nullable = false,insertable =false,updatable =false)
	    })
	    public List<Criteria43Qn> criteria43Qn;

		  @OneToMany(cascade= {CascadeType.PERSIST,CascadeType.MERGE},fetch = FetchType.LAZY)
		    @NotFound(action = NotFoundAction.IGNORE)	 
	    @JoinColumns ({
	        @JoinColumn(name="collegeId", referencedColumnName = "collegeId",nullable = false,insertable =false,updatable =false),
	        @JoinColumn(name="financialYear", referencedColumnName = "financialYear",nullable = false,insertable =false,updatable =false),
	        @JoinColumn(name="typeofInstitution", referencedColumnName = "typeofInstitution",nullable = false,insertable =false,updatable =false)
	    })
	    public List<Criteria44Ql> criteria44Ql;
	    
	
	
//    @OneToMany(cascade=CascadeType.ALL)
//    @JoinColumns ({
//        @JoinColumn(name="collegeId", referencedColumnName = "collegeId",nullable = false,insertable =false,updatable =false),
//        @JoinColumn(name="financialYear", referencedColumnName = "financialYear",nullable = false,insertable =false,updatable =false),
//        @JoinColumn(name="typeofInstitution", referencedColumnName = "typeofInstitution",nullable = false,insertable =false,updatable =false)
//    })
//    public List<Criteria4_FieldInfoQl> criteria4FieldInfoQl;
//    
//    @OneToMany(cascade=CascadeType.ALL)
//    @JoinColumns ({
//        @JoinColumn(name="collegeId", referencedColumnName = "collegeId",nullable = false,insertable =false,updatable =false),
//        @JoinColumn(name="financialYear", referencedColumnName = "financialYear",nullable = false,insertable =false,updatable =false),
//        @JoinColumn(name="typeofInstitution", referencedColumnName = "typeofInstitution",nullable = false,insertable =false,updatable =false)
//    })
//    public List<Criteria4_FieldInfoQn> criteria4FieldInfoQn;
//    
    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumns ({
        @JoinColumn(name="collegeId", referencedColumnName = "collegeId",nullable = false,insertable =false,updatable =false),
        @JoinColumn(name="financialYear", referencedColumnName = "financialYear",nullable = false,insertable =false,updatable =false),
        @JoinColumn(name="typeofInstitution", referencedColumnName = "typeofInstitution",nullable = false,insertable =false,updatable =false)
    })
    public List<Criteria4_FileUpload> criteria4FileUpload;
    
    
    @OneToMany(cascade= {CascadeType.PERSIST,CascadeType.MERGE},fetch = FetchType.LAZY)
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumns ({
        @JoinColumn(name="collegeId", referencedColumnName = "collegeId",nullable = false,insertable =false,updatable =false),
        @JoinColumn(name="financialYear", referencedColumnName = "financialYear",nullable = false,insertable =false,updatable =false),
        @JoinColumn(name="typeofInstitution", referencedColumnName = "typeofInstitution",nullable = false,insertable =false,updatable =false)
    })
    public List<YearTable4141> yearTable4141;
    
    
    @OneToMany(cascade= {CascadeType.PERSIST,CascadeType.MERGE},fetch = FetchType.LAZY)
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumns ({
        @JoinColumn(name="collegeId", referencedColumnName = "collegeId",nullable = false,insertable =false,updatable =false),
        @JoinColumn(name="financialYear", referencedColumnName = "financialYear",nullable = false,insertable =false,updatable =false),
        @JoinColumn(name="typeofInstitution", referencedColumnName = "typeofInstitution",nullable = false,insertable =false,updatable =false)
    })
    public List<YearTable41412> yearTable41412;
    
    
    @OneToMany(cascade= {CascadeType.PERSIST,CascadeType.MERGE},fetch = FetchType.LAZY)
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumns ({
        @JoinColumn(name="collegeId", referencedColumnName = "collegeId",nullable = false,insertable =false,updatable =false),
        @JoinColumn(name="financialYear", referencedColumnName = "financialYear",nullable = false,insertable =false,updatable =false),
        @JoinColumn(name="typeofInstitution", referencedColumnName = "typeofInstitution",nullable = false,insertable =false,updatable =false)
    })
    public List<YearTable4231> yearTable4231;
    
    
    @OneToMany(cascade= {CascadeType.PERSIST,CascadeType.MERGE},fetch = FetchType.LAZY)
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumns ({
        @JoinColumn(name="collegeId", referencedColumnName = "collegeId",nullable = false,insertable =false,updatable =false),
        @JoinColumn(name="financialYear", referencedColumnName = "financialYear",nullable = false,insertable =false,updatable =false),
        @JoinColumn(name="typeofInstitution", referencedColumnName = "typeofInstitution",nullable = false,insertable =false,updatable =false)
    })
    public List<YearTable4411> yearTable4411;
    
    
    @OneToMany(cascade= {CascadeType.PERSIST,CascadeType.MERGE},fetch = FetchType.LAZY)
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumns ({
        @JoinColumn(name="collegeId", referencedColumnName = "collegeId",nullable = false,insertable =false,updatable =false),
        @JoinColumn(name="financialYear", referencedColumnName = "financialYear",nullable = false,insertable =false,updatable =false),
        @JoinColumn(name="typeofInstitution", referencedColumnName = "typeofInstitution",nullable = false,insertable =false,updatable =false)
    })
    public List<YearTable44112> yearTable44112;
    
    
    
    @OneToMany(cascade= {CascadeType.PERSIST,CascadeType.MERGE},fetch = FetchType.LAZY)
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumns ({
        @JoinColumn(name="collegeId", referencedColumnName = "collegeId",nullable = false,insertable =false,updatable =false),
        @JoinColumn(name="financialYear", referencedColumnName = "financialYear",nullable = false,insertable =false,updatable =false),
        @JoinColumn(name="typeofInstitution", referencedColumnName = "typeofInstitution",nullable = false,insertable =false,updatable =false)
    })
    public List<Affiliated_YearTable4121> affiliatedYearTable4121;
    
    @OneToMany(cascade= {CascadeType.PERSIST,CascadeType.MERGE},fetch = FetchType.LAZY)
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumns ({
        @JoinColumn(name="collegeId", referencedColumnName = "collegeId",nullable = false,insertable =false,updatable =false),
        @JoinColumn(name="financialYear", referencedColumnName = "financialYear",nullable = false,insertable =false,updatable =false),
        @JoinColumn(name="typeofInstitution", referencedColumnName = "typeofInstitution",nullable = false,insertable =false,updatable =false)
    })
    public List<Affiliated_YearTable41212> affiliatedYearTable41212;

	public CriteriaPrimaryKey getCriteriaId() {
		return criteriaId;
	}

	public void setCriteriaId(CriteriaPrimaryKey criteriaId) {
		this.criteriaId = criteriaId;
	}

	public List<Criteria41Ql> getCriteria41Ql() {
		return criteria41Ql;
	}

	public void setCriteria41Ql(List<Criteria41Ql> criteria41Ql) {
		this.criteria41Ql = criteria41Ql;
	}

	public List<Criteria41Qn> getCriteria41Qn() {
		return criteria41Qn;
	}

	public void setCriteria41Qn(List<Criteria41Qn> criteria41Qn) {
		this.criteria41Qn = criteria41Qn;
	}

	public List<Criteria42Ql> getCriteria42Ql() {
		return criteria42Ql;
	}

	public void setCriteria42Ql(List<Criteria42Ql> criteria42Ql) {
		this.criteria42Ql = criteria42Ql;
	}

	public List<Criteria42Qn> getCriteria42Qn() {
		return criteria42Qn;
	}

	public void setCriteria42Qn(List<Criteria42Qn> criteria42Qn) {
		this.criteria42Qn = criteria42Qn;
	}

	public List<Criteria43Ql> getCriteria43Ql() {
		return criteria43Ql;
	}

	public void setCriteria43Ql(List<Criteria43Ql> criteria43Ql) {
		this.criteria43Ql = criteria43Ql;
	}

	public List<Criteria43Qn> getCriteria43Qn() {
		return criteria43Qn;
	}

	public void setCriteria43Qn(List<Criteria43Qn> criteria43Qn) {
		this.criteria43Qn = criteria43Qn;
	}

	public List<Criteria44Ql> getCriteria44Ql() {
		return criteria44Ql;
	}

	public void setCriteria44Ql(List<Criteria44Ql> criteria44Ql) {
		this.criteria44Ql = criteria44Ql;
	}

	public List<Criteria4_FileUpload> getCriteria4FileUpload() {
		return criteria4FileUpload;
	}

	public void setCriteria4FileUpload(List<Criteria4_FileUpload> criteria4FileUpload) {
		this.criteria4FileUpload = criteria4FileUpload;
	}

	public List<YearTable4141> getYearTable4141() {
		return yearTable4141;
	}

	public void setYearTable4141(List<YearTable4141> yearTable4141) {
		this.yearTable4141 = yearTable4141;
	}

	public List<YearTable41412> getYearTable41412() {
		return yearTable41412;
	}

	public void setYearTable41412(List<YearTable41412> yearTable41412) {
		this.yearTable41412 = yearTable41412;
	}

	public List<YearTable4231> getYearTable4231() {
		return yearTable4231;
	}

	public void setYearTable4231(List<YearTable4231> yearTable4231) {
		this.yearTable4231 = yearTable4231;
	}

	public List<YearTable4411> getYearTable4411() {
		return yearTable4411;
	}

	public void setYearTable4411(List<YearTable4411> yearTable4411) {
		this.yearTable4411 = yearTable4411;
	}

	public List<YearTable44112> getYearTable44112() {
		return yearTable44112;
	}

	public void setYearTable44112(List<YearTable44112> yearTable44112) {
		this.yearTable44112 = yearTable44112;
	}

	public List<Affiliated_YearTable4121> getAffiliatedYearTable4121() {
		return affiliatedYearTable4121;
	}

	public void setAffiliatedYearTable4121(List<Affiliated_YearTable4121> affiliatedYearTable4121) {
		this.affiliatedYearTable4121 = affiliatedYearTable4121;
	}

	public List<Affiliated_YearTable41212> getAffiliatedYearTable41212() {
		return affiliatedYearTable41212;
	}

	public void setAffiliatedYearTable41212(List<Affiliated_YearTable41212> affiliatedYearTable41212) {
		this.affiliatedYearTable41212 = affiliatedYearTable41212;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	


    
    
}
