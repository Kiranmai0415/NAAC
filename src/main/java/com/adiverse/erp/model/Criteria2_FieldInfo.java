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
@Table(name ="criteria2_fieldinfo")
public class Criteria2_FieldInfo implements Serializable
{
	
	private static final long serialVersionUID = 4920532919687126600L;

	
	@Id
    public CriteriaPrimaryKey criteriaId;
	
	
	
	
	@OneToMany(cascade= {CascadeType.PERSIST,CascadeType.MERGE},fetch = FetchType.LAZY)
    @NotFound(action = NotFoundAction.IGNORE)	
	    @JoinColumns ({
	        @JoinColumn(name="collegeId", referencedColumnName = "collegeId",nullable = false,insertable = false,updatable = false),
	        @JoinColumn(name="financialYear", referencedColumnName = "financialYear",nullable = false,insertable = false,updatable = false),
	        @JoinColumn(name="typeofInstitution", referencedColumnName = "typeofInstitution",nullable = false,insertable = false,updatable = false)
	    })
	    public List<Criteria21Qn> criteria21Qn;
		
	

	@OneToMany(cascade= {CascadeType.PERSIST,CascadeType.MERGE},fetch = FetchType.LAZY)
    @NotFound(action = NotFoundAction.IGNORE)	
	    @JoinColumns ({
	        @JoinColumn(name="collegeId", referencedColumnName = "collegeId",nullable = false,insertable = false,updatable = false),
	        @JoinColumn(name="financialYear", referencedColumnName = "financialYear",nullable = false,insertable = false,updatable = false),
	        @JoinColumn(name="typeofInstitution", referencedColumnName = "typeofInstitution",nullable = false,insertable = false,updatable = false)
	    })
	    public List<Criteria22Qn> criteria22Qn;
		

	@OneToMany(cascade= {CascadeType.PERSIST,CascadeType.MERGE},fetch = FetchType.LAZY)
    @NotFound(action = NotFoundAction.IGNORE)	
	    @JoinColumns ({
	        @JoinColumn(name="collegeId", referencedColumnName = "collegeId",nullable = false,insertable = false,updatable = false),
	        @JoinColumn(name="financialYear", referencedColumnName = "financialYear",nullable = false,insertable = false,updatable = false),
	        @JoinColumn(name="typeofInstitution", referencedColumnName = "typeofInstitution",nullable = false,insertable = false,updatable = false)
	    })
	    public List<Criteria23Ql> criteria23Ql;
		
	

	@OneToMany(cascade= {CascadeType.PERSIST,CascadeType.MERGE},fetch = FetchType.LAZY)
    @NotFound(action = NotFoundAction.IGNORE)	
	    @JoinColumns ({
	        @JoinColumn(name="collegeId", referencedColumnName = "collegeId",nullable = false,insertable = false,updatable = false),
	        @JoinColumn(name="financialYear", referencedColumnName = "financialYear",nullable = false,insertable = false,updatable = false),
	        @JoinColumn(name="typeofInstitution", referencedColumnName = "typeofInstitution",nullable = false,insertable = false,updatable = false)
	    })
	    public List<Criteria23Qn> criteria23Qn;
		
	@OneToMany(cascade= {CascadeType.PERSIST,CascadeType.MERGE},fetch = FetchType.LAZY)
    @NotFound(action = NotFoundAction.IGNORE)	
	    @JoinColumns ({
	        @JoinColumn(name="collegeId", referencedColumnName = "collegeId",nullable = false,insertable = false,updatable = false),
	        @JoinColumn(name="financialYear", referencedColumnName = "financialYear",nullable = false,insertable = false,updatable = false),
	        @JoinColumn(name="typeofInstitution", referencedColumnName = "typeofInstitution",nullable = false,insertable = false,updatable = false)
	    })
	    public List<Criteria24Qn> criteria24Qn;
		
	@OneToMany(cascade= {CascadeType.PERSIST,CascadeType.MERGE},fetch = FetchType.LAZY)
    @NotFound(action = NotFoundAction.IGNORE)	
	    @JoinColumns ({
	        @JoinColumn(name="collegeId", referencedColumnName = "collegeId",nullable = false,insertable = false,updatable = false),
	        @JoinColumn(name="financialYear", referencedColumnName = "financialYear",nullable = false,insertable = false,updatable = false),
	        @JoinColumn(name="typeofInstitution", referencedColumnName = "typeofInstitution",nullable = false,insertable = false,updatable = false)
	    })
	    public List<Criteria25Ql> criteria25Ql;
		
