package com.adiverse.erp.payload.request;

import java.io.Serializable;

public class RestAPIRequest implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String collegeId;
	
	private String financialYear;
	
	private String typeofInstitution;
	
	private long uniqueKey1;
	
	private String inputArg1;
	
	private String inputArg2;
	
	private String inputArg3;
	
	private String inputArg4;
	
	private String inputArg5;

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

	public long getUniqueKey1() {
		return uniqueKey1;
	}

	public void setUniqueKey1(long uniqueKey1) {
		this.uniqueKey1 = uniqueKey1;
	}

	public String getInputArg1() {
		return inputArg1;
	}

	public void setInputArg1(String inputArg1) {
		this.inputArg1 = inputArg1;
	}

	public String getInputArg2() {
		return inputArg2;
	}

	public void setInputArg2(String inputArg2) {
		this.inputArg2 = inputArg2;
	}

	public String getInputArg3() {
		return inputArg3;
	}

	public void setInputArg3(String inputArg3) {
		this.inputArg3 = inputArg3;
	}

	public String getInputArg4() {
		return inputArg4;
	}

	public void setInputArg4(String inputArg4) {
		this.inputArg4 = inputArg4;
	}

	public String getInputArg5() {
		return inputArg5;
	}

	public void setInputArg5(String inputArg5) {
		this.inputArg5 = inputArg5;
	}
}
