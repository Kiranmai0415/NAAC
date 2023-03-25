package com.adiverse.erp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "studentfileupload")
public class StudentFileupload {

	
	  @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  private long studentFile_id;
	 

	@Column(name = "studentFile_name")
	private String studentFilename;
	
	@Column(name = "studentFile_path")
	private String studentFilepath;
	
	@Column(name = "studentFile_type")
	private String studentFileType;

	public long getStudentFile_id() {
		return studentFile_id;
	}

	public void setStudentFile_id(long studentFile_id) {
		this.studentFile_id = studentFile_id;
	}

	public String getStudentFilename() {
		return studentFilename;
	}

	public void setStudentFilename(String studentFilename) {
		this.studentFilename = studentFilename;
	}

	public String getStudentFilepath() {
		return studentFilepath;
	}

	public void setStudentFilepath(String studentFilepath) {
		this.studentFilepath = studentFilepath;
	}

	public String getStudentFileType() {
		return studentFileType;
	}

	public void setStudentFileType(String studentFileType) {
		this.studentFileType = studentFileType;
	}
	

		
	
}
