package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "profile")
public class Profile implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private CriteriaPrimaryKey criteriaId;

	
	@Id
	@Column(name = "unique_key1")
	private long uniqueKey1;

	

	@Column(name = "employee_id")
	private String inputpt1;

	@Column(name = "prof_ dr_ mr_ mrs")
	private String inputpt2;

	@Column(name = "surname")
	private String inputpt3;

	@Column(name = "nameofthe_employee")
	private String inputpt4;

	@Column(name = "father_name")
	private String inputpt5;

	@Column(name = "mother_name")
	private String inputpt6;

	@Column(name = "spouse_name")
	private String inputpt7;

	@Column(name = "mother_tongue")
	private String inputpt8;

	@Column(name = "dateof_birth")
	private String inputpt9;
	
	@Column(name = "gender")
	private String inputpt10;

	@Column(name = "nationality")
	private String inputpt11;

	@Column(name = "religion")
	private String inputpt12;

	@Column(name = "cast")
	private String inputpt13;

	@Column(name = "reservation")
	private String inputpt14;

	@Column(name = "adhar_no")
	private String inputpt15;

//	@Column(name = "uploadthe_adhar")
//	private String inputpt15;

	@Column(name = "pancard_no")
	private String inputpt16;

//	@Column(name = "uploadthe_pan")
//	private String inputpt17;

	@Column(name = "bank_account")
	private String inputpt17;

//	@Column(name = "upload_the_bank_passbook_coverpage")
//	private String inputpt19;

	@Column(name = "passport_number")
	private String inputpt18;

	@Column(name = "driving_licence")
	private String inputpt19;

	@Column(name = "designation")
	private String inputpt20;
	
	@Column(name = "dept")
	private String inputpt21;
	
	@Column(name = "school_name")
	private String inputpt22;

