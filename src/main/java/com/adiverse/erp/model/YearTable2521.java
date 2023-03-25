package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="yeartable2521")
public class YearTable2521 implements Serializable
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
    private String input2521y;
	@Column(name = "complaints_grievances")
    private String input2521v;
	
	@Column(name = "examinations")
    private String input2521n;
	

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
	public String getInput2521y() {
		if (input2521y!=null) {
			return input2521y;
		}
		else {
			return "";
		}
		
	}
	public String getInput2521n() {
		return input2521n;
	}
	public void setInput2521n(String input2521n) {
		this.input2521n = input2521n;
	}
	public void setInput2521y(String input2521y) {
		this.input2521y = input2521y;
	}
	public String getInput2521v() {
		if (input2521v!=null) {
			return input2521v;
		}
		else {
			return "";
		}
		
	}
	public void setInput2521v(String input2521v) {
		this.input2521v = input2521v;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public int hashCode() {
		return Objects.hash(criteriaId, input2521n, input2521v, input2521y, uniqueKey1);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		YearTable2521 other = (YearTable2521) obj;
		return Objects.equals(criteriaId, other.criteriaId) && Objects.equals(input2521n, other.input2521n)
				&& Objects.equals(input2521v, other.input2521v) && Objects.equals(input2521y, other.input2521y)
				&& uniqueKey1 == other.uniqueKey1;
	}
	
	
	
	
}
