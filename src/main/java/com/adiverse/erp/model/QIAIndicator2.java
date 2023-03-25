package com.adiverse.erp.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="qia1_details")
public class QIAIndicator2 implements Serializable
{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private CriteriaPrimaryKey criteriaId;


	@Id
    @Column(name="unique_key1")
	private long uniqueKey1;

	
	  @Column(name="Application_For")
	  private String inputiiqa1t1;
	  
	  @Column(name="College")
	  private String inputiiqa1t2;
	  
	  @Column(name="Nameof_college")
	  private String inputiiqa2t1;
	  
	  @Column(name="Date_of_establishment_of_the_Institution")
	  private String inputiiqa3t1;
	  
	  @Column(name="Name_of_the_Head_of_the_Institution")
	  private String inputiiqa4t1;
	  
	  @Column(name="Designation")
	  private String inputiiqa4t2;
	  
	  @Column(name="Does_the_college_function_from_OwnCampus")
	  private String inputiiqa5t1;
	  
	  @Column(name="Address_of_the_College")
	  private String inputiiqa6t1;
	  
	  @Column(name="State_UT")
	  private String inputiiqa6t2;
	  
	  @Column(name="District")
	  private String inputiiqa6t3;
	  
	  @Column(name="City")
	  private String inputiiqa6t4;
	  
	  @Column(name="Pin")
	  private String inputiiqa6t5;
	  
	  @Column(name="Phone_No")
	  private String inputiiqa6t6;
	  
	  @Column(name="Fax_No")
	  private String inputiiqa6t7;
	  
	  @Column(name="Mobile_No")
	  private String inputiiqa6t8;
	  
	  @Column(name="Registered_Email")
	  private String inputiiqa6t9;
	  
	  @Column(name="Alternate_Email2")
	  private String inputiiqa6t10;
	  
	  @Column(name="Alternate_Faculty_Contact_Details")
	  private String inputiiqa7t1;
	  
	  @Column(name="Alternate_Address ")
	  private String inputiiqa7t2;
	  
	  @Column(name="Alternate_StateUT")
	  private String inputiiqa7t3;
	  
	  @Column(name="Alternate_City")
	  private String inputiiqa7t4;
	  
	  @Column(name="Alternate_Pin")
	  private String inputiiqa7t5;
	  
	  @Column(name="Alternate_PhoneNo")
	  private String inputiiqa7t6;
	  
	  @Column(name="Alternate_FaxNo")
	  private String inputiiqa7t7;
	  
	  @Column(name="Alternate_MobileNo")
	  private String inputiiqa7t8;
	  
	  @Column(name="Alternate_Email1")
	  private String inputiiqa7t9;
	  
	  @Column(name="AlternateFaclity_Email")
	  private String inputiiqa7t10;
	  
	  @Column(name="Website")
	  private String inputiiqa8t1;
	  
	  @Column(name="Institution_graduation_of_last_two_batches")
	  private String inputiiqa9t1;
	  
	  @Column(name="Nature_of_the_college")
	  private String inputiiqa10t1;
	  
	  @Column(name="College_Affiliation")
	  private String inputiiqa11t1;
	  
	  @Column(name="Institution_recognized_under_section")
	  private String inputiiqa13t1;
	  
	  @Column(name="Institution_recognized_under_section_12B")
	  private String inputiiqa14t1;
	  
	  @Column(name="institution_recognised_as_Autonomous")
	  private String inputiiqa15t1;
	  
	  @Column(name="institution_recognised_Potential_Excellence")
      private String inputiiqa16t1;
	  
	  @Column(name="the_institution_recognised_Excellence_UGC")	
	  private String inputiiqa17t1;
	  
	  @Column(name="College_offering_programmes_Statutory_Regulatory_Authority")
	  private String inputiiqa18t1;
	  
	  @Column(name="the_institution_not_affiliated_university")
	  private String inputiiqa19t1;
	  
	  @Column(name="institutionstatutory_cells_committees")
	  private String inputiiqa25t1;
	  
	  @Column(name="Date_establishment_IQAC")
	  private String inputiiqa26t1;
	  
	  @Column(name="institution_made_statutory_declaration")
	  private String inputiiqa28t1;
	  
	  @Column(name="college_have_academic_MoU_foreign_institution")
	  private String inputiiqa29t1;
	  
	  
	  @Column(name="dateof_uploading")
	  private String inputiiqa30t1;
	  
	  
	  @Column(name="headof_institution")
	  private String inputiiqa31t1;
	  
	  @Column(name="paid_details")
	  private String inputiiqa32t1;
	  
	  
	  
	  

	public CriteriaPrimaryKey getCriteriaId() {
		return criteriaId;
	}

