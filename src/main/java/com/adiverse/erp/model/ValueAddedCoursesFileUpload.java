package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "value_added_courses_fileupload")
public class ValueAddedCoursesFileUpload implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	 private CriteriaPrimaryKey criteriaId;
	
	
	@Id
    @Column(name="unique_key1")
	private String uniqueKey1;
	
	@Column(name = "vadd_courses_file_name")
	private String valueAddedCoursesFileName;
	
	@Column(name = "vadd_courses_file_path")
	private String valueAddedCoursesFilePath;
	
	@Column(name = "vadd_courses_file_type")
	private String valueAddedCoursesFileType;

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

	public String getValueAddedCoursesFileName() {
		return valueAddedCoursesFileName;
	}

	public void setValueAddedCoursesFileName(String valueAddedCoursesFileName) {
		this.valueAddedCoursesFileName = valueAddedCoursesFileName;
	}

	public String getValueAddedCoursesFilePath() {
		return valueAddedCoursesFilePath;
	}

	public void setValueAddedCoursesFilePath(String valueAddedCoursesFilePath) {
		this.valueAddedCoursesFilePath = valueAddedCoursesFilePath;
	}

	public String getValueAddedCoursesFileType() {
		return valueAddedCoursesFileType;
	}

	public void setValueAddedCoursesFileType(String valueAddedCoursesFileType) {
		this.valueAddedCoursesFileType = valueAddedCoursesFileType;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(criteriaId, uniqueKey1, valueAddedCoursesFileName, valueAddedCoursesFilePath,
				valueAddedCoursesFileType);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ValueAddedCoursesFileUpload other = (ValueAddedCoursesFileUpload) obj;
		return Objects.equals(criteriaId, other.criteriaId) && Objects.equals(uniqueKey1, other.uniqueKey1)
				&& Objects.equals(valueAddedCoursesFileName, other.valueAddedCoursesFileName)
				&& Objects.equals(valueAddedCoursesFilePath, other.valueAddedCoursesFilePath)
				&& Objects.equals(valueAddedCoursesFileType, other.valueAddedCoursesFileType);
	}

	
	

}
