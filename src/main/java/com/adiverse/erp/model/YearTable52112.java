package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="yeartable52112")
public class YearTable52112 implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private CriteriaPrimaryKey criteriaId;
	
    @Id
    @Column(name="unique_key1")
	private long uniqueKey1;
	
	@Column(name = "year")
    private String input52112y;
	@Column(name = "outgoing_students_1")
    private String input52112v;
	
	
	
	public String getInput52112y() {
		if ( input52112y!=null) {
			return input52112y;
		}else {
			return "";
		}
		
	}
	public void setInput52112y(String input52112y) {
		this.input52112y = input52112y;
	}
	public String getInput52112v() {
		if (input52112v!=null) {
			return input52112v;
		}
		else {
			return "";
		}
	}
	public void setInput52112v(String input52112v) {
		this.input52112v = input52112v;
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
		return Objects.hash(criteriaId, input52112v, input52112y, uniqueKey1);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		YearTable52112 other = (YearTable52112) obj;
		return Objects.equals(criteriaId, other.criteriaId) && Objects.equals(input52112v, other.input52112v)
				&& Objects.equals(input52112y, other.input52112y) && uniqueKey1 == other.uniqueKey1;
	}
	
	
}
