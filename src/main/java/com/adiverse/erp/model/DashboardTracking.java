package com.adiverse.erp.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="dashboard_tracking")
public class DashboardTracking implements Serializable
{

	private static final long serialVersionUID = 1L;

	@Id
    public CriteriaPrimaryKey criteriaId;

	@Column(name="record")
	private String record;
	
	@Column(name="status")
	private String status;
	
	
	@Column(name="hod_comments")
	private String hodComments;
	
	
	
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

	public String getHodComments() {
		return hodComments;
	}

	public void setHodComments(String hodComments) {
		this.hodComments = hodComments;
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

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	

	
}