	@OneToMany(cascade= {CascadeType.PERSIST,CascadeType.MERGE},fetch = FetchType.LAZY)
    @NotFound(action = NotFoundAction.IGNORE)	
	    @JoinColumns ({
	        @JoinColumn(name="collegeId", referencedColumnName = "collegeId",nullable = false,insertable = false,updatable = false),
	        @JoinColumn(name="financialYear", referencedColumnName = "financialYear",nullable = false,insertable = false,updatable = false),
	        @JoinColumn(name="typeofInstitution", referencedColumnName = "typeofInstitution",nullable = false,insertable = false,updatable = false)
	    })
	    public List<Criteria25Qn> criteria25Qn;
	
	
	@OneToMany(cascade= {CascadeType.PERSIST,CascadeType.MERGE},fetch = FetchType.LAZY)
    @NotFound(action = NotFoundAction.IGNORE)	
	    @JoinColumns ({
	        @JoinColumn(name="collegeId", referencedColumnName = "collegeId",nullable = false,insertable = false,updatable = false),
	        @JoinColumn(name="financialYear", referencedColumnName = "financialYear",nullable = false,insertable = false,updatable = false),
	        @JoinColumn(name="typeofInstitution", referencedColumnName = "typeofInstitution",nullable = false,insertable = false,updatable = false)
	    })
	    public List<Criteria26Ql> criteria26Ql;
	
	
	@OneToMany(cascade= {CascadeType.PERSIST,CascadeType.MERGE},fetch = FetchType.LAZY)
    @NotFound(action = NotFoundAction.IGNORE)	
	    @JoinColumns ({
	        @JoinColumn(name="collegeId", referencedColumnName = "collegeId",nullable = false,insertable = false,updatable = false),
	        @JoinColumn(name="financialYear", referencedColumnName = "financialYear",nullable = false,insertable = false,updatable = false),
	        @JoinColumn(name="typeofInstitution", referencedColumnName = "typeofInstitution",nullable = false,insertable = false,updatable = false)
	    })
	    public List<Criteria26Qn> criteria26Qn;
	
	@OneToMany(cascade= {CascadeType.PERSIST,CascadeType.MERGE},fetch = FetchType.LAZY)
    @NotFound(action = NotFoundAction.IGNORE)	
	    @JoinColumns ({
	        @JoinColumn(name="collegeId", referencedColumnName = "collegeId",nullable = false,insertable = false,updatable = false),
	        @JoinColumn(name="financialYear", referencedColumnName = "financialYear",nullable = false,insertable = false,updatable = false),
	        @JoinColumn(name="typeofInstitution", referencedColumnName = "typeofInstitution",nullable = false,insertable = false,updatable = false)
	    })
	    public List<Criteria27Ql> criteria27Ql;
	
	
//	 @OneToMany(cascade=CascadeType.ALL)
//	    @JoinColumns ({
//	        @JoinColumn(name="collegeId", referencedColumnName = "collegeId",nullable = false,insertable = false,updatable = false),
//	        @JoinColumn(name="financialYear", referencedColumnName = "financialYear",nullable = false,insertable = false,updatable = false),
//	        @JoinColumn(name="typeofInstitution", referencedColumnName = "typeofInstitution",nullable = false,insertable = false,updatable = false)
//	    })
//	    public List<Criteria2_FieldInfoQl> criteria2FieldInfoQl;
//		
//	    @OneToMany(cascade=CascadeType.ALL)
//	    @JoinColumns ({
//	        @JoinColumn(name="collegeId", referencedColumnName = "collegeId",nullable = false,insertable = false,updatable = false),
//	        @JoinColumn(name="financialYear", referencedColumnName = "financialYear",nullable = false,insertable = false,updatable = false),
//	        @JoinColumn(name="typeofInstitution", referencedColumnName = "typeofInstitution",nullable = false,insertable = false,updatable = false)
//	    })
//	    public List<Criteria2_FieldInfoQn> criteria2FieldInfoQn;
//	    
	    @OneToMany(cascade=CascadeType.ALL)
	    @JoinColumns ({
	        @JoinColumn(name="collegeId", referencedColumnName = "collegeId",nullable = false,insertable = false,updatable = false),
	        @JoinColumn(name="financialYear", referencedColumnName = "financialYear",nullable = false,insertable = false,updatable = false),
	        @JoinColumn(name="typeofInstitution", referencedColumnName = "typeofInstitution",nullable = false,insertable = false,updatable = false)
	    })
	    public List<Criteria2_FileUpload> criteria2FileUpload;
	    
