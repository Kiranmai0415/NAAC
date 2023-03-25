package com.adiverse.erp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="studentInternshipform")
public class StudentInternshipForm_MB {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long studentInternship_id;
	
	@Column(name = "studentInternship_email")
	private String sf3t1;
	
	@Column(name = "studentInternship_rollno")
	private String sf3t2;
	
	@Column(name = "studentInternship_department")
	private String sf3t3;
	
	@Column(name = "studentInternship_placerintern")
	private String sf3t4;
	
	@Column(name = "studentInternship_organisation")
	private String sf3t5;
	
	@Column(name = "studentInternship_package")
	private String sf3t6;
	
	@Column(name = "studentInternship_month")
	private String sf3t7;
	
	@Column(name = "studentInternship_year")
	private String  sf3t8;

	@Column(name = "studentInternship_remarks")
	private String sf3t9;
	
	
	  
	  @Column(name="work_Status")
	   private String workstatus;
		  
	  @Column(name="checker_Id")
	   private String checkerid;
	 
	  @Column(name="checker_Date")
	   private String checkerdate;
	
	
	

	public long getStudentInternship_id() {
		return studentInternship_id;
	}

	public void setStudentInternship_id(long studentInternship_id) {
		this.studentInternship_id = studentInternship_id;
	}

	public String getSf3t1() { 
		if (sf3t1!=null) {
			return sf3t1;
		}
		else {
			return "";
		}
		
	}

	public void setSf3t1(String sf3t1) {
		this.sf3t1 = sf3t1;
	}

	public String getSf3t2() {
		if (sf3t2!=null) {
			return sf3t2;
		}
		else {
			return "";
		}
	}

	public void setSf3t2(String sf3t2) {
		this.sf3t2 = sf3t2;
	}

	public String getSf3t3() {
		if (sf3t3!=null) {
			return sf3t3;
		}
		else {
			return "";
		}
	}

	public void setSf3t3(String sf3t3) {
		this.sf3t3 = sf3t3;
	}

	public String getSf3t4() {
		if (sf3t4!=null) {
			return sf3t4;
		}
		else {
			return "";
		}
	}

	public void setSf3t4(String sf3t4) {
		this.sf3t4 = sf3t4;
	}

	public String getSf3t5() {
		if (sf3t5!=null) {
			return sf3t5;
		}
		else {
			return "";
		}
	}

	public void setSf3t5(String sf3t5) {
		this.sf3t5 = sf3t5;
	}

	public String getSf3t6() {
		if (sf3t6!=null) {
			return sf3t6;
		}
		else {
			return "";
		}
	}

	public void setSf3t6(String sf3t6) {
		this.sf3t6 = sf3t6;
	}

	public String getSf3t7() {
		if (sf3t7!=null) {
			return sf3t7;
		}
		else {
			return "";
		}
	}

	public void setSf3t7(String sf3t7) {
		this.sf3t7 = sf3t7;
	}

	public String getSf3t8() {
		if (sf3t8!=null) {
			return sf3t8;
		}
		else {
			return "";
		}
	}

	public void setSf3t8(String sf3t8) {
		this.sf3t8 = sf3t8;
	}

	public String getSf3t9() {
		if (sf3t9!=null) {
			return sf3t9;
		}
		else {
			return "";
		}
	}

	public void setSf3t9(String sf3t9) {
		this.sf3t9 = sf3t9;
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


