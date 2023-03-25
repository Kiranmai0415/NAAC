package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="yeartable24212")
public class YearTable24212 implements Serializable
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
    private String input24212y;
	@Column(name = "fulltime_teachers_1")
    private String input24212v;
	
	
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
	public String getInput24212y() {
		if (input24212y!=null) {
			return input24212y;
		}
		else {
			return "";
		}
	
	}
	public void setInput24212y(String input24212y) {
		this.input24212y = input24212y;
	}
	public String getInput24212v() {
		if (input24212v!=null) {
			return input24212v;
		}
		else {
			return "";
		}
		
	}
	public void setInput24212v(String input24212v) {
		this.input24212v = input24212v;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public int hashCode() {
		return Objects.hash(criteriaId, input24212v, input24212y, uniqueKey1);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		YearTable24212 other = (YearTable24212) obj;
		return Objects.equals(criteriaId, other.criteriaId) && Objects.equals(input24212v, other.input24212v)
				&& Objects.equals(input24212y, other.input24212y) && uniqueKey1 == other.uniqueKey1;
	}
	
	 
}