//	@Column(name = "uploadthe_ordercopy")
//	private String inputpt23;

	@Column(name = "highest_qualification")
	private String inputpt23;

	@Column(name = "doctor_degree")
	private String inputpt24;

	@Column(name = "doctor_degree_obtainedyear")
	private String inputpt25;

	@Column(name = "pg_degree")
	private String inputpt26;

	@Column(name = "pgdegree_obtainedyear")
	private String inputpt27;

	@Column(name = "ug_degree")
	private String inputpt28;

	@Column(name = "ugdegree_obtainedyear")
	private String inputpt29;

	@Column(name = "otherqualification")
	private String inputpt30;

	@Column(name = "dateof_joining")
	private String inputpt31;

	@Column(name = "university_rectified")
	private String inputpt32;

	@Column(name = "programme")
	private String inputpt33;

	@Column(name = "course")
	private String inputpt34;

	@Column(name = "teaching_exp")
	private String inputpt35;

	@Column(name = "research_exp")
	private String inputpt36;

	@Column(name = "industry_exp")
	private String inputpt37;

	@Column(name = "areaof_specialization")
	private String inputpt38;

	@Column(name = "current_hindex(google)")
	private String inputpt39;

	@Column(name = "current_hindex(scopus)")
	private String inputpt40;

	@Column(name = "citation_google")
	private String inputpt41;

	@Column(name = "citation_scopus")
	private String inputpt42;

	@Column(name = "aicte_id")
	private String inputpt43;

	@Column(name = "orcid_id")
	private String inputpt44;

	@Column(name = "scopus_id")
	private String inputpt45;

	@Column(name = "vidwan_id")
	private String inputpt46;

	@Column(name = "land_lineno")
	private String inputpt47;

	@Column(name = "fax_no")
	private String inputpt48;

	@Column(name = "office_address")
	private String inputpt49;

	@Column(name = "phone_number")
	private String inputpt50;

	@Column(name = "email_id")
	private String inputpt51;

	@Column(name = "address")
	private String inputpt52;

	@Column(name = "city")
	private String inputpt53;

	@Column(name = "state")
	private String inputpt54;

	@Column(name = "pincode")
	private String inputpt55;

	@Column(name = "country")
	private String inputpt56;

	@Column(name = "home_address")
	private String inputpt57;

	@Column(name = "phno1")
	private String inputpt58;

	@Column(name = "email_id1")
	private String inputpt59;

	@Column(name = "address1")
	private String inputpt60;

	@Column(name = "high_qual1")
	private String inputpt61;
	
	@Column(name = "city1")
	private String inputpt62;

	@Column(name = "state1")
	private String inputpt63;

	@Column(name = "pincode1")
	private String inputpt64;

	@Column(name = "country1")
	private String inputpt65;
	
	
	
	
	
	
	
	

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

	public String getInputpt1() {
		if (inputpt1!=null) {
			return inputpt1;
		}
		else {
			return "";
		}
		
	}

	public void setInputpt1(String inputpt1) {
		this.inputpt1 = inputpt1;
	}

	public String getInputpt2() {
		if (inputpt2!=null) {
			return inputpt2;
		}
		else {
			return "";
		}
	}

	public void setInputpt2(String inputpt2) {
		this.inputpt2 = inputpt2;
	}

	public String getInputpt3() {
		if (inputpt3!=null) {
			return inputpt3;
		}
		else {
			return "";
		}
	}

	public void setInputpt3(String inputpt3) {
		this.inputpt3 = inputpt3;
	}

	public String getInputpt4() {
		if (inputpt4!=null) {
			return inputpt4;
		}
		else {
			return "";
		}
	}

	public void setInputpt4(String inputpt4) {
		this.inputpt4 = inputpt4;
	}

	public String getInputpt5() {
		if (inputpt5!=null) {
			return inputpt5;
		}
		else {
			return "";
		}
	}

	public void setInputpt5(String inputpt5) {
		this.inputpt5 = inputpt5;
	}

	public String getInputpt6() {
		if (inputpt6!=null) {
			return inputpt6;
		}
		else {
			return "";
		}
	}

	public void setInputpt6(String inputpt6) {
		this.inputpt6 = inputpt6;
	}

	public String getInputpt7() {
		if (inputpt7!=null) {
			return inputpt7;
		}
		else {
			return "";
		}
	}

	public void setInputpt7(String inputpt7) {
		this.inputpt7 = inputpt7;
	}

	public String getInputpt8() {
		if (inputpt8!=null) {
			return inputpt8;
		}
		else {
			return "";
		}
	}

	public void setInputpt8(String inputpt8) {
		this.inputpt8 = inputpt8;
	}

	public String getInputpt9() {
		if (inputpt9!=null) {
			return inputpt9;
		}
		else {
			return "";
		}
	}

	public void setInputpt9(String inputpt9) {
		this.inputpt9 = inputpt9;
	}

	public String getInputpt10() {
		if (inputpt10!=null) {
			return inputpt10;
		}
		else {
			return "";
		}
	}

	public void setInputpt10(String inputpt10) {
		this.inputpt10 = inputpt10;
	}

	public String getInputpt11() {
		if (inputpt11!=null) {
			return inputpt11;
		}
		else {
			return "";
		}
		
	}

	public void setInputpt11(String inputpt11) {
		this.inputpt11 = inputpt11;
	}

	public String getInputpt12() {
		if (inputpt12!=null) {
			return inputpt12;
		}
		else {
			return "";
		}
		
	}

	public void setInputpt12(String inputpt12) {
		this.inputpt12 = inputpt12;
	}

	public String getInputpt13() {
		if (inputpt13!=null) {
			return inputpt13;
		}
		else {
			return "";
		}
		
	}

	public void setInputpt13(String inputpt13) {
		this.inputpt13 = inputpt13;
	}

	public String getInputpt14() {
		if (inputpt14!=null) {
			return inputpt14;
		}
		else {
			return "";
		}
		
	}

	public void setInputpt14(String inputpt14) {
		this.inputpt14 = inputpt14;
	}

	public String getInputpt15() {
		if (inputpt15!=null) {
			return inputpt15;
		}
		else {
			return "";
		}
		
	}

	public void setInputpt15(String inputpt15) {
		this.inputpt15 = inputpt15;
	}

	public String getInputpt16() {
		if (inputpt16!=null) {
			return inputpt16;
		}
		else {
			return "";
		}
		
	}

	public void setInputpt16(String inputpt16) {
		this.inputpt16 = inputpt16;
	}

	public String getInputpt17() {
		if (inputpt17!=null) {
			return inputpt17;
		}
		else {
			return "";
		}
		
	}

	public void setInputpt17(String inputpt17) {
		this.inputpt17 = inputpt17;
	}

	public String getInputpt18() {
		if (inputpt18!=null) {
			return inputpt18;
		}
		else {
			return "";
		}
		
	}

	public void setInputpt18(String inputpt18) {
		this.inputpt18 = inputpt18;
	}

	public String getInputpt19() {
		if (inputpt19!=null) {
			return inputpt19;
		}
		else {
			return "";
		}
		
	}

	public void setInputpt19(String inputpt19) {
		this.inputpt19 = inputpt19;
	}

	public String getInputpt20() {
		if (inputpt20!=null) {
			return inputpt20;
		}
		else {
			return "";
		}
		
	}

	public void setInputpt20(String inputpt20) {
		this.inputpt20 = inputpt20;
	}

	public String getInputpt21() {
		if (inputpt21!=null) {
			return inputpt21;
		}
		else {
			return "";
		}
	}

	public void setInputpt21(String inputpt21) {
		this.inputpt21 = inputpt21;
	}

	public String getInputpt22() {
		if (inputpt22!=null) {
			return inputpt22;
		}
		else {
			return "";
		}
	}

	public void setInputpt22(String inputpt22) {
		this.inputpt22 = inputpt22;
	}

	public String getInputpt23() {
		if (inputpt23!=null) {
			return inputpt23;
		}
		else {
			return "";
		}
	}

	public void setInputpt23(String inputpt23) {
		this.inputpt23 = inputpt23;
	}

	public String getInputpt24() {
		if (inputpt24!=null) {
			return inputpt24;
		}
		else {
			return "";
		}
	}

	public void setInputpt24(String inputpt24) {
		this.inputpt24 = inputpt24;
	}

	public String getInputpt25() {
		if (inputpt25!=null) {
			return inputpt25;
		}
		else {
			return "";
		}
	}

	public void setInputpt25(String inputpt25) {
		this.inputpt25 = inputpt25;
	}

	public String getInputpt26() {
		if (inputpt26!=null) {
			return inputpt26;
		}
		else {
			return "";
		}
	}

	public void setInputpt26(String inputpt26) {
		this.inputpt26 = inputpt26;
	}

	public String getInputpt27() {
		if (inputpt27!=null) {
			return inputpt27;
		}
		else {
			return "";
		}
	}

	public void setInputpt27(String inputpt27) {
		this.inputpt27 = inputpt27;
	}

	public String getInputpt28() {
		if (inputpt28!=null) {
			return inputpt28;
		}
		else {
			return "";
		}
	}

	public void setInputpt28(String inputpt28) {
		this.inputpt28 = inputpt28;
	}

	public String getInputpt29() {
		if (inputpt29!=null) {
			return inputpt29;
		}
		else {
			return "";
		}
	}

	public void setInputpt29(String inputpt29) {
		this.inputpt29 = inputpt29;
	}

	public String getInputpt30() {
		if (inputpt30!=null) {
			return inputpt30;
		}
		else {
			return "";
		}
	}

	public void setInputpt30(String inputpt30) {
		this.inputpt30 = inputpt30;
	}

	public String getInputpt31() {
		if (inputpt31!=null) {
			return inputpt31;
		}
		else {
			return "";
		}
	}

	public void setInputpt31(String inputpt31) {
		this.inputpt31 = inputpt31;
	}

	public String getInputpt32() {
		if (inputpt32!=null) {
			return inputpt32;
		}
		else {
			return "";
		}
	}

	public void setInputpt32(String inputpt32) {
		this.inputpt32 = inputpt32;
	}

	public String getInputpt33() {
		if (inputpt33!=null) {
			return inputpt33;
		}
		else {
			return "";
		}
	}

	public void setInputpt33(String inputpt33) {
		this.inputpt33 = inputpt33;
	}

	public String getInputpt34() {
		if (inputpt34!=null) {
			return inputpt34;
		}
		else {
			return "";
		}
	}

	public void setInputpt34(String inputpt34) {
		this.inputpt34 = inputpt34;
	}

	public String getInputpt35() {
		if (inputpt35!=null) {
			return inputpt35;
		}
		else {
			return "";
		}
	}

	public void setInputpt35(String inputpt35) {
		this.inputpt35 = inputpt35;
	}

	public String getInputpt36() {
		if (inputpt36!=null) {
			return inputpt36;
		}
		else {
			return "";
		}
	}

	public void setInputpt36(String inputpt36) {
		this.inputpt36 = inputpt36;
	}

	public String getInputpt37() {
		if (inputpt37!=null) {
			return inputpt37;
		}
		else {
			return "";
		}
	}

	public void setInputpt37(String inputpt37) {
		this.inputpt37 = inputpt37;
	}

	public String getInputpt38() {
		if (inputpt38!=null) {
			return inputpt38;
		}
		else {
			return "";
		}
	}

	public void setInputpt38(String inputpt38) {
		this.inputpt38 = inputpt38;
	}

	public String getInputpt39() {
		if (inputpt39!=null) {
			return inputpt39;
		}
		else {
			return "";
		}
	}

	public void setInputpt39(String inputpt39) {
		this.inputpt39 = inputpt39;
	}

	public String getInputpt40() {
		if (inputpt40!=null) {
			return inputpt40;
		}
		else {
			return "";
		}
	}

	public void setInputpt40(String inputpt40) {
		this.inputpt40 = inputpt40;
	}

	public String getInputpt41() {
		if (inputpt41!=null) {
			return inputpt41;
		}
		else {
			return "";
		}
	}

	public void setInputpt41(String inputpt41) {
		this.inputpt41 = inputpt41;
	}

	public String getInputpt42() {
		if (inputpt42!=null) {
			return inputpt42;
		}
		else {
			return "";
		}
	}

	public void setInputpt42(String inputpt42) {
		this.inputpt42 = inputpt42;
	}

	public String getInputpt43() {
		if (inputpt43!=null) {
			return inputpt43;
		}
		else {
			return "";
		}
	}

	public void setInputpt43(String inputpt43) {
		this.inputpt43 = inputpt43;
	}

	public String getInputpt44() {
		if (inputpt44!=null) {
			return inputpt44;
		}
		else {
			return "";
		}
	}

	public void setInputpt44(String inputpt44) {
		this.inputpt44 = inputpt44;
	}

	public String getInputpt45() {
		if (inputpt45!=null) {
			return inputpt45;
		}
		else {
			return "";
		}
	}

	public void setInputpt45(String inputpt45) {
		this.inputpt45 = inputpt45;
	}

	public String getInputpt46() {
		if (inputpt46!=null) {
			return inputpt46;
		}
		else {
			return "";
		}
	}

	public void setInputpt46(String inputpt46) {
		this.inputpt46 = inputpt46;
	}

	public String getInputpt47() {
		if (inputpt47!=null) {
			return inputpt47;
		}
		else {
			return "";
		}
	}

	public void setInputpt47(String inputpt47) {
		this.inputpt47 = inputpt47;
	}

	public String getInputpt48() {
		if (inputpt48!=null) {
			return inputpt48;
		}
		else {
			return "";
		}
	}

	public void setInputpt48(String inputpt48) {
		this.inputpt48 = inputpt48;
	}

	public String getInputpt49() {
		if (inputpt49!=null) {
			return inputpt49;
		}
		else {
			return "";
		}
	}

	public void setInputpt49(String inputpt49) {
		this.inputpt49 = inputpt49;
	}

	public String getInputpt50() {
		if (inputpt50!=null) {
			return inputpt50;
		}
		else {
			return "";
		}
	}

	public void setInputpt50(String inputpt50) {
		this.inputpt50 = inputpt50;
	}

	public String getInputpt51() {
		if (inputpt51!=null) {
			return inputpt51;
		}
		else {
			return "";
		}
	}

	public void setInputpt51(String inputpt51) {
		this.inputpt51 = inputpt51;
	}

	public String getInputpt52() {
		if (inputpt52!=null) {
			return inputpt52;
		}
		else {
			return "";
		}
	}

	public void setInputpt52(String inputpt52) {
		this.inputpt52 = inputpt52;
	}

	public String getInputpt53() {
		if (inputpt53!=null) {
			return inputpt53;
		}
		else {
			return "";
		}
	}

	public void setInputpt53(String inputpt53) {
		this.inputpt53 = inputpt53;
	}

	public String getInputpt54() {
		if (inputpt54!=null) {
			return inputpt54;
		}
		else {
			return "";
		}
	}

	public void setInputpt54(String inputpt54) {
		this.inputpt54 = inputpt54;
	}

	public String getInputpt55() {
		if (inputpt55!=null) {
			return inputpt55;
		}
		else {
			return "";
		}
	}

	public void setInputpt55(String inputpt55) {
		this.inputpt55 = inputpt55;
	}

	public String getInputpt56() {
		if (inputpt56!=null) {
			return inputpt56;
		}
		else {
			return "";
		}
	}

	public void setInputpt56(String inputpt56) {
		this.inputpt56 = inputpt56;
	}

	public String getInputpt57() {
		if (inputpt57!=null) {
			return inputpt57;
		}
		else {
			return "";
		}
	}

	public void setInputpt57(String inputpt57) {
		this.inputpt57 = inputpt57;
	}

	public String getInputpt58() {
		if (inputpt58!=null) {
			return inputpt58;
		}
		else {
			return "";
		}
	}

	public void setInputpt58(String inputpt58) {
		this.inputpt58 = inputpt58;
	}

	public String getInputpt59() {
		if (inputpt59!=null) {
			return inputpt59;
		}
		else {
			return "";
		}
	}

	public void setInputpt59(String inputpt59) {
		this.inputpt59 = inputpt59;
	}

	public String getInputpt60() {
		if (inputpt60!=null) {
			return inputpt60;
		}
		else {
			return "";
		}
	}

	public void setInputpt60(String inputpt60) {
		this.inputpt60 = inputpt60;
	}

	public String getInputpt61() {
		if (inputpt61!=null) {
			return inputpt61;
		}
		else {
			return "";
		}
	}

	public void setInputpt61(String inputpt61) {
		this.inputpt61 = inputpt61;
	}

	public String getInputpt62() {
		if (inputpt62!=null) {
			return inputpt62;
		}
		else {
			return "";
		}
	}

	public void setInputpt62(String inputpt62) {
		this.inputpt62 = inputpt62;
	}

	public String getInputpt63() {
		if (inputpt63!=null) {
			return inputpt63;
		}
		else {
			return "";
		}
	}

	public void setInputpt63(String inputpt63) {
		this.inputpt63 = inputpt63;
	}

	public String getInputpt64() {
		if (inputpt64!=null) {
			return inputpt64;
		}
		else {
			return "";
		}
	}

	public void setInputpt64(String inputpt64) {
		this.inputpt64 = inputpt64;
	}

	public String getInputpt65() {
		if (inputpt65!=null) {
			return inputpt65;
		}
		else {
			return "";
		}
	}

	public void setInputpt65(String inputpt65) {
		this.inputpt65 = inputpt65;
	}

	
	
	
	
	
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(criteriaId, inputpt1, inputpt10, inputpt11, inputpt12, inputpt13, inputpt14, inputpt15,
				inputpt16, inputpt17, inputpt18, inputpt19, inputpt2, inputpt20, inputpt21, inputpt22, inputpt23,
				inputpt24, inputpt25, inputpt26, inputpt27, inputpt28, inputpt29, inputpt3, inputpt30, inputpt31,
				inputpt32, inputpt33, inputpt34, inputpt35, inputpt36, inputpt37, inputpt38, inputpt39, inputpt4,
				inputpt40, inputpt41, inputpt42, inputpt43, inputpt44, inputpt45, inputpt46, inputpt47, inputpt48,
				inputpt49, inputpt5, inputpt50, inputpt51, inputpt52, inputpt53, inputpt54, inputpt55, inputpt56,
				inputpt57, inputpt58, inputpt59, inputpt6, inputpt60, inputpt61, inputpt62, inputpt63, inputpt64,
				inputpt65, inputpt7, inputpt8, inputpt9, uniqueKey1);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Profile other = (Profile) obj;
		return Objects.equals(criteriaId, other.criteriaId) && Objects.equals(inputpt1, other.inputpt1)
				&& Objects.equals(inputpt10, other.inputpt10) && Objects.equals(inputpt11, other.inputpt11)
				&& Objects.equals(inputpt12, other.inputpt12) && Objects.equals(inputpt13, other.inputpt13)
				&& Objects.equals(inputpt14, other.inputpt14) && Objects.equals(inputpt15, other.inputpt15)
				&& Objects.equals(inputpt16, other.inputpt16) && Objects.equals(inputpt17, other.inputpt17)
				&& Objects.equals(inputpt18, other.inputpt18) && Objects.equals(inputpt19, other.inputpt19)
				&& Objects.equals(inputpt2, other.inputpt2) && Objects.equals(inputpt20, other.inputpt20)
				&& Objects.equals(inputpt21, other.inputpt21) && Objects.equals(inputpt22, other.inputpt22)
				&& Objects.equals(inputpt23, other.inputpt23) && Objects.equals(inputpt24, other.inputpt24)
				&& Objects.equals(inputpt25, other.inputpt25) && Objects.equals(inputpt26, other.inputpt26)
				&& Objects.equals(inputpt27, other.inputpt27) && Objects.equals(inputpt28, other.inputpt28)
				&& Objects.equals(inputpt29, other.inputpt29) && Objects.equals(inputpt3, other.inputpt3)
				&& Objects.equals(inputpt30, other.inputpt30) && Objects.equals(inputpt31, other.inputpt31)
				&& Objects.equals(inputpt32, other.inputpt32) && Objects.equals(inputpt33, other.inputpt33)
				&& Objects.equals(inputpt34, other.inputpt34) && Objects.equals(inputpt35, other.inputpt35)
				&& Objects.equals(inputpt36, other.inputpt36) && Objects.equals(inputpt37, other.inputpt37)
				&& Objects.equals(inputpt38, other.inputpt38) && Objects.equals(inputpt39, other.inputpt39)
				&& Objects.equals(inputpt4, other.inputpt4) && Objects.equals(inputpt40, other.inputpt40)
				&& Objects.equals(inputpt41, other.inputpt41) && Objects.equals(inputpt42, other.inputpt42)
				&& Objects.equals(inputpt43, other.inputpt43) && Objects.equals(inputpt44, other.inputpt44)
				&& Objects.equals(inputpt45, other.inputpt45) && Objects.equals(inputpt46, other.inputpt46)
				&& Objects.equals(inputpt47, other.inputpt47) && Objects.equals(inputpt48, other.inputpt48)
				&& Objects.equals(inputpt49, other.inputpt49) && Objects.equals(inputpt5, other.inputpt5)
				&& Objects.equals(inputpt50, other.inputpt50) && Objects.equals(inputpt51, other.inputpt51)
				&& Objects.equals(inputpt52, other.inputpt52) && Objects.equals(inputpt53, other.inputpt53)
				&& Objects.equals(inputpt54, other.inputpt54) && Objects.equals(inputpt55, other.inputpt55)
				&& Objects.equals(inputpt56, other.inputpt56) && Objects.equals(inputpt57, other.inputpt57)
				&& Objects.equals(inputpt58, other.inputpt58) && Objects.equals(inputpt59, other.inputpt59)
				&& Objects.equals(inputpt6, other.inputpt6) && Objects.equals(inputpt60, other.inputpt60)
				&& Objects.equals(inputpt61, other.inputpt61) && Objects.equals(inputpt62, other.inputpt62)
				&& Objects.equals(inputpt63, other.inputpt63) && Objects.equals(inputpt64, other.inputpt64)
				&& Objects.equals(inputpt65, other.inputpt65) && Objects.equals(inputpt7, other.inputpt7)
				&& Objects.equals(inputpt8, other.inputpt8) && Objects.equals(inputpt9, other.inputpt9)
				&& uniqueKey1 == other.uniqueKey1;
	}

	
	
	
	
	
	
	
}
