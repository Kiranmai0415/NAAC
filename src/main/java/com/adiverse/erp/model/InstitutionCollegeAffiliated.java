package com.adiverse.erp.model;



import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="institution_collegeAffiliated")
public class InstitutionCollegeAffiliated implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private CriteriaPrimaryKey criteriaId;
	
 	@Id
    @Column(name="unique_key1")
	private long uniqueKey1;
 	
	@Column(name="institution_state")
	private String inputbti11;

	
		@Column(name="institution_name")
		private String inputbti12;
		
		
		
		@Column(name="view_Document")
		private String inputbti13;



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



		public String getInputbti11() {
			if(inputbti11 !=null) {
				return inputbti11;
			}else {
				return "";
			}
		}



		public void setInputbti11(String inputbti11) {
			this.inputbti11 = inputbti11;
		}



		public String getInputbti12() {
			if(inputbti12 !=null) {
				return inputbti12;
			}else {
				return "";
			}
		}



		public void setInputbti12(String inputbti12) {
			this.inputbti12 = inputbti12;
		}



		public String getInputbti13() {
			if(inputbti13 !=null) {
				return inputbti13;
			}else {
				return "";
			}
		}



		public void setInputbti13(String inputbti13) {
			this.inputbti13 = inputbti13;
		}



		public static long getSerialversionuid() {
			return serialVersionUID;
		}



		@Override
		public int hashCode() {
			return Objects.hash(criteriaId, inputbti11, inputbti12, inputbti13, uniqueKey1);
		}



		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			InstitutionCollegeAffiliated other = (InstitutionCollegeAffiliated) obj;
			return Objects.equals(criteriaId, other.criteriaId) && Objects.equals(inputbti11, other.inputbti11)
					&& Objects.equals(inputbti12, other.inputbti12) && Objects.equals(inputbti13, other.inputbti13)
					&& uniqueKey1 == other.uniqueKey1;
		}
		
	
	
		
}

		
		





