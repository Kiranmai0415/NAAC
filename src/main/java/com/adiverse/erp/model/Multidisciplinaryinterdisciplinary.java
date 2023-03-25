package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity

@Table(name = "multidisciplinary") 
public class Multidisciplinaryinterdisciplinary implements Serializable
{
	 
	private static final long serialVersionUID = 2672111540055529530L;

	private CriteriaPrimaryKey criteriaId;
	
 	@Id
    @Column(name="unique_key1")
	private long uniqueKey1;
	
	  @Lob
	  @Column(name = "Multidisciplinary_name")
	  private String valuep1; 
	  @Lob
	  @Column(name= "ABC_title")
	  private String valuep2;
	  @Lob
	  @Column(name="Skill_development")
	  private String valuep3;
	  @Lob
	  @Column(name="Knowledge_a")
	  private String valuep4 ;
	  @Lob
	  @Column(name="education_OBE")
	  private String valuep5;
	  @Lob
	  @Column(name="online_education")
	  private String valuep6;
	  

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
	public String getValuep1() {
		if (valuep1!=null) {
			return valuep1;
		}
		else {
			return "";
		}
		
	}
	public void setValuep1(String valuep1) {
		this.valuep1 = valuep1;
	}
	public String getValuep2() {
		if (valuep2!=null) {
			return valuep2;
		}
		else {
			return "";
		}
	}
	public void setValuep2(String valuep2) {
		this.valuep2 = valuep2;
	}
	public String getValuep3() {
		if (valuep3!=null) {
			return valuep3;
		}
		else {
			return "";
		}
	}
	public void setValuep3(String valuep3) {
		this.valuep3 = valuep3;
	}
	public String getValuep4() {
		if (valuep4!=null) {
			return valuep4;
		}
		else {
			return "";
		}
	}
	public void setValuep4(String valuep4) {
		this.valuep4 = valuep4;
	}
	public String getValuep5() {
		if (valuep5!=null) {
			return valuep5;
		}
		else {
			return "";
		}
	}
	public void setValuep5(String valuep5) {
		this.valuep5 = valuep5;
	}
	public String getValuep6() {
		if (valuep6!=null) {
			return valuep6;
		}
		else {
			return "";
		}
	}
	public void setValuep6(String valuep6) {
		this.valuep6 = valuep6;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public int hashCode() {
		return Objects.hash(criteriaId, uniqueKey1, valuep1, valuep2, valuep3, valuep4, valuep5, valuep6);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Multidisciplinaryinterdisciplinary other = (Multidisciplinaryinterdisciplinary) obj;
		return Objects.equals(criteriaId, other.criteriaId) && uniqueKey1 == other.uniqueKey1
				&& Objects.equals(valuep1, other.valuep1) && Objects.equals(valuep2, other.valuep2)
				&& Objects.equals(valuep3, other.valuep3) && Objects.equals(valuep4, other.valuep4)
				&& Objects.equals(valuep5, other.valuep5) && Objects.equals(valuep6, other.valuep6);
	}
	
	
	
	
	
}