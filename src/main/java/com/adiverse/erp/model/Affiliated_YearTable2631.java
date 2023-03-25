package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="affiliated_yearTable2631")
public class Affiliated_YearTable2631 implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private CriteriaPrimaryKey criteriaId;
	
    @Id
    @Column(name="unique_key1")
	private long uniqueKey1;
    
	
	@Column(name = "examination year")
    private String input2631y;
	
	
	@Column(name = "finalyear")
    private String input2631v;
	
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
	public String getInput2631y() {
		return input2631y;
	}
	public void setInput2631y(String input2631y) {
		this.input2631y = input2631y;
	}
	public String getInput2631v() {
		return input2631v;
	}
	public void setInput2631v(String input2631v) {
		this.input2631v = input2631v;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public int hashCode() {
		return Objects.hash(criteriaId, input2631v, input2631y, uniqueKey1);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Affiliated_YearTable2631 other = (Affiliated_YearTable2631) obj;
		return Objects.equals(criteriaId, other.criteriaId) && Objects.equals(input2631v, other.input2631v)
				&& Objects.equals(input2631y, other.input2631y) && uniqueKey1 == other.uniqueKey1;
	}

	
	
	
	
	
}
