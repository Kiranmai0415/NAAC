package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "tracking_details")
public class TrackingDetails implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private CriteriaPrimaryKey criteriaId;
	
	@Id
	@Column(name = "programmer_Id")
	private String programmerId;
	
	@Column(name = "faculty_saved")
	private String facultysaved;
	
	@Column(name = "faculty_modify")
	private String facultymodify;
	
	@Column(name = "dean_status")
	private String deanStatus;
	
	@Column(name = "dean_Comments")
	private String deanComments;
	
	@Column(name = "principal_status")
	private String principalStatus;
	
	@Column(name = "principal_Comments")
	private String principalComments;

	public CriteriaPrimaryKey getCriteriaId() {
		return criteriaId;
	}

	public void setCriteriaId(CriteriaPrimaryKey criteriaId) {
		this.criteriaId = criteriaId;
	}

	public String getProgrammerId() {
		return programmerId;
	}

	public void setProgrammerId(String programmerId) {
		this.programmerId = programmerId;
	}

	public String getFacultysaved() {
		return facultysaved;
	}

	public void setFacultysaved(String facultysaved) {
		this.facultysaved = facultysaved;
	}

	public String getFacultymodify() {
		return facultymodify;
	}

	public void setFacultymodify(String facultymodify) {
		this.facultymodify = facultymodify;
	}

	public String getDeanStatus() {
		return deanStatus;
	}

	public void setDeanStatus(String deanStatus) {
		this.deanStatus = deanStatus;
	}

	public String getDeanComments() {
		return deanComments;
	}

	public void setDeanComments(String deanComments) {
		this.deanComments = deanComments;
	}

	public String getPrincipalStatus() {
		return principalStatus;
	}

	public void setPrincipalStatus(String principalStatus) {
		this.principalStatus = principalStatus;
	}

	public String getPrincipalComments() {
		return principalComments;
	}

	public void setPrincipalComments(String principalComments) {
		this.principalComments = principalComments;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(criteriaId, deanComments, deanStatus, facultymodify, facultysaved, principalComments,
				principalStatus, programmerId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TrackingDetails other = (TrackingDetails) obj;
		return Objects.equals(criteriaId, other.criteriaId) && Objects.equals(deanComments, other.deanComments)
				&& Objects.equals(deanStatus, other.deanStatus) && Objects.equals(facultymodify, other.facultymodify)
				&& Objects.equals(facultysaved, other.facultysaved)
				&& Objects.equals(principalComments, other.principalComments)
				&& Objects.equals(principalStatus, other.principalStatus)
				&& Objects.equals(programmerId, other.programmerId);
	}

		

}
