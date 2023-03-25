package com.adiverse.erp.model;

import java.io.Serializable;
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
@Table(name="teachingactivities_wb")
public class TeachingActivities_WB implements Serializable
{
	private static final long serialVersionUID = 6930284536355492655L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)

	private long teaching_id;
	
	  @Column(name="teachingEmail")
	  private String ff1t1;
	  
	  @Column(name="teaching_nameoftheFaculty")
	  private String ff1t2;
	  
	  @Column(name="teachingDepartment")
	  private String ff1t3;
	  
	  @Column(name="teachingYear") 
	  private String ff1t4;
	  
	  @Column(name="teachingSection")
	  private String ff1t5;
	  
	  @Column(name="teachingSubjecthandling")
	  private String ff1t6;
	  
	  @Column(name="teachingtopicDelivered")
	  private String ff1t7;
	  
	  @Column(name="teachingDate")
	  private String ff1t8;
	  
	  @Column(name="teachingTime")
	  private String ff1t9;
	 
	  @Column(name="no_of_students_participated")
	  private String ff1t10;
	  
	  @Column(name="modeofTeaching")
	  private String ff1t11;
	
	  @Column(name="teachingRemarks")
	  private String ff1t12;
	  
	  
	  @Column(name="work_Status")
	   private String workstatus;
		  
	  @Column(name="maker_Id")
	   private String makerid;
	 
	  @Column(name="maker_Date")
	   private String makerdate;

	public long getTeaching_id() {
		return teaching_id;
	}

	public void setTeaching_id(long teaching_id) {
		this.teaching_id = teaching_id;
	}

	public String getFf1t1() {
		return ff1t1;
	}

	public void setFf1t1(String ff1t1) {
		this.ff1t1 = ff1t1;
	}

	public String getFf1t2() {
		return ff1t2;
	}

	public void setFf1t2(String ff1t2) {
		this.ff1t2 = ff1t2;
	}

	public String getFf1t3() {
		return ff1t3;
	}

	public void setFf1t3(String ff1t3) {
		this.ff1t3 = ff1t3;
	}

	public String getFf1t4() {
		return ff1t4;
	}

	public void setFf1t4(String ff1t4) {
		this.ff1t4 = ff1t4;
	}

	public String getFf1t5() {
		return ff1t5;
	}

	public void setFf1t5(String ff1t5) {
		this.ff1t5 = ff1t5;
	}

	public String getFf1t6() {
		return ff1t6;
	}

	public void setFf1t6(String ff1t6) {
		this.ff1t6 = ff1t6;
	}

	public String getFf1t7() {
		return ff1t7;
	}

	public void setFf1t7(String ff1t7) {
		this.ff1t7 = ff1t7;
	}

	public String getFf1t8() {
		return ff1t8;
	}

	public void setFf1t8(String ff1t8) {
		this.ff1t8 = ff1t8;
	}

	public String getFf1t9() {
		return ff1t9;
	}

	public void setFf1t9(String ff1t9) {
		this.ff1t9 = ff1t9;
	}

	public String getFf1t10() {
		return ff1t10;
	}

	public void setFf1t10(String ff1t10) {
		this.ff1t10 = ff1t10;
	}

	public String getFf1t11() {
		return ff1t11;
	}

	public void setFf1t11(String ff1t11) {
		this.ff1t11 = ff1t11;
	}

	public String getFf1t12() {
		return ff1t12;
	}

	public void setFf1t12(String ff1t12) {
		this.ff1t12 = ff1t12;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(ff1t1, ff1t10, ff1t11, ff1t12, ff1t2, ff1t3, ff1t4, ff1t5, ff1t6, ff1t7, ff1t8, ff1t9,
				makerdate, makerid, teaching_id, workstatus);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TeachingActivities_WB other = (TeachingActivities_WB) obj;
		return Objects.equals(ff1t1, other.ff1t1) && Objects.equals(ff1t10, other.ff1t10)
				&& Objects.equals(ff1t11, other.ff1t11) && Objects.equals(ff1t12, other.ff1t12)
				&& Objects.equals(ff1t2, other.ff1t2) && Objects.equals(ff1t3, other.ff1t3)
				&& Objects.equals(ff1t4, other.ff1t4) && Objects.equals(ff1t5, other.ff1t5)
				&& Objects.equals(ff1t6, other.ff1t6) && Objects.equals(ff1t7, other.ff1t7)
				&& Objects.equals(ff1t8, other.ff1t8) && Objects.equals(ff1t9, other.ff1t9)
				&& Objects.equals(makerdate, other.makerdate) && Objects.equals(makerid, other.makerid)
				&& teaching_id == other.teaching_id && Objects.equals(workstatus, other.workstatus);
	}
	  


	
	  
}


