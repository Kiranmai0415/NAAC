package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="yeartable3641")
public class YearTable3641 implements Serializable
{
	private static final long serialVersionUID = 1L;

	private CriteriaPrimaryKey criteriaId;
	
	@Id
	@Column(name="unique_key1")
	private long uniqueKey1;
	
	@Column(name="year")
	private String input3641y;
	
	@Column(name = "extension_activities")
    private String input3641v;

	
	

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

	public String getInput3641y() {
		if (input3641y!=null) {
			return input3641y;
		}
		else {
			return "";
		}
		
	}

	public void setInput3641y(String input3641y) {
		this.input3641y = input3641y;
	}

	public String getInput3641v() {
		if (input3641v!=null) {
			return input3641v;
		}
		else {
			return "";
		}
	}

	public void setInput3641v(String input3641v) {
		this.input3641v = input3641v;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(criteriaId, input3641v, input3641y, uniqueKey1);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		YearTable3641 other = (YearTable3641) obj;
		return Objects.equals(criteriaId, other.criteriaId) && Objects.equals(input3641v, other.input3641v)
				&& Objects.equals(input3641y, other.input3641y) && uniqueKey1 == other.uniqueKey1;
	}

	
	
}
