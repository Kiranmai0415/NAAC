package com.adiverse.erp.model;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="laptopavailability")

public class LaptopAvailability_MB implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long laptop_id;
	
	@Column(name = "laptopEmail")
	private String sf2t1;
	
	@Column(name = "studentrollno")
	private String sf2t2;
	
	@Column(name = "laptopNameofthestudent")
	private String sf2t3;
	
	@Column(name = "laptopDepartment")
	private String sf2t4;
	
	@Column(name = "whetherlaptopisavailable")
	private String sf2t5;
	
	@Column(name = "laptopModel")
	private String sf2t6;
	
	@Column(name = "ramsize")
	private String sf2t7;
	
	@Column(name = "hddcapacity")
	private String  sf2t8;
	
	@Column(name = "typeofinternetfacilityavailable")
	private String sf2t9;
	
	@Column(name = "laptopRemarks")
	private String sf2t10;
	
	
	  
	  @Column(name="work_Status")
	   private String workstatus;
		  
	  @Column(name="checker_Id")
	   private String checkerid;
	 
	  @Column(name="checker_Date")
	   private String checkerdate;
	
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public long getLaptop_id() {
		return laptop_id;
	}
	public void setLaptop_id(long laptop_id) {
		this.laptop_id = laptop_id;
	}
	public String getSf2t1() {
		if(sf2t1 !=null) {
			return sf2t1;
		}else {
			return "";
		}
	}
	public void setSf2t1(String sf2t1) {
		this.sf2t1 = sf2t1;
	}
	public String getSf2t2() {
		if(sf2t2 !=null) {
			return sf2t2;
		}else {
			return "";
		}
	}
	public void setSf2t2(String sf2t2) {
		this.sf2t2 = sf2t2;
	}
	public String getSf2t3() {
		if(sf2t3 !=null) {
			return sf2t3;
		}else {
			return "";
		}
	}
	public void setSf2t3(String sf2t3) {
		this.sf2t3 = sf2t3;
	}
	public String getSf2t4() {
		if(sf2t4 !=null) {
			return sf2t4;
		}else {
			return "";
		}
	}
	public void setSf2t4(String sf2t4) {
		this.sf2t4 = sf2t4;
	}
	public String getSf2t5() {
		if(sf2t5 !=null) {
			return sf2t5;
		}else {
			return "";
		}
	}
	public void setSf2t5(String sf2t5) {
		this.sf2t5 = sf2t5;
	}
	public String getSf2t6() {
		if(sf2t6 !=null) {
			return sf2t6;
		}else {
			return "";
		}
	}
	public void setSf2t6(String sf2t6) {
		this.sf2t6 = sf2t6;
	}
	
	public String getSf2t7() {
		return sf2t7;
	}
	public void setSf2t7(String sf2t7) {
		this.sf2t7 = sf2t7;
	}
	public String getSf2t8() {
		if(sf2t8 !=null) {
			return sf2t8;
		}else {
			return "";
		}
	}
	public void setSf2t8(String sf2t8) {
		this.sf2t8 = sf2t8;
	}
	public String getSf2t9() {
		if(sf2t9 !=null) {
			return sf2t9;
		}else {
			return "";
		}
	}
	public void setSf2t9(String sf2t9) {
		this.sf2t9 = sf2t9;
	}
	public String getSf2t10() {
		if(sf2t10 !=null) {
			return sf2t10;
		}else {
			return "";
		}
	}
	public void setSf2t10(String sf2t10) {
		this.sf2t10 = sf2t10;
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




