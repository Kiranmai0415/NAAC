package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="yeartable2411")
public class YearTable2411 implements Serializable
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
    private String input2411y;
	@Column(name = "sanctioned_posts")
    private String input2411v;
	

	public String getInput2411y() {
		if (input2411y!=null) {
			return input2411y;
		}
		else {
			return "";
		}
		
	}
	public void setInput2411y(String input2411y) {
		this.input2411y = input2411y;
	}
	public String getInput2411v() {
		if (input2411v!=null) {
			return input2411v;
		}
		else {
			return "";
		}
		
	}
	public void setInput2411v(String input2411v) {
		this.input2411v = input2411v;
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
		return Objects.hash(criteriaId, input2411v, input2411y, uniqueKey1);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		YearTable2411 other = (YearTable2411) obj;
		return Objects.equals(criteriaId, other.criteriaId) && Objects.equals(input2411v, other.input2411v)
				&& Objects.equals(input2411y, other.input2411y) && uniqueKey1 == other.uniqueKey1;
	}
	
	
}
