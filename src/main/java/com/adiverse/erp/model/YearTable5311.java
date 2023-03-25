package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="yeartable5311")
public class YearTable5311 implements Serializable
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
    private String input5311y;
	
	@Column(name = "inter_university")
    private String input5311v;
	

	public String getInput5311y() {
		  if (input5311v!=null) {
		return input5311y;
		  }
		  else {
			return "";
		}
	}
	public void setInput5311y(String input5311y) {
		this.input5311y = input5311y;
	}
	public String getInput5311v() {
        if (input5311v!=null) {
        	return input5311v;
		}
        else {
			return "";
		}
		
	}
	public void setInput5311v(String input5311v) {
		this.input5311v = input5311v;
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
		return Objects.hash(criteriaId, input5311v, input5311y, uniqueKey1);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		YearTable5311 other = (YearTable5311) obj;
		return Objects.equals(criteriaId, other.criteriaId) && Objects.equals(input5311v, other.input5311v)
				&& Objects.equals(input5311y, other.input5311y) && uniqueKey1 == other.uniqueKey1;
	}
	
	
		
}
