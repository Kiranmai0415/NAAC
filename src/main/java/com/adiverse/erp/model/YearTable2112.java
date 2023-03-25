package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="yeartable2112")
public class YearTable2112 implements Serializable
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
    private String input2112y;
	@Column(name = "sanctioned_seats")
    private String input2112v;
	
	@Column(name = "Numberof_seats")
    private String input2112n;
	
	

	public String getInput2112y() {
		if (input2112y!=null) {
			return input2112y;
		}
		else {
			return "";
		}
	}
	public String getInput2112n() {
		return input2112n;
	}
	public void setInput2112n(String input2112n) {
		this.input2112n = input2112n;
	}
	public void setInput2112y(String input2112y) {
		this.input2112y = input2112y;
	}
	public String getInput2112v() {
		if (input2112v!=null) {
			return input2112v;
		}
		else {
			return "";
		}
	}
	public void setInput2112v(String input2112v) {
		this.input2112v = input2112v;
		
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
		return Objects.hash(criteriaId, input2112n, input2112v, input2112y, uniqueKey1);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		YearTable2112 other = (YearTable2112) obj;
		return Objects.equals(criteriaId, other.criteriaId) && Objects.equals(input2112n, other.input2112n)
				&& Objects.equals(input2112v, other.input2112v) && Objects.equals(input2112y, other.input2112y)
				&& uniqueKey1 == other.uniqueKey1;
	}
	
}
