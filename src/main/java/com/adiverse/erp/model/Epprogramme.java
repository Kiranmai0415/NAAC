package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ep_programme")
public class Epprogramme implements Serializable {

	/**
	 * 
	 */
	private CriteriaPrimaryKey criteriaId;

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "unique_key1")

	private long uniqueKey1;

	@Column(name = "programmeYear")
	private String input11y;

	@Column(name = "programmeNumber")
	private String input11v;

	public long getUniqueKey1() {
		return uniqueKey1;
	}

	public void setUniqueKey1(long uniqueKey1) {
		this.uniqueKey1 = uniqueKey1;
	}

	public String getInput11y() {
		if(input11y !=null) {
			return input11y;
		}else {
			return "";
		}
	}

	public void setInput11y(String input11y) {
		this.input11y = input11y;
	}

	public String getInput11v() {
		if(input11v !=null) {
			return input11v;
		}else {
			return "";
		}
	}

	public void setInput11v(String input11v) {
		this.input11v = input11v;
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

	@Override
	public int hashCode() {
		return Objects.hash(criteriaId, input11v, input11y, uniqueKey1);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Epprogramme other = (Epprogramme) obj;
		return Objects.equals(criteriaId, other.criteriaId) && Objects.equals(input11v, other.input11v)
				&& Objects.equals(input11y, other.input11y) && uniqueKey1 == other.uniqueKey1;
	}

}