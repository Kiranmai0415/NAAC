package com.adiverse.erp.model;

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
@Table(name="course_registrationform")
public class CourseRegistrationform_WB {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long course_id;
	
	@Column(name = "course_email")
	private String sf4t1;
	
	@Column(name = "course_year")
	private String sf4t2;
	
	@Column(name = "course_rollno")
	private String sf4t3;
	
	@Column(name = "course_nameofthestudent")
	private String sf4t4;
	
	@Column(name = "course_contact")
	private String sf4t5;
	
	@Column(name = "course_amountpaid")
	private String sf4t6;
	
	@Column(name = "course_transactionid")
	private String sf4t7;
	
	@Column(name = "course_declaration")
	private String  sf4t8;

	@Column(name = "studentInternship_remarks")
	private String sf4t9;
	
	  
	  @Column(name="work_Status")
	   private String workstatus;
		  
	  @Column(name="maker_Id")
	   private String makerid;
	 
	  @Column(name="maker_Date")
	   private String makerdate;
	
	

  @OneToMany(targetEntity = CourseRegistreFileUpload1.class,cascade=CascadeType.ALL)
	@JoinColumn(name="course_foreignkey",referencedColumnName="course_id")
		private List<CourseRegistreFileUpload1> courseRegistreFileUpload;
	  
	  

	public long getCourse_id() {
		return course_id;
	}

	public void setCourse_id(long course_id) {
		this.course_id = course_id;
	}

	public String getSf4t1() {
		if(sf4t1 !=null) {
		return sf4t1;
	}else {
		return "";
	}
	}

	public void setSf4t1(String sf4t1) {
		this.sf4t1 = sf4t1;
	}

	public String getSf4t2() {
		if(sf4t2 !=null) {
		return sf4t2;
	}else {
		return "";
	}
	}

	public void setSf4t2(String sf4t2) {
		this.sf4t2 = sf4t2;
	}

	public String getSf4t3() {
		if(sf4t3 !=null) {
		return sf4t3;
	}else {
		return "";
	}
	}

	public void setSf4t3(String sf4t3) {
		this.sf4t3 = sf4t3;
	}

	public String getSf4t4() {
		if(sf4t4 !=null) {
		return sf4t4;
	}else {
		return "";
	}
	}

	public void setSf4t4(String sf4t4) {
		this.sf4t4 = sf4t4;
	}

	public String getSf4t5() {
		if(sf4t5 !=null) {
		return sf4t5;
	}else {
		return "";
	}
	}

	public void setSf4t5(String sf4t5) {
		this.sf4t5 = sf4t5;
	}

	public String getSf4t6() {
		if(sf4t6 !=null) {
		return sf4t6;
	}else {
		return "";
	}
	}

	public void setSf4t6(String sf4t6) {
		this.sf4t6 = sf4t6;
	}

	public String getSf4t7() {
		if(sf4t7 !=null) {
		return sf4t7;
	}else {
		return "";
	}
	}

	public void setSf4t7(String sf4t7) {
		this.sf4t7 = sf4t7;
	}

	public String getSf4t8() {
		if(sf4t8 !=null) {
		return sf4t8;
	}else {
		return "";
	}
	}

	public void setSf4t8(String sf4t8) {
		this.sf4t8 = sf4t8;
	}

	public String getSf4t9() {
		if(sf4t9 !=null) {
		return sf4t9;
	}else {
		return "";
	}
	}

	public void setSf4t9(String sf4t9) {
		this.sf4t9 = sf4t9;
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

	public List<CourseRegistreFileUpload1> getCourseRegistreFileUpload() {
		return courseRegistreFileUpload;
	}

	public void setCourseRegistreFileUpload(List<CourseRegistreFileUpload1> courseRegistreFileUpload) {
		this.courseRegistreFileUpload = courseRegistreFileUpload;
	}

	public void setMakerdate(String makerdate) {
		this.makerdate = makerdate;
	}



//	public List<CourseRegistreFileUpload> getCourseRegistreFileUpload() {
//		return courseRegistreFileUpload;
//	}
//
//	public void setCourseRegistreFileUpload(List<CourseRegistreFileUpload> courseRegistreFileUpload) {
//		this.courseRegistreFileUpload = courseRegistreFileUpload;
//	}
//	
//	
	

	
	
}


