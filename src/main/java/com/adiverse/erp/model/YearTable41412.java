package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="yeartable41412")
public class YearTable41412 implements Serializable
{
	private static final long serialVersionUID = 1L;

	private CriteriaPrimaryKey criteriaId;
	
    @Id
    @Column(name="unique_key1")
	private long uniqueKey1;
	
	@Column(name = "year")
    private String input41412y;
	
	@Column(name = "expenditure_infrastructure_1")
    private String input41412v;
	

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
	public String getInput41412y() {
		if (input41412y!=null) {
			return input41412y;
		}
		else {
			return "";
		}
	}
	public void setInput41412y(String input41412y) {
		this.input41412y = input41412y;
	}
	public String getInput41412v() {
		if (input41412v!=null) {
			return input41412v;
		}
		else {
			return "";
		}
		
	}
	public void setInput41412v(String input41412v) {
		this.input41412v = input41412v;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public int hashCode() {
		return Objects.hash(criteriaId, input41412v, input41412y, uniqueKey1);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		YearTable41412 other = (YearTable41412) obj;
		return Objects.equals(criteriaId, other.criteriaId) && Objects.equals(input41412v, other.input41412v)
				&& Objects.equals(input41412y, other.input41412y) && uniqueKey1 == other.uniqueKey1;
	}
	
}
