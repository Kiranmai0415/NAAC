package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="universityyeartable3331")
public class UniversityYearTable3331 implements Serializable
{
	private static final long serialVersionUID = 1L;

	private CriteriaPrimaryKey criteriaId;
	
	@Id
	@Column(name="unique_key1")
	private long uniqueKey1;
	
	@Column(name="year")
	private String input3331y;
	
	@Column(name = "awards_recognitions")
    private String input3331v;


	public String getInput3331y() {
		if (input3331y!=null) {
			return input3331y;
		}
		else {
			return "";
		}
		
	}

	public void setInput3331y(String input3331y) {
		this.input3331y = input3331y;
	}

	public String getInput3331v() {
		if (input3331v!=null) {
			return input3331v;
		}
		else {
			return "";
		}
		
	}

	public void setInput3331v(String input3331v) {
		this.input3331v = input3331v;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

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

	@Override
	public int hashCode() {
		return Objects.hash(criteriaId, input3331v, input3331y, uniqueKey1);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UniversityYearTable3331 other = (UniversityYearTable3331) obj;
		return Objects.equals(criteriaId, other.criteriaId) && Objects.equals(input3331v, other.input3331v)
				&& Objects.equals(input3331y, other.input3331y) && uniqueKey1 == other.uniqueKey1;
	}

	
}
