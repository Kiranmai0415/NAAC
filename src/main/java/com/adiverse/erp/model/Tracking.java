package com.adiverse.erp.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tracking")
public class Tracking implements Serializable
{

	private static final long serialVersionUID = 1L;

	@Id
    public CriteriaPrimaryKey criteriaId;

	@Column(name="record")
	private String record;
	
	@Column(name="status")
	private String status;
	
	@Column(name="prinaipal_comments")
	private String principalComments;
	
	@Column(name="dean_comments")
	private String deanComments;
	
	@Column(name="qualityAdvisor_comments")
	private String qualityAdvisorComments;
	
	@Column(name="assigned_to")
	private String assignedTo;
	
	@Column(name="assigned_by")
	private String assignedBy;
	
	@Column(name="approver_id")
	private String approverId;
	
	@Column(name="role")
	private String role;
	
	@Column(name="date")
	private String date;
	
    

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getPrincipalComments() {
		return principalComments;
	}

	public void setPrincipalComments(String principalComments) {
		this.principalComments = principalComments;
	}

	public String getDeanComments() {
		return deanComments;
	}

	public void setDeanComments(String deanComments) {
		this.deanComments = deanComments;
	}

	public String getQualityAdvisorComments() {
		return qualityAdvisorComments;
	}

	public void setQualityAdvisorComments(String qualityAdvisorComments) {
		this.qualityAdvisorComments = qualityAdvisorComments;
	}

	public String getAssignedTo() {
		return assignedTo;
	}

	public void setAssignedTo(String assignedTo) {
		this.assignedTo = assignedTo;
	}

	public String getAssignedBy() {
		return assignedBy;
	}

	public void setAssignedBy(String assignedBy) {
		this.assignedBy = assignedBy;
	}

	public String getApproverId() {
		return approverId;
	}

	public void setApproverId(String approverId) {
		this.approverId = approverId;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public CriteriaPrimaryKey getCriteriaId() {
		return criteriaId;
	}

	public void setCriteriaId(CriteriaPrimaryKey criteriaId) {
		this.criteriaId = criteriaId;
	}

	public String getRecord() {
		return record;
	}

	public void setRecord(String record) {
		this.record = record;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
}
