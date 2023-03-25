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
@Table(name="mentee_form")
public class MenteeForm implements Serializable
{
	private static final long serialVersionUID = 1912350747026034527L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)

	private long menteeform_id;
	
	  @Column(name="mentee_sno")
	  private String mf1t1;
	  
	  @Column(name="mentee_rollno")
	  private String mf1t2;
	  
	  @Column(name="mentee_name")
	  private String mf1t3;
	  
	  @Column(name="mentee_phoneno") 
	  private String mf1t4;
	  
	  @Column(name="mentee_parentPhoneno") 
	  private String mf1t5;
	  
	  @Column(name="mentee_emailid")
	  private String mf1t6;
	  
	  @Column(name="mentee_sscCgpa")
	  private String mf1t7;
	  
	  @Column(name="mentee_interCgpa")
	  private String mf1t8;
	  
	  @Column(name="mentee_eamcetRank")
	  private String mf1t9;
	  
	  @Column(name="mentee_management")
	  private String mf1t10;
	 
	  @Column(name="mentee_I_I")
	  private String mf1t11;
	  
	  @Column(name="mentee_I_II")
	  private String mf1t12;
	
	  @Column(name="mentee_II_I")
	  private String mf1t13;
	  
	  @Column(name="mentee_II_II")
	  private String mf1t14;
	  
	  @Column(name="mentee_III_I")
	  private String mf1t15;
	  
	  @Column(name="mentee_III_II")
	  private String mf1t16;
	  
	  @Column(name="mentee_IV_I")
	  private String mf1t17;
	  
	  @Column(name="mentee_IV_II")
	  private String mf1t18;
	  
	  @Column(name="mentee_feeDues")
	  private String mf1t19;
	  
	  @Column(name="mentee_memberofClub")
	  private String mf1t20;
	  
	  @Column(name="mentee_higherEducation")
	  private String mf1t21;
	  
	  @Column(name="mentee_gaurdian")
	  private String mf1t22;
	  
	  @Column(name="mentee_interships")
	  private String mf1t23;
	  
	  @Column(name="mentee_events")
	  private String mf1t24;
	  
	  @Column(name="mentee_health")
	  private String mf1t25;

	  @Column(name="mentee_remarks")
	  private String mf1t26;

	public long getMenteeform_id() {
		return menteeform_id;
	}

	public void setMenteeform_id(long menteeform_id) {
		this.menteeform_id = menteeform_id;
	}

	public String getMf1t1() {
		if(mf1t1 !=null) {
			return mf1t1;
		}else {
			return "";
		}
	}

	public void setMf1t1(String mf1t1) {
		this.mf1t1 = mf1t1;
	}

	public String getMf1t2() {
		if(mf1t2 !=null) {
			return mf1t2;
		}else {
			return "";
		}
	}

	public void setMf1t2(String mf1t2) {
		this.mf1t2 = mf1t2;
	}

	public String getMf1t3() {
		if(mf1t3 !=null) {
			return mf1t3;
		}else {
			return "";
		}
	}

	public void setMf1t3(String mf1t3) {
		this.mf1t3 = mf1t3;
	}

	public String getMf1t4() {
		if(mf1t4 !=null) {
			return mf1t4;
		}else {
			return "";
		}
	}

	public void setMf1t4(String mf1t4) {
		this.mf1t4 = mf1t4;
	}

	public String getMf1t5() {
		if(mf1t5 !=null) {
			return mf1t5;
		}else {
			return "";
		}
	}

	public void setMf1t5(String mf1t5) {
		this.mf1t5 = mf1t5;
	}

	public String getMf1t6() {
		if(mf1t6 !=null) {
			return mf1t6;
		}else {
			return "";
		}
	}

	public void setMf1t6(String mf1t6) {
		this.mf1t6 = mf1t6;
	}

	public String getMf1t7() {
		if(mf1t7 !=null) {
			return mf1t7;
		}else {
			return "";
		}
	}

	public void setMf1t7(String mf1t7) {
		this.mf1t7 = mf1t7;
	}

	public String getMf1t8() {
		if(mf1t8 !=null) {
			return mf1t8;
		}else {
			return "";
		}
	}

	public void setMf1t8(String mf1t8) {
		this.mf1t8 = mf1t8;
	}

	public String getMf1t9() {
		if(mf1t9 !=null) {
			return mf1t9;
		}else {
			return "";
		}
	}

	public void setMf1t9(String mf1t9) {
		this.mf1t9 = mf1t9;
	}

	public String getMf1t10() {
		if(mf1t10 !=null) {
			return mf1t10;
		}else {
			return "";
		}
	}

	public void setMf1t10(String mf1t10) {
		this.mf1t10 = mf1t10;
	}

	public String getMf1t11() {
		if(mf1t11 !=null) {
			return mf1t11;
		}else {
			return "";
		}
	}

	public void setMf1t11(String mf1t11) {
		this.mf1t11 = mf1t11;
	}

	public String getMf1t12() {
		if(mf1t12 !=null) {
			return mf1t12;
		}else {
			return "";
		}
	}

	public void setMf1t12(String mf1t12) {
		this.mf1t12 = mf1t12;
	}

	public String getMf1t13() {
		if(mf1t13 !=null) {
			return mf1t13;
		}else {
			return "";
		}
	}

	public void setMf1t13(String mf1t13) {
		this.mf1t13 = mf1t13;
	}

	public String getMf1t14() {
		if(mf1t14 !=null) {
			return mf1t14;
		}else {
			return "";
		}
	}

	public void setMf1t14(String mf1t14) {
		this.mf1t14 = mf1t14;
	}

	public String getMf1t15() {
		if(mf1t15 !=null) {
			return mf1t15;
		}else {
			return "";
		}
	}

	public void setMf1t15(String mf1t15) {
		this.mf1t15 = mf1t15;
	}

	public String getMf1t16() {
		if(mf1t16 !=null) {
			return mf1t16;
		}else {
			return "";
		}
	}

	public void setMf1t16(String mf1t16) {
		this.mf1t16 = mf1t16;
	}

	public String getMf1t17() {
		if(mf1t17 !=null) {
			return mf1t17;
		}else {
			return "";
		}
	}

	public void setMf1t17(String mf1t17) {
		this.mf1t17 = mf1t17;
	}

	public String getMf1t18() {
		if(mf1t18 !=null) {
			return mf1t18;
		}else {
			return "";
		}
	}

	public void setMf1t18(String mf1t18) {
		this.mf1t18 = mf1t18;
	}

	public String getMf1t19() {
		if(mf1t19 !=null) {
			return mf1t19;
		}else {
			return "";
		}
	}

	public void setMf1t19(String mf1t19) {
		this.mf1t19 = mf1t19;
	}

	public String getMf1t20() {
		if(mf1t20 !=null) {
			return mf1t20;
		}else {
			return "";
		}
	}

	public void setMf1t20(String mf1t20) {
		this.mf1t20 = mf1t20;
	}

	public String getMf1t21() {
		if(mf1t21 !=null) {
			return mf1t21;
		}else {
			return "";
		}
	}

	public void setMf1t21(String mf1t21) {
		this.mf1t21 = mf1t21;
	}

	public String getMf1t22() {
		if(mf1t22 !=null) {
			return mf1t22;
		}else {
			return "";
		}
	}

	public void setMf1t22(String mf1t22) {
		this.mf1t22 = mf1t22;
	}

	public String getMf1t23() {
		if(mf1t23 !=null) {
			return mf1t23;
		}else {
			return "";
		}
	}

	public void setMf1t23(String mf1t23) {
		this.mf1t23 = mf1t23;
	}

	public String getMf1t24() {
		if(mf1t24 !=null) {
			return mf1t24;
		}else {
			return "";
		}
	}

	public void setMf1t24(String mf1t24) {
		this.mf1t24 = mf1t24;
	}

	public String getMf1t25() {
		if(mf1t25 !=null) {
			return mf1t25;
		}else {
			return "";
		}
	}

	public void setMf1t25(String mf1t25) {
		this.mf1t25 = mf1t25;
	}

	public String getMf1t26() {
		if(mf1t26 !=null) {
			return mf1t26;
		}else {
			return "";
		}
	}

	public void setMf1t26(String mf1t26) {
		this.mf1t26 = mf1t26;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	  
//	  @OneToMany(targetEntity = AdmissionEnquiryForm.class,cascade=CascadeType.ALL)
//	  @JoinColumn(name="admission_foreignkey",referencedColumnName="admissionform_id")
//	  private List<AdmissionEnquiryForm> admissionEnquiryform;
	  
	  
	

	
	  
}


