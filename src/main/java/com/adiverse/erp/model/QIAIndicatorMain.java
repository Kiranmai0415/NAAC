package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@Entity
@Table(name="qIAIndicator_Main")
public class QIAIndicatorMain implements Serializable
{



	private static final long serialVersionUID = 7087082295931160059L;
	

	@EmbeddedId
    public CriteriaPrimaryKey criteriaId;
	
	 @Column(name="dateof_submission")
	  private String inputIiqaDate;
	 
	 @Column(name="aishe_id")
	  private String inputIiqaAisheId;
	 
	 @Column(name="institution_trackid")
	  private String inputIiqaTrackId;
	 
    @OneToMany(cascade= {CascadeType.PERSIST,CascadeType.MERGE},fetch = FetchType.LAZY)
    @NotFound(action = NotFoundAction.IGNORE)
	 @JoinColumns ({
	        @JoinColumn(name="collegeId", referencedColumnName = "collegeId",nullable = false,insertable = false,updatable = false),
	        @JoinColumn(name="financialYear", referencedColumnName = "financialYear",nullable = false,insertable = false,updatable = false),
	        @JoinColumn(name="typeofInstitution", referencedColumnName = "typeofInstitution",nullable = false,insertable = false,updatable = false)
	    })
	private List<QIAIndicator> qIAIndicator;
	
	
    @OneToMany(cascade= {CascadeType.PERSIST,CascadeType.MERGE},fetch = FetchType.LAZY)
    @NotFound(action = NotFoundAction.IGNORE)
	 @JoinColumns ({
	        @JoinColumn(name="collegeId", referencedColumnName = "collegeId",nullable = false,insertable = false,updatable = false),
	        @JoinColumn(name="financialYear", referencedColumnName = "financialYear",nullable = false,insertable = false,updatable = false),
	        @JoinColumn(name="typeofInstitution", referencedColumnName = "typeofInstitution",nullable = false,insertable = false,updatable = false)
	    })
	private List<QIAIndicator1> qiaIndicator1;
	
    @OneToMany(cascade= {CascadeType.PERSIST,CascadeType.MERGE},fetch = FetchType.LAZY)
    @NotFound(action = NotFoundAction.IGNORE)
	 @JoinColumns ({
	        @JoinColumn(name="collegeId", referencedColumnName = "collegeId",nullable = false,insertable = false,updatable = false),
	        @JoinColumn(name="financialYear", referencedColumnName = "financialYear",nullable = false,insertable = false,updatable = false),
	        @JoinColumn(name="typeofInstitution", referencedColumnName = "typeofInstitution",nullable = false,insertable = false,updatable = false)
	    })
	private List<QIAIndicator2> qiaIndicator2;
	
	
    @OneToMany(cascade= {CascadeType.PERSIST,CascadeType.MERGE},fetch = FetchType.LAZY)
    @NotFound(action = NotFoundAction.IGNORE)
	 @JoinColumns ({
	        @JoinColumn(name="collegeId", referencedColumnName = "collegeId",nullable = false,insertable = false,updatable = false),
	        @JoinColumn(name="financialYear", referencedColumnName = "financialYear",nullable = false,insertable = false,updatable = false),
	        @JoinColumn(name="typeofInstitution", referencedColumnName = "typeofInstitution",nullable = false,insertable = false,updatable = false)
	    })
	private List<QIAIndicator3> qiaIndicator3;
	
    @OneToMany(cascade= {CascadeType.PERSIST,CascadeType.MERGE},fetch = FetchType.LAZY)
    @NotFound(action = NotFoundAction.IGNORE)
	 @JoinColumns ({
	        @JoinColumn(name="collegeId", referencedColumnName = "collegeId",nullable = false,insertable = false,updatable = false),
	        @JoinColumn(name="financialYear", referencedColumnName = "financialYear",nullable = false,insertable = false,updatable = false),
	        @JoinColumn(name="typeofInstitution", referencedColumnName = "typeofInstitution",nullable = false,insertable = false,updatable = false)
	    })
	private List<QIAIndicator4> qiaIndicator4;
    
