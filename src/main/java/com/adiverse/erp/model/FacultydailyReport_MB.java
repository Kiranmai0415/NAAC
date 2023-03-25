package com.adiverse.erp.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class FacultydailyReport_MB {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)

	private long faculty_id;
	
	  @Column(name="facultyEmail")
	  private String ff5t1;
	  
	  @Column(name="facultyEmployeeid")
	  private String ff5t2;
	  
	  @Column(name="report_nameoftheFaculty")
	  private String ff5t3;
	  
	  @Column(name="facultyDepartment") 
	  private String ff5t4;
	  
	  @Column(name="faculty_sessionEngaged")
	  private String ff5t5;
	  
	  @Column(name="faculty_subjectHandled")
	  private String ff5t6;
	  
	  @Column(name="facultytopicDelivered")
	  private String ff5t7;
	  
	  @Column(name="facultyYear")
	  private String ff5t8;
	  
	  @Column(name="facultyBranch")
	  private String ff5t9;
	 
	  @Column(name="facultySection")
	  private String ff5t10;
	  
	  @Column(name="faculty_noofstudentsPresent")
	  private String ff5t11;
	
	  @Column(name="faculty_noofstudentsAbsent")
	  private String ff5t12;
	  
	  @Column(name="meetingwithMentees")
	  private String ff5t13;
	  
	  @Column(name="noofMenteesparticipated")
	  private String ff5t14;
	  
	  @Column(name="facultyRemarks")
	  private String ff5t15;
	  
	  @Column(name="work_Status")
	   private String workstatus;
		  
	  @Column(name="checker_Id")
	   private String checkerid;
	 
	  @Column(name="checker_Date")
	   private String checkerdate;

	public long getFaculty_id() {
		return faculty_id;
	}

	public void setFaculty_id(long faculty_id) {
		this.faculty_id = faculty_id;
	}

	public String getFf5t1() {
		return ff5t1;
	}

	public void setFf5t1(String ff5t1) {
		this.ff5t1 = ff5t1;
	}

	public String getFf5t2() {
		return ff5t2;
	}

	public void setFf5t2(String ff5t2) {
		this.ff5t2 = ff5t2;
	}

	public String getFf5t3() {
		return ff5t3;
	}

	public void setFf5t3(String ff5t3) {
		this.ff5t3 = ff5t3;
	}

	public String getFf5t4() {
		return ff5t4;
	}

	public void setFf5t4(String ff5t4) {
		this.ff5t4 = ff5t4;
	}

	public String getFf5t5() {
		return ff5t5;
	}

	public void setFf5t5(String ff5t5) {
		this.ff5t5 = ff5t5;
	}

	public String getFf5t6() {
		return ff5t6;
	}

	public void setFf5t6(String ff5t6) {
		this.ff5t6 = ff5t6;
	}

	public String getFf5t7() {
		return ff5t7;
	}

	public void setFf5t7(String ff5t7) {
		this.ff5t7 = ff5t7;
	}

	public String getFf5t8() {
		return ff5t8;
	}

	public void setFf5t8(String ff5t8) {
		this.ff5t8 = ff5t8;
	}

	public String getFf5t9() {
		return ff5t9;
	}

	public void setFf5t9(String ff5t9) {
		this.ff5t9 = ff5t9;
	}

	public String getFf5t10() {
		return ff5t10;
	}

	public void setFf5t10(String ff5t10) {
		this.ff5t10 = ff5t10;
	}

	public String getFf5t11() {
		return ff5t11;
	}

	public void setFf5t11(String ff5t11) {
		this.ff5t11 = ff5t11;
	}

	public String getFf5t12() {
		return ff5t12;
	}

	public void setFf5t12(String ff5t12) {
		this.ff5t12 = ff5t12;
	}

	public String getFf5t13() {
		return ff5t13;
	}

	public void setFf5t13(String ff5t13) {
		this.ff5t13 = ff5t13;
	}

	public String getFf5t14() {
		return ff5t14;
	}

	public void setFf5t14(String ff5t14) {
		this.ff5t14 = ff5t14;
	}

	public String getFf5t15() {
		return ff5t15;
	}

	public void setFf5t15(String ff5t15) {
		this.ff5t15 = ff5t15;
	}

	public String getWorkstatus() {
		return workstatus;
	}

	public void setWorkstatus(String workstatus) {
		this.workstatus = workstatus;
	}

	public String getCheckerid() {
		return checkerid;
	}

	public void setCheckerid(String checkerid) {
		this.checkerid = checkerid;
	}

	public String getCheckerdate() {
		return checkerdate;
	}

	public void setCheckerdate(String checkerdate) {
		this.checkerdate = checkerdate;
	}
	  
	  
	  
	  
	  

}
