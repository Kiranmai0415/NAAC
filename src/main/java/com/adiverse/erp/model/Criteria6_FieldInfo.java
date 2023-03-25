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
@Table(name ="criteria6_fieldinfo")
public class Criteria6_FieldInfo implements Serializable {
	
	private static final long serialVersionUID = 384884159595539439L;

	@Id
	 public CriteriaPrimaryKey criteriaId;
	
	
	 @OneToMany(cascade= {CascadeType.PERSIST,CascadeType.MERGE},fetch = FetchType.LAZY)
	    @NotFound(action = NotFoundAction.IGNORE)
	    @JoinColumns ({
	        @JoinColumn(name="collegeId", referencedColumnName = "collegeId",nullable = false,insertable = false,updatable = false),
	        @JoinColumn(name="financialYear", referencedColumnName = "financialYear",nullable = false,insertable = false,updatable = false),
	        @JoinColumn(name="typeofInstitution", referencedColumnName = "typeofInstitution",nullable = false,insertable = false,updatable = false)
	    })
	    public List<Criteria61Ql> criteria61Ql;
	 
	 @OneToMany(cascade= {CascadeType.PERSIST,CascadeType.MERGE},fetch = FetchType.LAZY)
	    @NotFound(action = NotFoundAction.IGNORE)
	    @JoinColumns ({
	        @JoinColumn(name="collegeId", referencedColumnName = "collegeId",nullable = false,insertable = false,updatable = false),
	        @JoinColumn(name="financialYear", referencedColumnName = "financialYear",nullable = false,insertable = false,updatable = false),
	        @JoinColumn(name="typeofInstitution", referencedColumnName = "typeofInstitution",nullable = false,insertable = false,updatable = false)
	    })
	    public List<Criteria61Qn> criteria61Qn;
	 
	 @OneToMany(cascade= {CascadeType.PERSIST,CascadeType.MERGE},fetch = FetchType.LAZY)
	    @NotFound(action = NotFoundAction.IGNORE)
	    @JoinColumns ({
	        @JoinColumn(name="collegeId", referencedColumnName = "collegeId",nullable = false,insertable = false,updatable = false),
	        @JoinColumn(name="financialYear", referencedColumnName = "financialYear",nullable = false,insertable = false,updatable = false),
	        @JoinColumn(name="typeofInstitution", referencedColumnName = "typeofInstitution",nullable = false,insertable = false,updatable = false)
	    })
	    public List<Criteria62Ql> criteria62Ql;
	 
	 @OneToMany(cascade= {CascadeType.PERSIST,CascadeType.MERGE},fetch = FetchType.LAZY)
	    @NotFound(action = NotFoundAction.IGNORE)
	    @JoinColumns ({
	        @JoinColumn(name="collegeId", referencedColumnName = "collegeId",nullable = false,insertable = false,updatable = false),
	        @JoinColumn(name="financialYear", referencedColumnName = "financialYear",nullable = false,insertable = false,updatable = false),
	        @JoinColumn(name="typeofInstitution", referencedColumnName = "typeofInstitution",nullable = false,insertable = false,updatable = false)
	    })
	    public List<Criteria62Qn> criteria62Qn;
	 
	 
	 @OneToMany(cascade= {CascadeType.PERSIST,CascadeType.MERGE},fetch = FetchType.LAZY)
	    @NotFound(action = NotFoundAction.IGNORE)
	    @JoinColumns ({
	        @JoinColumn(name="collegeId", referencedColumnName = "collegeId",nullable = false,insertable = false,updatable = false),
	        @JoinColumn(name="financialYear", referencedColumnName = "financialYear",nullable = false,insertable = false,updatable = false),
	        @JoinColumn(name="typeofInstitution", referencedColumnName = "typeofInstitution",nullable = false,insertable = false,updatable = false)
	    })
	    public List<Criteria63Ql> criteria63Ql;
	 
	 
	 @OneToMany(cascade= {CascadeType.PERSIST,CascadeType.MERGE},fetch = FetchType.LAZY)
	    @NotFound(action = NotFoundAction.IGNORE)
	    @JoinColumns ({
	        @JoinColumn(name="collegeId", referencedColumnName = "collegeId",nullable = false,insertable = false,updatable = false),
	        @JoinColumn(name="financialYear", referencedColumnName = "financialYear",nullable = false,insertable = false,updatable = false),
	        @JoinColumn(name="typeofInstitution", referencedColumnName = "typeofInstitution",nullable = false,insertable = false,updatable = false)
	    })
	    public List<Criteria63Qn> criteria63Qn;
	 
	 
	 @OneToMany(cascade= {CascadeType.PERSIST,CascadeType.MERGE},fetch = FetchType.LAZY)
	    @NotFound(action = NotFoundAction.IGNORE)
	    @JoinColumns ({
	        @JoinColumn(name="collegeId", referencedColumnName = "collegeId",nullable = false,insertable = false,updatable = false),
	        @JoinColumn(name="financialYear", referencedColumnName = "financialYear",nullable = false,insertable = false,updatable = false),
	        @JoinColumn(name="typeofInstitution", referencedColumnName = "typeofInstitution",nullable = false,insertable = false,updatable = false)
	    })
	    public List<Criteria64Ql> criteria64Ql;
	 
	 
	   @OneToMany(cascade= {CascadeType.PERSIST,CascadeType.MERGE},fetch = FetchType.LAZY)
	   @NotFound(action = NotFoundAction.IGNORE)
	    @JoinColumns ({
	        @JoinColumn(name="collegeId", referencedColumnName = "collegeId",nullable = false,insertable = false,updatable = false),
	        @JoinColumn(name="financialYear", referencedColumnName = "financialYear",nullable = false,insertable = false,updatable = false),
	        @JoinColumn(name="typeofInstitution", referencedColumnName = "typeofInstitution",nullable = false,insertable = false,updatable = false)
	    })
	    public List<Criteria64Qn> criteria64Qn;
	 
	   
	   @OneToMany(cascade= {CascadeType.PERSIST,CascadeType.MERGE},fetch = FetchType.LAZY)
	   @NotFound(action = NotFoundAction.IGNORE)
	    @JoinColumns ({
	        @JoinColumn(name="collegeId", referencedColumnName = "collegeId",nullable = false,insertable = false,updatable = false),
	        @JoinColumn(name="financialYear", referencedColumnName = "financialYear",nullable = false,insertable = false,updatable = false),
	        @JoinColumn(name="typeofInstitution", referencedColumnName = "typeofInstitution",nullable = false,insertable = false,updatable = false)
	    })
	    public List<Criteria65Ql> criteria65Ql;
	   
