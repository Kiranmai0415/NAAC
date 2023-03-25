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
@Table(name="eventdetailsmb")
public class EventDetails_mb {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long event_id;
	
	@Column(name = "eventEmail")
	private String ff4t1;
	@Column(name = "eventEmployeeid")
	private String ff4t2;
	@Column(name = "eventnameoftheCoordinator")
	private String ff4t3;
	@Column(name = "eventDepartment")
	private String ff4t4;
	@Column(name = "nameoftheEvent")
	private String ff4t5;
	@Column(name = "eventDates")
	private String ff4t6;
	@Column(name = "event_noofParticipants")
	private String ff4t7;
	@Column(name = "event_noofresourcePersons")
	private String  ff4t8;
	@Column(name = "event_modeofConductofEvent")
	private String ff4t9;

	@Column(name = "eventRemarks")
	private String ff4t10;
	
	
	  
	  @Column(name="work_Status")
	   private String workstatus;
		  
	  @Column(name="checker_Id")
	   private String checkerid;
	 
	  @Column(name="checker_Date")
	   private String checkerdate;
	  
	  
	
	
	  @OneToMany(targetEntity = EventFileupload.class,cascade=CascadeType.ALL)
	  @JoinColumn(name="event_foreignkey",referencedColumnName="event_id")
	  private List<EventFileupload> eventFileupload;
	  

	public List<EventFileupload> getEventFileupload() {
		return eventFileupload;
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

	public void setEventFileupload(List<EventFileupload> eventFileupload) {
		this.eventFileupload = eventFileupload;
	}

	public long getEvent_id() {
		return event_id;
	}

	public void setEvent_id(long event_id) {
		this.event_id = event_id;
	}

	public String getFf4t1() {
		if(ff4t1 !=null) {
		return ff4t1;
	}else {
		return "";
	}
	}

	public void setFf4t1(String ff4t1) {
		this.ff4t1 = ff4t1;
	}

	public String getFf4t2() {
		if(ff4t2 !=null) {
			return ff4t2;
		}else {
			return "";
		}
	}

	public void setFf4t2(String ff4t2) {
		this.ff4t2 = ff4t2;
	}

	public String getFf4t3() {
		if(ff4t3 !=null) {
			return ff4t3;
		}else {
			return "";
		}
	}

	public void setFf4t3(String ff4t3) {
		this.ff4t3 = ff4t3;
	}

	public String getFf4t4() {
		if(ff4t4 !=null) {
			return ff4t4;
		}else {
			return "";
		}
	}

	public void setFf4t4(String ff4t4) {
		this.ff4t4 = ff4t4;
	}

	public String getFf4t5() {
		if(ff4t5 !=null) {
			return ff4t5;
		}else {
			return "";
		}
	}

	public void setFf4t5(String ff4t5) {
		this.ff4t5 = ff4t5;
	}

	public String getFf4t6() {
		if(ff4t6!=null) {
			return ff4t6;
		}else {
			return "";
		}
	}

	public void setFf4t6(String ff4t6) {
		this.ff4t6 = ff4t6;
	}

	public String getFf4t7() {
		if(ff4t7 !=null) {
			return ff4t7;
		}else {
			return "";
		}
	}

	public void setFf4t7(String ff4t7) {
		this.ff4t7 = ff4t7;
	}

	public String getFf4t8() {
		if(ff4t8 !=null) {
			return ff4t8;
		}else {
			return "";
		}
	}

	public void setFf4t8(String ff4t8) {
		this.ff4t8 = ff4t8;
	}

	public String getFf4t9() {
		if(ff4t9 !=null) {
			return ff4t9;
		}else {
			return "";
		}
	}

	public void setFf4t9(String ff4t9) {
		this.ff4t9 = ff4t9;
	}

	public String getFf4t10() {
		if(ff4t10 !=null) {
			return ff4t10;
		}else {
			return "";
		}
	}

	public void setFf4t10(String ff4t10) {
		this.ff4t10 = ff4t10;
	}
	
	
	
}


