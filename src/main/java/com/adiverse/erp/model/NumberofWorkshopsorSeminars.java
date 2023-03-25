package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "no_of_workshops_seminors")
public class NumberofWorkshopsorSeminars implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private CriteriaPrimaryKey criteriaId;

	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="unique_key1")
	private long uniqueKey1;
	
	@Column(name = "year")
	private String inputwt1;
	
	@Column(name = "dept")
	private String inputwt2;
	
	@Column(name = "schools_name")
	private String inputwt3;
	 
	@Column(name = "nameof_workshop_seminar")
	private String inputwt4;
	
	@Column(name = "no_of_participants")
	private String inputwt5;
	
	@Column(name = "date_from")
	private String inputwt6;
	
	@Column(name = "date_to")
	private String inputwt7;

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

	public String getInputwt1() {
		if (inputwt1!=null) {
			return inputwt1;
		}
		else {
			return "";
		}
		
	}

	public void setInputwt1(String inputwt1) {
		this.inputwt1 = inputwt1;
	}

	public String getInputwt2() {
		if (inputwt2!=null) {
			return inputwt2;
		}
		else {
			return "";
		}
	}

	public void setInputwt2(String inputwt2) {
		this.inputwt2 = inputwt2;
	}

	public String getInputwt3() {
		if (inputwt3!=null) {
			return inputwt3;
		}
		else {
			return "";
		}
	}

	public void setInputwt3(String inputwt3) {
		this.inputwt3 = inputwt3;
	}

	public String getInputwt4() {
		if (inputwt4!=null) {
			return inputwt4;
		}
		else {
			return "";
		}
	}

	public void setInputwt4(String inputwt4) {
		this.inputwt4 = inputwt4;
	}

	public String getInputwt5() {
		if (inputwt5!=null) {
			return inputwt5;
		}
		else {
			return "";
		}
	}

	public void setInputwt5(String inputwt5) {
		this.inputwt5 = inputwt5;
	}

	public String getInputwt6() {
		if (inputwt6!=null) {
			return inputwt6;
		}
		else {
			return "";
		}
	}

	public void setInputwt6(String inputwt6) {
		this.inputwt6 = inputwt6;
	}

	public String getInputwt7() {
		if (inputwt7!=null) {
			return inputwt7;
		}
		else {
			return "";
		}
	}

	public void setInputwt7(String inputwt7) {
		this.inputwt7 = inputwt7;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(criteriaId, inputwt1, inputwt2, inputwt3, inputwt4, inputwt5, inputwt6, inputwt7,
				uniqueKey1);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NumberofWorkshopsorSeminars other = (NumberofWorkshopsorSeminars) obj;
		return Objects.equals(criteriaId, other.criteriaId) && Objects.equals(inputwt1, other.inputwt1)
				&& Objects.equals(inputwt2, other.inputwt2) && Objects.equals(inputwt3, other.inputwt3)
				&& Objects.equals(inputwt4, other.inputwt4) && Objects.equals(inputwt5, other.inputwt5)
				&& Objects.equals(inputwt6, other.inputwt6) && Objects.equals(inputwt7, other.inputwt7)
				&& uniqueKey1 == other.uniqueKey1;
	}

	
	
	
}
