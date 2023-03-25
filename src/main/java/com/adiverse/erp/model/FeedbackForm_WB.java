package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="feedbackFormwb")
public class FeedbackForm_WB implements Serializable
{
	private static final long serialVersionUID = 6253778019670213928L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)

	private long feedback_id;
	
	  @Column(name="nameoftheFaculty_feedback")
	  private String ff1t1;
	  
	  @Column(name="feedback_department")
	  private String ff1t2;
	  
	  @Column(name="feedback_report")
	  private String ff1t3;
	  
	  @Column(name="feedbackClass") 
	  private String ff1t4;
	  
	  @Column(name="feedbackSubject")
	  private String ff1t5;
	  
	  @Column(name="feedbackPerformance")
	  private String ff1t6;
	
	  @Column(name="work_Status")
	   private String workstatus;
		  
	  @Column(name="maker_Id")
	   private String makerid;
	 
	  @Column(name="maker_Date")
	   private String makerdate;
	  
	  
	  

	public long getFeedback_id() {
		return feedback_id;
	}

	public void setFeedback_id(long feedback_id) {
		this.feedback_id = feedback_id;
	}

	public String getFf1t1() {
		if(ff1t1 !=null) {
			return ff1t1;
		}else {
			return "";
		}
	}

	public void setFf1t1(String ff1t1) {
		this.ff1t1 = ff1t1;
	}

	public String getFf1t2() {
		if(ff1t2 !=null) {
			return ff1t2;
		}else {
			return "";
		}
	}

	public void setFf1t2(String ff1t2) {
		this.ff1t2 = ff1t2;
	}

	public String getFf1t3() {
		if(ff1t3 !=null) {
			return ff1t3;
		}else {
			return "";
		}
	}

	public void setFf1t3(String ff1t3) {
		this.ff1t3 = ff1t3;
	}

	public String getFf1t4() {
		if(ff1t4 !=null) {
			return ff1t4;
		}else {
			return "";
		}
	}

	public void setFf1t4(String ff1t4) {
		this.ff1t4 = ff1t4;
	}

	public String getFf1t5() {
		if(ff1t5 !=null) {
			return ff1t5;
		}else {
			return "";
		}
	}

	public void setFf1t5(String ff1t5) {
		this.ff1t5 = ff1t5;
	}

	public String getFf1t6() {
		if(ff1t6 !=null) {
			return ff1t6;
		}else {
			return "";
		}
	}

	public void setFf1t6(String ff1t6) {
		this.ff1t6 = ff1t6;
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

	@Override
	public int hashCode() {
		return Objects.hash(feedback_id, ff1t1, ff1t2, ff1t3, ff1t4, ff1t5, ff1t6, makerdate, makerid, workstatus);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FeedbackForm_WB other = (FeedbackForm_WB) obj;
		return feedback_id == other.feedback_id && Objects.equals(ff1t1, other.ff1t1)
				&& Objects.equals(ff1t2, other.ff1t2) && Objects.equals(ff1t3, other.ff1t3)
				&& Objects.equals(ff1t4, other.ff1t4) && Objects.equals(ff1t5, other.ff1t5)
				&& Objects.equals(ff1t6, other.ff1t6) && Objects.equals(makerdate, other.makerdate)
				&& Objects.equals(makerid, other.makerid) && Objects.equals(workstatus, other.workstatus);
	}

	
	
	
}


