package com.adiverse.erp.model;
import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="studentformwb")
public class StudentForm_WB implements Serializable
{


	private static final long serialVersionUID = 403944080310232741L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long student_id;
	
	@Column(name = "studentEmail")
	private String sf1t1;
	
	@Column(name = "studentRollno")
	private String sf1t2;
	
	@Column(name = "studentName")
	private String sf1t3;
	
	@Column(name = "studentContactno")
	private String sf1t4;
	
	@Column(name = "studentProgramme")
	private String sf1t5;
	
	@Column(name = "studentDepartment")
	private String sf1t6;
	
	@Column(name = "studentCurrentyear")
	private String sf1t7;
	
	@Column(name = "studentSection")
	private String  sf1t8;
	
	@Column(name = "studentDocuments")
	private String sf1t9;
	
	@Column(name = "studentAddress")
	private String sf1t10;

	@Column(name = "studentRemarks")
	private String sf1t11;
	
	  
	  @Column(name="work_Status")
	   private String workstatus;
		  
	  @Column(name="maker_Id")
	   private String makerid;
	 
	  @Column(name="maker_Date")
	   private String makerdate;
	
	
	
	@OneToMany(targetEntity = LaptopAvailability_WB.class,cascade=CascadeType.ALL)
	@JoinColumn(name="student_foreignkey",referencedColumnName="student_id")
	private List<LaptopAvailability_WB> laptopAvailability;
	
	@OneToMany(targetEntity = StudentInternshipForm_WB.class,cascade=CascadeType.ALL)
	@JoinColumn(name="student_foreignkey",referencedColumnName="student_id")
	private List<StudentInternshipForm_WB> studentInternshipform;
	
	@OneToMany(targetEntity = CourseRegistrationform_WB.class,cascade=CascadeType.ALL)
	@JoinColumn(name="student_foreignkey",referencedColumnName="student_id")
	private List<CourseRegistrationform_WB> courseRegistrationform;
	
	@OneToMany(targetEntity = StudentFileupload.class,cascade=CascadeType.ALL)
	@JoinColumn(name="student_foreignkey",referencedColumnName="student_id")
	private List<StudentFileupload> studentFileupload;

	public long getStudent_id() {
		return student_id;
	}

	public void setStudent_id(long student_id) {
		this.student_id = student_id;
	}

	public String getSf1t1() {
		if (sf1t1!=null) {
			return sf1t1;
		}
		else {
			return "";
		}
		
	}

	public void setSf1t1(String sf1t1) {
		this.sf1t1 = sf1t1;
	}

	public String getSf1t2() {
		if (sf1t2!=null) {
			return sf1t2;
		}
		else {
			return "";
		}
	}

	public void setSf1t2(String sf1t2) {
		this.sf1t2 = sf1t2;
	}

	public String getSf1t3() {
		if (sf1t3!=null) {
			return sf1t3;
		}
		else {
			return "";
		}
	}

	public void setSf1t3(String sf1t3) {
		this.sf1t3 = sf1t3;
	}

	public String getSf1t4() {
		if (sf1t4!=null) {
			return sf1t4;
		}
		else {
			return "";
		}
	}

	public void setSf1t4(String sf1t4) {
		this.sf1t4 = sf1t4;
	}

	public String getSf1t5() {
		if (sf1t5!=null) {
			return sf1t5;
		}
		else {
			return "";
		}
	}

	public void setSf1t5(String sf1t5) {
		this.sf1t5 = sf1t5;
	}

	public String getSf1t6() {
		if (sf1t6!=null) {
			return sf1t6;
		}
		else {
			return "";
		}
	}

	public void setSf1t6(String sf1t6) {
		this.sf1t6 = sf1t6;
	}

	public String getSf1t7() {
		if (sf1t7!=null) {
			return sf1t7;
		}
		else {
			return "";
		}
	}

	public void setSf1t7(String sf1t7) {
		this.sf1t7 = sf1t7;
	}

	public String getSf1t8() {
		if (sf1t8!=null) {
			return sf1t8;
		}
		else {
			return "";
		}
	}

	public void setSf1t8(String sf1t8) {
		this.sf1t8 = sf1t8;
	}

	public String getSf1t9() {
		if (sf1t9!=null) {
			return sf1t9;
		}
		else {
			return "";
		}
	}

	public void setSf1t9(String sf1t9) {
		this.sf1t9 = sf1t9;
	}

	public String getSf1t10() {
		if (sf1t10!=null) {
			return sf1t10;
		}
		else {
			return "";
		}
	}

	public void setSf1t10(String sf1t10) {
		this.sf1t10 = sf1t10;
	}

	public String getSf1t11() {
		if (sf1t11!=null) {
			return sf1t11;
		}
		else {
			return "";
		}
	}

	public void setSf1t11(String sf1t11) {
		this.sf1t11 = sf1t11;
	}

	public List<LaptopAvailability_WB> getLaptopAvailability() {
		return laptopAvailability;
	}

	public void setLaptopAvailability(List<LaptopAvailability_WB> laptopAvailability) {
		this.laptopAvailability = laptopAvailability;
	}

	public List<StudentInternshipForm_WB> getStudentInternshipform() {
		return studentInternshipform;
	}

	public void setStudentInternshipform(List<StudentInternshipForm_WB> studentInternshipform) {
		this.studentInternshipform = studentInternshipform;
	}

	public List<StudentFileupload> getStudentFileupload() {
		return studentFileupload;
	}

	public void setStudentFileupload(List<StudentFileupload> studentFileupload) {
		this.studentFileupload = studentFileupload;
	}

	public List<CourseRegistrationform_WB> getCourseRegistrationform() {
		return courseRegistrationform;
	}

	public void setCourseRegistrationform(List<CourseRegistrationform_WB> courseRegistrationform) {
		this.courseRegistrationform = courseRegistrationform;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
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


