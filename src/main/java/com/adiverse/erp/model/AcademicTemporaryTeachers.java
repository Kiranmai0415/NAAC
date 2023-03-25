package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="academic_temporaryTeachers")
public class AcademicTemporaryTeachers implements Serializable
{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private CriteriaPrimaryKey criteriaId;
	
 	@Id
    @Column(name="unique_key1")
	private long uniqueKey1;
	
 	@Column(name="temporary_professor_male")
	private String inputatq51;
	@Column(name="temporary_professor_female")
	private String inputatq52;
	@Column(name="temporary_professor_others")
	private String inputatq53;

	@Column(name="temporary_associate_male")
	private String inputatq54;
	@Column(name="temporary_associate_female")
	private String inputatq55;
	@Column(name="temporary_associate_others")
	private String inputatq56;
	
	@Column(name="temporary_assistant_male")
	private String inputatq57;
	@Column(name="temporary_assistant_female")
	private String inputatq58;
	@Column(name="temporary_assistant_others")
	private String inputatq59;
	
	@Column(name="temporary_total")
	private String inputatq510;

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

	public String getInputatq51() {
		if(inputatq51 !=null) {
		return inputatq51;
	}else {
		return "";
	}
	}

	public void setInputatq51(String inputatq51) {
		this.inputatq51 = inputatq51;
	}

	public String getInputatq52() {
		if(inputatq52 !=null) {
		return inputatq52;
	}else {
		return "";
	}
	}

	public void setInputatq52(String inputatq52) {
		this.inputatq52 = inputatq52;
	}

	public String getInputatq53() {
		if(inputatq53 !=null) {
		return inputatq53;
	}else {
		return "";
	}
	}

	public void setInputatq53(String inputatq53) {
		this.inputatq53 = inputatq53;
	}

	public String getInputatq54() {
		if(inputatq54 !=null) {
		return inputatq54;
	}else {
		return "";
	}
	}

	public void setInputatq54(String inputatq54) {
		this.inputatq54 = inputatq54;
	}

	public String getInputatq55() {
		if(inputatq55 !=null) {
		return inputatq55;
	}else {
		return "";
	}
	}

	public void setInputatq55(String inputatq55) {
		this.inputatq55 = inputatq55;
	}

	public String getInputatq56() {
		if(inputatq56 !=null) {
		return inputatq56;
	}else {
		return "";
	}
	}

	public void setInputatq56(String inputatq56) {
		this.inputatq56 = inputatq56;
	}

	public String getInputatq57() {
		if(inputatq57 !=null) {
		return inputatq57;
	}else {
		return "";
	}
	}

	public void setInputatq57(String inputatq57) {
		this.inputatq57 = inputatq57;
	}

	public String getInputatq58() {
		if(inputatq58 !=null) {
		return inputatq58;
	}else{
		return "";
	}
	}

	public void setInputatq58(String inputatq58) {
		this.inputatq58 = inputatq58;
	}

	public String getInputatq59() {
		if(inputatq59 !=null) {
		return inputatq59;
	}else {
		return "";
	}
	}

	public void setInputatq59(String inputatq59) {
		this.inputatq59 = inputatq59;
	}

	public String getInputatq510() {
		if(inputatq510 !=null) {
		return inputatq510;
	}else {
		return "";
	}
	}

	public void setInputatq510(String inputatq510) {
		this.inputatq510 = inputatq510;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(criteriaId, inputatq51, inputatq510, inputatq52, inputatq53, inputatq54, inputatq55,
				inputatq56, inputatq57, inputatq58, inputatq59, uniqueKey1);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AcademicTemporaryTeachers other = (AcademicTemporaryTeachers) obj;
		return Objects.equals(criteriaId, other.criteriaId) && Objects.equals(inputatq51, other.inputatq51)
				&& Objects.equals(inputatq510, other.inputatq510) && Objects.equals(inputatq52, other.inputatq52)
				&& Objects.equals(inputatq53, other.inputatq53) && Objects.equals(inputatq54, other.inputatq54)
				&& Objects.equals(inputatq55, other.inputatq55) && Objects.equals(inputatq56, other.inputatq56)
				&& Objects.equals(inputatq57, other.inputatq57) && Objects.equals(inputatq58, other.inputatq58)
				&& Objects.equals(inputatq59, other.inputatq59) && uniqueKey1 == other.uniqueKey1;
	}
	
	

	
	
}