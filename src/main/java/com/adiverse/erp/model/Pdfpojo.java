
package com.adiverse.erp.model;


import java.util.*;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

//import com.adiverse.erp.model.AcademicInstitution;
import com.lowagie.text.Chunk;

@Entity
@Table(name ="pdf_pojo22")
public class Pdfpojo {
	
	@Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long pojoId;
	
	@Column(name = "Criteria_name")
    private String Criteria_name;
	
	@Column(name = "gradescale_value")
    private String inputvalt1;
  
	@Column(name = "gradescale_wisegrade")
    private String inputvalt2;
	
	 
	 @OneToMany(targetEntity = Pdfpojo1.class,cascade=CascadeType.ALL)
	  @JoinColumn(name="pdf_foreignkey",referencedColumnName="pojoId")
	  private List<Pdfpojo1> pdfpojo1;
	 
	  
    
	public Long getPojoId() {
		return pojoId;
	}

	public void setPojoId(Long pojoId) {
		this.pojoId = pojoId;
	}

	public String getCriteria_name() {
		if (Criteria_name!=null) {
			return Criteria_name;
		}
		else {
			return "";
		}
		
	}

	public void setCriteria_name(String criteria_name) {
		Criteria_name = criteria_name;
	}

	

	public String getInputvalt1() {
		if (inputvalt1!=null) {
			return inputvalt1;
		}
		else {
			return "";
		}
	}

	public void setInputvalt1(String inputvalt1) {
		this.inputvalt1 = inputvalt1;
	}

	public String getInputvalt2() {
		if (inputvalt2!=null) {
			return inputvalt2;
		}
		else {
			return "";
		}
	}

	public void setInputvalt2(String inputvalt2) {
		this.inputvalt2 = inputvalt2;
	}

	public List<Pdfpojo1> getPdfpojo1() {
		return pdfpojo1;
	}

	public void setPdfpojo1(List<Pdfpojo1> pdfpojo1) {
		this.pdfpojo1 = pdfpojo1;
	}
	
	
}
	


	