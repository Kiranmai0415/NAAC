package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="basic_profile2")
public class basicprofile_2 implements Serializable
{
	private static final long serialVersionUID = 3169055891249182027L;

	private CriteriaPrimaryKey criteriaId;
	
 	@Id
    @Column(name="unique_key1")
	private long uniqueKey1;
	
	@Column(name="ugcpotentialfor_excellence")
	private String inputbtip1;
	
	@Column(name="CPE")
	private String inputbtip2;
	
	@Column(name="dateofrecognition_date")
	private String  inputbtip3;
	
	@Column(name="government_agency")
	private String inputbtip4;
	
	@Column(name="nametheagency_name")
	private String inputbtip5;
	
	@Column(name="recognition_date")
	private String inputbtip6;

	

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

	public String getInputbtip1() {
		if(inputbtip1 !=null) {
		return inputbtip1;
	}else {
		return "";
	}
	}

	public void setInputbtip1(String inputbtip1) {
		this.inputbtip1 = inputbtip1;
	}

	public String getInputbtip2() {
		if(inputbtip2 !=null) {
		return inputbtip2;
	}else {
		return "";
	}
	}

	public void setInputbtip2(String inputbtip2) {
		this.inputbtip2 = inputbtip2;
	}

	public String getInputbtip3() {
		if(inputbtip3 !=null) {
		return inputbtip3;
	}else {
		return "";
	}
	}

	public void setInputbtip3(String inputbtip3) {
		this.inputbtip3 = inputbtip3;
	}

	public String getInputbtip4() {
		if(inputbtip4 !=null) {
		return inputbtip4;
	}else {
		return "";
	}
	}

	public void setInputbtip4(String inputbtip4) {
		this.inputbtip4 = inputbtip4;
	}

	public String getInputbtip5() {
		if(inputbtip5  !=null) {
		return inputbtip5;
	}else {
		return "";
	}
	}

	public void setInputbtip5(String inputbtip5) {
		this.inputbtip5 = inputbtip5;
	}

	public String getInputbtip6() {
		if(inputbtip6  !=null) {
		return inputbtip6;
	}else {
		return "";
	}
	}

	public void setInputbtip6(String inputbtip6) {
		this.inputbtip6 = inputbtip6;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(criteriaId, inputbtip1, inputbtip2, inputbtip3, inputbtip4, inputbtip5, inputbtip6,
				uniqueKey1);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		basicprofile_2 other = (basicprofile_2) obj;
		return Objects.equals(criteriaId, other.criteriaId) && Objects.equals(inputbtip1, other.inputbtip1)
				&& Objects.equals(inputbtip2, other.inputbtip2) && Objects.equals(inputbtip3, other.inputbtip3)
				&& Objects.equals(inputbtip4, other.inputbtip4) && Objects.equals(inputbtip5, other.inputbtip5)
				&& Objects.equals(inputbtip6, other.inputbtip6) && uniqueKey1 == other.uniqueKey1;
	}
	
	
	
	
	
}