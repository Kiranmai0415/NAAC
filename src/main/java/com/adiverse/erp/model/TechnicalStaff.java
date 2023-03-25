package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="technical_Staff")
public class TechnicalStaff implements Serializable
{
	private static final long serialVersionUID = 478870268357692854L;


	private CriteriaPrimaryKey criteriaId;
	
 	@Id
    @Column(name="unique_key1")
	private long uniqueKey1;
	
	@Column(name="Technical_male")
	private String inputatt15;
	
	@Column(name="Technical_Female")
	private String inputatt16;
	
	@Column(name="Technical_Others")
	private String inputatt17;
	
	@Column(name="Technical_Total")
	private String inputatt18;

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

	public String getInputatt15() {
		if (inputatt15!=null) {
			return inputatt15;
		}
		else {
			return "";
		}
		
	}

	public void setInputatt15(String inputatt15) {
		this.inputatt15 = inputatt15;
	}

	public String getInputatt16() {
		if (inputatt16!=null) {
			return inputatt16;
		}
		else {
			return "";
		}
		
	}

	public void setInputatt16(String inputatt16) {
		this.inputatt16 = inputatt16;
	}

	public String getInputatt17() {
		if (inputatt17!=null) {
			return inputatt17;
		}
		else {
			return "";
		}
		
	}

	public void setInputatt17(String inputatt17) {
		this.inputatt17 = inputatt17;
	}

	public String getInputatt18() {
		if (inputatt18!=null) {
			return inputatt18;
		}
		else {
			return "";
		}
	}

	public void setInputatt18(String inputatt18) {
		this.inputatt18 = inputatt18;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(criteriaId, inputatt15, inputatt16, inputatt17, inputatt18, uniqueKey1);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TechnicalStaff other = (TechnicalStaff) obj;
		return Objects.equals(criteriaId, other.criteriaId) && Objects.equals(inputatt15, other.inputatt15)
				&& Objects.equals(inputatt16, other.inputatt16) && Objects.equals(inputatt17, other.inputatt17)
				&& Objects.equals(inputatt18, other.inputatt18) && uniqueKey1 == other.uniqueKey1;
	}
	
	
	

	
	
}