	    //changes
	    
	    @OneToMany(cascade= {CascadeType.PERSIST,CascadeType.MERGE},fetch = FetchType.LAZY)
	    @NotFound(action = NotFoundAction.IGNORE)
	    @JoinColumns ({
	        @JoinColumn(name="collegeId", referencedColumnName = "collegeId",nullable = false,insertable = false,updatable = false),
	        @JoinColumn(name="financialYear", referencedColumnName = "financialYear",nullable = false,insertable = false,updatable = false),
	        @JoinColumn(name="typeofInstitution", referencedColumnName = "typeofInstitution",nullable = false,insertable = false,updatable = false)
	    })
	    public List<YearTable2111> yearTable2111;
	    

	    @OneToMany(cascade= {CascadeType.PERSIST,CascadeType.MERGE},fetch = FetchType.LAZY)
	    @NotFound(action = NotFoundAction.IGNORE)
	    @JoinColumns ({
	        @JoinColumn(name="collegeId", referencedColumnName = "collegeId",nullable = false,insertable = false,updatable = false),
	        @JoinColumn(name="financialYear", referencedColumnName = "financialYear",nullable = false,insertable = false,updatable = false),
	        @JoinColumn(name="typeofInstitution", referencedColumnName = "typeofInstitution",nullable = false,insertable = false,updatable = false)
	    })
	    public List<YearTable2112> yearTable2112;


	    @OneToMany(cascade=CascadeType.ALL)
	    @JoinColumns ({
	        @JoinColumn(name="collegeId", referencedColumnName = "collegeId",nullable = false,insertable = false,updatable = false),
	        @JoinColumn(name="financialYear", referencedColumnName = "financialYear",nullable = false,insertable = false,updatable = false),
	        @JoinColumn(name="typeofInstitution", referencedColumnName = "typeofInstitution",nullable = false,insertable = false,updatable = false)
	    })
	    public List<YearTable2121> yearTable2121;
	    
	    
	    @OneToMany(cascade=CascadeType.ALL)
	    @JoinColumns ({
	        @JoinColumn(name="collegeId", referencedColumnName = "collegeId",nullable = false,insertable = false,updatable = false),
	        @JoinColumn(name="financialYear", referencedColumnName = "financialYear",nullable = false,insertable = false,updatable = false),
	        @JoinColumn(name="typeofInstitution", referencedColumnName = "typeofInstitution",nullable = false,insertable = false,updatable = false)
	    })
	    public List<Affiliated_YearTable2122> affiliated_YearTable2122;
	    
	    


	    @OneToMany(cascade= {CascadeType.PERSIST,CascadeType.MERGE},fetch = FetchType.LAZY)
	    @NotFound(action = NotFoundAction.IGNORE)
	    @JoinColumns ({
	        @JoinColumn(name="collegeId", referencedColumnName = "collegeId",nullable = false,insertable = false,updatable = false),
	        @JoinColumn(name="financialYear", referencedColumnName = "financialYear",nullable = false,insertable = false,updatable = false),
	        @JoinColumn(name="typeofInstitution", referencedColumnName = "typeofInstitution",nullable = false,insertable = false,updatable = false)
	    })
	    public List<YearTable21212> yearTable21212;

	

	    @OneToMany(cascade= {CascadeType.PERSIST,CascadeType.MERGE},fetch = FetchType.LAZY)
	    @NotFound(action = NotFoundAction.IGNORE)
	    @JoinColumns ({
	        @JoinColumn(name="collegeId", referencedColumnName = "collegeId",nullable = false,insertable = false,updatable = false),
	        @JoinColumn(name="financialYear", referencedColumnName = "financialYear",nullable = false,insertable = false,updatable = false),
	        @JoinColumn(name="typeofInstitution", referencedColumnName = "typeofInstitution",nullable = false,insertable = false,updatable = false)
	    })
	    public List<YearTable2411> yearTable2411;
	    