	public void setCriteriaId(CriteriaPrimaryKey criteriaId) {
		this.criteriaId = criteriaId;
	}

	public String getInputiiqa30t1() {
		if (inputiiqa30t1!=null) {
			return inputiiqa30t1;
		}
		else {
			return "";
		}
		
	}

	public void setInputiiqa30t1(String inputiiqa30t1) {
		this.inputiiqa30t1 = inputiiqa30t1;
	}

	public String getInputiiqa31t1() {
		if (inputiiqa31t1!=null) {
			return inputiiqa31t1;
		}
		else {
			return "";
		}
	}

	public void setInputiiqa31t1(String inputiiqa31t1) {
		this.inputiiqa31t1 = inputiiqa31t1;
	}

	public String getInputiiqa32t1() {
		if (inputiiqa32t1!=null) {
			return inputiiqa32t1;
		}
		else {
			return "";
		}
	}

	public void setInputiiqa32t1(String inputiiqa32t1) {
		this.inputiiqa32t1 = inputiiqa32t1;
	}

	

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public long getUniqueKey1() {
		return uniqueKey1;
	}

	public void setUniqueKey1(long uniqueKey1) {
		this.uniqueKey1 = uniqueKey1;
	}

	public String getInputiiqa1t1() {
		if (inputiiqa1t1!=null) {
			return inputiiqa1t1;
		}
		else {
			return "";
		}
		
	}

	public void setInputiiqa1t1(String inputiiqa1t1) {
		this.inputiiqa1t1 = inputiiqa1t1;
	}

	public String getInputiiqa1t2() {
		if (inputiiqa1t2!=null) {
			return inputiiqa1t2;
		}
		else {
			return "";
		}
	}

	public void setInputiiqa1t2(String inputiiqa1t2) {
		this.inputiiqa1t2 = inputiiqa1t2;
	}

	public String getInputiiqa2t1() {
		if (inputiiqa2t1!=null) {
			return inputiiqa2t1;
		}
		else {
			return "";
		}
	}

	public void setInputiiqa2t1(String inputiiqa2t1) {
		this.inputiiqa2t1 = inputiiqa2t1;
	}

	public String getInputiiqa3t1() {
		if (inputiiqa3t1!=null) {
			return inputiiqa3t1;
		}
		else {
			return "";
		}
	}

	public void setInputiiqa3t1(String inputiiqa3t1) {
		this.inputiiqa3t1 = inputiiqa3t1;
	}

	public String getInputiiqa4t1() {
		if (inputiiqa4t1!=null) {
			return inputiiqa4t1;
		}
		else {
			return "";
		}
	}

	public void setInputiiqa4t1(String inputiiqa4t1) {
		this.inputiiqa4t1 = inputiiqa4t1;
	}

	public String getInputiiqa4t2() {
		if (inputiiqa4t2!=null) {
			return inputiiqa4t2;
		}
		else {
			return "";
		}
	}

	public void setInputiiqa4t2(String inputiiqa4t2) {
		this.inputiiqa4t2 = inputiiqa4t2;
	}

	public String getInputiiqa5t1() {
		if (inputiiqa5t1!=null) {
			return inputiiqa5t1;
		}
		else {
			return "";
		}
	}

	public void setInputiiqa5t1(String inputiiqa5t1) {
		this.inputiiqa5t1 = inputiiqa5t1;
	}

	public String getInputiiqa6t1() {
		if (inputiiqa6t1!=null) {
			return inputiiqa6t1;
		}
		else {
			return "";
		}
	}

	public void setInputiiqa6t1(String inputiiqa6t1) {
		this.inputiiqa6t1 = inputiiqa6t1;
	}

	public String getInputiiqa6t2() {
		if (inputiiqa6t2!=null) {
			return inputiiqa6t2;
		}
		else {
			return "";
		}
	}

	public void setInputiiqa6t2(String inputiiqa6t2) {
		this.inputiiqa6t2 = inputiiqa6t2;
	}

	public String getInputiiqa6t3() {
		if (inputiiqa6t3!=null) {
			return inputiiqa6t3;
		}
		else {
			return "";
		}
	}

	public void setInputiiqa6t3(String inputiiqa6t3) {
		this.inputiiqa6t3 = inputiiqa6t3;
	}

	public String getInputiiqa6t4() {
		if (inputiiqa6t4!=null) {
			return inputiiqa6t4;
		}
		else {
			return "";
		}
	}

	public void setInputiiqa6t4(String inputiiqa6t4) {
		this.inputiiqa6t4 = inputiiqa6t4;
	}

	public String getInputiiqa6t5() {
		if (inputiiqa6t5!=null) {
			return inputiiqa6t5;
		}
		else {
			return "";
		}
	}

