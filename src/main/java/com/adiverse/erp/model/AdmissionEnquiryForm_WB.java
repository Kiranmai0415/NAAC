package com.adiverse.erp.model;



import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="admissionenquiryform")
public class AdmissionEnquiryForm_WB 
{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)

	private long admissioneform_id;
	
	  @Column(name="admissione_email")
	  private String af2t1;
	  
	  @Column(name="admissione_name")
	  private String af2t2;
	  
	  @Column(name="admissione_mobileno")
	  private String af2t3;
	  
	  @Column(name="admissione_fathername") 
	  private String af2t4;
	  
	  @Column(name="admissione_fathercontact")
	  private String af2t5;
	  
	  @Column(name="admissione_mothername")
	  private String af2t6;
	 
	  @Column(name="admissione_mothercontact")
	  private String af2t7;
	  
	  @Column(name="admissione_course1")
	  private String af2t8;
	  
	  @Column(name="admissione_course2")
	  private String af2t9;
	 
	  @Column(name="admissione_course3")
	  private String af2t10;
	  
	  @Column(name="admissione_sscmarks")
	  private String af2t11;
	
	  @Column(name="admissione_intermarks")
	  private String af2t12;
	  
	  @Column(name="admissione_tseamcetRank")
	  private String af2t13;
	  
	  @Column(name="admissione_remarks")
	  private String af2t14;
	  
	  
	  @Column(name="work_Status")
	   private String workstatus;
		  
	  @Column(name="maker_Id")
	   private String makerid;
	 
	  @Column(name="maker_Date")
	   private String makerdate;
	  
	
	  
	  

	public long getAdmissioneform_id() {
		return admissioneform_id;
	}

	public void setAdmissioneform_id(long admissioneform_id) {
		this.admissioneform_id = admissioneform_id;
	}

	public String getAf2t1() {
		if(af2t1 !=null) {
		return af2t1;
	}else {
		return "";
	}
	}

	public void setAf2t1(String af2t1) {
		this.af2t1 = af2t1;
	}

	public String getAf2t2() {
		if(af2t2 !=null) {
		return af2t2;
	}else {
		return "";
	}
	}

	public void setAf2t2(String af2t2) {
		this.af2t2 = af2t2;
	}

	public String getAf2t3() {
		if(af2t3 !=null) {
		return af2t3;
	}else {
		return "";
	}
	}

	public void setAf2t3(String af2t3) {
		this.af2t3 = af2t3;
	}

	public String getAf2t4() {
		if(af2t4 !=null) {
		return af2t4;
	}else {
		return "";
	}
	}

	public void setAf2t4(String af2t4) {
		this.af2t4 = af2t4;
	}

	public String getAf2t5() {
		if(af2t5 !=null) {
		return af2t5;
	}else {
		return "";
	}
	}

	public void setAf2t5(String af2t5) {
		this.af2t5 = af2t5;
	}

	public String getAf2t6() {
		if(af2t6 !=null) {
		return af2t6;
	}else {
		return "";
	}
	}

	public void setAf2t6(String af2t6) {
		this.af2t6 = af2t6;
	}

	public String getAf2t7() {
		if(af2t7 !=null) {
		return af2t7;
	}else {
		return "";
	}
	}

	public void setAf2t7(String af2t7) {
		this.af2t7 = af2t7;
	}

	public String getAf2t8() {
		if(af2t8 !=null) {
		return af2t8;
	}else {
		return "";
	}
	}

	public void setAf2t8(String af2t8) {
		this.af2t8 = af2t8;
	}

	public String getAf2t9() {
		if(af2t9 !=null) {
		return af2t9;
	}else {
		return "";
	}
	}

	public void setAf2t9(String af2t9) {
		this.af2t9 = af2t9;
	}

	public String getAf2t10() {
		if(af2t10 !=null) {
		return af2t10;
	}else {
		return "";
	}
	}

	public void setAf2t10(String af2t10) {
		this.af2t10 = af2t10;
	}

	public String getAf2t11() {
		if(af2t11 !=null) {
		return af2t11;
	}else {
		return "";
	}
	}

	public void setAf2t11(String af2t11) {
		this.af2t11 = af2t11;
	}

	public String getAf2t12() {
		if(af2t12 !=null) {
		return af2t12;
	}else {
		return "";
	}
	}

	public void setAf2t12(String af2t12) {
		this.af2t12 = af2t12;
	}

	public String getAf2t13() {
		if(af2t13 !=null) {
		return af2t13;
	}else {
		return "";
	}
	}

	public void setAf2t13(String af2t13) {
		this.af2t13 = af2t13;
	}

	public String getAf2t14() {
		if(af2t14 !=null) {
		return af2t14;
	}else {
		return "";
	}
	}

	public void setAf2t14(String af2t14) {
		this.af2t14 = af2t14;
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

	@Override
	public int hashCode() {
		return Objects.hash(admissioneform_id, af2t1, af2t10, af2t11, af2t12, af2t13, af2t14, af2t2, af2t3, af2t4,
				af2t5, af2t6, af2t7, af2t8, af2t9, makerdate, makerid, workstatus);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AdmissionEnquiryForm_WB other = (AdmissionEnquiryForm_WB) obj;
		return admissioneform_id == other.admissioneform_id && Objects.equals(af2t1, other.af2t1)
				&& Objects.equals(af2t10, other.af2t10) && Objects.equals(af2t11, other.af2t11)
				&& Objects.equals(af2t12, other.af2t12) && Objects.equals(af2t13, other.af2t13)
				&& Objects.equals(af2t14, other.af2t14) && Objects.equals(af2t2, other.af2t2)
				&& Objects.equals(af2t3, other.af2t3) && Objects.equals(af2t4, other.af2t4)
				&& Objects.equals(af2t5, other.af2t5) && Objects.equals(af2t6, other.af2t6)
				&& Objects.equals(af2t7, other.af2t7) && Objects.equals(af2t8, other.af2t8)
				&& Objects.equals(af2t9, other.af2t9) && Objects.equals(makerdate, other.makerdate)
				&& Objects.equals(makerid, other.makerid) && Objects.equals(workstatus, other.workstatus);
	}
	

	
}


