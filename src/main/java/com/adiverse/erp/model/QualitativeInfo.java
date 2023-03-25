package com.adiverse.erp.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "qualitative_info")
public class QualitativeInfo implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	public CriteriaPrimaryKey criteriaId;

	@Column(name = "qualitative_comments")
	private String qualitativeComments;

	/*
	 * @OneToMany(cascade = CascadeType.ALL)
	 * 
	 * @JoinColumns({ @JoinColumn(name = "collegeId", referencedColumnName =
	 * "collegeId", nullable = false),
	 * 
	 * @JoinColumn(name = "financialYear", referencedColumnName = "financialYear",
	 * nullable = false),
	 * 
	 * @JoinColumn(name = "typeofInstitution", referencedColumnName =
	 * "typeofInstitution", nullable = false) }) public List<Qualitative>
	 * qualitativeDataList;
	 */

//	@OneToMany(cascade = CascadeType.ALL)
//	@JoinColumns({ @JoinColumn(name = "collegeId", referencedColumnName = "collegeId", nullable = false),
//			@JoinColumn(name = "financialYear", referencedColumnName = "financialYear", nullable = false),
//			@JoinColumn(name = "typeofInstitution", referencedColumnName = "typeofInstitution", nullable = false) })
//	public List<QualitativeCriterionWise> qualitativeCriterionWiseList;

	

	public CriteriaPrimaryKey getCriteriaId() {
		return criteriaId;
	}

	public void setCriteriaId(CriteriaPrimaryKey criteriaId) {
		this.criteriaId = criteriaId;
	}

	public String getQualitativeComments() {
		if (qualitativeComments!=null) {
			return qualitativeComments;
		}
		else {
			return "";
		}
		
	}

	public void setQualitativeComments(String qualitativeComments) {
		this.qualitativeComments = qualitativeComments;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
