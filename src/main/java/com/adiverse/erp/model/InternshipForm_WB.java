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
@Table(name="internshipformwb")
public class InternshipForm_WB implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5190759914048090752L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long internship_id;
	
	@Column(name = "internship_fullname")
	private String if1t1;
	
	@Column(name = "internship_rollno")
	private String if1t2;
	
	@Column(name = "internship_branch")
	private String if1t3;
	
	@Column(name = "internship_year")
	private String if1t4;
	
	@Column(name = "internship_section")
	private String if1t5;
	
	@Column(name = "internship_mobileno")
	private String if1t6;
	
	@Column(name = "internship_emailid")
	private String if1t7;
	
	@Column(name = "internship_nameofthecompany")
	private String  if1t8;

	@Column(name = "internship_salary")
	private String if1t9;
	
	@Column(name = "internship_amount")
	private String if1t10;
	
	@Column(name = "internship_information")
	private String if1t11;
	
	  @Column(name="work_Status")
	   private String workstatus;
		  
	  @Column(name="maker_Id")
	   private String makerid;
	 
	  @Column(name="maker_Date")
	   private String makerdate;
	
	
	@OneToMany(targetEntity = InternshipFileupload.class,cascade=CascadeType.ALL)
	@JoinColumn(name="internship_foreignkey",referencedColumnName="internship_id")
	private List<InternshipFileupload> internshipFileupload;

	public long getInternship_id() {
		return internship_id;
	}

	public void setInternship_id(long internship_id) {
		this.internship_id = internship_id;
	}

	public String getIf1t1() {
		if(if1t1 !=null) {
			return if1t1;
		}else {
			return "";
		}
	}

	public void setIf1t1(String if1t1) {
		this.if1t1 = if1t1;
	}

	public String getIf1t2() {
		if(if1t2 !=null) {
			return if1t2;
		}else {
			return "";
		}
	}

	public void setIf1t2(String if1t2) {
		this.if1t2 = if1t2;
	}

	public String getIf1t3() {
		if(if1t3 !=null) {
			return if1t3;
		}else {
			return "";
		}
	}

	public void setIf1t3(String if1t3) {
		this.if1t3 = if1t3;
	}

	public String getIf1t4() {
		if(if1t4 !=null) {
			return if1t4;
		}else {
			return "";
		}
	}

	public void setIf1t4(String if1t4) {
		this.if1t4 = if1t4;
	}

	public String getIf1t5() {
		if(if1t5 !=null) {
			return if1t5;
		}else {
			return "";
		}
	}

	public void setIf1t5(String if1t5) {
		this.if1t5 = if1t5;
	}

	public String getIf1t6() {
		if(if1t6 !=null) {
			return if1t6;
		}else {
			return "";
		}
	}

	public void setIf1t6(String if1t6) {
		this.if1t6 = if1t6;
	}

	public String getIf1t7() {
		if(if1t7 !=null) {
			return if1t7;
		}else {
			return "";
		}
	}

	public void setIf1t7(String if1t7) {
		this.if1t7 = if1t7;
	}

	public String getIf1t8() {
		if(if1t8 !=null) {
			return if1t8;
		}else {
			return "";
		}
	}

	public void setIf1t8(String if1t8) {
		this.if1t8 = if1t8;
	}

	public String getIf1t9() {
		if(if1t9 !=null) {
			return if1t9;
		}else {
			return "";
		}
	}

	public void setIf1t9(String if1t9) {
		this.if1t9 = if1t9;
	}

	public String getIf1t10() {
		if(if1t10 !=null) {
			return if1t10;
		}else {
			return "";
		}
	}

	public void setIf1t10(String if1t10) {
		this.if1t10 = if1t10;
	}

	public String getIf1t11() {
		if(if1t11 !=null) {
			return if1t11;
		}else {
			return "";
		}
	}

	public void setIf1t11(String if1t11) {
		this.if1t11 = if1t11;
	}

	public List<InternshipFileupload> getInternshipFileupload() {
		return internshipFileupload;
	}

	public void setInternshipFileupload(List<InternshipFileupload> internshipFileupload) {
		this.internshipFileupload = internshipFileupload;
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


