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
@Table(name = "Profile_oftheCollege")
public class ProfileoftheCollege implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	public CriteriaPrimaryKey criteriaId;

	@Column(name = "regulatory_authority")
	private String inputa4t1;

	@Column(name = "integrated_programmes")
	private String inputa4t2;
	
	// affiliated visiting faculty engaged
	
	@Column(name="visiting_faculty")
	private String inputatg1;
	
	
	
	

	@OneToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.LAZY)
	@NotFound(action = NotFoundAction.IGNORE)
	@JoinColumns({
			@JoinColumn(name = "collegeId", referencedColumnName = "collegeId", nullable = false, insertable = false, updatable = false),
			@JoinColumn(name = "financialYear", referencedColumnName = "financialYear", nullable = false, insertable = false, updatable = false),
			@JoinColumn(name = "typeofInstitution", referencedColumnName = "typeofInstitution", nullable = false, insertable = false, updatable = false) })
	public List<AffiliatedEnrollment> affiliatedEnrollment;

	

	@OneToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.LAZY)
	@NotFound(action = NotFoundAction.IGNORE)
	@JoinColumns({
			@JoinColumn(name = "collegeId", referencedColumnName = "collegeId", nullable = false, insertable = false, updatable = false),
			@JoinColumn(name = "financialYear", referencedColumnName = "financialYear", nullable = false, insertable = false, updatable = false),
			@JoinColumn(name = "typeofInstitution", referencedColumnName = "typeofInstitution", nullable = false, insertable = false, updatable = false) })
	public List<BasicProfile> basicProfile;
	

	@OneToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.LAZY)
	@NotFound(action = NotFoundAction.IGNORE)
	@JoinColumns({
			@JoinColumn(name = "collegeId", referencedColumnName = "collegeId", nullable = false, insertable = false, updatable = false),
			@JoinColumn(name = "financialYear", referencedColumnName = "financialYear", nullable = false, insertable = false, updatable = false),
			@JoinColumn(name = "typeofInstitution", referencedColumnName = "typeofInstitution", nullable = false, insertable = false, updatable = false) })
	public List<ContactsforCommunication> contactsforCommunication;



	@OneToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.LAZY)
	@NotFound(action = NotFoundAction.IGNORE)
	@JoinColumns({
			@JoinColumn(name = "collegeId", referencedColumnName = "collegeId", nullable = false, insertable = false, updatable = false),
			@JoinColumn(name = "financialYear", referencedColumnName = "financialYear", nullable = false, insertable = false, updatable = false),
			@JoinColumn(name = "typeofInstitution", referencedColumnName = "typeofInstitution", nullable = false, insertable = false, updatable = false) })
	public List<AffiliatedStatus> affiliatedStatus;

	

	@OneToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.LAZY)
	@NotFound(action = NotFoundAction.IGNORE)
	@JoinColumns({
			@JoinColumn(name = "collegeId", referencedColumnName = "collegeId", nullable = false, insertable = false, updatable = false),
			@JoinColumn(name = "financialYear", referencedColumnName = "financialYear", nullable = false, insertable = false, updatable = false),
			@JoinColumn(name = "typeofInstitution", referencedColumnName = "typeofInstitution", nullable = false, insertable = false, updatable = false) })
	public List<DetailsofUgcRecognition> detailsofUgcRecognition;

	

	@OneToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.LAZY)
	@NotFound(action = NotFoundAction.IGNORE)
	@JoinColumns({
			@JoinColumn(name = "collegeId", referencedColumnName = "collegeId", nullable = false, insertable = false, updatable = false),
			@JoinColumn(name = "financialYear", referencedColumnName = "financialYear", nullable = false, insertable = false, updatable = false),
			@JoinColumn(name = "typeofInstitution", referencedColumnName = "typeofInstitution", nullable = false, insertable = false, updatable = false) })
	public List<Recognition> recognition;



	@OneToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.LAZY)
	@NotFound(action = NotFoundAction.IGNORE)
	@JoinColumns({
			@JoinColumn(name = "collegeId", referencedColumnName = "collegeId", nullable = false, insertable = false, updatable = false),
			@JoinColumn(name = "financialYear", referencedColumnName = "financialYear", nullable = false, insertable = false, updatable = false),
			@JoinColumn(name = "typeofInstitution", referencedColumnName = "typeofInstitution", nullable = false, insertable = false, updatable = false) })
	public List<AffiliatedCampus> affiliatedCampus;



	@OneToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.LAZY)
	@NotFound(action = NotFoundAction.IGNORE)
	@JoinColumns({
			@JoinColumn(name = "collegeId", referencedColumnName = "collegeId", nullable = false, insertable = false, updatable = false),
			@JoinColumn(name = "financialYear", referencedColumnName = "financialYear", nullable = false, insertable = false, updatable = false),
			@JoinColumn(name = "typeofInstitution", referencedColumnName = "typeofInstitution", nullable = false, insertable = false, updatable = false) })
	public List<AcademicInformation> academicinformation;



	@OneToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.LAZY)
	@NotFound(action = NotFoundAction.IGNORE)
	@JoinColumns({
			@JoinColumn(name = "collegeId", referencedColumnName = "collegeId", nullable = false, insertable = false, updatable = false),
			@JoinColumn(name = "financialYear", referencedColumnName = "financialYear", nullable = false, insertable = false, updatable = false),
			@JoinColumn(name = "typeofInstitution", referencedColumnName = "typeofInstitution", nullable = false, insertable = false, updatable = false) })
	public List<AffiliatedProgrammes> affiliatedProgrammes;

	
	@OneToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.LAZY)
	@NotFound(action = NotFoundAction.IGNORE)
	@JoinColumns({
			@JoinColumn(name = "collegeId", referencedColumnName = "collegeId", nullable = false, insertable = false, updatable = false),
			@JoinColumn(name = "financialYear", referencedColumnName = "financialYear", nullable = false, insertable = false, updatable = false),
			@JoinColumn(name = "typeofInstitution", referencedColumnName = "typeofInstitution", nullable = false, insertable = false, updatable = false) })
	public List<AffiliatedDepartment> affiliatedDepartment;


	@OneToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.LAZY)
	@NotFound(action = NotFoundAction.IGNORE)
	@JoinColumns({
			@JoinColumn(name = "collegeId", referencedColumnName = "collegeId", nullable = false, insertable = false, updatable = false),
			@JoinColumn(name = "financialYear", referencedColumnName = "financialYear", nullable = false, insertable = false, updatable = false),
			@JoinColumn(name = "typeofInstitution", referencedColumnName = "typeofInstitution", nullable = false, insertable = false, updatable = false) })
	public List<AffiliatedInstitution> affiliatedInstitution;



	@OneToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.LAZY)
	@NotFound(action = NotFoundAction.IGNORE)
	@JoinColumns({
			@JoinColumn(name = "collegeId", referencedColumnName = "collegeId", nullable = false, insertable = false, updatable = false),
			@JoinColumn(name = "financialYear", referencedColumnName = "financialYear", nullable = false, insertable = false, updatable = false),
			@JoinColumn(name = "typeofInstitution", referencedColumnName = "typeofInstitution", nullable = false, insertable = false, updatable = false) })
	public List<AffiliatedTeachingstaff> affiliatedTeachingstaff;


	@OneToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.LAZY)
	@NotFound(action = NotFoundAction.IGNORE)
	@JoinColumns({
			@JoinColumn(name = "collegeId", referencedColumnName = "collegeId", nullable = false, insertable = false, updatable = false),
			@JoinColumn(name = "financialYear", referencedColumnName = "financialYear", nullable = false, insertable = false, updatable = false),
			@JoinColumn(name = "typeofInstitution", referencedColumnName = "typeofInstitution", nullable = false, insertable = false, updatable = false) })
	public List<AffiliatedEducation> affiliatedEducation;

	

	@OneToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.LAZY)
	@NotFound(action = NotFoundAction.IGNORE)
	@JoinColumns({
			@JoinColumn(name = "collegeId", referencedColumnName = "collegeId", nullable = false, insertable = false, updatable = false),
			@JoinColumn(name = "financialYear", referencedColumnName = "financialYear", nullable = false, insertable = false, updatable = false),
			@JoinColumn(name = "typeofInstitution", referencedColumnName = "typeofInstitution", nullable = false, insertable = false, updatable = false) })
	public List<AffiliatedAccrediation> affiliatedAccrediation;


	@OneToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.LAZY)
	@NotFound(action = NotFoundAction.IGNORE)
	@JoinColumns({
			@JoinColumn(name = "collegeId", referencedColumnName = "collegeId", nullable = false, insertable = false, updatable = false),
			@JoinColumn(name = "financialYear", referencedColumnName = "financialYear", nullable = false, insertable = false, updatable = false),
			@JoinColumn(name = "typeofInstitution", referencedColumnName = "typeofInstitution", nullable = false, insertable = false, updatable = false) })
	public List<AffiliatedAnnualQuality> affiliatedAnnualQuality;


	@OneToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.LAZY)
	@NotFound(action = NotFoundAction.IGNORE)
	@JoinColumns({
			@JoinColumn(name = "collegeId", referencedColumnName = "collegeId", nullable = false, insertable = false, updatable = false),
			@JoinColumn(name = "financialYear", referencedColumnName = "financialYear", nullable = false, insertable = false, updatable = false),
			@JoinColumn(name = "typeofInstitution", referencedColumnName = "typeofInstitution", nullable = false, insertable = false, updatable = false) })
	public List<AffiliatedAdmittstudents> affiliatedAdmittstudents;

