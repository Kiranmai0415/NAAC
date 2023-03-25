package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="academic_institution")
public class AcademicInstitution implements Serializable
{
	private static final long serialVersionUID = 2458692497580148528L;
	private CriteriaPrimaryKey criteriaId;
	
 	@Id
    @Column(name="unique_key1")
	private long uniqueKey1;
	
	
	@Column(name="Contract")
	private String inputat00;
	
	@Column(name="Professior_male")
	private String inputat11;
	@Column(name="Professior_Female")
	private String inputat12;
	@Column(name="Professior_Others")
	private String inputat13;
	@Column(name="Professior_Total")
	private String inputat14;
	
	@Column(name="AssociateProfessior_male")
	private String inputat15;
	@Column(name="AssociateProfessior_Female")
	private String inputat16;
	@Column(name="AssociateProfessior_Others")
	private String inputat17;
	@Column(name="AssociateProfessior_Total")
	private String inputat18;
	
	@Column(name="AssistantProfessior_male")
	private String inputat19;
	@Column(name="AssistantProfessior_Female")
	private String inputat10;
	@Column(name="AssistantProfessior_Others")
	private String inputat111;
	@Column(name="AssistantProfessior_Total")
	private String inputat112;
	
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

	public String getInputat00() {
		if(inputat00 !=null) {
		return inputat00;
	}else {
		return "";
	}
	}

	public void setInputat00(String inputat00) {
		this.inputat00 = inputat00;
	}

	public String getInputat11() {
		if(inputat11 !=null) {
		return inputat11;
	}else {
		return "";
	}
	}

	public void setInputat11(String inputat11) {
		this.inputat11 = inputat11;
	}

	public String getInputat12() {
		if(inputat12 !=null) {
		return inputat12;
	}else {
		return "";
	}
	}

	public void setInputat12(String inputat12) {
		this.inputat12 = inputat12;
	}

	public String getInputat13() {
		if(inputat13 !=null) {
		return inputat13;
	}else {
		return "";
	}
	}

	public void setInputat13(String inputat13) {
		this.inputat13 = inputat13;
	}

	public String getInputat14() {
		if(inputat14 !=null) {
		return inputat14;
	}else {
		return "";
	}
	}

	public void setInputat14(String inputat14) {
		this.inputat14 = inputat14;
	}

	public String getInputat15() {
		if(inputat15 !=null) {
		return inputat15;
	}else {
		return "";
	}
	}

	public void setInputat15(String inputat15) {
		this.inputat15 = inputat15;
	}

	public String getInputat16() {
		if(inputat16 !=null) {
		return inputat16;
	}else {
		return "";
	}
	}

	public void setInputat16(String inputat16) {
		this.inputat16 = inputat16;
	}

	public String getInputat17() {
		if(inputat17 !=null) {
		return inputat17;
	}else {
		return "";
	}
	}

	public void setInputat17(String inputat17) {
		this.inputat17 = inputat17;
	}

	public String getInputat18() {
		if(inputat18 !=null) {
		return inputat18;
	}else {
		return "";
	}
	}

	public void setInputat18(String inputat18) {
		this.inputat18 = inputat18;
	}

	public String getInputat19() {
		if(inputat19 !=null) {
		return inputat19;
	}else {
		return "";
	}
	}

	public void setInputat19(String inputat19) {
		this.inputat19 = inputat19;
	}

	public String getInputat10() {
		if(inputat10 !=null) {
		return inputat10;
	}else {
		return "";
	}
	}

	public void setInputat10(String inputat10) {
		this.inputat10 = inputat10;
	}

	public String getInputat111() {
		if(inputat111 !=null) {
		return inputat111;
	}else {
		return "";
	}
			
	}

	public void setInputat111(String inputat111) {
		this.inputat111 = inputat111;
	}

	public String getInputat112() {
		if(inputat112 !=null) {
		return inputat112;
	}else {
		return "";
	}
	}

	public void setInputat112(String inputat112) {
		this.inputat112 = inputat112;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public int hashCode() {
		return Objects.hash(criteriaId, inputat00, inputat10, inputat11, inputat111, inputat112, inputat12, inputat13,
				inputat14, inputat15, inputat16, inputat17, inputat18, inputat19, uniqueKey1);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AcademicInstitution other = (AcademicInstitution) obj;
		return Objects.equals(criteriaId, other.criteriaId) && Objects.equals(inputat00, other.inputat00)
				&& Objects.equals(inputat10, other.inputat10) && Objects.equals(inputat11, other.inputat11)
				&& Objects.equals(inputat111, other.inputat111) && Objects.equals(inputat112, other.inputat112)
				&& Objects.equals(inputat12, other.inputat12) && Objects.equals(inputat13, other.inputat13)
				&& Objects.equals(inputat14, other.inputat14) && Objects.equals(inputat15, other.inputat15)
				&& Objects.equals(inputat16, other.inputat16) && Objects.equals(inputat17, other.inputat17)
				&& Objects.equals(inputat18, other.inputat18) && Objects.equals(inputat19, other.inputat19)
				&& uniqueKey1 == other.uniqueKey1;
	}
	

	
	
	
	
	
	
	


}