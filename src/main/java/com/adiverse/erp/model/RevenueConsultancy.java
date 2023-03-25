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
@Table(name = "revenue_consultancy")
public class RevenueConsultancy implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	private CriteriaPrimaryKey criteriaId;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="unique_key1")
	private long uniqueKey1;
	
	@Column(name = "nameofthe_teacher_consultant")
	private String inputrct1;
	
	@Column(name = "nameof_consultancy_project")
	private String inputrct2;
	
	@Column(name = "dept")
	private String inputrct3;
	
	@Column(name = "schools_name")
	private String inputrct4;
	
	@Column(name = "consulting_agency_contact_dtls")
	private String inputrct5;
	
	@Column(name = "year")
	private String inputrct6;
	
	@Column(name = "revenue_generated_inlakhs")
	private String inputrct7;

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

	public String getInputrct1() {
		if (inputrct1!=null) {
			return inputrct1;
		}
		else {
			return "";
		}
		
	}

	public void setInputrct1(String inputrct1) {
		this.inputrct1 = inputrct1;
	}

	public String getInputrct2() {
		if (inputrct2!=null) {
			return inputrct2;
		}
		else {
			return "";
		}
	}

	public void setInputrct2(String inputrct2) {
		this.inputrct2 = inputrct2;
	}

	public String getInputrct3() {
		if (inputrct3!=null) {
			return inputrct3;
		}
		else {
			return "";
		}
	}

	public void setInputrct3(String inputrct3) {
		this.inputrct3 = inputrct3;
	}

	public String getInputrct4() {
		if (inputrct4!=null) {
			return inputrct4;
		}
		else {
			return "";
		}
	}

	public void setInputrct4(String inputrct4) {
		this.inputrct4 = inputrct4;
	}

	public String getInputrct5() {
		if (inputrct5!=null) {
			return inputrct5;
		}
		else {
			return "";
		}
	}

	public void setInputrct5(String inputrct5) {
		this.inputrct5 = inputrct5;
	}

	public String getInputrct6() {
		if (inputrct6!=null) {
			return inputrct6;
		}
		else {
			return "";
		}
	}

	public void setInputrct6(String inputrct6) {
		this.inputrct6 = inputrct6;
	}

	public String getInputrct7() {
		if (inputrct7!=null) {
			return inputrct7;
		}
		else {
			return "";
		}
	}

	public void setInputrct7(String inputrct7) {
		this.inputrct7 = inputrct7;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(criteriaId, inputrct1, inputrct2, inputrct3, inputrct4, inputrct5, inputrct6, inputrct7,
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
		RevenueConsultancy other = (RevenueConsultancy) obj;
		return Objects.equals(criteriaId, other.criteriaId) && Objects.equals(inputrct1, other.inputrct1)
				&& Objects.equals(inputrct2, other.inputrct2) && Objects.equals(inputrct3, other.inputrct3)
				&& Objects.equals(inputrct4, other.inputrct4) && Objects.equals(inputrct5, other.inputrct5)
				&& Objects.equals(inputrct6, other.inputrct6) && Objects.equals(inputrct7, other.inputrct7)
				&& uniqueKey1 == other.uniqueKey1;
	}

	
	
	
	
}