//		public CriteriaPrimaryKey getCriteriaId() {
//			return criteriaId;
//		}
//
//
//		public void setCriteriaId(CriteriaPrimaryKey criteriaId) {
//			this.criteriaId = criteriaId;
//		}



	@OneToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.LAZY)
	@NotFound(action = NotFoundAction.IGNORE)
	@JoinColumns({
			@JoinColumn(name = "collegeId", referencedColumnName = "collegeId", nullable = false, insertable = false, updatable = false),
			@JoinColumn(name = "financialYear", referencedColumnName = "financialYear", nullable = false, insertable = false, updatable = false),
			@JoinColumn(name = "typeofInstitution", referencedColumnName = "typeofInstitution", nullable = false, insertable = false, updatable = false) })
	public List<ProgrammeIntroduced> programmeIntroduced;

	@OneToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.LAZY)
	@NotFound(action = NotFoundAction.IGNORE)
	@JoinColumns({
			@JoinColumn(name = "collegeId", referencedColumnName = "collegeId", nullable = false, insertable = false, updatable = false),
			@JoinColumn(name = "financialYear", referencedColumnName = "financialYear", nullable = false, insertable = false, updatable = false),
			@JoinColumn(name = "typeofInstitution", referencedColumnName = "typeofInstitution", nullable = false, insertable = false, updatable = false) })
	public List<basicprofile_2> basicprofile2;

	@OneToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.LAZY)
	@NotFound(action = NotFoundAction.IGNORE)
	@JoinColumns({
			@JoinColumn(name = "collegeId", referencedColumnName = "collegeId", nullable = false, insertable = false, updatable = false),
			@JoinColumn(name = "financialYear", referencedColumnName = "financialYear", nullable = false, insertable = false, updatable = false),
			@JoinColumn(name = "typeofInstitution", referencedColumnName = "typeofInstitution", nullable = false, insertable = false, updatable = false) })
	public List<Campus> campus;

	// ---------------------------------------------

	@OneToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.LAZY)
	@NotFound(action = NotFoundAction.IGNORE)
	@JoinColumns({
			@JoinColumn(name = "collegeId", referencedColumnName = "collegeId", nullable = false, insertable = false, updatable = false),
			@JoinColumn(name = "financialYear", referencedColumnName = "financialYear", nullable = false, insertable = false, updatable = false),
			@JoinColumn(name = "typeofInstitution", referencedColumnName = "typeofInstitution", nullable = false, insertable = false, updatable = false) })
	public List<AcademicInstitution> academicinstitution;

	@OneToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.LAZY)
	@NotFound(action = NotFoundAction.IGNORE)
	@JoinColumns({
			@JoinColumn(name = "collegeId", referencedColumnName = "collegeId", nullable = false, insertable = false, updatable = false),
			@JoinColumn(name = "financialYear", referencedColumnName = "financialYear", nullable = false, insertable = false, updatable = false),
			@JoinColumn(name = "typeofInstitution", referencedColumnName = "typeofInstitution", nullable = false, insertable = false, updatable = false) })
	public List<AcademicStudentsEnrolled> academicstudentsEnrolled;

	@OneToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.LAZY)
	@NotFound(action = NotFoundAction.IGNORE)
	@JoinColumns({
			@JoinColumn(name = "collegeId", referencedColumnName = "collegeId", nullable = false, insertable = false, updatable = false),
			@JoinColumn(name = "financialYear", referencedColumnName = "financialYear", nullable = false, insertable = false, updatable = false),
			@JoinColumn(name = "typeofInstitution", referencedColumnName = "typeofInstitution", nullable = false, insertable = false, updatable = false) })
	public List<AcademicStudentsAdmitted> academicstudentsAdmitted;

	// --------------------

	@OneToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.LAZY)
	@NotFound(action = NotFoundAction.IGNORE)
	@JoinColumns({
			@JoinColumn(name = "collegeId", referencedColumnName = "collegeId", nullable = false, insertable = false, updatable = false),
			@JoinColumn(name = "financialYear", referencedColumnName = "financialYear", nullable = false, insertable = false, updatable = false),
			@JoinColumn(name = "typeofInstitution", referencedColumnName = "typeofInstitution", nullable = false, insertable = false, updatable = false) })
	public List<EvaluativeReport> evaluativeReport;

	@OneToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.LAZY)
	@NotFound(action = NotFoundAction.IGNORE)
	@JoinColumns({
			@JoinColumn(name = "collegeId", referencedColumnName = "collegeId", nullable = false, insertable = false, updatable = false),
			@JoinColumn(name = "financialYear", referencedColumnName = "financialYear", nullable = false, insertable = false, updatable = false),
			@JoinColumn(name = "typeofInstitution", referencedColumnName = "typeofInstitution", nullable = false, insertable = false, updatable = false) })
	public List<EvaluativeFileUpload> evaluativeFileupload;

	@OneToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.LAZY)
	@NotFound(action = NotFoundAction.IGNORE)
	@JoinColumns({
			@JoinColumn(name = "collegeId", referencedColumnName = "collegeId", nullable = false, insertable = false, updatable = false),
			@JoinColumn(name = "financialYear", referencedColumnName = "financialYear", nullable = false, insertable = false, updatable = false),
			@JoinColumn(name = "typeofInstitution", referencedColumnName = "typeofInstitution", nullable = false, insertable = false, updatable = false) })
	public List<Multidisciplinaryinterdisciplinary> multidisciplinaryInterdisciplinary;

	// Affiliated

	@OneToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.LAZY)
	@NotFound(action = NotFoundAction.IGNORE)
	@JoinColumns({
			@JoinColumn(name = "collegeId", referencedColumnName = "collegeId", nullable = false, insertable = false, updatable = false),
			@JoinColumn(name = "financialYear", referencedColumnName = "financialYear", nullable = false, insertable = false, updatable = false),
			@JoinColumn(name = "typeofInstitution", referencedColumnName = "typeofInstitution", nullable = false, insertable = false, updatable = false) })
	public List<AuniversityAffiliated> auniversityAffiliated;

	@OneToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.LAZY)
	@NotFound(action = NotFoundAction.IGNORE)
	@JoinColumns({
			@JoinColumn(name = "collegeId", referencedColumnName = "collegeId", nullable = false, insertable = false, updatable = false),
			@JoinColumn(name = "financialYear", referencedColumnName = "financialYear", nullable = false, insertable = false, updatable = false),
			@JoinColumn(name = "typeofInstitution", referencedColumnName = "typeofInstitution", nullable = false, insertable = false, updatable = false) })
	public List<AuniversityAffiliated1> auniversityAffiliated1;

	@OneToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.LAZY)
	@NotFound(action = NotFoundAction.IGNORE)
	@JoinColumns({
			@JoinColumn(name = "collegeId", referencedColumnName = "collegeId", nullable = false, insertable = false, updatable = false),
			@JoinColumn(name = "financialYear", referencedColumnName = "financialYear", nullable = false, insertable = false, updatable = false),
			@JoinColumn(name = "typeofInstitution", referencedColumnName = "typeofInstitution", nullable = false, insertable = false, updatable = false) })
	public List<UniversityColleges> universityColleges;

	@OneToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.LAZY)
	@NotFound(action = NotFoundAction.IGNORE)
	@JoinColumns({
			@JoinColumn(name = "collegeId", referencedColumnName = "collegeId", nullable = false, insertable = false, updatable = false),
			@JoinColumn(name = "financialYear", referencedColumnName = "financialYear", nullable = false, insertable = false, updatable = false),
			@JoinColumn(name = "typeofInstitution", referencedColumnName = "typeofInstitution", nullable = false, insertable = false, updatable = false) })
	public List<AcademiciansAppointed> academiciansAppointed;

	@OneToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.LAZY)
	@NotFound(action = NotFoundAction.IGNORE)
	@JoinColumns({
			@JoinColumn(name = "collegeId", referencedColumnName = "collegeId", nullable = false, insertable = false, updatable = false),
			@JoinColumn(name = "financialYear", referencedColumnName = "financialYear", nullable = false, insertable = false, updatable = false),
			@JoinColumn(name = "typeofInstitution", referencedColumnName = "typeofInstitution", nullable = false, insertable = false, updatable = false) })
	public List<IntegratedProgrammes> integratedProgrammes;

	@OneToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.LAZY)
	@NotFound(action = NotFoundAction.IGNORE)
	@JoinColumns({
			@JoinColumn(name = "collegeId", referencedColumnName = "collegeId", nullable = false, insertable = false, updatable = false),
			@JoinColumn(name = "financialYear", referencedColumnName = "financialYear", nullable = false, insertable = false, updatable = false),
			@JoinColumn(name = "typeofInstitution", referencedColumnName = "typeofInstitution", nullable = false, insertable = false, updatable = false) })
	public List<HumanResourceDevelopment> humanResourceDevelopment;

	@OneToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.LAZY)
	@NotFound(action = NotFoundAction.IGNORE)
	@JoinColumns({
			@JoinColumn(name = "collegeId", referencedColumnName = "collegeId", nullable = false, insertable = false, updatable = false),
			@JoinColumn(name = "financialYear", referencedColumnName = "financialYear", nullable = false, insertable = false, updatable = false),
			@JoinColumn(name = "typeofInstitution", referencedColumnName = "typeofInstitution", nullable = false, insertable = false, updatable = false) })
	public List<InstitutedUniversity> institutedUniversity;

	// programmes

	@OneToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.LAZY)
	@NotFound(action = NotFoundAction.IGNORE)
	@JoinColumns({
			@JoinColumn(name = "collegeId", referencedColumnName = "collegeId", nullable = false, insertable = false, updatable = false),
			@JoinColumn(name = "financialYear", referencedColumnName = "financialYear", nullable = false, insertable = false, updatable = false),
			@JoinColumn(name = "typeofInstitution", referencedColumnName = "typeofInstitution", nullable = false, insertable = false, updatable = false) })
	public List<ProgrammesOffred> programmesOffered;

	@OneToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.LAZY)
	@NotFound(action = NotFoundAction.IGNORE)
	@JoinColumns({
			@JoinColumn(name = "collegeId", referencedColumnName = "collegeId", nullable = false, insertable = false, updatable = false),
			@JoinColumn(name = "financialYear", referencedColumnName = "financialYear", nullable = false, insertable = false, updatable = false),
			@JoinColumn(name = "typeofInstitution", referencedColumnName = "typeofInstitution", nullable = false, insertable = false, updatable = false) })
	public List<Proffessionalprogrammes> proffessionalprogrammes;

	// autonomous recognization minority

	@OneToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.LAZY)
	@NotFound(action = NotFoundAction.IGNORE)
	@JoinColumns({
			@JoinColumn(name = "collegeId", referencedColumnName = "collegeId", nullable = false, insertable = false, updatable = false),
			@JoinColumn(name = "financialYear", referencedColumnName = "financialYear", nullable = false, insertable = false, updatable = false),
			@JoinColumn(name = "typeofInstitution", referencedColumnName = "typeofInstitution", nullable = false, insertable = false, updatable = false) })
	public List<RecognizedMinority> recognizedMinority;

	// recognization details

	@OneToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.LAZY)
	@NotFound(action = NotFoundAction.IGNORE)
	@JoinColumns({
			@JoinColumn(name = "collegeId", referencedColumnName = "collegeId", nullable = false, insertable = false, updatable = false),
			@JoinColumn(name = "financialYear", referencedColumnName = "financialYear", nullable = false, insertable = false, updatable = false),
			@JoinColumn(name = "typeofInstitution", referencedColumnName = "typeofInstitution", nullable = false, insertable = false, updatable = false) })
	public List<RecognizationDetails> recognizationDetails;

	// DETAILS OF VISITING FACULTIES

	@OneToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.LAZY)
	@NotFound(action = NotFoundAction.IGNORE)
	@JoinColumns({
			@JoinColumn(name = "collegeId", referencedColumnName = "collegeId", nullable = false, insertable = false, updatable = false),
			@JoinColumn(name = "financialYear", referencedColumnName = "financialYear", nullable = false, insertable = false, updatable = false),
			@JoinColumn(name = "typeofInstitution", referencedColumnName = "typeofInstitution", nullable = false, insertable = false, updatable = false) })
	public List<DetailsofVisitingFaculties> detailsofVisitingFaculties;

	// non teaching staff
