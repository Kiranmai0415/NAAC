package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;


@Entity
@Table(name = "facultyfileupload")
public class FacultyFileupload implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long documentfileupload_id;

	@Column(name = "teachingstaff_fileName")
	private String teachingstaff_fileName;
	
	@Column(name = "teachingstaff_filePath")
	private String teachingstaff_filePath;
	
	@Column(name = "teachingstaff_fileType")
	private String teachingstaff_fileType;

	public long getDocumentfileupload_id() {
		return documentfileupload_id;
	}

	public void setDocumentfileupload_id(long documentfileupload_id) {
		this.documentfileupload_id = documentfileupload_id;
	}

	public String getTeachingstaff_fileName() {
		return teachingstaff_fileName;
	}

	public void setTeachingstaff_fileName(String teachingstaff_fileName) {
		this.teachingstaff_fileName = teachingstaff_fileName;
	}

	public String getTeachingstaff_filePath() {
		return teachingstaff_filePath;
	}

	public void setTeachingstaff_filePath(String teachingstaff_filePath) {
		this.teachingstaff_filePath = teachingstaff_filePath;
	}

	public String getTeachingstaff_fileType() {
		return teachingstaff_fileType;
	}

	public void setTeachingstaff_fileType(String teachingstaff_fileType) {
		this.teachingstaff_fileType = teachingstaff_fileType;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(documentfileupload_id, teachingstaff_fileName, teachingstaff_filePath,
				teachingstaff_fileType);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FacultyFileupload other = (FacultyFileupload) obj;
		return documentfileupload_id == other.documentfileupload_id
				&& Objects.equals(teachingstaff_fileName, other.teachingstaff_fileName)
				&& Objects.equals(teachingstaff_filePath, other.teachingstaff_filePath)
				&& Objects.equals(teachingstaff_fileType, other.teachingstaff_fileType);
	}


	
	
}