	   @OneToMany(cascade= {CascadeType.PERSIST,CascadeType.MERGE},fetch = FetchType.LAZY)
	   @NotFound(action = NotFoundAction.IGNORE)
	    @JoinColumns ({
	        @JoinColumn(name="collegeId", referencedColumnName = "collegeId",nullable = false,insertable = false,updatable = false),
	        @JoinColumn(name="financialYear", referencedColumnName = "financialYear",nullable = false,insertable = false,updatable = false),
	        @JoinColumn(name="typeofInstitution", referencedColumnName = "typeofInstitution",nullable = false,insertable = false,updatable = false)
	    })
	    public List<Criteria65Qn> criteria65Qn;
	   
	   
	   
	 
	 
	 
	 
	 
	
	
	 
//	
//	 @OneToMany(cascade=CascadeType.ALL)
//	    @JoinColumns ({
//	        @JoinColumn(name="collegeId", referencedColumnName = "collegeId",nullable = false,insertable = false,updatable = false),
//	        @JoinColumn(name="financialYear", referencedColumnName = "financialYear",nullable = false,insertable = false,updatable = false),
//	        @JoinColumn(name="typeofInstitution", referencedColumnName = "typeofInstitution",nullable = false,insertable = false,updatable = false)
//	    })
//	    public List<Criteria6_FieldInfoQl> criteria6FieldInfoQl;
//		
//	    @OneToMany(cascade=CascadeType.ALL)
//	    @JoinColumns ({
//	        @JoinColumn(name="collegeId", referencedColumnName = "collegeId",nullable = false,insertable = false,updatable = false),
//	        @JoinColumn(name="financialYear", referencedColumnName = "financialYear",nullable = false,insertable = false,updatable = false),
//	        @JoinColumn(name="typeofInstitution", referencedColumnName = "typeofInstitution",nullable = false,insertable = false,updatable = false)
//	    })
//	    public List<Criteria6_FieldInfoQn> criteria6FieldInfoQn;
	    

	    
	    //changes
	    
	    @OneToMany(cascade= {CascadeType.PERSIST,CascadeType.MERGE},fetch = FetchType.LAZY)
	    @NotFound(action = NotFoundAction.IGNORE)
	    @JoinColumns ({
	        @JoinColumn(name="collegeId", referencedColumnName = "collegeId",nullable = false,insertable = false,updatable = false),
	        @JoinColumn(name="financialYear", referencedColumnName = "financialYear",nullable = false,insertable = false,updatable = false),
	        @JoinColumn(name="typeofInstitution", referencedColumnName = "typeofInstitution",nullable = false,insertable = false,updatable = false)
	    })
	    public List<YearTable6321> yearTable6321;
	    
