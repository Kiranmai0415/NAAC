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
@Table(name ="criteria3_fieldinfo")
public class Criteria3_FieldInfo implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@EmbeddedId
    public CriteriaPrimaryKey criteriaId;
	
		
	@OneToMany(cascade= {CascadeType.PERSIST,CascadeType.MERGE},fetch = FetchType.LAZY)
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumns ({
        @JoinColumn(name="collegeId", referencedColumnName = "collegeId",nullable = false,insertable = false,updatable = false),
        @JoinColumn(name="financialYear", referencedColumnName = "financialYear",nullable = false,insertable = false,updatable = false),
        @JoinColumn(name="typeofInstitution", referencedColumnName = "typeofInstitution",nullable = false,insertable = false,updatable = false)
    })
    public List<Criteria31Ql> criteria31Ql;
	
	@OneToMany(cascade= {CascadeType.PERSIST,CascadeType.MERGE},fetch = FetchType.LAZY)
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumns ({
        @JoinColumn(name="collegeId", referencedColumnName = "collegeId",nullable = false,insertable = false,updatable = false),
        @JoinColumn(name="financialYear", referencedColumnName = "financialYear",nullable = false,insertable = false,updatable = false),
        @JoinColumn(name="typeofInstitution", referencedColumnName = "typeofInstitution",nullable = false,insertable = false,updatable = false)
    })
    public List<Criteria31Qn> criteria31Qn;
	
	
	@OneToMany(cascade= {CascadeType.PERSIST,CascadeType.MERGE},fetch = FetchType.LAZY)
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumns ({
        @JoinColumn(name="collegeId", referencedColumnName = "collegeId",nullable = false,insertable = false,updatable = false),
        @JoinColumn(name="financialYear", referencedColumnName = "financialYear",nullable = false,insertable = false,updatable = false),
        @JoinColumn(name="typeofInstitution", referencedColumnName = "typeofInstitution",nullable = false,insertable = false,updatable = false)
    })
    public List<Criteria32Ql> criteria32Ql;
	
	@OneToMany(cascade= {CascadeType.PERSIST,CascadeType.MERGE},fetch = FetchType.LAZY)
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumns ({
        @JoinColumn(name="collegeId", referencedColumnName = "collegeId",nullable = false,insertable = false,updatable = false),
        @JoinColumn(name="financialYear", referencedColumnName = "financialYear",nullable = false,insertable = false,updatable = false),
        @JoinColumn(name="typeofInstitution", referencedColumnName = "typeofInstitution",nullable = false,insertable = false,updatable = false)
    })
    public List<Criteria32Qn> criteria32Qn;
	
	
	@OneToMany(cascade= {CascadeType.PERSIST,CascadeType.MERGE},fetch = FetchType.LAZY)
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumns ({
        @JoinColumn(name="collegeId", referencedColumnName = "collegeId",nullable = false,insertable = false,updatable = false),
        @JoinColumn(name="financialYear", referencedColumnName = "financialYear",nullable = false,insertable = false,updatable = false),
        @JoinColumn(name="typeofInstitution", referencedColumnName = "typeofInstitution",nullable = false,insertable = false,updatable = false)
    })
    public List<Criteria33Ql> criteria33Ql;
	
	@OneToMany(cascade= {CascadeType.PERSIST,CascadeType.MERGE},fetch = FetchType.LAZY)
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumns ({
        @JoinColumn(name="collegeId", referencedColumnName = "collegeId",nullable = false,insertable = false,updatable = false),
        @JoinColumn(name="financialYear", referencedColumnName = "financialYear",nullable = false,insertable = false,updatable = false),
        @JoinColumn(name="typeofInstitution", referencedColumnName = "typeofInstitution",nullable = false,insertable = false,updatable = false)
    })
    public List<Criteria33Qn> criteria33Qn;
	
	
	@OneToMany(cascade= {CascadeType.PERSIST,CascadeType.MERGE},fetch = FetchType.LAZY)
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumns ({
        @JoinColumn(name="collegeId", referencedColumnName = "collegeId",nullable = false,insertable = false,updatable = false),
        @JoinColumn(name="financialYear", referencedColumnName = "financialYear",nullable = false,insertable = false,updatable = false),
        @JoinColumn(name="typeofInstitution", referencedColumnName = "typeofInstitution",nullable = false,insertable = false,updatable = false)
    })
    public List<Criteria34Ql> criteria34Ql;
	
	
	
	@OneToMany(cascade= {CascadeType.PERSIST,CascadeType.MERGE},fetch = FetchType.LAZY)
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumns ({
        @JoinColumn(name="collegeId", referencedColumnName = "collegeId",nullable = false,insertable = false,updatable = false),
        @JoinColumn(name="financialYear", referencedColumnName = "financialYear",nullable = false,insertable = false,updatable = false),
        @JoinColumn(name="typeofInstitution", referencedColumnName = "typeofInstitution",nullable = false,insertable = false,updatable = false)
    })
    public List<Criteria34Qn> criteria34Qn;
	
	
	
	
	@OneToMany(cascade= {CascadeType.PERSIST,CascadeType.MERGE},fetch = FetchType.LAZY)
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumns ({
        @JoinColumn(name="collegeId", referencedColumnName = "collegeId",nullable = false,insertable = false,updatable = false),
        @JoinColumn(name="financialYear", referencedColumnName = "financialYear",nullable = false,insertable = false,updatable = false),
        @JoinColumn(name="typeofInstitution", referencedColumnName = "typeofInstitution",nullable = false,insertable = false,updatable = false)
    })
    public List<Criteria35Ql> criteria35Ql;
	
	
	@OneToMany(cascade= {CascadeType.PERSIST,CascadeType.MERGE},fetch = FetchType.LAZY)
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumns ({
        @JoinColumn(name="collegeId", referencedColumnName = "collegeId",nullable = false,insertable = false,updatable = false),
        @JoinColumn(name="financialYear", referencedColumnName = "financialYear",nullable = false,insertable = false,updatable = false),
        @JoinColumn(name="typeofInstitution", referencedColumnName = "typeofInstitution",nullable = false,insertable = false,updatable = false)
    })
    public List<Criteria35Qn> criteria35Qn;
	
	@OneToMany(cascade= {CascadeType.PERSIST,CascadeType.MERGE},fetch = FetchType.LAZY)
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumns ({
        @JoinColumn(name="collegeId", referencedColumnName = "collegeId",nullable = false,insertable = false,updatable = false),
        @JoinColumn(name="financialYear", referencedColumnName = "financialYear",nullable = false,insertable = false,updatable = false),
        @JoinColumn(name="typeofInstitution", referencedColumnName = "typeofInstitution",nullable = false,insertable = false,updatable = false)
    })
    public List<Criteria36Ql> criteria36Ql;
	
	
	@OneToMany(cascade= {CascadeType.PERSIST,CascadeType.MERGE},fetch = FetchType.LAZY)
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumns ({
        @JoinColumn(name="collegeId", referencedColumnName = "collegeId",nullable = false,insertable = false,updatable = false),
        @JoinColumn(name="financialYear", referencedColumnName = "financialYear",nullable = false,insertable = false,updatable = false),
        @JoinColumn(name="typeofInstitution", referencedColumnName = "typeofInstitution",nullable = false,insertable = false,updatable = false)
    })
    public List<Criteria36Qn> criteria36Qn;
	
	
	@OneToMany(cascade= {CascadeType.PERSIST,CascadeType.MERGE},fetch = FetchType.LAZY)
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumns ({
        @JoinColumn(name="collegeId", referencedColumnName = "collegeId",nullable = false,insertable = false,updatable = false),
        @JoinColumn(name="financialYear", referencedColumnName = "financialYear",nullable = false,insertable = false,updatable = false),
        @JoinColumn(name="typeofInstitution", referencedColumnName = "typeofInstitution",nullable = false,insertable = false,updatable = false)
    })
    public List<Criteria37Qn> criteria37Qn;
	
	
	
	
	
	
	
	
	
