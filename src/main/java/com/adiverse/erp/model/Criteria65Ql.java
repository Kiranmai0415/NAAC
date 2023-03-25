package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name ="criteria65Ql")
public class Criteria65Ql implements Serializable {
	
	private static final long serialVersionUID = 384884159595539439L;


	private CriteriaPrimaryKey criteriaId;
	
	@Id
    @Column(name="unique_key1")
	private long uniqueKey1;
	
	
	
	@Column(name = "input651t1")
    private String input651t1;
	
	
	
	@Column(name = "input652t1")
    private String input652t1;
	
	@Column(name = "responseValue652")
    private String response652;

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

	public String getInput651t1() {
		if(input651t1 !=null) {
		return input651t1;
	}else {
		return "";
	}
	}

	public void setInput651t1(String input651t1) {
		this.input651t1 = input651t1;
	}

	
	public String getInput652t1() {
		if(input652t1 !=null) {
		return input652t1;
	}else {
		return "";
	}
	}

	public void setInput652t1(String input652t1) {
		this.input652t1 = input652t1;
	}

	public String getResponse652() {
		if(response652 !=null) {
		return response652;
	}else {
		return "";
	}
	}

	public void setResponse652(String response652) {
		this.response652 = response652;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(criteriaId, input651t1, input652t1, response652, uniqueKey1);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Criteria65Ql other = (Criteria65Ql) obj;
		return Objects.equals(criteriaId, other.criteriaId) && Objects.equals(input651t1, other.input651t1)
				&& Objects.equals(input652t1, other.input652t1) && Objects.equals(response652, other.response652)
				&& uniqueKey1 == other.uniqueKey1;
	}

	
	
	
}
