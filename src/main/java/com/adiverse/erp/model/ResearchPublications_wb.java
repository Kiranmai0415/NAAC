package com.adiverse.erp.model;


import java.util.List;
import java.util.Objects;

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
@Table(name="researchPublications")
public class ResearchPublications_wb {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long research_id;
	
	
	@Column(name = "research_email")
	private String ff3t1;
	
	@Column(name = "research_employeeid")
	private String ff3t2;
	
	@Column(name = "research_nameofthefaculty")
	private String ff3t3;
	
	@Column(name = "research_department")
	private String ff3t4;
	
	@Column(name = "research_scopusid")
	private String ff3t5;
	
	@Column(name = "research_scopusindexofcmrgiauthours")
	private String ff3t6;
	
	@Column(name = "research_ranking")
	private String ff3t7;
	
	@Column(name = "research_vidwanid")
	private String  ff3t8;
	
	@Column(name = "research_titleofthepublication")
	private String ff3t9;
	
	@Column(name = "research_nameofthejournal")
	private String ff3t10;
	
	@Column(name = "research_issn")
	private String  ff3t11;
	
	@Column(name = "research_volumeno")
	private String ff3t12;
	
	@Column(name = "research_issueno")
	private String ff3t13;
	
	@Column(name = "research_monthofpublication")
	private String ff3t14;
	
	@Column(name = "research_yearofpublication")
	private String  ff3t15;
	
	@Column(name = "research_digitalobjectidentifier")
	private String ff3t16;
	
	@Column(name = "research_remarks")
	private String ff3t17;
	
	  
	  @Column(name="work_Status")
	   private String workstatus;
		  
	  @Column(name="marker_Id")
	   private String markerid;
	 
	  @Column(name="marker_Date")
	   private String markerdate;
	
	  @OneToMany(targetEntity = FacultyFileupload.class,cascade=CascadeType.ALL)
	  @JoinColumn(name="research_foreignkey",referencedColumnName="research_id")
	  private List<FacultyFileupload> facultyFileupload;
	
	
	
	public String getWorkstatus() {
		return workstatus;
	}
	public void setWorkstatus(String workstatus) {
		this.workstatus = workstatus;
	}
	
	public String getMarkerid() {
		return markerid;
	}
	public void setMarkerid(String markerid) {
		this.markerid = markerid;
	}
	public String getMarkerdate() {
		return markerdate;
	}
	public void setMarkerdate(String markerdate) {
		this.markerdate = markerdate;
	}
	
	public List<FacultyFileupload> getFacultyFileupload() {
		return facultyFileupload;
	}
	public void setFacultyFileupload(List<FacultyFileupload> facultyFileupload) {
		this.facultyFileupload = facultyFileupload;
	}
	public long getRsearch_id() {
		return research_id;
	}
	public void setRsearch_id(long rsearch_id) {
		this.research_id = rsearch_id;
	}
	public long getResearch_id() {
		return research_id;
	}
	public void setResearch_id(long research_id) {
		this.research_id = research_id;
	}
	public String getFf3t1() {
		if (ff3t1!=null) {
			return ff3t1;
		}
		else {
			return "";
		}
		
	}
	public void setFf3t1(String ff3t1) {
		this.ff3t1 = ff3t1;
	}
	public String getFf3t2() {
		if (ff3t2!=null) {
			return ff3t2;
		}
		else {
			return "";
		}
	}
	public void setFf3t2(String ff3t2) {
		this.ff3t2 = ff3t2;
	}
	public String getFf3t3() {
		if (ff3t3!=null) {
			return ff3t3;
		}
		else {
			return "";
		}
	}
	public void setFf3t3(String ff3t3) {
		this.ff3t3 = ff3t3;
	}
	public String getFf3t4() {
		if (ff3t4!=null) {
			return ff3t4;
		}
		else {
			return "";
		}
	}
	public void setFf3t4(String ff3t4) {
		this.ff3t4 = ff3t4;
	}
	public String getFf3t5() {
		if (ff3t5!=null) {
			return ff3t5;
		}
		else {
			return "";
		}
	}
	public void setFf3t5(String ff3t5) {
		this.ff3t5 = ff3t5;
	}
	public String getFf3t6() {
		if (ff3t6!=null) {
			return ff3t6;
		}
		else {
			return "";
		}
	}
	public void setFf3t6(String ff3t6) {
		this.ff3t6 = ff3t6;
	}
	public String getFf3t7() {
		if (ff3t7!=null) {
			return ff3t7;
		}
		else {
			return "";
		}
	}
	public void setFf3t7(String ff3t7) {
		this.ff3t7 = ff3t7;
	}
	public String getFf3t8() {
		if (ff3t8!=null) {
			return ff3t8;
		}
		else {
			return "";
		}
	}
	public void setFf3t8(String ff3t8) {
		this.ff3t8 = ff3t8;
	}
	public String getFf3t9() {
		if (ff3t9!=null) {
			return ff3t9;
		}
		else {
			return "";
		}
	}
	public void setFf3t9(String ff3t9) {
		this.ff3t9 = ff3t9;
	}
	public String getFf3t10() {
		if (ff3t10!=null) {
			return ff3t10;
		}
		else {
			return "";
		}
	}
	public void setFf3t10(String ff3t10) {
		this.ff3t10 = ff3t10;
	}
	public String getFf3t11() {
		if (ff3t11!=null) {
			return ff3t11;
		}
		else {
			return "";
		}
	}
	public void setFf3t11(String ff3t11) {
		this.ff3t11 = ff3t11;
	}
	public String getFf3t12() {
		if (ff3t12!=null) {
			return ff3t12;
		}
		else {
			return "";
		}
	}
	public void setFf3t12(String ff3t12) {
		this.ff3t12 = ff3t12;
	}
	public String getFf3t13() {
		if (ff3t13!=null) {
			return ff3t13;
		}
		else {
			return "";
		}
	}
	public void setFf3t13(String ff3t13) {
		this.ff3t13 = ff3t13;
	}
	public String getFf3t14() {
		if (ff3t14!=null) {
			return ff3t14;
		}
		else {
			return "";
		}
	}
	public void setFf3t14(String ff3t14) {
		this.ff3t14 = ff3t14;
	}
	public String getFf3t15() {
		if (ff3t15!=null) {
			return ff3t15;
		}
		else {
			return "";
		}
	}
	public void setFf3t15(String ff3t15) {
		this.ff3t15 = ff3t15;
	}
	public String getFf3t16() {
		if (ff3t16!=null) {
			return ff3t16;
		}
		else {
			return "";
		}
	}
	public void setFf3t16(String ff3t16) {
		this.ff3t16 = ff3t16;
	}
	public String getFf3t17() {
		if (ff3t17!=null) {
			return ff3t17;
		}
		else {
			return "";
		}
	}
	public void setFf3t17(String ff3t17) {
		this.ff3t17 = ff3t17;
	}
	
	
}
