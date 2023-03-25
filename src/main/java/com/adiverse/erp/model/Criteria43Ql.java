package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;




@Entity
@Table(name ="criteria43Ql")
public class Criteria43Ql  implements Serializable{

private static final long serialVersionUID = 1L;
	
	
	private CriteriaPrimaryKey criteriaId;
	
	@Id
    @Column(name="unique_key1")
	private long uniqueKey1;
	
	
	@Column(name = "responseValue431")
    private String response431;
	
	@Column(name = "input431t1")
    private String input431t1;
	
	@Column(name = "input431t2")
    private String input431t2;

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

	public String getResponse431() {
		if(response431 !=null) {
		return response431;
	}else {
		return "";
	}
	}

	public void setResponse431(String response431) {
		this.response431 = response431;
	}

	public String getInput431t1() {
		if(input431t1 !=null) {
		return input431t1;
	}else {
		return "";
	}
	}

	public void setInput431t1(String input431t1) {
		this.input431t1 = input431t1;
	}

	public String getInput431t2() {
		if(input431t2 !=null) {
		return input431t2;
	}else {
		return "";
	}
	}

	public void setInput431t2(String input431t2) {
		this.input431t2 = input431t2;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(criteriaId, input431t1, input431t2, response431, uniqueKey1);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Criteria43Ql other = (Criteria43Ql) obj;
		return Objects.equals(criteriaId, other.criteriaId) && Objects.equals(input431t1, other.input431t1)
				&& Objects.equals(input431t2, other.input431t2) && Objects.equals(response431, other.response431)
				&& uniqueKey1 == other.uniqueKey1;
	}
	
	
	
	
	
}
