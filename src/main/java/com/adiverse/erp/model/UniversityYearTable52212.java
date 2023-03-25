package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="universityyeartable52212")
public class UniversityYearTable52212 implements Serializable
{
	private static final long serialVersionUID = 1L;

	private CriteriaPrimaryKey criteriaId;
	
    @Id
    @Column(name="unique_key1")
	private long uniqueKey1;
	
	@Column(name="year")
	private String input52212y;
	
	@Column(name="students_placed2")
	private String input52212v;

	

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

	public String getInput52212y() {
		if (input52212y!=null) {
			return input52212y;
		}
		else {
			return "";
		}
		
	}

	public void setInput52212y(String input52212y) {
		this.input52212y = input52212y;
	}

	public String getInput52212v() {
		if (input52212v!=null) {
			return input52212v;
		}
		else {
			return "";
		}
		
	}

	public void setInput52212v(String input52212v) {
		this.input52212v = input52212v;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(criteriaId, input52212v, input52212y, uniqueKey1);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UniversityYearTable52212 other = (UniversityYearTable52212) obj;
		return Objects.equals(criteriaId, other.criteriaId) && Objects.equals(input52212v, other.input52212v)
				&& Objects.equals(input52212y, other.input52212y) && uniqueKey1 == other.uniqueKey1;
	}

	
	
}
