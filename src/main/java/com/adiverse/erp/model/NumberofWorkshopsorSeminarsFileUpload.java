package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "no_of_workshops_seminors_file_upload")
public class NumberofWorkshopsorSeminarsFileUpload implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private CriteriaPrimaryKey criteriaId;
	
	@Id
    @Column(name="unique_key1")
	private String uniqueKey1;
	
	@Column(name = "no_of_workshops_seminors_file_name")
	private String noofWorkshopsSeminorsFileName;
	
	@Column(name = "no_of_workshops_seminors_file_path")
	private String noofWorkshopsSeminorsFilePath;
	
	@Column(name = "no_of_workshops_seminors_file_type")
	private String noofWorkshopsSeminorsFileType;

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

	public String getNoofWorkshopsSeminorsFileName() {
		if (noofWorkshopsSeminorsFileName!=null) {
			return noofWorkshopsSeminorsFileName;
		}
else {
	return "";
}
	}

	public void setNoofWorkshopsSeminorsFileName(String noofWorkshopsSeminorsFileName) {
		this.noofWorkshopsSeminorsFileName = noofWorkshopsSeminorsFileName;
	}

	public String getNoofWorkshopsSeminorsFilePath() {
		if (noofWorkshopsSeminorsFilePath!=null) {
			return noofWorkshopsSeminorsFilePath;
		}
		else {
			return "";
		}
		
	}

	public void setNoofWorkshopsSeminorsFilePath(String noofWorkshopsSeminorsFilePath) {
		this.noofWorkshopsSeminorsFilePath = noofWorkshopsSeminorsFilePath;
	}

	public String getNoofWorkshopsSeminorsFileType() {
		if (noofWorkshopsSeminorsFileType!=null) {
			return noofWorkshopsSeminorsFileType;
		}
		else {
			return "";
		}
		
	}

	public void setNoofWorkshopsSeminorsFileType(String noofWorkshopsSeminorsFileType) {
		this.noofWorkshopsSeminorsFileType = noofWorkshopsSeminorsFileType;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(criteriaId, noofWorkshopsSeminorsFileName, noofWorkshopsSeminorsFilePath,
				noofWorkshopsSeminorsFileType, uniqueKey1);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NumberofWorkshopsorSeminarsFileUpload other = (NumberofWorkshopsorSeminarsFileUpload) obj;
		return Objects.equals(criteriaId, other.criteriaId)
				&& Objects.equals(noofWorkshopsSeminorsFileName, other.noofWorkshopsSeminorsFileName)
				&& Objects.equals(noofWorkshopsSeminorsFilePath, other.noofWorkshopsSeminorsFilePath)
				&& Objects.equals(noofWorkshopsSeminorsFileType, other.noofWorkshopsSeminorsFileType)
				&& Objects.equals(uniqueKey1, other.uniqueKey1);
	}

	
	

}
