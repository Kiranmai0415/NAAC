package com.adiverse.erp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "qia_indicator_fileupload")
public class QIAIndicator_FileUpload 
{	
	
private CriteriaPrimaryKey criteriaId;
	
    @Id
    @Column(name="unique_key1")
	private String uniqueKey1;
	 
	@Column(name = "qia_file_name")
	private String qiaFileName;
	
	@Column(name = "qia_file_path")
	private String qiaFilePath;
	
	@Column(name = "qia_file_type")
	private String qiaFileType;

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

	public String getQiaFileName() {
		if (qiaFileName!=null) {
			return qiaFileName;
		}
		else {
			return "";
		}
		
	}

	public void setQiaFileName(String qiaFileName) {
		this.qiaFileName = qiaFileName;
	}

	public String getQiaFilePath() {
		if (qiaFilePath!=null) {
			return qiaFilePath;
		}
		else {
			return "";
		}
		
	}

	public void setQiaFilePath(String qiaFilePath) {
		this.qiaFilePath = qiaFilePath;
	}

	public String getQiaFileType() {
		if (qiaFileType!=null) {
			return qiaFileType;
		}
		else {
			return "";
		}
		
	}

	public void setQiaFileType(String qiaFileType) {
		this.qiaFileType = qiaFileType;
	}

	
	
}
