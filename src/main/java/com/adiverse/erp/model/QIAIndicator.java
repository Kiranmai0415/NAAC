package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="qia_details")
public class QIAIndicator implements Serializable
{

	private static final long serialVersionUID = 7087082295931160059L;
	
	
	private CriteriaPrimaryKey criteriaId;
	
	
	@Id
    @Column(name="unique_key1")
	private long uniqueKey1;

 
	 
	// first three tables
	  @Column(name="Date_of_submission")
	  private String inputIiqaDate;
	  
	  @Column(name="aishe_id")
	  private String inputIiqaAisheId;
	  
	  @Column(name="institution_trackId")
	  private String inputIiqaTrackId;

	  
	  
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

	

	

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(criteriaId, inputIiqaAisheId, inputIiqaDate, inputIiqaTrackId, uniqueKey1);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		QIAIndicator other = (QIAIndicator) obj;
		return Objects.equals(criteriaId, other.criteriaId) && Objects.equals(inputIiqaAisheId, other.inputIiqaAisheId)
				&& Objects.equals(inputIiqaDate, other.inputIiqaDate)
				&& Objects.equals(inputIiqaTrackId, other.inputIiqaTrackId) && uniqueKey1 == other.uniqueKey1;
	}

	public String getInputIiqaDate() {
		if (inputIiqaDate!=null) {
			return inputIiqaDate;
		}
		else {
			return "";
		}
		
	}

	public void setInputIiqaDate(String inputIiqaDate) {
		this.inputIiqaDate = inputIiqaDate;
	}

	public String getInputIiqaAisheId() {
		if (inputIiqaAisheId!=null) {
			return inputIiqaAisheId;
		}
		else {
			return "";
		}
		
	}

	public void setInputIiqaAisheId(String inputIiqaAisheId) {
		this.inputIiqaAisheId = inputIiqaAisheId;
	}

	public String getInputIiqaTrackId() {
		if (inputIiqaTrackId!=null) {
			return inputIiqaTrackId;
		}
		else {
			return "";
		}
		
	}

	public void setInputIiqaTrackId(String inputIiqaTrackId) {
		this.inputIiqaTrackId = inputIiqaTrackId;
	}
	  
	  
	
	
}