	    @OneToMany(cascade= {CascadeType.PERSIST,CascadeType.MERGE},fetch = FetchType.LAZY)
	    @NotFound(action = NotFoundAction.IGNORE)
	    @JoinColumns ({
	        @JoinColumn(name="collegeId", referencedColumnName = "collegeId",nullable = false,insertable = false,updatable = false),
	        @JoinColumn(name="financialYear", referencedColumnName = "financialYear",nullable = false,insertable = false,updatable = false),
	        @JoinColumn(name="typeofInstitution", referencedColumnName = "typeofInstitution",nullable = false,insertable = false,updatable = false)
	    })
	    public List<YearTable63212> yearTable63212;
	    

	    @OneToMany(cascade= {CascadeType.PERSIST,CascadeType.MERGE},fetch = FetchType.LAZY)
	    @NotFound(action = NotFoundAction.IGNORE)
	    @JoinColumns ({
	        @JoinColumn(name="collegeId", referencedColumnName = "collegeId",nullable = false,insertable = false,updatable = false),
	        @JoinColumn(name="financialYear", referencedColumnName = "financialYear",nullable = false,insertable = false,updatable = false),
	        @JoinColumn(name="typeofInstitution", referencedColumnName = "typeofInstitution",nullable = false,insertable = false,updatable = false)
	    })
	    public List<YearTable6331> yearTable6331;
	    
	    @OneToMany(cascade= {CascadeType.PERSIST,CascadeType.MERGE},fetch = FetchType.LAZY)
	    @NotFound(action = NotFoundAction.IGNORE)
	    @JoinColumns ({
	        @JoinColumn(name="collegeId", referencedColumnName = "collegeId",nullable = false,insertable = false,updatable = false),
	        @JoinColumn(name="financialYear", referencedColumnName = "financialYear",nullable = false,insertable = false,updatable = false),
	        @JoinColumn(name="typeofInstitution", referencedColumnName = "typeofInstitution",nullable = false,insertable = false,updatable = false)
	    })
	    public List<Affiliated_YearTable6332> affiliated_YearTable6332;
	   
	    

	    @OneToMany(cascade= {CascadeType.PERSIST,CascadeType.MERGE},fetch = FetchType.LAZY)
	    @NotFound(action = NotFoundAction.IGNORE)
	    @JoinColumns ({
	        @JoinColumn(name="collegeId", referencedColumnName = "collegeId",nullable = false,insertable = false,updatable = false),
	        @JoinColumn(name="financialYear", referencedColumnName = "financialYear",nullable = false,insertable = false,updatable = false),
	        @JoinColumn(name="typeofInstitution", referencedColumnName = "typeofInstitution",nullable = false,insertable = false,updatable = false)
	    })
	    public List<YearTable6341> yearTable6341;
	    
	    @OneToMany(cascade= {CascadeType.PERSIST,CascadeType.MERGE},fetch = FetchType.LAZY)
	    @NotFound(action = NotFoundAction.IGNORE)
	    @JoinColumns ({
	        @JoinColumn(name="collegeId", referencedColumnName = "collegeId",nullable = false,insertable = false,updatable = false),
	        @JoinColumn(name="financialYear", referencedColumnName = "financialYear",nullable = false,insertable = false,updatable = false),
	        @JoinColumn(name="typeofInstitution", referencedColumnName = "typeofInstitution",nullable = false,insertable = false,updatable = false)
	    })
	    public List<YearTable63412> yearTable63412;
	    

	    @OneToMany(cascade= {CascadeType.PERSIST,CascadeType.MERGE},fetch = FetchType.LAZY)
	    @NotFound(action = NotFoundAction.IGNORE)
	    @JoinColumns ({
	        @JoinColumn(name="collegeId", referencedColumnName = "collegeId",nullable = false,insertable = false,updatable = false),
	        @JoinColumn(name="financialYear", referencedColumnName = "financialYear",nullable = false,insertable = false,updatable = false),
	        @JoinColumn(name="typeofInstitution", referencedColumnName = "typeofInstitution",nullable = false,insertable = false,updatable = false)
	    })
	    public List<YearTable6421> yearTable6421;
	    
		   
	    @OneToMany(cascade= {CascadeType.PERSIST,CascadeType.MERGE},fetch = FetchType.LAZY)
	    @NotFound(action = NotFoundAction.IGNORE)
	    @JoinColumns ({
	        @JoinColumn(name="collegeId", referencedColumnName = "collegeId",nullable = false,insertable = false,updatable = false),
	        @JoinColumn(name="financialYear", referencedColumnName = "financialYear",nullable = false,insertable = false,updatable = false),
	        @JoinColumn(name="typeofInstitution", referencedColumnName = "typeofInstitution",nullable = false,insertable = false,updatable = false)
	    })
	    public List<Criteria6_FileUpload> criteria6FileUpload;


