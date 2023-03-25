package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="yeartable2412")
public class YearTable2412 implements Serializable
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
    private String input2412y;
	@Column(name = "sanctioned_posts_1")
    private String input2412v;
	
	
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
	public String getInput2412y() {
		if (input2412y!=null) {
			return input2412y;
		}
		else {
			return "";
		}
		
	}
	public void setInput2412y(String input2412y) {
		this.input2412y = input2412y;
	}
	public String getInput2412v() {
		if (input2412v!=null) {
			return input2412v;
		}
		else {
			return "";
		}
		
	}
	public void setInput2412v(String input2412v) {
		this.input2412v = input2412v;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public int hashCode() {
		return Objects.hash(criteriaId, input2412v, input2412y, uniqueKey1);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		YearTable2412 other = (YearTable2412) obj;
		return Objects.equals(criteriaId, other.criteriaId) && Objects.equals(input2412v, other.input2412v)
				&& Objects.equals(input2412y, other.input2412y) && uniqueKey1 == other.uniqueKey1;
	}

}
