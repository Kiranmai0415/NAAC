package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "revenue_corpo_train_fileupolad")
public class RevenueCorporateTrainingFileUpload implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	 private CriteriaPrimaryKey criteriaId;
	
	
	@Id
    @Column(name="unique_key1")
	private String uniqueKey1;
	
	@Column(name = "revenue_corpo_train_file_name")
	private String revenueCorpoTrainingFileName;
	
	@Column(name = "revenue_corpo_train_file_path")
	private String revenueCorpoTrainingFilePath;
	
	@Column(name = "revenue_corpo_train_file_type")
	private String revenueCorpoTrainingFileType;

	public CriteriaPrimaryKey getCriteriaId() {
		return criteriaId;
	}

	public void setCriteriaId(CriteriaPrimaryKey criteriaId) {
		this.criteriaId = criteriaId;
	}

	public String getUniqueKey1() {
		return uniqueKey1;
	}

	public void setUniqueKey1(String uniqueKey1) {
		this.uniqueKey1 = uniqueKey1;
	}

	public String getRevenueCorpoTrainingFileName() {
		if (revenueCorpoTrainingFileName!=null) {
			return revenueCorpoTrainingFileName;
		}
		else {
			return "";
		}
		
	}

	public void setRevenueCorpoTrainingFileName(String revenueCorpoTrainingFileName) {
		this.revenueCorpoTrainingFileName = revenueCorpoTrainingFileName;
	}

	public String getRevenueCorpoTrainingFilePath() {
		if (revenueCorpoTrainingFilePath!=null) {
			return revenueCorpoTrainingFilePath;
		}
		else {
			return "";
		}
	}

	public void setRevenueCorpoTrainingFilePath(String revenueCorpoTrainingFilePath) {
		this.revenueCorpoTrainingFilePath = revenueCorpoTrainingFilePath;
	}

	public String getRevenueCorpoTrainingFileType() {
		if (revenueCorpoTrainingFileType!=null) {
			return revenueCorpoTrainingFileType;
		}
		else {
			return "";
		}
		
	}

	public void setRevenueCorpoTrainingFileType(String revenueCorpoTrainingFileType) {
		this.revenueCorpoTrainingFileType = revenueCorpoTrainingFileType;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(criteriaId, revenueCorpoTrainingFileName, revenueCorpoTrainingFilePath,
				revenueCorpoTrainingFileType, uniqueKey1);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RevenueCorporateTrainingFileUpload other = (RevenueCorporateTrainingFileUpload) obj;
		return Objects.equals(criteriaId, other.criteriaId)
				&& Objects.equals(revenueCorpoTrainingFileName, other.revenueCorpoTrainingFileName)
				&& Objects.equals(revenueCorpoTrainingFilePath, other.revenueCorpoTrainingFilePath)
				&& Objects.equals(revenueCorpoTrainingFileType, other.revenueCorpoTrainingFileType)
				&& Objects.equals(uniqueKey1, other.uniqueKey1);
	}

	
    
}
