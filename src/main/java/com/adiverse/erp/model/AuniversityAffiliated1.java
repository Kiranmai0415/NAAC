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
@Table(name="auniversityaffiliated1")
public class AuniversityAffiliated1 implements Serializable
{
	private static final long serialVersionUID = -2231411273570309611L;

	private CriteriaPrimaryKey criteriaId;
	
 	@Id
    @Column(name="unique_key1")
	private long uniqueKey1;
	
	
	@Column(name="typeof_colleges")
	private String inputa2t1;
	
	@Column(name="permanent")
	private String inputa2t2;
	
	@Column(name="temporary")
	private String inputa2t3;

	@Column(name="total")
	private String inputa2t4;

	

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

	public String getInputa2t1() {
		if(inputa2t1 !=null) {
		return inputa2t1;
	}else {
		return "";
	}
	}

	public void setInputa2t1(String inputa2t1) {
		this.inputa2t1 = inputa2t1;
	}

	public String getInputa2t2() {
		if(inputa2t2 !=null) {
		return inputa2t2;
	}else {
		return "";
	}
	}

	public void setInputa2t2(String inputa2t2) {
		this.inputa2t2 = inputa2t2;
	}

	public String getInputa2t3() {
		if(inputa2t3 !=null) {
		return inputa2t3;
	}else {
		return "";
	}
	}

	public void setInputa2t3(String inputa2t3) {
		this.inputa2t3 = inputa2t3;
	}

	public String getInputa2t4() {
		if(inputa2t4 !=null) {
		return inputa2t4;
	}else {
		return "";
	}
	}

	public void setInputa2t4(String inputa2t4) {
		this.inputa2t4 = inputa2t4;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(criteriaId, inputa2t1, inputa2t2, inputa2t3, inputa2t4, uniqueKey1);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AuniversityAffiliated1 other = (AuniversityAffiliated1) obj;
		return Objects.equals(criteriaId, other.criteriaId) && Objects.equals(inputa2t1, other.inputa2t1)
				&& Objects.equals(inputa2t2, other.inputa2t2) && Objects.equals(inputa2t3, other.inputa2t3)
				&& Objects.equals(inputa2t4, other.inputa2t4) && uniqueKey1 == other.uniqueKey1;
	}
	

	
}
