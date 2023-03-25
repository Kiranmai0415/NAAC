package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="affiliated_teachingstaff")
public class AffiliatedTeachingstaff implements Serializable
{
	private static final long serialVersionUID = 2458692497580148528L;
	private CriteriaPrimaryKey criteriaId;
	
 	@Id
    @Column(name="unique_key1")
	private long uniqueKey1;
	
	
	@Column(name="highest_qualification")
	private String inputatso;
	
	@Column(name="Professior_male")
	private String inputats1;
	
	@Column(name="Professior_Female")
	private String inputats2;
	
	
	@Column(name="AssociateProfessior_male")
	private String inputats3;
	@Column(name="AssociateProfessior_Female")
	private String inputats4;
	
	@Column(name="AssistantProfessior_male")
	private String inputats5;
	
	@Column(name="AssistantProfessior_Female")
	private String inputats6;
	
	@Column(name="total")
	private String inputats7;
	
	

	
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

	public String getInputatso() {
		if(inputatso !=null) {
		return inputatso;
	}else {
		return "";
	}
	}

	public void setInputatso(String inputatso) {
		this.inputatso = inputatso;
	}

	public String getInputats1() {
		if(inputats1 !=null) {
		return inputats1;
	}else {
		return "";
	}
	}

	public void setInputats1(String inputats1) {
		this.inputats1 = inputats1;
	}

	public String getInputats2() {
		if(inputats2 !=null) {
		return inputats2;
	}else {
		return "";
	}
	}

	public void setInputats2(String inputats2) {
		this.inputats2 = inputats2;
	}

	public String getInputats3() {
		if(inputats3 !=null) {
		return inputats3;
	}else {
		return "";
	}
	}

	public void setInputats3(String inputats3) {
		this.inputats3 = inputats3;
	}

	public String getInputats4() {
		if(inputats4 !=null) {
		return inputats4;
	}else {
		return "";
	}
	}

	public void setInputats4(String inputats4) {
		this.inputats4 = inputats4;
	}

	public String getInputats5() {
		if(inputats5 !=null) {
		return inputats5;
	}else {
		return "";
	}
	}

	public void setInputats5(String inputats5) {
		this.inputats5 = inputats5;
	}

	public String getInputats6() {
		if(inputats6 !=null) {
		return inputats6;
	}else {
		return "";
	}
	}

	public void setInputats6(String inputats6) {
		this.inputats6 = inputats6;
	}

	public String getInputats7() {
		if(inputats7 !=null) {
		return inputats7;
	}else {
		return "";
	}
	}

	public void setInputats7(String inputats7) {
		this.inputats7 = inputats7;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(criteriaId, inputats1, inputats2, inputats3, inputats4, inputats5, inputats6, inputats7,
				inputatso, uniqueKey1);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AffiliatedTeachingstaff other = (AffiliatedTeachingstaff) obj;
		return Objects.equals(criteriaId, other.criteriaId) && Objects.equals(inputats1, other.inputats1)
				&& Objects.equals(inputats2, other.inputats2) && Objects.equals(inputats3, other.inputats3)
				&& Objects.equals(inputats4, other.inputats4) && Objects.equals(inputats5, other.inputats5)
				&& Objects.equals(inputats6, other.inputats6) && Objects.equals(inputats7, other.inputats7)
				&& Objects.equals(inputatso, other.inputatso) && uniqueKey1 == other.uniqueKey1;
	}

	
	


}