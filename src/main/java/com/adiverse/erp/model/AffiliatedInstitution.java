package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="affiliated_institution")
public class AffiliatedInstitution implements Serializable
{
	private static final long serialVersionUID = 2458692497580148528L;
	private CriteriaPrimaryKey criteriaId;
	
 	@Id
    @Column(name="unique_key1")
	private long uniqueKey1;
	
	
	@Column(name="position")
	private String inputatto;
	
	@Column(name="Professior_male")
	private String inputatt1;
	
	@Column(name="Professior_Female")
	private String inputatt2;
	
	
	@Column(name="AssociateProfessior_male")
	private String inputatt3;
	@Column(name="AssociateProfessior_Female")
	private String inputatt4;
	
	@Column(name="AssistantProfessior_male")
	private String inputatt5;
	
	@Column(name="AssistantProfessior_Female")
	private String inputatt6;
	
	@Column(name="nonteaching_staff")
	private String inputatt7;
	
	
	@Column(name="technical_staff")
	private String inputatt8;


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


	public String getInputatto() {
		if(inputatto !=null) {
		return inputatto;
	}else {
		return "";
	}
	}


	public void setInputatto(String inputatto) {
		this.inputatto = inputatto;
	}


	public String getInputatt1() {
		if(inputatt1 !=null) {
		return inputatt1;
	}else {
		return "";
	}
	}


	public void setInputatt1(String inputatt1) {
		this.inputatt1 = inputatt1;
	}


	public String getInputatt2() {
		if(inputatt2 !=null) {
		return inputatt2;
	}else {
		return "";
	}
	}


	public void setInputatt2(String inputatt2) {
		this.inputatt2 = inputatt2;
	}


	public String getInputatt3() {
		if(inputatt3 !=null) {
		return inputatt3;
	}else {
		return "";
	}
	}


	public void setInputatt3(String inputatt3) {
		this.inputatt3 = inputatt3;
	}


	public String getInputatt4() {
		if(inputatt4 !=null) {
		return inputatt4;
	}else {
		return "";
	}
	}


	public void setInputatt4(String inputatt4) {
		this.inputatt4 = inputatt4;
	}


	public String getInputatt5() {
		if(inputatt5 !=null) {
		return inputatt5;
	}else {
		return "";
	}
	}


	public void setInputatt5(String inputatt5) {
		this.inputatt5 = inputatt5;
	}


	public String getInputatt6() {
		if(inputatt6 !=null) {
		return inputatt6;
	}else {
		return "";
	}
	}


	public void setInputatt6(String inputatt6) {
		this.inputatt6 = inputatt6;
	}


	public String getInputatt7() {
		if(inputatt7 !=null) {
		return inputatt7;
	}else {
		return "";
	}
	}


	public void setInputatt7(String inputatt7) {
		this.inputatt7 = inputatt7;
	}


	public String getInputatt8() {
		if(inputatt8 !=null) {
		return inputatt8;
	}else {
		return "";
	}
	}


	public void setInputatt8(String inputatt8) {
		this.inputatt8 = inputatt8;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	@Override
	public int hashCode() {
		return Objects.hash(criteriaId, inputatt1, inputatt2, inputatt3, inputatt4, inputatt5, inputatt6, inputatt7,
				inputatt8, inputatto, uniqueKey1);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AffiliatedInstitution other = (AffiliatedInstitution) obj;
		return Objects.equals(criteriaId, other.criteriaId) && Objects.equals(inputatt1, other.inputatt1)
				&& Objects.equals(inputatt2, other.inputatt2) && Objects.equals(inputatt3, other.inputatt3)
				&& Objects.equals(inputatt4, other.inputatt4) && Objects.equals(inputatt5, other.inputatt5)
				&& Objects.equals(inputatt6, other.inputatt6) && Objects.equals(inputatt7, other.inputatt7)
				&& Objects.equals(inputatt8, other.inputatt8) && Objects.equals(inputatto, other.inputatto)
				&& uniqueKey1 == other.uniqueKey1;
	}
	
	
	
	
	
	


}