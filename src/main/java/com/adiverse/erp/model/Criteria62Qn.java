package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name ="criteria62Qn")
public class Criteria62Qn implements Serializable {
	
	private static final long serialVersionUID = 384884159595539439L;


	private CriteriaPrimaryKey criteriaId;
	
	@Id
    @Column(name="unique_key1")
	private long uniqueKey1;
	
	
	@Column(name = "responseValue623")
    private String response623;
	
	@Column(name = "input623t1")
    private String input623t1;
	

	
	


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



	public String getResponse623() {
		if(response623 !=null) {
		return response623;
	}else {
		return "";
	}
	}



	public void setResponse623(String response623) {
		this.response623 = response623;
	}



	public String getInput623t1() {
		if(input623t1 !=null) {
		return input623t1;
	}else {
		return "";
	}
	}



	public void setInput623t1(String input623t1) {
		this.input623t1 = input623t1;
	}



	

	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	@Override
	public int hashCode() {
		return Objects.hash(criteriaId, input623t1, response623, uniqueKey1);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Criteria62Qn other = (Criteria62Qn) obj;
		return Objects.equals(criteriaId, other.criteriaId) && Objects.equals(input623t1, other.input623t1)
				&& Objects.equals(response623, other.response623) && uniqueKey1 == other.uniqueKey1;
	}



	
	
	
	
	
}
