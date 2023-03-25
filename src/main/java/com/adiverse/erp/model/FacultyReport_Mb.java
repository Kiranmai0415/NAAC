package com.adiverse.erp.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="facultyReport_MB")
public class FacultyReport_Mb implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EmbeddedId
    public CriteriaPrimaryKey criteriaId;

	private long facultyAprilreport_id;
	
	  @Column(name="facultyAprilemail")
	  private String ff6t1;
	  
	  @Column(name="aprilFacultyname")
	  private String ff6t2;
	  
	  @Column(name="aprilFacultydepartment")
	  private String ff6t3;
	  
	  @Column(name="theorySubjects_handled") 
	  private String ff6t4;
	  
	  @Column(name="labsHandled")
	  private String ff6t5;
	  
	  @Column(name="noofOnlineclasses")
	  private String ff6t6;
	  
	  @Column(name="noofunitsCovered")
	  private String ff6t7;
	  
	  @Column(name="averagenoofStudentspresent")
	  private String ff6t8;
	  
	  @Column(name="webinarsAttended")
	  private String ff6t9;
	 
	  @Column(name="fdps_attended")
	  private String ff6t10;
	  
	  @Column(name="aprilPublications")
	  private String ff6t11;
	
	  @Column(name="aprilcoursesRegistered")
	  private String ff6t12;
	  
	  @Column(name="aprilInnovation_covid19")
	  private String ff6t13;
	  
	  @Column(name="aprilAchievements")
	  private String ff6t14;
	  
	  @Column(name="april_menteesAssigned")
	  private String ff6t15;
	  
	  @Column(name="april_menteesRollnos")
	  private String ff6t16;
	  
	  @Column(name="mentees_Regularcontact")
	  private String ff6t17;
	  
	  @Column(name="april_menteesCertification")
	  private String ff6t18;
	  
	  @Column(name="april_facultyRemarks")
	  private String ff6t19;
	  
	  
	  @Column(name="work_Status")
	   private String workstatus;
		  
	  @Column(name="checker_Id")
	   private String checkerid;
	 
	  @Column(name="checker_Date")
	   private String checkerdate;
	  
	  
	  
	  

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

	public CriteriaPrimaryKey getCriteriaId() {
		return criteriaId;
	}

	public void setCriteriaId(CriteriaPrimaryKey criteriaId) {
		this.criteriaId = criteriaId;
	}

	public long getFacultyAprilreport_id() {
	return facultyAprilreport_id;
}

  public void setFacultyAprilreport_id(long facultyAprilreport_id) {
	this.facultyAprilreport_id = facultyAprilreport_id;
	}

	public String getFf6t1() {
		if(ff6t1 !=null) {
		return ff6t1;
	}else {
		return "";
	}
	}

	public void setFf6t1(String ff6t1) {
		this.ff6t1 = ff6t1;
	}

	public String getFf6t2() {
		if(ff6t2 !=null) {
			return ff6t2;
		}else {
			return "";
		}
	}

	public void setFf6t2(String ff6t2) {
		this.ff6t2 = ff6t2;
	}

	public String getFf6t3() {
		if(ff6t3 !=null) {
			return ff6t3;
		}else {
			return "";
		}
	}

	public void setFf6t3(String ff6t3) {
		this.ff6t3 = ff6t3;
	}

	public String getFf6t4() {
		if(ff6t4 !=null) {
			return ff6t4;
		}else {
			return "";
		}
	}

	public void setFf6t4(String ff6t4) {
		this.ff6t4 = ff6t4;
	}

	public String getFf6t5() {
		if(ff6t5 !=null) {
			return ff6t5;
		}else {
			return "";
		}
	}

	public void setFf6t5(String ff6t5) {
		this.ff6t5 = ff6t5;
	}

	public String getFf6t6() {
		if(ff6t6 !=null) {
			return ff6t6;
		}else {
			return "";
		}
	}

	public void setFf6t6(String ff6t6) {
		this.ff6t6 = ff6t6;
	}

	public String getFf6t7() {
		if(ff6t7 !=null) {
			return ff6t7;
		}else {
			return "";
		}
	}

	public void setFf6t7(String ff6t7) {
		this.ff6t7 = ff6t7;
	}

	public String getFf6t8() {
		if(ff6t8 !=null) {
			return ff6t8;
		}else {
			return "";
		}
	}

	public void setFf6t8(String ff6t8) {
		this.ff6t8 = ff6t8;
	}

	public String getFf6t9() {
		if(ff6t9 !=null) {
			return ff6t9;
		}else {
			return "";
		}
	}

	public void setFf6t9(String ff6t9) {
		this.ff6t9 = ff6t9;
	}

	public String getFf6t10() {
		if(ff6t10 !=null) {
			return ff6t10;
		}else {
			return "";
		}
	}

	public void setFf6t10(String ff6t10) {
		this.ff6t10 = ff6t10;
	}

	public String getFf6t11() {
		if(ff6t11 !=null) {
			return ff6t11;
		}else {
			return "";
		}
	}

	public void setFf6t11(String ff6t11) {
		this.ff6t11 = ff6t11;
	}

	public String getFf6t12() {
		if(ff6t12 !=null) {
			return ff6t12;
		}else {
			return "";
		}
	}

	public void setFf6t12(String ff6t12) {
		this.ff6t12 = ff6t12;
	}

	public String getFf6t13() {
		if(ff6t13 !=null) {
			return ff6t13;
		}else {
			return "";
		}
	}

	public void setFf6t13(String ff6t13) {
		this.ff6t13 = ff6t13;
	}

	public String getFf6t14() {
		if(ff6t14 !=null) {
			return ff6t14;
		}else {
			return "";
		}
	}

	public void setFf6t14(String ff6t14) {
		this.ff6t14 = ff6t14;
	}

	public String getFf6t15() {
		if(ff6t15 !=null) {
			return ff6t15;
		}else {
			return "";
		}
	}

	public void setFf6t15(String ff6t15) {
		this.ff6t15 = ff6t15;
	}

	public String getFf6t16() {
		if(ff6t16 !=null) {
			return ff6t16;
		}else {
			return "";
		}
	}

	public void setFf6t16(String ff6t16) {
		this.ff6t16 = ff6t16;
	}

	public String getFf6t17() {
		if(ff6t17 !=null) {
			return ff6t17;
		}else {
			return "";
		}
	}

	public void setFf6t17(String ff6t17) {
		this.ff6t17 = ff6t17;
	}

	public String getFf6t18() {
		if(ff6t18 !=null) {
			return ff6t18;
		}else {
			return "";
		}
	}

	public void setFf6t18(String ff6t18) {
		this.ff6t18 = ff6t18;
	}

	public String getFf6t19() {
		if(ff6t19 !=null) {
			return ff6t19;
		}else {
			return "";
		}
	}

	public void setFf6t19(String ff6t19) {
		this.ff6t19 = ff6t19;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}



}


