package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;





@Entity
@Table(name="epinstitution45")
public class EpInstitution45 implements Serializable
{
     private static final long serialVersionUID = 1L;


     private CriteriaPrimaryKey criteriaId;
   	
    	@Id
        @Column(name="unique_key1")
    	
    	private long uniqueKey1;
   	
   
   @Column(name="totalyearexpenditureYear")
   private String input45y;
   
   @Column(name="totalnumbersalaryNumber")
   private String input45v;

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

public String getInput45y() {
	if(input45y !=null) {
		return input45y;
	}else {
		return "";
	}
}

public void setInput45y(String input45y) {
	this.input45y = input45y;
}

public String getInput45v() {
	if(input45v !=null) {
		return input45v;
	}else {
		return "";
	}
}

public void setInput45v(String input45v) {
	this.input45v = input45v;
}

public static long getSerialversionuid() {
	return serialVersionUID;
}

@Override
public int hashCode() {
	return Objects.hash(criteriaId, input45v, input45y, uniqueKey1);
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	EpInstitution45 other = (EpInstitution45) obj;
	return Objects.equals(criteriaId, other.criteriaId) && Objects.equals(input45v, other.input45v)
			&& Objects.equals(input45y, other.input45y) && uniqueKey1 == other.uniqueKey1;
}




 

   
   

}