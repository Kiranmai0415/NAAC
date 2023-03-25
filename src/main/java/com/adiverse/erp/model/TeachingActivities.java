//package com.adiverse.erp.model;
//
//import java.io.Serializable;
//import java.util.List;
//
//import javax.persistence.CascadeType;
//import javax.persistence.Column;
//
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.OneToMany;
//import javax.persistence.Table;
//
//
//@Entity
//@Table(name="teachingactivities")
//public class TeachingActivities implements Serializable
//{
//	private static final long serialVersionUID = 6930284536355492655L;
//
//	@Id
//	@GeneratedValue(strategy=GenerationType.IDENTITY)
//
//	private long teaching_id;
//	
//	  @Column(name="teachingEmail")
//	  private String ff1t1;
//	  
//	  @Column(name="teaching_nameoftheFaculty")
//	  private String ff1t2;
//	  
//	  @Column(name="teachingDepartment")
//	  private String ff1t3;
//	  
//	  @Column(name="teachingYear") 
//	  private String ff1t4;
//	  
//	  @Column(name="teachingSection")
//	  private String ff1t5;
//	  
//	  @Column(name="teachingSubjecthandling")
//	  private String ff1t6;
//	  
//	  @Column(name="teachingtopicDelivered")
//	  private String ff1t7;
//	  
//	  @Column(name="teachingDate")
//	  private String ff1t8;
//	  
//	  @Column(name="teachingTime")
//	  private String ff1t9;
//	 
//	  @Column(name="no_of_students_participated")
//	  private String ff1t10;
//	  
//	  @Column(name="modeofTeaching")
//	  private String ff1t11;
//	
//	  @Column(name="teachingRemarks")
//	  private String ff1t12;
//	  
//	  
//	  @OneToMany(targetEntity = DocumentSubmission.class,cascade=CascadeType.ALL)
//	  @JoinColumn(name="faculty_foreignkey",referencedColumnName="teaching_id")
//	  private List<DocumentSubmission> documentSubmission;
//	  
//	  @OneToMany(targetEntity = ResearchPublications.class,cascade=CascadeType.ALL)
//	  @JoinColumn(name="faculty_foreignkey",referencedColumnName="teaching_id")
//	  private List<ResearchPublications> researchPublications;
//	  
//	  @OneToMany(targetEntity = EventDetails.class,cascade=CascadeType.ALL)
//	  @JoinColumn(name="faculty_foreignkey",referencedColumnName="teaching_id")
//	  private List<EventDetails> eventDetails;
//	  
//	  @OneToMany(targetEntity = FacultydailyReport.class,cascade=CascadeType.ALL)
//	  @JoinColumn(name="faculty_foreignkey",referencedColumnName="teaching_id")
//	  private List<FacultydailyReport> facultydailyReport;
//	  
//	  @OneToMany(targetEntity = FacultyReport.class,cascade=CascadeType.ALL)
//	  @JoinColumn(name="faculty_foreignkey",referencedColumnName="teaching_id")
//	  private List<FacultyReport> facultyReport;
//	  
//	  @OneToMany(targetEntity = FacultyFileupload.class,cascade=CascadeType.ALL)
//	  @JoinColumn(name="faculty_foreignkey",referencedColumnName="teaching_id")
//	  private List<FacultyFileupload> facultyFileupload;
//
//	public long getTeaching_id() {
//		return teaching_id;
//	}
//
//	public void setTeaching_id(long teaching_id) {
//		this.teaching_id = teaching_id;
//	}
//
//	public String getFf1t1() {
//		if (ff1t1!=null) {
//			return ff1t1;
//		}
//		else {
//			return "";
//		}
//		
//	}
//
//	public void setFf1t1(String ff1t1) {
//		this.ff1t1 = ff1t1;
//	}
//
//	public String getFf1t2() {
//		if (ff1t2!=null) {
//			return ff1t2;
//		}
//		else {
//			return "";
//		}
//		
//	}
//
//	public void setFf1t2(String ff1t2) {
//		this.ff1t2 = ff1t2;
//	}
//
//	public String getFf1t3() {
//		if (ff1t3!=null) {
//			return ff1t3;
//		}
//		else {
//			return "";
//		}
//		
//	}
//
//	public void setFf1t3(String ff1t3) {
//		this.ff1t3 = ff1t3;
//	}
//
//	public String getFf1t4() {
//		if (ff1t4!=null) {
//			return ff1t4;
//		}
//		else {
//			return "";
//		}
//		
//	}
//
//	public void setFf1t4(String ff1t4) {
//		this.ff1t4 = ff1t4;
//	}
//
//	public String getFf1t5() {
//		if (ff1t5!=null) {
//			return ff1t5;
//		}
//		else {
//			return "";
//		}
//		
//	}
//
//	public void setFf1t5(String ff1t5) {
//		this.ff1t5 = ff1t5;
//	}
//
//	public String getFf1t6() {
//		if (ff1t6!=null) {
//			return ff1t6;
//		}
//		else {
//			return "";
//		}
//		
//	}
//
//	public void setFf1t6(String ff1t6) {
//		this.ff1t6 = ff1t6;
//	}
//
//	public String getFf1t7() {
//		if (ff1t7!=null) {
//			return ff1t7;
//		}
//		else {
//			return "";
//		}
//	}
//
//	public void setFf1t7(String ff1t7) {
//		this.ff1t7 = ff1t7;
//	}
//
//	public String getFf1t8() {
//		if (ff1t8!=null) {
//			return ff1t8;
//		}
//		else {
//			return "";
//		}
//		
//	}
//
//	public void setFf1t8(String ff1t8) {
//		this.ff1t8 = ff1t8;
//	}
//
//	public String getFf1t9() {
//		if (ff1t9!=null) {
//			return ff1t9;
//		}
//		else {
//			return "";
//		}
//		
//	}
//
//	public void setFf1t9(String ff1t9) {
//		this.ff1t9 = ff1t9;
//	}
//
//	public String getFf1t10() {
//		if (ff1t10!=null) {
//			return ff1t10;
//		}
//		else {
//			return "";
//		}
//		
//	}
//
//	public void setFf1t10(String ff1t10) {
//		this.ff1t10 = ff1t10;
//	}
//
//	public String getFf1t11() {
//		if (ff1t11!=null) {
//			return ff1t11;
//		}
//		else {
//			return "";
//		}
//		
//	}
//
//	public void setFf1t11(String ff1t11) {
//		this.ff1t11 = ff1t11;
//	}
//
//	public String getFf1t12() {
//		if (ff1t12!=null) {
//			return ff1t12;
//		}
//		else {
//			return "";
//		}
//		
//	}
//
//	public void setFf1t12(String ff1t12) {
//		this.ff1t12 = ff1t12;
//	}
//
//	public List<DocumentSubmission> getDocumentSubmission() {
//		return documentSubmission;
//	}
//
//	public void setDocumentSubmission(List<DocumentSubmission> documentSubmission) {
//		this.documentSubmission = documentSubmission;
//	}
//
//	public List<ResearchPublications> getResearchPublications() {
//		return researchPublications;
//	}
//
//	public void setResearchPublications(List<ResearchPublications> researchPublications) {
//		this.researchPublications = researchPublications;
//	}
//
//	public List<EventDetails> getEventDetails() {
//		return eventDetails;
//	}
//
//	public void setEventDetails(List<EventDetails> eventDetails) {
//		this.eventDetails = eventDetails;
//	}
//
//	public List<FacultydailyReport> getFacultydailyReport() {
//		return facultydailyReport;
//	}
//
//	public void setFacultydailyReport(List<FacultydailyReport> facultydailyReport) {
//		this.facultydailyReport = facultydailyReport;
//	}
//
//	public List<FacultyReport> getFacultyReport() {
//		return facultyReport;
//	}
//
//	public void setFacultyReport(List<FacultyReport> facultyReport) {
//		this.facultyReport = facultyReport;
//	}
//
//	public List<FacultyFileupload> getFacultyFileupload() {
//		return facultyFileupload;
//	}
//
//	public void setFacultyFileupload(List<FacultyFileupload> facultyFileupload) {
//		this.facultyFileupload = facultyFileupload;
//	}
//
//	public static long getSerialversionuid() {
//		return serialVersionUID;
//	}
//
//	
//
//	
//	  
//}
//
//
