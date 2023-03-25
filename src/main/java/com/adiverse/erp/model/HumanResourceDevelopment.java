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
@Table(name="humanresourcedevelopment")
public class HumanResourceDevelopment implements Serializable
{
	private static final long serialVersionUID = -2231411273570309611L;
	private CriteriaPrimaryKey criteriaId;
	
 	@Id
    @Column(name="unique_key1")
	private long uniqueKey1;
	
	
	@Column(name="yearof_establishment")
	private String inputrdt1;
	
	@Column(name="orientation_programmes")
	private String inputrdt2;
	
	@Column(name="refresher_course")
	private String inputrdt3;
	
	
	@Column(name="own_programmes")
	private String inputrdt4;
	
	@Column(name="programmes_conducted")
	private String  inputrdt5;

	

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

	public String getInputrdt1() {
		if(inputrdt1 !=null) {
			return inputrdt1;
		}else {
			return "";
		}
	}

	public void setInputrdt1(String inputrdt1) {
		this.inputrdt1 = inputrdt1;
	}

	public String getInputrdt2() {
		if(inputrdt2 !=null) {
			return inputrdt2;
		}else {
			return "";
		}
	}

	public void setInputrdt2(String inputrdt2) {
		this.inputrdt2 = inputrdt2;
	}

	public String getInputrdt3() {
		if(inputrdt3 !=null) {
			return inputrdt3;
		}else {
			return "";
		}
	}

	public void setInputrdt3(String inputrdt3) {
		this.inputrdt3 = inputrdt3;
	}

	public String getInputrdt4() {
		if(inputrdt4 !=null) {
			return inputrdt4;
		}else {
			return "";
		}
	}

	public void setInputrdt4(String inputrdt4) {
		this.inputrdt4 = inputrdt4;
	}

	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getInputrdt5() {
		return inputrdt5;
	}

	public void setInputrdt5(String inputrdt5) {
		this.inputrdt5 = inputrdt5;
	}

	@Override
	public int hashCode() {
		return Objects.hash(criteriaId, inputrdt1, inputrdt2, inputrdt3, inputrdt4, inputrdt5, uniqueKey1);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HumanResourceDevelopment other = (HumanResourceDevelopment) obj;
		return Objects.equals(criteriaId, other.criteriaId) && Objects.equals(inputrdt1, other.inputrdt1)
				&& Objects.equals(inputrdt2, other.inputrdt2) && Objects.equals(inputrdt3, other.inputrdt3)
				&& Objects.equals(inputrdt4, other.inputrdt4) && Objects.equals(inputrdt5, other.inputrdt5)
				&& uniqueKey1 == other.uniqueKey1;
	}

	
	
	
	
	
	

}
