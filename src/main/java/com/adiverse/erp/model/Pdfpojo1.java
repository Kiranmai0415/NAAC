package com.adiverse.erp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="pdf_pojo23")
public class Pdfpojo1 {
	@Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long pojo1Id;
	@Column(name = "Institutional_CGPA")
    private String Institutional_CGPA;
	
	
	@Column(name = "grade")
    private String inputvalt3;
	
	@Column(name = "total")
    private String inputvalt4;
	
	@Column(name = "date")
    private String inputvalt5;



	public Long getPojo1Id() {
		return pojo1Id;
	}

	public void setPojo1Id(Long pojo1Id) {
		this.pojo1Id = pojo1Id;
	}

	public String getInstitutional_CGPA() {
		if (Institutional_CGPA!=null) {
			return Institutional_CGPA;
		}
		else {
			return "";
		}
	}

	public void setInstitutional_CGPA(String institutional_CGPA) {
		Institutional_CGPA = institutional_CGPA;
	}

	public String getInputvalt3() {
		if (inputvalt3!=null) {
			return inputvalt3;
		}
		else {
			return "";
		}
		
	}

	public void setInputvalt3(String inputvalt3) {
		this.inputvalt3 = inputvalt3;
	}

	public String getInputvalt4() {
		if (inputvalt4!=null) {
			return inputvalt4;
		}
		else {
			return "";
		}
	}

	public void setInputvalt4(String inputvalt4) {
		this.inputvalt4 = inputvalt4;
	}

	public String getInputvalt5() {
		if (inputvalt5!=null) {
			return inputvalt5;
		}
		else {
			return "";
		}
	}

	public void setInputvalt5(String inputvalt5) {
		this.inputvalt5 = inputvalt5;
	}

	

	
	
}
