package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name ="AssignEmail")
public class AssignEmail implements Serializable{
	
	
	
	private static final long serialVersionUID = 2963762320319863087L;

	@Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long assignId;
	
	@Column(name = "emailAddress")
    private String emailAddress;
	@Column(name = "Criterias")
    private String criteria;
	@Column(name = "ExpiryDate")
    private String expiryDate;
	
	private String attachment;

	public Long getAssignId() {
		return assignId;
	}

	public void setAssignId(Long assignId) {
		this.assignId = assignId;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getCriteria() {
		return criteria;
	}

	public void setCriteria(String criteria) {
		this.criteria = criteria;
	}

	public String getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}

	public String getAttachment() {
		return attachment;
	}

	public void setAttachment(String attachment) {
		this.attachment = attachment;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

   
	
	
	

		
}