	    @OneToMany(cascade= {CascadeType.PERSIST,CascadeType.MERGE},fetch = FetchType.LAZY)
	    @NotFound(action = NotFoundAction.IGNORE)
	    @JoinColumns ({
	        @JoinColumn(name="collegeId", referencedColumnName = "collegeId",nullable = false,insertable = false,updatable = false),
	        @JoinColumn(name="financialYear", referencedColumnName = "financialYear",nullable = false,insertable = false,updatable = false),
	        @JoinColumn(name="typeofInstitution", referencedColumnName = "typeofInstitution",nullable = false,insertable = false,updatable = false)
	    })
	    public List<YearTable24112> yearTable24112;

	
	    @OneToMany(cascade= {CascadeType.PERSIST,CascadeType.MERGE},fetch = FetchType.LAZY)
	    @NotFound(action = NotFoundAction.IGNORE)
	    @JoinColumns ({
	        @JoinColumn(name="collegeId", referencedColumnName = "collegeId",nullable = false,insertable = false,updatable = false),
	        @JoinColumn(name="financialYear", referencedColumnName = "financialYear",nullable = false,insertable = false,updatable = false),
	        @JoinColumn(name="typeofInstitution", referencedColumnName = "typeofInstitution",nullable = false,insertable = false,updatable = false)
	    })
	    public List<YearTable2412> yearTable2412;

	    @OneToMany(cascade= {CascadeType.PERSIST,CascadeType.MERGE},fetch = FetchType.LAZY)
	    @NotFound(action = NotFoundAction.IGNORE)
	    @JoinColumns ({
	        @JoinColumn(name="collegeId", referencedColumnName = "collegeId",nullable = false,insertable = false,updatable = false),
	        @JoinColumn(name="financialYear", referencedColumnName = "financialYear",nullable = false,insertable = false,updatable = false),
	        @JoinColumn(name="typeofInstitution", referencedColumnName = "typeofInstitution",nullable = false,insertable = false,updatable = false)
	    })
	    public List<YearTable2421> yearTable2421;

		

	    @OneToMany(cascade= {CascadeType.PERSIST,CascadeType.MERGE},fetch = FetchType.LAZY)
	    @NotFound(action = NotFoundAction.IGNORE)
	    @JoinColumns ({
	        @JoinColumn(name="collegeId", referencedColumnName = "collegeId",nullable = false,insertable = false,updatable = false),
	        @JoinColumn(name="financialYear", referencedColumnName = "financialYear",nullable = false,insertable = false,updatable = false),
	        @JoinColumn(name="typeofInstitution", referencedColumnName = "typeofInstitution",nullable = false,insertable = false,updatable = false)
	    })
	    public List<YearTable24212> yearTable24212;

	    @OneToMany(cascade= {CascadeType.PERSIST,CascadeType.MERGE},fetch = FetchType.LAZY)
	    @NotFound(action = NotFoundAction.IGNORE)
	    @JoinColumns ({
	        @JoinColumn(name="collegeId", referencedColumnName = "collegeId",nullable = false,insertable = false,updatable = false),
	        @JoinColumn(name="financialYear", referencedColumnName = "financialYear",nullable = false,insertable = false,updatable = false),
	        @JoinColumn(name="typeofInstitution", referencedColumnName = "typeofInstitution",nullable = false,insertable = false,updatable = false)
	    })
	    public List<YearTable2511> yearTable2511;

	    @OneToMany(cascade= {CascadeType.PERSIST,CascadeType.MERGE},fetch = FetchType.LAZY)
	    @NotFound(action = NotFoundAction.IGNORE)
	    @JoinColumns ({
	        @JoinColumn(name="collegeId", referencedColumnName = "collegeId",nullable = false,insertable = false,updatable = false),
	        @JoinColumn(name="financialYear", referencedColumnName = "financialYear",nullable = false,insertable = false,updatable = false),
	        @JoinColumn(name="typeofInstitution", referencedColumnName = "typeofInstitution",nullable = false,insertable = false,updatable = false)
	    })
	    public List<YearTable2521> yearTable2521;


