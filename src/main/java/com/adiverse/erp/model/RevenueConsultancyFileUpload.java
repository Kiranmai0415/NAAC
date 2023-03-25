package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "revenue_consultancy_fileupload")
public class RevenueConsultancyFileUpload implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	 private CriteriaPrimaryKey criteriaId;
	
	@Id
    @Column(name="unique_key1")
	private String uniqueKey1;
	
	@Column(name = "revenue_consultancy_file_name")
	private String revenueConsultancyFileName;
	
	@Column(name = "revenue_consultancy_file_path")
	private String revenueConsultancyFilePath;
	
	@Column(name = "revenue_consultancy_file_type")
	private String revenueConsultancyFileType;

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

	public String getRevenueConsultancyFileName() {
		if (revenueConsultancyFileName!=null) {
			return revenueConsultancyFileName;
		}
		else {
			return "";
		}
		
	}

	public void setRevenueConsultancyFileName(String revenueConsultancyFileName) {
		this.revenueConsultancyFileName = revenueConsultancyFileName;
	}

	public String getRevenueConsultancyFilePath() {
		if (revenueConsultancyFilePath!=null) {
			return revenueConsultancyFilePath;
		}
		else {
			return "";
		}
	
	}

	public void setRevenueConsultancyFilePath(String revenueConsultancyFilePath) {
		this.revenueConsultancyFilePath = revenueConsultancyFilePath;
	}

	public String getRevenueConsultancyFileType() {
		if (revenueConsultancyFileType!=null) {
			return revenueConsultancyFileType;
		}
		else {
			return "";
		}
	}

	public void setRevenueConsultancyFileType(String revenueConsultancyFileType) {
		this.revenueConsultancyFileType = revenueConsultancyFileType;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(criteriaId, revenueConsultancyFileName, revenueConsultancyFilePath,
				revenueConsultancyFileType, uniqueKey1);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RevenueConsultancyFileUpload other = (RevenueConsultancyFileUpload) obj;
		return Objects.equals(criteriaId, other.criteriaId)
				&& Objects.equals(revenueConsultancyFileName, other.revenueConsultancyFileName)
				&& Objects.equals(revenueConsultancyFilePath, other.revenueConsultancyFilePath)
				&& Objects.equals(revenueConsultancyFileType, other.revenueConsultancyFileType)
				&& Objects.equals(uniqueKey1, other.uniqueKey1);
	}

	

}