    @OneToMany(cascade= {CascadeType.PERSIST,CascadeType.MERGE},fetch = FetchType.LAZY)
    @NotFound(action = NotFoundAction.IGNORE)
	 @JoinColumns ({
	        @JoinColumn(name="collegeId", referencedColumnName = "collegeId",nullable = false,insertable = false,updatable = false),
	        @JoinColumn(name="financialYear", referencedColumnName = "financialYear",nullable = false,insertable = false,updatable = false),
	        @JoinColumn(name="typeofInstitution", referencedColumnName = "typeofInstitution",nullable = false,insertable = false,updatable = false)
	    })
	private List<QIAIndicator5> qiaIndicator5;
	
    @OneToMany(cascade= {CascadeType.PERSIST,CascadeType.MERGE},fetch = FetchType.LAZY)
    @NotFound(action = NotFoundAction.IGNORE)
	 @JoinColumns ({
	        @JoinColumn(name="collegeId", referencedColumnName = "collegeId",nullable = false,insertable = false,updatable = false),
	        @JoinColumn(name="financialYear", referencedColumnName = "financialYear",nullable = false,insertable = false,updatable = false),
	        @JoinColumn(name="typeofInstitution", referencedColumnName = "typeofInstitution",nullable = false,insertable = false,updatable = false)
	    })
	private List<QIAIndicator6> qiaIndicator6;
	
    @OneToMany(cascade= {CascadeType.PERSIST,CascadeType.MERGE},fetch = FetchType.LAZY)
    @NotFound(action = NotFoundAction.IGNORE)
	 @JoinColumns ({
	        @JoinColumn(name="collegeId", referencedColumnName = "collegeId",nullable = false,insertable = false,updatable = false),
	        @JoinColumn(name="financialYear", referencedColumnName = "financialYear",nullable = false,insertable = false,updatable = false),
	        @JoinColumn(name="typeofInstitution", referencedColumnName = "typeofInstitution",nullable = false,insertable = false,updatable = false)
	    })
	private List<QIAIndicator7> qiaIndicator7;
	
    @OneToMany(cascade= {CascadeType.PERSIST,CascadeType.MERGE},fetch = FetchType.LAZY)
    @NotFound(action = NotFoundAction.IGNORE)
	 @JoinColumns ({
	        @JoinColumn(name="collegeId", referencedColumnName = "collegeId",nullable = false,insertable = false,updatable = false),
	        @JoinColumn(name="financialYear", referencedColumnName = "financialYear",nullable = false,insertable = false,updatable = false),
	        @JoinColumn(name="typeofInstitution", referencedColumnName = "typeofInstitution",nullable = false,insertable = false,updatable = false)
	    })
	private List<QIAIndicator8> qiaIndicator8;
	
    @OneToMany(cascade= {CascadeType.PERSIST,CascadeType.MERGE},fetch = FetchType.LAZY)
    @NotFound(action = NotFoundAction.IGNORE)
	 @JoinColumns ({
	        @JoinColumn(name="collegeId", referencedColumnName = "collegeId",nullable = false,insertable = false,updatable = false),
	        @JoinColumn(name="financialYear", referencedColumnName = "financialYear",nullable = false,insertable = false,updatable = false),
	        @JoinColumn(name="typeofInstitution", referencedColumnName = "typeofInstitution",nullable = false,insertable = false,updatable = false)
	    })
	private List<QIAIndicator9> qiaIndicator9;
	