	    @OneToMany(cascade= {CascadeType.PERSIST,CascadeType.MERGE},fetch = FetchType.LAZY)
	    @NotFound(action = NotFoundAction.IGNORE)
	    @JoinColumns ({
	        @JoinColumn(name="collegeId", referencedColumnName = "collegeId",nullable = false,insertable = false,updatable = false),
	        @JoinColumn(name="financialYear", referencedColumnName = "financialYear",nullable = false,insertable = false,updatable = false),
	        @JoinColumn(name="typeofInstitution", referencedColumnName = "typeofInstitution",nullable = false,insertable = false,updatable = false)
	    })
	    public List<YearTable25212> yearTable25212;
	    
	    
	    @OneToMany(cascade= {CascadeType.PERSIST,CascadeType.MERGE},fetch = FetchType.LAZY)
	    @NotFound(action = NotFoundAction.IGNORE)
	    @JoinColumns ({
	        @JoinColumn(name="collegeId", referencedColumnName = "collegeId",nullable = false,insertable = false,updatable = false),
	        @JoinColumn(name="financialYear", referencedColumnName = "financialYear",nullable = false,insertable = false,updatable = false),
	        @JoinColumn(name="typeofInstitution", referencedColumnName = "typeofInstitution",nullable = false,insertable = false,updatable = false)
	    })
	    public List<UniversityYearTable2441> universityYearTable2441;
	    
	    
	    @OneToMany(cascade= {CascadeType.PERSIST,CascadeType.MERGE},fetch = FetchType.LAZY)
	    @NotFound(action = NotFoundAction.IGNORE)
	    @JoinColumns ({
	        @JoinColumn(name="collegeId", referencedColumnName = "collegeId",nullable = false,insertable = false,updatable = false),
	        @JoinColumn(name="financialYear", referencedColumnName = "financialYear",nullable = false,insertable = false,updatable = false),
	        @JoinColumn(name="typeofInstitution", referencedColumnName = "typeofInstitution",nullable = false,insertable = false,updatable = false)
	    })
	    public List<Affiliated_YearTable251> affiliated_YearTable251;
	    
	    
	    @OneToMany(cascade= {CascadeType.PERSIST,CascadeType.MERGE},fetch = FetchType.LAZY)
	    @NotFound(action = NotFoundAction.IGNORE)
	    @JoinColumns ({
	        @JoinColumn(name="collegeId", referencedColumnName = "collegeId",nullable = false,insertable = false,updatable = false),
	        @JoinColumn(name="financialYear", referencedColumnName = "financialYear",nullable = false,insertable = false,updatable = false),
	        @JoinColumn(name="typeofInstitution", referencedColumnName = "typeofInstitution",nullable = false,insertable = false,updatable = false)
	    })
	    public List<Affiliated_YearTable221> affiliated_YearTable221;
	    
	    
	    @OneToMany(cascade= {CascadeType.PERSIST,CascadeType.MERGE},fetch = FetchType.LAZY)
	    @NotFound(action = NotFoundAction.IGNORE)
	    @JoinColumns ({
	        @JoinColumn(name="collegeId", referencedColumnName = "collegeId",nullable = false,insertable = false,updatable = false),
	        @JoinColumn(name="financialYear", referencedColumnName = "financialYear",nullable = false,insertable = false,updatable = false),
	        @JoinColumn(name="typeofInstitution", referencedColumnName = "typeofInstitution",nullable = false,insertable = false,updatable = false)
	    })
	    public List<Affiliated_YearTable2621> affiliated_YearTable2621;
	    
	    
	    @OneToMany(cascade= {CascadeType.PERSIST,CascadeType.MERGE},fetch = FetchType.LAZY)
	    @NotFound(action = NotFoundAction.IGNORE)
	    @JoinColumns ({
	        @JoinColumn(name="collegeId", referencedColumnName = "collegeId",nullable = false,insertable = false,updatable = false),
	        @JoinColumn(name="financialYear", referencedColumnName = "financialYear",nullable = false,insertable = false,updatable = false),
	        @JoinColumn(name="typeofInstitution", referencedColumnName = "typeofInstitution",nullable = false,insertable = false,updatable = false)
	    })
	    public List<Affiliated_YearTable2622> affiliated_YearTable2622;
	    
	    
	    
	    @OneToMany(cascade= {CascadeType.PERSIST,CascadeType.MERGE},fetch = FetchType.LAZY)
	    @NotFound(action = NotFoundAction.IGNORE)
	    @JoinColumns ({
	        @JoinColumn(name="collegeId", referencedColumnName = "collegeId",nullable = false,insertable = false,updatable = false),
	        @JoinColumn(name="financialYear", referencedColumnName = "financialYear",nullable = false,insertable = false,updatable = false),
	        @JoinColumn(name="typeofInstitution", referencedColumnName = "typeofInstitution",nullable = false,insertable = false,updatable = false)
	    })
	    public List<Affiliated_YearTable2631> affiliatedyearTable2631;
	    
	    
	    
