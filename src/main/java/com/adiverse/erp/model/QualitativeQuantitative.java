package com.adiverse.erp.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="qualitative_quantitave")
public class QualitativeQuantitative {
	
	private CriteriaPrimaryKey criteriaId;
	

	@Id
	@Column(name="unique_key1")
	private long uniqueKey1;
	
	@Column(name = "Metricwise_grade")
    private String qnqlt1;
	@Column(name = "kiwise_weight")
    private String qnqlt2;
	@Column(name = "kiwise_grade")
    private String qnqlt3;
	@Column(name = "total")
    private String qnqlt4;
	@Column(name = "grade")
    private String qnqlt5;
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
	public String getQnqlt1() {
		if (qnqlt1!=null) {
			return qnqlt1;
		}
		else {
			return "";
		}
		
	}
	public void setQnqlt1(String qnqlt1) {
		this.qnqlt1 = qnqlt1;
	}
	public String getQnqlt2() {
		if (qnqlt2!=null) {
			return qnqlt2;
		}
		else {
			return "";
		}
	}
	public void setQnqlt2(String qnqlt2) {
		this.qnqlt2 = qnqlt2;
	}
	public String getQnqlt3() {
		if (qnqlt3!=null) {
			return qnqlt3;
		}
		else {
			return "";
		}
	}
	public void setQnqlt3(String qnqlt3) {
		this.qnqlt3 = qnqlt3;
	}
	public String getQnqlt4() {
		if (qnqlt4!=null) {
			return qnqlt4;
		}
		else {
			return "";
		}
	}
	public void setQnqlt4(String qnqlt4) {
		this.qnqlt4 = qnqlt4;
	}
	public String getQnqlt5() {
		if (qnqlt5!=null) {
			return qnqlt5;
		}
		else {
			return "";
		}
	}
	public void setQnqlt5(String qnqlt5) {
		this.qnqlt5 = qnqlt5;
	}
	@Override
	public int hashCode() {
		return Objects.hash(criteriaId, qnqlt1, qnqlt2, qnqlt3, qnqlt4, qnqlt5, uniqueKey1);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		QualitativeQuantitative other = (QualitativeQuantitative) obj;
		return Objects.equals(criteriaId, other.criteriaId) && Objects.equals(qnqlt1, other.qnqlt1)
				&& Objects.equals(qnqlt2, other.qnqlt2) && Objects.equals(qnqlt3, other.qnqlt3)
				&& Objects.equals(qnqlt4, other.qnqlt4) && Objects.equals(qnqlt5, other.qnqlt5)
				&& uniqueKey1 == other.uniqueKey1;
	}
	
	
	
	
	

}
