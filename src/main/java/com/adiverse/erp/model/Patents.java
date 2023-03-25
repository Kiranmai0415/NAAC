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
@Table(name="patents")
public class Patents implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private CriteriaPrimaryKey criteriaId;
	
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="unique_key1")
	private long uniqueKey1;
	
	 @Column(name="nameofthe_teacher")
		private String inputppt1;
	 
	 @Column(name="dept")
		private String inputppt2;
	 
	 @Column(name="schools_name")
		private String inputppt3;
	 
	 @Column(name="patent_number")
		private String inputppt4;
	 
	 @Column(name="title_ofthe_patent")
		private String inputppt5;
	
	 @Column(name="yearofaward_publishofpatent")
		private String inputppt6;

	 @Column(name="curr_year")
		private String inputppt7;
	 
	 @Column(name="earnings")
		private String inputppt8;

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

	public String getInputppt1() {
		if (inputppt1!=null) {
			return inputppt1;
		}
		else {
			return "";
		}
		
	}

	public void setInputppt1(String inputppt1) {
		this.inputppt1 = inputppt1;
	}

	public String getInputppt2() {
		if (inputppt2!=null) {
			return inputppt2;
		}
		else {
			return "";
		}
	}

	public void setInputppt2(String inputppt2) {
		this.inputppt2 = inputppt2;
	}

	public String getInputppt3() {
		if (inputppt3!=null) {
			return inputppt3;
		}
		else {
			return "";
		}
	}

	public void setInputppt3(String inputppt3) {
		this.inputppt3 = inputppt3;
	}

	public String getInputppt4() {
		if (inputppt4!=null) {
			return inputppt4;
		}
		else {
			return "";
		}
	}

	public void setInputppt4(String inputppt4) {
		this.inputppt4 = inputppt4;
	}

	public String getInputppt5() {
		if (inputppt5!=null) {
			return inputppt5;
		}
		else {
			return "";
		}
	}

	public void setInputppt5(String inputppt5) {
		this.inputppt5 = inputppt5;
	}

	public String getInputppt6() {
		if (inputppt6!=null) {
			return inputppt6;
		}
		else {
			return "";
		}
	}

	public void setInputppt6(String inputppt6) {
		this.inputppt6 = inputppt6;
	}

	public String getInputppt7() {
		if (inputppt7!=null) {
			return inputppt7;
		}
		else {
			return "";
		}
	}

	public void setInputppt7(String inputppt7) {
		this.inputppt7 = inputppt7;
	}

	
	
	
	
	public String getInputppt8() {
		if(inputppt8!=null) {
			return inputppt8;
		}
		else {
			return "";
		}
		 
	}

	public void setInputppt8(String inputppt8) {
		this.inputppt8 = inputppt8;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(criteriaId, inputppt1, inputppt2, inputppt3, inputppt4, inputppt5, inputppt6, inputppt7,
				inputppt8, uniqueKey1);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Patents other = (Patents) obj;
		return Objects.equals(criteriaId, other.criteriaId) && Objects.equals(inputppt1, other.inputppt1)
				&& Objects.equals(inputppt2, other.inputppt2) && Objects.equals(inputppt3, other.inputppt3)
				&& Objects.equals(inputppt4, other.inputppt4) && Objects.equals(inputppt5, other.inputppt5)
				&& Objects.equals(inputppt6, other.inputppt6) && Objects.equals(inputppt7, other.inputppt7)
				&& Objects.equals(inputppt8, other.inputppt8) && uniqueKey1 == other.uniqueKey1;
	}

	
	 
	 
	 

	
	 
}
