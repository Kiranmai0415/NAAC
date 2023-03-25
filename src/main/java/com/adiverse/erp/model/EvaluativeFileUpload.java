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
@Table(name = "evaluative_fileupload")
public class EvaluativeFileUpload implements Serializable
{

	private static final long serialVersionUID = 4684412447270038160L;

private CriteriaPrimaryKey criteriaId;
	
    @Id
    @Column(name="unique_key1")
	private String uniqueKey1;

	 

	@Column(name = "evaluative_fileName")
	private String evaluative_fileName;
	
	@Column(name = "evaluative_filePath")
	private String evaluative_filePath;
	
	@Column(name = "evaluate_fileType")
	private String evaluate_fileType;

	
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

	@Override
	public int hashCode() {
		return Objects.hash(criteriaId, evaluate_fileType, evaluative_fileName, evaluative_filePath, uniqueKey1);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EvaluativeFileUpload other = (EvaluativeFileUpload) obj;
		return Objects.equals(criteriaId, other.criteriaId)
				&& Objects.equals(evaluate_fileType, other.evaluate_fileType)
				&& Objects.equals(evaluative_fileName, other.evaluative_fileName)
				&& Objects.equals(evaluative_filePath, other.evaluative_filePath)
				&& Objects.equals(uniqueKey1, other.uniqueKey1);
	}
	
	

	
	
}
