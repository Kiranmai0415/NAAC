package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="yeartable5232")
public class YearTable5232 implements Serializable
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
    private String input5232y;
	
	@Column(name = "students_appearing")
    private String input5232v;
	
	


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


	public String getInput5232y() {
		  if (input5232y!=null) {
		return input5232y;
		  }
		  else {
			return "";
		}
	}


	public void setInput5232y(String input5232y) {
		this.input5232y = input5232y;
	}


	public String getInput5232v() {
		if (input5232v!=null) {
			return input5232v;
		}
		else {
			return "";
		}
		
	}


	public void setInput5232v(String input5232v) {
		this.input5232v = input5232v;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	@Override
	public int hashCode() {
		return Objects.hash(criteriaId, input5232v, input5232y, uniqueKey1);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		YearTable5232 other = (YearTable5232) obj;
		return Objects.equals(criteriaId, other.criteriaId) && Objects.equals(input5232v, other.input5232v)
				&& Objects.equals(input5232y, other.input5232y) && uniqueKey1 == other.uniqueKey1;
	}


	
	
}
