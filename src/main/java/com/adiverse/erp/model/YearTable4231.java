package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="yeartable4231")
public class YearTable4231 implements Serializable
{
	private static final long serialVersionUID = 1L;

	private CriteriaPrimaryKey criteriaId;
	
    @Id
    @Column(name="unique_key1")
	private long uniqueKey1;
	
	@Column(name = "year")
    private String input4231y;
	@Column(name = "books_ebooks")
    private String input4231v;
	
	
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
	public String getInput4231y() {
		if (input4231y!=null) {
			return input4231y;
		}
		else {
			return "";
		}
		
	}
	public void setInput4231y(String input4231y) {
		this.input4231y = input4231y;
	}
	public String getInput4231v() {
		if (input4231v!=null) {
			return input4231v;
		}
		else {
			return "";
		}
		
	}
	public void setInput4231v(String input4231v) {
		this.input4231v = input4231v;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public int hashCode() {
		return Objects.hash(criteriaId, input4231v, input4231y, uniqueKey1);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		YearTable4231 other = (YearTable4231) obj;
		return Objects.equals(criteriaId, other.criteriaId) && Objects.equals(input4231v, other.input4231v)
				&& Objects.equals(input4231y, other.input4231y) && uniqueKey1 == other.uniqueKey1;
	}
	
}
