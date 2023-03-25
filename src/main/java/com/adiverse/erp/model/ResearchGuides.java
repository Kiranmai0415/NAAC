package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "research_guides")
public class ResearchGuides implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private CriteriaPrimaryKey criteriaId;

	
	@Id
    @Column(name="unique_key1")
	private long uniqueKey1;
	
	@Column(name = "nameof_fulltime_teacher")
	private String inputrgt1;
	
	@Column(name = "dept")
	private String inputrgt2;
	
	@Column(name = "schools_name")
	private String inputrgt3;
	
	@Column(name = "qualif_yearof_obtaining")
	private String inputrgt4;
    
	@Column(name = "whether_recog_asresearch_guidefor")
	private String inputrgt5;
	
	@Column(name = "yrof_recog_as_researchguide")
	private String inputrgt6;
	
	@Column(name = "isteacher_stillserving_institute")
	private String inputrgt7;
	
	@Column(name = "nameof_research_scholar")
	private String inputrgt8;
	
	@Column(name = "yrof_regist_ofscholar")
	private String inputrgt9;
	
	@Column(name = "guide_allot_letterlink")
	private String inputrgt10;

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

	public String getInputrgt1() {
		if (inputrgt1!=null) {
			return inputrgt1;
		}
		else {
			return "";
		}
		
	}

	public void setInputrgt1(String inputrgt1) {
		this.inputrgt1 = inputrgt1;
	}

	public String getInputrgt2() {
		if (inputrgt2!=null) {
			return inputrgt2;
		}
		else {
			return "";
		}
	}

	public void setInputrgt2(String inputrgt2) {
		this.inputrgt2 = inputrgt2;
	}

	public String getInputrgt3() {
		if (inputrgt3!=null) {
			return inputrgt3;
		}
		else {
			return "";
		}
	}

	public void setInputrgt3(String inputrgt3) {
		this.inputrgt3 = inputrgt3;
	}

	public String getInputrgt4() {
		if (inputrgt4!=null) {
			return inputrgt4;
		}
		else {
			return "";
		}
	}

	public void setInputrgt4(String inputrgt4) {
		this.inputrgt4 = inputrgt4;
	}

	public String getInputrgt5() {
		if (inputrgt5!=null) {
			return inputrgt5;
		}
		else {
			return "";
		}
	}

	public void setInputrgt5(String inputrgt5) {
		this.inputrgt5 = inputrgt5;
	}

	public String getInputrgt6() {
		if (inputrgt6!=null) {
			return inputrgt6;
		}
		else {
			return "";
		}
	}

	public void setInputrgt6(String inputrgt6) {
		this.inputrgt6 = inputrgt6;
	}

	public String getInputrgt7() {
		if (inputrgt7!=null) {
			return inputrgt7;
		}
		else {
			return "";
		}
	}

	public void setInputrgt7(String inputrgt7) {
		this.inputrgt7 = inputrgt7;
	}

	public String getInputrgt8() {
		if (inputrgt8!=null) {
			return inputrgt8;
		}
		else {
			return "";
		}
	}

	public void setInputrgt8(String inputrgt8) {
		this.inputrgt8 = inputrgt8;
	}

	public String getInputrgt9() {
		if (inputrgt9!=null) {
			return inputrgt9;
		}
		else {
			return "";
		}
	}

	public void setInputrgt9(String inputrgt9) {
		this.inputrgt9 = inputrgt9;
	}

	public String getInputrgt10() {
		if (inputrgt10!=null) {
			return inputrgt10;
		}
		else {
			return "";
		}
	}

	public void setInputrgt10(String inputrgt10) {
		this.inputrgt10 = inputrgt10;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(criteriaId, inputrgt1, inputrgt10, inputrgt2, inputrgt3, inputrgt4, inputrgt5, inputrgt6,
				inputrgt7, inputrgt8, inputrgt9, uniqueKey1);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ResearchGuides other = (ResearchGuides) obj;
		return Objects.equals(criteriaId, other.criteriaId) && Objects.equals(inputrgt1, other.inputrgt1)
				&& Objects.equals(inputrgt10, other.inputrgt10) && Objects.equals(inputrgt2, other.inputrgt2)
				&& Objects.equals(inputrgt3, other.inputrgt3) && Objects.equals(inputrgt4, other.inputrgt4)
				&& Objects.equals(inputrgt5, other.inputrgt5) && Objects.equals(inputrgt6, other.inputrgt6)
				&& Objects.equals(inputrgt7, other.inputrgt7) && Objects.equals(inputrgt8, other.inputrgt8)
				&& Objects.equals(inputrgt9, other.inputrgt9) && uniqueKey1 == other.uniqueKey1;
	}

	
	
	
}