	public void setInputiiqa6t5(String inputiiqa6t5) {
		this.inputiiqa6t5 = inputiiqa6t5;
	}

	public String getInputiiqa6t6() {
		if (inputiiqa6t6!=null) {
			return inputiiqa6t6;
		}
		else {
			return "";
		}
	}

	public void setInputiiqa6t6(String inputiiqa6t6) {
		this.inputiiqa6t6 = inputiiqa6t6;
	}

	public String getInputiiqa6t7() {
		if (inputiiqa6t7!=null) {
			return inputiiqa6t7;
		}
		else {
			return "";
		}
	}

	public void setInputiiqa6t7(String inputiiqa6t7) {
		this.inputiiqa6t7 = inputiiqa6t7;
	}

	public String getInputiiqa6t8() {
		if (inputiiqa6t8!=null) {
			return inputiiqa6t8;
		}
		else {
			return "";
		}
	}

	public void setInputiiqa6t8(String inputiiqa6t8) {
		this.inputiiqa6t8 = inputiiqa6t8;
	}

	public String getInputiiqa6t9() {
		if (inputiiqa6t9!=null) {
			return inputiiqa6t9;
		}
		else {
			return "";
		}
	}

	public void setInputiiqa6t9(String inputiiqa6t9) {
		this.inputiiqa6t9 = inputiiqa6t9;
	}

	public String getInputiiqa6t10() {
		if (inputiiqa6t10!=null) {
			return inputiiqa6t10;
		}
		else {
			return "";
		}
	}

	public void setInputiiqa6t10(String inputiiqa6t10) {
		this.inputiiqa6t10 = inputiiqa6t10;
	}

	public String getInputiiqa7t1() {
		if (inputiiqa7t1!=null) {
			return inputiiqa7t1;
		}
		else {
			return "";
		}
	}

	public void setInputiiqa7t1(String inputiiqa7t1) {
		this.inputiiqa7t1 = inputiiqa7t1;
	}

	public String getInputiiqa7t2() {
		if (inputiiqa7t2!=null) {
			return inputiiqa7t2;
		}
		else {
			return "";
		}
	}

	public void setInputiiqa7t2(String inputiiqa7t2) {
		this.inputiiqa7t2 = inputiiqa7t2;
	}

	public String getInputiiqa7t3() {
		if (inputiiqa7t3!=null) {
			return inputiiqa7t3;
		}
		else {
			return "";
		}
	}

	public void setInputiiqa7t3(String inputiiqa7t3) {
		this.inputiiqa7t3 = inputiiqa7t3;
	}

	public String getInputiiqa7t4() {
		if (inputiiqa7t4!=null) {
			return inputiiqa7t4;
		}
		else {
			return "";
		}
	}

	public void setInputiiqa7t4(String inputiiqa7t4) {
		this.inputiiqa7t4 = inputiiqa7t4;
	}

	public String getInputiiqa7t5() {
		if (inputiiqa7t5!=null) {
			return inputiiqa7t5;
		}
		else {
			return "";
		}
	}

	public void setInputiiqa7t5(String inputiiqa7t5) {
		this.inputiiqa7t5 = inputiiqa7t5;
	}

	public String getInputiiqa7t6() {
		if (inputiiqa7t6!=null) {
			return inputiiqa7t6;
		}
		else {
			return "";
		}
	}

	public void setInputiiqa7t6(String inputiiqa7t6) {
		this.inputiiqa7t6 = inputiiqa7t6;
	}

	public String getInputiiqa7t7() {
		if (inputiiqa7t7!=null) {
			return inputiiqa7t7;
		}
		else {
			return "";
		}
	}

	public void setInputiiqa7t7(String inputiiqa7t7) {
		this.inputiiqa7t7 = inputiiqa7t7;
	}

	public String getInputiiqa7t8() {
		if (inputiiqa7t8!=null) {
			return inputiiqa7t8;
		}
		else {
			return "";
		}
	}

	public void setInputiiqa7t8(String inputiiqa7t8) {
		this.inputiiqa7t8 = inputiiqa7t8;
	}

	public String getInputiiqa7t9() {
		if (inputiiqa7t9!=null) {
			return inputiiqa7t9;
		}
		else {
			return "";
		}
	}

	public void setInputiiqa7t9(String inputiiqa7t9) {
		this.inputiiqa7t9 = inputiiqa7t9;
	}

	public String getInputiiqa7t10() {
		if (inputiiqa7t10!=null) {
			return inputiiqa7t10;
		}
		else {
			return "";
		}
	}

