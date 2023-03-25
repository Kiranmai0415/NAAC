package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="recognization_Details")
public class RecognizationDetails implements Serializable
{
	private static final long serialVersionUID = 3315733796001209410L;
	
	private CriteriaPrimaryKey criteriaId;
	
 	@Id
    @Column(name="unique_key1")
	private long uniqueKey1;
	
     @Column(name="UGC_OF_2f")
     private String inputbtr6;
 			
 			@Column(name="UGC_OF_12B")
 			private String inputbtr7;

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

			public String getInputbtr6() {
				if (inputbtr6!=null) {
					return inputbtr6;
				}
				else {
					return "";
				}
				
			}

			public void setInputbtr6(String inputbtr6) {
				this.inputbtr6 = inputbtr6;
			}

			public String getInputbtr7() {
				if (inputbtr7!=null) {
					return inputbtr7;
				}
				else {
					return "";
				}
			
			}

			public void setInputbtr7(String inputbtr7) {
				this.inputbtr7 = inputbtr7;
			}

			public static long getSerialversionuid() {
				return serialVersionUID;
			}

			@Override
			public int hashCode() {
				return Objects.hash(criteriaId, inputbtr6, inputbtr7, uniqueKey1);
			}

			@Override
			public boolean equals(Object obj) {
				if (this == obj)
					return true;
				if (obj == null)
					return false;
				if (getClass() != obj.getClass())
					return false;
				RecognizationDetails other = (RecognizationDetails) obj;
				return Objects.equals(criteriaId, other.criteriaId) && Objects.equals(inputbtr6, other.inputbtr6)
						&& Objects.equals(inputbtr7, other.inputbtr7) && uniqueKey1 == other.uniqueKey1;
			}
 			
 	




	

}