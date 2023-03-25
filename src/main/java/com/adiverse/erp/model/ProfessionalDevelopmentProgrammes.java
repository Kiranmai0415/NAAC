package com.adiverse.erp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "professional_development_programmes")
public class ProfessionalDevelopmentProgrammes implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private CriteriaPrimaryKey criteriaId;

	@Id
    @Column(name="unique_key1")
	private long uniqueKey1;
	
	    @Column(name = "year")
		private String inputpdt1;
	 
	    @Column(name = "dates_from")
		private String inputpdt2;
	    
	    @Column(name = "dates_to")
		private String inputpdt3;
	    
	    @Column(name = "titleof_pro")
		private String inputpdt4;
	    
	    @Column(name = "department")
		private String inputpdt5;
	    
	    @Column(name = "schools_name")
		private String inputpdt6;
	    
	    @Column(name = "no_of_participants")
	  	private String inputpdt7;

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

		public String getInputpdt1() {
			if (inputpdt1!=null) {
				return inputpdt1;
			}
			else {
				return "";
			}
			
		}

		public void setInputpdt1(String inputpdt1) {
			this.inputpdt1 = inputpdt1;
		}

		public String getInputpdt2() {
			if (inputpdt2!=null) {
				return inputpdt2;
			}
			else {
				return "";
			}
		}

		public void setInputpdt2(String inputpdt2) {
			this.inputpdt2 = inputpdt2;
		}

		public String getInputpdt3() {
			if (inputpdt3!=null) {
				return inputpdt3;
			}
			else {
				return "";
			}
		}

		public void setInputpdt3(String inputpdt3) {
			this.inputpdt3 = inputpdt3;
		}

		public String getInputpdt4() {
			if (inputpdt4!=null) {
				return inputpdt4;
			}
			else {
				return "";
			}
		}

		public void setInputpdt4(String inputpdt4) {
			this.inputpdt4 = inputpdt4;
		}

		public String getInputpdt5() {
			if (inputpdt5!=null) {
				return inputpdt5;
			}
			else {
				return "";
			}
		}

		public void setInputpdt5(String inputpdt5) {
			this.inputpdt5 = inputpdt5;
		}

		public String getInputpdt6() {
			if (inputpdt6!=null) {
				return inputpdt6;
			}
			else {
				return "";
			}
		}

		public void setInputpdt6(String inputpdt6) {
			this.inputpdt6 = inputpdt6;
		}

		public String getInputpdt7() {
			if (inputpdt7!=null) {
				return inputpdt7;
			}
			else {
				return "";
			}
		}

		public void setInputpdt7(String inputpdt7) {
			this.inputpdt7 = inputpdt7;
		}

		public static long getSerialversionuid() {
			return serialVersionUID;
		}

		@Override
		public int hashCode() {
			return Objects.hash(criteriaId, inputpdt1, inputpdt2, inputpdt3, inputpdt4, inputpdt5, inputpdt6, inputpdt7,
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
			ProfessionalDevelopmentProgrammes other = (ProfessionalDevelopmentProgrammes) obj;
			return Objects.equals(criteriaId, other.criteriaId) && Objects.equals(inputpdt1, other.inputpdt1)
					&& Objects.equals(inputpdt2, other.inputpdt2) && Objects.equals(inputpdt3, other.inputpdt3)
					&& Objects.equals(inputpdt4, other.inputpdt4) && Objects.equals(inputpdt5, other.inputpdt5)
					&& Objects.equals(inputpdt6, other.inputpdt6) && Objects.equals(inputpdt7, other.inputpdt7)
					&& uniqueKey1 == other.uniqueKey1;
		}


		
	    
	  	    
}
