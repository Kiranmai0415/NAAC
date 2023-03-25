package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Embeddable;


@Embeddable
public class CriteriaId implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Column(name="collegeId")
    private String collegeId;
	
	@Column(name="financialYear")
    private String financialYear;
	
	@Column(name="typeofInstitution")
    private String typeofInstitution;

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
	

	public String getTypeofInstitution() {
		return typeofInstitution;
	}

	public void setTypeofInstitution(String typeofInstitution) {
		this.typeofInstitution = typeofInstitution;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(collegeId, financialYear, typeofInstitution);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CriteriaId other = (CriteriaId) obj;
		return Objects.equals(collegeId, other.collegeId) && Objects.equals(financialYear, other.financialYear)
				&& Objects.equals(typeofInstitution, other.typeofInstitution);
	}

	
	
}
