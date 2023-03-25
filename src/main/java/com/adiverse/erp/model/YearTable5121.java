package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="yeartable5121")
public class YearTable5121 implements Serializable
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
    private String input5121y;
	@Column(name = "non_government_agencies")
    private String input5121v;
	
	
	
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
	public String getInput5121y() {
		if (input5121y!=null) {
			return input5121y;
		}
		else {
			return "";
		}
		
	}
	public void setInput5121y(String input5121y) {
		this.input5121y = input5121y;
	}
	public String getInput5121v() {
		if (input5121v!=null) {
			return input5121v;
		}else {
			return "";
		}
	
	}
	public void setInput5121v(String input5121v) {
		this.input5121v = input5121v;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public int hashCode() {
		return Objects.hash(criteriaId, input5121v, input5121y, uniqueKey1);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		YearTable5121 other = (YearTable5121) obj;
		return Objects.equals(criteriaId, other.criteriaId) && Objects.equals(input5121v, other.input5121v)
				&& Objects.equals(input5121y, other.input5121y) && uniqueKey1 == other.uniqueKey1;
	}

	
}
