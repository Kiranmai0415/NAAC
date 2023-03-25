package com.adiverse.erp.model;


import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="principal_assign_functionality")
public class AssignFunctionality implements Serializable
{


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private CriteriaPrimaryKey criteriaId;
	
 	@Id
    @Column(name="unique_key1")
	private long uniqueKey1;
	
	
	 @Column(name="assigned_to")
	  private String assignedTo;
	
	
	@Column(name="assigned_by")
	  private String assignedBy;
	  
	  @Column(name="assign_date")
	  private String assignDate;
	  
	  @Column(name="expiry_date")
	  private String expiryDate;
	  
	  @Column(name="tracking_status") 
	  private String trackingStatus;

	public CriteriaPrimaryKey getCriteriaId() {
		return criteriaId;
	}

	public void setCriteriaId(CriteriaPrimaryKey criteriaId) {
		this.criteriaId = criteriaId;
	}

	public long getUniqueKey1() {
		return uniqueKey1;
	}

	public void setUniqueKey1(long uniqueKey1) {
		this.uniqueKey1 = uniqueKey1;
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

	public String getAssignDate() {
		return assignDate;
	}

	public void setAssignDate(String assignDate) {
		this.assignDate = assignDate;
	}

	public String getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}

	public String getTrackingStatus() {
		return trackingStatus;
	}

	public void setTrackingStatus(String trackingStatus) {
		this.trackingStatus = trackingStatus;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(assignDate, assignedBy, assignedTo, criteriaId, expiryDate, trackingStatus, uniqueKey1);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AssignFunctionality other = (AssignFunctionality) obj;
		return Objects.equals(assignDate, other.assignDate) && Objects.equals(assignedBy, other.assignedBy)
				&& Objects.equals(assignedTo, other.assignedTo) && Objects.equals(criteriaId, other.criteriaId)
				&& Objects.equals(expiryDate, other.expiryDate) && Objects.equals(trackingStatus, other.trackingStatus)
				&& uniqueKey1 == other.uniqueKey1;
	}
	  
	  

	
	 
	  
}


