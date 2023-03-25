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
@Table(name ="criteria7_fieldinfo")
public class Criteria7_FieldInfo implements Serializable{
	
	private static final long serialVersionUID = 4708923488494526011L;

	@EmbeddedId
	 public CriteriaPrimaryKey criteriaId;
	
	
	@OneToMany(cascade= {CascadeType.PERSIST,CascadeType.MERGE},fetch = FetchType.LAZY)
    @NotFound(action = NotFoundAction.IGNORE)	
	    @JoinColumns ({
	        @JoinColumn(name="collegeId", referencedColumnName = "collegeId",nullable = false,insertable = false,updatable = false),
	        @JoinColumn(name="financialYear", referencedColumnName = "financialYear",nullable = false,insertable = false,updatable = false),
	        @JoinColumn(name="typeofInstitution", referencedColumnName = "typeofInstitution",nullable = false,insertable = false,updatable = false)
	    })
	    public List<Criteria71Ql> criteria71Ql;
	
	
	
	@OneToMany(cascade= {CascadeType.PERSIST,CascadeType.MERGE},fetch = FetchType.LAZY)
    @NotFound(action = NotFoundAction.IGNORE)	
	    @JoinColumns ({
	        @JoinColumn(name="collegeId", referencedColumnName = "collegeId",nullable = false,insertable = false,updatable = false),
	        @JoinColumn(name="financialYear", referencedColumnName = "financialYear",nullable = false,insertable = false,updatable = false),
	        @JoinColumn(name="typeofInstitution", referencedColumnName = "typeofInstitution",nullable = false,insertable = false,updatable = false)
	    })
	    public List<Criteria71Qn> criteria71Qn;
	
	@OneToMany(cascade= {CascadeType.PERSIST,CascadeType.MERGE},fetch = FetchType.LAZY)
    @NotFound(action = NotFoundAction.IGNORE)	
	    @JoinColumns ({
	        @JoinColumn(name="collegeId", referencedColumnName = "collegeId",nullable = false,insertable = false,updatable = false),
	        @JoinColumn(name="financialYear", referencedColumnName = "financialYear",nullable = false,insertable = false,updatable = false),
	        @JoinColumn(name="typeofInstitution", referencedColumnName = "typeofInstitution",nullable = false,insertable = false,updatable = false)
	    })
	    public List<Criteria72Ql> criteria72Ql;
	
	@OneToMany(cascade= {CascadeType.PERSIST,CascadeType.MERGE},fetch = FetchType.LAZY)
    @NotFound(action = NotFoundAction.IGNORE)	
	    @JoinColumns ({
	        @JoinColumn(name="collegeId", referencedColumnName = "collegeId",nullable = false,insertable = false,updatable = false),
	        @JoinColumn(name="financialYear", referencedColumnName = "financialYear",nullable = false,insertable = false,updatable = false),
	        @JoinColumn(name="typeofInstitution", referencedColumnName = "typeofInstitution",nullable = false,insertable = false,updatable = false)
	    })
	    public List<Criteria73Ql> criteria73Ql;
	

	
	
//	 @OneToMany(cascade=CascadeType.ALL)
//	    @JoinColumns ({
//	        @JoinColumn(name="collegeId", referencedColumnName = "collegeId",nullable = false,insertable = false,updatable = false),
//	        @JoinColumn(name="financialYear", referencedColumnName = "financialYear",nullable = false,insertable = false,updatable = false),
//	        @JoinColumn(name="typeofInstitution", referencedColumnName = "typeofInstitution",nullable = false,insertable = false,updatable = false)
//	    })
//	    public List<Criteria7_FieldInfoQl> criteria7FieldInfoQl;
//		
//	    @OneToMany(cascade=CascadeType.ALL)
//	    @JoinColumns ({
//	        @JoinColumn(name="collegeId", referencedColumnName = "collegeId",nullable = false,insertable = false,updatable = false),
//	        @JoinColumn(name="financialYear", referencedColumnName = "financialYear",nullable = false,insertable = false,updatable = false),
//	        @JoinColumn(name="typeofInstitution", referencedColumnName = "typeofInstitution",nullable = false,insertable = false,updatable = false)
//	    })
//	    public List<Criteria7_FieldInfoQn> criteria7FieldInfoQn;
//	    
	@OneToMany(cascade= {CascadeType.PERSIST,CascadeType.MERGE},fetch = FetchType.LAZY)
    @NotFound(action = NotFoundAction.IGNORE)
	    @JoinColumns ({
	        @JoinColumn(name="collegeId", referencedColumnName = "collegeId",nullable = false,insertable = false,updatable = false),
	        @JoinColumn(name="financialYear", referencedColumnName = "financialYear",nullable = false,insertable = false,updatable = false),
	        @JoinColumn(name="typeofInstitution", referencedColumnName = "typeofInstitution",nullable = false,insertable = false,updatable = false)
	    })
	    public List<Criteria7_FileUpload> criteria7FileUpload;




	public CriteriaPrimaryKey getCriteriaId() {
		return criteriaId;
	}




	public void setCriteriaId(CriteriaPrimaryKey criteriaId) {
		this.criteriaId = criteriaId;
	}




	public List<Criteria71Ql> getCriteria71Ql() {
		return criteria71Ql;
	}




	public void setCriteria71Ql(List<Criteria71Ql> criteria71Ql) {
		this.criteria71Ql = criteria71Ql;
	}




	public List<Criteria71Qn> getCriteria71Qn() {
		return criteria71Qn;
	}




	public void setCriteria71Qn(List<Criteria71Qn> criteria71Qn) {
		this.criteria71Qn = criteria71Qn;
	}




	public List<Criteria72Ql> getCriteria72Ql() {
		return criteria72Ql;
	}




	public void setCriteria72Ql(List<Criteria72Ql> criteria72Ql) {
		this.criteria72Ql = criteria72Ql;
	}




	public List<Criteria73Ql> getCriteria73Ql() {
		return criteria73Ql;
	}




	public void setCriteria73Ql(List<Criteria73Ql> criteria73Ql) {
		this.criteria73Ql = criteria73Ql;
	}




	public List<Criteria7_FileUpload> getCriteria7FileUpload() {
		return criteria7FileUpload;
	}




	public void setCriteria7FileUpload(List<Criteria7_FileUpload> criteria7FileUpload) {
		this.criteria7FileUpload = criteria7FileUpload;
	}




	public static long getSerialversionuid() {
		return serialVersionUID;
	}




	
		
}
