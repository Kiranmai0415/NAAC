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
@Table(name ="RejectEmail")
public class RejectEmail implements Serializable{
	
	
	
	private static final long serialVersionUID = 2963762320319863087L;

	@Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long emailId;
	
	@Column(name = "emailAddress")
    private String emailAddress;
	@Column(name = "Comments")
    private String comments;
	
	private String attachment; 
	
	public String getAttachment() {
		return attachment;
	}
	public void setAttachment(String attachment) {
		this.attachment = attachment;
	}
	public Long getEmailId() {
		return emailId;
	}
	public void setEmailId(Long emailId) {
		this.emailId = emailId;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

   
	
	
	

		
}
