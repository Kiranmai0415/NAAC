package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="yeartable21212")
public class YearTable21212 implements Serializable
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
    private String input21212y;
	
	@Column(name = "reserved_categories_1")
    private String input21212v;
	
	@Column(name = "reserved_GOI_norms_1")
    private String input21212n;
	
	
	
	public CriteriaPrimaryKey getCriteriaId() {
		return criteriaId;
	}
	public void setCriteriaId(CriteriaPrimaryKey criteriaId) {
		this.criteriaId = criteriaId;
	}
	public long getUniqueKey1() {
		return uniqueKey1;
	}
	public String getInput21212n() {
		return input21212n;
	}
	public void setInput21212n(String input21212n) {
		this.input21212n = input21212n;
	}
	public void setUniqueKey1(long uniqueKey1) {
		this.uniqueKey1 = uniqueKey1;
	}
	public String getInput21212y() {
		if (input21212y!=null) {
			return input21212y;
		}
		else {
			return "";
		}
		
	}
	public void setInput21212y(String input21212y) {
		this.input21212y = input21212y;
	}
	public String getInput21212v() {
		if (input21212v!=null) {
			return input21212v;
		}
		else {
			return "";
		}
	}
	public void setInput21212v(String input21212v) {
		this.input21212v = input21212v;
		
		
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public int hashCode() {
		return Objects.hash(criteriaId, input21212n, input21212v, input21212y, uniqueKey1);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		YearTable21212 other = (YearTable21212) obj;
		return Objects.equals(criteriaId, other.criteriaId) && Objects.equals(input21212n, other.input21212n)
				&& Objects.equals(input21212v, other.input21212v) && Objects.equals(input21212y, other.input21212y)
				&& uniqueKey1 == other.uniqueKey1;
	}
	
	
	
}