    @OneToMany(cascade= {CascadeType.PERSIST,CascadeType.MERGE},fetch = FetchType.LAZY)
    @NotFound(action = NotFoundAction.IGNORE)
	 @JoinColumns ({
	        @JoinColumn(name="collegeId", referencedColumnName = "collegeId",nullable = false,insertable = false,updatable = false),
	        @JoinColumn(name="financialYear", referencedColumnName = "financialYear",nullable = false,insertable = false,updatable = false),
	        @JoinColumn(name="typeofInstitution", referencedColumnName = "typeofInstitution",nullable = false,insertable = false,updatable = false)
	    })
	private List<QIAIndicator10> qiaIndicator10;
	
    @OneToMany(cascade= {CascadeType.PERSIST,CascadeType.MERGE},fetch = FetchType.LAZY)
    @NotFound(action = NotFoundAction.IGNORE)
	 @JoinColumns ({
	        @JoinColumn(name="collegeId", referencedColumnName = "collegeId",nullable = false,insertable = false,updatable = false),
	        @JoinColumn(name="financialYear", referencedColumnName = "financialYear",nullable = false,insertable = false,updatable = false),
	        @JoinColumn(name="typeofInstitution", referencedColumnName = "typeofInstitution",nullable = false,insertable = false,updatable = false)
	    })
	private List<QIAIndicator12> qiaIndicator12;
	
	@OneToMany(cascade=CascadeType.ALL)
	 @JoinColumns ({
	        @JoinColumn(name="collegeId", referencedColumnName = "collegeId",nullable = false,insertable = false,updatable = false),
	        @JoinColumn(name="financialYear", referencedColumnName = "financialYear",nullable = false,insertable = false,updatable = false),
	        @JoinColumn(name="typeofInstitution", referencedColumnName = "typeofInstitution",nullable = false,insertable = false,updatable = false)
	    })
	private List<QIAIndicator_FileUpload> qiaIndiactor_fileupload;
	

	public CriteriaPrimaryKey getCriteriaId() {
		return criteriaId;
	}

	public void setCriteriaId(CriteriaPrimaryKey criteriaId) {
		this.criteriaId = criteriaId;
	}
	
	public List<QIAIndicator> getqIAIndicator() {
		return qIAIndicator;
	}

	public void setqIAIndicator(List<QIAIndicator> qIAIndicator) {
		this.qIAIndicator = qIAIndicator;
	}

	public List<QIAIndicator1> getQiaIndicator1() {
		return qiaIndicator1;
	}

	public void setQiaIndicator1(List<QIAIndicator1> qiaIndicator1) {
		this.qiaIndicator1 = qiaIndicator1;
	}

	public List<QIAIndicator2> getQiaIndicator2() {
		return qiaIndicator2;
	}

	public void setQiaIndicator2(List<QIAIndicator2> qiaIndicator2) {
		this.qiaIndicator2 = qiaIndicator2;
	}

	public List<QIAIndicator3> getQiaIndicator3() {
		return qiaIndicator3;
	}

	public void setQiaIndicator3(List<QIAIndicator3> qiaIndicator3) {
		this.qiaIndicator3 = qiaIndicator3;
	}

	public List<QIAIndicator4> getQiaIndicator4() {
		return qiaIndicator4;
	}

	public void setQiaIndicator4(List<QIAIndicator4> qiaIndicator4) {
		this.qiaIndicator4 = qiaIndicator4;
	}

	public List<QIAIndicator5> getQiaIndicator5() {
		return qiaIndicator5;
	}

	public void setQiaIndicator5(List<QIAIndicator5> qiaIndicator5) {
		this.qiaIndicator5 = qiaIndicator5;
	}

	public List<QIAIndicator6> getQiaIndicator6() {
		return qiaIndicator6;
	}

	public void setQiaIndicator6(List<QIAIndicator6> qiaIndicator6) {
		this.qiaIndicator6 = qiaIndicator6;
	}

	public List<QIAIndicator7> getQiaIndicator7() {
		return qiaIndicator7;
	}

	public void setQiaIndicator7(List<QIAIndicator7> qiaIndicator7) {
		this.qiaIndicator7 = qiaIndicator7;
	}

