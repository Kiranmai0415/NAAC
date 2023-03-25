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
@Table(name = "extended_profile")
public class ExtendedProfile implements Serializable {
	private static final long serialVersionUID = 4305235894838345799L;
	@EmbeddedId
	public CriteriaPrimaryKey criteriaId;

	@Column(name = "numberofDepartments")
	private String eTable12v;

	@Column(name = "classroomsSeminarhalls")
	private String eTable43v;

	@Column(name = "campusforacademicPurpose")
	private String eTable44v;

	@OneToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
	@NotFound(action = NotFoundAction.IGNORE)
	@JoinColumns({
			@JoinColumn(name = "collegeId", referencedColumnName = "collegeId", nullable = false, insertable = false, updatable = false),
			@JoinColumn(name = "financialYear", referencedColumnName = "financialYear", nullable = false, insertable = false, updatable = false),
			@JoinColumn(name = "typeofInstitution", referencedColumnName = "typeofInstitution", nullable = false, insertable = false, updatable = false) })
	public List<Epprogramme> epYeartable11;
	
	
	@OneToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
	@NotFound(action = NotFoundAction.IGNORE)
	@JoinColumns({
		@JoinColumn(name = "collegeId", referencedColumnName = "collegeId", nullable = false, insertable = false, updatable = false),
		@JoinColumn(name = "financialYear", referencedColumnName = "financialYear", nullable = false, insertable = false, updatable = false),
		@JoinColumn(name = "typeofInstitution", referencedColumnName = "typeofInstitution", nullable = false, insertable = false, updatable = false) })
	public List<Epstudent21> epYeartable21;

	@OneToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
	@NotFound(action = NotFoundAction.IGNORE)
	@JoinColumns({
	    @JoinColumn(name = "collegeId", referencedColumnName = "collegeId", nullable = false, insertable = false, updatable = false),
	    @JoinColumn(name = "financialYear", referencedColumnName = "financialYear", nullable = false, insertable = false, updatable = false),
	    @JoinColumn(name = "typeofInstitution", referencedColumnName = "typeofInstitution", nullable = false, insertable = false, updatable = false) })
	public List<Epstudent22> epYeartable22;

	@OneToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
	@NotFound(action = NotFoundAction.IGNORE)
	@JoinColumns({
	    @JoinColumn(name = "collegeId", referencedColumnName = "collegeId", nullable = false, insertable = false, updatable = false),
	    @JoinColumn(name = "financialYear", referencedColumnName = "financialYear", nullable = false, insertable = false, updatable = false),
	    @JoinColumn(name = "typeofInstitution", referencedColumnName = "typeofInstitution", nullable = false, insertable = false, updatable = false) })
	public List<Epstudent23> epYeartable23;

	@OneToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
	@NotFound(action = NotFoundAction.IGNORE)
	@JoinColumns({
	    @JoinColumn(name = "collegeId", referencedColumnName = "collegeId", nullable = false, insertable = false, updatable = false),
	    @JoinColumn(name = "financialYear", referencedColumnName = "financialYear", nullable = false, insertable = false, updatable = false),
	    @JoinColumn(name = "typeofInstitution", referencedColumnName = "typeofInstitution", nullable = false, insertable = false, updatable = false) })
	public List<Epstudent24> epYeartable24;

	@OneToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
	@NotFound(action = NotFoundAction.IGNORE)
	@JoinColumns({
	    @JoinColumn(name = "collegeId", referencedColumnName = "collegeId", nullable = false, insertable = false, updatable = false),
	    @JoinColumn(name = "financialYear", referencedColumnName = "financialYear", nullable = false, insertable = false, updatable = false),
	    @JoinColumn(name = "typeofInstitution", referencedColumnName = "typeofInstitution", nullable = false, insertable = false, updatable = false) })
	public List<EpAcademic31> epYeartable31;

	@OneToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
	@NotFound(action = NotFoundAction.IGNORE)
	@JoinColumns({
	    @JoinColumn(name = "collegeId", referencedColumnName = "collegeId", nullable = false, insertable = false, updatable = false),
	    @JoinColumn(name = "financialYear", referencedColumnName = "financialYear", nullable = false, insertable = false, updatable = false),
	    @JoinColumn(name = "typeofInstitution", referencedColumnName = "typeofInstitution", nullable = false, insertable = false, updatable = false) })
	public List<EpAcademic32> epYeartable32;

	@OneToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
	@NotFound(action = NotFoundAction.IGNORE)
	@JoinColumns({
	    @JoinColumn(name = "collegeId", referencedColumnName = "collegeId", nullable = false, insertable = false, updatable = false),
	    @JoinColumn(name = "financialYear", referencedColumnName = "financialYear", nullable = false, insertable = false, updatable = false),
	    @JoinColumn(name = "typeofInstitution", referencedColumnName = "typeofInstitution", nullable = false, insertable = false, updatable = false) })
	public List<EpAcademic33> epYeartable33;

	@OneToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
	@NotFound(action = NotFoundAction.IGNORE)
	@JoinColumns({
	    @JoinColumn(name = "collegeId", referencedColumnName = "collegeId", nullable = false, insertable = false, updatable = false),
	    @JoinColumn(name = "financialYear", referencedColumnName = "financialYear", nullable = false, insertable = false, updatable = false),
	    @JoinColumn(name = "typeofInstitution", referencedColumnName = "typeofInstitution", nullable = false, insertable = false, updatable = false) })
	public List<EpInstitution41> epYeartable41;

