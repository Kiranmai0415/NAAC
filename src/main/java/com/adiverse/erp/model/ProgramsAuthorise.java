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
@Table(name = "programs_authorise")
public class ProgramsAuthorise implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
    public CriteriaPrimaryKey criteriaId;
	
	@Id
	@Column(name = "programmer_Id")
	private String programmerId;
	
	@Column(name = "faculty_status")
	private String facultyStatus;
	
	@Column(name = "faculty_Comments")
	private String facultyComments;
	
	@Column(name = "dean_status")
	private String deanStatus;
	
	@Column(name = "dean_Comments")
	private String deanComments;
	
	@Column(name = "principal_status")
	private String principalStatus;
	
	@Column(name = "principal_Comments")
	private String principalComments;

	@Column(name = "created_time")
	private String createdTime;
	
	@Column(name = "authorized_by")
	private String authorizedBy;
	
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

	public String getFacultyStatus() {
		return facultyStatus;
	}

	public void setFacultyStatus(String facultyStatus) {
		this.facultyStatus = facultyStatus;
	}

	public String getFacultyComments() {
		return facultyComments;
	}

	public void setFacultyComments(String facultyComments) {
		this.facultyComments = facultyComments;
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

	public String getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(String createdTime) {
		this.createdTime = createdTime;
	}

	public String getAuthorizedBy() {
		return authorizedBy;
	}

	public void setAuthorizedBy(String authorizedBy) {
		this.authorizedBy = authorizedBy;
	}

	@Override
	public int hashCode() {
		return Objects.hash(authorizedBy, createdTime, criteriaId, deanComments, deanStatus, facultyComments,
				facultyStatus, principalComments, principalStatus, programmerId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProgramsAuthorise other = (ProgramsAuthorise) obj;
		return Objects.equals(authorizedBy, other.authorizedBy) && Objects.equals(createdTime, other.createdTime)
				&& Objects.equals(criteriaId, other.criteriaId) && Objects.equals(deanComments, other.deanComments)
				&& Objects.equals(deanStatus, other.deanStatus)
				&& Objects.equals(facultyComments, other.facultyComments)
				&& Objects.equals(facultyStatus, other.facultyStatus)
				&& Objects.equals(principalComments, other.principalComments)
				&& Objects.equals(principalStatus, other.principalStatus)
				&& Objects.equals(programmerId, other.programmerId);
	}

	

}
