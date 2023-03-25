package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;


@Embeddable
public class Criteria1Id implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Column(name="college_id")
    private String collegeId;
	
	@Column(name="financial_year")
    private String financialYear;

	public String getCollegeId() {
		return collegeId;
	}

	public void setCollegeId(String collegeId) {
		this.collegeId = collegeId;
	}

	public String getFinancialYear() {
		return financialYear;
	}

	public void setFinancialYear(String financialYear) {
		this.financialYear = financialYear;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(collegeId, financialYear);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Criteria1Id other = (Criteria1Id) obj;
		return Objects.equals(collegeId, other.collegeId) && Objects.equals(financialYear, other.financialYear);
	}
	
	

}