	@OneToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
	@NotFound(action = NotFoundAction.IGNORE)
	@JoinColumns({
	    @JoinColumn(name = "collegeId", referencedColumnName = "collegeId", nullable = false, insertable = false, updatable = false),
	    @JoinColumn(name = "financialYear", referencedColumnName = "financialYear", nullable = false, insertable = false, updatable = false),
	    @JoinColumn(name = "typeofInstitution", referencedColumnName = "typeofInstitution", nullable = false, insertable = false, updatable = false) })
	public List<EpInstitution42> epYeartable42;

	@OneToMany(cascade = { CascadeType.PERSIST,CascadeType.MERGE}, fetch = FetchType.LAZY)
	@NotFound(action = NotFoundAction.IGNORE)
	@JoinColumns({
	    @JoinColumn(name = "collegeId", referencedColumnName = "collegeId", nullable = false, insertable = false, updatable = false),
	    @JoinColumn(name = "financialYear", referencedColumnName = "financialYear", nullable = false, insertable = false, updatable = false),
	    @JoinColumn(name = "typeofInstitution", referencedColumnName = "typeofInstitution", nullable = false, insertable = false, updatable = false) })
	public List<EpInstitution45> epYeartable45;
	
	//affiliated extended file upload
	
	@OneToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
	@NotFound(action = NotFoundAction.IGNORE)
	@JoinColumns({
	    @JoinColumn(name = "collegeId", referencedColumnName = "collegeId", nullable = false, insertable = false, updatable = false),
	    @JoinColumn(name = "financialYear", referencedColumnName = "financialYear", nullable = false, insertable = false, updatable = false),
	    @JoinColumn(name = "typeofInstitution", referencedColumnName = "typeofInstitution", nullable = false, insertable = false, updatable = false) })
	private List<ExtendedFileupload> extendedFileupload; 
	

	

	public List<ExtendedFileupload> getExtendedFileupload() {
		return extendedFileupload;
	}

	public void setExtendedFileupload(List<ExtendedFileupload> extendedFileupload) {
		this.extendedFileupload = extendedFileupload;
	}

	public CriteriaPrimaryKey getCriteriaId() {
		return criteriaId;
	}

	public void setCriteriaId(CriteriaPrimaryKey criteriaId) {
		this.criteriaId = criteriaId;
	}

	public String geteTable12v() {
		return eTable12v;
	}

	public void seteTable12v(String eTable12v) {
		this.eTable12v = eTable12v;
	}

	public String geteTable43v() {
		return eTable43v;
	}

	public void seteTable43v(String eTable43v) {
		this.eTable43v = eTable43v;
	}

	public String geteTable44v() {
		return eTable44v;
	}

	
	
	public void seteTable44v(String eTable44v) {
		this.eTable44v = eTable44v;
	}

	public List<Epprogramme> getEpYeartable11() {
		return epYeartable11;
	}

	public void setEpYeartable11(List<Epprogramme> epYeartable11) {
		this.epYeartable11 = epYeartable11;
	}

	public List<Epstudent21> getEpYeartable21() {
		return epYeartable21;
	}

	public void setEpYeartable21(List<Epstudent21> epYeartable21) {
		this.epYeartable21 = epYeartable21;
	}

	public List<Epstudent22> getEpYeartable22() {
		return epYeartable22;
	}

	public void setEpYeartable22(List<Epstudent22> epYeartable22) {
		this.epYeartable22 = epYeartable22;
	}

	public List<Epstudent23> getEpYeartable23() {
		return epYeartable23;
	}

	public void setEpYeartable23(List<Epstudent23> epYeartable23) {
		this.epYeartable23 = epYeartable23;
	}

	public List<Epstudent24> getEpYeartable24() {
		return epYeartable24;
	}

	public void setEpYeartable24(List<Epstudent24> epYeartable24) {
		this.epYeartable24 = epYeartable24;
	}

	public List<EpAcademic31> getEpYeartable31() {
		return epYeartable31;
	}

	public void setEpYeartable31(List<EpAcademic31> epYeartable31) {
		this.epYeartable31 = epYeartable31;
	}

	public List<EpAcademic32> getEpYeartable32() {
		return epYeartable32;
	}

	public void setEpYeartable32(List<EpAcademic32> epYeartable32) {
		this.epYeartable32 = epYeartable32;
	}

	
	public List<EpInstitution41> getEpYeartable41() {
		return epYeartable41;
	}

	public void setEpYeartable41(List<EpInstitution41> epYeartable41) {
		this.epYeartable41 = epYeartable41;
	}

	public List<EpInstitution42> getEpYeartable42() {
		return epYeartable42;
	}

	public void setEpYeartable42(List<EpInstitution42> epYeartable42) {
		this.epYeartable42 = epYeartable42;
	}

	public List<EpInstitution45> getEpYeartable45() {
		return epYeartable45;
	}

	public void setEpYeartable45(List<EpInstitution45> epYeartable45) {
		this.epYeartable45 = epYeartable45;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public List<EpAcademic33> getEpYeartable33() {
		return epYeartable33;
	}

	public void setEpYeartable33(List<EpAcademic33> epYeartable33) {
		this.epYeartable33 = epYeartable33;
	}

	

}