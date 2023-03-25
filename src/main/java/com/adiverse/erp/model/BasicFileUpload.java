package com.adiverse.erp.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;


@Entity
@Table(name = "basic_fileupload")
public class BasicFileUpload implements Serializable
{

	private static final long serialVersionUID = 4684412447270038160L;


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Long basic_fileId ;
	 

	@Column(name = "basic_fileName")
	private String evaluative_fileName;
	
	@Column(name = "basic_filePath")
	private String evaluative_filePath;
	
	@Column(name = "basic_fileType")
	private String evaluate_fileType;

	

	

	

	public Long getBasic_fileId() {
		return basic_fileId;
	}







	public void setBasic_fileId(Long basic_fileId) {
		this.basic_fileId = basic_fileId;
	}







	public String getEvaluative_fileName() {
		return evaluative_fileName;
	}







	public void setEvaluative_fileName(String evaluative_fileName) {
		this.evaluative_fileName = evaluative_fileName;
	}







	public String getEvaluative_filePath() {
		return evaluative_filePath;
	}







	public void setEvaluative_filePath(String evaluative_filePath) {
		this.evaluative_filePath = evaluative_filePath;
	}







	public String getEvaluate_fileType() {
		return evaluate_fileType;
	}







	public void setEvaluate_fileType(String evaluate_fileType) {
		this.evaluate_fileType = evaluate_fileType;
	}







	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

	
	
}
