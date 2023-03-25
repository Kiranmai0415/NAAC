package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="yeartable5331")
public class YearTable5331 implements Serializable
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
    private String input5331y;
	@Column(name = "cultural_events")
    private String input5331v;
	
	
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
	public String getInput5331y() {
		if (input5331y!=null) {
		return input5331y;}
		else {
			return "";
		}
	}
	public void setInput5331y(String input5331y) {
		this.input5331y = input5331y;
	}
	public String getInput5331v() {
		if (input5331v!=null) {
		return input5331v;
		}
		else {
			return "";
		}
	}
	public void setInput5331v(String input5331v) {
		this.input5331v = input5331v;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public int hashCode() {
		return Objects.hash(criteriaId, input5331v, input5331y, uniqueKey1);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		YearTable5331 other = (YearTable5331) obj;
		return Objects.equals(criteriaId, other.criteriaId) && Objects.equals(input5331v, other.input5331v)
				&& Objects.equals(input5331y, other.input5331y) && uniqueKey1 == other.uniqueKey1;
	}
	
	
	
}
