package com.adiverse.erp.model;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="facultydailyReport")
public class FacultydailyReport_WB
{
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
		  
	  @Column(name="maker_Id")
	   private String makerid;
	 
	  @Column(name="maker_Date")
	   private String makerdate;
	  
	  

	public long getFaculty_id() {
		return faculty_id;
	}

	public void setFaculty_id(long faculty_id) {
		this.faculty_id = faculty_id;
	}

	public String getFf5t1() {
		if(ff5t1!=null) {
			return ff5t1;
		}else {
			return "";
		}
	}

	public void setFf5t1(String ff5t1) {
		this.ff5t1 = ff5t1;
	}

	public String getFf5t2() {
		if(ff5t2!=null) {
			return ff5t2;
		}else {
			return "";
		}
	}

	public void setFf5t2(String ff5t2) {
		this.ff5t2 = ff5t2;
	}

	public String getFf5t3() {
		if(ff5t3!=null) {
			return ff5t3;
		}else {
			return "";
		}
	}

	public void setFf5t3(String ff5t3) {
		this.ff5t3 = ff5t3;
	}

	public String getFf5t4() {
		if(ff5t4!=null) {
			return ff5t4;
		}else {
			return "";
		}
	}

	public void setFf5t4(String ff5t4) {
		this.ff5t4 = ff5t4;
	}

	public String getFf5t5() {
		if(ff5t5!=null) {
			return ff5t5;
		}else {
			return "";
		}
	}

	public void setFf5t5(String ff5t5) {
		this.ff5t5 = ff5t5;
	}

	public String getFf5t6() {
		if(ff5t6!=null) {
			return ff5t6;
		}else {
			return "";
		}
	}

	public void setFf5t6(String ff5t6) {
		this.ff5t6 = ff5t6;
	}

	public String getFf5t7() {
		if(ff5t7!=null) {
			return ff5t7;
		}else {
			return "";
		}
	}

	public void setFf5t7(String ff5t7) {
		this.ff5t7 = ff5t7;
	}

	public String getFf5t8() {
		if(ff5t8!=null) {
			return ff5t8;
		}else {
			return "";
		}
	}

	public void setFf5t8(String ff5t8) {
		this.ff5t8 = ff5t8;
	}

	public String getFf5t9() {
		if(ff5t9!=null) {
			return ff5t9;
		}else {
			return "";
		}
	}

	public void setFf5t9(String ff5t9) {
		this.ff5t9 = ff5t9;
	}

	public String getFf5t10() {
		if(ff5t10!=null) {
			return ff5t10;
		}else {
			return "";
		}
	}

	public void setFf5t10(String ff5t10) {
		this.ff5t10 = ff5t10;
	}

	public String getFf5t11() {
		if(ff5t11!=null) {
			return ff5t11;
		}else {
			return "";
		}
	}

	public void setFf5t11(String ff5t11) {
		this.ff5t11 = ff5t11;
	}

	public String getFf5t12() {
		if(ff5t12!=null) {
			return ff5t12;
		}else {
			return "";
		}
	}

	public void setFf5t12(String ff5t12) {
		this.ff5t12 = ff5t12;
	}

	public String getFf5t13() {
		if(ff5t13!=null) {
			return ff5t13;
		}else {
			return "";
		}
	}

	public void setFf5t13(String ff5t13) {
		this.ff5t13 = ff5t13;
	}

	public String getFf5t14() {
		if(ff5t14!=null) {
			return ff5t14;
		}else {
			return "";
		}
	}

	public void setFf5t14(String ff5t14) {
		this.ff5t14 = ff5t14;
	}

	public String getFf5t15() {
		if(ff5t15!=null) {
			return ff5t15;
		}else {
			return "";
		}
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

	public String getMakerid() {
		return makerid;
	}

	public void setMakerid(String makerid) {
		this.makerid = makerid;
	}

	public String getMakerdate() {
		return makerdate;
	}

	public void setMakerdate(String makerdate) {
		this.makerdate = makerdate;
	}

	
}


