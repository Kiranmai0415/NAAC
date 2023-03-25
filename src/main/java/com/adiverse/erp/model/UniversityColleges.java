package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="universitycolleges")
public class UniversityColleges implements Serializable
{
	private static final long serialVersionUID = -2231411273570309611L;

	private CriteriaPrimaryKey criteriaId;
	
 	@Id
    @Column(name="unique_key1")
	private long uniqueKey1;
	
	
	//universites
	
	@Column(name="constituent_colleges")
	private String inputa3t1;
	
	@Column(name="affiliated_colleges")
	private String inputa3t2;
	
	@Column(name="colleges_under2f")
	private String inputa3t3;

	@Column(name="colleges_under2fand12b")
	private String inputa3t4;
	

	@Column(name="naacaccredited_colleges")
	private String inputa3t5;
	
	@Column(name="potential_excellence")
	private String inputa3t6;
	
	@Column(name="autonomous_colleges")
	private String inputa3t7;
	
	@Column(name="postgraduate_departments")
	private String inputa3t8;
	
	@Column(name="research_departments")
	private String inputa3t9;
	
	@Column(name="research_institutes")
	private String inputa3t10;
	
	@Column(name="regulatory_authority")
	private String inputa3t11;
	
	



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

	public String getInputa3t1() {
		if (inputa3t1!=null) {
			return inputa3t1;
		}
		else {
			return "";
		}
		
	}

	public void setInputa3t1(String inputa3t1) {
		this.inputa3t1 = inputa3t1;
	}

	public String getInputa3t2() {
		if (inputa3t2!=null) {
			return inputa3t2;
		}
		else {
			return "";
		}
		
	}

	public void setInputa3t2(String inputa3t2) {
		this.inputa3t2 = inputa3t2;
	}

	public String getInputa3t3() {
		if (inputa3t3!=null) {
			return inputa3t3;
		}
		else {
			return "";
		}
		
	}

	public void setInputa3t3(String inputa3t3) {
		this.inputa3t3 = inputa3t3;
	}

	public String getInputa3t4() {
		if (inputa3t4!=null) {
			return inputa3t4;
		}
		else {
			return "";
		}
		
	}

	public void setInputa3t4(String inputa3t4) {
		this.inputa3t4 = inputa3t4;
	}

	public String getInputa3t5() {
		if (inputa3t5!=null) {
			return inputa3t5;
		}
		else {
			return "";
		}
		
	}

	public void setInputa3t5(String inputa3t5) {
		this.inputa3t5 = inputa3t5;
	}

	public String getInputa3t6() {
		if (inputa3t6!=null) {
			return inputa3t6;
		}
		else {
			return "";
		}
		
	}

	public void setInputa3t6(String inputa3t6) {
		this.inputa3t6 = inputa3t6;
	}

	public String getInputa3t7() {
		if (inputa3t7!=null) {
			return inputa3t7;
		}
		else {
			return "";
		}
		
	}

	public void setInputa3t7(String inputa3t7) {
		this.inputa3t7 = inputa3t7;
	}

	public String getInputa3t8() {
		if (inputa3t8!=null) {
			return inputa3t8;
		}
		else {
			return "";
		}
		
	}

	public void setInputa3t8(String inputa3t8) {
		this.inputa3t8 = inputa3t8;
	}

	public String getInputa3t9() {
		if (inputa3t9!=null) {
			return inputa3t9;
		}
		else {
			return "";
		}
	}

	public void setInputa3t9(String inputa3t9) {
		this.inputa3t9 = inputa3t9;
	}

	public String getInputa3t10() {
		if (inputa3t10!=null) {
			return inputa3t10;
		}
		else {
			return "";
		}
		
	}

	public void setInputa3t10(String inputa3t10) {
		this.inputa3t10 = inputa3t10;
	}
	

	public String getInputa3t11() {
		if (inputa3t11!=null) {
			return inputa3t11;
		}
		else {
			return "";
		}
		
	}

	public void setInputa3t11(String inputa3t11) {
		this.inputa3t11 = inputa3t11;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(criteriaId, inputa3t1, inputa3t10, inputa3t11, inputa3t2, inputa3t3, inputa3t4, inputa3t5,
				inputa3t6, inputa3t7, inputa3t8, inputa3t9, uniqueKey1);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UniversityColleges other = (UniversityColleges) obj;
		return Objects.equals(criteriaId, other.criteriaId) && Objects.equals(inputa3t1, other.inputa3t1)
				&& Objects.equals(inputa3t10, other.inputa3t10) && Objects.equals(inputa3t11, other.inputa3t11)
				&& Objects.equals(inputa3t2, other.inputa3t2) && Objects.equals(inputa3t3, other.inputa3t3)
				&& Objects.equals(inputa3t4, other.inputa3t4) && Objects.equals(inputa3t5, other.inputa3t5)
				&& Objects.equals(inputa3t6, other.inputa3t6) && Objects.equals(inputa3t7, other.inputa3t7)
				&& Objects.equals(inputa3t8, other.inputa3t8) && Objects.equals(inputa3t9, other.inputa3t9)
				&& uniqueKey1 == other.uniqueKey1;
	}
	

	
}
