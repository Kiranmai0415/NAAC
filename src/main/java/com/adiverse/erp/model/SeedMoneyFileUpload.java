package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "seed_money_fileupload")
public class SeedMoneyFileUpload implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private CriteriaPrimaryKey criteriaId;
	
	@Id
    @Column(name="unique_key1")
	private String uniqueKey1;
	
	@Column(name = "seed_money_file_name")
	private String seedMoneyFileName;
	
	@Column(name = "seed_money_file_path")
	private String seedMoneyFilePath;
	
	@Column(name = "seed_money_file_type")
	private String seedMoneyFileType;

	public String getUniqueKey1() {
		return uniqueKey1;
	}

	public void setUniqueKey1(String uniqueKey1) {
		this.uniqueKey1 = uniqueKey1;
	}

	public String getSeedMoneyFileName() {
		if (seedMoneyFileName!=null) {
			return seedMoneyFileName;
		}
		else {
			return "";
		}
		
	}

	public void setSeedMoneyFileName(String seedMoneyFileName) {
		this.seedMoneyFileName = seedMoneyFileName;
	}

	public String getSeedMoneyFilePath() {
		if (seedMoneyFilePath!=null) {
			return seedMoneyFilePath;
		}
		else {
			return "";
		}
		
	}

	public void setSeedMoneyFilePath(String seedMoneyFilePath) {
		this.seedMoneyFilePath = seedMoneyFilePath;
	}

	public String getSeedMoneyFileType() {
		if (seedMoneyFileType!=null) {
			return seedMoneyFileType;
		}
		else {
			return "";
		}
		
	}

	public void setSeedMoneyFileType(String seedMoneyFileType) {
		this.seedMoneyFileType = seedMoneyFileType;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

	public CriteriaPrimaryKey getCriteriaId() {
		return criteriaId;
	}

	public void setCriteriaId(CriteriaPrimaryKey criteriaId) {
		this.criteriaId = criteriaId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(criteriaId, seedMoneyFileName, seedMoneyFilePath, seedMoneyFileType, uniqueKey1);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SeedMoneyFileUpload other = (SeedMoneyFileUpload) obj;
		return Objects.equals(criteriaId, other.criteriaId)
				&& Objects.equals(seedMoneyFileName, other.seedMoneyFileName)
				&& Objects.equals(seedMoneyFilePath, other.seedMoneyFilePath)
				&& Objects.equals(seedMoneyFileType, other.seedMoneyFileType)
				&& Objects.equals(uniqueKey1, other.uniqueKey1);
	}

	
}