		public CriteriaPrimaryKey getCriteriaId() {
			return criteriaId;
		}


		public void setCriteriaId(CriteriaPrimaryKey criteriaId) {
			this.criteriaId = criteriaId;
		}


		public List<Criteria61Ql> getCriteria61Ql() {
			return criteria61Ql;
		}


		public void setCriteria61Ql(List<Criteria61Ql> criteria61Ql) {
			this.criteria61Ql = criteria61Ql;
		}


		public List<Criteria61Qn> getCriteria61Qn() {
			return criteria61Qn;
		}


		public void setCriteria61Qn(List<Criteria61Qn> criteria61Qn) {
			this.criteria61Qn = criteria61Qn;
		}


		public List<Criteria62Ql> getCriteria62Ql() {
			return criteria62Ql;
		}


		public void setCriteria62Ql(List<Criteria62Ql> criteria62Ql) {
			this.criteria62Ql = criteria62Ql;
		}


		public List<Criteria62Qn> getCriteria62Qn() {
			return criteria62Qn;
		}


		public void setCriteria62Qn(List<Criteria62Qn> criteria62Qn) {
			this.criteria62Qn = criteria62Qn;
		}


		public List<Criteria63Ql> getCriteria63Ql() {
			return criteria63Ql;
		}


		public void setCriteria63Ql(List<Criteria63Ql> criteria63Ql) {
			this.criteria63Ql = criteria63Ql;
		}


		public List<Criteria63Qn> getCriteria63Qn() {
			return criteria63Qn;
		}


		public void setCriteria63Qn(List<Criteria63Qn> criteria63Qn) {
			this.criteria63Qn = criteria63Qn;
		}


		public List<Criteria64Ql> getCriteria64Ql() {
			return criteria64Ql;
		}


		public void setCriteria64Ql(List<Criteria64Ql> criteria64Ql) {
			this.criteria64Ql = criteria64Ql;
		}


		public List<Criteria64Qn> getCriteria64Qn() {
			return criteria64Qn;
		}


		public void setCriteria64Qn(List<Criteria64Qn> criteria64Qn) {
			this.criteria64Qn = criteria64Qn;
		}


		public List<Criteria65Ql> getCriteria65Ql() {
			return criteria65Ql;
		}


		public void setCriteria65Ql(List<Criteria65Ql> criteria65Ql) {
			this.criteria65Ql = criteria65Ql;
		}


		public List<Criteria65Qn> getCriteria65Qn() {
			return criteria65Qn;
		}


		public void setCriteria65Qn(List<Criteria65Qn> criteria65Qn) {
			this.criteria65Qn = criteria65Qn;
		}


		public List<YearTable6321> getYearTable6321() {
			return yearTable6321;
		}


		public void setYearTable6321(List<YearTable6321> yearTable6321) {
			this.yearTable6321 = yearTable6321;
		}


		public List<YearTable63212> getYearTable63212() {
			return yearTable63212;
		}


		public void setYearTable63212(List<YearTable63212> yearTable63212) {
			this.yearTable63212 = yearTable63212;
		}


		public List<YearTable6331> getYearTable6331() {
			return yearTable6331;
		}


		public void setYearTable6331(List<YearTable6331> yearTable6331) {
			this.yearTable6331 = yearTable6331;
		}


		public List<Affiliated_YearTable6332> getAffiliated_YearTable6332() {
			return affiliated_YearTable6332;
		}


		public void setAffiliated_YearTable6332(List<Affiliated_YearTable6332> affiliated_YearTable6332) {
			this.affiliated_YearTable6332 = affiliated_YearTable6332;
		}


		public List<YearTable6341> getYearTable6341() {
			return yearTable6341;
		}


		public void setYearTable6341(List<YearTable6341> yearTable6341) {
			this.yearTable6341 = yearTable6341;
		}


		public List<YearTable63412> getYearTable63412() {
			return yearTable63412;
		}


		public void setYearTable63412(List<YearTable63412> yearTable63412) {
			this.yearTable63412 = yearTable63412;
		}


		public List<YearTable6421> getYearTable6421() {
			return yearTable6421;
		}


		public void setYearTable6421(List<YearTable6421> yearTable6421) {
			this.yearTable6421 = yearTable6421;
		}


		public List<Criteria6_FileUpload> getCriteria6FileUpload() {
			return criteria6FileUpload;
		}


		public void setCriteria6FileUpload(List<Criteria6_FileUpload> criteria6FileUpload) {
			this.criteria6FileUpload = criteria6FileUpload;
		}


		public static long getSerialversionuid() {
			return serialVersionUID;
		}


	

		
}
