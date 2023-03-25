package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="nonTeaching_staff")
public class NonTeachingStaff implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private CriteriaPrimaryKey criteriaId;
	
 	@Id
    @Column(name="unique_key1")
	private long uniqueKey1;

	
	@Column(name="Non_teaching_male")
	private String inputatnt11;
	
	@Column(name="Non_teaching_Female")
	private String inputatnt12;
	
	@Column(name="Non_teaching_Others")
	private String inputatnt13;
	
	@Column(name="Non_teaching_Total")
	private String inputatnt14;

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

	public String getInputatnt11() {
		if (inputatnt11!=null) {
			return inputatnt11;
		}
		else {
			return "";
		}
		
	}

	public void setInputatnt11(String inputatnt11) {
		this.inputatnt11 = inputatnt11;
	}

	public String getInputatnt12() {
		if (inputatnt12!=null) {
			return inputatnt12;
		}
		else {
			return "";
		}
	}

	public void setInputatnt12(String inputatnt12) {
		this.inputatnt12 = inputatnt12;
	}

	public String getInputatnt13() {
		if (inputatnt13!=null) {
			return inputatnt13;
		}
		else {
			return "";
		}
	}

	public void setInputatnt13(String inputatnt13) {
		this.inputatnt13 = inputatnt13;
	}

	public String getInputatnt14() {
		if (inputatnt14!=null) {
			return inputatnt14;
		}
		else {
			return "";
		}
	}

	public void setInputatnt14(String inputatnt14) {
		this.inputatnt14 = inputatnt14;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

	@Override
	public int hashCode() {
		return Objects.hash(criteriaId, inputatnt11, inputatnt12, inputatnt13, inputatnt14, uniqueKey1);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NonTeachingStaff other = (NonTeachingStaff) obj;
		return Objects.equals(criteriaId, other.criteriaId) && Objects.equals(inputatnt11, other.inputatnt11)
				&& Objects.equals(inputatnt12, other.inputatnt12) && Objects.equals(inputatnt13, other.inputatnt13)
				&& Objects.equals(inputatnt14, other.inputatnt14) && uniqueKey1 == other.uniqueKey1;
	}
	

	
	
	
}