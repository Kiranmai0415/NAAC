package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="academic_ParttimeTeacheres")
public class AcademicParttimeTeacheres implements Serializable
{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private CriteriaPrimaryKey criteriaId;
	
 	@Id
    @Column(name="unique_key1")
	private long uniqueKey1;
	
 	@Column(name="parttime_professor_male")
	private String inputatq91;
	@Column(name="parttime_professor_female")
	private String inputatq92;
	@Column(name="parttime_professor_others")
	private String inputatq93;

	@Column(name="parttime_associate_male")
	private String inputatq94;
	@Column(name="parttime_associate_female")
	private String inputatq95;
	@Column(name="parttime_associate_others")
	private String inputatq96;
	
	@Column(name="parttime_assistant_male")
	private String inputatq97;
	@Column(name="parttime_assistant_female")
	private String inputatq98;
	@Column(name="parttime_assistant_others")
	private String inputatq99;
	
	@Column(name="parttime_total")
	private String inputatq910;

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

	public String getInputatq91() {
		if(inputatq91 !=null) {
		return inputatq91;
	}else {
		return "";
	}
	}

	public void setInputatq91(String inputatq91) {
		this.inputatq91 = inputatq91;
	}

	public String getInputatq92() {
		if(inputatq92 !=null) {
		return inputatq92;
	}else {
		return "";
	}
	}

	public void setInputatq92(String inputatq92) {
		this.inputatq92 = inputatq92;
	}

	public String getInputatq93() {
		if(inputatq93 !=null) {
		return inputatq93;
	}else {
		return "";
	}
	}

	public void setInputatq93(String inputatq93) {
		this.inputatq93 = inputatq93;
	}

	public String getInputatq94() {
		if(inputatq94 !=null) {
		return inputatq94;
	}else {
		return "";
	}
	}

	public void setInputatq94(String inputatq94) {
		this.inputatq94 = inputatq94;
	}

	public String getInputatq95() {
		if(inputatq95 !=null) {
		return inputatq95;
	}else {
		return "";
	}
	}

	public void setInputatq95(String inputatq95) {
		this.inputatq95 = inputatq95;
	}

	public String getInputatq96() {
		if(inputatq96 !=null) {
		return inputatq96;
	}else {
		return "";
	}
	}

	public void setInputatq96(String inputatq96) {
		this.inputatq96 = inputatq96;
	}

	public String getInputatq97() {
		if(inputatq97 !=null) {
		return inputatq97;
	}else {
		return "";
	}
	}

	public void setInputatq97(String inputatq97) {
		this.inputatq97 = inputatq97;
	}

	public String getInputatq98() {
		if(inputatq98 !=null) {
		return inputatq98;
	}else {
		return "";
	}
	}

	public void setInputatq98(String inputatq98) {
		this.inputatq98 = inputatq98;
	}

	public String getInputatq99() {
		if(inputatq99 !=null) {
		return inputatq99;
	}else {
		return "";
	}
	}

	public void setInputatq99(String inputatq99) {
		this.inputatq99 = inputatq99;
	}

	public String getInputatq910() {
		if(inputatq910 !=null) {
		return inputatq910;
	}else {
		return "";
	}
	}

	public void setInputatq910(String inputatq910) {
		this.inputatq910 = inputatq910;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(criteriaId, inputatq91, inputatq910, inputatq92, inputatq93, inputatq94, inputatq95,
				inputatq96, inputatq97, inputatq98, inputatq99, uniqueKey1);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AcademicParttimeTeacheres other = (AcademicParttimeTeacheres) obj;
		return Objects.equals(criteriaId, other.criteriaId) && Objects.equals(inputatq91, other.inputatq91)
				&& Objects.equals(inputatq910, other.inputatq910) && Objects.equals(inputatq92, other.inputatq92)
				&& Objects.equals(inputatq93, other.inputatq93) && Objects.equals(inputatq94, other.inputatq94)
				&& Objects.equals(inputatq95, other.inputatq95) && Objects.equals(inputatq96, other.inputatq96)
				&& Objects.equals(inputatq97, other.inputatq97) && Objects.equals(inputatq98, other.inputatq98)
				&& Objects.equals(inputatq99, other.inputatq99) && uniqueKey1 == other.uniqueKey1;
	}

	
	
	
}