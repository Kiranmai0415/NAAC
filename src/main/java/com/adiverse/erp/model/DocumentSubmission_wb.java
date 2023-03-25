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
@Table(name="documentsubmission")
public class DocumentSubmission_wb {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long document_id;
	
	@Column(name ="documentEmail")
	private String ff2t1;
	@Column(name = "documentStudent")
	private String ff2t2;
	@Column(name = "studentrollno")
	private String ff2t3;
	@Column(name = "nameofthestudent")
	private String ff2t4;
	@Column(name = "studentDepartment")
	private String ff2t5;
	@Column(name = "documentRemarks")
	private String ff2t6;
	
	@Column(name="work_Status")
	   private String workstatus;
		  
	  @Column(name="maker_Id")
	   private String makerid;
	 
	  @Column(name="maker_Date")
	   private String makerdate;
	  
	
	
	  @OneToMany(targetEntity = FacultyFileupload.class,cascade=CascadeType.ALL)
	  @JoinColumn(name="document_foreignkey",referencedColumnName="document_id")
	  private List<FacultyFileupload> facultyFileupload;
	  
	  
	
	
	public List<FacultyFileupload> getFacultyFileupload() {
		return facultyFileupload;
	}
	public void setFacultyFileupload(List<FacultyFileupload> facultyFileupload) {
		this.facultyFileupload = facultyFileupload;
	}
	public long getDocument_id() {
		return document_id;
	}
	public void setDocument_id(long document_id) {
		this.document_id = document_id;
	}
	public String getFf2t1() {
		if(ff2t1 !=null) {
		return ff2t1;
	}else {
		return "";
	}
	}
	public void setFf2t1(String ff2t1) {
		this.ff2t1 = ff2t1;
	}
	public String getFf2t2() {
		
		if(ff2t2 !=null) {
			return ff2t2;
		}else {
			return "";
		}
	}
	public void setFf2t2(String ff2t2) {
		this.ff2t2 = ff2t2;
	}
	public String getFf2t3() {
		
		if(ff2t3 !=null) {
			return ff2t3;
		}else {
			return "";
		}
	}
	public void setFf2t3(String ff2t3) {
		this.ff2t3 = ff2t3;
	}
	public String getFf2t4() {
		
		if(ff2t4 !=null) {
			return ff2t4;
		}else {
			return "";
		}
	}
	public void setFf2t4(String ff2t4) {
		this.ff2t4 = ff2t4;
	}
	public String getFf2t5() {
		
		if(ff2t5!=null) {
			return ff2t5;
		}else {
			return "";
		}
	}
	public void setFf2t5(String ff2t5) {
		this.ff2t5 = ff2t5;
	}
	public String getFf2t6() {
		if(ff2t6 !=null) {
			return ff2t6;
		}else {
			return "";
		}
		
	}
	public void setFf2t6(String ff2t6) {
		this.ff2t6 = ff2t6;
	}
	@Override
	public int hashCode() {
		return Objects.hash(document_id, facultyFileupload, ff2t1, ff2t2, ff2t3, ff2t4, ff2t5, ff2t6, makerdate,
				makerid, workstatus);
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
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DocumentSubmission_wb other = (DocumentSubmission_wb) obj;
		return document_id == other.document_id && Objects.equals(facultyFileupload, other.facultyFileupload)
				&& Objects.equals(ff2t1, other.ff2t1) && Objects.equals(ff2t2, other.ff2t2)
				&& Objects.equals(ff2t3, other.ff2t3) && Objects.equals(ff2t4, other.ff2t4)
				&& Objects.equals(ff2t5, other.ff2t5) && Objects.equals(ff2t6, other.ff2t6)
				&& Objects.equals(makerdate, other.makerdate) && Objects.equals(makerid, other.makerid)
				&& Objects.equals(workstatus, other.workstatus);
	}
	
	
}

	
	
	
	