//    @OneToMany(cascade= {CascadeType.PERSIST,CascadeType.MERGE},fetch = FetchType.LAZY)
//    @NotFound(action = NotFoundAction.IGNORE)
//    @JoinColumns ({
//        @JoinColumn(name="collegeId", referencedColumnName = "collegeId",nullable = false,insertable = false,updatable = false),
//        @JoinColumn(name="financialYear", referencedColumnName = "financialYear",nullable = false,insertable = false,updatable = false),
//        @JoinColumn(name="typeofInstitution", referencedColumnName = "typeofInstitution",nullable = false,insertable = false,updatable = false)
//    })
//    public List<Criteria3_FieldInfoQl> criteria3FieldInfoQl;
//	
//    @OneToMany(cascade= {CascadeType.PERSIST,CascadeType.MERGE},fetch = FetchType.LAZY)
//    @NotFound(action = NotFoundAction.IGNORE)
//    @JoinColumns ({
//        @JoinColumn(name="collegeId", referencedColumnName = "collegeId",nullable = false,insertable = false,updatable = false),
//        @JoinColumn(name="financialYear", referencedColumnName = "financialYear",nullable = false,insertable = false,updatable = false),
//        @JoinColumn(name="typeofInstitution", referencedColumnName = "typeofInstitution",nullable = false,insertable = false,updatable = false)
//    })
//    public List<Criteria3_FieldInfoQn> criteria3FieldInfoQn;
    
    @OneToMany(cascade= {CascadeType.PERSIST,CascadeType.MERGE},fetch = FetchType.LAZY)
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumns ({
        @JoinColumn(name="collegeId", referencedColumnName = "collegeId",nullable = false,insertable = false,updatable = false),
        @JoinColumn(name="financialYear", referencedColumnName = "financialYear",nullable = false,insertable = false,updatable = false),
        @JoinColumn(name="typeofInstitution", referencedColumnName = "typeofInstitution",nullable = false,insertable = false,updatable = false)
    })
    public List<Criteria3_FileUpload> criteria3FileUpload;
    
    @OneToMany(cascade= {CascadeType.PERSIST,CascadeType.MERGE},fetch = FetchType.LAZY)
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumns ({
        @JoinColumn(name="collegeId", referencedColumnName = "collegeId",nullable = false,insertable = false,updatable = false),
        @JoinColumn(name="financialYear", referencedColumnName = "financialYear",nullable = false,insertable = false,updatable = false),
        @JoinColumn(name="typeofInstitution", referencedColumnName = "typeofInstitution",nullable = false,insertable = false,updatable = false)
    })
    public List<YearTable3121> yearTable3121;
    
    @OneToMany(cascade= {CascadeType.PERSIST,CascadeType.MERGE},fetch = FetchType.LAZY)
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumns ({
        @JoinColumn(name="collegeId", referencedColumnName = "collegeId",nullable = false,insertable = false,updatable = false),
        @JoinColumn(name="financialYear", referencedColumnName = "financialYear",nullable = false,insertable = false,updatable = false),
        @JoinColumn(name="typeofInstitution", referencedColumnName = "typeofInstitution",nullable = false,insertable = false,updatable = false)
    })
    public List<YearTable3131> yearTable3131;
    
    @OneToMany(cascade= {CascadeType.PERSIST,CascadeType.MERGE},fetch = FetchType.LAZY)
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumns ({
        @JoinColumn(name="collegeId", referencedColumnName = "collegeId",nullable = false,insertable = false,updatable = false),
        @JoinColumn(name="financialYear", referencedColumnName = "financialYear",nullable = false,insertable = false,updatable = false),
        @JoinColumn(name="typeofInstitution", referencedColumnName = "typeofInstitution",nullable = false,insertable = false,updatable = false)
    })
    public List<YearTable3211> yearTable3211;
    
    @OneToMany(cascade= {CascadeType.PERSIST,CascadeType.MERGE},fetch = FetchType.LAZY)
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumns ({
        @JoinColumn(name="collegeId", referencedColumnName = "collegeId",nullable = false,insertable = false,updatable = false),
        @JoinColumn(name="financialYear", referencedColumnName = "financialYear",nullable = false,insertable = false,updatable = false),
        @JoinColumn(name="typeofInstitution", referencedColumnName = "typeofInstitution",nullable = false,insertable = false,updatable = false)
    })
    public List<YearTable3221> yearTable3221;
    
    @OneToMany(cascade= {CascadeType.PERSIST,CascadeType.MERGE},fetch = FetchType.LAZY)
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumns ({
        @JoinColumn(name="collegeId", referencedColumnName = "collegeId",nullable = false,insertable = false,updatable = false),
        @JoinColumn(name="financialYear", referencedColumnName = "financialYear",nullable = false,insertable = false,updatable = false),
        @JoinColumn(name="typeofInstitution", referencedColumnName = "typeofInstitution",nullable = false,insertable = false,updatable = false)
    })
    public List<YearTable3241> yearTable3241;
    
    @OneToMany(cascade= {CascadeType.PERSIST,CascadeType.MERGE},fetch = FetchType.LAZY)
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumns ({
        @JoinColumn(name="collegeId", referencedColumnName = "collegeId",nullable = false,insertable = false,updatable = false),
        @JoinColumn(name="financialYear", referencedColumnName = "financialYear",nullable = false,insertable = false,updatable = false),
        @JoinColumn(name="typeofInstitution", referencedColumnName = "typeofInstitution",nullable = false,insertable = false,updatable = false)
    })
    public List<YearTable3242> yearTable3242;

    
    @OneToMany(cascade= {CascadeType.PERSIST,CascadeType.MERGE},fetch = FetchType.LAZY)
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumns ({
        @JoinColumn(name="collegeId", referencedColumnName = "collegeId",nullable = false,insertable = false,updatable = false),
        @JoinColumn(name="financialYear", referencedColumnName = "financialYear",nullable = false,insertable = false,updatable = false),
        @JoinColumn(name="typeofInstitution", referencedColumnName = "typeofInstitution",nullable = false,insertable = false,updatable = false)
    })
    public List<YearTable3321> yearTable3321;
    
    @OneToMany(cascade= {CascadeType.PERSIST,CascadeType.MERGE},fetch = FetchType.LAZY)
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumns ({
        @JoinColumn(name="collegeId", referencedColumnName = "collegeId",nullable = false,insertable = false,updatable = false),
        @JoinColumn(name="financialYear", referencedColumnName = "financialYear",nullable = false,insertable = false,updatable = false),
        @JoinColumn(name="typeofInstitution", referencedColumnName = "typeofInstitution",nullable = false,insertable = false,updatable = false)
    })
    public List<YearTable3431> yearTable3431;
    
    @OneToMany(cascade= {CascadeType.PERSIST,CascadeType.MERGE},fetch = FetchType.LAZY)
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumns ({
        @JoinColumn(name="collegeId", referencedColumnName = "collegeId",nullable = false,insertable = false,updatable = false),
        @JoinColumn(name="financialYear", referencedColumnName = "financialYear",nullable = false,insertable = false,updatable = false),
        @JoinColumn(name="typeofInstitution", referencedColumnName = "typeofInstitution",nullable = false,insertable = false,updatable = false)
    })
    public List<YearTable3441> yearTable3441;
    
    @OneToMany(cascade= {CascadeType.PERSIST,CascadeType.MERGE},fetch = FetchType.LAZY)
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumns ({
        @JoinColumn(name="collegeId", referencedColumnName = "collegeId",nullable = false,insertable = false,updatable = false),
        @JoinColumn(name="financialYear", referencedColumnName = "financialYear",nullable = false,insertable = false,updatable = false),
        @JoinColumn(name="typeofInstitution", referencedColumnName = "typeofInstitution",nullable = false,insertable = false,updatable = false)
    })
    public List<YearTable3511> yearTable3511;
    
    @OneToMany(cascade= {CascadeType.PERSIST,CascadeType.MERGE},fetch = FetchType.LAZY)
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumns ({
        @JoinColumn(name="collegeId", referencedColumnName = "collegeId",nullable = false,insertable = false,updatable = false),
        @JoinColumn(name="financialYear", referencedColumnName = "financialYear",nullable = false,insertable = false,updatable = false),
        @JoinColumn(name="typeofInstitution", referencedColumnName = "typeofInstitution",nullable = false,insertable = false,updatable = false)
    })
    public List<YearTable3521> yearTable3521;
    
    @OneToMany(cascade= {CascadeType.PERSIST,CascadeType.MERGE},fetch = FetchType.LAZY)
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumns ({
        @JoinColumn(name="collegeId", referencedColumnName = "collegeId",nullable = false,insertable = false,updatable = false),
        @JoinColumn(name="financialYear", referencedColumnName = "financialYear",nullable = false,insertable = false,updatable = false),
        @JoinColumn(name="typeofInstitution", referencedColumnName = "typeofInstitution",nullable = false,insertable = false,updatable = false)
    })
    public List<YearTable3621> yearTable3621;
    
    @OneToMany(cascade= {CascadeType.PERSIST,CascadeType.MERGE},fetch = FetchType.LAZY)
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumns ({
        @JoinColumn(name="collegeId", referencedColumnName = "collegeId",nullable = false,insertable = false,updatable = false),
        @JoinColumn(name="financialYear", referencedColumnName = "financialYear",nullable = false,insertable = false,updatable = false),
        @JoinColumn(name="typeofInstitution", referencedColumnName = "typeofInstitution",nullable = false,insertable = false,updatable = false)
    })
    public List<YearTable3631> yearTable3631;
    
    @OneToMany(cascade= {CascadeType.PERSIST,CascadeType.MERGE},fetch = FetchType.LAZY)
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumns ({
        @JoinColumn(name="collegeId", referencedColumnName = "collegeId",nullable = false,insertable = false,updatable = false),
        @JoinColumn(name="financialYear", referencedColumnName = "financialYear",nullable = false,insertable = false,updatable = false),
        @JoinColumn(name="typeofInstitution", referencedColumnName = "typeofInstitution",nullable = false,insertable = false,updatable = false)
    })
    public List<YearTable3641> yearTable3641;
    
    
    @OneToMany(cascade= {CascadeType.PERSIST,CascadeType.MERGE},fetch = FetchType.LAZY)
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumns ({
        @JoinColumn(name="collegeId", referencedColumnName = "collegeId",nullable = false,insertable = false,updatable = false),
        @JoinColumn(name="financialYear", referencedColumnName = "financialYear",nullable = false,insertable = false,updatable = false),
        @JoinColumn(name="typeofInstitution", referencedColumnName = "typeofInstitution",nullable = false,insertable = false,updatable = false)
    })

    public List<YearTable36412> yearTable36412;
    
   
    

    
    @OneToMany(cascade= {CascadeType.PERSIST,CascadeType.MERGE},fetch = FetchType.LAZY)
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumns ({
        @JoinColumn(name="collegeId", referencedColumnName = "collegeId",nullable = false,insertable = false,updatable = false),
        @JoinColumn(name="financialYear", referencedColumnName = "financialYear",nullable = false,insertable = false,updatable = false),
        @JoinColumn(name="typeofInstitution", referencedColumnName = "typeofInstitution",nullable = false,insertable = false,updatable = false)
    })
    public List<UniversityYearTable3141> universityYearTable3141;
    
    @OneToMany(cascade= {CascadeType.PERSIST,CascadeType.MERGE},fetch = FetchType.LAZY)
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumns ({
        @JoinColumn(name="collegeId", referencedColumnName = "collegeId",nullable = false,insertable = false,updatable = false),
        @JoinColumn(name="financialYear", referencedColumnName = "financialYear",nullable = false,insertable = false,updatable = false),
        @JoinColumn(name="typeofInstitution", referencedColumnName = "typeofInstitution",nullable = false,insertable = false,updatable = false)
    })
    public List<UniversityYearTable3231> universityYearTable3231;
    
    @OneToMany(cascade= {CascadeType.PERSIST,CascadeType.MERGE},fetch = FetchType.LAZY)
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumns ({
        @JoinColumn(name="collegeId", referencedColumnName = "collegeId",nullable = false,insertable = false,updatable = false),
        @JoinColumn(name="financialYear", referencedColumnName = "financialYear",nullable = false,insertable = false,updatable = false),
        @JoinColumn(name="typeofInstitution", referencedColumnName = "typeofInstitution",nullable = false,insertable = false,updatable = false)
    })
    public List<UniversityYearTable3232> universityYearTable3232;
    
    @OneToMany(cascade= {CascadeType.PERSIST,CascadeType.MERGE},fetch = FetchType.LAZY)
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumns ({
        @JoinColumn(name="collegeId", referencedColumnName = "collegeId",nullable = false,insertable = false,updatable = false),
        @JoinColumn(name="financialYear", referencedColumnName = "financialYear",nullable = false,insertable = false,updatable = false),
        @JoinColumn(name="typeofInstitution", referencedColumnName = "typeofInstitution",nullable = false,insertable = false,updatable = false)
    })
    public List<UniversityYearTable3331> universityYearTable3331;
    
    @OneToMany(cascade= {CascadeType.PERSIST,CascadeType.MERGE},fetch = FetchType.LAZY)
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumns ({
        @JoinColumn(name="collegeId", referencedColumnName = "collegeId",nullable = false,insertable = false,updatable = false),
        @JoinColumn(name="financialYear", referencedColumnName = "financialYear",nullable = false,insertable = false,updatable = false),
        @JoinColumn(name="typeofInstitution", referencedColumnName = "typeofInstitution",nullable = false,insertable = false,updatable = false)
    })
    public List<UniversityYearTable3431> universityYearTable3431;
    
    @OneToMany(cascade= {CascadeType.PERSIST,CascadeType.MERGE},fetch = FetchType.LAZY)
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumns ({
        @JoinColumn(name="collegeId", referencedColumnName = "collegeId",nullable = false,insertable = false,updatable = false),
        @JoinColumn(name="financialYear", referencedColumnName = "financialYear",nullable = false,insertable = false,updatable = false),
        @JoinColumn(name="typeofInstitution", referencedColumnName = "typeofInstitution",nullable = false,insertable = false,updatable = false)
    })
    public List<UniversityYearTable3442> universityYearTable3442;
    
    @OneToMany(cascade= {CascadeType.PERSIST,CascadeType.MERGE},fetch = FetchType.LAZY)
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumns ({
        @JoinColumn(name="collegeId", referencedColumnName = "collegeId",nullable = false,insertable = false,updatable = false),
        @JoinColumn(name="financialYear", referencedColumnName = "financialYear",nullable = false,insertable = false,updatable = false),
        @JoinColumn(name="typeofInstitution", referencedColumnName = "typeofInstitution",nullable = false,insertable = false,updatable = false)
    })
    public List<UniversityYearTable3451> universityYearTable3451;
    
    @OneToMany(cascade= {CascadeType.PERSIST,CascadeType.MERGE},fetch = FetchType.LAZY)
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumns ({
        @JoinColumn(name="collegeId", referencedColumnName = "collegeId",nullable = false,insertable = false,updatable = false),
        @JoinColumn(name="financialYear", referencedColumnName = "financialYear",nullable = false,insertable = false,updatable = false),
        @JoinColumn(name="typeofInstitution", referencedColumnName = "typeofInstitution",nullable = false,insertable = false,updatable = false)
    })
    public List<UniversityYearTable34512> universityYearTable34512;
    
    @OneToMany(cascade= {CascadeType.PERSIST,CascadeType.MERGE},fetch = FetchType.LAZY)
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumns ({
        @JoinColumn(name="collegeId", referencedColumnName = "collegeId",nullable = false,insertable = false,updatable = false),
        @JoinColumn(name="financialYear", referencedColumnName = "financialYear",nullable = false,insertable = false,updatable = false),
        @JoinColumn(name="typeofInstitution", referencedColumnName = "typeofInstitution",nullable = false,insertable = false,updatable = false)
    })
    public List<UniversityYearTable3461> universityYearTable3461;
    
    @OneToMany(cascade= {CascadeType.PERSIST,CascadeType.MERGE},fetch = FetchType.LAZY)
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumns ({
        @JoinColumn(name="collegeId", referencedColumnName = "collegeId",nullable = false,insertable = false,updatable = false),
        @JoinColumn(name="financialYear", referencedColumnName = "financialYear",nullable = false,insertable = false,updatable = false),
        @JoinColumn(name="typeofInstitution", referencedColumnName = "typeofInstitution",nullable = false,insertable = false,updatable = false)
    })
    public List<UniversityYearTable34612> universityYearTable34612;
    
    @OneToMany(cascade= {CascadeType.PERSIST,CascadeType.MERGE},fetch = FetchType.LAZY)
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumns ({
        @JoinColumn(name="collegeId", referencedColumnName = "collegeId",nullable = false,insertable = false,updatable = false),
        @JoinColumn(name="financialYear", referencedColumnName = "financialYear",nullable = false,insertable = false,updatable = false),
        @JoinColumn(name="typeofInstitution", referencedColumnName = "typeofInstitution",nullable = false,insertable = false,updatable = false)
    })
    public List<Affiliated_YearTable342> affiliated_YearTable342;
    
    @OneToMany(cascade= {CascadeType.PERSIST,CascadeType.MERGE},fetch = FetchType.LAZY)
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumns ({
        @JoinColumn(name="collegeId", referencedColumnName = "collegeId",nullable = false,insertable = false,updatable = false),
        @JoinColumn(name="financialYear", referencedColumnName = "financialYear",nullable = false,insertable = false,updatable = false),
        @JoinColumn(name="typeofInstitution", referencedColumnName = "typeofInstitution",nullable = false,insertable = false,updatable = false)
    })
    public List<Affiliated_YearTable351> affiliated_YearTable351;
    
    
   
    
    
    @OneToMany(cascade= {CascadeType.PERSIST,CascadeType.MERGE},fetch = FetchType.LAZY)
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumns ({
        @JoinColumn(name="collegeId", referencedColumnName = "collegeId",nullable = false,insertable = false,updatable = false),
        @JoinColumn(name="financialYear", referencedColumnName = "financialYear",nullable = false,insertable = false,updatable = false),
        @JoinColumn(name="typeofInstitution", referencedColumnName = "typeofInstitution",nullable = false,insertable = false,updatable = false)
    })
    public List<Affiliated_YearTable3311> affiliatedYearTable3311;

    
    @OneToMany(cascade= {CascadeType.PERSIST,CascadeType.MERGE},fetch = FetchType.LAZY)
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumns ({
        @JoinColumn(name="collegeId", referencedColumnName = "collegeId",nullable = false,insertable = false,updatable = false),
        @JoinColumn(name="financialYear", referencedColumnName = "financialYear",nullable = false,insertable = false,updatable = false),
        @JoinColumn(name="typeofInstitution", referencedColumnName = "typeofInstitution",nullable = false,insertable = false,updatable = false)
    })
    public List<YearTable3711> yearTable3711;
    
    @OneToMany(cascade= {CascadeType.PERSIST,CascadeType.MERGE},fetch = FetchType.LAZY)
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumns ({
        @JoinColumn(name="collegeId", referencedColumnName = "collegeId",nullable = false,insertable = false,updatable = false),
        @JoinColumn(name="financialYear", referencedColumnName = "financialYear",nullable = false,insertable = false,updatable = false),
        @JoinColumn(name="typeofInstitution", referencedColumnName = "typeofInstitution",nullable = false,insertable = false,updatable = false)
    })
    public List<YearTable3721> yearTable3721;
    
    @OneToMany(cascade= {CascadeType.PERSIST,CascadeType.MERGE},fetch = FetchType.LAZY)
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumns ({
    	 @JoinColumn(name="collegeId", referencedColumnName = "collegeId",nullable = false,insertable = false,updatable = false),
         @JoinColumn(name="financialYear", referencedColumnName = "financialYear",nullable = false,insertable = false,updatable = false),
         @JoinColumn(name="typeofInstitution", referencedColumnName = "typeofInstitution",nullable = false,insertable = false,updatable = false)
    })
    public List<Affiliated_YearTable3111> affiliatedYearTable3111;

	public CriteriaPrimaryKey getCriteriaId() {
		return criteriaId;
	}

	public void setCriteriaId(CriteriaPrimaryKey criteriaId) {
		this.criteriaId = criteriaId;
	}

	public List<Criteria31Ql> getCriteria31Ql() {
		return criteria31Ql;
	}

	public void setCriteria31Ql(List<Criteria31Ql> criteria31Ql) {
		this.criteria31Ql = criteria31Ql;
	}

	public List<Criteria31Qn> getCriteria31Qn() {
		return criteria31Qn;
	}

	public void setCriteria31Qn(List<Criteria31Qn> criteria31Qn) {
		this.criteria31Qn = criteria31Qn;
	}

	public List<Criteria32Ql> getCriteria32Ql() {
		return criteria32Ql;
	}

	public void setCriteria32Ql(List<Criteria32Ql> criteria32Ql) {
		this.criteria32Ql = criteria32Ql;
	}

	public List<Criteria32Qn> getCriteria32Qn() {
		return criteria32Qn;
	}

	public void setCriteria32Qn(List<Criteria32Qn> criteria32Qn) {
		this.criteria32Qn = criteria32Qn;
	}

	public List<Criteria33Ql> getCriteria33Ql() {
		return criteria33Ql;
	}

	public void setCriteria33Ql(List<Criteria33Ql> criteria33Ql) {
		this.criteria33Ql = criteria33Ql;
	}

	public List<Criteria33Qn> getCriteria33Qn() {
		return criteria33Qn;
	}

	public void setCriteria33Qn(List<Criteria33Qn> criteria33Qn) {
		this.criteria33Qn = criteria33Qn;
	}

	public List<Criteria34Ql> getCriteria34Ql() {
		return criteria34Ql;
	}

	public void setCriteria34Ql(List<Criteria34Ql> criteria34Ql) {
		this.criteria34Ql = criteria34Ql;
	}

	public List<Criteria34Qn> getCriteria34Qn() {
		return criteria34Qn;
	}

	public void setCriteria34Qn(List<Criteria34Qn> criteria34Qn) {
		this.criteria34Qn = criteria34Qn;
	}

	public List<Criteria35Ql> getCriteria35Ql() {
		return criteria35Ql;
	}

	public void setCriteria35Ql(List<Criteria35Ql> criteria35Ql) {
		this.criteria35Ql = criteria35Ql;
	}

	public List<Criteria35Qn> getCriteria35Qn() {
		return criteria35Qn;
	}

	public void setCriteria35Qn(List<Criteria35Qn> criteria35Qn) {
		this.criteria35Qn = criteria35Qn;
	}

	public List<Criteria36Ql> getCriteria36Ql() {
		return criteria36Ql;
	}

	public void setCriteria36Ql(List<Criteria36Ql> criteria36Ql) {
		this.criteria36Ql = criteria36Ql;
	}

	public List<Criteria36Qn> getCriteria36Qn() {
		return criteria36Qn;
	}

	public void setCriteria36Qn(List<Criteria36Qn> criteria36Qn) {
		this.criteria36Qn = criteria36Qn;
	}

	public List<Criteria37Qn> getCriteria37Qn() {
		return criteria37Qn;
	}

	public void setCriteria37Qn(List<Criteria37Qn> criteria37Qn) {
		this.criteria37Qn = criteria37Qn;
	}

	public List<Criteria3_FileUpload> getCriteria3FileUpload() {
		return criteria3FileUpload;
	}

	public void setCriteria3FileUpload(List<Criteria3_FileUpload> criteria3FileUpload) {
		this.criteria3FileUpload = criteria3FileUpload;
	}

	public List<YearTable3121> getYearTable3121() {
		return yearTable3121;
	}

	public void setYearTable3121(List<YearTable3121> yearTable3121) {
		this.yearTable3121 = yearTable3121;
	}

	public List<YearTable3131> getYearTable3131() {
		return yearTable3131;
	}

	public void setYearTable3131(List<YearTable3131> yearTable3131) {
		this.yearTable3131 = yearTable3131;
	}

	public List<YearTable3211> getYearTable3211() {
		return yearTable3211;
	}

	public void setYearTable3211(List<YearTable3211> yearTable3211) {
		this.yearTable3211 = yearTable3211;
	}

	public List<YearTable3221> getYearTable3221() {
		return yearTable3221;
	}

	public void setYearTable3221(List<YearTable3221> yearTable3221) {
		this.yearTable3221 = yearTable3221;
	}

	public List<YearTable3241> getYearTable3241() {
		return yearTable3241;
	}

	public void setYearTable3241(List<YearTable3241> yearTable3241) {
		this.yearTable3241 = yearTable3241;
	}

	public List<YearTable3242> getYearTable3242() {
		return yearTable3242;
	}

	public void setYearTable3242(List<YearTable3242> yearTable3242) {
		this.yearTable3242 = yearTable3242;
	}

	public List<YearTable3321> getYearTable3321() {
		return yearTable3321;
	}

	public void setYearTable3321(List<YearTable3321> yearTable3321) {
		this.yearTable3321 = yearTable3321;
	}

	public List<YearTable3431> getYearTable3431() {
		return yearTable3431;
	}

	public void setYearTable3431(List<YearTable3431> yearTable3431) {
		this.yearTable3431 = yearTable3431;
	}

	public List<YearTable3441> getYearTable3441() {
		return yearTable3441;
	}

	public void setYearTable3441(List<YearTable3441> yearTable3441) {
		this.yearTable3441 = yearTable3441;
	}

	public List<YearTable3511> getYearTable3511() {
		return yearTable3511;
	}

	public void setYearTable3511(List<YearTable3511> yearTable3511) {
		this.yearTable3511 = yearTable3511;
	}

	public List<YearTable3521> getYearTable3521() {
		return yearTable3521;
	}

	public void setYearTable3521(List<YearTable3521> yearTable3521) {
		this.yearTable3521 = yearTable3521;
	}

	public List<YearTable3621> getYearTable3621() {
		return yearTable3621;
	}

	public void setYearTable3621(List<YearTable3621> yearTable3621) {
		this.yearTable3621 = yearTable3621;
	}

	public List<YearTable3631> getYearTable3631() {
		return yearTable3631;
	}

	public void setYearTable3631(List<YearTable3631> yearTable3631) {
		this.yearTable3631 = yearTable3631;
	}

	public List<YearTable3641> getYearTable3641() {
		return yearTable3641;
	}

	public void setYearTable3641(List<YearTable3641> yearTable3641) {
		this.yearTable3641 = yearTable3641;
	}

	public List<YearTable36412> getYearTable36412() {
		return yearTable36412;
	}

	public void setYearTable36412(List<YearTable36412> yearTable36412) {
		this.yearTable36412 = yearTable36412;
	}

	public List<UniversityYearTable3141> getUniversityYearTable3141() {
		return universityYearTable3141;
	}

	public void setUniversityYearTable3141(List<UniversityYearTable3141> universityYearTable3141) {
		this.universityYearTable3141 = universityYearTable3141;
	}

	public List<UniversityYearTable3231> getUniversityYearTable3231() {
		return universityYearTable3231;
	}

	public void setUniversityYearTable3231(List<UniversityYearTable3231> universityYearTable3231) {
		this.universityYearTable3231 = universityYearTable3231;
	}

	public List<UniversityYearTable3232> getUniversityYearTable3232() {
		return universityYearTable3232;
	}

	public void setUniversityYearTable3232(List<UniversityYearTable3232> universityYearTable3232) {
		this.universityYearTable3232 = universityYearTable3232;
	}

	public List<UniversityYearTable3331> getUniversityYearTable3331() {
		return universityYearTable3331;
	}

	public void setUniversityYearTable3331(List<UniversityYearTable3331> universityYearTable3331) {
		this.universityYearTable3331 = universityYearTable3331;
	}

	public List<UniversityYearTable3431> getUniversityYearTable3431() {
		return universityYearTable3431;
	}

	public void setUniversityYearTable3431(List<UniversityYearTable3431> universityYearTable3431) {
		this.universityYearTable3431 = universityYearTable3431;
	}

	public List<UniversityYearTable3442> getUniversityYearTable3442() {
		return universityYearTable3442;
	}

	public void setUniversityYearTable3442(List<UniversityYearTable3442> universityYearTable3442) {
		this.universityYearTable3442 = universityYearTable3442;
	}

	public List<UniversityYearTable3451> getUniversityYearTable3451() {
		return universityYearTable3451;
	}

	public void setUniversityYearTable3451(List<UniversityYearTable3451> universityYearTable3451) {
		this.universityYearTable3451 = universityYearTable3451;
	}

	public List<UniversityYearTable34512> getUniversityYearTable34512() {
		return universityYearTable34512;
	}

	public void setUniversityYearTable34512(List<UniversityYearTable34512> universityYearTable34512) {
		this.universityYearTable34512 = universityYearTable34512;
	}

	public List<UniversityYearTable3461> getUniversityYearTable3461() {
		return universityYearTable3461;
	}

	public void setUniversityYearTable3461(List<UniversityYearTable3461> universityYearTable3461) {
		this.universityYearTable3461 = universityYearTable3461;
	}

	public List<UniversityYearTable34612> getUniversityYearTable34612() {
		return universityYearTable34612;
	}

	public void setUniversityYearTable34612(List<UniversityYearTable34612> universityYearTable34612) {
		this.universityYearTable34612 = universityYearTable34612;
	}

	public List<Affiliated_YearTable342> getAffiliated_YearTable342() {
		return affiliated_YearTable342;
	}

	public void setAffiliated_YearTable342(List<Affiliated_YearTable342> affiliated_YearTable342) {
		this.affiliated_YearTable342 = affiliated_YearTable342;
	}

	public List<Affiliated_YearTable351> getAffiliated_YearTable351() {
		return affiliated_YearTable351;
	}

	public void setAffiliated_YearTable351(List<Affiliated_YearTable351> affiliated_YearTable351) {
		this.affiliated_YearTable351 = affiliated_YearTable351;
	}

	public List<Affiliated_YearTable3311> getAffiliatedYearTable3311() {
		return affiliatedYearTable3311;
	}

	public void setAffiliatedYearTable3311(List<Affiliated_YearTable3311> affiliatedYearTable3311) {
		this.affiliatedYearTable3311 = affiliatedYearTable3311;
	}

	public List<YearTable3711> getYearTable3711() {
		return yearTable3711;
	}

	public void setYearTable3711(List<YearTable3711> yearTable3711) {
		this.yearTable3711 = yearTable3711;
	}

	public List<YearTable3721> getYearTable3721() {
		return yearTable3721;
	}

	public void setYearTable3721(List<YearTable3721> yearTable3721) {
		this.yearTable3721 = yearTable3721;
	}

	public List<Affiliated_YearTable3111> getAffiliatedYearTable3111() {
		return affiliatedYearTable3111;
	}

	public void setAffiliatedYearTable3111(List<Affiliated_YearTable3111> affiliatedYearTable3111) {
		this.affiliatedYearTable3111 = affiliatedYearTable3111;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
    
}
