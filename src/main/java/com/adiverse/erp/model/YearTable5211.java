package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="yeartable5211")
public class YearTable5211 implements Serializable
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
    private String input5211y;
	@Column(name = "outgoing_students")
    private String input5211v;
	
	
	
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
	public String getInput5211y() {
		if (input5211y!=null) {
			return input5211y;
		}else {
			return "";
		}
		
	}
	public void setInput5211y(String input5211y) {
		this.input5211y = input5211y;
	}
	public String getInput5211v() {
		if (input5211v!=null) {
			return input5211v;
		}else {
		return "";
		}
	}
	public void setInput5211v(String input5211v) {
		this.input5211v = input5211v;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public int hashCode() {
		return Objects.hash(criteriaId, input5211v, input5211y, uniqueKey1);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		YearTable5211 other = (YearTable5211) obj;
		return Objects.equals(criteriaId, other.criteriaId) && Objects.equals(input5211v, other.input5211v)
				&& Objects.equals(input5211y, other.input5211y) && uniqueKey1 == other.uniqueKey1;
	}
	
}
