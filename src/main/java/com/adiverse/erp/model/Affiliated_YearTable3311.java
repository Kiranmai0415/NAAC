package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="affiliated_yeartable3311")
public class Affiliated_YearTable3311 implements Serializable
{
	
     /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//changes
	
	private CriteriaPrimaryKey criteriaId;
	
    @Id
    @Column(name="unique_key1")
	private long uniqueKey1;
	
	
	@Column(name = "year")
    private String input3311y;

	@Column(name = "journals")
    private String input3311v;

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

	public String getInput3311y() {
		if(input3311y !=null) {
		return input3311y;
	}else {
		return "";
	}
	}

	public void setInput3311y(String input3311y) {
		this.input3311y = input3311y;
	}

	public String getInput3311v() {
		if(input3311v !=null) {
		return input3311v;
	}else {
		return "";
	}
	}

	public void setInput3311v(String input3311v) {
		this.input3311v = input3311v;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(criteriaId, input3311v, input3311y, uniqueKey1);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Affiliated_YearTable3311 other = (Affiliated_YearTable3311) obj;
		return Objects.equals(criteriaId, other.criteriaId) && Objects.equals(input3311v, other.input3311v)
				&& Objects.equals(input3311y, other.input3311y) && uniqueKey1 == other.uniqueKey1;
	}

	
	
	
	
	}
