package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="yeartable24112")
public class YearTable24112 implements Serializable
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
    private String input24112y;
	@Column(name = "sanctioned_posts")
    private String input24112v;
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
	public String getInput24112y() {
		if (input24112y!=null) {
			return input24112y;
		}
		else {
			return "";
		}
		
	}
	public void setInput24112y(String input24112y) {
		this.input24112y = input24112y;
	}
	public String getInput24112v() {
		if (input24112v!=null) {
			return input24112v;
		}
		else {
			return "";
		}
		
	}
	public void setInput24112v(String input24112v) {
		this.input24112v = input24112v;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public int hashCode() {
		return Objects.hash(criteriaId, input24112v, input24112y, uniqueKey1);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		YearTable24112 other = (YearTable24112) obj;
		return Objects.equals(criteriaId, other.criteriaId) && Objects.equals(input24112v, other.input24112v)
				&& Objects.equals(input24112y, other.input24112y) && uniqueKey1 == other.uniqueKey1;
	}
	

	
	
}
