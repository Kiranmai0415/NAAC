package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "financial_supto_teach_fileupload")
public class FinancialSupportToTeachersFileUpload implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private CriteriaPrimaryKey criteriaId;
	
	@Id
    @Column(name="unique_key1")
	private String uniqueKey1;
	
	@Column(name = "finance_sup_teach_file_name")
	private String financeSupTeachFileName;
	
	@Column(name = "finance_sup_teach_file_path")
	private String financeSupTeachFilePath;
	
	@Column(name = "finance_sup_teach_file_type")
	private String financeSupTeachFileType;

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

	public String getFinanceSupTeachFileName() {
		return financeSupTeachFileName;
	}

	public void setFinanceSupTeachFileName(String financeSupTeachFileName) {
		this.financeSupTeachFileName = financeSupTeachFileName;
	}

	public String getFinanceSupTeachFilePath() {
		return financeSupTeachFilePath;
	}

	public void setFinanceSupTeachFilePath(String financeSupTeachFilePath) {
		this.financeSupTeachFilePath = financeSupTeachFilePath;
	}

	public String getFinanceSupTeachFileType() {
		return financeSupTeachFileType;
	}

	public void setFinanceSupTeachFileType(String financeSupTeachFileType) {
		this.financeSupTeachFileType = financeSupTeachFileType;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(criteriaId, financeSupTeachFileName, financeSupTeachFilePath, financeSupTeachFileType,
				uniqueKey1);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FinancialSupportToTeachersFileUpload other = (FinancialSupportToTeachersFileUpload) obj;
		return Objects.equals(criteriaId, other.criteriaId)
				&& Objects.equals(financeSupTeachFileName, other.financeSupTeachFileName)
				&& Objects.equals(financeSupTeachFilePath, other.financeSupTeachFilePath)
				&& Objects.equals(financeSupTeachFileType, other.financeSupTeachFileType)
				&& Objects.equals(uniqueKey1, other.uniqueKey1);
	}

	

}
