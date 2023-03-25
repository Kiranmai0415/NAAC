package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="yeartable2121")
public class YearTable2121 implements Serializable
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
    private String input2121y;
	@Column(name = "reserved_categories")
    private String input2121v;
	
	

	public String getInput2121y() {
		if (input2121y!=null) {
			return input2121y;
		}
		else {
			return "";
		}
		
	}
	public void setInput2121y(String input2121y) {
		this.input2121y = input2121y;
	}
	public String getInput2121v() {
		if (input2121v!=null) {
			return input2121v;
		}
		else {
			return "";
		}
		
	}
	public void setInput2121v(String input2121v) {
		this.input2121v = input2121v;
		
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
		return Objects.hash(criteriaId, input2121v, input2121y, uniqueKey1);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		YearTable2121 other = (YearTable2121) obj;
		return Objects.equals(criteriaId, other.criteriaId) && Objects.equals(input2121v, other.input2121v)
				&& Objects.equals(input2121y, other.input2121y) && uniqueKey1 == other.uniqueKey1;
	}
	
}
