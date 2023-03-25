package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="yeartable6331")
public class YearTable6331 implements Serializable
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
    private String input6331y;
	@Column(name = "development_administrative")
    private String input6331v;
	
	
	
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
	public String getInput6331y() {
		if(input6331y !=null)
		{
		return input6331y;
		}
		else 
		{
			return "";
		}
	}
	public void setInput6331y(String input6331y) {
		this.input6331y = input6331y;
	}
	public String getInput6331v() {
		if(input6331v !=null)
		{
		return input6331v;
		}
		else {
			return "";
		}
	}
	public void setInput6331v(String input6331v) {
		this.input6331v = input6331v;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public int hashCode() {
		return Objects.hash(criteriaId, input6331v, input6331y, uniqueKey1);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		YearTable6331 other = (YearTable6331) obj;
		return Objects.equals(criteriaId, other.criteriaId) && Objects.equals(input6331v, other.input6331v)
				&& Objects.equals(input6331y, other.input6331y) && uniqueKey1 == other.uniqueKey1;
	}
	
	

}
