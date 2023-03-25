package com.adiverse.erp.model;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;


@Entity
@Table(name = "admission_fileupload")
public class AdmissionFileupload {

	
	  @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY) 
	  private long admin_fileid;
	 

	@Column(name = "admin_fileName")
	private String admin_fileName;
	
	@Column(name = "admin_filePath")
	private String admin_filePath;
	
	@Column(name = "admin_fileType")
	private String admin_fileType;

	public long getAdmin_fileid() {
		return admin_fileid;
	}

	public void setAdmin_fileid(long admin_fileid) {
		this.admin_fileid = admin_fileid;
	}

	public String getAdmin_fileName() {
		return admin_fileName;
	}

	public void setAdmin_fileName(String admin_fileName) {
		this.admin_fileName = admin_fileName;
	}

	public String getAdmin_filePath() {
		return admin_filePath;
	}

	public void setAdmin_filePath(String admin_filePath) {
		this.admin_filePath = admin_filePath;
	}

	public String getAdmin_fileType() {
		return admin_fileType;
	}

	public void setAdmin_fileType(String admin_fileType) {
		this.admin_fileType = admin_fileType;
	}

	
}