//    
	@OneToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.LAZY)
	@NotFound(action = NotFoundAction.IGNORE)
	@JoinColumns({
			@JoinColumn(name = "collegeId", referencedColumnName = "collegeId", nullable = false, insertable = false, updatable = false),
			@JoinColumn(name = "financialYear", referencedColumnName = "financialYear", nullable = false, insertable = false, updatable = false),
			@JoinColumn(name = "typeofInstitution", referencedColumnName = "typeofInstitution", nullable = false, insertable = false, updatable = false) })
	public List<NonTeachingStaff> nonTeachingStaff;

	@OneToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.LAZY)
	@NotFound(action = NotFoundAction.IGNORE)
	@JoinColumns({
			@JoinColumn(name = "collegeId", referencedColumnName = "collegeId", nullable = false, insertable = false, updatable = false),
			@JoinColumn(name = "financialYear", referencedColumnName = "financialYear", nullable = false, insertable = false, updatable = false),
			@JoinColumn(name = "typeofInstitution", referencedColumnName = "typeofInstitution", nullable = false, insertable = false, updatable = false) })
	public List<TechnicalStaff> technicalStaff;

	// acedamic perminent

	@OneToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.LAZY)
	@NotFound(action = NotFoundAction.IGNORE)
	@JoinColumns({
			@JoinColumn(name = "collegeId", referencedColumnName = "collegeId", nullable = false, insertable = false, updatable = false),
			@JoinColumn(name = "financialYear", referencedColumnName = "financialYear", nullable = false, insertable = false, updatable = false),
			@JoinColumn(name = "typeofInstitution", referencedColumnName = "typeofInstitution", nullable = false, insertable = false, updatable = false) })
	public List<AcademicPerminentTeachers> academicPerminentTeachers;

	@OneToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.LAZY)
	@NotFound(action = NotFoundAction.IGNORE)
	@JoinColumns({
			@JoinColumn(name = "collegeId", referencedColumnName = "collegeId", nullable = false, insertable = false, updatable = false),
			@JoinColumn(name = "financialYear", referencedColumnName = "financialYear", nullable = false, insertable = false, updatable = false),
			@JoinColumn(name = "typeofInstitution", referencedColumnName = "typeofInstitution", nullable = false, insertable = false, updatable = false) })
	public List<AcademicTemporaryTeachers> academicTemporaryTeachers;

	@OneToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.LAZY)
	@NotFound(action = NotFoundAction.IGNORE)
	@JoinColumns({
			@JoinColumn(name = "collegeId", referencedColumnName = "collegeId", nullable = false, insertable = false, updatable = false),
			@JoinColumn(name = "financialYear", referencedColumnName = "financialYear", nullable = false, insertable = false, updatable = false),
			@JoinColumn(name = "typeofInstitution", referencedColumnName = "typeofInstitution", nullable = false, insertable = false, updatable = false) })
	public List<AcademicParttimeTeacheres> academicParttimeTeacheres;

	// basic

	@OneToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.LAZY)
	@NotFound(action = NotFoundAction.IGNORE)
	@JoinColumns({
			@JoinColumn(name = "collegeId", referencedColumnName = "collegeId", nullable = false, insertable = false, updatable = false),
			@JoinColumn(name = "financialYear", referencedColumnName = "financialYear", nullable = false, insertable = false, updatable = false),
			@JoinColumn(name = "typeofInstitution", referencedColumnName = "typeofInstitution", nullable = false, insertable = false, updatable = false) })
	public List<InstitutionCollegeAffiliated> institutionCollegeAffiliated;

	@OneToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.LAZY)
	@NotFound(action = NotFoundAction.IGNORE)
	@JoinColumns({
			@JoinColumn(name = "collegeId", referencedColumnName = "collegeId", nullable = false, insertable = false, updatable = false),
			@JoinColumn(name = "financialYear", referencedColumnName = "financialYear", nullable = false, insertable = false, updatable = false),
			@JoinColumn(name = "typeofInstitution", referencedColumnName = "typeofInstitution", nullable = false, insertable = false, updatable = false) })
	public List<NatureofInstitution> natureofInstitution;

	public CriteriaPrimaryKey getCriteriaId() {
		return criteriaId;
	}

	public void setCriteriaId(CriteriaPrimaryKey criteriaId) {
		this.criteriaId = criteriaId;
	}

	public String getInputa4t1() {
		if (inputa4t1!=null) {
			return inputa4t1;
		}
		else {
			return "";
		}
	}

	public void setInputa4t1(String inputa4t1) {
		this.inputa4t1 = inputa4t1;
	}

	public String getInputa4t2() {
		if (inputa4t2!=null) {
			return inputa4t2;
		}
		else {
			return "";
		}
	}

	public void setInputa4t2(String inputa4t2) {
		this.inputa4t2 = inputa4t2;
	}

	public String getInputatg1() {
		if (inputatg1!=null) {
			return inputatg1;
		}
		else {
			return "";
		}
	}

	public void setInputatg1(String inputatg1) {
		this.inputatg1 = inputatg1;
	}

	public List<AffiliatedEnrollment> getAffiliatedEnrollment() {
		return affiliatedEnrollment;
	}

	public void setAffiliatedEnrollment(List<AffiliatedEnrollment> affiliatedEnrollment) {
		this.affiliatedEnrollment = affiliatedEnrollment;
	}

	public List<BasicProfile> getBasicProfile() {
		return basicProfile;
	}

	public void setBasicProfile(List<BasicProfile> basicProfile) {
		this.basicProfile = basicProfile;
	}

	public List<ContactsforCommunication> getContactsforCommunication() {
		return contactsforCommunication;
	}

	public void setContactsforCommunication(List<ContactsforCommunication> contactsforCommunication) {
		this.contactsforCommunication = contactsforCommunication;
	}

	public List<AffiliatedStatus> getAffiliatedStatus() {
		return affiliatedStatus;
	}

	public void setAffiliatedStatus(List<AffiliatedStatus> affiliatedStatus) {
		this.affiliatedStatus = affiliatedStatus;
	}

	public List<DetailsofUgcRecognition> getDetailsofUgcRecognition() {
		return detailsofUgcRecognition;
	}

	public void setDetailsofUgcRecognition(List<DetailsofUgcRecognition> detailsofUgcRecognition) {
		this.detailsofUgcRecognition = detailsofUgcRecognition;
	}

	public List<Recognition> getRecognition() {
		return recognition;
	}

	public void setRecognition(List<Recognition> recognition) {
		this.recognition = recognition;
	}

	public List<AffiliatedCampus> getAffiliatedCampus() {
		return affiliatedCampus;
	}

	public void setAffiliatedCampus(List<AffiliatedCampus> affiliatedCampus) {
		this.affiliatedCampus = affiliatedCampus;
	}

	public List<AcademicInformation> getAcademicinformation() {
		return academicinformation;
	}

	public void setAcademicinformation(List<AcademicInformation> academicinformation) {
		this.academicinformation = academicinformation;
	}

	public List<AffiliatedProgrammes> getAffiliatedProgrammes() {
		return affiliatedProgrammes;
	}

	public void setAffiliatedProgrammes(List<AffiliatedProgrammes> affiliatedProgrammes) {
		this.affiliatedProgrammes = affiliatedProgrammes;
	}

	public List<AffiliatedDepartment> getAffiliatedDepartment() {
		return affiliatedDepartment;
	}

	public void setAffiliatedDepartment(List<AffiliatedDepartment> affiliatedDepartment) {
		this.affiliatedDepartment = affiliatedDepartment;
	}

	public List<AffiliatedInstitution> getAffiliatedInstitution() {
		return affiliatedInstitution;
	}

	public void setAffiliatedInstitution(List<AffiliatedInstitution> affiliatedInstitution) {
		this.affiliatedInstitution = affiliatedInstitution;
	}

	public List<AffiliatedTeachingstaff> getAffiliatedTeachingstaff() {
		return affiliatedTeachingstaff;
	}

	public void setAffiliatedTeachingstaff(List<AffiliatedTeachingstaff> affiliatedTeachingstaff) {
		this.affiliatedTeachingstaff = affiliatedTeachingstaff;
	}

	public List<AffiliatedEducation> getAffiliatedEducation() {
		return affiliatedEducation;
	}

	public void setAffiliatedEducation(List<AffiliatedEducation> affiliatedEducation) {
		this.affiliatedEducation = affiliatedEducation;
	}

	public List<AffiliatedAccrediation> getAffiliatedAccrediation() {
		return affiliatedAccrediation;
	}

	public void setAffiliatedAccrediation(List<AffiliatedAccrediation> affiliatedAccrediation) {
		this.affiliatedAccrediation = affiliatedAccrediation;
	}

	public List<AffiliatedAnnualQuality> getAffiliatedAnnualQuality() {
		return affiliatedAnnualQuality;
	}

	public void setAffiliatedAnnualQuality(List<AffiliatedAnnualQuality> affiliatedAnnualQuality) {
		this.affiliatedAnnualQuality = affiliatedAnnualQuality;
	}

	public List<AffiliatedAdmittstudents> getAffiliatedAdmittstudents() {
		return affiliatedAdmittstudents;
	}

	public void setAffiliatedAdmittstudents(List<AffiliatedAdmittstudents> affiliatedAdmittstudents) {
		this.affiliatedAdmittstudents = affiliatedAdmittstudents;
	}

	public List<ProgrammeIntroduced> getProgrammeIntroduced() {
		return programmeIntroduced;
	}

	public void setProgrammeIntroduced(List<ProgrammeIntroduced> programmeIntroduced) {
		this.programmeIntroduced = programmeIntroduced;
	}

	public List<basicprofile_2> getBasicprofile2() {
		return basicprofile2;
	}

	public void setBasicprofile2(List<basicprofile_2> basicprofile2) {
		this.basicprofile2 = basicprofile2;
	}

	public List<Campus> getCampus() {
		return campus;
	}

	public void setCampus(List<Campus> campus) {
		this.campus = campus;
	}

	public List<AcademicInstitution> getAcademicinstitution() {
		return academicinstitution;
	}

	public void setAcademicinstitution(List<AcademicInstitution> academicinstitution) {
		this.academicinstitution = academicinstitution;
	}

	public List<AcademicStudentsEnrolled> getAcademicstudentsEnrolled() {
		return academicstudentsEnrolled;
	}

	public void setAcademicstudentsEnrolled(List<AcademicStudentsEnrolled> academicstudentsEnrolled) {
		this.academicstudentsEnrolled = academicstudentsEnrolled;
	}

	public List<AcademicStudentsAdmitted> getAcademicstudentsAdmitted() {
		return academicstudentsAdmitted;
	}

	public void setAcademicstudentsAdmitted(List<AcademicStudentsAdmitted> academicstudentsAdmitted) {
		this.academicstudentsAdmitted = academicstudentsAdmitted;
	}

	public List<EvaluativeReport> getEvaluativeReport() {
		return evaluativeReport;
	}

	public void setEvaluativeReport(List<EvaluativeReport> evaluativeReport) {
		this.evaluativeReport = evaluativeReport;
	}

	public List<EvaluativeFileUpload> getEvaluativeFileupload() {
		return evaluativeFileupload;
	}

	public void setEvaluativeFileupload(List<EvaluativeFileUpload> evaluativeFileupload) {
		this.evaluativeFileupload = evaluativeFileupload;
	}

	public List<Multidisciplinaryinterdisciplinary> getMultidisciplinaryInterdisciplinary() {
		return multidisciplinaryInterdisciplinary;
	}

	public void setMultidisciplinaryInterdisciplinary(
			List<Multidisciplinaryinterdisciplinary> multidisciplinaryInterdisciplinary) {
		this.multidisciplinaryInterdisciplinary = multidisciplinaryInterdisciplinary;
	}

	public List<AuniversityAffiliated> getAuniversityAffiliated() {
		return auniversityAffiliated;
	}

	public void setAuniversityAffiliated(List<AuniversityAffiliated> auniversityAffiliated) {
		this.auniversityAffiliated = auniversityAffiliated;
	}

	public List<AuniversityAffiliated1> getAuniversityAffiliated1() {
		return auniversityAffiliated1;
	}

	public void setAuniversityAffiliated1(List<AuniversityAffiliated1> auniversityAffiliated1) {
		this.auniversityAffiliated1 = auniversityAffiliated1;
	}

	public List<UniversityColleges> getUniversityColleges() {
		return universityColleges;
	}

	public void setUniversityColleges(List<UniversityColleges> universityColleges) {
		this.universityColleges = universityColleges;
	}

	public List<AcademiciansAppointed> getAcademiciansAppointed() {
		return academiciansAppointed;
	}

	public void setAcademiciansAppointed(List<AcademiciansAppointed> academiciansAppointed) {
		this.academiciansAppointed = academiciansAppointed;
	}

	public List<IntegratedProgrammes> getIntegratedProgrammes() {
		return integratedProgrammes;
	}

	public void setIntegratedProgrammes(List<IntegratedProgrammes> integratedProgrammes) {
		this.integratedProgrammes = integratedProgrammes;
	}

	public List<HumanResourceDevelopment> getHumanResourceDevelopment() {
		return humanResourceDevelopment;
	}

	public void setHumanResourceDevelopment(List<HumanResourceDevelopment> humanResourceDevelopment) {
		this.humanResourceDevelopment = humanResourceDevelopment;
	}

	public List<InstitutedUniversity> getInstitutedUniversity() {
		return institutedUniversity;
	}

	public void setInstitutedUniversity(List<InstitutedUniversity> institutedUniversity) {
		this.institutedUniversity = institutedUniversity;
	}

	public List<ProgrammesOffred> getProgrammesOffered() {
		return programmesOffered;
	}

	public void setProgrammesOffered(List<ProgrammesOffred> programmesOffered) {
		this.programmesOffered = programmesOffered;
	}

	public List<Proffessionalprogrammes> getProffessionalprogrammes() {
		return proffessionalprogrammes;
	}

	public void setProffessionalprogrammes(List<Proffessionalprogrammes> proffessionalprogrammes) {
		this.proffessionalprogrammes = proffessionalprogrammes;
	}

	public List<RecognizedMinority> getRecognizedMinority() {
		return recognizedMinority;
	}

	public void setRecognizedMinority(List<RecognizedMinority> recognizedMinority) {
		this.recognizedMinority = recognizedMinority;
	}

	public List<RecognizationDetails> getRecognizationDetails() {
		return recognizationDetails;
	}

	public void setRecognizationDetails(List<RecognizationDetails> recognizationDetails) {
		this.recognizationDetails = recognizationDetails;
	}

	public List<DetailsofVisitingFaculties> getDetailsofVisitingFaculties() {
		return detailsofVisitingFaculties;
	}

	public void setDetailsofVisitingFaculties(List<DetailsofVisitingFaculties> detailsofVisitingFaculties) {
		this.detailsofVisitingFaculties = detailsofVisitingFaculties;
	}

	public List<NonTeachingStaff> getNonTeachingStaff() {
		return nonTeachingStaff;
	}

	public void setNonTeachingStaff(List<NonTeachingStaff> nonTeachingStaff) {
		this.nonTeachingStaff = nonTeachingStaff;
	}

	public List<TechnicalStaff> getTechnicalStaff() {
		return technicalStaff;
	}

	public void setTechnicalStaff(List<TechnicalStaff> technicalStaff) {
		this.technicalStaff = technicalStaff;
	}

	public List<AcademicPerminentTeachers> getAcademicPerminentTeachers() {
		return academicPerminentTeachers;
	}

	public void setAcademicPerminentTeachers(List<AcademicPerminentTeachers> academicPerminentTeachers) {
		this.academicPerminentTeachers = academicPerminentTeachers;
	}

	public List<AcademicTemporaryTeachers> getAcademicTemporaryTeachers() {
		return academicTemporaryTeachers;
	}

	public void setAcademicTemporaryTeachers(List<AcademicTemporaryTeachers> academicTemporaryTeachers) {
		this.academicTemporaryTeachers = academicTemporaryTeachers;
	}

	public List<AcademicParttimeTeacheres> getAcademicParttimeTeacheres() {
		return academicParttimeTeacheres;
	}

	public void setAcademicParttimeTeacheres(List<AcademicParttimeTeacheres> academicParttimeTeacheres) {
		this.academicParttimeTeacheres = academicParttimeTeacheres;
	}

	public List<InstitutionCollegeAffiliated> getInstitutionCollegeAffiliated() {
		return institutionCollegeAffiliated;
	}

	public void setInstitutionCollegeAffiliated(List<InstitutionCollegeAffiliated> institutionCollegeAffiliated) {
		this.institutionCollegeAffiliated = institutionCollegeAffiliated;
	}

	public List<NatureofInstitution> getNatureofInstitution() {
		return natureofInstitution;
	}

	public void setNatureofInstitution(List<NatureofInstitution> natureofInstitution) {
		this.natureofInstitution = natureofInstitution;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	// afiliated

	// affiliated teaching

	
	
	
	
	
	
}
