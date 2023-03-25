package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
//import javax.persistence.GenerationType;
//import javax.persistence.OneToOne;
//import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="quality_advisor")
public class QualityAdvisor implements Serializable
{

	private static final long serialVersionUID = -7236424143156288812L;


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long quality_id;
	
	
	@Column(name="quality_sno")
	private String qa1t1;
	
	@Column(name="quality_metricno")
	private String qa1t2;
	
	@Column(name="quality_qi_qn")
	private String qa1t3;
	
	@Column(name="quality_description")
	private String qa1t4;
//----------------------------------------------------------------------------------------	

	 @OneToMany(targetEntity = QualityAdvisor2.class,cascade=CascadeType.ALL)
	  @JoinColumn(name="Quality_foreignkey",referencedColumnName="quality_id")
	  private List<QualityAdvisor2> qualityAdvisor2;
	 
	public List<QualityAdvisor2> getQualityAdvisor2() {
		return qualityAdvisor2;
	}

	public void setQualityAdvisor2(List<QualityAdvisor2> qualityAdvisor2) {
		this.qualityAdvisor2 = qualityAdvisor2;
	}

	public long getQuality_id() {
		return quality_id;
	}

	public void setQuality_id(long quality_id) {
		this.quality_id = quality_id;
	}

	public String getQa1t1() {
		if (qa1t1!=null) {
			return qa1t1;
		}
		else {
			return "";
		}
		
	}

	public void setQa1t1(String qa1t1) {
		this.qa1t1 = qa1t1;
	}

	public String getQa1t2() {
		if (qa1t2!=null) {
			return qa1t2;
		}
		else {
			return "";
		}
	}

	public void setQa1t2(String qa1t2) {
		this.qa1t2 = qa1t2;
	}

	public String getQa1t3() {
		if (qa1t3!=null) {
			return qa1t3;
		}
		else {
			return "";
		}
	}

	public void setQa1t3(String qa1t3) {
		this.qa1t3 = qa1t3;
	}

	public String getQa1t4() {
		if (qa1t4!=null) {
			return qa1t4;
		}
		else {
			return "";
		}
	}

	public void setQa1t4(String qa1t4) {
		this.qa1t4 = qa1t4;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	}