	public List<QIAIndicator8> getQiaIndicator8() {
		return qiaIndicator8;
	}

	public void setQiaIndicator8(List<QIAIndicator8> qiaIndicator8) {
		this.qiaIndicator8 = qiaIndicator8;
	}

	public List<QIAIndicator9> getQiaIndicator9() {
		return qiaIndicator9;
	}

	public void setQiaIndicator9(List<QIAIndicator9> qiaIndicator9) {
		this.qiaIndicator9 = qiaIndicator9;
	}

	public List<QIAIndicator10> getQiaIndicator10() {
		return qiaIndicator10;
	}

	public void setQiaIndicator10(List<QIAIndicator10> qiaIndicator10) {
		this.qiaIndicator10 = qiaIndicator10;
	}

	public List<QIAIndicator12> getQiaIndicator12() {
		return qiaIndicator12;
	}

	public void setQiaIndicator12(List<QIAIndicator12> qiaIndicator12) {
		this.qiaIndicator12 = qiaIndicator12;
	}

	public List<QIAIndicator_FileUpload> getQiaIndiactor_fileupload() {
		return qiaIndiactor_fileupload;
	}

	public void setQiaIndiactor_fileupload(List<QIAIndicator_FileUpload> qiaIndiactor_fileupload) {
		this.qiaIndiactor_fileupload = qiaIndiactor_fileupload;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getInputIiqaDate() {
		return inputIiqaDate;
	}

	public void setInputIiqaDate(String inputIiqaDate) {
		this.inputIiqaDate = inputIiqaDate;
	}

	public String getInputIiqaAisheId() {
		return inputIiqaAisheId;
	}

	public void setInputIiqaAisheId(String inputIiqaAisheId) {
		this.inputIiqaAisheId = inputIiqaAisheId;
	}

	public String getInputIiqaTrackId() {
		return inputIiqaTrackId;
	}

	public void setInputIiqaTrackId(String inputIiqaTrackId) {
		this.inputIiqaTrackId = inputIiqaTrackId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(criteriaId, inputIiqaAisheId, inputIiqaDate, inputIiqaTrackId, qIAIndicator,
				qiaIndiactor_fileupload, qiaIndicator1, qiaIndicator10, qiaIndicator12, qiaIndicator2, qiaIndicator3,
				qiaIndicator4, qiaIndicator5, qiaIndicator6, qiaIndicator7, qiaIndicator8, qiaIndicator9);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		QIAIndicatorMain other = (QIAIndicatorMain) obj;
		return Objects.equals(criteriaId, other.criteriaId) && Objects.equals(inputIiqaAisheId, other.inputIiqaAisheId)
				&& Objects.equals(inputIiqaDate, other.inputIiqaDate)
				&& Objects.equals(inputIiqaTrackId, other.inputIiqaTrackId)
				&& Objects.equals(qIAIndicator, other.qIAIndicator)
				&& Objects.equals(qiaIndiactor_fileupload, other.qiaIndiactor_fileupload)
				&& Objects.equals(qiaIndicator1, other.qiaIndicator1)
				&& Objects.equals(qiaIndicator10, other.qiaIndicator10)
				&& Objects.equals(qiaIndicator12, other.qiaIndicator12)
				&& Objects.equals(qiaIndicator2, other.qiaIndicator2)
				&& Objects.equals(qiaIndicator3, other.qiaIndicator3)
				&& Objects.equals(qiaIndicator4, other.qiaIndicator4)
				&& Objects.equals(qiaIndicator5, other.qiaIndicator5)
				&& Objects.equals(qiaIndicator6, other.qiaIndicator6)
				&& Objects.equals(qiaIndicator7, other.qiaIndicator7)
				&& Objects.equals(qiaIndicator8, other.qiaIndicator8)
				&& Objects.equals(qiaIndicator9, other.qiaIndicator9);
	}



}