	    @OneToMany(cascade= {CascadeType.PERSIST,CascadeType.MERGE},fetch = FetchType.LAZY)
	    @NotFound(action = NotFoundAction.IGNORE)
	    @JoinColumns ({
	        @JoinColumn(name="collegeId", referencedColumnName = "collegeId",nullable = false,insertable = false,updatable = false),
	        @JoinColumn(name="financialYear", referencedColumnName = "financialYear",nullable = false,insertable = false,updatable = false),
	        @JoinColumn(name="typeofInstitution", referencedColumnName = "typeofInstitution",nullable = false,insertable = false,updatable = false)
	    })
	    public List<Affiliated_YearTable2632> affiliatedyearTable2632;
	    


		public CriteriaPrimaryKey getCriteriaId() {
			return criteriaId;
		}


		public void setCriteriaId(CriteriaPrimaryKey criteriaId) {
			this.criteriaId = criteriaId;
		}


		public List<Criteria21Qn> getCriteria21Qn() {
			return criteria21Qn;
		}


		public void setCriteria21Qn(List<Criteria21Qn> criteria21Qn) {
			this.criteria21Qn = criteria21Qn;
		}


		public List<Criteria22Qn> getCriteria22Qn() {
			return criteria22Qn;
		}


		public void setCriteria22Qn(List<Criteria22Qn> criteria22Qn) {
			this.criteria22Qn = criteria22Qn;
		}


		public List<Criteria23Ql> getCriteria23Ql() {
			return criteria23Ql;
		}


		public void setCriteria23Ql(List<Criteria23Ql> criteria23Ql) {
			this.criteria23Ql = criteria23Ql;
		}


		public List<Criteria23Qn> getCriteria23Qn() {
			return criteria23Qn;
		}


		public void setCriteria23Qn(List<Criteria23Qn> criteria23Qn) {
			this.criteria23Qn = criteria23Qn;
		}


		public List<Criteria24Qn> getCriteria24Qn() {
			return criteria24Qn;
		}


		public void setCriteria24Qn(List<Criteria24Qn> criteria24Qn) {
			this.criteria24Qn = criteria24Qn;
		}


		public List<Criteria25Ql> getCriteria25Ql() {
			return criteria25Ql;
		}


		public void setCriteria25Ql(List<Criteria25Ql> criteria25Ql) {
			this.criteria25Ql = criteria25Ql;
		}


		public List<Criteria25Qn> getCriteria25Qn() {
			return criteria25Qn;
		}


		public void setCriteria25Qn(List<Criteria25Qn> criteria25Qn) {
			this.criteria25Qn = criteria25Qn;
		}


		public List<Criteria26Ql> getCriteria26Ql() {
			return criteria26Ql;
		}


		public void setCriteria26Ql(List<Criteria26Ql> criteria26Ql) {
			this.criteria26Ql = criteria26Ql;
		}


		public List<Criteria26Qn> getCriteria26Qn() {
			return criteria26Qn;
		}


		public void setCriteria26Qn(List<Criteria26Qn> criteria26Qn) {
			this.criteria26Qn = criteria26Qn;
		}


		public List<Criteria27Ql> getCriteria27Ql() {
			return criteria27Ql;
		}


		public void setCriteria27Ql(List<Criteria27Ql> criteria27Ql) {
			this.criteria27Ql = criteria27Ql;
		}


		public List<Criteria2_FileUpload> getCriteria2FileUpload() {
			return criteria2FileUpload;
		}


		public void setCriteria2FileUpload(List<Criteria2_FileUpload> criteria2FileUpload) {
			this.criteria2FileUpload = criteria2FileUpload;
		}


		public List<YearTable2111> getYearTable2111() {
			return yearTable2111;
		}


		public void setYearTable2111(List<YearTable2111> yearTable2111) {
			this.yearTable2111 = yearTable2111;
		}


		public List<YearTable2112> getYearTable2112() {
			return yearTable2112;
		}


		public void setYearTable2112(List<YearTable2112> yearTable2112) {
			this.yearTable2112 = yearTable2112;
		}


		public List<YearTable2121> getYearTable2121() {
			return yearTable2121;
		}


		public void setYearTable2121(List<YearTable2121> yearTable2121) {
			this.yearTable2121 = yearTable2121;
		}


		public List<Affiliated_YearTable2122> getAffiliated_YearTable2122() {
			return affiliated_YearTable2122;
		}


