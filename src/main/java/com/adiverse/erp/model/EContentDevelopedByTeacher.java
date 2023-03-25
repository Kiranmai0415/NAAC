package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "econtent_devel_byteach")
public class EContentDevelopedByTeacher implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	 private CriteriaPrimaryKey criteriaId;

	
	@Id
    @Column(name="unique_key1")
	private long uniqueKey1;
	
	@Column(name = "nameof_teacher")
	private String inputect1;
	
	@Column(name = "dept")
	private String inputect2;
	
	@Column(name = "schools_name")
	private String inputect3;
	
	@Column(name = "nameof_module_devel")
	private String inputect4;
	
	@Column(name = "platf_onwhich_module_devel")
	private String inputect5;
	
	@Column(name = "dateof_launching_econtent")
	private String inputect6;
	
	@Column(name = "linkto_doc_facility_avail_institute")
	private String inputect7;
	
	@Column(name = "listof_econtent_devel_facil_avail")
	private String inputect8;

	@Column(name = "linkto_vid_ofmedia_center")
	private String inputect9;

	public CriteriaPrimaryKey getCriteriaId() {
		return criteriaId;
	}

	public void setCriteriaId(CriteriaPrimaryKey criteriaId) {
		this.criteriaId = criteriaId;
	}

	public long getUniqueKey1() {
		return uniqueKey1;
	}

	public void setUniqueKey1(long uniqueKey1) {
		this.uniqueKey1 = uniqueKey1;
	}

	public String getInputect1() {
		if(inputect1 !=null) {
		return inputect1;
	}else {
		return "";
	}
	}

	public void setInputect1(String inputect1) {
		this.inputect1 = inputect1;
	}

	public String getInputect2() {
		
		if(inputect2 !=null) {
			return inputect2;
		}else {
			return "";
		}
	}

	public void setInputect2(String inputect2) {
		this.inputect2 = inputect2;
	}

	public String getInputect3() {
		if(inputect3 !=null) {
			return inputect3;
		}else {
			return "";
		}
	}

	public void setInputect3(String inputect3) {
		this.inputect3 = inputect3;
	}

	public String getInputect4() {
		if(inputect4 !=null) {
			return inputect4;
		}else {
			return "";
		}
	}

	public void setInputect4(String inputect4) {
		this.inputect4 = inputect4;
	}

	public String getInputect5() {
		if(inputect5 !=null) {
			return inputect5;
		}else {
			return "";
		}
	}

	public void setInputect5(String inputect5) {
		this.inputect5 = inputect5;
	}

	public String getInputect6() {
		if(inputect6 !=null) {
			return inputect6;
		}else {
			return "";
		}
	}

	public void setInputect6(String inputect6) {
		this.inputect6 = inputect6;
	}

	public String getInputect7() {
		if(inputect7 !=null) {
			return inputect7;
		}else {
			return "";
		}
	}

	public void setInputect7(String inputect7) {
		this.inputect7 = inputect7;
	}

	public String getInputect8() {
		if(inputect8 !=null) {
			return inputect8;
		}else {
			return "";
		}
	}

	public void setInputect8(String inputect8) {
		this.inputect8 = inputect8;
	}

	public String getInputect9() {
		if(inputect9 !=null) {
			return inputect9;
		}else {
			return "";
		}
	}

	public void setInputect9(String inputect9) {
		this.inputect9 = inputect9;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(criteriaId, inputect1, inputect2, inputect3, inputect4, inputect5, inputect6, inputect7,
				inputect8, inputect9, uniqueKey1);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EContentDevelopedByTeacher other = (EContentDevelopedByTeacher) obj;
		return Objects.equals(criteriaId, other.criteriaId) && Objects.equals(inputect1, other.inputect1)
				&& Objects.equals(inputect2, other.inputect2) && Objects.equals(inputect3, other.inputect3)
				&& Objects.equals(inputect4, other.inputect4) && Objects.equals(inputect5, other.inputect5)
				&& Objects.equals(inputect6, other.inputect6) && Objects.equals(inputect7, other.inputect7)
				&& Objects.equals(inputect8, other.inputect8) && Objects.equals(inputect9, other.inputect9)
				&& uniqueKey1 == other.uniqueKey1;
	}

	
	
	
}