	public void setInputiiqa7t10(String inputiiqa7t10) {
		this.inputiiqa7t10 = inputiiqa7t10;
	}

	public String getInputiiqa8t1() {
		if (inputiiqa8t1!=null) {
			return inputiiqa8t1;
		}
		else {
			return "";
		}
	}

	public void setInputiiqa8t1(String inputiiqa8t1) {
		this.inputiiqa8t1 = inputiiqa8t1;
	}

	public String getInputiiqa9t1() {
		if (inputiiqa9t1!=null) {
			return inputiiqa9t1;
		}
		else {
			return "";
		}
	}

	public void setInputiiqa9t1(String inputiiqa9t1) {
		this.inputiiqa9t1 = inputiiqa9t1;
	}

	public String getInputiiqa10t1() {
		if (inputiiqa10t1!=null) {
			return inputiiqa10t1;
		}
		else {
			return "";
		}
	}

	public void setInputiiqa10t1(String inputiiqa10t1) {
		this.inputiiqa10t1 = inputiiqa10t1;
	}

	public String getInputiiqa11t1() {
		if (inputiiqa11t1!=null) {
			return inputiiqa11t1;
		}
		else {
			return "";
		}
	}

	public void setInputiiqa11t1(String inputiiqa11t1) {
		this.inputiiqa11t1 = inputiiqa11t1;
	}

	public String getInputiiqa13t1() {
		if (inputiiqa13t1!=null) {
			return inputiiqa13t1;
		}
		else {
			return "";
		}
	}

	public void setInputiiqa13t1(String inputiiqa13t1) {
		this.inputiiqa13t1 = inputiiqa13t1;
	}

	public String getInputiiqa14t1() {
		if (inputiiqa14t1!=null) {
			return inputiiqa14t1;
		}
		else {
			return "";
		}
	}

	public void setInputiiqa14t1(String inputiiqa14t1) {
		this.inputiiqa14t1 = inputiiqa14t1;
	}

	public String getInputiiqa15t1() {
		if (inputiiqa15t1!=null) {
			return inputiiqa15t1;
		}
		else {
			return "";
		}
	}

	public void setInputiiqa15t1(String inputiiqa15t1) {
		this.inputiiqa15t1 = inputiiqa15t1;
	}

	public String getInputiiqa16t1() {
		if (inputiiqa16t1!=null) {
			return inputiiqa16t1;
		}
		else {
			return "";
		}
	}

	public void setInputiiqa16t1(String inputiiqa16t1) {
		this.inputiiqa16t1 = inputiiqa16t1;
	}

	public String getInputiiqa17t1() {
		if (inputiiqa17t1!=null) {
			return inputiiqa17t1;
		}
		else {
			return "";
		}
	}

	public void setInputiiqa17t1(String inputiiqa17t1) {
		this.inputiiqa17t1 = inputiiqa17t1;
	}

	public String getInputiiqa18t1() {
		if (inputiiqa18t1!=null) {
			return inputiiqa18t1;
		}
		else {
			return "";
		}
	}

	public void setInputiiqa18t1(String inputiiqa18t1) {
		this.inputiiqa18t1 = inputiiqa18t1;
	}

	public String getInputiiqa19t1() {
		if (inputiiqa19t1!=null) {
			return inputiiqa19t1;
		}
		else {
			return "";
		}
	}

	public void setInputiiqa19t1(String inputiiqa19t1) {
		this.inputiiqa19t1 = inputiiqa19t1;
	}

	public String getInputiiqa25t1() {
		if (inputiiqa25t1!=null) {
			return inputiiqa25t1;
		}
		else {
			return "";
		}
	}

	public void setInputiiqa25t1(String inputiiqa25t1) {
		this.inputiiqa25t1 = inputiiqa25t1;
	}

	public String getInputiiqa26t1() {
		if (inputiiqa26t1!=null) {
			return inputiiqa26t1;
		}
		else {
			return "";
		}
	}

	public void setInputiiqa26t1(String inputiiqa26t1) {
		this.inputiiqa26t1 = inputiiqa26t1;
	}

	public String getInputiiqa28t1() {
		if (inputiiqa28t1!=null) {
			return inputiiqa28t1;
		}
		else {
			return "";
		}
	}

	public void setInputiiqa28t1(String inputiiqa28t1) {
		this.inputiiqa28t1 = inputiiqa28t1;
	}

	public String getInputiiqa29t1() {
		if (inputiiqa29t1!=null) {
			return inputiiqa29t1;
		}
		else {
			return "";
		}
	}

	public void setInputiiqa29t1(String inputiiqa29t1) {
		this.inputiiqa29t1 = inputiiqa29t1;
	}
	

	  
	
	  
	  
	  
	  
}
