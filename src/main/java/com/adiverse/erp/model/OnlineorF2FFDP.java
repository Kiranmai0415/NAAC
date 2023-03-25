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
@Table(name = "online_f2f_fdp")
public class OnlineorF2FFDP implements Serializable{

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
	private String inputfdpt1;
	
	@Column(name = "nameof_teach_attend_progm")
	private String inputfdpt2;
	
	@Column(name = "dept")
	private String inputfdpt3;
	
	@Column(name = "schools_name")
	private String inputfdpt4;
	
	@Column(name = "duration_from")
	private String inputfdpt5;
	
	
	@Column(name = "duration_to")
	private String inputfdpt6;


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

	public String getInputfdpt1() {
		if (inputfdpt1!=null) {
			return inputfdpt1;
		}
		else {
			return "";
		}
		
	}

	public void setInputfdpt1(String inputfdpt1) {
		this.inputfdpt1 = inputfdpt1;
	}

	public String getInputfdpt2() {
		if (inputfdpt2!=null) {
			return inputfdpt2;
		}
		else {
			return "";
		}
	}

	public void setInputfdpt2(String inputfdpt2) {
		this.inputfdpt2 = inputfdpt2;
	}

	public String getInputfdpt3() {
		if (inputfdpt3!=null) {
			return inputfdpt3;
		}
		else {
			return "";
		}
	}

	public void setInputfdpt3(String inputfdpt3) {
		this.inputfdpt3 = inputfdpt3;
	}

	public String getInputfdpt4() {
		if (inputfdpt4!=null) {
			return inputfdpt4;
		}
		else {
			return "";
		}
	}

	public void setInputfdpt4(String inputfdpt4) {
		this.inputfdpt4 = inputfdpt4;
	}

	public String getInputfdpt5() {
		if (inputfdpt5!=null) {
			return inputfdpt5;
		}
		else {
			return "";
		}
	}

	public void setInputfdpt5(String inputfdpt5) {
		this.inputfdpt5 = inputfdpt5;
	}


	public String getInputfdpt6() {
		if (inputfdpt6!=null) {
			return inputfdpt6;
		}
		else {
			return "";
		}
	}


	public void setInputfdpt6(String inputfdpt6) {
		this.inputfdpt6 = inputfdpt6;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(criteriaId, inputfdpt1, inputfdpt2, inputfdpt3, inputfdpt4, inputfdpt5, inputfdpt6,
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
		OnlineorF2FFDP other = (OnlineorF2FFDP) obj;
		return Objects.equals(criteriaId, other.criteriaId) && Objects.equals(inputfdpt1, other.inputfdpt1)
				&& Objects.equals(inputfdpt2, other.inputfdpt2) && Objects.equals(inputfdpt3, other.inputfdpt3)
				&& Objects.equals(inputfdpt4, other.inputfdpt4) && Objects.equals(inputfdpt5, other.inputfdpt5)
				&& Objects.equals(inputfdpt6, other.inputfdpt6) && uniqueKey1 == other.uniqueKey1;
	}
	
	

	

}
