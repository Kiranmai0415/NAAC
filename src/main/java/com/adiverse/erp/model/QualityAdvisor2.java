package com.adiverse.erp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="quality_advisor2")
public class QualityAdvisor2 {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long quality2_id;
	
	@Column(name="quality_w")
	private String qa1t5;
	
	@Column(name="quality_ki")
	private String qa1t6;
	
	@Column(name="quality_criteria")
	private String qa1t7;
	
	@Column(name="quality_advv")
	private String qa1t8;
	
	@Column(name="quality_metricGradescale")
	private String qa1t9;
	
	@Column(name="quality_metricwiseGradepoints")
	private String qa1t10;
	
	@Column(name="quality_Kiwise_weightedGrade")
	private String qa1t11;
	
	@Column(name="quality_Kiwise_gradePoint")
	private String qa1t12;
	
	@Column(name="quality_criteria_W")
	private String qa1t13;
	
	@Column(name="qualit_criteriaWise_gradePoint")
	private String qa1t14;

	public long getQuantitative2_id() {
		return quality2_id;
	}

	public void setQuantitative2_id(long quantitative2_id) {
		this.quality2_id = quantitative2_id;
	}

	public String getQa1t5() {
		if (qa1t5!=null) {
			return qa1t5;
		}
		else {
			return "";
		}
		
	}

	public void setQa1t5(String qa1t5) {
		this.qa1t5 = qa1t5;
	}

	public String getQa1t6() {
		if (qa1t6!=null) {
			return qa1t6;
		}
		else {
			return "";
		}
	}

	public void setQa1t6(String qa1t6) {
		this.qa1t6 = qa1t6;
	}

	public String getQa1t7() {
		if (qa1t7!=null) {
			return qa1t7;
		}
		else {
			return "";
		}
	}

	public void setQa1t7(String qa1t7) {
		this.qa1t7 = qa1t7;
	}

	public String getQa1t8() {
		if (qa1t8!=null) {
			return qa1t8;
		}
		else {
			return "";
		}
	}

	public void setQa1t8(String qa1t8) {
		this.qa1t8 = qa1t8;
	}

	public String getQa1t9() {
		if (qa1t9!=null) {
			return qa1t9;
		}
		else {
			return "";
		}
	}

	public void setQa1t9(String qa1t9) {
		this.qa1t9 = qa1t9;
	}

	public String getQa1t10() {
		if (qa1t10!=null) {
			return qa1t10;
		}
		else {
			return "";
		}
	}

	public void setQa1t10(String qa1t10) {
		this.qa1t10 = qa1t10;
	}

	public String getQa1t11() {
		if (qa1t11!=null) {
			return qa1t11;
		}
		else {
			return "";
		}
	}

	public void setQa1t11(String qa1t11) {
		this.qa1t11 = qa1t11;
	}

	public String getQa1t12() {
		if (qa1t12!=null) {
			return qa1t12;
		}
		else {
			return "";
		}
	}

	public void setQa1t12(String qa1t12) {
		this.qa1t12 = qa1t12;
	}

	public String getQa1t13() {
		if (qa1t13!=null) {
			return qa1t13;
		}
		else {
			return "";
		}
	}

	public void setQa1t13(String qa1t13) {
		this.qa1t13 = qa1t13;
	}

	public String getQa1t14() {
		if (qa1t14!=null) {
			return qa1t14;
		}
		else {
			return "";
		}
	}

	public void setQa1t14(String qa1t14) {
		this.qa1t14 = qa1t14;
	}

	

}
