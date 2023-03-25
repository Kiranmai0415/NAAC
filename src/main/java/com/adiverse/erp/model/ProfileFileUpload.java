package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "profile_fileupload")
public class ProfileFileUpload implements Serializable {

	


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private CriteriaPrimaryKey criteriaId;

	@Id
	@Column(name = "unique_key1")
	private String uniqueKey1;

	@Column(name = "profile_file_name")
	private String profileFileName;

	@Column(name = "profile_file_path")
	private String profileFilePath;

	@Column(name = "profile_file_type")
	private String profileFileType;

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

	public String getProfileFileName() {
		return profileFileName;
	}

	public void setProfileFileName(String profileFileName) {
		this.profileFileName = profileFileName;
	}

	public String getProfileFilePath() {
		return profileFilePath;
	}

	public void setProfileFilePath(String profileFilePath) {
		this.profileFilePath = profileFilePath;
	}

	public String getProfileFileType() {
		return profileFileType;
	}

	public void setProfileFileType(String profileFileType) {
		this.profileFileType = profileFileType;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(criteriaId, profileFileName, profileFilePath, profileFileType, uniqueKey1);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProfileFileUpload other = (ProfileFileUpload) obj;
		return Objects.equals(criteriaId, other.criteriaId) && Objects.equals(profileFileName, other.profileFileName)
				&& Objects.equals(profileFilePath, other.profileFilePath)
				&& Objects.equals(profileFileType, other.profileFileType)
				&& Objects.equals(uniqueKey1, other.uniqueKey1);
	}

	
	
	
	
	
}