		public void setAffiliated_YearTable2122(List<Affiliated_YearTable2122> affiliated_YearTable2122) {
			this.affiliated_YearTable2122 = affiliated_YearTable2122;
		}


		public List<YearTable21212> getYearTable21212() {
			return yearTable21212;
		}


		public void setYearTable21212(List<YearTable21212> yearTable21212) {
			this.yearTable21212 = yearTable21212;
		}


		public List<YearTable2411> getYearTable2411() {
			return yearTable2411;
		}


		public void setYearTable2411(List<YearTable2411> yearTable2411) {
			this.yearTable2411 = yearTable2411;
		}


		public List<YearTable24112> getYearTable24112() {
			return yearTable24112;
		}


		public void setYearTable24112(List<YearTable24112> yearTable24112) {
			this.yearTable24112 = yearTable24112;
		}


		public List<YearTable2412> getYearTable2412() {
			return yearTable2412;
		}


		public void setYearTable2412(List<YearTable2412> yearTable2412) {
			this.yearTable2412 = yearTable2412;
		}


		public List<YearTable2421> getYearTable2421() {
			return yearTable2421;
		}


		public void setYearTable2421(List<YearTable2421> yearTable2421) {
			this.yearTable2421 = yearTable2421;
		}


		public List<YearTable24212> getYearTable24212() {
			return yearTable24212;
		}


		public void setYearTable24212(List<YearTable24212> yearTable24212) {
			this.yearTable24212 = yearTable24212;
		}


		public List<YearTable2511> getYearTable2511() {
			return yearTable2511;
		}


		public void setYearTable2511(List<YearTable2511> yearTable2511) {
			this.yearTable2511 = yearTable2511;
		}


		public List<YearTable2521> getYearTable2521() {
			return yearTable2521;
		}


		public void setYearTable2521(List<YearTable2521> yearTable2521) {
			this.yearTable2521 = yearTable2521;
		}


		public List<YearTable25212> getYearTable25212() {
			return yearTable25212;
		}


		public void setYearTable25212(List<YearTable25212> yearTable25212) {
			this.yearTable25212 = yearTable25212;
		}


		public List<UniversityYearTable2441> getUniversityYearTable2441() {
			return universityYearTable2441;
		}


		public void setUniversityYearTable2441(List<UniversityYearTable2441> universityYearTable2441) {
			this.universityYearTable2441 = universityYearTable2441;
		}


		public List<Affiliated_YearTable251> getAffiliated_YearTable251() {
			return affiliated_YearTable251;
		}


		public void setAffiliated_YearTable251(List<Affiliated_YearTable251> affiliated_YearTable251) {
			this.affiliated_YearTable251 = affiliated_YearTable251;
		}


		public List<Affiliated_YearTable221> getAffiliated_YearTable221() {
			return affiliated_YearTable221;
		}


		public void setAffiliated_YearTable221(List<Affiliated_YearTable221> affiliated_YearTable221) {
			this.affiliated_YearTable221 = affiliated_YearTable221;
		}


		public List<Affiliated_YearTable2621> getAffiliated_YearTable2621() {
			return affiliated_YearTable2621;
		}


		public void setAffiliated_YearTable2621(List<Affiliated_YearTable2621> affiliated_YearTable2621) {
			this.affiliated_YearTable2621 = affiliated_YearTable2621;
		}


		public List<Affiliated_YearTable2622> getAffiliated_YearTable2622() {
			return affiliated_YearTable2622;
		}


		public void setAffiliated_YearTable2622(List<Affiliated_YearTable2622> affiliated_YearTable2622) {
			this.affiliated_YearTable2622 = affiliated_YearTable2622;
		}
		
		
		
		


		public List<Affiliated_YearTable2631> getAffiliatedyearTable2631() {
			return affiliatedyearTable2631;
		}


		public void setAffiliatedyearTable2631(List<Affiliated_YearTable2631> affiliatedyearTable2631) {
			this.affiliatedyearTable2631 = affiliatedyearTable2631;
		}


		public List<Affiliated_YearTable2632> getAffiliatedyearTable2632() {
			return affiliatedyearTable2632;
		}


		public void setAffiliatedyearTable2632(List<Affiliated_YearTable2632> affiliatedyearTable2632) {
			this.affiliatedyearTable2632 = affiliatedyearTable2632;
		}


		public static long getSerialversionuid() {
			return serialVersionUID;
		}


		

}
