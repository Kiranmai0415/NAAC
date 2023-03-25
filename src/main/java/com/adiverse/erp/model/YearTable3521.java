package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="yeartable3521")
public class YearTable3521 implements Serializable
{
	private static final long serialVersionUID = 1L;

	private CriteriaPrimaryKey criteriaId;
	
	@Id
	@Column(name="unique_key1")
	private long uniqueKey1;
	
	@Column(name="year")
	private String input3521y;
	
	@Column(name = "amount_spent")
    private String input3521v;



	public String getInput3521y() {
		if (input3521y!=null) {
			return input3521y;
		}
		else {
			return "";
		}
		
	}

	public void setInput3521y(String input3521y) {
		this.input3521y = input3521y;
	}

	public String getInput3521v() {
		if (input3521v!=null) {
			return input3521v;
		}
		else {
			return "";
		}
		
	}

	public void setInput3521v(String input3521v) {
		this.input3521v = input3521v;
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
		return Objects.hash(criteriaId, input3521v, input3521y, uniqueKey1);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		YearTable3521 other = (YearTable3521) obj;
		return Objects.equals(criteriaId, other.criteriaId) && Objects.equals(input3521v, other.input3521v)
				&& Objects.equals(input3521y, other.input3521y) && uniqueKey1 == other.uniqueKey1;
	}

	

}
