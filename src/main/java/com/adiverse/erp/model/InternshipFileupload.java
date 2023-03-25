package com.adiverse.erp.model;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;


@Entity
@Table(name = "internshipfileupload")
public class InternshipFileupload {

	
	  @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY) 
	  private long internship_fileid;
	 

	@Column(name = "internship_fileName")
	private String internship_fileName;
	
	@Column(name = "internship_filePath")
	private String internship_filePath;
	
	@Column(name = "internship_fileType")
	private String internship_fileType;

	public long getInternship_fileid() {
		return internship_fileid;
	}

	public void setInternship_fileid(long internship_fileid) {
		this.internship_fileid = internship_fileid;
	}

	public String getInternship_fileName() {
		return internship_fileName;
	}

	public void setInternship_fileName(String internship_fileName) {
		this.internship_fileName = internship_fileName;
	}

	public String getInternship_filePath() {
		return internship_filePath;
	}

	public void setInternship_filePath(String internship_filePath) {
		this.internship_filePath = internship_filePath;
	}

	public String getInternship_fileType() {
		return internship_fileType;
	}

	public void setInternship_fileType(String internship_fileType) {
		this.internship_fileType = internship_fileType;
	}

	
}
