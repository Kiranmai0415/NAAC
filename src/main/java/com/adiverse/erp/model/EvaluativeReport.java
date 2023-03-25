package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="evaluative")
public class EvaluativeReport implements Serializable
{
	private static final long serialVersionUID = -5146302415898029412L;
	
	private CriteriaPrimaryKey criteriaId;
	
 	@Id
    @Column(name="unique_key1")
	private long uniqueKey1;
	
	  @Column(name="dname_1")
	  private String valuet1;
	  
	  @Column(name="dname_2")
	  private String valuet2;

	  @Column(name="dname_3")
	  private String valuet3;

	  @Column(name="dname_4")
	  private String valuet4;

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

	public String getValuet1() {
		if(valuet1  !=null) {
		return valuet1;
	}else {
		return "";
	}
	}

	public void setValuet1(String valuet1) {
		this.valuet1 = valuet1;
	}


	public String getValuet2() {
		if(valuet2  !=null) {
			return valuet2;
		}else {
			return "";
		}
	}

	public void setValuet2(String valuet2) {
		this.valuet2 = valuet2;
	}

	public String getValuet3() {
		if(valuet3  !=null) {
			return valuet3;
		}else {
			return "";
		}
	}

	public void setValuet3(String valuet3) {
		this.valuet3 = valuet3;
	}

	public String getValuet4() {
		if(valuet4  !=null) {
			return valuet4;
		}else {
			return "";
		}
	}

	public void setValuet4(String valuet4) {
		this.valuet4 = valuet4;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(criteriaId, uniqueKey1, valuet1, valuet2, valuet3, valuet4);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EvaluativeReport other = (EvaluativeReport) obj;
		return Objects.equals(criteriaId, other.criteriaId) && uniqueKey1 == other.uniqueKey1
				&& Objects.equals(valuet1, other.valuet1) && Objects.equals(valuet2, other.valuet2)
				&& Objects.equals(valuet3, other.valuet3) && Objects.equals(valuet4, other.valuet4);
	}




	
	  
	  

}
