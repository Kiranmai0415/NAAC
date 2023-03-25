package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "value_added_courses")
public class ValueAddedCourses implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private CriteriaPrimaryKey criteriaId;
	
	@Id
    @Column(name="unique_key1")
	private long uniqueKey1;
	
	@Column(name = "nameof_vadd_course_offered")
	private String inputvat1;
	
	@Column(name = "dept")
	private String inputvat2;
	
	@Column(name = "schools_name")
	private String inputvat3;
	
	@Column(name = "course_code")
	private String inputvat4;
	
	@Column(name = "yearof_offering")
	private String inputvat5;
	
	@Column(name = "noof_times_offeredin_sameyr")
	private String inputvat6;
	
	@Column(name = "durationof_course")
	private String inputvat7;
	
	@Column(name = "noof_stud_enrolled_intheyr")
	private String inputvat8;
	
	@Column(name = "noof_stud_completing_course_inyr")
	private String inputvat9;

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

	public String getInputvat1() {
		if (inputvat1!=null) {
			return inputvat1;
		}
		else {
			return "";
		}
		
	}

	public void setInputvat1(String inputvat1) {
		this.inputvat1 = inputvat1;
	}

	public String getInputvat2() {
		if (inputvat2!=null) {
			return inputvat2;
		}
		else {
			return "";
		}
		
	}

	public void setInputvat2(String inputvat2) {
		this.inputvat2 = inputvat2;
	}

	public String getInputvat3() {
		if (inputvat3!=null) {
			return inputvat3;
		}
		else {
			return "";
		}
	}

	public void setInputvat3(String inputvat3) {
		this.inputvat3 = inputvat3;
	}

	public String getInputvat4() {
		if (inputvat4!=null) {
			return inputvat4;
		}
		else {
			return "";
		}
	
	}

	public void setInputvat4(String inputvat4) {
		this.inputvat4 = inputvat4;
	}

	public String getInputvat5() {
		if (inputvat5!=null) {
			return inputvat5;
		}
		else {
			return "";
		}
		
	}

	public void setInputvat5(String inputvat5) {
		this.inputvat5 = inputvat5;
	}

	public String getInputvat6() {
		if (inputvat6!=null) {
			return inputvat6;
		}
		else {
			return "";
		}
		
	}

	public void setInputvat6(String inputvat6) {
		this.inputvat6 = inputvat6;
	}

	public String getInputvat7() {
		if (inputvat7!=null) {
			return inputvat7;
		}
		else {
			return "";
		}
		
	}

	public void setInputvat7(String inputvat7) {
		this.inputvat7 = inputvat7;
	}

	public String getInputvat8() {
		if (inputvat8!=null) {
			return inputvat8;
		}
		else {
			return "";
		}
		
	}

	public void setInputvat8(String inputvat8) {
		this.inputvat8 = inputvat8;
	}

	public String getInputvat9() {
		if (inputvat9!=null) {
			return inputvat9;
		}
		else {
			return "";
		}
		
	}

	public void setInputvat9(String inputvat9) {
		this.inputvat9 = inputvat9;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(criteriaId, inputvat1, inputvat2, inputvat3, inputvat4, inputvat5, inputvat6, inputvat7,
				inputvat8, inputvat9, uniqueKey1);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ValueAddedCourses other = (ValueAddedCourses) obj;
		return Objects.equals(criteriaId, other.criteriaId) && Objects.equals(inputvat1, other.inputvat1)
				&& Objects.equals(inputvat2, other.inputvat2) && Objects.equals(inputvat3, other.inputvat3)
				&& Objects.equals(inputvat4, other.inputvat4) && Objects.equals(inputvat5, other.inputvat5)
				&& Objects.equals(inputvat6, other.inputvat6) && Objects.equals(inputvat7, other.inputvat7)
				&& Objects.equals(inputvat8, other.inputvat8) && Objects.equals(inputvat9, other.inputvat9)
				&& uniqueKey1 == other.uniqueKey1;
	}
	
	
	

}
