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
@Table(name="admissionform")
public class AdmissionForm_WB implements Serializable
{
	private static final long serialVersionUID = 1912350747026034527L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)

	private long admissionform_id;
	
	  @Column(name="admission_studentname")
	  private String af1t1;
	  
	  @Column(name="admission_stufathername")
	  private String af1t2;
	  
	  @Column(name="admission_stumothername")
	  private String af1t3;
	  
	  @Column(name="admission_stuadharno") 
	  private String af1t4;
	  
	  @Column(name="admission_stucourse")
	  private String af1t5;
	  
	  @Column(name="admission_stusection")//
	  private String af1t6;
	  
	  @Column(name="admission_stuadmission")
	  private String af1t7;
	  
	  @Column(name="admission_stucategory")
	  private String af1t8;
	  
	  @Column(name="admission_stumobileno")
	  private String af1t9;
	 
	  @Column(name="admission_stufathermobileno")
	  private String af1t10;
	  
	  @Column(name="admission_stuemailid")
	  private String af1t11;
	
	  @Column(name="admission_stuaddress")
	  private String af1t12;
	  
	  @Column(name="admission_stubloodg")
	  private String af1t13;
	  
	  @Column(name="admission_dob")
	  private String af1t14;
	  
	  @Column(name="work_Status")
	   private String workstatus;
		  
	  @Column(name="maker_Id")
	   private String makerid;
	 
	  @Column(name="maker_Date")
	   private String makerdate;
	  
	
	  

	  
	  @OneToMany(targetEntity = AdmissionEnquiryForm_WB.class,cascade=CascadeType.ALL)
	  @JoinColumn(name="admission_foreignkey",referencedColumnName="admissionform_id")
	  private List<AdmissionEnquiryForm_WB> admissionEnquiryform;
	  
	  @OneToMany(targetEntity = AdmissionFileupload.class,cascade=CascadeType.ALL)
	  @JoinColumn(name="admission_foreignkey",referencedColumnName="admissionform_id")
	  private List<AdmissionFileupload> admissionFileupload;
	

	public long getAdmissionform_id() {
		return admissionform_id;
	}

	public void setAdmissionform_id(long admissionform_id) {
		this.admissionform_id = admissionform_id;
	}

	public String getAf1t1() {
		if(af1t1 !=null) {
		return af1t1;
	}else {
		return "";
	}
	}

	public void setAf1t1(String af1t1) {
		this.af1t1 = af1t1;
	}

	public String getAf1t2() {
		if(af1t2 !=null) {
		return af1t2;
	}else {
		return "";
	}
		}

	public void setAf1t2(String af1t2) {
		this.af1t2 = af1t2;
	}

	public String getAf1t3() {
		if(af1t3 !=null) {
		return af1t3;
	}else {
		return "";
	}
	}

	public void setAf1t3(String af1t3) {
		this.af1t3 = af1t3;
	}

	public String getAf1t4() {
		if(af1t4 !=null) {
		return af1t4;
	}else {
		return "";
	}
	}

	public void setAf1t4(String af1t4) {
		this.af1t4 = af1t4;
	}

	public String getAf1t5() {
		if(af1t5 !=null) {
		return af1t5;
	}else {
		return "";
	}
	}

	public void setAf1t5(String af1t5) {
		this.af1t5 = af1t5;
	}

	public String getAf1t6() {
		if(af1t6 !=null) {
		return af1t6;
	}else {
		return "";
	}
	}

	public void setAf1t6(String af1t6) {
		this.af1t6 = af1t6;
	}

	public String getAf1t7() {
		if(af1t7 !=null) {
		return af1t7;
	}else {
		return "";
	}
	}

	public void setAf1t7(String af1t7) {
		this.af1t7 = af1t7;
	}

	public String getAf1t8() {
		if(af1t8 !=null) {
		return af1t8;
	}else {
		return "";
	}
	}

	public void setAf1t8(String af1t8) {
		this.af1t8 = af1t8;
	}

	public String getAf1t9() {
		if(af1t9 !=null) {
		return af1t9;
	}else {
		return "";
	}
	}

	public void setAf1t9(String af1t9) {
		this.af1t9 = af1t9;
	}

	public String getAf1t10() {
		if(af1t10 !=null) {
		return af1t10;
	}else {
		return "";
	}
	}

	public void setAf1t10(String af1t10) {
		this.af1t10 = af1t10;
	}

	public String getAf1t11() {
		if(af1t11 !=null) {
		return af1t11;
	}else {
		return "";
	}
	}

	public void setAf1t11(String af1t11) {
		this.af1t11 = af1t11;
	}

	public String getAf1t12() {
		if(af1t12 !=null) {
		return af1t12;
	}else {
		return "";
	}
	}

	public void setAf1t12(String af1t12) {
		this.af1t12 = af1t12;
	}

	public String getAf1t13() {
		if(af1t13 !=null) {
		return af1t13;
	}else {
		return "";
	}
	}

	public void setAf1t13(String af1t13) {
		this.af1t13 = af1t13;
	}

	public String getAf1t14() {
		if(af1t14  !=null) {
		return af1t14;
	}else {
		return "";
	}
	}

	public void setAf1t14(String af1t14) {
		this.af1t14 = af1t14;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public List<AdmissionEnquiryForm_WB> getAdmissionEnquiryform() {
		return admissionEnquiryform;
	}

	public void setAdmissionEnquiryform(List<AdmissionEnquiryForm_WB> admissionEnquiryform) {
		this.admissionEnquiryform = admissionEnquiryform;
	}

	public List<AdmissionFileupload> getAdmissionFileupload() {
		return admissionFileupload;
	}

	public void setAdmissionFileupload(List<AdmissionFileupload> admissionFileupload) {
		this.admissionFileupload = admissionFileupload;
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


